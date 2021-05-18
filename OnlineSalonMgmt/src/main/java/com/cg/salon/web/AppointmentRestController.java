package com.cg.salon.web;

import java.util.List;

import javax.management.ServiceNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.salon.dto.AppointmentDto;
import com.cg.salon.dto.AppointmentSuccessMessage;
import com.cg.salon.dto.SalonServiceSuccessMessage;
import com.cg.salon.entity.Appointment;
import com.cg.salon.exceptions.AppointmentNotFoundException;
import com.cg.salon.exceptions.CustomerNotFoundException;
import com.cg.salon.exceptions.SalonServiceNotFoundException;
import com.cg.salon.exceptions.ValidateAppointmentException;
import com.cg.salon.exceptions.ValidateSalonServiceException;
import com.cg.salon.service.IAppointmentService;

@RestController
public class AppointmentRestController {
	
	@Autowired
	private IAppointmentService service;
	
	@GetMapping("viewappointmentbyid/{appId}")
	public Appointment viewAppointmentById(@PathVariable("appId")int appId) throws AppointmentNotFoundException {
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

	@PostMapping("addappointment")
	public AppointmentSuccessMessage addAppointment(@Valid @RequestBody AppointmentDto appdto, BindingResult br) throws SalonServiceNotFoundException, ValidateAppointmentException {
		if (br.hasErrors())
			throw new ValidateAppointmentException(br.getFieldErrors());
		int aid= service.addAppointment(appdto);
		
		return new AppointmentSuccessMessage("Your generated appointment id is "+ aid);
		
	}
	
	@PutMapping("editappointment")
	public AppointmentSuccessMessage editAppointment(@Valid @RequestBody AppointmentDto appdto, BindingResult br) throws SalonServiceNotFoundException, AppointmentNotFoundException, ValidateAppointmentException {
		if (br.hasErrors())
		{
			throw new ValidateAppointmentException(br.getFieldErrors());
		}
		service.editAppointment(appdto);
		return new AppointmentSuccessMessage("Appointment Edited successfully");
	}
	
	@DeleteMapping("cancelappointment/{appid}")
	public AppointmentSuccessMessage removeAppointment(@PathVariable ("appid") int appointmentId) throws AppointmentNotFoundException {
		service.removeAppointment(appointmentId);	
		return new AppointmentSuccessMessage("Appointment deleted Successfully");
	}
	
	@GetMapping("viewallappointment")
	public List<Appointment> viewAllAppointments() throws AppointmentNotFoundException {
		return service.viewAllAppointment();
	}

}
