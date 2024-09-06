package Pantallas;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

import Utiles.Recursos;
import Utiles.Render;
import elementos.Imagen;
import elementos.Text;

public class MenuScreen implements Screen{
	private Imagen background;
	private Text info;
	private ArrayList<Text> options;
	

	
	public MenuScreen() {
		this.background = new Imagen (Recursos.MENU_BACKGROUND); 
		options = new ArrayList<Text>();
	}
	
	@Override
	public void show() {
//		this.info= new Text(Recursos.MENU_FONT, 100f, 200f, 22,"Prueba");
		
	}
	
	@Override
	public void render(float delta) {
		Render.batch.begin();
		this.info.dibujar();
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
	
	private void generateMenu() {
		int mFontSize = 35;
		this.options.add(new Text("Nuevo Juego", mFontSize, Recursos.MENU_FONT));
		this.options.add(new Text("Cargar Partida", mFontSize, Recursos.MENU_FONT));
		this.options.add(new Text("Opciones", mFontSize, Recursos.MENU_FONT));
		this.options.add(new Text("Salir", mFontSize, Recursos.MENU_FONT));
	}
}
