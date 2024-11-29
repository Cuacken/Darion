package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import java.util.HashMap;

public class SFXManager {

    // Mapa para almacenar los efectos de sonido cargados
    private static final HashMap<String, Sound> soundMap = new HashMap<>();
    
    // Instancia única (Singleton)
    private static final SFXManager instance = new SFXManager();

    private SFXManager() {}

    public static SFXManager getInstance() {
        return instance;
    }

    // Cargar un SFX
    public void loadSound(String key, String filePath) {
        if (!soundMap.containsKey(key)) {
            soundMap.put(key, Gdx.audio.newSound(Gdx.files.internal(filePath)));
        }
    }

    // Reproducir un SFX
    public void playSound(String key) {
        Sound sound = soundMap.get(key);
        if (sound != null) {
            sound.play();
            Gdx.app.log("SFXManager", "Reproduciendo SFX: " + key);
        } else {
            Gdx.app.log("SFXManager", "No se encontró el SFX para la clave: " + key);
        }
    }

    // Reproducir un SFX con un volumen personalizado
    public void playSound(String key, float volume) {
        Sound sound = soundMap.get(key);
        if (sound != null) {
            sound.play(volume);  // Ajuste del volumen
        } else {
            Gdx.app.log("SFXManager", "No se encontró el SFX para la clave: " + key);
        }
    }

    // Detener un SFX específico (si fuera necesario)
    public void stopSound(String key) {
        Sound sound = soundMap.get(key);
        if (sound != null) {
            sound.stop();
        }
    }

    // Liberar los recursos cuando ya no se necesiten
    public void dispose() {
        for (Sound sound : soundMap.values()) {
            sound.dispose();
        }
        soundMap.clear();
    }
}
