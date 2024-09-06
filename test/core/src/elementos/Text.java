package elementos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import Pantallas.FreeTypeFontGenerator;
import Utiles.Recursos;
import Utiles.Render;

public class Text {
	private static final Color FONT_COLOR = Color.WHITE;
	private BitmapFont font;
	private GlyphLayout layout;
	private float x, y;
	private int fontSize = 16;
	private String texto;
	
	//constructores
	
	public Text(String pFontPath, float x, float y, int pFontSize, String pTexto) {
		initLayout();
		generarTexto(pFontPath,pFontSize, FONT_COLOR ,pShadow false);
	}
	

	public Text(String pFontPath, float x, float y, int pFontSize, String pTexto,boolean pShadow) {
		initLayout();
		generarTexto(pFontPath, pFontSize, FONT_COLOR ,pShadow);
	}

	public Text(String pFontPath, float x, float y, int pFontSize, String pTexto, Color pColor) {
		initLayout();
		generarTexto(pFontPath,pFontSize, pColor ,pShadow false);
	}
	

	public Text(String pFontPath, float x, float y, int pFontSize, String pTexto, Color pColor,boolean pShadow) {
		initLayout();
		generarTexto(pFontPath, pFontSize, pColor ,pShadow);
	}
	
	//get + set
	public BitmapFont getFont() {
		return font;
	}

	public void setFont(BitmapFont font) {
		this.font = font;
	}

	public GlyphLayout getLayout() {
		return layout;
	}

	public void setLayout(GlyphLayout layout) {
		this.layout = layout;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}
	
	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setCordinates (float pX, float pY) {
		this.setX(pX);
		this.setY(pY);
	}
	
	public void setColor(Color pColor) {
		this.getFont().setColor(pColor);
	}


	//metodos privados

	private void generarTexto(String pFontPath, float x, float y, int pFontSize, Color pColor,boolean pShadow) {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator (Gdx.files.internal(Recursos.MENU_FONT));
		FreeTypeFontGenerator.FreeTypeFontParameter parametro = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parametro.size = 16;
		parametro.color = Color.FIREBRICK;
		parametro.shadowOffsetX = 1;
		parametro.shadowOffsetY = 1;
		parametro.shadowColor = Color.BLACK;
		this.font = generator.generateFont(parametro);
		
		this.layout.setText(this.font, "Empezar");
		this.font.draw(Render.batch, "Empezar", 100,100);
	}
	
	private void initLayout() {
		this.setLayout(new GlyphLayout());
	}
}
