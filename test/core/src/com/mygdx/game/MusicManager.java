package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import java.util.HashMap;

public class MusicManager {
    private static MusicManager instance; // Singleton para gestionar la música globalmente
    private Music currentMusic;
    private final HashMap<String, Music> musicMap;

    private MusicManager() {
        musicMap = new HashMap<>();
    }

    public static MusicManager getInstance() {
        if (instance == null) {
            instance = new MusicManager();
        }
        return instance;
    }

    // Carga una canción y la asocia a una clave
    public void loadMusic(String key, String filePath) {
        Music music = Gdx.audio.newMusic(Gdx.files.internal(filePath));
        musicMap.put(key, music);
    }

    // Reproduce la música asociada a una clave
    public void playMusic(String key) {
        if (currentMusic != null) {
            currentMusic.stop();
        }

        currentMusic = musicMap.get(key);
        if (currentMusic != null) {
            currentMusic.setLooping(true);
            currentMusic.setVolume(1f); // Ajusta el volumen según prefieras
            currentMusic.play();
            Gdx.app.log("MusicManager", "Reproduciendo música: " + key);
        } else {
            Gdx.app.log("MusicManager", "No se encontró música para la clave: " + key);
        }
    }
    

    // Detiene la música actual
    public void stopMusic() {
        if (currentMusic != null) {
            currentMusic.stop();
        }
    }

    // Libera los recursos de música al cerrar el juego
    public void dispose() {
        if (currentMusic != null) {
            currentMusic.stop();
            currentMusic.dispose();
        }

        for (Music music : musicMap.values()) {
            music.dispose();
        }

        musicMap.clear();
    }
}