/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

import Helpers.ImportantConstants;
import MainPackage.App;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erika A. Henández Z.
 */
public class Director extends Employee {

    private String status;
    private App app = App.getInstance();

    public Director(int company, int workerId, int type, int daysToFinish, int numOfWorkDone, int hourlyWage,
            Drive driveRef, Semaphore mutex) {
        super(company, workerId, type, daysToFinish, numOfWorkDone, hourlyWage, driveRef, mutex);
        this.status = "Inactivo";
    }

    @Override
    public void run() {
        while (true) {
            try {
                int dayDuration = app.getDayDuration();
                int oneHour = dayDuration / 24;
                // Se determina cuanto son 35 minutos.
                int thirtyFiveMinutes = (int) (oneHour * (35.0 / 60.0));
                int remainingMinutes = oneHour - thirtyFiveMinutes;

                // Se buscan los días restantes.
                int remainingDays = this.company == 0 ? app.getNickelodeon().getRemainingDays()
                        : app.getCartoonNetwork().getRemainingDays();

                if (remainingDays <= 0) {
                    this.setStatus("Enviando capítulos");
                    sendChaptersToTV();
                } // Si es un dia diferente al 0 entonces hace sus labores administrativas y
                // supervisa al PM
                else {
                    Random rand = new Random();
                    int randomHour = rand.nextInt(24);

                    for (int i = 0; i < 24; i++) {
                        if (i == randomHour) {
                            this.status = "Vigilando PM";
                            checkProjectManager();
                            Thread.sleep(thirtyFiveMinutes);
                            checkProjectManager();
                            // Basta con solo 2 revisadas porque solo puede cambiar 2 veces el status del PM
                            // en 1 hora.
                            Thread.sleep(remainingMinutes);
                        } else {
                            performAdministrativeTasks();
                            Thread.sleep(oneHour);
                        }
                    }
                }

                getPaid();
                Thread.sleep(dayDuration);
            } catch (InterruptedException ex) {
                Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void resetDeadline(TelevisionNetwork tv) {
        tv.setRemainingDays(app.getDeadline());
    }

    private void sendChaptersToTV() {
        try {
            this.setStatus("Enviando capítulos");

            // Esperar un día completo (simulado)
            Thread.sleep(app.getDayDuration());
            // Reiniciar el contador de días restantes
            if (this.company == 0) {
                calculateProfit(app.getNickelodeon());
                app.getNickelodeon().getDrive().resetChapters();
                app.getNickelodeon().setLastNumChaptersWithPlotTwist(
                        app.getNickelodeon().getActualNumChaptersWithPlotTwist());
                app.getNickelodeon().setLastNumNormalChapters(
                        app.getNickelodeon().getActualNumNormalChapters()
                );
                app.getNickelodeon().setActualNumNormalChapters(0);
                app.getNickelodeon().setLastOpsCost(app.getNickelodeon().getTotalCost()
                        - app.getNickelodeon().getLastOpsCost());
                calculateBatchLastProfit(app.getNickelodeon());
                resetDeadline(app.getNickelodeon());

            } else {
                calculateProfit(app.getCartoonNetwork());
                app.getCartoonNetwork().getDrive().resetChapters();
                app.getCartoonNetwork().setLastNumChaptersWithPlotTwist(
                        app.getCartoonNetwork().getActualNumChaptersWithPlotTwist());
                app.getCartoonNetwork().setLastNumNormalChapters(
                        app.getCartoonNetwork().getActualNumNormalChapters()
                );
                app.getCartoonNetwork().setActualNumChaptersWithPlotTwist(0);
                app.getCartoonNetwork().setActualNumNormalChapters(0);
                app.getCartoonNetwork().setLastOpsCost(app.getCartoonNetwork().getTotalCost()
                        - app.getCartoonNetwork().getLastOpsCost());
                calculateBatchLastProfit(app.getCartoonNetwork());
                resetDeadline(app.getCartoonNetwork());
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void calculateBatchLastProfit(TelevisionNetwork tv) {
        float profit = (tv.getLastNumNormalChapters()
                * ImportantConstants.profitPerChapter[this.company][0])
                + (tv.getNumChaptersWithPlotTwist()
                * ImportantConstants.profitPerChapter[this.company][1])
                - (tv.getLastOpsCost());

        tv.setBatchLastProfit(profit);
    }

    private void performAdministrativeTasks() {
        this.setStatus("Administrando");
    }

    private void calculateProfit(TelevisionNetwork tv) {
        float totalCost = tv.getTotalCost();
        float earning = (tv.getNumNormalChapters() * ImportantConstants.profitPerChapter[this.company][0])
                + (tv.getNumChaptersWithPlotTwist() * ImportantConstants.profitPerChapter[this.company][1]);
        float profit = earning - totalCost;

        tv.setEarning(earning);
        tv.setProfit(profit);
    }

    private void checkProjectManager() {
        this.status = "Vigilando PM";
        if (this.company == 0) {
            if ("Viendo Anime".equals(app.getNickelodeon().getProjectManagerInstance().getCurrentState())) {
                app.getNickelodeon().getProjectManagerInstance().setAccumulatedSalary(
                        app.getNickelodeon().getProjectManagerInstance().getAccumulatedSalary() - 100);
                app.getNickelodeon().getProjectManagerInstance().addStrike();
            }
        } else {
            if ("Viendo Anime".equals(app.getCartoonNetwork().getProjectManagerInstance().getCurrentState())) {
                app.getCartoonNetwork().getProjectManagerInstance().setAccumulatedSalary(
                        app.getCartoonNetwork().getProjectManagerInstance().getAccumulatedSalary() - 100);
                app.getCartoonNetwork().getProjectManagerInstance().addStrike();
            }

        }

    }

    private void getPaid() {
        this.accumulatedSalary += this.hourlyWage * 24;
        if (this.company == 0) {
            app.getNickelodeon().increaseTotalCost(this.hourlyWage * 24);
            app.getNickelodeon().setProfit(app.getNickelodeon().getProfit() - (this.hourlyWage * 24));
        } else {
            app.getCartoonNetwork().increaseTotalCost(this.hourlyWage * 24);
            app.getCartoonNetwork().setProfit(app.getCartoonNetwork().getProfit() - (this.hourlyWage * 24));
        }
    }

    @Override
    public String toString() {
        return "Director [Salario acumulado=" + this.accumulatedSalary + ", Estado actual=" + this.getStatus() + "]";
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
