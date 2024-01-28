/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Erika A. Hernández Z.
 */
public class TelevisionNetwork {

    private String name;
    private int maxEmployeesQuantity;
    private int actualEmployeesQuantity;
    private Employee[] screenwriters;
    private Employee[] setDesigners;
    private Employee[] characterAnimators;
    private Employee[] voiceActors;
    private Employee[] plotTwistScreenwriters;
    private Employee[] Assemblers;
    private int projectManager;
    private int director;
    private static Drive drive;
    private Semaphore mutex;
    private float totalCost;
    private float earning;
    private float profit;

    // CONSTRUCTOR

    public TelevisionNetwork(String name, int maxEmployeesQuantity, Employee[] screenwriters, Employee[] setDesigners,
            Employee[] characterAnimators, Employee[] voiceActors, Employee[] plotTwistScreenwriters,
            Employee[] Assemblers, int projectManager, int director, Drive drive, Semaphore mutex) {
        this.name = name;
        this.maxEmployeesQuantity = maxEmployeesQuantity;
        this.screenwriters = screenwriters;
        this.setDesigners = setDesigners;
        this.characterAnimators = characterAnimators;
        this.voiceActors = voiceActors;
        this.plotTwistScreenwriters = plotTwistScreenwriters;
        this.Assemblers = Assemblers;
        this.projectManager = projectManager;
        this.director = director;
        this.drive = drive;
        this.mutex = mutex;
        this.actualEmployeesQuantity();
    }

    public void actualEmployeesQuantity() {
        this.setActualEmployeesQuantity(screenwriters.length + setDesigners.length + characterAnimators.length
                + characterAnimators.length + voiceActors.length + plotTwistScreenwriters.length);
    }

    public TelevisionNetwork(String name, int maxEmployeesQuantity) {
        this.name = name;
        this.maxEmployeesQuantity = maxEmployeesQuantity;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the maxEmployeesQuantity
     */
    public int getMaxEmployeesQuantity() {
        return maxEmployeesQuantity;
    }

    /**
     * @param maxEmployeesQuantity the maxEmployeesQuantity to set
     */
    public void setMaxEmployeesQuantity(int maxEmployeesQuantity) {
        this.maxEmployeesQuantity = maxEmployeesQuantity;
    }

    /**
     * @return the screenwriters
     */
    public Employee[] getScreenwriters() {
        return screenwriters;
    }

    /**
     * @param screenwriters the screenwriters to set
     */
    public void setScreenwriters(Employee[] screenwriters) {
        this.screenwriters = screenwriters;
    }

    /**
     * @return the setDesigners
     */
    public Employee[] getSetDesigners() {
        return setDesigners;
    }

    /**
     * @param setDesigners the setDesigners to set
     */
    public void setSetDesigners(Employee[] setDesigners) {
        this.setDesigners = setDesigners;
    }

    /**
     * @return the characterAnimators
     */
    public Employee[] getCharacterAnimators() {
        return characterAnimators;
    }

    /**
     * @param characterAnimators the characterAnimators to set
     */
    public void setCharacterAnimators(Employee[] characterAnimators) {
        this.characterAnimators = characterAnimators;
    }

    /**
     * @return the voiceActors
     */
    public Employee[] getVoiceActors() {
        return voiceActors;
    }

    /**
     * @param voiceActors the voiceActors to set
     */
    public void setVoiceActors(Employee[] voiceActors) {
        this.voiceActors = voiceActors;
    }

    /**
     * @return the plotTwistScreenwriters
     */
    public Employee[] getPlotTwistScreenwriters() {
        return plotTwistScreenwriters;
    }

    /**
     * @param plotTwistScreenwriters the plotTwistScreenwriters to set
     */
    public void setPlotTwistScreenwriters(Employee[] plotTwistScreenwriters) {
        this.plotTwistScreenwriters = plotTwistScreenwriters;
    }

    /**
     * @return the Assemblers
     */
    public Employee[] getAssemblers() {
        return Assemblers;
    }

    /**
     * @param Assemblers the Assemblers to set
     */
    public void setAssemblers(Employee[] Assemblers) {
        this.Assemblers = Assemblers;
    }

    /**
     * @return the projectManager
     */
    public int getProjectManager() {
        return projectManager;
    }

    /**
     * @param projectManager the projectManager to set
     */
    public void setProjectManager(int projectManager) {
        this.projectManager = projectManager;
    }

    /**
     * @return the director
     */
    public int getDirector() {
        return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(int director) {
        this.director = director;
    }

    /**
     * @return the drive
     */
    public static Drive getDrive() {
        return drive;
    }

    /**
     * @param aDrive the drive to set
     */
    public static void setDrive(Drive aDrive) {
        drive = aDrive;
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
     * @return the totalCost
     */
    public float getTotalCost() {
        return totalCost;
    }

    /**
     * @param totalCost the totalCost to set
     */
    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * @return the earning
     */
    public float getEarning() {
        return earning;
    }

    /**
     * @param earning the earning to set
     */
    public void setEarning(float earning) {
        this.earning = earning;
    }

    /**
     * @return the profit
     */
    public float getProfit() {
        return profit;
    }

    /**
     * @param profit the profit to set
     */
    public void setProfit(float profit) {
        this.profit = profit;
    }

    /**
     * @return the actualEmployeesQuantity
     */
    public int getActualEmployeesQuantity() {
        return actualEmployeesQuantity;
    }

    /**
     * @param actualEmployeesQuantity the actualEmployeesQuantity to set
     */
    public void setActualEmployeesQuantity(int actualEmployeesQuantity) {
        this.actualEmployeesQuantity = actualEmployeesQuantity;
    }

}