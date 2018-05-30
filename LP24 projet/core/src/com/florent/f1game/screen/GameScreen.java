package com.florent.f1game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.florent.f1game.F1Game;
import com.florent.f1game.scenes.Hud;

import Sprites.FirstMap;
import Sprites.Ground;
import Sprites.Moto;

public class GameScreen implements Screen {

	
	private F1Game game;
	private Stage stage;
	private Skin skin;
	
	private World world;
	private Box2DDebugRenderer b2dr;
	
	private OrthographicCamera gamecam;
	private Viewport gamePort;
	private Hud hud;
	
	private String vehicles;
	
	private int compteurverticies = 0;
	
	public GameScreen(F1Game game) {
		
		this.game = game;
		//create cam used to follow the vehicle through cam world
		gamecam = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		
		
		gamePort = new FitViewport(F1Game.V_WIDTH, F1Game.V_HEIGHT, gamecam);
		
		hud = new Hud(game.batch);
		
		
		gamecam.position.set(gamePort.getWorldWidth()/2 , gamePort.getWorldHeight()/2, 0);

		
		//Box2d variables
		world = new World(new Vector2(0,-50),	 true);	
		b2dr = new Box2DDebugRenderer();
		
		
		
		Moto moto = new Moto(world);
		//Ground gr = new Ground(world);
		FirstMap fr = new FirstMap(world);
		
		
		//vehicles = "moto.png";
		
		//skin.add("moto", vehicles);
		

		
	}
	
	
	
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	public void makeMapCollision(float dt) {

		if(Gdx.input.justTouched()) {
			System.out.println("vertices["+ compteurverticies +"] = new Vector2("+ Gdx.input.getX() +"f  , "+ (F1Game.V_HEIGHT - Gdx.input.getY())+"f  );");
			compteurverticies++;
		}
	}
	
	public void handleInput(float dt) {
		

	}
	
	public void update(float dt) {
		
		//handleInput(dt);
		makeMapCollision(dt);
		world.step(1/60f , 6 , 2);
		gamecam.update();
		//renderer.setView(gamecam);
	}
	
	@Override
	public void render(float delta) {

		
		update(delta);
		
		//Clear the game screen
		Gdx.gl.glClearColor(0,0,0,1);   //color
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);  // clear the screen
		
		//renderer.render();    //pour map
		
		
		// render debug collision
		b2dr.render(world, gamecam.combined);
		
		game.batch.setProjectionMatrix(gamecam.combined);
		
		game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
		//hud.stage.draw();
		
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
