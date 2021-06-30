package com.cg.salon.service;

import java.util.List;

import com.cg.salon.dto.AppointmentDto;
import com.cg.salon.entity.Appointment;
import com.cg.salon.exceptions.AppointmentCancelException;
import com.cg.salon.exceptions.AppointmentNotFoundException;
import com.cg.salon.exceptions.CustomerNotFoundException;
import com.cg.salon.exceptions.SalonServiceScheduleNotFoundException;

public interface IAppointmentService {

	public Appointment getAppointmentById(int appId) throws AppointmentNotFoundException;

	public List<Appointment> getAppointmentByCustomerId(int custId) throws AppointmentNotFoundException;

	public List<Appointment> getAppointmentByScheduleId(int serviceScheduleId) throws AppointmentNotFoundException;

	public Integer addAppointment(AppointmentDto appdto)
			throws CustomerNotFoundException, SalonServiceScheduleNotFoundException,
			AppointmentNotFoundException, AppointmentCancelException;

	public boolean cancelAppointment(int appid) throws AppointmentNotFoundException,
	AppointmentCancelException;

	public List<Appointment> getAllAppointment() throws AppointmentNotFoundException;

}
