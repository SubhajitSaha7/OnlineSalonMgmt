package com.cg.salon.dto;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;

import com.cg.salon.entity.Customer;
import com.cg.salon.entity.SalonServiceSchedule;

public class ViewAppointmentDto {
	
	private Integer appointmentId;
	
	@FutureOrPresent(message = "Preferred Date must not be in the past")
	private LocalDate preferredDate;
	
	private Customer customer;
	
	private SalonServiceSchedule salonServiceSchedule;
	
	private String appointmentStatus;

	public ViewAppointmentDto() {
		super();
	}

	public ViewAppointmentDto(Integer appointmentId, LocalDate preferredDate, Customer customer,
			SalonServiceSchedule salonServiceSchedule, String appointmentStatus) {
		super();
		this.appointmentId = appointmentId;
		this.preferredDate = preferredDate;
		this.customer = customer;
		this.salonServiceSchedule = salonServiceSchedule;
		this.appointmentStatus = appointmentStatus;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LocalDate getPreffeDate() {
		return preferredDate;
	}

	public void setPreffeDate(LocalDate preffeDate) {
		this.preferredDate = preffeDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public SalonServiceSchedule getSalonServiceSchedule() {
		return salonServiceSchedule;
	}

	public void setSalonServiceSchedule(SalonServiceSchedule salonServiceSchedule) {
		this.salonServiceSchedule = salonServiceSchedule;
	}

	public String getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	

}
