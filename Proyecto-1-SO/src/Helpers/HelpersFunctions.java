/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

import MainClasses.Employee;
import MainClasses.ProjectManager;
import FileFunctions.FileFunctions;
import Helpers.ImportantConstants;
import MainClasses.Director;
import MainClasses.Drive;
import MainClasses.TelevisionNetwork;
import MainPackage.App;
import java.util.concurrent.Semaphore;

/**
 *
 * @author angel
 */
public class HelpersFunctions {

    public static void loadParams() {
        String fileData = FileFunctions.read(App.getSelectedFile());

        // Se obtiene los datos del TXT
        int[] params = FileFunctions.getGeneralParams(fileData);

        if (params != null && params.length >= 2) {
            App.setDayDuration(params[0]);
            App.setDeadline(params[1]);
        }

        App app = App.getInstance();
        app.setNickelodeon(HelpersFunctions.createTelevisionNetwork(0));
        app.setCartoonNetwork(HelpersFunctions.createTelevisionNetwork(1));

    }

    // NOTE - 0 para nickelodeon y 1 para cartoon network
    public static TelevisionNetwork createTelevisionNetwork(int company) {
        String fileData = FileFunctions.read(App.getSelectedFile());

        // Se obtiene los datos del TXT
        int[] televisionNetworkValues = FileFunctions.getTelevisionNetworkValues(company, fileData);

        if (televisionNetworkValues != null && televisionNetworkValues.length >= 9) {

            String name = ImportantConstants.companies[company];
            Employee[][] workers = new Employee[6][];
            Semaphore mutex = new Semaphore(1);
            // REVIEW - Revisar los tama;os de las secciones del Drive
            Drive drive = new Drive(25, 20, 55, 35, 10);
            int projectManager = 1;
            int director = 1;
            int maxEmployees = televisionNetworkValues[8];

            // Se crean los empleados de cada sección
            for (int type = 0; type <= 5; type++) {
                Employee[] employees = new Employee[televisionNetworkValues[type]];

                for (int j = 0; j < employees.length; j++) {
                    int workerId = j + 1;
                    int daysToFinish = ImportantConstants.productionTimes[company][type][1];
                    int numOfWorkDone = ImportantConstants.productionTimes[company][type][0];
                    int hourlyWage = ImportantConstants.hourlyWages[type];

                    employees[j] = new Employee(company, workerId, type, daysToFinish, numOfWorkDone, hourlyWage,
                            drive, mutex);

                }
                workers[type] = employees;
            }
            TelevisionNetwork network = new TelevisionNetwork(name, maxEmployees, workers[0], workers[1], workers[2], workers[3], workers[4],
            workers[5], projectManager, director, drive, mutex);
            
            // Se crea al projectManager y al director, se les pasa la cadena televisiva. 
            ProjectManager projectManagerInstance = new ProjectManager(40, network);
            Director directorInstance = new Director(60, network);
            network.setProjectManagerInstance(projectManagerInstance);
            network.setDirectorInstance(directorInstance);
            
            return network;

        }
        return null;
    }

}
