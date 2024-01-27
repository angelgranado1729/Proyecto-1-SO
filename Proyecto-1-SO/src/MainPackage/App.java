/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;

import GUI.Classes.Home;
import MainClasses.Drive;
import MainClasses.Employee;
import FileFunctions.FileFuctions;
import MainClasses.Helpers;
import MainClasses.TelevisionNetwork;
import java.io.File;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Angel Granado & Erika Hernández
 */
public class App {

    private static int dayDuration = 3000;
    private static String selectedPath = "test//params.txt";
    private static File selectedFile = new File(selectedPath);
    private static FileFuctions fileFunctions = new FileFuctions();
    private static String fileData = getFileFunctions().read(getSelectedFile());
    private static Semaphore mutex;
    private TelevisionNetwork cartoonNetwork;
    
    private static App app;
     
     /**
     * Devuelve una instancia única de la aplicación.
     *
     * @return La instancia única de la aplicación.
     */
    public static synchronized App getInstance() {
        if (getApp() == null) {
            setApp(new App());
        }
        return getApp();
    }


    public void start() {
            this.createCartoonNetwork();
            Home home = new Home();
            home.setVisible(true);
    }

    
    public void createCartoonNetwork() {
        // Se obtiene los datos de CartoonNetwork del TXT
        int[] cartoonNetworkValues = fileFunctions.getCartoonNetworkValues(this.fileData);
        
        if (cartoonNetworkValues != null && cartoonNetworkValues.length >= 9) {
            int idWorker = 1;
            
            // Inicialización de arrays de empleados con los tamaños especificados
            Employee[] screenWriters = new Employee[cartoonNetworkValues[0]];
            Employee[] setDesigners = new Employee[cartoonNetworkValues[1]];
            Employee[] characterAnimators = new Employee[cartoonNetworkValues[2]];
            Employee[] voiceActors = new Employee[cartoonNetworkValues[3]];
            Employee[] plotTwistScreenwriters = new Employee[cartoonNetworkValues[4]];
            Employee[] assemblers = new Employee[cartoonNetworkValues[5]];
            Drive cartoonDrive = new Drive(25, 20, 55, 35, 10); // Asumiendo que estos son los tamaños del drive
            int projectManager = 1; 
            int director = 1; 
            int maxEmployees = cartoonNetworkValues[8];
            int remainingDays = 30; 
            int passedDays = 0;
            
            // Llenar los arrays con instancias de empleados
            for (int j = 0; j < screenWriters.length; j++) {
                screenWriters[j] = new Employee(idWorker++, 0, 20, 4, cartoonDrive, mutex, 3000);
            }
            for (int j = 0; j < setDesigners.length; j++) {
                setDesigners[j] = new Employee(idWorker++, 1, 26, 4, cartoonDrive, mutex, 3000);
            }
            for (int j = 0; j < characterAnimators.length; j++) {
                characterAnimators[j] = new Employee(idWorker++, 2, 40, 1, cartoonDrive, mutex, 3000);
            }
            for (int j = 0; j < voiceActors.length; j++) {
                voiceActors[j] = new Employee(idWorker++, 3, 16, 1, cartoonDrive, mutex, 3000);
            }
            for (int j = 0; j < plotTwistScreenwriters.length; j++) {
                plotTwistScreenwriters[j] = new Employee(idWorker++, 4, 34, 2, cartoonDrive, mutex, 3000);
            }
            for (int j = 0; j < assemblers.length; j++) {
                assemblers[j] = new Employee(idWorker++, 5, 50, 2, cartoonDrive, mutex, 3000);
            }
            this.cartoonNetwork = new TelevisionNetwork("Cartoon Network", maxEmployees, screenWriters, setDesigners, characterAnimators, voiceActors, plotTwistScreenwriters, assemblers, projectManager, director, remainingDays, passedDays, cartoonDrive, mutex);
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

    /**
     * @return the selectedFile
     */
    public static File getSelectedFile() {
        return selectedFile;
    }

    /**
     * @param aSelectedFile the selectedFile to set
     */
    public static void setSelectedFile(File aSelectedFile) {
        selectedFile = aSelectedFile;
    }

    /**
     * @return the fileFunctions
     */
    public static FileFuctions getFileFunctions() {
        return fileFunctions;
    }

    /**
     * @param aFileFunctions the fileFunctions to set
     */
    public static void setFileFunctions(FileFuctions aFileFunctions) {
        fileFunctions = aFileFunctions;
    }

    /**
     * @return the cartoonNetwork
     */
    public TelevisionNetwork getCartoonNetwork() {
        return cartoonNetwork;
    }

    /**
     * @param cartoonNetwork the cartoonNetwork to set
     */
    public void setCartoonNetwork(TelevisionNetwork cartoonNetwork) {
        this.cartoonNetwork = cartoonNetwork;
    }

    /**
     * @return the app
     */
    public static App getApp() {
        return app;
    }

    /**
     * @param aApp the app to set
     */
    public static void setApp(App aApp) {
        app = aApp;
    }

    
}
