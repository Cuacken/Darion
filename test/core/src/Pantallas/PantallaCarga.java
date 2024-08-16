package Pantallas;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Utiles.Recursos;
import Utiles.Render;
import elementos.Imagen;

public class PantallaCarga implements Screen {

	Imagen fondo;
	SpriteBatch b;
	boolean fadeInTermindo = false;
	float a = 0;
	float contTiempo = 0, tiempoEspera = 4;

	@Override
	public void show() {
		fondo = new Imagen(Recursos.LOGO);
		b = Render.batch;
		fondo.setTransparencia(a);
	}

	@Override
	public void render(float delta) {
		Render.limpiarPantalla(0, 0, 0);

		b.begin();
			fondo.dibujar();
		b.end();
		procesarFade();
	}

	private void procesarFade() {
		if (!fadeInTermindo) {
			a += 0.01F;
			if(a > 1) {
				a = 1;
				fadeInTermindo = true;
			}
		}else {
			contTiempo += 0.05f;
			if(contTiempo >tiempoEspera) {
				a -= 0.01F;
				if(a < 0) {
					a = 0;
					fadeInTermindo = true;
				}
			}
		}

		fondo.setTransparencia(a);

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
