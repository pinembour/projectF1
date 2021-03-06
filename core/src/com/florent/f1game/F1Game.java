package com.florent.f1game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.florent.f1game.screen.MainMenuScreen;


public class F1Game extends Game {
	
	public static final int V_WIDTH = 1280;
	public static final int V_HEIGHT = 720;
	
	
	public SpriteBatch batch;

	
	MainMenuScreen mainMenuScreen;
	
	@Override
	public void create () {
		
		batch = new SpriteBatch();
		this.setScreen(new MainMenuScreen());
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
