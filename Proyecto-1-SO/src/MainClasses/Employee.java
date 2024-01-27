/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

import MainPackage.App;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class Employee extends Thread {

    private int workerId;
    private int company;
    private int type;
    private int hourlyWage;
    private float accumulatedSalary;
    private float dailyProgress;
    private float accumulatedProgress;
    private Drive driveRef;
    private Semaphore mutex;
    private int dayDuration;
    private int daysToFinish;

    public Employee(
            int workerId,
            int company,
            int type,
            int hourlyWage,
            int daysToFinish,
            Drive driveRef,
            Semaphore mutex
    ) {
        this.workerId = workerId;
        this.company = company;
        this.type = type;
        this.hourlyWage = hourlyWage;
        this.accumulatedSalary = 0;
        this.daysToFinish = daysToFinish;
        this.dailyProgress = 1.0f/daysToFinish;
        this.accumulatedProgress = 0f;
        this.driveRef = driveRef;
        this.mutex = mutex;
        this.dayDuration = App.getDayDuration();
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.getPaid();
                this.working();
                System.out.println(this.toString());
                sleep(this.getDayDuration());
            } catch (InterruptedException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void working() {
        this.setAccumulatedProgress(this.getAccumulatedProgress() + (this.getDailyProgress()));

        if (this.getAccumulatedProgress() >= 1) {
            try {
                this.getMutex().acquire();
                this.getDriveRef().uploadFile(getType());
                this.getMutex().release();
                this.setAccumulatedProgress(0);
            } catch (InterruptedException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void getPaid() {
        this.setAccumulatedSalary(this.getAccumulatedSalary() + this.getHourlyWage() * 24);
    }

    @Override
    public String toString() {
        return "Employee { \n"
                + "workerId=" + getWorkerId() + "\n"
                + "Company=" + Helpers.companies[getCompany()] + "\n"
                + "type=" + Helpers.workesType[getType()] + "\n"
                + "hourlyWage=" + getHourlyWage() + "\n"
                + "accumulatedSalary=" + getAccumulatedSalary() + "\n"
                + "Days to finish work=" + getDaysToFinish() + "\n"
                + "dailyProgress=" + getDailyProgress() + "\n"
                + "accumulatedProgress=" + getAccumulatedProgress() + "\n"
                + "driveRef=" + (getDriveRef() != null ? "assigned" : "not assigned") + "\n"
                + "mutex=" + (getMutex() != null ? "assigned" : "not assigned") + "\n"
                + '}' + "\n";
    }

    /**
     * @return the workerId
     */
    public int getWorkerId() {
        return workerId;
    }

    /**
     * @param workerId the workerId to set
     */
    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    /**
     * @return the company
     */
    public int getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(int company) {
        this.company = company;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the hourlyWage
     */
    public int getHourlyWage() {
        return hourlyWage;
    }

    /**
     * @param hourlyWage the hourlyWage to set
     */
    public void setHourlyWage(int hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    /**
     * @return the accumulatedSalary
     */
    public float getAccumulatedSalary() {
        return accumulatedSalary;
    }

    /**
     * @param accumulatedSalary the accumulatedSalary to set
     */
    public void setAccumulatedSalary(float accumulatedSalary) {
        this.accumulatedSalary = accumulatedSalary;
    }

    /**
     * @return the dailyProgress
     */
    public float getDailyProgress() {
        return dailyProgress;
    }

    /**
     * @param dailyProgress the dailyProgress to set
     */
    public void setDailyProgress(float dailyProgress) {
        this.dailyProgress = dailyProgress;
    }

    /**
     * @return the accumulatedProgress
     */
    public float getAccumulatedProgress() {
        return accumulatedProgress;
    }

    /**
     * @param accumulatedProgress the accumulatedProgress to set
     */
    public void setAccumulatedProgress(float accumulatedProgress) {
        this.accumulatedProgress = accumulatedProgress;
    }

    /**
     * @return the driveRef
     */
    public Drive getDriveRef() {
        return driveRef;
    }

    /**
     * @param driveRef the driveRef to set
     */
    public void setDriveRef(Drive driveRef) {
        this.driveRef = driveRef;
    }

    /**
     * @return the mutex
     */
    public Semaphore getMutex() {
        return mutex;
    }

    /**
     * @param mutex the mutex to set
     */
    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }

    /**
     * @return the dayDuration
     */
    public int getDayDuration() {
        return dayDuration;
    }

    /**
     * @param dayDuration the dayDuration to set
     */
    public void setDayDuration(int dayDuration) {
        this.dayDuration = dayDuration;
    }

    /**
     * @return the daysToFinish
     */
    public int getDaysToFinish() {
        return daysToFinish;
    }

    /**
     * @param daysToFinish the daysToFinish to set
     */
    public void setDaysToFinish(int daysToFinish) {
        this.daysToFinish = daysToFinish;
    }
  
}
