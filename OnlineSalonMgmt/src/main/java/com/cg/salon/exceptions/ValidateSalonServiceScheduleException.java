package com.cg.salon.exceptions;

import java.util.List;

import org.springframework.validation.FieldError;

public class ValidateSalonServiceScheduleException extends Exception {

	private List<FieldError> errors;

	public ValidateSalonServiceScheduleException() {
		super();

	}

	public ValidateSalonServiceScheduleException(String message) {
		super(message);

	}

	public ValidateSalonServiceScheduleException(List<FieldError> errors) {
		super();
		this.errors = errors;
	}

	public List<FieldError> getErrors() {
		return errors;
	}

}