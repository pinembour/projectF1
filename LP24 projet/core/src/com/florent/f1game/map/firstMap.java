package com.florent.f1game.map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class firstMap extends Abstract_Map {

	public firstMap(World world) {
		super(world,new Sprite(new Texture("map/map1_image.png")));
		
		this.spawn = new Vector2(80,710);
	}

	@Override
	public void defineMap() {

		
		this.nbverticies = 22;
		
		this.vertices = new Vector2[nbverticies];
		
		vertices[0] = new Vector2(1.0f  , 633.0f  );
		vertices[1] = new Vector2(1727.0f  , 631.0f  );
		vertices[2] = new Vector2(2147.0f  , 801.0f  );
		vertices[3] = new Vector2(2469.0f  , 627.0f  );
		vertices[4] = new Vector2(2808.0f  , 536.0f  );
		vertices[5] = new Vector2(3074.0f  , 370.0f  );
		vertices[6] = new Vector2(3524.0f  , 360.0f  );
		vertices[7] = new Vector2(4157.0f  , 522.0f  );
		vertices[8] = new Vector2(4470.0f  , 527.0f  );
		vertices[9] = new Vector2(5398.0f  , 631.0f  );
		vertices[10] = new Vector2(5996.0f  , 785.0f  );
		vertices[11] = new Vector2(6873.0f  , 842.0f  );
		vertices[12] = new Vector2(7543.0f  , 748.0f  );
		vertices[13] = new Vector2(8647.0f  , 944.0f  );
		vertices[14] = new Vector2(8685.0f  , 815.0f  );
		vertices[15] = new Vector2(8551.0f  , 722.0f  );
		vertices[16] = new Vector2(8581.0f  , 445.0f  );
		vertices[17] = new Vector2(8690.0f  , 247.0f  );
		vertices[18] = new Vector2(9202.0f  , 176.0f  );
		vertices[19] = new Vector2(9966.0f  , 230.0f  );
		vertices[20] = new Vector2(10795.0f  , 214.0f  );
		vertices[21] = new Vector2(10802.0f  , 671.0f  );

	
	}

}
