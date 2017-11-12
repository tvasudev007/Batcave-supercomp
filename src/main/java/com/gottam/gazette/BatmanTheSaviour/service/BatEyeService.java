package com.gottam.gazette.BatmanTheSaviour.service;

import static com.gottam.gazette.BatmanTheSaviour.constants.ApplicationConstants.targets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gottam.gazette.BatmanTheSaviour.dto.Fugitives;
import com.gottam.gazette.BatmanTheSaviour.dto.Location;
import com.gottam.gazette.BatmanTheSaviour.dto.LocationResponseDTO;
import com.gottam.gazette.BatmanTheSaviour.dto.Monument;
import com.gottam.gazette.BatmanTheSaviour.dto.Target;
import com.gottam.gazette.BatmanTheSaviour.dto.TargetDTO;
import com.gottam.gazette.BatmanTheSaviour.dto.Villain;

@Service
public class BatEyeService {

	// private List<Monument> targets = ;
	private static final double R = 6372.8; // In kilometers
	private static final int MAX_PROBABILITY = 95; // Maximum probability cannot
													// be more than 95, as
													// Villains are not 100%
													// predictable

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public LocationResponseDTO calculateProbalibilty(double lat, double lng) {

		List<Target> highRiskTargets = new ArrayList<Target>();

		for (Monument monument : targets) {
			double distance = haversine(monument.getLocation().getLat(), monument.getLocation().getLng(), lat, lng);
			if (distance <= 2.0) {
				log.debug("############ FOUND TARGET ################ PLACE: " + monument.getPlace()
						+ " Located at a distance of : " + distance + " in KM");
				highRiskTargets.add(new Target(monument.getPlace(), monument.getLocation(), distance));
			}
		}
		// sort the targets by distance with smallest distance first
		Collections.sort(highRiskTargets, new Comparator<Target>() {
			@Override
			public int compare(Target t1, Target t2) {
				return Double.compare(t1.getDistance(), t2.getDistance());
			}
		});

		// considering only top two nearest distances from the villian's
		// location
		LocationResponseDTO response = new LocationResponseDTO();

		int proababilty = 0;
		double totalDistance = highRiskTargets.get(0).getDistance() + highRiskTargets.get(1).getDistance();

		proababilty = (int) (((highRiskTargets.get(1).getDistance()) / totalDistance) * 100);

		if (proababilty > MAX_PROBABILITY) {
			proababilty = MAX_PROBABILITY;
		}

		String villian = Fugitives.values()[new Random().nextInt(Fugitives.values().length)].toString();
		Villain villain = new Villain(villian, new Location(lat, lng));

		List<TargetDTO> responseTargets = new ArrayList<TargetDTO>();

		responseTargets.add(
				new TargetDTO(highRiskTargets.get(0).getPlace(), proababilty, highRiskTargets.get(0).getLocation()));
		responseTargets.add(new TargetDTO(highRiskTargets.get(1).getPlace(), 100 - proababilty,
				highRiskTargets.get(1).getLocation()));

		response.setTargets(responseTargets);
		response.setVillain(villain);

		return response;
	}

	// Formula to Calculate distance between two coordinates
	private static double haversine(double lat1, double lon1, double lat2, double lon2) {
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);

		double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
		double c = 2 * Math.asin(Math.sqrt(a));
		return R * c;
	}

}
