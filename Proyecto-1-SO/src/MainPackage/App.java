/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;

import FileFunctions.FileFunctions;
import GUI.Classes.Home;
import MainClasses.Drive;
import MainClasses.Employee;
import MainClasses.Helpers;
import java.util.concurrent.Semaphore;

/**
 *
 * @author angel
 */
public class App {

    private static int dayDuration;
    private static int deadline;
    private static final Semaphore mutex = new Semaphore(1);
    private static Drive drive = new Drive(25, 20, 55, 35, 10);

    // Es un array tal que en 0 esta un array con los arrays de los trabajadores de Nickelodeon, y en 1 los de Cartoon Network
    // Es decir workers[0][1] es la lista de Set designers de Nickelodeon, mientras que workers[1][0] es el array de los Screenwriters
    // de Cartoon Network
    private static Employee[][][] workers;
    private static Employee[][] proyectManagers;
    private static Employee[][] directors;

    private static String selectedPath = "test\\params.txt";

    public void start() {
        FileFunctions fileFunctions = new FileFunctions(getSelectedPath());
        //Cargamos los parametros iniciales
        fileFunctions.loadParameters();

        Home home = new Home();
        home.setVisible(true);
    }

    /**
     * Devuelve la lista de los empleados de una empresa.
     *
     * @param company, nombre de la empresa (nickelodeon o cartoon network)
     * @param type, tipo de empleado a obtener
     * @return Un array con los empleados
     */
    public static Employee[] getEmployees(String company, String type) {
        int numCompany = company.equalsIgnoreCase("nickelodeon") ? 0 : 1;
        for (int i = 0; i < Helpers.workesType.length; i++) {
            if (Helpers.workesType[i].equalsIgnoreCase(type)) {
                return getWorkers()[numCompany][i];
            }
        }
        return null;
    }

    /**
     * Actualiza la lista de empleados de una empresa.
     *
     * @param company, el nombre de la empresa (nickelodeon o cartoon network)
     * @param type, lista de empleados a modificar
     * @param newEmployees, la nueva lista de empleados
     */
    public static void setEmployees(String company, String type, Employee[] newEmployees) {
        int numCompany = company.equalsIgnoreCase("nickelodeon") ? 0 : 1;
        for (int i = 0; i < Helpers.workesType.length; i++) {
            if (Helpers.workesType[i].equalsIgnoreCase(type)) {
                getWorkers()[numCompany][i] = newEmployees;
            }
        }
    }

    /**
     * @return the dayDuration
     */
    public static int getDayDuration() {
        return dayDuration;
    }

    /**
     * @param aDayDuration the dayDuration to set
     */
    public static void setDayDuration(int aDayDuration) {
        dayDuration = aDayDuration;
    }

    /**
     * @return the deadline
     */
    public static int getDeadline() {
        return deadline;
    }

    /**
     * @param aDeadline the deadline to set
     */
    public static void setDeadline(int aDeadline) {
        deadline = aDeadline;
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
    public static Semaphore getMutex() {
        return mutex;
    }

    /**
     * @return the workers
     */
    public static Employee[][][] getWorkers() {
        return workers;
    }

    /**
     * @param aWorkers the workers to set
     */
    public static void setWorkers(Employee[][][] aWorkers) {
        workers = aWorkers;
    }

    /**
     * @return the proyectManagers
     */
    public static Employee[][] getProyectManagers() {
        return proyectManagers;
    }

    /**
     * @param aProyectManagers the proyectManagers to set
     */
    public static void setProyectManagers(Employee[][] aProyectManagers) {
        proyectManagers = aProyectManagers;
    }

    /**
     * @return the directors
     */
    public static Employee[][] getDirectors() {
        return directors;
    }

    /**
     * @param aDirectors the directors to set
     */
    public static void setDirectors(Employee[][] aDirectors) {
        directors = aDirectors;
    }

    /**
     * @return the selectedPath
     */
    public static String getSelectedPath() {
        return selectedPath;
    }

    /**
     * @param aSelectedPath the selectedPath to set
     */
    public static void setSelectedPath(String aSelectedPath) {
        selectedPath = aSelectedPath;
    }  
}
