package com.ebay.earthquake.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EarthQuakeServiceException.class)
	public ResponseEntity<Object> exception(EarthQuakeServiceException exception) {
		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, exception.getLocalizedMessage(), exception.getMessage());
		return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}