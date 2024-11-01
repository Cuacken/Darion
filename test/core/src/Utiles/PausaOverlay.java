package Utiles;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import com.badlogic.gdx.Game;
import com.mygdx.game.Juego;
import com.mygdx.game.world.GameMap;



public class PausaOverlay {

	
	private BufferedImage backgroundImg;
	private int bgX, bgY, bgW, bgH;


	public PausaOverlay() {
	
	}

	private void loadBackground() {
		backgroundImg = PauseMenu.GetSpriteAtlas(PauseMenu.PAUSE_BACKGROUND);
		bgW = (int) (backgroundImg.getWidth() * GameMap.SCALE);
		bgH = (int) (backgroundImg.getHeight() * GameMap.SCALE);
		bgX = GameMap.GAME_WIDTH / 2 - bgW / 2;
		bgY = 100;

	}

	public void update() {


	}

	public void draw(Graphics g) {
	
		g.drawImage(backgroundImg, bgX, bgY, bgW, bgH, null);

	
	}

	public void mouseDragged(MouseEvent e) {
	

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {


	}

	public void mouseMoved(MouseEvent e) {

	}

}