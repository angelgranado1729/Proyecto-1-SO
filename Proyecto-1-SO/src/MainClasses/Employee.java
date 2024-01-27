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
    private int type;
    private int hourlyWage;
    private float accumulatedSalary;
    private float dailyProgress;
    private float accumulatedProgress;
    private Drive driveRef;
    private Semaphore mutex;
    private int dayDuration;

    public Employee(
            int workerId,
            int type,
            int hourlyWage,
            float daysToFinish,
            Drive driveRef,
            Semaphore mutex,
            int dayDuration
    ) {
        this.workerId = workerId;
        this.type = type;
        this.hourlyWage = hourlyWage;
        this.accumulatedSalary = 0;
        this.dailyProgress = Helpers.calculateDailyProgress(daysToFinish);
        this.accumulatedProgress = 0;
        this.driveRef = driveRef;
        this.dayDuration = dayDuration;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.getPaid();
                this.working();
                sleep(this.dayDuration);
            } catch (InterruptedException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void working() {
        this.accumulatedProgress += this.dailyProgress;

        if (this.getAccumulatedProgress() >= 1) {
            try {
                this.mutex.acquire();
                this.driveRef.uploadFile(type);
                this.mutex.release();
                this.setAccumulatedProgress(0);
            } catch (InterruptedException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void getPaid() {
        this.accumulatedSalary += this.hourlyWage * 24;
    }

    @Override
    public String toString() {
        return "Employee {"
                + "workerId=" + workerId
                + ", type=" + type
                + ", hourlyWage=" + hourlyWage
                + ", accumulatedSalary=" + accumulatedSalary
                + ", dailyProgress=" + dailyProgress
                + ", accumulatedProgress=" + accumulatedProgress
                + ", driveRef=" + (driveRef != null ? "assigned" : "not assigned")
                + ", mutex=" + (mutex != null ? "assigned" : "not assigned")
                + '}';
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

}
