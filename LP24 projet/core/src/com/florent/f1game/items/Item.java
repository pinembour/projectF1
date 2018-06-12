package com.florent.f1game.items;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

public abstract class Item {

	protected Body body;
	protected BodyDef bodyDef;
	protected FixtureDef itemFixtureDef;
	protected Shape shape ;
	protected Sprite skin;

	
	/****************************************************************************************************************************/

	public Item(World world, float positionX, float positionY ) {
		this.bodyDef = new BodyDef();
		this.bodyDef.type = BodyType.StaticBody;
		this.bodyDef.position.set(positionX, positionY);

		
		itemFixtureDef = new FixtureDef();
		makeShape();
		itemFixtureDef.shape = shape;
		itemFixtureDef.isSensor = true;
		makeUserData();
		//System.out.println(this.shape.getRadius());
		this.body = world.createBody(bodyDef);
		this.body.createFixture(itemFixtureDef).setUserData(makeUserData());;
		
		makeSprite();

	}
	
	public Body getBody() {
		return this.body;
	}
	public Sprite getSprite() {
		return this.skin;
	}
	
	public abstract void makeShape();
	public abstract void makeSprite();
	public abstract String makeUserData();
	
	
	
}
