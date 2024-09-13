package Utiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Juego;

public class Render {
	public static SpriteBatch batch = new SpriteBatch();
	
	public static void limpiarPantalla() {
		ScreenUtils.clear(0, 0, 0, 0);
	}
	
	public static void limpiarPantalla (float pR, float pG, float pB, float pA) {
		ScreenUtils.clear(pR, pG, pB, pA);
		}
}
