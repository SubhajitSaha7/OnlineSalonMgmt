package com.cg.salon.exceptions;

import java.util.List;

import org.springframework.validation.FieldError;

public class ValidateSalonServiceException extends Exception {

	private List<FieldError> errors;

	public ValidateSalonServiceException() {
		super();

	}

	public ValidateSalonServiceException(String message) {
		super(message);

	}

	public ValidateSalonServiceException(List<FieldError> errors) {
		super();
		this.errors = errors;
	}

	public List<FieldError> getErrors() {
		return errors;
	}

}