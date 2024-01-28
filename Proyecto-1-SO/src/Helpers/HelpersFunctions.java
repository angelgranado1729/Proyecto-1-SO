/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

import MainClasses.Employee;
import FileFunctions.FileFunctions;
import Helpers.ImportantConstants;
import MainClasses.Drive;
import MainClasses.TelevisionNetwork;
import MainPackage.App;
import java.util.concurrent.Semaphore;

/**
 *
 * @author angel
 */
public class HelpersFunctions {

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

                    System.out.println(employees[j].toString());

                }
                workers[type] = employees;
            }
            return new TelevisionNetwork(name, maxEmployees, workers[0], workers[1], workers[2], workers[3], workers[4],
                    workers[5], projectManager, director, drive, mutex);

        }
        return null;
    }

}
