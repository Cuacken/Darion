package Pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

import Utiles.Recursos;
import Utiles.Render;
import elementos.Imagen;

public class MenuScreen implements Screen{
	private Imagen background;
	
	private BitmapFont font;
	private GlyphLayout layout;
	
	public MenuScreen() {
		this.background = new Imagen (Recursos.MENU_BACKGROUND); 
		this.layout = new GlyphLayout();
	}
	
	@Override
	public void show() {
	
		
	}
	
	@Override
	public void render(float delta) {
		Render.batch.begin();
		this.background.dibujar();
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator (Gdx.files.internal(Recursos.MENU_FONT));
		FreeTypeFontGenerator.FreeTypeFontParameter parametro = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parametro.size = 16;
		parametro.color =
				
		
		Render.batch.end();
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
