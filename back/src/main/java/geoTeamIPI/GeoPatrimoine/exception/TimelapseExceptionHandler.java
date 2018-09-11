
package geoTeamIPI.GeoPatrimoine.exception;

import geoTeamIPI.GeoPatrimoine.utils.TimelapseHelper;

public class TimelapseExceptionHandler extends GlobalExceptionHandler {

	public static void notAllowed() {
		throw new IllegalArgumentException(TimelapseHelper.TIMELAPSE_NOT_ALLOWED);
	}

}
