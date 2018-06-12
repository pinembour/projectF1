package com.florent.f1game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.florent.f1game.F1Game;
import com.florent.f1game.items.Coin;
import com.florent.f1game.items.Item;
import com.florent.f1game.map.Abstract_Map;
import com.florent.f1game.map.SecondMap;
import com.florent.f1game.map.firstMap;
import com.florent.f1game.scenes.Hud;
import com.florent.f1game.vehicle.Abstract_Car;
import com.florent.f1game.vehicle.RedCar;

public class GameScreen implements Screen, ContactListener {

	
	private F1Game game;

	private World world;
	private PauseScreen pause;
	private GameOverScreen gameOver;
	private Box2DDebugRenderer b2dr;
	private OrthographicCamera gamecam;
	
	
	private Hud hud;
	
	private int compteurverticies = 0;
	int vitesse = 10;
	
	private Abstract_Map map;
	private Abstract_Car car;
	private int level;
	private boolean isDead, isPaused ;
	private float step ;
	
	private Item coin;

	private static final int VELOCITYITERATIONS = 8, POSITIONITERATIONS = 3;
	
	
	public GameScreen(F1Game game, int level) {
		
		this.game = game;	
		this.setLevel(level);
		this.step = 1/60f;
		//create cam used to follow the vehicle through cam world
		gamecam = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		
		//Box2d variables
		world = new World(new Vector2(0, -9.81f *15 ),true);	
		world.setContactListener(this);
		
		pause = new PauseScreen(game, level, this);
		gameOver = new GameOverScreen(game, level);
		
		b2dr = new Box2DDebugRenderer();
		hud = new Hud(game.batch);
		
		
		//map
		if (level == 1) {
			map = new firstMap(world);
		}
		if (level == 2)
		{
			map = new SecondMap(world);
		}
		
		//item
		coin = new Coin(world, map.getSpawn().x+300, map.getSpawn().y+40);

		// Car
		FixtureDef fixtureDef = new FixtureDef(), wheelFixtureDef = new FixtureDef();
		fixtureDef.density = 4;
		fixtureDef.friction = 0.4f;
		fixtureDef.restitution = 0.3f;
		
		wheelFixtureDef.density = fixtureDef.density * 1.5f; 
		wheelFixtureDef.friction = 30;
		wheelFixtureDef.restitution = 0.4f;   //rebond
		
		car = new RedCar(world,fixtureDef,wheelFixtureDef,map.getSpawn().x,map.getSpawn().y, 144 ,72);
		
		

	}

	
	
	@Override
	public void render(float delta) {

		
		update(delta);
		
		//Clear the game screen
		Gdx.gl.glClearColor(1,1,1,1);   //color
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);  // clear the screen

		world.step(step, VELOCITYITERATIONS, POSITIONITERATIONS);
		
		gamecam.position.set(car.getChassis().getPosition().x, car.getChassis().getPosition().y, 0);
		gamecam.update();
		
		car.getSp_VehicleBody().setPosition(car.getChassis().getPosition().x - car.getSp_VehicleBody().getWidth()/2 ,car.getChassis().getPosition().y - car.getSp_VehicleBody().getHeight()/2);
		car.getSp_VehicleBody().setRotation(car.getChassis().getAngle()* MathUtils.radiansToDegrees);
		
		car.getSp_LeftWheel().setPosition(car.getLeftWheel().getPosition().x - car.getSp_LeftWheel().getWidth()/2, car.getLeftWheel().getPosition().y - car.getSp_LeftWheel().getHeight()/2);
		car.getSp_LeftWheel().setRotation(car.getLeftWheel().getAngle()* MathUtils.radiansToDegrees);
		
		car.getSp_RightWheel().setPosition(car.getRightWheel().getPosition().x - car.getSp_RightWheel().getWidth()/2, car.getRightWheel().getPosition().y - car.getSp_RightWheel().getHeight()/2);
		car.getSp_RightWheel().setRotation(car.getRightWheel().getAngle()* MathUtils.radiansToDegrees);
		
