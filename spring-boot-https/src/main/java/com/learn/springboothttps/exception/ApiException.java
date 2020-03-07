package com.learn.springboothttps.exception;

import org.springframework.http.HttpStatus;

/**
 * API Exception - custom exception
 * 
 * @author MALLIKARJUN
 *
 */
public class ApiException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private ApiError error;

	public ApiException(String message) {
		this.setMessage(message);
	}

	public ApiException(String message, HttpStatus status) {
		this.setError(new ApiError(message, status));
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ApiError getError() {
		return error;
	}

	public void setError(ApiError error) {
		this.error = error;
	}
}
