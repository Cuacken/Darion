package Pantallas;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Utiles.Recursos;
import Utiles.Render;
import elementos.Imagen;

public class PantallaCarga implements Screen {

	private Imagen fondo;
	private float suma, alpha;
	private boolean carga, listo, pausa;
	SpriteBatch b;

	
	
	public PantallaCarga() {
		this.fondo = new Imagen(Recursos.LOGO);
		this.suma = 0.01f;
		this.alpha = 0;
		this.carga = false;
		this.listo = false;
		this.pausa = false;
	} 


	@Override
	public void show() {
		this.fondo.setSize(160, 290);
		this.fondo.setCordinates(250, 250);
		b = Render.batch;
	}

	@Override
	public void render(float delta) {
		Render.limpiarPantalla();

		b.begin();
			this.fondo.dibujar();
		b.end();
		
		if(this.carga) {
			if(!this.pausa) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.pausa = true;
			}
			if(!this.listo)
				fadeOut();
			else {
				Recursos.MAIN.setScreen(new MenuScreen());
				this.dispose();
			}
		}else
			fadeIn();
	}


	@Override
	public void dispose() {
		this.fondo.dispose();;
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
	
	private void fadeIn() {
		if(!this.carga) { 	
			if(this.alpha >=1)
				this.carga = true;
		else 
			this.alpha += this.suma;
		this.fondo.setAlpha(this.alpha);
		}
	}
	
	private void fadeOut() {
		if(!this.listo) {	
			if(this.alpha < 0 )
				this.listo = true;
			else
				this.alpha -= this.suma;
			this.fondo.setAlpha(this.alpha);
	}

}
}
