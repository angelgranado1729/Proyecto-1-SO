/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

/**
 *
 * @author angel
 */
public class Drive {

    private int[] sections;
    private int[] maxCapacity;

    public Drive(
            int maxScripts,
            int maxScenarios,
            int maxAnimations,
            int maxDubbing,
            int maxScriptsWithPlotTwist
    ) {
        this.sections = new int[6];
        this.maxCapacity = new int[]{
            maxScripts,
            maxScenarios,
            maxAnimations,
            maxDubbing,
            maxScriptsWithPlotTwist
        };
    }

    public void uploadFile(int workerType, int workToUpload) {
        if (workerType >= 0 && workerType <= 5) {
            // Si el trabajador es de tipo 5, se sube el archivo sin verificar la capacidad máxima
            if (workerType == 5) {
                this.getSections()[workerType] += workToUpload;
            } else if (this.getSections()[workerType] < this.getMaxCapacity()[workerType]) {
                // Para los otros trabajadores, se verifica la capacidad máxima antes de subir el archivo
                this.getSections()[workerType] += workToUpload;
            }
        }
    }

    @Override
    public String toString() {
        String str = "Drive Info\n\n";
        for (int i = 0; i <= 5; i++) {
            str += "-" + Helpers.workesType[i] + "'s drive section: " + this.sections[i] + "\n";
            if (i != 5) {
                str += "-" + Helpers.workesType[i] + "'s max capacity: " + this.maxCapacity[i] + "\n";
            }
        }
        return str;
    }

    /**
     * @return the sections
     */
    public int[] getSections() {
        return sections;
    }

    /**
     * @param sections the sections to set
     */
    public void setSections(int[] sections) {
        this.sections = sections;
    }

    /**
     * @return the maxCapacity
     */
    public int[] getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * @param maxCapacity the maxCapacity to set
     */
    public void setMaxCapacity(int[] maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

}
