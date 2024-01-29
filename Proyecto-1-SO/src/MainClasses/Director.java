/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package MainClasses;

import MainPackage.App;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erika A. Henández Z.
 */

public class Director extends Thread {
    private int hourlyWage;
    private float accumulatedSalary;
    private final App app = App.getInstance();
    private TelevisionNetwork network;
    private String status;

    public Director(int hourlyWage, TelevisionNetwork network) {
        this.hourlyWage = hourlyWage;
        this.accumulatedSalary = 0;
        this.network = network;
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

                int remainingDays = network.getRemainingDays();

                if (remainingDays == 0) {
                    this.setStatus("Enviando capítulos.");
                    sendChaptersToTV();
                } 
                // Si es un dia diferente al 0 entonces hace sus labores administrativas y supervisa al PM
                else {
                    Random rand = new Random();
                    int randomHour = rand.nextInt(24);
                    System.out.println(randomHour);
                    for (int i = 0; i < 24; i++) {
                        if (i == randomHour) {
                            this.status = "Vigilando PM";
                            checkProjectManager();
                            Thread.sleep(thirtyFiveMinutes);
                            checkProjectManager();
                            // Basta con solo 2 revisadas porque solo puede cambiar 2 veces el status del PM en 1 hora. 
                            Thread.sleep(remainingMinutes);
                        } else {
                            performAdministrativeTasks();
                            Thread.sleep(oneHour);
                        }
                    }
                }

                getPaid();
                System.out.println(this.toString());
                Thread.sleep(dayDuration); // Wait for the next day
            } catch (InterruptedException ex) {
                Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void sendChaptersToTV() {
    try {
        this.setStatus("Enviando capítulos.");
        this.calculateProfit();
        // Esperar un día completo (simulado)
        Thread.sleep(app.getDayDuration());

        // Reiniciar el contador de días restantes, el contador de faltas del Project Manager y los capitulos producidos.
        network.setRemainingDays(network.getDaySet());
        network.getProjectManagerInstance().resetStrikes();
        network.getDrive().resetChapters();
        network.getDrive().resetCost();
        
    } catch (InterruptedException ex) {
        Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    private void performAdministrativeTasks() {
        this.setStatus("Administrando");
    }
    
    private void calculateProfit(){
        int cost = network.getDrive().getCost();
        int earnStandard =+ network.getDrive().getStandarChapters();
        int earnPlotTwist =+ network.getDrive().getPlotTwistChapters();
        if (network.getName() == "Nickelodeon"){
            earnStandard *= 450000;
            earnPlotTwist *=550000;
        } else {
            earnStandard *= 300000;
            earnPlotTwist *=650000;
        }
       int earning = earnStandard + earnPlotTwist;
       int profit = earning - cost;
       network.setEarning(earning);
       network.setProfit(profit);
    }

    private void checkProjectManager() {
        this.status = "Vigilando PM";
        if ("Viendo Anime".equals(network.getProjectManagerInstance().getCurrentState())) {
            network.getProjectManagerInstance().setAccumulatedSalary(
                network.getProjectManagerInstance().getAccumulatedSalary() - 100);
            network.getProjectManagerInstance().addStrike();
        }
    }

    private void getPaid() {
        this.accumulatedSalary += this.hourlyWage * 24;
        network.getDrive().setCost(this.hourlyWage * 24);
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