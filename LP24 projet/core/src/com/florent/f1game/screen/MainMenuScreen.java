package com.florent.f1game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.florent.f1game.F1Game;

public class MainMenuScreen implements Screen {
	
	private F1Game game;
	
	Texture mainMenu;
	Texture mainMenuNewGame;
	Texture mainMenuContinue ;
	Texture mainMenuControl;
	
	int maxNewGameY;
	int maxContinueY;
	
	
	public MainMenuScreen(F1Game game) {
		
		this.game = game;
		mainMenu = new Texture("F1 Project MainMenu.png");
		mainMenuNewGame = new Texture("F1 Project MainMenu New Game select.png");
		mainMenuContinue = new Texture("F1 Project MainMenu Continue select.png");
		mainMenuControl  = new Texture("F1 Project MainMenu Control select.png");
		
		maxNewGameY = 350;
		maxContinueY = 450;
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(1,1,1,1);   //color
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);  // clear the screen
		
		game.batch.begin();
		
		
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
		
		
		System.out.println(Gdx.input.getY());
		
		game.batch.end();
		
		// TODO Auto-generated method stub
		
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
