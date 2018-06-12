package com.florent.f1game.screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.florent.f1game.vehicle.RedCar;

public class playtest implements Screen {

		private World world;
		private Box2DDebugRenderer debugRenderer;
		private SpriteBatch batch;
		private OrthographicCamera camera;

		private final float TIMESTEP = 1 / 60f;
		private final int VELOCITYITERATIONS = 8, POSITIONITERATIONS = 3;

		private RedCar car;


		@Override
		public void render(float delta) {
			Gdx.gl.glClearColor(0, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

			world.step(TIMESTEP, VELOCITYITERATIONS, POSITIONITERATIONS);

			camera.position.set(car.getChassis().getPosition().x, car.getChassis().getPosition().y, 0);
			camera.update();

			batch.setProjectionMatrix(camera.combined);


			debugRenderer.render(world, camera.combined);
		}

		@Override
		public void resize(int width, int height) {
			camera.viewportWidth = width / 25;
			camera.viewportHeight = height / 25;
		}

		@Override
		public void show() {
			world = new World(new Vector2(0, -9.81f), true);
			debugRenderer = new Box2DDebugRenderer();
			batch = new SpriteBatch();

			camera = new OrthographicCamera();

			BodyDef bodyDef = new BodyDef();
			FixtureDef fixtureDef = new FixtureDef(), wheelFixtureDef = new FixtureDef();

			// car
			fixtureDef.density = 5;
			fixtureDef.friction = .4f;
			fixtureDef.restitution = .3f;

			wheelFixtureDef.density = fixtureDef.density * 1.5f;
			wheelFixtureDef.friction = 50;
			wheelFixtureDef.restitution = .4f;

			car = new RedCar(world, fixtureDef, wheelFixtureDef, 0, 3, 3, 1.25f);

			Gdx.input.setInputProcessor(new InputMultiplexer(new InputAdapter() {

				@Override
				public boolean keyDown(int keycode) {
					switch(keycode) {
					case Keys.ESCAPE:
						//((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenuScreen());
						break;
					}
					return false;
				}

				@Override
				public boolean scrolled(int amount) {
					camera.zoom += amount / 25f;
					return true;
				}

			}, car));

			// GROUND
			// body definition
			bodyDef.type = BodyType.StaticBody;
			bodyDef.position.set(0, 0);

			// ground shape
			ChainShape groundShape = new ChainShape();
			groundShape.createChain(new Vector2[] {new Vector2(-50, 0), new Vector2(50, 0)});

			// fixture definition
			fixtureDef.shape = groundShape;
			fixtureDef.friction = .5f;
			fixtureDef.restitution = 0;

			world.createBody(bodyDef).createFixture(fixtureDef);

			groundShape.dispose();
		}

		@Override
		public void hide() {
			dispose();
		}

		@Override
		public void pause() {
		}

		@Override
		public void resume() {
		}

		@Override
		public void dispose() {
			world.dispose();
			debugRenderer.dispose();
		}
}

