package com.cg.salon.exceptions;

import java.util.List;

import org.springframework.validation.FieldError;

public class ValidateViewAppointmentException extends Exception{
	private List<FieldError> errors;

	public ValidateViewAppointmentException() {
		super();
	}
	
	public ValidateViewAppointmentException(String message) {
		super(message);
	}

	public ValidateViewAppointmentException(List<FieldError> errors) {
		super();
		this.errors = errors;
	}
	
	public List<FieldError> getErrors() {
		return errors;
	}
	
}
