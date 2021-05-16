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
	private IviewAppointmentService service;
	
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


}
