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

    // 0 si es Nickelodeon & 1 si es Cartoon Network (REVISAR LA CLASE IMPORTANT
    // CONSTANTS)
    int company;
    private int workerId;
    private int type;
    private int daysToFinish;
    private int numOfWorkDone;
    App app = App.getInstance();
    private Drive driveRef;
    Semaphore mutex;

    int hourlyWage;
    float accumulatedSalary;
    private float dailyProgress;
    private float totalWork;
    private int plotTwistCounter = 0;

    public Employee(int company, int workerId, int type, int daysToFinish, int numOfWorkDone, int hourlyWage,
            Drive driveRef, Semaphore mutex) {
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
        while (!Thread.interrupted()) {
            try {
                this.getPaid();
                if (this.type == 5) {
                    this.assembleChapters();
                } else {
                    this.working();
                }
                sleep(App.getDayDuration());
                System.out.println(this.toString());
            } catch (InterruptedException ex) {
                // Interrupción manejada, preparándose para terminar el hilo
                Logger.getLogger(Employee.class.getName()).log(Level.INFO, "Hilo de Employee interrumpido, terminando...");
                break; 
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
    
     private void assembleChapters() {
        try {
              this.getMutex().acquire();
              this.evaluateAssemble();
              this.getMutex().release();
            } catch (InterruptedException ex) {
              Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
     }

    private void evaluateAssemble() {
        int screenwriters = this.getDriveRef().getSections()[0];
        int scenarists = this.getDriveRef().getSections()[1];
        int animators = this.getDriveRef().getSections()[2];
        int voiceActors = this.getDriveRef().getSections()[3];
        int plotTwistWriters = this.getDriveRef().getSections()[4];

        if (this.company == 0) {
            // Lógica para Nickelodeon
            if (screenwriters >= 2 && scenarists >= 1 && animators >= 4 && voiceActors >= 4) {
                assembleChapter(new int[] {2, 1, 4, 4}, 5, 2, this.app.getNickelodeon());
            }
        } else if (this.company == 1) {
            // Lógica para Cartoon Network
            if (screenwriters >= 1 && scenarists >= 2 && animators >= 6 && voiceActors >= 5) {
                assembleChapter(new int[] {1, 2, 6, 5}, 3, 1, this.app.getCartoonNetwork());
            }
        } else {
            try {
              sleep(app.getDayDuration());
            } catch (InterruptedException ex) {
              Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        this.getMutex().release();
    }

    private void assembleChapter(int[] resources, int plotTwistFrequency, int plotTwistRequirement, TelevisionNetwork network) {
        // Se descuenta el recurso (parte de episodios estándar
        for (int i = 0; i < resources.length; i++) {
            this.getDriveRef().decrementSection(i, resources[i]);
        }

        // Verificar y ensamblar capítulo con PlotTwist
        if (plotTwistCounter == plotTwistFrequency && this.getDriveRef().getSections()[4] >= plotTwistRequirement) {
            // Descontar recursos adicionales para capítulo con PlotTwist
            this.getDriveRef().decrementSection(4, plotTwistRequirement);
            this.getDriveRef().increasePlotTwistChapters();

            // Resetear el contador
            plotTwistCounter = 0;
        } else {
            this.getDriveRef().increaseStandarChapters();
            // Incrementar el contador después de crear un capítulo estándar
            plotTwistCounter++;
        }

        try {
            sleep(app.getDayDuration() * 2);
        } catch (InterruptedException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


     
    private void getPaid() {
        this.setAccumulatedSalary(this.getAccumulatedSalary() + this.getHourlyWage() * 24);
         if (this.company == 0 ) {
            app.getNickelodeon().increaseTotalCost(this.getHourlyWage() * 24);
        } else {
          app.getCartoonNetwork().increaseTotalCost(this.getHourlyWage() * 24);
        }
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

    // Getters and Setters
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
