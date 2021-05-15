package com.cg.salon.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cg_appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "seq1")
	@SequenceGenerator(name = "seq1",sequenceName = "appointment_seq1",allocationSize = 1)
	@Column(name = "appointment_id")
	private Integer appointmentId;
	 
	
	@Column(name = "appointment_date")
	private LocalDate preferredDate;
	
	@ManyToOne
	@JoinColumn(name = "cust_id", referencedColumnName = "cust_user_id")
	private Customer customer;
	
	
	@Column(name = "appointment_time_slots", length = 25, nullable = false)
	private String timeSlots;
	
	@ManyToOne
	@JoinColumn(name = "schedule_id", referencedColumnName = "service_schedule_id")
	private SalonServiceSchedule salonServiceSchedule;
	
	@Column(name = "appointment_status", length = 25, nullable = false)
	private String appointmentStatus;
	
	
	public long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}
	public LocalDate getPreferredDate() {
		return preferredDate;
	}
	public void setPreferredDate(LocalDate preferredDate) {
		this.preferredDate = preferredDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String getTimeSlots() {
		return timeSlots;
	}
	public void setTimeSlots(String timeSlots) {
		this.timeSlots = timeSlots;
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
	public Appointment() {
		super();
	}
	@Override
	public String toString() {
		return " " + appointmentId + " " + preferredDate + " "
				+ customer + " " +  " " + timeSlots + " "
				+ appointmentStatus + " ";
	}
	
}
