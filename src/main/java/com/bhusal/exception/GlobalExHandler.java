package com.bhusal.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExHandler {
	@ExceptionHandler(StudentNotFoundEx.class)
	public ResponseEntity<?> handleStuNotfoundEx(StudentNotFoundEx ex) {
	return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
}
	
	public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex)
	{
		Map<String, Object> body = new HashMap<>();
		Map<String, Object> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->errors.put(error.getField(),error.getDefaultMessage()));
		body.put("timestamp", LocalDateTime.now());
		body.put("status", HttpStatus.BAD_REQUEST.value());
		body.put("errors", errors);
		return new ResponseEntity<>(body,HttpStatus.BAD_REQUEST);
		
	}

}
