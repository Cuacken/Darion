package com.mygdx.game.entities;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.world.GameMap;

public class Player extends Entity {
	private static float boost = 1 ;
	private static final float SPEED = 60*boost;
	
	Texture image;

	public Player(float x, float y) {
		super(x, y, EntityType.PLAYER);
		image = new Texture("personaje.png");
	}

	
	@Override
	public void update(float deltaTime) {
		
			//MOVIMIENTO{
		//ARRIBA
		if (Gdx.input.isKeyPressed(Keys.W) == true)
			this.moveY((SPEED*deltaTime)*boost);
		//ABAJO
		if (Gdx.input.isKeyPressed(Keys.S))
			this.moveY((-SPEED*deltaTime)*boost);
		//IZQUIERDA
		if (Gdx.input.isKeyPressed(Keys.A))
			this.moveX((-SPEED*deltaTime)*boost);
		//DERECHA
		if (Gdx.input.isKeyPressed(Keys.D))
			this.moveX((SPEED*deltaTime)*boost);
			//}
		
			//CARRERA{

		//set boost a carrera
		if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)) {
			boost = 2f;
		}
		else {
			boost = 1f;
		}
			//}
		
			//ROLL{
		//set boost a roll
		if (Gdx.input.isKeyJustPressed(Keys.CONTROL_LEFT)) {
			boost = 2f;
			long tiempo = TimeUtils.millis();
			long tuturo = TimeUtils.timeSinceMillis(tiempo+2000);
			System.out.println("Velocidad inicial:" + boost);
			System.out.println(tiempo);
			if(TimeUtils.timeSinceMillis(tiempo) == tuturo) {
				boost = 1f;
			}
			System.out.println("Velocidad final:" + boost);
		}
			//}

		super.update(deltaTime);
	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
	}

}
