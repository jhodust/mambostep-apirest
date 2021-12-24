package com.academia.mambostepapirest.error;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	

	private ResponseEntity<ErrorResponse> buildResponseEntity(HttpStatus httpStatus, RuntimeException exc, List<String> errors) {
		ErrorResponse error = new ErrorResponse();
		error.setMessage(exc.getMessage());
		error.setStatus(httpStatus.value());
		error.setHttpStatus(httpStatus);
		error.setTimestamp(new Date());
		error.setErrors(errors);
		return new ResponseEntity<>(error, httpStatus);
	}
	
	@ExceptionHandler(CustomException.class) // exception handled
	protected ResponseEntity<?> handleException(CustomException exc){
		return buildResponseEntity(exc.getStatus(), exc, null);
	}
	
	
}
