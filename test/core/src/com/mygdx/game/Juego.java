package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.world.GameMap;
import com.mygdx.game.world.TileType;
import com.mygdx.game.world.TiledGameMap;

import Pantallas.PantallaCarga;
import Utiles.Render;

public class Juego extends Game {
	
	SpriteBatch batch;
	Texture img;
	OrthographicCamera cam;
	
	GameMap gameMap;
	
	public void create () {
		Render.app =this;
		batch = Render.batch;
		this.setScreen(new PantallaCarga());
		img = new Texture("badlogic.jpg");
		gameMap = new TiledGameMap();
		cam = new OrthographicCamera();
		cam.zoom = 1;
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.update();

		
	}

	public void render () {
		super.render();
//		Gdx.gl.glClearColor(150,14,0,1);
//		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		
//		//mover camara con el mouse
//		if(Gdx.input.isTouched()) {
//			cam.translate(-Gdx.input.getDeltaX(), Gdx.input.getDeltaY());
//			cam.update();
//		}
//		
//		//mover camara con las teclas
//		if (Gdx.input.isKeyPressed(Keys.UP)) {
//			cam.translate(0, 1, 0);
//			cam.update();
//		}
//		if(Gdx.input.isKeyPressed(Keys.DOWN)) {
//			cam.translate(0, -1, 0);
//			cam.update();
//		}
//		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
//			cam.translate(-1, 0, 0);
//			cam.update();
//		}
//		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
//			cam.translate(1, 0, 0);
//			cam.update();
//		}
//		
//		
//		
//		//zoom ++
//		if(Gdx.input.isKeyJustPressed(Keys.O) || Gdx.input.isKeyJustPressed(Keys.NUMPAD_ADD)  ) {
//			if (cam.zoom <= 0.2f){
//				cam.update();
//				cam.zoom = 0.2f;
//				cam.update();
//			}
//			else if (cam.zoom > 0.2f){
//			cam.zoom = cam.zoom - 0.2f;
//			cam.update();
//			}
//			else if (cam.zoom == 0.0f){
//				cam.zoom = 0.2f;
//				cam.update();
//			}
//		}
//		//zoom --
//		if(Gdx.input.isKeyJustPressed(Keys.P )|| Gdx.input.isKeyJustPressed(Keys.NUMPAD_SUBTRACT)) {
//			cam.zoom = cam.zoom + 0.2f;
//			cam.update();
//		}
//		
//		
//		gameMap.update(Gdx.graphics.getDeltaTime());
//		gameMap.render(cam, batch);

	}
	
	@Override
	public void dispose () {
		Render.batch.dispose();
//		gameMap.dispose();
	}
}
