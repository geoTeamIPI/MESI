package geoTeamIPI.GeoPatrimoine.exception;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/*
	 * 404 : not found 400 : Bad request 409 : Conflict 201 : Created (post) 200 : OK (PUT et Delete)
	 * 
	 */

	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleEntityNotFoundException(
			EntityNotFoundException entityNotFoundException) {
		return entityNotFoundException.getMessage();
	}

	@ExceptionHandler(EntityExistsException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.CONFLICT)
	public String handleEntityExistsException(
			EntityExistsException entityExistsException) {
		return entityExistsException.getMessage();
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String handleIllegalArgumentException(IllegalArgumentException illegalArgumentException) {
		return illegalArgumentException.getMessage();
	}

}
