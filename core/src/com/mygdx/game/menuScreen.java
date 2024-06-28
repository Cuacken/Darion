package com.mygdx.game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Screen;

public class menuScreen extends InputAdapter implements Screen{
	
	Stage stage;
	SpriteBatch batch;
	Texture pj;
	float Vel = 50.0f;
	float pjx = 0;
	float pjy = 0;
	

	@Override
	public void show() {
	pj = new Texture("issac.jpg");
	stage = new Stage();
	Gdx.input.setInputProcessor(stage);
	batch = new SpriteBatch();
	}

	@Override
	public void render(float delta) {
	Gdx.gl.glClearColor(1, 1, 1, 0);
	ScreenUtils.clear(1, 1, 1, 0);
	batch.begin();
	stage.draw();
	batch.draw(pj,pjx,pjy);
		
	if (Gdx.input.isKeyPressed(Input.Keys.W)) {
		System.out.println("W");
		pjy += Gdx.graphics.getDeltaTime() + Vel;
	}
	if (Gdx.input.isKeyPressed(Input.Keys.S)) {
		System.out.println("S");
		pjy -= Gdx.graphics.getDeltaTime() + Vel;
	}
	if (Gdx.input.isKeyPressed(Input.Keys.A)) {
		System.out.println("A");
		pjx -= Gdx.graphics.getDeltaTime() + Vel;
	}
	if (Gdx.input.isKeyPressed(Input.Keys.D)) {
		System.out.println("D");
		pjx += Gdx.graphics.getDeltaTime() + Vel;
	}
	batch.end();
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

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
