package com.learn.springbootjetty.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global Exception Handler
 * 
 * @author MALLIKARJUN
 *
 */
@ControllerAdvice
public class ExceptionAdviceHandler {

	@ExceptionHandler(value = ApiException.class)
	public ResponseEntity<Object> handleApiException(ApiException apiException) {
		System.out.println("API Exception Handler");
		return new ResponseEntity<>(apiException.getError(),apiException.getError().getStatus());
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> handleException(Exception exception) {
		System.out.println("Exception handler");
		return new ResponseEntity<>(new ApiError(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
