package com.florent.f1game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.florent.f1game.F1Game;

public class MainMenuScreen implements Screen {
	
	private F1Game game;
	
	
	SpriteBatch batch;
	BitmapFont font ;	
	
	private static GlyphLayout glyphLayout = new GlyphLayout();
	
	private String tNewGame;
	private String tContinue;
	private String tControl;
	
	private int axeX;
	private int continuePositionY;
	private int spacing;
	private float scaleFont;
	
	private Texture metalPlate ;
	
	public MainMenuScreen(F1Game game) {
		
		this.game = game;
		
		
		/*****************************************************************************************************/


		font = new BitmapFont(Gdx.files.internal("font/ScifiMovies.fnt"));
		
		
		tNewGame = "NEW GAME";
		tContinue = "CONTINUE";
		tControl = "CONTROL";
		
		axeX = 1000;
		continuePositionY = 300;
		spacing = 100;
		scaleFont = 0.7f;
		
		
		metalPlate = new Texture ("MetalPlate.jpg");
		
		font.getData().setScale(scaleFont);  // redimension police
		

		
		
		/*****************************************************************************************************/
		
	}
	
	
	

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		
		//Gdx.gl.glClearColor(0,0,0,0);   //color
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);  // clear the screen
		
		game.batch.begin();
		
		
		/*****************************************************************************************************/
		
		glyphLayout.setText(font, tNewGame);
		
	
		font.draw(game.batch, glyphLayout, 
				axeX - glyphLayout.width /2 ,
				Gdx.graphics.getHeight() - continuePositionY);
		
		
		glyphLayout.setText(font, tContinue);
		font.draw(game.batch, tContinue, 
				axeX - glyphLayout.width /2 ,
				Gdx.graphics.getHeight() - continuePositionY-spacing);
		
		
		glyphLayout.setText(font, tControl);
		font.draw(game.batch, tControl, 
				axeX - glyphLayout.width /2 ,
				Gdx.graphics.getHeight() - continuePositionY - 2 * spacing);
		
		/*****************************************************************************************************/
		
		/*
		if(Gdx.input.getX()<= 480 || Gdx.input.getX() >= 800 || Gdx.input.getY() <= 260 || Gdx.input.getY() >= 530  ) {
			game.batch.draw(mainMenu, 0, 0);
		}
		else if(Gdx.input.getY()> 260 && Gdx.input.getY()< maxNewGameY) {
			game.batch.draw(mainMenuNewGame, 0, 0);
		}
		else if(Gdx.input.getY()>= maxNewGameY && Gdx.input.getY()< maxContinueY) {
			game.batch.draw(mainMenuContinue, 0, 0);
		}
		else {
			game.batch.draw(mainMenuControl, 0, 0);
		}
		
		*/
		
		//System.out.println(Gdx.input.getY());
		
		game.batch.end();

		
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
