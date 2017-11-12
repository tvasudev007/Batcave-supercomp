package com.gottam.gazette.BatmanTheSaviour.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = Villain.class)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Villain {

	private String name;
	
	private Location location;
	
	public Villain(){
		
	}

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
