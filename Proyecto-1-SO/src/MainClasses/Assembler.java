/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class Assembler extends Employee {
    
    public Assembler(int workerId, int company, int type, int hourlyWage, int daysToFinish, Drive driveRef, Semaphore mutex) {
        super(workerId, company, type, hourlyWage, daysToFinish, driveRef, mutex);
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
    
    
    @Override
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
    
}
