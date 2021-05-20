package com.cg.salon.exceptions;

import java.util.List;

import org.springframework.validation.FieldError;

public class ValidateAppointmentException extends Exception {
	private List<FieldError> errors;

	public ValidateAppointmentException() {
		super();
	}

	public ValidateAppointmentException(String message) {
		super(message);
	}

	public ValidateAppointmentException(List<FieldError> errors) {
		super();
		this.errors = errors;
	}

	public List<FieldError> getErrors() {
		return errors;
	}

}
