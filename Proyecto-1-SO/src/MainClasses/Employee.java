/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

import Helpers.ImportantConstants;
import MainPackage.App;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class Employee extends Thread {

//    0 si es Nickelodeon & 1 si es Cartoon Network (REVISAR LA CLASE IMPORTANT CONSTANTS)
    private int company;
    private int workerId;
    private int type;
    private int daysToFinish;
    private int numOfWorkDone;
    private Drive driveRef;
    private Semaphore mutex;

    private int hourlyWage;
    private float accumulatedSalary;
    private float dailyProgress;
    private float totalWork;

    public Employee(int company, int workerId, int type, int daysToFinish, int numOfWorkDone, int hourlyWage, Drive driveRef, Semaphore mutex) {
        this.company = company;
        this.workerId = workerId;
        this.type = type;
        this.daysToFinish = daysToFinish;
        this.numOfWorkDone = numOfWorkDone;
        this.driveRef = driveRef;
        this.mutex = mutex;

        this.hourlyWage = ImportantConstants.hourlyWages[type];
        this.accumulatedSalary = 0;
        // Cantidad de trabajo realizado por dia        
        this.dailyProgress = (float) numOfWorkDone / daysToFinish;
        this.totalWork = 0;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.getPaid();
                this.working();
                sleep(App.getDayDuration());
            } catch (InterruptedException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void working() {
        this.setTotalWork(this.getTotalWork() + this.getDailyProgress());

        if (getTotalWork() >= 1) {
            try {
                int workToUpload = (int) Math.floor(this.getTotalWork());
                this.getMutex().acquire();
                this.getDriveRef().uploadFile(getType(), workToUpload);
                this.getMutex().release();
                this.setTotalWork(this.getTotalWork() - workToUpload);
            } catch (InterruptedException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void getPaid() {
        this.setAccumulatedSalary(this.getAccumulatedSalary() + this.getHourlyWage() * 24);
    }

    @Override
    public String toString() {
        return """
               Employee {
               """ + "-Company= " + ImportantConstants.companies[getCompany()] + "\n"
                + "-workerId= " + getWorkerId() + "\n"
                + "-type= " + ImportantConstants.workesType[getType()] + "\n"
                + "-Days to Finish his part= " + getDaysToFinish() + "\n"
                + "- Num of work done per days= " + getNumOfWorkDone() + "\n"
                + "-hourlyWage= " + getHourlyWage() + "\n"
                + "-accumulatedSalary= " + getAccumulatedSalary() + "\n"
                + "-dailyProgress= " + getDailyProgress() + "\n"
                + "-Total Work= " + getTotalWork() + "\n"
                + "-driveRef= " + (getDriveRef() != null ? "assigned" : "not assigned") + "\n"
                + "-mutex= " + (getMutex() != null ? "assigned" : "not assigned") + "\n"
                + "\n}";
    }

    //    Getters and Setters
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

    /**
     * @return the numOfWorkDone
     */
    public int getNumOfWorkDone() {
        return numOfWorkDone;
    }

    /**
     * @param numOfWorkDone the numOfWorkDone to set
     */
    public void setNumOfWorkDone(int numOfWorkDone) {
        this.numOfWorkDone = numOfWorkDone;
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
     * @return the totalWork
     */
    public float getTotalWork() {
        return totalWork;
    }

    /**
     * @param totalWork the totalWork to set
     */
    public void setTotalWork(float totalWork) {
        this.totalWork = totalWork;
    }

}
