package Sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public class Moto extends Sprite {
	
	public World world;
	public Body b2body;
	
	
	public Moto(World world) {
		this.world = world;
		defineMoto();
	}
	
	public void defineMoto() {
		BodyDef bdef = new BodyDef();
		bdef.position.set(50,400);						// cr�ation d'un squelette type
		bdef.type = BodyDef.BodyType.DynamicBody;
		
		
		FixtureDef fdef = new FixtureDef();				// Cr�ation d'une forme
		CircleShape shape = new CircleShape();
		shape.setRadius(15);
		
		fdef.shape = shape;
		
		b2body = world.createBody(bdef);				// cr�ation d'un corp a partir du squelette
		b2body.createFixture(fdef);						// ajout de la forme au corps
	}

}
