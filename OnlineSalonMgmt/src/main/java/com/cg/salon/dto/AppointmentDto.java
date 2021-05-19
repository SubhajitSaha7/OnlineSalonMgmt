package com.cg.salon.dto;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;

import com.cg.salon.entity.Customer;
import com.cg.salon.entity.SalonServiceSchedule;

public class AppointmentDto {
	
	private Integer appointmentId;

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	@FutureOrPresent(message = "Preferred Date must not be in the past")
	private LocalDate preferredDate;

	private Integer custId;

	private Integer scheduleId;

	private String appointmentStatus;

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public AppointmentDto() {
		super();
	}

	public LocalDate getPreferredDate() {
		return preferredDate;
	}

	public void setPreferredDate(LocalDate preferredDate) {
		this.preferredDate = preferredDate;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

}
