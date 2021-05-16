package com.cg.salon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.salon.dao.IAppointmentDao;
import com.cg.salon.entity.Appointment;
import com.cg.salon.exceptions.AppointmentNotFoundException;

@Service("viewappointment")
public class ViewAppointmentServiceImpl implements IviewAppointmentService{

	@Autowired
	private IAppointmentDao appointmentdao;
	
	
	
	@Override
	public Appointment viewAppointmentById(int appId) throws AppointmentNotFoundException {
		
		Optional<Appointment> optappointment = appointmentdao.findById(appId);
		if (!optappointment.isPresent())
			throw new AppointmentNotFoundException("No Appointment exists for appointment id " + appId);
		return optappointment.get();
	}
	
	public List<Appointment> viewAppointmentByCustomerId(int custId) throws AppointmentNotFoundException	{
		
		List<Appointment> lst = appointmentdao.viewAppointmentByCustomerId(custId);
		if(lst.isEmpty())
			throw new AppointmentNotFoundException("No appointment found for Customer Id " + custId);
		return lst;
	}
	
	public Appointment viewAppointmentByScheduleId(int serviceScheduleId) throws AppointmentNotFoundException	{
		
		Optional<Appointment> optappointment = appointmentdao.findById(serviceScheduleId);
		if (!optappointment.isPresent())
			throw new AppointmentNotFoundException("No appointment found for Schedule Id " + serviceScheduleId);
		return optappointment.get();
	
	}
	
}
