package Sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class rect extends Sprite {

	
	public World world;
	public Body b2body;
	
	
	BodyDef bdef;
	FixtureDef fdef;
	
	
	public rect(World world) {
		this.world = world;
		defineRect();
	}
	
	public void defineRect() {
		
		bdef = new BodyDef();
		bdef.type = BodyDef.BodyType.StaticBody;
		bdef.position.set( 1280/2 , 150 );

		PolygonShape shape = new PolygonShape();
		shape.setAsBox(500, 100);

		fdef = new FixtureDef();
		fdef.shape = shape;
		fdef.density = 5;
		
		Body body;
		body = world.createBody(bdef);
		body.createFixture(fdef);
		

		
		shape.dispose();
	}
}
