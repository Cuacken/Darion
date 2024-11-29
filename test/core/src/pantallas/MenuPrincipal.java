package pantallas;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MusicManager;
import com.mygdx.game.Principal;
import com.mygdx.game.SFXManager;

public class MenuPrincipal implements Screen{
	
	private static final int EXIT_BUTTON_WIDTH=150, EXIT_BUTTON_HEIGHT=60, PLAY_BUTTON_WIDTH=200, PLAY_BUTTON_HEIGHT=80;
	private static final int TITLE_WIDTH=424, TITLE_HEIGHT=211;
	private static final int EXIT_BUTTON_Y = 30, PLAY_BUTTON_Y = 110, TITLE_Y = 230;
	private static final int CREDITS_BUTTON_WIDTH=100,CREDITS_BUTTON_HEIGHT=20,CREDITS_BUTTON_Y=190;
	
	private final Principal pr;
	
	private Texture bg = new Texture("Fondos/fondo1.jpeg");
	
	private ScreenViewport screenViewport;
	
	private Texture gameTitle;
	
	private Sprite bgSprite;
	
	private Texture playButtonActive;
	private Texture playButtonInactive;
	private Texture creditsButtonActive;
	private Texture creditsButtonInactive;
	private Texture exitButtonActive;
	private Texture exitButtonInactive;
	private boolean[] hasPlayedHoverSound = new boolean[3];  // Para asegurarnos de que el sonido de hover se reproduzca solo una vez.
	private boolean isMouseInside = false; // Controla si el mouse está dentro del botón en el frame actual.
	private boolean wasMouseInside = false;
	
	public MenuPrincipal(Principal pr) {
	    this.pr = pr;
	    this.screenViewport = pr.screenViewport;
	    this.gameTitle = new Texture("logo.png");
	    this.bgSprite = new Sprite(bg);
	    this.playButtonActive = new Texture("playactivo.png");
	    this.playButtonInactive = new Texture("playinactivo.png");
	    this.exitButtonActive = new Texture("saliractivo.png");
	    this.exitButtonInactive = new Texture("salirinactivo.png");
	    this.creditsButtonActive = new Texture("creditosactivo.png");
	    this.creditsButtonInactive = new Texture("creditosinactivo.png");
	
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
		
		int exitX = Gdx.graphics.getWidth()/2 - EXIT_BUTTON_WIDTH/2;
		int exitY = EXIT_BUTTON_Y;
		int playX = Gdx.graphics.getWidth()/2 - PLAY_BUTTON_WIDTH/2;
		int playY = PLAY_BUTTON_Y;
		int creditsX = Gdx.graphics.getWidth()/2 - CREDITS_BUTTON_WIDTH/2;
		int creditsY = CREDITS_BUTTON_Y;
		
		pr.batch.draw(gameTitle, (Gdx.graphics.getWidth()/2 - TITLE_WIDTH/2), TITLE_Y, TITLE_WIDTH, TITLE_HEIGHT);
		
		if (hoverButton(playButtonActive, playButtonInactive, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT, playX, playY, 0)) {
			pr.setScreen(new Juego());
			this.dispose();
		} else if (hoverButton(exitButtonActive, exitButtonInactive, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT, exitX, exitY, 1)) {
			Gdx.app.exit();
		} else if (hoverButton(creditsButtonActive, creditsButtonInactive, CREDITS_BUTTON_WIDTH, CREDITS_BUTTON_HEIGHT, creditsX, creditsY, 2)) {
			pr.setScreen(new Creditos(pr));
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
		screenViewport.update(width, height, true);
		
		bgSprite.setSize(width, height);
		
	}

	@Override
	public void pause() {
	} 

	@Override
	public void resume() {	
	}

	@Override
	public void hide() {}

	@Override
	public void dispose() {}

}
