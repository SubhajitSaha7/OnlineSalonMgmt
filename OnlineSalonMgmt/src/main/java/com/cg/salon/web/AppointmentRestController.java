package com.cg.salon.web;

import java.util.List;

import javax.management.ServiceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.cg.salon.dto.AppointmentSuccessMessage;
import com.cg.salon.entity.Appointment;
import com.cg.salon.exceptions.AppointmentNotFoundException;
import com.cg.salon.exceptions.CustomerNotFoundException;
import com.cg.salon.service.IAppointmentService;

public class AppointmentRestController {
	
	@Autowired
	private IAppointmentService service;
	
	@GetMapping("viewappointmentbyid/{appId}")
	public Appointment viewAppointmentById(@PathVariable("appId")int appId) throws AppointmentNotFoundException {
		System.out.println("get");
		return viewAppointmentById(appId);
		
	}
	
	@GetMapping("viewappointmentbycustomerid/{custid}")
	public List<Appointment> viewAppointmentByCustomerId(@PathVariable("custid")int custId) throws AppointmentNotFoundException {
		return viewAppointmentByCustomerId(custId);
		
	}
	
	@GetMapping("viewappointmentbyscheduleid/{sid}")
	public Appointment viewAppointmentByScheduleId(@PathVariable("sid")int serviceScheduleId) throws AppointmentNotFoundException {
		return viewAppointmentByScheduleId(serviceScheduleId);
		
	}

	@PutMapping("addappointmentbycustomerid/{custid}")
	public Appointment addAppointmentByCustomerId(@PathVariable("custid")int custId) throws CustomerNotFoundException {
		return addAppointmentByCustomerId(custId);
		
	}
	@PutMapping("addappointmentbyscheduleid/{sid}")
	public Appointment addAppointmentByScheduleId(@PathVariable("sid")int serviceScheduleId) throws ServiceNotFoundException {
		return addAppointmentByScheduleId(serviceScheduleId);
		
	}
	@DeleteMapping
	public boolean deleteAppointmentByAppointmentId(@PathVariable("appointmentid")int appointmentId) throws AppointmentNotFoundException {
		return deleteAppointmentByAppointmentId(appointmentId);
		
	}

}
