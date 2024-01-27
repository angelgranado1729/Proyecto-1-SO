/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileFunctions;

import MainClasses.Drive;
import MainClasses.Employee;
import MainClasses.Helpers;
import MainPackage.App;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.concurrent.Semaphore;

/**
 *
 * @author angel
 */
public class FileFunctions {

    private static int dayDuration = 0;
    private static int deadline = 0;
    private static int[] maxWorkers = new int[2];

    private static int[][] daysToFinishWork = new int[2][6];

    private static int[] nickelodeonWorkers = new int[6];

    private static int[] cartoonNetworkWorkers = new int[6];

    private static String path;
    private static File selectedFile;

    public FileFunctions(String path) {
        FileFunctions.path = path;
        FileFunctions.selectedFile = new File(path);
    }

    public void readParameters() {

        try (BufferedReader br = new BufferedReader(new FileReader(FileFunctions.getSelectedFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Day duration")) {
                    setDayDuration(extractValue(line));
                } else if (line.startsWith("Deadline")) {
                    setDeadline(extractValue(line));
                } else if (line.startsWith("Nickelodeon workers")) {
                    line = br.readLine();
                    for (int i = 0; i < getNickelodeonWorkers().length; i++) {
                        line = br.readLine();
                        getNickelodeonWorkers()[i] = extractValue(line);
                    }
                } else if (line.startsWith("Maximum number of Nickelodeon workers")) {
                    line = br.readLine();
                    line = br.readLine();
                    getMaxWorkers()[0] = extractValue(line);
                } else if (line.startsWith("Days to finish work for Nickelodeon workers")) {
                    line = br.readLine();
                    for (int i = 0; i < getDaysToFinishWork()[0].length; i++) {
                        line = br.readLine();
                        getDaysToFinishWork()[0][i] = extractValue(line);
                    }
                } else if (line.startsWith("Cartoon Network workers")) {
                    line = br.readLine();
                    for (int i = 0; i < getCartoonNetworkWorkers().length; i++) {
                        line = br.readLine();
                        getCartoonNetworkWorkers()[i] = extractValue(line);
                    }
                } else if (line.startsWith("Maximum number of Cartoon Network workers")) {
                    line = br.readLine();
                    line = br.readLine();
                    getMaxWorkers()[1] = extractValue(line);
                } else if (line.startsWith("Days to finish work for Cartoon Network workers")) {
                    line = br.readLine();
                    for (int i = 0; i < getDaysToFinishWork()[1].length; i++) {
                        line = br.readLine();
                        getDaysToFinishWork()[1][i] = extractValue(line);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int extractValue(String line) {
        String numberPart = line.replaceAll(" ", "").replaceAll(",", "").split("=")[1];
        return Integer.parseInt(numberPart);
    }

    public void loadParameters() {
        readParameters();
        App.setDayDuration(getDayDuration());
        App.setDeadline(getDeadline());
        Employee[][][] employees = new Employee[2][8][];

        for (int company = 0; company < 2; company++) {
            for (int workerType = 0; workerType < 6; workerType++) {
                employees[company][workerType] = new Employee[getMaxWorkers()[company]];

                int workersToCreate = 0;

                if (company == 0) {
                    workersToCreate = getNickelodeonWorkers()[workerType];
                } else {
                    workersToCreate = getCartoonNetworkWorkers()[workerType];
                }

                for (int workerId = 0; workerId < workersToCreate; workerId++) {

                    int hourlyWage = Helpers.hourlyWages[workerType];
                    int daysToFinish = getDaysToFinishWork()[company][workerType];
                    Drive driveRef = App.getDrive();
                    Semaphore mutex = App.getMutex();

                    employees[company][workerType][workerId] = new Employee(workerId, company, workerType, hourlyWage,
                            daysToFinish, driveRef, mutex);

                    System.out.println(employees[company][workerType][workerId].toString());
                    employees[company][workerType][workerId].start();

                }
            }

            // TODO Terminar esto, probablemente se necesite primero agregar una clase PM y Director

            // for (int specialWorker = 6; specialWorker < 8; specialWorker++) {
            // int hourlyWage = Helpers.hourlyWages[specialWorker];
            // int daysToFinish = 5;
            // Drive driveRef = null;
            // Semaphore mutex = null;
            // employees[company][specialWorker][0] = new Employee(0, specialWorker,
            // hourlyWage, daysToFinish,driveRef, mutex);
            // }
        }
        App.setWorkers(employees);
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
     * @return the maxWorkers
     */
    public static int[] getMaxWorkers() {
        return maxWorkers;
    }

    /**
     * @param aMaxWorkers the maxWorkers to set
     */
    public static void setMaxWorkers(int[] aMaxWorkers) {
        maxWorkers = aMaxWorkers;
    }

    /**
     * @return the nickelodeonWorkers
     */
    public static int[] getNickelodeonWorkers() {
        return nickelodeonWorkers;
    }

    /**
     * @param aNickelodeonWorkers the nickelodeonWorkers to set
     */
    public static void setNickelodeonWorkers(int[] aNickelodeonWorkers) {
        nickelodeonWorkers = aNickelodeonWorkers;
    }

    /**
     * @return the cartoonNetworkWorkers
     */
    public static int[] getCartoonNetworkWorkers() {
        return cartoonNetworkWorkers;
    }

    /**
     * @param aCartoonNetworkWorkers the cartoonNetworkWorkers to set
     */
    public static void setCartoonNetworkWorkers(int[] aCartoonNetworkWorkers) {
        cartoonNetworkWorkers = aCartoonNetworkWorkers;
    }

    /**
     * @return the path
     */
    public static String getPath() {
        return path;
    }

    /**
     * @param aPath the path to set
     */
    public static void setPath(String aPath) {
        path = aPath;
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
     * @return the daysToFinishWork
     */
    public static int[][] getDaysToFinishWork() {
        return daysToFinishWork;
    }

    /**
     * @param aDaysToFinishWork the daysToFinishWork to set
     */
    public static void setDaysToFinishWork(int[][] aDaysToFinishWork) {
        daysToFinishWork = aDaysToFinishWork;
    }

}
