/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileFunctions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author angel
 */
public class FileFuctions {
    
    public static String read(File selectedFile){
        String line;
        String data= "";
        File file = selectedFile;
        
        try {
            if (!file.exists()) {
                file.createNewFile();

            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                
                while ((line = br.readLine()) != null){
                    if (!(line.isEmpty())){
                        data += line + "\n";
                    }
                }
                br.close();
            }
            return data;
        } catch (Exception e){
        }
        return data;
    }

     public int[] getCartoonNetworkValues(String fileData) {
    // Busca el índice de inicio de la sección de Cartoon Network
        int startIndex = fileData.indexOf("[CartoonNetwork]");
        if (startIndex == -1) {
            // La sección de Cartoon Network no fue encontrada.
            return null;
        }

        // Se Encuentra el final de la sección de Cartoon Network o el final del archivo si no hay más secciones
        int endIndex = fileData.indexOf("[", startIndex + 1);
        if (endIndex == -1) {
            endIndex = fileData.length();
        }

        // Se extrae la sección de Cartoon Network
        String cnSection = fileData.substring(startIndex, endIndex);

        // Se divide la sección en líneas
        String[] lines = cnSection.split("\n");

        // Se crea un array para almacenar los valores enteros de la configuración
        // Hay 8 tipos de trabajadores + el valor de máxima cantidad de empleados.
        int[] cnValues = new int[9];

        // Variable para recorrer el arreglo de líneas
        int valueIndex = 0;

        // Se Itera sobre las líneas, extrayendo los valores enteros
        for (String line : lines) {
            if (line.contains("=")) {
                // Divide la línea en la etiqueta y el valor
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    try {
                        // Se castea el valor entero y lo almacena en el array
                        cnValues[valueIndex++] = Integer.parseInt(parts[1].trim());
                    } catch (NumberFormatException e) {
                        System.out.println("El valor no es entero");
                    }
                }
            }
    }
    
    return cnValues;
}
     
     public int[] getNickelodeonValues(String fileData) {
    // Busca el índice de inicio de la sección de Nickelodeon
        int startIndex = fileData.indexOf("[Nickelodeon]");
        if (startIndex == -1) {
            // La sección de Cartoon Network no fue encontrada.
            return null;
        }

        // Se Encuentra el final de la sección de Cartoon Network o el final del archivo si no hay más secciones
        int endIndex = fileData.indexOf("[", startIndex + 1);
        if (endIndex == -1) {
            endIndex = fileData.length();
        }

        // Se extrae la sección de Nickelodeon
        String cnSection = fileData.substring(startIndex, endIndex);

        // Se divide la sección en líneas
        String[] lines = cnSection.split("\n");

        // Se crea un array para almacenar los valores enteros de la configuración
        // Hay 8 tipos de trabajadores + el valor de máxima cantidad de empleados.
        int[] nickValues = new int[9];

        // Variable para recorrer el arreglo de líneas
        int valueIndex = 0;

        // Se Itera sobre las líneas, extrayendo los valores enteros
        for (String line : lines) {
            if (line.contains("=")) {
                // Divide la línea en la etiqueta y el valor
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    try {
                        // Se castea el valor entero y lo almacena en el array
                        nickValues[valueIndex++] = Integer.parseInt(parts[1].trim());
                    } catch (NumberFormatException e) {
                        System.out.println("El valor no es entero");
                    }
                }
            }
    }
    
    return nickValues;
}
    
    public static void loadData(String data){
        if (!("").equals(data)){
            
        }
    }
}
