package com.cg.salon.exceptions;

public class AppointmentNotFoundException extends Exception{
	
	
	public AppointmentNotFoundException()	{
		super();
	}
	
	public AppointmentNotFoundException(String message)	{
		super(message);
	}
}
