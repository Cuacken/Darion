package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import Utiles.Recursos;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
    public static void main(String[] arg) {

        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setForegroundFPS(60);
        config.setWindowSizeLimits(650, 500, 650, 500);
        config.setWindowIcon("iconotemporal.png");
        config.setTitle("Project: S.E.R.");

        // Crear la instancia principal del juego y asignarla a Recursos.MAIN
        Recursos.MAIN = new Principal();

        // Pasar la instancia al constructor de Lwjgl3Application
        new Lwjgl3Application(Recursos.MAIN, config);
    }
}