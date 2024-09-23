package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.utils.ScreenUtils;

public class Principal extends Game {

	@Override
	public void create() {
		this.setScreen(new Juego());
		
	}
	
	@Override 
	public void render() {
		super.render();
		ScreenUtils.clear(255,250, 50, 0);
		
	}
	
	@Override
	public void dispose() {
		super.dispose();
	}
}
