package com.cg.salon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.salon.dto.AppointmentDto;
import com.cg.salon.entity.Appointment;
import com.cg.salon.exceptions.AppointmentNotFoundException;
import com.cg.salon.exceptions.SalonServiceNotFoundException;


public interface IAppointmentService {

	public Appointment viewAppointmentById(int appId) throws AppointmentNotFoundException;
	public List<Appointment> viewAppointmentByCustomerId(int custId) throws AppointmentNotFoundException;
	public Appointment viewAppointmentByScheduleId(int serviceScheduleId) throws AppointmentNotFoundException;

    public Integer addAppointment(AppointmentDto appdto)throws SalonServiceNotFoundException;
	
	public boolean editAppointment(AppointmentDto appdto) throws SalonServiceNotFoundException,AppointmentNotFoundException;
	public boolean removeAppointment(int appointmentId) throws AppointmentNotFoundException;
	public List<Appointment> viewAllAppointment() throws AppointmentNotFoundException;
	
	
}
