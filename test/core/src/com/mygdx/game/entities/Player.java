package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.world.GameMap;

public class Player extends Entity {
	
	private static final int SPEED = 60;
	
	Texture image;

	public Player(float x, float y, GameMap map) {
		super(x, y, EntityType.PLAYER, map);
		image = new Texture("personaje.png");
	}

	
	@Override
	public void update(float deltaTime) {
		//ARRIBA
		if (Gdx.input.isKeyPressed(Keys.W))
			this.moveY(SPEED*deltaTime);
		//ABAJO
		if (Gdx.input.isKeyPressed(Keys.S))
			this.moveY(-SPEED*deltaTime);
		//IZQUIERDA
		if (Gdx.input.isKeyPressed(Keys.A))
			this.moveX(-SPEED*deltaTime);
		//DERECHA
		if (Gdx.input.isKeyPressed(Keys.D))
			this.moveX(SPEED*deltaTime);
		//DebugTeleport
		//incompleto falta hacer
		super.update(deltaTime);
	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
	}

}
