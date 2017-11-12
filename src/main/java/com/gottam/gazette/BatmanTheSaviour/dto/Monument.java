package com.gottam.gazette.BatmanTheSaviour.dto;

public class Monument {

	private String place;

	private Location location;

	public Monument(String place, Location location) {
		this.place = place;
		this.location = location;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
