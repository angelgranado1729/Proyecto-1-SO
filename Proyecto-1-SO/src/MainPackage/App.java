/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;

import GUI.Classes.Home;
import MainClasses.Drive;
import MainClasses.Employee;
import java.io.File;

/**
 *
 * @author angel
 */
public class App {

    private static int dayDuration = 3000;
    private static Drive drive = new Drive(25, 20, 55, 35, 10);
    private static Employee[] screenwriters;
    private static Employee[] setDesigners;
    private static Employee[] characterAnimators;
    private static Employee[] voiceActors;
    private static Employee[] plotTwistScreenwriters;
    private static Employee[] Assemblers;
    private static String selectedPath = "test\\params.txt";
    private static File selectedFile = new File(selectedPath);

    public void start() {
        Home home = new Home();
        home.setVisible(true);
    }

    /**
     * @return the dayDuration
     */
    public int getDayDuration() {
        return dayDuration;
    }

    /**
     * @param aDayDuration the dayDuration to set
     */
    public static void setDayDuration(int aDayDuration) {
        dayDuration = aDayDuration;
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
     * @return the screenwriters
     */
    public static Employee[] getScreenwriters() {
        return screenwriters;
    }

    /**
     * @param aScreenwriters the screenwriters to set
     */
    public static void setScreenwriters(Employee[] aScreenwriters) {
        screenwriters = aScreenwriters;
    }

    /**
     * @return the setDesigners
     */
    public static Employee[] getSetDesigners() {
        return setDesigners;
    }

    /**
     * @param aSetDesigners the setDesigners to set
     */
    public static void setSetDesigners(Employee[] aSetDesigners) {
        setDesigners = aSetDesigners;
    }

    /**
     * @return the characterAnimators
     */
    public static Employee[] getCharacterAnimators() {
        return characterAnimators;
    }

    /**
     * @param aCharacterAnimators the characterAnimators to set
     */
    public static void setCharacterAnimators(Employee[] aCharacterAnimators) {
        characterAnimators = aCharacterAnimators;
    }

    /**
     * @return the voiceActors
     */
    public static Employee[] getVoiceActors() {
        return voiceActors;
    }

    /**
     * @param aVoiceActors the voiceActors to set
     */
    public static void setVoiceActors(Employee[] aVoiceActors) {
        voiceActors = aVoiceActors;
    }

    /**
     * @return the plotTwistScreenwriters
     */
    public static Employee[] getPlotTwistScreenwriters() {
        return plotTwistScreenwriters;
    }

    /**
     * @param aPlotTwistScreenwriters the plotTwistScreenwriters to set
     */
    public static void setPlotTwistScreenwriters(Employee[] aPlotTwistScreenwriters) {
        plotTwistScreenwriters = aPlotTwistScreenwriters;
    }

    /**
     * @return the Assemblers
     */
    public static Employee[] getAssemblers() {
        return Assemblers;
    }

    /**
     * @param aAssemblers the Assemblers to set
     */
    public static void setAssemblers(Employee[] aAssemblers) {
        Assemblers = aAssemblers;
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
