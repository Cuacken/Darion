package com.mygdx.game;
import com.mygdx.game.entities.Player;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.world.GameMap;
import com.mygdx.game.world.TileType;
import com.mygdx.game.world.TiledGameMap;
import Utiles.Render;

public class Juego implements Screen {

	SpriteBatch batch;
	Texture img;
	OrthographicCamera cam;
	GameMap gameMap;
	Player player;
	@Override
	public void dispose () {
		Render.batch.dispose();
		gameMap.dispose();
	}

	@Override
	public void show() {

		batch = Render.batch;

		img = new Texture("badlogic.jpg");
		gameMap = new TiledGameMap();
		cam = new OrthographicCamera();
		player  = new Player(0, 0);
		cam.zoom = 1;
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.update();

		
	}

	@Override
	public void render(float delta) {

		Render.batch.begin();
		gameMap.update(Gdx.graphics.getDeltaTime());
		gameMap.render(cam, batch);
		Render.batch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
}
