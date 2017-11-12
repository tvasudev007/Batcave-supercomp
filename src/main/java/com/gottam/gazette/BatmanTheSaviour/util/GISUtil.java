package com.gottam.gazette.BatmanTheSaviour.util;

public class GISUtil {

	/*
	 * top: north latitude of bounding box. left: left longitude of bounding box
	 * (western bound). bottom: south latitude of the bounding box. right: right
	 * longitude of bounding box (eastern bound). latitude: latitude of the
	 * point to check. longitude: longitude of the point to check.
	 */

	private static final double top = 40.763328;
	private static final double bottom = 40.746422;
	private static final double left = -73.994753;
	private static final double right = -73.968039;

	public static boolean isBounded(double latitude, double longitude) {

		if (top >= latitude && latitude >= bottom) {

			if (left <= right && left <= longitude && longitude <= right) {
				return true;
			} else if (left > right && (left <= longitude || longitude <= right)) {
				return true;
			}
		}
		return false;
	}

}