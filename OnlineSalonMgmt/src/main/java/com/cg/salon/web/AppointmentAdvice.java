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
public class AppointmentAdvice extends GlobalAdvice{
	
	@ExceptionHandler(ServiceNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public AddAppointmentErrorMessage handleExceptionServiceNotFound(ServiceNotFoundException ex)
	{
		return new AddAppointmentErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
	}
	
	@ExceptionHandler(AppointmentNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public DeleteAppointmentErrorMessage handleExceptionAppointmentNotFound(AppointmentNotFoundException ex)
	{
		return new DeleteAppointmentErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
	}
}