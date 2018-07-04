package geoTeamIPI.GeoPatrimoine.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class StoryHelper {

	public static void ThrowBadRequestException(String message){
		throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, message); 
	}
	
	/**
	 * Déclenche une exception NOT FOUND
	 * @param bad request
	 */
	public static void ThrowNotFoundException(String message){
		throw new HttpClientErrorException(HttpStatus.NOT_FOUND, message);
	}
	
	/**
	 * Déclenche une erreur INTERNAL SERVER ERROR
	 * @param message d'erreur
	 */
	public static void ThrowInternalServerErrorException(String message){
		throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR, message); 
	}
	
}
