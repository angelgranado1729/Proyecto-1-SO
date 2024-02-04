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
 * @author Erika A. Henández Z.
 */
public class ProjectManager extends Employee {

    private String currentState;
    private int strikes;

    public ProjectManager(int company, int workerId, int type, int daysToFinish, int numOfWorkDone, int hourlyWage, Drive driveRef, Semaphore mutex) {
        super(company, workerId, type, daysToFinish, numOfWorkDone, hourlyWage, driveRef, mutex);
        this.currentState = "Inactivo";
        this.strikes = 0;
    }

    @Override
    public void run() {
        while (true) {
            try {
                //Se obtiene la duración del día total directo de la variable de app.
                int dayDuration = App.getDayDuration();

                // Duración de una hora en la simulación
                int oneHour = dayDuration / 24;

                // Se sabe que pasa 16 horas alterando ver anime y trabajar cada 30 mins.
                // Por lo tanto se loopea cada 30 mins (32 intervalos de 30 mins) para las primeras 16 h. 
                for (int i = 0; i < 32; i++) {
                    if (i % 2 == 0) {
                        this.setCurrentState("Viendo Anime");

                    } else {
                        setCurrentState("Trabajando");

                    }
                    // Duerme por la mitad de una hora de simulación
                    Thread.sleep(oneHour / 2);
                }
                // La segunda parte del día traba para actualizar 1 vez el contador
                // Porque se actualiza 1 vez por día el dayCounter
                setCurrentState("Trabajando");
                Thread.sleep(oneHour * 8);

                // Culminado el día cobra su salario
                this.getPaid();

                if (this.company == 0) {
                    app.getNickelodeon().setTotalDays(app.getNickelodeon().getTotalDays() + 1);
                } else {
                    app.getCartoonNetwork().setTotalDays(app.getCartoonNetwork().getTotalDays() + 1);
                }
                this.updateCountdown();

            } catch (InterruptedException ex) {
                Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void updateCountdown() {
        // Lógica para actualizar el contador de días restantes
        if (this.company == 0) {
            if (app.getNickelodeon().getRemainingDays() != 0) {
                app.getNickelodeon().decreaceRemainingDays();
            }
        } else {
            if (app.getCartoonNetwork().getRemainingDays() != 0) {
                app.getCartoonNetwork().decreaceRemainingDays();
            }
        }
    }

    private void getPaid() {
        // Asumiendo que el Project Manager trabaja las 24 horas del día, incluyendo ver anime.
        this.setAccumulatedSalary(this.getAccumulatedSalary() + this.getHourlyWage() * 24);
        if (this.company == 0) {
            app.getNickelodeon().increaseTotalCost(this.getHourlyWage() * 24);
            app.getNickelodeon().setProfit(app.getNickelodeon().getProfit() - (this.hourlyWage * 24));
        } else {
            app.getCartoonNetwork().increaseTotalCost(this.getHourlyWage() * 24);
            app.getCartoonNetwork().setProfit(app.getCartoonNetwork().getProfit() - (this.hourlyWage * 24));
        }
    }

    @Override
    public String toString() {
        // Retorna información relevante sobre el Project Manager
        return "Project Manager [Salario acumulado del project Manager=" + this.getAccumulatedSalary() + "]";
    }

    /**
     * @return the currentState
     */
    public String getCurrentState() {
        return currentState;
    }

    /**
     * @param currentState the currentState to set
     */
    public void setCurrentState(String currentState) {
        this.currentState = currentState;
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
     * @return the app
     */
    public App getApp() {
        return app;
    }

    /**
     * @param app the app to set
     */
    public void setApp(App app) {
        this.app = app;
    }

    /**
     * @return the strikes
     */
    public int getStrikes() {
        return strikes;
    }

    /**
     * @param strikes the strikes to set
     */
    public void setStrikes(int strikes) {
        this.strikes = strikes;
    }

    /**
     * @param strikes the strikes to set
     */
    public void addStrike() {
        this.strikes++;
    }

    public void resetStrikes() {
        this.strikes = 0;
    }
}
