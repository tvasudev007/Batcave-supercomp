package com.gottam.gazette.BatmanTheSaviour.dto;

import org.springframework.stereotype.Component;

@Component
public class ErrorResponseDTO {

	private String error;
	
	public ErrorResponseDTO(){
		
	}

	public String getErrorMessage() {
		return error;
	}

	public void setErrorMessage(String error) {
		this.error = error;
	}
}
