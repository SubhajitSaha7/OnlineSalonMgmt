package com.cg.salon.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cg_salon_service_schedule")
public class OnlineSalon_SalonServiceSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "seq1")
	@SequenceGenerator(name = "seq1",sequenceName = "schedule_seq1",allocationSize = 1)
	@Column(name = "service_schedule_id")
	private Integer serviceScheduleId;
	
	@Column(name = "schedule_date")
	private LocalDate scheduleDate;
	
	@Column(name = "schedule_slot", length = 10, nullable = false)
	private String slot;
	
	
	private OnlineSalon_Appointment appointments;
	private OnlineSalon_SalonService salonService;
	
	public Integer getServiceScheduleId() {
		return serviceScheduleId;
	}
	public void setServiceScheduleId(Integer serviceScheduleId) {
		this.serviceScheduleId = serviceScheduleId;
	}
	public LocalDate getScheduleDate() {
		return scheduleDate;
	} 
	public void setScheduleDate(LocalDate scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public OnlineSalon_Appointment getAppointments() {
		return appointments;
	}
	public void setAppointments(OnlineSalon_Appointment appointments) {
		this.appointments = appointments;
	}
	public OnlineSalon_SalonService getSalonService() {
		return salonService;
	}
	public void setSalonService(OnlineSalon_SalonService salonService) {
		this.salonService = salonService;
	}
	public OnlineSalon_SalonServiceSchedule(Integer serviceScheduleId, LocalDate scheduleDate, String slot,
			OnlineSalon_Appointment appointments, OnlineSalon_SalonService salonService) {
		super();
		this.serviceScheduleId = serviceScheduleId;
		this.scheduleDate = scheduleDate;
		this.slot = slot;
		this.appointments = appointments;
		this.salonService = salonService;
	}
	@Override
	public String toString() {
		return " " + serviceScheduleId + " "
				+ scheduleDate + " " + slot + " ";
	}
	
	
}
