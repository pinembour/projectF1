package com.florent.f1game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.florent.f1game.screen.MainMenuScreen;

public class F1Game extends Game {
	
	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT = 200;
	
	
	public SpriteBatch batch;

	
	MainMenuScreen mainMenuScreen;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		setScreen(new MainMenuScreen(this));
	}
	
	@Override
	public void render () {
		super.render(); 
	}
	
	@Override
	public void dispose () {
		//batch.dispose();
		//img.dispose();
	}
}
