/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import java.io.File;

// ...

public void playSound() {
    try {
        // Abre un archivo de sonido.
        File soundFile = new File("sonidos/gong.wav"); // Debes cambiar esta ruta al lugar correcto de tu archivo de sonido.
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
        
        // Obtiene un clip de sonido de recursos del sistema.
        Clip clip = AudioSystem.getClip();
        
        // Abre el archivo de audio para el clip y empieza a reproducirlo
        clip.open(audioIn);
        clip.start();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
