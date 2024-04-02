package com.bhusal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class StudentNotFoundEx extends RuntimeException{
	public StudentNotFoundEx(Long id) {
		super("Student is not found with id: " + id);
	}
	
	

}
