package com.florent.f1game.items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.World;
import com.florent.f1game.F1Game;

public class Coin extends Item {


	
	public Coin(World world, float positionX, float positionY) {
		super(world, positionX, positionY);
	}


	@Override
	public void makeShape() {
		float size = 1;
		this.shape = new CircleShape();
		this.shape.setRadius((size/2) * F1Game.PPM);
		System.out.println(size);
		
	}


	@Override
	public void makeSprite() {
		this.skin = new Sprite(new Texture("item/CoinMario.png"));
		float scale = this.shape.getRadius() / skin.getHeight();
		System.out.println(scale);
		this.skin.setScale(scale);
	}


	@Override
	public String makeUserData() {
		return "Coin";
	}
}
