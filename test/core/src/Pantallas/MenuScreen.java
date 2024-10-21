package Pantallas;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import Utiles.Recursos;
import Utiles.Render;
import elementos.Imagen;


public class MenuScreen implements Screen{
	private Stage stage;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table;
	private TextButton btnSalir, btnJugar;
	private BitmapFont blanco , negro;
	private Label heading;
	Imagen fondo;
	SpriteBatch b;
	
	@Override
	public void show() {
		
//		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/myfont.ttf"));
//		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
//		blanco = BitmapFont(Gdx.files.internal("fonts/IndieFlowe.ttf"),false);
//		fondo = new Imagen(Recursos.MENU_BACKGROUND);
		b = Render.batch;
	}


	@Override
	public void render(float delta) {
//		Render.batch.begin();
//			fondo.dibujar();
//		Render.batch.end();
		
		
	}

	@Override
	public void resize(int width, int height) {
		
		
	}

	@Override
	public void pause() {
		
		
	}

	@Override
	public void resume() {
		
		
	}

	@Override
	public void hide() {
		
		
	}

	@Override
	public void dispose() {
		
		
	}
	
}
