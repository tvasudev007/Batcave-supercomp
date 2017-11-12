package com.gottam.gazette.BatmanTheSaviour.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class LocationResponseDTO {

	private Villain villain;

	private List<TargetDTO> targets;

	public LocationResponseDTO() {

	}

	public LocationResponseDTO(Villain villain, List<TargetDTO> targets) {

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
