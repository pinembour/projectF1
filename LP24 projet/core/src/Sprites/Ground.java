package Sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Ground extends Sprite {

	private World world;
	private Body b2body;
	
	
	private BodyDef bdef;
	private FixtureDef fdef;
	
	public Ground(World world) {
		this.world = world;
		defineGround3();
	}
	
	public void defineGround() {
		/*** Enchainement de rectangle à la suite */
		
		bdef = new BodyDef();
		bdef.position.set(0,0);								// création d'un squelette type
		bdef.type = BodyDef.BodyType.StaticBody;
		
		for(int i = 0 ; i<1000; i += 50) {
			bdef.position.set(i*2,0);
			fdef = new FixtureDef();						// Création d'une forme
			PolygonShape shape = new PolygonShape();
			shape.setAsBox(50, 100+(i/20));
			
			fdef.shape = shape;
			
			b2body = world.createBody(bdef);				// création d'un corp a partir du squelette
			b2body.createFixture(fdef);						// ajout de la forme au corps
		}
		
	}
	
	
	public void defineGround2() {
		Vector2[] vertices = new Vector2[8];

	    vertices[0] = new Vector2(0f  , 100f  );
	    vertices[1] = new Vector2(90f , 40f  );
	    vertices[2] = new Vector2(150f , 268f);
	    vertices[3] = new Vector2(400f , 341f);
	    vertices[4] = new Vector2(500f , 322f);
	    vertices[5] = new Vector2(600f , 398f);     
	    vertices[6] = new Vector2(800f , 457f);
	    vertices[7] = new Vector2(40f , -20f);
	    PolygonShape shape = new PolygonShape();
	    shape.set(vertices);
	    
	    
	    bdef = new BodyDef();
		bdef.position.set(0,0);								// création d'un squelette type
		bdef.type = BodyDef.BodyType.StaticBody;
	
		fdef = new FixtureDef();						// Création d'une forme

		
		fdef.shape = shape;
		
		b2body = world.createBody(bdef);				// création d'un corp a partir du squelette
		b2body.createFixture(fdef);						// ajout de la forme au corps
		
		
		/*** GROS PROBLEME, On ne peut faire que des quadrilatères */
		
	}
	
	public void defineGround3() {
		
		int nbverticies = 7;
		
		Vector2[] vertices = new Vector2[nbverticies];
		
	    vertices[0] = new Vector2(10f  , 500f  );
	    vertices[1] = new Vector2(200f , 600f  );
	    vertices[2] = new Vector2(400f, 250f);  
	    vertices[3] = new Vector2(600f, 200f );
	    vertices[4] = new Vector2(800f , 500f);
	    vertices[5] = new Vector2(1000f , 450f);
	    vertices[6] = new Vector2(1200f , 450f);
	    
	    EdgeShape chemin = new EdgeShape();
	    
	    for(int i = 0; i < nbverticies-1 ; i++) {
	    	
	    	chemin.set(vertices[i],vertices[i+1]);	
	    	
	    	bdef = new BodyDef();
			bdef.type = BodyDef.BodyType.StaticBody;
		
			fdef = new FixtureDef();						// Création d'une forme
			fdef.shape = chemin;
			
			b2body = world.createBody(bdef);				// création d'un corp a partir du squelette
			b2body.createFixture(fdef);						// ajout de la forme au corps
		
	    }  
	}
	
	
	
}
