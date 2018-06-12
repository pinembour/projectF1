package com.florent.f1game.vehicle;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.WheelJoint;
import com.badlogic.gdx.physics.box2d.joints.WheelJointDef;

public abstract class Abstract_Car extends InputAdapter {

	// les différentes partie de la moto
	public Body man, chassis, leftWheel, rightWheel;
	
	// represente les liaisions entre les objets
	protected	WheelJointDef axisDef , ManDef ;		// cahier des charges des liaisons
	private WheelJoint leftAxis, rightAxis;				// les liaisons	

	
	// represente le skin(l'image)
	protected Sprite sp_VehicleBody;
	protected Sprite sp_LeftWheel;
	protected Sprite sp_RightWheel;

	// represente la forme
	protected CircleShape wheelShape;
	
	private FixtureDef manFixtureDef;
	
	protected float radiusWheel;
	private float motorSpeed = 8.6f;
	
	
	/****************************************************************************************************************************/
	
	public Abstract_Car(World world, FixtureDef chassisFixtureDef, FixtureDef wheelFixtureDef ,
						Vector2 positionLeftWheel, Vector2 positionRightWheel,
						float x, float y,
						float width, float height) {
		
		
		// création d'un "cahier des charges"
		BodyDef bodyDef = new BodyDef();
		bodyDef.type =  BodyType.DynamicBody;   // subit les forces du world
		bodyDef.position.set(x, y);
		
		
		
		// chassis
		PolygonShape chassisShape = new PolygonShape();
		chassisShape.set(new float[] {-width / 2 , - height /2 ,
									width  /2 , -height /2,
									width  /2 * 0.75f , height / 2,
									-width /2 * 0.8f, height/2 *.8f});  
		
		
		chassisFixtureDef.shape = chassisShape;
		
		chassis = world.createBody(bodyDef);		//creation du corps suivant le cahier des charges
		chassis.createFixture(chassisFixtureDef);	//
		
		
		
		
		radiusWheel = height/3.5f;
		
		//man
		CircleShape ManShape = new CircleShape();
		ManShape.setRadius(radiusWheel);
		ManShape.setPosition(new Vector2(0, height/2));
		
		manFixtureDef = new FixtureDef();
		/*
		manFixtureDef.density = 1; 
		manFixtureDef.friction = 30;
		manFixtureDef.restitution = 0.4f;
		*/
		manFixtureDef.shape = ManShape;
		manFixtureDef.isSensor = true;
		
		chassis.createFixture(manFixtureDef).setUserData("head");
		/*
		manFixtureDef.friction = 0;
		
		man = world.createBody(bodyDef);
		man.createFixture(manFixtureDef);
		*/
		// left wheel
		
		
		wheelShape = new CircleShape();
		wheelShape.setRadius(radiusWheel);
		
		wheelFixtureDef.shape = wheelShape;
		
		leftWheel = world.createBody(bodyDef);
		leftWheel.createFixture(wheelFixtureDef);
		
		// right wheel	
		rightWheel = world.createBody(bodyDef);
		rightWheel.createFixture(wheelFixtureDef);
		
		
		
		//man axi
		/*
		ManDef = new WheelJointDef();
		ManDef.bodyA = chassis;
		ManDef.bodyB = man;
		ManDef.collideConnected = true;
		ManDef.localAnchorA.set(0,2*height/3  );
		ManDef.frequencyHz = 10000;
		ManDef.dampingRatio = 1f;
		
		
		manAxis = (WheelJoint) world.createJoint(ManDef);
		
		*/
		
		// left axis
		axisDef = new WheelJointDef();
		axisDef.bodyA = chassis;
		axisDef.bodyB = leftWheel;
		axisDef.localAnchorA.set(positionLeftWheel );
		axisDef.frequencyHz = chassisFixtureDef.density;
		axisDef.localAxisA.set(Vector2.Y);
		axisDef.maxMotorTorque = 2000000000  ;
		
		leftAxis = (WheelJoint) world.createJoint(axisDef);
		
		// right axis
		axisDef.bodyB = rightWheel;
		axisDef.localAnchorA.set(positionRightWheel);
		
		setRightAxis((WheelJoint) world.createJoint(axisDef));

		


	}
	
	
	@Override
	public boolean keyDown(int keycode) {
		
		switch(keycode) {
		case Keys.RIGHT:
				leftAxis.enableMotor(true);
				leftAxis.setMotorSpeed(- motorSpeed);
				break;
		case Keys.LEFT:
				leftAxis.enableMotor(true);
				leftAxis.setMotorSpeed(motorSpeed);
		}
		return true;
	}
	
	@Override
	public boolean keyUp(int keycode) {
		
		switch(keycode) {
		case Keys.RIGHT:
		case Keys.LEFT:
			leftAxis.enableMotor(false);

			
		}
		return true;
	}

	
	//-----------------------------------
	
	public Body getChassis() {
		return chassis;
	}
	//***
	public Body getLeftWheel() {
		return leftWheel;
	}
	public Body getRightWheel() {
		return rightWheel;
	}
	//***
	public void setSp_VehicleBody(Sprite sp) {
		this.sp_VehicleBody = sp;
	}
	public Sprite getSp_VehicleBody() {
		return sp_VehicleBody;
	}
	//***
	public void setSp_LeftWheel(Sprite sp) {
		this.sp_LeftWheel = sp;
	}
	public Sprite getSp_LeftWheel() {
		return sp_LeftWheel;
	}
	//***
	public void setSp_RightWheel(Sprite sp_RightWheel) {
		this.sp_RightWheel = sp_RightWheel;
	}
	public Sprite getSp_RightWheel() {
		return sp_RightWheel;
	}


	public WheelJoint getRightAxis() {
		return rightAxis;
	}


	public void setRightAxis(WheelJoint rightAxis) {
		this.rightAxis = rightAxis;
	}


	public FixtureDef getManFixtureDef() {
		return manFixtureDef;
	}


	public void setManFixtureDef(FixtureDef manFixtureDef) {
		this.manFixtureDef = manFixtureDef;
	}
}
