package elementos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import Utiles.Render;

public class Imagen {
	
	private Texture t; 
	private Sprite s;
	
	public Imagen(String pSource) {
		this.set_Texture(new Texture(pSource));
		this.set_Sprite(new Sprite(this.get_Texture()));
		
	}
	
	public Texture get_Texture() {return t;}
	public Sprite get_Sprite() {
		return s;
	}
	

	public float getX() {return this.get_Sprite().getX();}
	public float getY() {return this.get_Sprite().getY();}
	public float getHeight() {return this.get_Sprite().getHeight();}
	public float getWidth() {return this.get_Sprite().getWidth();}
	
	public void set_Texture(Texture t ) {this.t = t;}
	public void set_Sprite(Sprite s ) {this.s = s;}
	public void setX(float pX) {this.get_Sprite().setX(pX);}
	public void setY(float pY) {this.get_Sprite().setY(pY);}
	public void setSize(float pH, float pW  ) {this.get_Sprite().setSize(pW,pH);}
	public void setCordinates (float pX, float pY) {this.setX(pX);this.setY(pY);}
	public void setAlpha (float pAlpha) {
		this.get_Sprite().setAlpha(pAlpha);
	}
	
	public void dibujar () {
		this.get_Sprite().draw(Render.batch);
	}
	
	public void dispose() {
		this.get_Texture();
	}
}
