package Sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public class FirstMap extends Sprite {

	private World world;
	private Body b2body;
	
	
	private BodyDef bdef;
	private FixtureDef fdef;
	
	
	public FirstMap(World world) {
		this.world = world;
		definefirstMap();
	}
	
	
	public void definefirstMap() {
		
		int nbverticies = 23;
		
		Vector2[] vertices = new Vector2[nbverticies];
		
		vertices[0] = new Vector2(74f  , 550f  );
		vertices[1] = new Vector2(108f  , 579f  );
		vertices[2] = new Vector2(142f  , 523f  );
		vertices[3] = new Vector2(158f  , 494f  );
		vertices[4] = new Vector2(173f  , 476f  );
		vertices[5] = new Vector2(221f  , 447f  );
		vertices[6] = new Vector2(296f  , 437f  );
		vertices[7] = new Vector2(353f  , 435f  );
		vertices[8] = new Vector2(398f  , 435f  );
		vertices[9] = new Vector2(471f  , 438f  );
		vertices[10] = new Vector2(530f  , 435f  );
		vertices[11] = new Vector2(563f  , 413f  );
		vertices[12] = new Vector2(593f  , 380f  );
		vertices[13] = new Vector2(616f  , 342f  );
		vertices[14] = new Vector2(647f  , 305f  );
		vertices[15] = new Vector2(709f  , 280f  );
		vertices[16] = new Vector2(750f  , 276f  );
		vertices[17] = new Vector2(818f  , 286f  );
		vertices[18] = new Vector2(885f  , 296f  );
		vertices[19] = new Vector2(941f  , 288f  );
		vertices[20] = new Vector2(975f  , 272f  );
		vertices[21] = new Vector2(1010f  , 238f  );
		vertices[22] = new Vector2(1070f  , 197f  );
	    
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

