package pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MusicManager;
import com.mygdx.game.Principal;

import Utiles.Recursos;
import Utiles.Render;
import elementos.Imagen;
public class PantallaCarga implements Screen {

	Imagen fondo;
	boolean fadeInTerminado = false, termina = false;;
	SpriteBatch b;
	float a = 0;
	float contTiempo =0, tiempoEspera=1;
	float contTiempoTermina=0, tiempoTermina =1;
	private Principal pr;
	private ScreenViewport screenViewport;

	public PantallaCarga(Principal pr) {
	    this.pr = pr;
	    this.screenViewport = pr.screenViewport;
	    }
	
	@Override
	public void show() {
		fondo = new Imagen(Recursos.LOGO);
		fondo.setSize(500, 400);
		fondo.setPos(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		b = Render.batch;
		fondo.setTransparencia(a);

	}

	@Override
	public void render(float delta) {
		Render.limpiarPantalla(0,0,0, 0);

		
		b.begin();
			fondo.dibujar();
		b.end();
		
		procesarFade();

	}




	@Override
	public void dispose() {
		
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
	
	private void procesarFade() {
		if(!fadeInTerminado) {
			a += 0.01f;
			if(a>1) {
				a=1;
				fadeInTerminado = true;
			}
		}else {
			contTiempo +=0.05f;
			if(contTiempo>tiempoEspera) {
				a -= 0.01f;
				if(a<0) {
					a=0;
					termina = true;
			}
		}
	}
		fondo.setTransparencia(a);
		
		//Fin de la Pantalla de carga Inicio menu
		
		if (termina) {
		    contTiempoTermina += 0.1f;
		    if (contTiempoTermina > tiempoTermina) {
		    	MusicManager.getInstance().playMusic("menu");
		    	Recursos.MAIN.setScreen(new MenuPrincipal((Principal) Recursos.MAIN));;
		    }
		}
}
}