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
@Table(name = "cg_appointment")
public class OnlineSalon_Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "seq1")
	@SequenceGenerator(name = "seq1",sequenceName = "appointment_seq1",allocationSize = 1)
	@Column(name = "appointment_id")
	private long appointmentId;
	 
	
	@Column(name = "appointment_date")
	private LocalDate preferredDate;
	
	private OnlineSalon_Customer customer;
	private OnlineSalon_Payment payment;
	
	@Column(name = "appointment_time_slots", length = 25, nullable = false)
	private String timeSlots;
	
	private OnlineSalon_SalonServiceSchedule salonServiceSchedule;
	
	@Column(name = "appointment_status", length = 25, nullable = false)
	private String appointmentStatus;
	
	
	public long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}
	public LocalDate getPreferredDate() {
		return preferredDate;
	}
	public void setPreferredDate(LocalDate preferredDate) {
		this.preferredDate = preferredDate;
	}
	public OnlineSalon_Customer getCustomer() {
		return customer;
	}
	public void setCustomer(OnlineSalon_Customer customer) {
		this.customer = customer;
	}
	public OnlineSalon_Payment getPayment() {
		return payment;
	}
	public void setPayment(OnlineSalon_Payment payment) {
		this.payment = payment;
	}
	public String getTimeSlots() {
		return timeSlots;
	}
	public void setTimeSlots(String timeSlots) {
		this.timeSlots = timeSlots;
	}
	public OnlineSalon_SalonServiceSchedule getSalonServiceSchedule() {
		return salonServiceSchedule;
	}
	public void setSalonServiceSchedule(OnlineSalon_SalonServiceSchedule salonServiceSchedule) {
		this.salonServiceSchedule = salonServiceSchedule;
	}
	public String getAppointmentStatus() {
		return appointmentStatus;
	}
	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	@Override
	public String toString() {
		return " " + appointmentId + " " + preferredDate
				+ " " + timeSlots + " " + appointmentStatus + " ";
	}
	public OnlineSalon_Appointment(long appointmentId, LocalDate preferredDate, OnlineSalon_Customer customer,
			OnlineSalon_Payment payment, String timeSlots, OnlineSalon_SalonServiceSchedule salonServiceSchedule,
			String appointmentStatus) {
		super();
		this.appointmentId = appointmentId;
		this.preferredDate = preferredDate;
		this.customer = customer;
		this.payment = payment;
		this.timeSlots = timeSlots;
		this.salonServiceSchedule = salonServiceSchedule;
		this.appointmentStatus = appointmentStatus;
	}
	
	
	

}
