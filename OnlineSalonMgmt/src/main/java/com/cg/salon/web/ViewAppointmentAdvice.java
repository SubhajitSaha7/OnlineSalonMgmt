package com.cg.salon.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.salon.dto.ViewAppointmentErrorMessage;
import com.cg.salon.exceptions.AppointmentNotFoundException;
import com.cg.salon.exceptions.ValidateViewAppointmentException;

@RestControllerAdvice
public class ViewAppointmentAdvice extends GlobalAdvice{
	
	@ExceptionHandler(AppointmentNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ViewAppointmentErrorMessage handleExceptionAppointmentNotFound(AppointmentNotFoundException ex)
	{
		return new ViewAppointmentErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
	}
	
	@ExceptionHandler(ValidateViewAppointmentException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ViewAppointmentErrorMessage handleException2(ValidateViewAppointmentException ex)
	{
		List<String> errors = ex.getErrors().stream().map(err -> err.getDefaultMessage()).collect(Collectors.toList());
		return new ViewAppointmentErrorMessage(HttpStatus.BAD_REQUEST.toString(), errors);
	}
}
