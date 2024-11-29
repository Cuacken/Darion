package pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Principal;
import com.mygdx.game.SFXManager;

public class Creditos implements Screen{
	
	private static final int PLAY_BUTTON_WIDTH=95, PLAY_BUTTON_HEIGHT=25, PLAY_BUTTON_Y = 10, TITLE_Y = 0;
	private static final int TITLE_WIDTH=650, TITLE_HEIGHT=500;
	
	private Principal pr;
	
	private Texture bg = new Texture("Fondos/fondo1.jpeg");
	
	private ScreenViewport screenViewport;
	
	private Texture gameTitle;
	
	private Sprite bgSprite;
	
	private Texture playButtonActive;
	private Texture playButtonInactive;
	private boolean[] hasPlayedHoverSound = new boolean[1];  // Para asegurarnos de que el sonido de hover se reproduzca solo una vez.
	private boolean isMouseInside = false; // Controla si el mouse está dentro del botón en el frame actual.
	private boolean wasMouseInside = false;
	
	public Creditos(Principal pr) {
	    this.pr = pr;
	    this.screenViewport = pr.screenViewport;
	    this.gameTitle = new Texture("creditosfondo.png");
	    this.bgSprite = new Sprite(bg);
	    this.playButtonActive = new Texture("volveractivo.png");
	    this.playButtonInactive = new Texture("volverinactivo.png");
	    	
	    }
	@Override
	public void show() {

		
	}
	@Override
	public void render(float delta) {
		ScreenUtils.clear(0.4f, 0.4f, 0.4f, 1);
		
		screenViewport.apply();
		
		pr.batch.setProjectionMatrix(screenViewport.getCamera().combined);
		
		pr.batch.begin();
		
		bgSprite.draw(pr.batch);
		
		int playX = Gdx.graphics.getWidth()/2 - PLAY_BUTTON_WIDTH/2;
		int playY = PLAY_BUTTON_Y;
		
		pr.batch.draw(gameTitle, (Gdx.graphics.getWidth()/2 - TITLE_WIDTH/2), TITLE_Y, TITLE_WIDTH, TITLE_HEIGHT);
		
		if (hoverButton(playButtonActive, playButtonInactive, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT, playX, playY, 0)) {
			pr.setScreen(new MenuPrincipal(pr));
			this.dispose();
		}
		pr.batch.end();
		
		
		}
	public boolean hoverButton(Texture buttonActive, Texture buttonInactive, int buttonWidth, int buttonHeight, int buttonX, int buttonY, int buttonIndex) {

        // Check if mouse is inside the button area
        boolean mouseNowInside = Gdx.input.getX() < buttonX + buttonWidth && Gdx.input.getX() > buttonX &&
                Gdx.graphics.getHeight() - Gdx.input.getY() < buttonY + buttonHeight &&
                Gdx.graphics.getHeight() - Gdx.input.getY() > buttonY;

        // Play hover sound only if mouse enters the button and sound hasn't been played yet (for this specific button)
        if (mouseNowInside && !wasMouseInside && !hasPlayedHoverSound[buttonIndex]) {
            SFXManager.getInstance().playSound("hover");
            hasPlayedHoverSound[buttonIndex] = true; // Mark sound as played for this button
          
        }

        // Reset `hasPlayedHoverSound` for this button if mouse exits
        if (!mouseNowInside) {
            hasPlayedHoverSound[buttonIndex] = false;
        }

        // Draw the button
        pr.batch.draw(mouseNowInside ? buttonActive : buttonInactive,
                Gdx.graphics.getWidth() / 2 - buttonWidth / 2, buttonY, buttonWidth, buttonHeight);

	    // Si el mouse está dentro y se hace clic

	    if (mouseNowInside && Gdx.input.justTouched()) {

	        SFXManager.getInstance().playSound("click");

	        return true;

	    }

        // Update mouse state for next frame
        wasMouseInside = isMouseInside;
        isMouseInside = mouseNowInside;

        return false;
    }

	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
