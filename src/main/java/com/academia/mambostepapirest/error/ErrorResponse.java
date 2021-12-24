package com.academia.mambostepapirest.error;

import lombok.Setter;

import lombok.Getter;

import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;

import java.util.List;

import java.util.Date;

import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorResponse {

	private int status;
	private HttpStatus httpStatus;
	private String message;
	private Date timestamp;
	List<String> errors;
	
	
}
