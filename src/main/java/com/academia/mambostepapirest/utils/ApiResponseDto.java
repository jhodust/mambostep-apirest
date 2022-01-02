package com.academia.mambostepapirest.utils;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDto<T> {

	private T data;
	private String message;
	private StackTraceElement[] trace;
	private int status;
	public ApiResponseDto(T data) {
		this.data = data;
	}

	public ApiResponseDto(T data, String message) {
		this.data = data;
		this.message = message;
	}


	public static ApiResponseDto<String> ok() {
		return ApiResponseDto.<String>builder()
				.data("")
				.message("success")
				.status(HttpStatus.OK.value())
				.build();
	}
	
	public static ApiResponseDto<String> ok(String mensaje) {
		return ApiResponseDto.<String>builder()
				.data("")
				.message(mensaje)
				.status(HttpStatus.OK.value())
				.build();
	}


	public static <T> ApiResponseDto<T> ok(T data) {
		return ApiResponseDto.<T>builder()
				.data(data)
				.message("success")
				.status(HttpStatus.OK.value())
				.build();
	}
	
	public static <T> ApiResponseDto<T> ok(T data, String mensaje) {
		return ApiResponseDto.<T>builder()
				.data(data)
				.message(mensaje)
				.status(HttpStatus.OK.value())
				.build();
	}
	
	public static <T> ApiResponseDto<T> empty() {
		return ApiResponseDto.<T>builder()
		.message("success")
		.build();
	}

}
