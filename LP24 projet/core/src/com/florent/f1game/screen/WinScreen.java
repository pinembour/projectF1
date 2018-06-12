package com.florent.f1game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.florent.f1game.F1Game;

public class WinScreen implements Screen{
F1Game game;
	
	private Stage stage;
	private Skin skin;
	private TextButton buttonRestart,buttonContinue;
	private BitmapFont font;
	
	private float buttonScale;
	private float fontScale;
	private int buttonAxeX;
	private int buttonAxeY;
	private float buttonSpacing;
	
	private String textureButtonUp;
	private String textureButtondown;
	
	private int level;
	
	public WinScreen(F1Game game, int level) {
		
		this.game = game;
		this.level = level;
		buttonScale = 0.3f ;
		fontScale = 1.4f;
		buttonAxeX = F1Game.V_WIDTH /2;
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
		
		/*-------buttonRestart------*/
		
		buttonRestart = new TextButton("RESTART", textButtonStyle); 		// On creer un bouton avec le style et le text
		buttonRestart.addListener(new ClickListener() {
			
			@Override
			public void clicked(InputEvent event, float x, float y) {
				dispose();
				game.setScreen(new GameScreen(game , level));
			}
		});
		buttonRestart.pad(20); 											// nb of pixel of... je sais pas
		buttonRestart.setTransform(true);
		buttonRestart.setScale(buttonScale);
		buttonRestart.getLabel().setFontScale(fontScale);
		buttonRestart.setPosition(buttonAxeX - buttonRestart.getWidth()*buttonScale / 2, buttonAxeY);

		/*-------buttonContinue------*/
		
		buttonContinue = new TextButton("CONTINUE", textButtonStyle);
		buttonContinue.addListener(new ClickListener() {
			
			@Override
			public void clicked(InputEvent event, float x, float y) {
				dispose();
				game.setScreen(new MainMenuScreen(game));
			}
		});
		buttonContinue.pad(20);
		buttonContinue.setTransform(true);
		buttonContinue.setScale(buttonScale);
		buttonContinue.getLabel().setFontScale(fontScale);
		buttonContinue.setPosition(buttonAxeX - buttonContinue.getWidth()*buttonScale / 2, buttonAxeY - buttonRestart.getHeight() * buttonScale - buttonSpacing );
		
		/**************************************************************************************************************/
		/**************************************************************************************************************/
		/**************************************************************************************************************/
			
		stage.addActor(buttonRestart);			// On ajoute la table au stage
		stage.addActor(buttonContinue);
		
	}

	@Override
	public void render(float delta) {
		//Gdx.gl.glClearColor(0,0,0,1);   //color
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);  // clear the screen
		
		stage.act(delta);
		stage.draw();
		
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
