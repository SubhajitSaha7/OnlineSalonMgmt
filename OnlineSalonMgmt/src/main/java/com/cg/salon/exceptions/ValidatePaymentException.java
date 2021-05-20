package com.cg.salon.exceptions;

import java.util.Collection;
import java.util.List;

import org.springframework.validation.FieldError;

public class ValidatePaymentException extends Exception {

	private List<FieldError> errors;

	public ValidatePaymentException() {
		super();
	}

	public ValidatePaymentException(String message) {
		super(message);
	}

	public ValidatePaymentException(List<FieldError> errors) {
		super();
		this.errors = errors;
	}

	public List<FieldError> getErrors() {
		return errors;
	}

}
