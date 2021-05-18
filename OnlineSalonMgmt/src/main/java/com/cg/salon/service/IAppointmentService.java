package com.cg.salon.dto;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

public interface Iappointmentservice
{
	public Appointment addAppointment(AppDto appdto)throws SalonServiceNotFoundException;
	public Appointment viewAppointment(long appointmentId)throws AppointmentNotFoundException;
	public List<Appointment> viewAppointment(LocalDate preferredDate)throws AppointmentNotFoundException;
	public List<Appointment> viewAppointment(LocalDate preferredDate, SalonService salonServices)throws
	AppointmentNotFoundException;
	public boolean editAppointment(AppDto appdto) throws SalonServiceNotFoundException,AppointmentNotFoundException;
	public boolean removeAppointment(long appointmentId) throws AppointmentNotFoundException;
	public List<Appointment> viewAppointment();
}