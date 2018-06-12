package com.florent.f1game.map;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public abstract class Abstract_Map extends Sprite{

	protected World world;
	protected Body b2body;
	
	
	protected BodyDef bdef;
	protected FixtureDef fdef;
	

	protected Sprite sp;
	protected Vector2 spawn;
	
	protected int nbverticies;
	protected Vector2[] vertices;
	
	/****************************************************************/
	
	public Abstract_Map(World world,Sprite sprite) {
		this.world = world;

		setSp(sprite);
		
		sp.setPosition(0, 0);
		defineMap();
		setMap();
	}
	
	
	public void setMap() {
		
		EdgeShape chemin = new EdgeShape();
	    
	    for(int i = 0; i < nbverticies-1 ; i++) {
	    	
	    	chemin.set(vertices[i],vertices[i+1]);	
	    	
	    	bdef = new BodyDef();
	    	
			bdef.type = BodyDef.BodyType.StaticBody;
		
			fdef = new FixtureDef();						// Création d'une forme
			fdef.density = 0.9f;
			fdef.friction = 0.5f;
			fdef.restitution = 0;
			fdef.shape = chemin;
			
			b2body = world.createBody(bdef);				// création d'un corp a partir du squelette
			b2body.createFixture(fdef);						// ajout de la forme au corps
		
	    }  
		
	}
	
	//-----------------------------------------
	
	public Sprite getSp() {
		return sp;
	}

	//-----------------------------------------

	public void setSp(Sprite sp) {
		this.sp = sp;
	}
	
	//-----------------------------------------
	
	public Vector2 getSpawn() {
		return spawn;
	}

	//-----------------------------------------

	public void setspawn(Vector2 spawn) {
		this.spawn = spawn;
	}
	//-----------------------------------------


	public abstract  void defineMap();
	
}
