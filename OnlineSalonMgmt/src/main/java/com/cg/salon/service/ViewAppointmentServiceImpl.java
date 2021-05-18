package com.cg.salon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.salon.dao.IAppointmentDao;
import com.cg.salon.dto.AppointmentDto;
import com.cg.salon.entity.Appointment;
import com.cg.salon.exceptions.AppointmentNotFoundException;
import com.cg.salon.exceptions.SalonServiceNotFoundException;

@Service("viewappointment")
public class ViewAppointmentServiceImpl implements IAppointmentService{

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

	@Override
	public Appointment addAppointment(AppointmentDto appdto) throws SalonServiceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editAppointment(AppointmentDto appdto)
			throws SalonServiceNotFoundException, AppointmentNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAppointment(long appointmentId) throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Appointment> viewAppointment() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
