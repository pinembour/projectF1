package com.florent.f1game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.florent.f1game.F1Game;

public class MainMenuScreen implements Screen{

	private F1Game game;
	Texture texture;
	
	
	public MainMenuScreen(F1Game game) {
		this.game = game;
		texture = new Texture("moto shadow.png");
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1,0,0,1);   //color
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);  // clear the screen
		
		
		game.batch.begin();
		game.batch.draw(texture,0,0);
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