		coin.getSprite().setPosition(coin.getBody().getPosition().x - coin.getSprite().getWidth()/2, coin.getBody().getPosition().y- coin.getSprite().getHeight()/2);
		
		game.batch.setProjectionMatrix(gamecam.combined);
		
		
		game.batch.begin();
		map.getSp().draw(game.batch);
		car.getSp_LeftWheel().draw(game.batch);
		car.getSp_RightWheel().draw(game.batch);
		car.getSp_VehicleBody().draw(game.batch);
		coin.getSprite().draw(game.batch);
		game.batch.end();
		
		
		// render debug collision
		b2dr.render(world, gamecam.combined);
		
		hud.stage.draw();
		
		if (isDead) {

			gameOver.render(delta);
		}
		
		if (isPaused) {
			 
			pause.render(delta);
		}


	}
	
	
	@Override
	public void show() {
		
		if (!isPaused) {

			step = 1/60f;
			Gdx.input.setInputProcessor(new InputMultiplexer(new InputAdapter() {
				@Override
				public boolean keyDown(int keycode) {
					switch(keycode) {
					case Keys.ESCAPE:
						
						isPaused = true;
						show();						
						
						break;
						

					}
					return false;
				}
	
				@Override
				public boolean scrolled(int amount) {
					gamecam.zoom += amount / 25f;
					return true;
				}
			},car));
			
	
			gamecam.position.set(car.getChassis().getPosition().x, car.getChassis().getPosition().y, 0);
	
		}
		if (isPaused) {

			step = 0;
			pause.show();
		}
		if(isDead) {


			gameOver.show();
		}
		
		
		
		

	}


	/**********************************************/
	
	public void update(float dt) {
		
		//makeMapCollision(dt);
		

		world.step(step , 6 , 2);
		gamecam.update();
		


	}
	
	public void makeMapCollision(float dt) {

		if(Gdx.input.justTouched()) {
			
			System.out.println("vertices["+ compteurverticies +"] = new Vector2("+ (Gdx.input.getX() + gamecam.position.x - F1Game.V_WIDTH/2)  +"f  , "+ (gamecam.position.y + F1Game.V_HEIGHT/2   - Gdx.input.getY()  )+"f  );");
			compteurverticies++;
		}
		
		if(Gdx.input.isKeyPressed(Keys.DOWN)) {
			gamecam.translate(0,-vitesse);
		}
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			gamecam.translate(-vitesse,0);
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			gamecam.translate(vitesse,0);
		}
		if(Gdx.input.isKeyPressed(Keys.UP)) {
			gamecam.translate(0,vitesse);
		}
	}
	/**********************************************/



	@Override
	public void resize(int width, int height) {
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
		dispose();
		
	}

	@Override
	public void dispose() {
		map.getSp().getTexture().dispose();
		car.getSp_VehicleBody().getTexture().dispose();
		car.getSp_RightWheel().getTexture().dispose();
		car.getSp_LeftWheel().getTexture().dispose();

		// world.dispose();

		
	}



	/*******************************************************************/
	/*******************************************************************/
	/*******************************************************************/

	
	@Override
	public void beginContact(Contact contact) {
		// TODO Auto-generated method stub
		if(contact.getFixtureA().getUserData()=="head" || contact.getFixtureB().getUserData()=="head") {
			
			if(contact.getFixtureA().getUserData() != "Coin" && contact.getFixtureB().getUserData() != "Coin") {
				//System.out.println("ça marche");
				
				this.isDead = true;
				
				show();
			}
			

		}
	}



	@Override
	public void endContact(Contact contact) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub
		
	}
	/*******************************************************************/
	/*******************************************************************/
	/*******************************************************************/
	
	
	public void setIsPaused(boolean bool) {
		this.isPaused = bool;
	}



	public int getLevel() {
		return level;
	}



	public void setLevel(int level) {
		this.level = level;
	}
}
