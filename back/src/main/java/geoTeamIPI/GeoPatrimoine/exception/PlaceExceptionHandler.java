
package geoTeamIPI.GeoPatrimoine.exception;

import geoTeamIPI.GeoPatrimoine.utils.PlaceHelper;

public class PlaceExceptionHandler extends GlobalExceptionHandler {

	public static void notTheCreator() {
		throw new IllegalArgumentException(PlaceHelper.PLACE_CREATOR_REFUSED);
	}

	public static void tooManyStoriesLinked() {
		throw new IllegalArgumentException(PlaceHelper.MORE_THAN_ONE_STORY_LINKED);
	}

}
