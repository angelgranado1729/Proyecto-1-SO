/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

/**
 *
 * @author angel
 */
public class ImportantConstants {

    public final static String[] companies = {
            "Nickelodeon",
            "Cartoon Network"
    };

    public final static String[] workesType = {
            "Screenwriter",
            "Set designer",
            "Character animator",
            "Voice actor",
            "Plot Twist Screenwriter",
            "Assembler",
            "Project Manager",
            "Director"
    };

    public final static int[] hourlyWages = {
            20,
            26,
            40,
            16,
            34,
            50,
            40,
            60
    };

    // ANCHOR - El primer array es de Nickelodeon y el segundo de Cartoon Network
    // FIXME - Revisar los tiempos de producción (El carnet)
    // NOTE - Estoy asumiendo que Nickelodeon es con el carnet mio (ultimo digito =
    // 3). El primer numero es la cantidad de trabajo que termina y el segundo es
    // cuantos dia le toma en terminarlo
    public final static int[][][] productionTimes = {
            { { 1, 3 }, { 1, 3 }, { 2, 1 }, { 3, 1 }, { 1, 3 }, { 1, 2 } },
            { { 1, 4 }, { 1, 4 }, { 1, 1 }, { 5, 1 }, { 1, 2 }, { 1, 2 } }
    };

}
