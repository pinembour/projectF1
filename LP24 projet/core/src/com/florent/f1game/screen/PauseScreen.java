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

public class PauseScreen implements Screen {

F1Game game;
	
	private Stage stage;
	private Skin skin;
	private TextButton buttonResume,buttonRestart,buttonMainMenu;
	private BitmapFont font;
	
	private float buttonScale;
	private float fontScale;
	private int buttonAxeX;
	private int buttonAxeY;
	private float buttonSpacing;
	
	private String textureButtonUp;
	private String textureButtondown;
	
	private int level;
	private GameScreen lastScreen;
	
	public PauseScreen(F1Game game, int level, GameScreen screen) {
		
		this.game = game;
		this.level = level;
		this.lastScreen = screen;
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
		setStage(new Stage());    		// l'ensemble principale
		

		//world.step(GameScreen.step, VELOCITYITERATIONS, POSITIONITERATIONS);
		
		Gdx.input.setInputProcessor(getStage());
		
		setSkin(new Skin());				// bibliothèque d'image
		getSkin().add("up", new Texture(textureButtonUp));
		getSkin().add("down", new Texture(textureButtondown));
		
		font = new BitmapFont(Gdx.files.internal("font/ScifiMovies.fnt"));		//Police d'écriture

		TextButtonStyle textButtonStyle = new TextButtonStyle();		// Style du boutton
		textButtonStyle.up = getSkin().getDrawable("up");
		textButtonStyle.down = getSkin().getDrawable("down");
		textButtonStyle.pressedOffsetX = 1;
		textButtonStyle.pressedOffsetY = -1;
		textButtonStyle.font= font;


		/**************************************************************************************************************/
		/**************************************************************************************************************/
		/**************************************************************************************************************/
		
		/*-------buttonResume------*/
		
		buttonResume = new TextButton("RESUME", textButtonStyle); 		// On creer un bouton avec le style et le text
		buttonResume.addListener(new ClickListener() {
			
			@Override
			public void clicked(InputEvent event, float x, float y) {
				stage.dispose();
				lastScreen.setIsPaused(false);
				lastScreen.show();
				
				
			}
		});
		buttonResume.pad(20); 											// nb of pixel of... je sais pas
		buttonResume.setTransform(true);
		buttonResume.setScale(buttonScale);
		buttonResume.getLabel().setFontScale(fontScale);
		buttonResume.setPosition(buttonAxeX - buttonResume.getWidth()*buttonScale / 2, buttonAxeY);
		
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
		buttonRestart.setPosition(buttonAxeX - buttonRestart.getWidth()*buttonScale / 2, buttonResume.getY() - buttonResume.getHeight() * buttonScale - buttonSpacing);

		/*-------buttonMAIN MENU------*/
		
		buttonMainMenu = new TextButton("MAIN MENU", textButtonStyle);
		buttonMainMenu.addListener(new ClickListener() {
			
			@Override
			public void clicked(InputEvent event, float x, float y) {
				dispose();
				game.setScreen(new MainMenuScreen(game));
			}
		});
		buttonMainMenu.pad(20);
		buttonMainMenu.setTransform(true);
		buttonMainMenu.setScale(buttonScale);
		buttonMainMenu.getLabel().setFontScale(fontScale);
		buttonMainMenu.setPosition(buttonAxeX - buttonMainMenu.getWidth()*buttonScale / 2, buttonRestart.getY() - buttonRestart.getHeight() * buttonScale - buttonSpacing );
		
		/**************************************************************************************************************/
		/**************************************************************************************************************/
		/**************************************************************************************************************/
			
		getStage().addActor(buttonResume);
		getStage().addActor(buttonRestart);			// On ajoute la table au stage
		getStage().addActor(buttonMainMenu);
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		//Gdx.gl.glClearColor(0,0,0,1);   //color
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);  // clear the screen
		
		getStage().act(delta);
		getStage().draw();
		
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


	public Stage getStage() {
		return stage;
	}


	public void setStage(Stage stage) {
		this.stage = stage;
	}


	public Skin getSkin() {
		return skin;
	}


	public void setSkin(Skin skin) {
		this.skin = skin;
	}




}
