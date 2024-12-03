package com.asr.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Map<String, String>> resourceNotFoundException(CustomerNotFoundException response) {
		Map<String, String> result = new HashMap<String, String>();
		String message = response.getMessage();
		String time = LocalDateTime.now().toString();
		String status = HttpStatus.NOT_FOUND.toString();
		result.put("message", message);
		result.put("time", time);
		result.put("status", status);

		return ResponseEntity.ok(result);
	}
}
