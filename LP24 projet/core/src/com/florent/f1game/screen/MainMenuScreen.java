package com.florent.f1game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.florent.f1game.F1Game;

public class MainMenuScreen implements Screen{

	F1Game game;
	
	private Stage stage;
	private Skin skin;
	private TextButton buttonPlay,buttonContinue, buttonControl, buttonExit;
	private BitmapFont font;
	
	private float buttonScale;
	private float fontScale;
	private int buttonAxeX;
	private int buttonAxeY;
	private float buttonSpacing;
	
	private String textureButtonUp;
	private String textureButtondown;
	
	
	public MainMenuScreen(F1Game game) {
		
		this.game = game;
		
		buttonScale = 0.3f ;
		fontScale = 1.4f;
		buttonAxeX = 2* F1Game.V_WIDTH /3;
		buttonAxeY = 2*F1Game.V_HEIGHT / 3;
		buttonSpacing = 10;
		
		textureButtonUp = "boutons_rect_up.png";
		textureButtondown = "boutons_rect_down.png";
	}
	
	
	@Override
	public void show() {
		
		stage = new Stage();    		// l'ensemble principale
		
		Gdx.input.setInputProcessor(stage);
		
		skin = new Skin();				// bibliothèque d'image
		skin.add("up", new Texture(textureButtonUp));
		skin.add("down", new Texture(textureButtondown));
		
		font = new BitmapFont(Gdx.files.internal("font/ScifiMovies.fnt"));		//Police d'écriture

		TextButtonStyle textButtonStyle = new TextButtonStyle();		// Style du boutton
		textButtonStyle.up = skin.getDrawable("up");
		textButtonStyle.down = skin.getDrawable("down");
		textButtonStyle.pressedOffsetX = 1;
		textButtonStyle.pressedOffsetY = -1;
		textButtonStyle.font= font;


		/**************************************************************************************************************/
		/**************************************************************************************************************/
		/**************************************************************************************************************/
		
		/*-------buttonPlay------*/
		
		buttonPlay = new TextButton("NEW GAME", textButtonStyle); 		// On creer un bouton avec le style et le text
		buttonPlay.addListener(new ClickListener() {
			
			@Override
			public void clicked(InputEvent event, float x, float y) {
				dispose();
				game.setScreen(new GameScreen(game , 1));
			}
		});
		buttonPlay.pad(20); 											// nb of pixel of... je sais pas
		buttonPlay.setTransform(true);
		buttonPlay.setScale(buttonScale);
		buttonPlay.getLabel().setFontScale(fontScale);
		buttonPlay.setPosition(buttonAxeX, buttonAxeY);

		/*-------buttonContinue------*/
		
		buttonContinue = new TextButton("CONTINUE", textButtonStyle);
		buttonContinue.addListener(new ClickListener() {
			
			@Override
			public void clicked(InputEvent event, float x, float y) {
				dispose();
				game.setScreen(new GameScreen(game,2));
			}
		});
		buttonContinue.pad(20);
		buttonContinue.setTransform(true);
		buttonContinue.setScale(buttonScale);
		buttonContinue.getLabel().setFontScale(fontScale);
		buttonContinue.setPosition(buttonAxeX, buttonAxeY - buttonPlay.getHeight() * buttonScale - buttonSpacing );
		
		
		/*-------buttonControl------*/
		
		buttonControl = new TextButton("CONTROL", textButtonStyle);
		buttonControl.addListener(new ClickListener() {
			
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO
				game.setScreen(new WinScreen(game,2));

			}
		});
		buttonControl.pad(20);
		buttonControl.setTransform(true);
		buttonControl.setScale(buttonScale);
		buttonControl.getLabel().setFontScale(fontScale);
		buttonControl.setPosition(buttonAxeX, buttonContinue.getY() - buttonContinue.getHeight()* buttonScale - buttonSpacing );
		
		
		/*-------buttonExit------*/
		
		buttonExit = new TextButton("EXIT", textButtonStyle);
		buttonExit.addListener(new ClickListener() {
			
			@Override
			public void clicked(InputEvent event, float x, float y) {
				dispose();
				Gdx.app.exit();
			}
		});
		buttonExit.pad(20);
		buttonExit.setTransform(true);
		buttonExit.setScale(buttonScale);
		buttonExit.getLabel().setFontScale(fontScale);
		buttonExit.setPosition(buttonAxeX, buttonControl.getY() - buttonControl.getHeight()* buttonScale - buttonSpacing );

		/**************************************************************************************************************/
		/**************************************************************************************************************/
		/**************************************************************************************************************/
			
		stage.addActor(buttonPlay);			// On ajoute la table au stage
		stage.addActor(buttonContinue);
		stage.addActor(buttonControl);
		stage.addActor(buttonExit);		
		
	}

	
	
	
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0,0,0,1);   //color
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);  // clear the screen
		
		stage.act(delta);
		stage.draw();
		
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
		stage.dispose();
		
	}

}
