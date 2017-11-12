package com.gottam.gazette.BatmanTheSaviour.constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.gottam.gazette.BatmanTheSaviour.dto.Location;
import com.gottam.gazette.BatmanTheSaviour.dto.Monument;


public class ApplicationConstants {

	
	public static final List<Monument> targets = Collections.unmodifiableList(
		    new ArrayList<Monument>() {

			{
		    	add(new Monument("Amusement Mile", new Location(40.748288, -73.985791)));
				add(new Monument("Gotham University", new Location(40.753722, -73.977494)));
				add(new Monument("Giordano Botanical Gardens", new Location(40.753875, -73.983745)));
				add(new Monument("Gotham Arms Apartment", new Location(40.761687, -73.981873)));
				add(new Monument("Old Gotham Subway", new Location(40.759941, -73.975449)));
				add(new Monument("Gotham Arms Apartment", new Location(40.749428, -73.981873)));
				add(new Monument("Special Crimes Unit", new Location(40.761687, -73.976931)));
				add(new Monument("GCPD Headquarters", new Location(40.753645, -73.988117)));
				add(new Monument("Gotham City Hall", new Location(40.753170, -73.981972)));
				add(new Monument("The Clocktower", new Location(40.755469, -73.976731)));
				add(new Monument("Wayne Enterprises", new Location(40.759134, -73.979021)));
		    }});
	
	
	
}
