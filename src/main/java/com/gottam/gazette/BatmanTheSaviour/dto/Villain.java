package com.gottam.gazette.BatmanTheSaviour.dto;

public class Villain {

	private String name;
	
	private Location location;

	public Villain(String name, Location location) {
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
}
