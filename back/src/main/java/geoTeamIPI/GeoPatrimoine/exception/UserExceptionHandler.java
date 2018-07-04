
package geoTeamIPI.GeoPatrimoine.exception;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import geoTeamIPI.GeoPatrimoine.utils.UserHelper;

public class UserExceptionHandler extends GlobalExceptionHandler{
	
	public static void userNotFound() {
		 throw new EntityNotFoundException(UserHelper.USER_NO_EXISTS); 
	}
	
	public static void userAlreadyExists() {
		 throw new EntityExistsException(UserHelper.USER_ALREADY_EXISTS); 	
	}
	
	public static void userIllegalArguments() {
		throw new IllegalArgumentException(UserHelper.ERROR_REQUEST); 
	}
	
	public static void userAuthenticationException() {
		throw new IllegalArgumentException(UserHelper.ERR_IDENTIFICATION); 
	}
	

}

