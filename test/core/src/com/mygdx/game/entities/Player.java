package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.world.GameMap;

public class Player extends Entity {
	private static float boost = 1 ;
	private static final float SPEED = 60*boost;
	
	Texture image;

	public Player(float x, float y, GameMap map) {
		super(x, y, EntityType.PLAYER, map);
		image = new Texture("personaje.png");
	}

	
	@Override
	public void update(float deltaTime) {
		
		//MOVIMIENTO{
		//ARRIBA
		if (Gdx.input.isKeyPressed(Keys.W) == true)
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
		//}
		
		//CARRERA{
		if (Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)){
			//ARRIBA
			if (Gdx.input.isKeyPressed(Keys.W))
				this.moveY((SPEED*deltaTime)*boost );
			//ABAJO
			if (Gdx.input.isKeyPressed(Keys.S))
				this.moveY((-SPEED*deltaTime)*boost);
			//IZQUIERDA
			if (Gdx.input.isKeyPressed(Keys.A))
				this.moveX((-SPEED*deltaTime)*boost);
			//DERECHA
			if (Gdx.input.isKeyPressed(Keys.D))
				this.moveX((SPEED*deltaTime)*boost);
			}
		//set boost a carrera
		if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)) {
			boost = 1.15f;
		}
		else {
			boost = 1f;
		}
		//}
		
		//ROLL{
		if (Gdx.input.isKeyJustPressed(Keys.CONTROL_LEFT)) {
			//ARRIBA
			if (Gdx.input.isKeyPressed(Keys.W))
				this.moveY((SPEED*deltaTime)*boost );
			//ABAJO
			if (Gdx.input.isKeyPressed(Keys.S))
				this.moveY((-SPEED*deltaTime)*boost);
			//IZQUIERDA
			if (Gdx.input.isKeyPressed(Keys.A))
				this.moveX((-SPEED*deltaTime)*boost);
			//DERECHA
			if (Gdx.input.isKeyPressed(Keys.D))
				this.moveX((SPEED*deltaTime)*boost);
		}
		//set boost a roll
		if(Gdx.input.isKeyPressed(Keys.CONTROL_LEFT)) {
			boost = 6.0001f;
			for(int i=0;i>15;i++) {
				boost = boost - 0.13334f;
			}
		}
		else {
			boost = 1f;
		}
		//}
		
		super.update(deltaTime);
	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
	}

}
