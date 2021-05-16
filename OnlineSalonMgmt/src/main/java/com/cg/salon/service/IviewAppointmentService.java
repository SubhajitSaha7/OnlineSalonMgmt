package com.cg.salon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.salon.entity.Appointment;
import com.cg.salon.exceptions.AppointmentNotFoundException;


public interface IviewAppointmentService {

	public Appointment viewAppointmentById(int appId) throws AppointmentNotFoundException;
	public List<Appointment> viewAppointmentByCustomerId(int custId) throws AppointmentNotFoundException;
	public Appointment viewAppointmentByScheduleId(int serviceScheduleId) throws AppointmentNotFoundException;

	
	
}
