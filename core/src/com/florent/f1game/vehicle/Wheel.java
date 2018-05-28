package com.florent.f1game.vehicle;

public class Wheel{
	
	private String skin;
	private int mass;
	
	public Wheel(String s, int m) {
		this.setSkin(s);
		this.setMass(m);
	}

	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	public int getMass() {
		return mass;
	}

	public void setMass(int mass) {
		this.mass = mass;
	}
	
}