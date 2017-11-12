package com.gottam.gazette.BatmanTheSaviour.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = LocationResponseDTO.class)
@JsonIgnoreProperties(ignoreUnknown=true)
public class LocationResponseDTO {

	private Villain villain;

	private List<TargetDTO> targets;

	public LocationResponseDTO() {

	}
	
	@JsonCreator
	public LocationResponseDTO(@JsonProperty("villain")Villain villain, @JsonProperty("targets")List<TargetDTO> targets) {

		this.villain = villain;
		this.targets = targets;

	}

	public Villain getVillain() {
		return villain;
	}

	public void setVillain(Villain villain) {
		this.villain = villain;
	}

	public List<TargetDTO> getTargets() {
		return targets;
	}

	public void setTargets(List<TargetDTO> targets) {
		this.targets = targets;
	}

}
