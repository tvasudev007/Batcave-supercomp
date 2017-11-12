package com.gottam.gazette.BatmanTheSaviour.dto;

import org.springframework.stereotype.Component;

@Component
public class ErrorResponseDTO {

	private String error;

	public String getErrorMessage() {
		return error;
	}

	public void setErrorMessage(String errorMessage) {
		this.error = errorMessage;
	}
}
