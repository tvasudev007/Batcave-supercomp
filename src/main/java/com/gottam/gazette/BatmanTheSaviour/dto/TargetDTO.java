package com.gottam.gazette.BatmanTheSaviour.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = TargetDTO.class)
@JsonIgnoreProperties(ignoreUnknown=true)
public class TargetDTO {

	private String place;

	private int probability;

	private Location location;

	public TargetDTO() {

	}

	public TargetDTO(String place, int probability, Location location) {
		this.place = place;
		this.probability = probability;
		this.location = location;

	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(int probability) {
		this.probability = probability;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
