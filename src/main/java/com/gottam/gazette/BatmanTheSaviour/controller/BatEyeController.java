package com.gottam.gazette.BatmanTheSaviour.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.gottam.gazette.BatmanTheSaviour.dto.ErrorResponseDTO;
import com.gottam.gazette.BatmanTheSaviour.service.BatEyeService;
import com.gottam.gazette.BatmanTheSaviour.util.GISUtil;

@RestController
@RequestMapping("/")
public class BatEyeController {
	
	private static final String errorMessage ="Desole, Bat Eye Tracker cannot compute this location :( ";
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final Geocoder geocoder = new Geocoder();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		return "Welcome to BatEyeController";
	}

	@RequestMapping(value = "/location", method = RequestMethod.GET)
	public Object attackLocatorByLocation(@RequestParam String q) {
		
		log.info("Request recieved at attackLocatorByLocation() with parameters : {}", q);

		return batEyeWithAddress(q);
	}

	@RequestMapping(value = "/address", method = RequestMethod.GET)
	public Object attackLocatorByAddress(@RequestParam String q) {
		
		log.info("Request recieved at attackLocatorByAddress() with parameters : {}", q);
		return batEyeWithAddress(q);
	}

	@RequestMapping(value = "/coordinate", method = RequestMethod.GET)
	public Object attackLocatorByCoordinate(@RequestParam String q) {
		log.info("Request recieved at attackLocatorByCoordinate() with parameters : {}", q);

		List<String> coordinates = Arrays.asList(q.split(","));
		double lat = Double.parseDouble(coordinates.get(0));
		double lng = Double.parseDouble(coordinates.get(1));

		return batEyeTracker(lat, lng);

	}

	private Object batEyeTracker(double lat, double lng) {

		if (GISUtil.isBounded(lat, lng)) {
			BatEyeService batEyeService = new BatEyeService();

			return batEyeService.calculateProbalibilty(lat, lng);

		} else {
			ErrorResponseDTO businessError = new ErrorResponseDTO();

			businessError.setErrorMessage(errorMessage);
			return businessError;
		}
	}

	private Object batEyeWithAddress(String address) {

		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(address).setLanguage("en")
				.getGeocoderRequest();
		GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
		
		try{
			log.info("LAT: " + geocoderResponse.getResults().get(0).getGeometry().getLocation().getLat() + " lng : "
					+ geocoderResponse.getResults().get(0).getGeometry().getLocation().getLng());
			
			BigDecimal lat = geocoderResponse.getResults().get(0).getGeometry().getLocation().getLat();
			BigDecimal lng = geocoderResponse.getResults().get(0).getGeometry().getLocation().getLng();
			return batEyeTracker(lat.doubleValue(), lng.doubleValue());
		}
		catch(Exception e){
			log.error(e.getMessage());
			ErrorResponseDTO businessError = new ErrorResponseDTO();

			businessError.setErrorMessage(errorMessage);
			return businessError;
			
		}
		

		

	}
}
