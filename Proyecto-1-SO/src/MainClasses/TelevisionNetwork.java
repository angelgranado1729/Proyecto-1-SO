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
    private int actualEmployeesQuantity = 0;
    private Employee[] screenwriters;
    private Employee[] setDesigners;
    private Employee[] characterAnimators;
    private Employee[] voiceActors;
    private Employee[] plotTwistScreenwriters;
    private Employee[] Assemblers;
    private int projectManager;
    private ProjectManager projectManagerInstance;
    private int director;
    private Director directorInstance;
    private static Drive drive;
    private Semaphore mutex;
    private float totalCost;
    private float earning;
    private float profit;
    private int daySet = 30;
    private int remainingDays = daySet;

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

    public void start() {
        this.setTotalCost(0);
        this.setEarning(0);
        this.setProfit(0);

        for (int i = 0; i < this.getScreenwriters().length; i++) {
            if(this.getScreenwriters()[i] != null){
                this.getScreenwriters()[i].start();
            }
        }
        for (int i = 0; i < this.getSetDesigners().length; i++) {
            if(this.getSetDesigners()[i] != null){
                this.getSetDesigners()[i].start();
            }
        }
        for (int i = 0; i < this.getCharacterAnimators().length; i++) {
             if(this.getCharacterAnimators()[i] != null){
                this.getCharacterAnimators()[i].start();
             }
        }
        for (int i = 0; i < this.getVoiceActors().length; i++) {
            if(this.getVoiceActors()[i] != null){
                this.getVoiceActors()[i].start();
            }
        }
        for (int i = 0; i < this.getPlotTwistScreenwriters().length; i++) {
            if(this.getPlotTwistScreenwriters()[i] != null){
                this.getPlotTwistScreenwriters()[i].start();
            }
        }
        for (int i = 0; i < this.getAssemblers().length; i++) {
            if(this.getAssemblers()[i] != null){
                this.getAssemblers()[i].start();
            }
        }
       this.getProjectManagerInstance().start();
       this.getDirectorInstance().start();

    }

    public void actualEmployeesQuantity() {
    int totalEmployees = 0;

    // Contar empleados no nulos en cada arreglo
    totalEmployees += countNonNull(screenwriters);
    totalEmployees += countNonNull(setDesigners);
    totalEmployees += countNonNull(characterAnimators);
    totalEmployees += countNonNull(voiceActors);
    totalEmployees += countNonNull(plotTwistScreenwriters);

    this.setActualEmployeesQuantity(totalEmployees);
}

    // Método auxiliar para contar los elementos no nulos en un arreglo de Employee
    private int countNonNull(Employee[] employees) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                count++;
            }
        }
        return count;
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

    /**
     * @return the projectManagerInstance
     */
    public ProjectManager getProjectManagerInstance() {
        return projectManagerInstance;
    }

    /**
     * @param projectManagerInstance the projectManagerInstance to set
     */
    public void setProjectManagerInstance(ProjectManager projectManagerInstance) {
        this.projectManagerInstance = projectManagerInstance;
    }

    /**
     * @return the daySet
     */
    public int getDaySet() {
        return daySet;
    }

    /**
     * @param daySet the daySet to set
     */
    public void setDaySet(int daySet) {
        this.daySet = daySet;
    }

    /**
     * @return the remainingDays
     */
    public int getRemainingDays() {
        return remainingDays;
    }

    /**
     * @param remainingDays the remainingDays to set
     */
    public void setRemainingDays(int remainingDays) {
        this.remainingDays = remainingDays;
    }

    /**
     * @return the directorInstance
     */
    public Director getDirectorInstance() {
        return directorInstance;
    }

    /**
     * @param directorInstance the directorInstance to set
     */
    public void setDirectorInstance(Director directorInstance) {
        this.directorInstance = directorInstance;
    }


    
}