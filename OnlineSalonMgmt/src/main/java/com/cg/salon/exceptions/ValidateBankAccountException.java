package com.cg.salon.exceptions;

import java.util.List;

import org.springframework.validation.FieldError;

public class ValidateBankAccountException extends Exception {

	private List<FieldError> errors;

	public ValidateBankAccountException() {
		super();

	}

	public ValidateBankAccountException(String msg) {
		super(msg);
	}

	public ValidateBankAccountException(List<FieldError> errors) {
		super();
		this.errors = errors;
	}

	public List<FieldError> getErrors() {
		return errors;
	}

}
