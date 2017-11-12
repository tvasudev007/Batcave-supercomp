package com.gottam.gazette.BatmanTheSaviour.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.gottam.gazette.BatmanTheSaviour.dto.LocationResponseDTO;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class BatEyeControllerTest {

	static final String VALID_PRODUCT_API_URI = "http://localhost:8080/BatmanTheSaviour/coordinate?q=40.755605,-73.988145";
	private RestTemplate restTemplate;

	@Before
	public void setUp() {
		restTemplate = new RestTemplate();
	}

	@Test
	public void testProductFound() {
		ResponseEntity<?> responseEntity = restTemplate.getForEntity(VALID_PRODUCT_API_URI, LocationResponseDTO.class);
		assert (responseEntity.getStatusCode() == HttpStatus.OK);
	}
}
