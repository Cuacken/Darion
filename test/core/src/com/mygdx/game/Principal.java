package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import Utiles.Recursos;
import pantallas.Juego;
import pantallas.MenuPrincipal;
import pantallas.PantallaCarga;

public class Principal extends Game {
	public SpriteBatch batch;
	public ScreenViewport screenViewport;
	
	@Override
	public void create () {
        MusicManager musicManager = MusicManager.getInstance();
        SFXManager sfxManager = SFXManager.getInstance();
        // Cargar canciones
        musicManager.loadMusic("menu", "music/menu.mp3");
        musicManager.loadMusic("main", "music/main loop.mp3");
        musicManager.loadMusic("win", "music/victory.mp3");
        // Cargar sonidos
        sfxManager.loadSound("hover", "sfx/menuhover.mp3");
        sfxManager.loadSound("click", "sfx/menuclick.mp3");
		Recursos.MAIN = this;
		batch = new SpriteBatch();
		screenViewport = new ScreenViewport();
		this.setScreen(new PantallaCarga(this));
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);		
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		super.dispose();
	}
	

	
}
