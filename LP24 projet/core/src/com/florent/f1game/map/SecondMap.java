package com.florent.f1game.map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class SecondMap extends Abstract_Map {

	
	public SecondMap(World world) {
		
		super(world,new Sprite(new Texture("map/map 2.png")));
		this.spawn = new Vector2(80,450 );
		
		
	}

	public void defineMap() {
		
		this.nbverticies = 134;
		
		this.vertices = new Vector2[nbverticies];
		
		vertices[0] = new Vector2(6.0f  , 361f  );
		vertices[1] = new Vector2(9.0f  , 361f  );
		vertices[2] = new Vector2(14.0f  , 361f  );
		vertices[3] = new Vector2(17.0f  , 361f  );
		vertices[4] = new Vector2(22.0f  , 361f  );
		vertices[5] = new Vector2(27.0f  , 361f  );
		vertices[6] = new Vector2(32.0f  , 361f  );
		vertices[7] = new Vector2(36.0f  , 361f  );
		vertices[8] = new Vector2(40.0f  , 361f  );
		vertices[9] = new Vector2(44.0f  , 361f  );
		vertices[10] = new Vector2(49.0f  , 361f  );
		vertices[11] = new Vector2(54.0f  , 361f  );
		vertices[12] = new Vector2(59.0f  , 361f  );
		vertices[13] = new Vector2(65.0f  , 361f  );
		vertices[14] = new Vector2(70.0f  , 361f  );
		vertices[15] = new Vector2(75.0f  , 361f  );
		vertices[16] = new Vector2(80.0f  , 361f  );
		vertices[17] = new Vector2(85.0f  , 361f  );
		vertices[18] = new Vector2(90.0f  , 361f  );
		vertices[19] = new Vector2(94.0f  , 361f  );
		vertices[20] = new Vector2(99.0f  , 361f  );
		vertices[21] = new Vector2(103.0f  , 361f  );
		vertices[22] = new Vector2(107.0f  , 361f  );
		vertices[23] = new Vector2(112.0f  , 361f  );
		vertices[24] = new Vector2(115.0f  , 361f  );
		vertices[25] = new Vector2(119.0f  , 361f  );
		vertices[26] = new Vector2(124.0f  , 361f  );
		vertices[27] = new Vector2(128.0f  , 361f  );
		vertices[28] = new Vector2(133.0f  , 361f  );
		vertices[29] = new Vector2(138.0f  , 361f  );
		vertices[30] = new Vector2(142.0f  , 361f  );
		vertices[31] = new Vector2(147.0f  , 361f  );
		vertices[32] = new Vector2(151.0f  , 361f  );
		vertices[33] = new Vector2(156.0f  , 361f  );
		vertices[34] = new Vector2(160.0f  , 361f  );
		vertices[35] = new Vector2(165.0f  , 361f  );
		vertices[36] = new Vector2(171.0f  , 361f  );
		vertices[37] = new Vector2(176.0f  , 361f  );
		vertices[38] = new Vector2(181.0f  , 361f  );
		vertices[39] = new Vector2(186.0f  , 361f  );
		vertices[40] = new Vector2(190.0f  , 361f  );
		vertices[41] = new Vector2(195.0f  , 361f  );
		vertices[42] = new Vector2(200.0f  , 361f  );
		vertices[43] = new Vector2(205.0f  , 361f  );
		vertices[44] = new Vector2(210.0f  , 361f  );
		vertices[45] = new Vector2(215.0f  , 361f  );
		vertices[46] = new Vector2(220.0f  , 361f  );
		vertices[47] = new Vector2(225.0f  , 361f  );
		vertices[48] = new Vector2(230.0f  , 361f  );
		vertices[49] = new Vector2(235.0f  , 361f  );
		vertices[50] = new Vector2(240.0f  , 361f  );
		vertices[51] = new Vector2(247.0f  , 360f  );
		vertices[52] = new Vector2(253.0f  , 360f  );
		vertices[53] = new Vector2(260.0f  , 358f  );
		vertices[54] = new Vector2(267.0f  , 353f  );
		vertices[55] = new Vector2(274.0f  , 352f  );
		vertices[56] = new Vector2(281.0f  , 347f  );
		vertices[57] = new Vector2(290.0f  , 343f  );
		vertices[58] = new Vector2(297.0f  , 338f  );
		vertices[59] = new Vector2(302.0f  , 334f  );
		vertices[60] = new Vector2(307.0f  , 333f  );
		vertices[61] = new Vector2(314.0f  , 332f  );
		vertices[62] = new Vector2(328.0f  , 327f  );
		vertices[63] = new Vector2(334.0f  , 327f  );
		vertices[64] = new Vector2(344.0f  , 326f  );
		vertices[65] = new Vector2(350.0f  , 326f  );
		vertices[66] = new Vector2(357.0f  , 327f  );
		vertices[67] = new Vector2(368.0f  , 338f  );
		vertices[68] = new Vector2(374.0f  , 352f  );
		vertices[69] = new Vector2(380.0f  , 363f  );
		vertices[70] = new Vector2(388.0f  , 368f  );
		vertices[71] = new Vector2(400.0f  , 380f  );
		vertices[72] = new Vector2(407.0f  , 386f  );
		vertices[73] = new Vector2(416.0f  , 396f  );
		vertices[74] = new Vector2(427.0f  , 408f  );
		vertices[75] = new Vector2(441.0f  , 415f  );
		vertices[76] = new Vector2(458.0f  , 419f  );
		vertices[77] = new Vector2(473.0f  , 421f  );
		vertices[78] = new Vector2(487.0f  , 421f  );
		vertices[79] = new Vector2(497.0f  , 418f  );
		vertices[80] = new Vector2(504.0f  , 410f  );
		vertices[81] = new Vector2(511.0f  , 399f  );
		vertices[82] = new Vector2(521.0f  , 388f  );
		vertices[83] = new Vector2(534.0f  , 367f  );
		vertices[84] = new Vector2(551.0f  , 339f  );
		vertices[85] = new Vector2(564.0f  , 315f  );
		vertices[86] = new Vector2(566.0f  , 290f  );
		vertices[87] = new Vector2(571.0f  , 257f  );
		vertices[88] = new Vector2(586.0f  , 243f  );
		vertices[89] = new Vector2(604.0f  , 238f  );
		vertices[90] = new Vector2(639.0f  , 230f  );
		vertices[91] = new Vector2(671.0f  , 236f  );
		vertices[92] = new Vector2(714.0f  , 234f  );
		vertices[93] = new Vector2(747.0f  , 236f  );
		vertices[94] = new Vector2(790.0f  , 241f  );
		vertices[95] = new Vector2(817.0f  , 264f  );
		vertices[96] = new Vector2(838.0f  , 303f  );
		vertices[97] = new Vector2(858.0f  , 323f  );
		vertices[98] = new Vector2(899.0f  , 340f  );
		vertices[99] = new Vector2(939.0f  , 350f  );
		vertices[100] = new Vector2(962.0f  , 371f  );
		vertices[101] = new Vector2(982.0f  , 384f  );
		vertices[102] = new Vector2(1013.0f  , 386f  );
		vertices[103] = new Vector2(1039.0f  , 366f  );
		vertices[104] = new Vector2(1058.0f  , 337f  );
		vertices[105] = new Vector2(1090.0f  , 324f  );
		vertices[106] = new Vector2(1128.0f  , 327f  );
		vertices[107] = new Vector2(1157.0f  , 328f  );
		vertices[108] = new Vector2(1183.0f  , 309f  );
		vertices[109] = new Vector2(1205.0f  , 295f  );
		vertices[110] = new Vector2(1240.0f  , 297f  );
		vertices[111] = new Vector2(1270.0f  , 318f  );
		vertices[112] = new Vector2(1297.0f  , 337f  );
		vertices[113] = new Vector2(1327.0f  , 346f  );
		vertices[114] = new Vector2(1366.0f  , 336f  );
		vertices[115] = new Vector2(1387.0f  , 324f  );
		vertices[116] = new Vector2(1407.0f  , 307f  );
		vertices[117] = new Vector2(1434.0f  , 302f  );
		vertices[118] = new Vector2(1455.0f  , 312f  );
		vertices[119] = new Vector2(1469.0f  , 336f  );
		vertices[120] = new Vector2(1475.0f  , 352f  );
		vertices[121] = new Vector2(1487.0f  , 373f  );
		vertices[122] = new Vector2(1503.0f  , 380f  );
		vertices[123] = new Vector2(1530.0f  , 389f  );
		vertices[124] = new Vector2(1568.0f  , 402f  );
		vertices[125] = new Vector2(1593.0f  , 418f  );
		vertices[126] = new Vector2(1635.0f  , 436f  );
		vertices[127] = new Vector2(1668.0f  , 453f  );
		vertices[128] = new Vector2(1689.0f  , 452f  );
		vertices[129] = new Vector2(1718.0f  , 444f  );
		vertices[130] = new Vector2(1746.0f  , 444f  );
		vertices[131] = new Vector2(1779.0f  , 460f  );
		vertices[132] = new Vector2(1804.0f  , 471f  );
		vertices[133] = new Vector2(1828.0f  , 491f  );

	    

	}







}
