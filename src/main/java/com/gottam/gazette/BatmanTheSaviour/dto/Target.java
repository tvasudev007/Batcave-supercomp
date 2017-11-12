package com.gottam.gazette.BatmanTheSaviour.dto;

public class Target {

	private String place;


	private Location location;

	private double distance;

	public Target() {

	}



	public Target(String place, Location location, double distance) {
		this.place = place;
		this.location = location;
		this.distance = distance;
	}



	public Target(String place, Location location) {
		super();
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

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

}
