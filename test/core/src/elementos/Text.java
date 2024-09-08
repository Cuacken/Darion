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
	
	public Text() {
		initLayout();
		generarTexto(Recursos.MENU_FONT, this.fontSize , FONT_COLOR , pShadow false);
		this.setCordinates(100, 100f);
		this.setTexto("");
	}
	
	public Text(String pFontPath, float pX, float pY, int pFontSize, String pTexto) {
		initLayout();
		generarTexto(pFontPath,pFontSize, FONT_COLOR ,pShadow false);
		this.setCordinates(pX, pY);
		this.setTexto(pTexto);
	}
	

	public Text(String pFontPath, float pX, float pY, int pFontSize, String pTexto,boolean pShadow) {
		initLayout();
		generarTexto(pFontPath, pFontSize, FONT_COLOR ,pShadow);
		this.setCordinates(pX, pY);
		this.setTexto(pTexto);
	}

	public Text(String pFontPath, float pX, float pY, int pFontSize, String pTexto, Color pColor) {
		initLayout();
		generarTexto(pFontPath,pFontSize, pColor ,pShadow false);
		this.setCordinates(pX, pY);
		this.setTexto(pTexto);
	}
	

	public Text(String pFontPath, float pX, float pY, int pFontSize, String pTexto, Color pColor,boolean pShadow) {
		initLayout();
		generarTexto(pFontPath, pFontSize, pColor ,pShadow);
		this.setCordinates(pX, pY);
		this.setTexto(pTexto);
	}
	public Text (String pTexto, int pFontSize, String pFontSource) {
		initLayout();
		generarTexto(pFont, pFontSize, this.FONT_COLOR ,pShadow);
		this.setCordinates(1,1);
		this.setTexto(pTexto);
	
	
	public Text (String pTexto, int pFontSize) {
		initLayout();
		generarTexto(Recursos.MENU_FONT, pFontSize, this.FONT_COLOR ,pShadow);
		this.setCordinates(1,1);
		this.setTexto(pTexto);
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

	public float getWidth() {
		return this.getLayout().width;
	}
	public float getHeight() {
		return this.getLayout().height;
	}
	
	public void setTexto(String pTexto) {
		this.texto = pTexto;
		this.layout.setText(this.font, pTexto);
	}

	public void setCordinates (float pX, float pY) {
		this.setX(pX);
		this.setY(pY);
	}
	
	public void setColor(Color pColor) {
		this.getFont().setColor(pColor);
	}

	//Funciones publicas
	public void draw() {
		this.font.draw(Render.batch, this.getTexto(), this.getX(), this.getY());
	}
	
	public void centerText() {
		float w = (Recursos.WIDTH/2) - (this.getWidth()/2);
		float h = (Recursos.HEIGHT/2) - (this.getHeight()/2);
		this.setCordinates(w, h);
	}
	//metodos privados

	private void generarTexto(String pFontPath, float x, float y, int pFontSize, Color pColor,boolean pShadow) {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator (Gdx.files.internal(pFontPath));
		FreeTypeFontGenerator.FreeTypeFontParameter parametro = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parametro.size = fontSize;
		parametro.color = pColor;
		if(pShadow) {
			parametro.shadowOffsetX = 1;
			parametro.shadowOffsetY = 1;
			parametro.shadowColor = Color.BLACK;
		}
		
		this.setFontSize(pFontSize);
		this.font = generator.generateFont(parametro);
	}
	
	private void initLayout() {
		this.setLayout(new GlyphLayout());
	}
}
