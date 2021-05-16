package com.cg.salon.dto;

public class ViewAppointmentSuccessMessage {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ViewAppointmentSuccessMessage(String message) {
		super();
		this.message = message;
	}
}
