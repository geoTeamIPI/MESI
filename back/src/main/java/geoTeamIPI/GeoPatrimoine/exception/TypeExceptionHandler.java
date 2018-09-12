
package geoTeamIPI.GeoPatrimoine.exception;

import geoTeamIPI.GeoPatrimoine.utils.TypeHelper;

public class TypeExceptionHandler extends GlobalExceptionHandler {

	public static void notAllowed() {
		throw new IllegalArgumentException(TypeHelper.TYPE_NOT_ALLOWED);
	}

}
