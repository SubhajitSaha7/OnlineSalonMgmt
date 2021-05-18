package com.cg.salon.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.salon.dto.ViewAppointmentSuccessMessage;
import com.cg.salon.entity.Appointment;
import com.cg.salon.exceptions.AppointmentNotFoundException;
import com.cg.salon.service.IviewAppointmentService;

public class ViewAppointmentRestController {
	
	@Autowired
	private IAppointmentService service;
	
	@PutMapping("addappointmentbycustomerid/{custid}")
	public Appointment addAppointmentByCustomerId(@PathVariable("custid")int custId) throws CustomerNotFoundException {
		return addAppointmentByCustomerId(custId);
		
	}
	@putMapping("addappointmentbyscheduleid/{sid}")
	public Appointment addAppointmentByScheduleId(@PathVariable("sid")int serviceScheduleId) throws ServiceNotFoundException {
		return addAppointmentByScheduleId(serviceScheduleId);
		
	}
	@DeleteMapping
	public boolean DeleteAppointmentByAppointmentId(@PathVariable("appointmentid")int appointmentId) throws AppointmentNotFoundException {
		return deleteAppointmentByAppointmentId(appointmentId);
		
	}
}