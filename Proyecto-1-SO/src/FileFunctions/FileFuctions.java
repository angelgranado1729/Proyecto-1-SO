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
    
    public static void loadData(String data){
        if (!("").equals(data)){
            
        }
    }
    
    
    
}
