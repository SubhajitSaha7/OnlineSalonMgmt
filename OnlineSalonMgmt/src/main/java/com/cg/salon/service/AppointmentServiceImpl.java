package com.cg.salon.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.salon.dao.IAppointmentDao;
import com.cg.salon.dto.AppointmentDto;
import com.cg.salon.entity.Appointment;
import com.cg.salon.exceptions.AppointmentNotFoundException;
import com.cg.salon.exceptions.SalonServiceNotFoundException;

@Service("appointment")
public class AppointmentServiceImpl implements IAppointmentService{

	@Autowired
	private IAppointmentDao appointmentdao;
	
	
	@Override
	public Appointment viewAppointmentById(int appId) throws AppointmentNotFoundException {
		
		Optional<Appointment> optappointment = appointmentdao.findById(appId);
		if (!optappointment.isPresent())
			throw new AppointmentNotFoundException("No Appointment exists for appointment id " + appId);
		return optappointment.get();
	}
	
	@Override
	public List<Appointment> viewAppointmentByCustomerId(int custId) throws AppointmentNotFoundException	{
		
		List<Appointment> lst = appointmentdao.viewAppointmentByCustomerId(custId);
		if(lst.isEmpty())
			throw new AppointmentNotFoundException("No appointment found for Customer Id " + custId);
		return lst;
	}
	
	@Override
	public Appointment viewAppointmentByScheduleId(int serviceScheduleId) throws AppointmentNotFoundException	{
		
		Optional<Appointment> optappointment = appointmentdao.findById(serviceScheduleId);
		if (!optappointment.isPresent())
			throw new AppointmentNotFoundException("No appointment found for Schedule Id " + serviceScheduleId);
		return optappointment.get();
	
	}

	@Override
	public Integer addAppointment(AppointmentDto appdto) throws SalonServiceNotFoundException {
		
		Appointment appointment = new Appointment();
		appointment.setAppointmentStatus(appdto.getAppointmentStatus());
		appointment.setCustomer(appdto.getCustomer());
		appointment.setPreferredDate(appdto.getPreffeDate());
		appointment.setSalonServiceSchedule(appdto.getSalonServiceSchedule());
		
		Appointment savedAppointment = appointmentdao.save(appointment);
		return savedAppointment.getAppointmentId();
		
	}

	@Override
	@Transactional
	public boolean editAppointment(AppointmentDto appdto) throws SalonServiceNotFoundException, AppointmentNotFoundException {
		Optional<Appointment> optapp = appointmentdao.findById(appdto.getAppointmentId());
		if(!optapp.isPresent())
			throw new AppointmentNotFoundException("No appointment found");
		Appointment appointment = optapp.get();
		appointment.setAppointmentStatus(appdto.getAppointmentStatus());
		appointment.setPreferredDate(appdto.getPreffeDate());
		appointment.setCustomer(appdto.getCustomer());
		appointment.setSalonServiceSchedule(appdto.getSalonServiceSchedule());
		Appointment persistedappointment = appointmentdao.save(appointment);
		return true;
	}

	@Override
	public boolean removeAppointment(int appointmentId) throws AppointmentNotFoundException {
		Appointment appointment = viewAppointmentById(appointmentId);
		if (appointment == null)
			throw new AppointmentNotFoundException("Appointment not found for id " + appointmentId);
		appointmentdao.delete(appointment);
		return true;
	}

	@Override
	public List<Appointment> viewAllAppointment() throws AppointmentNotFoundException {
		List<Appointment> lst = appointmentdao.findAll();
		if (lst.isEmpty()) {
			throw new AppointmentNotFoundException("No Appointments found");
		}
		return lst;
	}
	
}
