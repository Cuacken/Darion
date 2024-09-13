package elementos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import Utiles.Render;

public class Imagen {
	
	private Texture t; 
	private Sprite s;
	

	public Imagen(String ruta) {
		t = new Texture (ruta);
		s = new Sprite (t);
		
	}
	

	public void dibujar () {
		s.draw(Render.batch);
	}
	
	public void setTransparencia (float a) {
		s.setAlpha(a);
	}
}
