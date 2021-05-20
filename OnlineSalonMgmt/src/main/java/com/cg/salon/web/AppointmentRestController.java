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
import com.cg.salon.exceptions.AppointmentCancelException;
import com.cg.salon.exceptions.AppointmentNotFoundException;
import com.cg.salon.exceptions.CustomerNotFoundException;
import com.cg.salon.exceptions.SalonServiceNotFoundException;
import com.cg.salon.exceptions.SalonServiceScheduleNotFoundException;
import com.cg.salon.exceptions.ValidateAppointmentException;
import com.cg.salon.exceptions.ValidateSalonServiceException;
import com.cg.salon.service.IAppointmentService;
import com.cg.util.SalonConstraints;

@RestController
public class AppointmentRestController {

	@Autowired
	private IAppointmentService service;

	@GetMapping("viewappointmentbyid/{appId}")
	public Appointment viewAppointmentById(@PathVariable("appId") int appId) throws AppointmentNotFoundException {
		return service.viewAppointmentById(appId);

	}

	@GetMapping("viewappointmentbycustomerid/{custid}")
	public List<Appointment> viewAppointmentByCustomerId(@PathVariable("custid") int custId)
			throws AppointmentNotFoundException {
		return service.viewAppointmentByCustomerId(custId);

	}

	@GetMapping("viewappointmentbyscheduleid/{sid}")
	public Appointment viewAppointmentByScheduleId(@PathVariable("sid") int serviceScheduleId)
			throws AppointmentNotFoundException {
		return service.viewAppointmentByScheduleId(serviceScheduleId);

	}

	@PostMapping("addappointment")
	public AppointmentSuccessMessage addAppointment(@Valid @RequestBody AppointmentDto appdto, BindingResult br)
			throws SalonServiceNotFoundException, ValidateAppointmentException, CustomerNotFoundException,
			SalonServiceScheduleNotFoundException, AppointmentNotFoundException, AppointmentCancelException {
		if (br.hasErrors())
			throw new ValidateAppointmentException(br.getFieldErrors());
		int aid = service.addAppointment(appdto);

		return new AppointmentSuccessMessage(SalonConstraints.APPOINTMENT_CREATED + aid);

	}

	@PutMapping("cancelappointment/{appid}")
	public AppointmentSuccessMessage cancelAppointment(@PathVariable("appid") int appointmentId)
			throws SalonServiceNotFoundException, AppointmentNotFoundException, ValidateAppointmentException,
			CustomerNotFoundException, SalonServiceScheduleNotFoundException, AppointmentCancelException {

		service.cancelAppointment(appointmentId);
		return new AppointmentSuccessMessage(SalonConstraints.APPOINTMENT_CANCELLED);
	}

	@GetMapping("viewallappointment")
	public List<Appointment> viewAllAppointments() throws AppointmentNotFoundException {
		return service.viewAllAppointment();
	}

}
