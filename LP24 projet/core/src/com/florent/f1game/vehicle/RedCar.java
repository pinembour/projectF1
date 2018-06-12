package com.florent.f1game.vehicle;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public class RedCar extends Abstract_Car {
	
	public RedCar(World world, FixtureDef chassisFixtureDef, FixtureDef wheelFixtureDef, 
			float x, float y, 
			float width,float height) {
		

		super(world, chassisFixtureDef, wheelFixtureDef,
				new Vector2(-width / 2 + width/10   , - height / 2  ),
				new Vector2((width /3 ) + width/10  , - height / 2 ),
				x, y, 
				width, height );
		
		// sprites
		setSp_VehicleBody(new Sprite(new Texture("vehicles/moto_Rouge_image.png")));
		sp_VehicleBody.setScale((width + height /3.5f ) / sp_VehicleBody.getWidth()) ;
		
		sp_LeftWheel = new Sprite(new Texture("roue/roue_image.png"));
		sp_RightWheel = new Sprite(sp_LeftWheel.getTexture());
		
		float scale = radiusWheel/(sp_LeftWheel.getHeight()+15);
		sp_LeftWheel.scale(scale);
		sp_RightWheel.scale(scale);
		
	}
	
}



