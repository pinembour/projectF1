package com.florent.f1game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.florent.f1game.F1Game;
import com.florent.f1game.scenes.Hud;

public class TestScreen implements Screen{

	private F1Game game;
	Texture texture;
	private OrthographicCamera gameCam;
	private Viewport gamePort;
	
	private Hud hud;
	
	
	public TestScreen(F1Game game) {
		this.game = game;
		texture = new Texture("moto shadow.png");
		gameCam = new OrthographicCamera();
		gamePort = new FitViewport(F1Game.V_WIDTH,F1Game.V_HEIGHT,gameCam);
		hud = new Hud(game.batch);
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1,0,0,1);   //color
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);  // clear the screen
		
		
		game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
		hud.stage.draw();
		
		/*
		
		game.batch.setProjectionMatrix(gameCam.combined);
		game.batch.begin();
		game.batch.draw(texture,0,0);
		game.batch.end();
		*/
	}

	@Override
	public void resize(int width, int height) {
		gamePort.update(width, height);
		
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