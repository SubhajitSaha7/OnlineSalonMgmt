package com.cg.salon.web;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cg.salon.dto.SalonServiceScheduleDto;
import com.cg.salon.dto.SalonServiceScheduleSuccessMessage;
import com.cg.salon.entity.SalonServiceSchedule;
import com.cg.salon.exceptions.SalonServiceScheduleNotFoundException;
import com.cg.salon.exceptions.ValidateSalonServiceScheduleException;
import com.cg.salon.service.ISalonServiceSchedule;


@RestController
public class SalonServiceScheduleRestController {
	
	@Autowired
	private ISalonServiceSchedule schedule;
	
	@PostMapping("createschedule")
	public SalonServiceScheduleSuccessMessage addEmployee(@Valid @RequestBody SalonServiceScheduleDto scheduledto, BindingResult br) throws ValidateSalonServiceScheduleException
	{
		System.out.println("I am in add salon service schedule");
	
		if (br.hasErrors())
			throw new ValidateSalonServiceScheduleException(br.getFieldErrors());
		int sid= schedule.createSchedule(scheduledto);
		
		return new SalonServiceScheduleSuccessMessage("Your generated solon service schedule id is "+ sid);
		
	}	
	
	@PutMapping("editsalonservicescheule")
	public SalonServiceScheduleSuccessMessage editEmployee(@Valid @RequestBody 	SalonServiceScheduleDto scheduledto, BindingResult br) throws ValidateSalonServiceScheduleException, SalonServiceScheduleNotFoundException
	{
		if (br.hasErrors())
		{
			throw new ValidateSalonServiceScheduleException(br.getFieldErrors());
		}
		schedule.editSalonServiceSchedule(scheduledto);
		return new SalonServiceScheduleSuccessMessage("Salon service schedule edited successfully");
	}

	
	
	@GetMapping("viewbysalonservicescheduleid/{salonservicescheduleid}")
	public SalonServiceSchedule viewSalonServiceScheduleById(@PathVariable("salonservicescheduleid") int salonServiceScheduleId) throws SalonServiceScheduleNotFoundException
	{
		return schedule.viewSalonServiceScheduleById(salonServiceScheduleId);
	}
	
	@GetMapping("viewbysalonservicescheduledate/{salonservicescheduledate}")
	public List<SalonServiceSchedule> viewSalonServiceScheduleByDate(@PathVariable("salonservicescheduledate") LocalDate salonServiceScheduleDate) throws SalonServiceScheduleNotFoundException
	{
	return schedule.viewSalonServiceScheduleByDate(salonServiceScheduleDate);
	}
	@GetMapping("viewbysalonservicescheduleserviceid/{salonservicescheduleserviceid}")
	public SalonServiceSchedule viewSalonServiceScheduleByServiceId(@PathVariable("salonservicescheduleserviceid") int salonServiceScheduleServiceId) throws SalonServiceScheduleNotFoundException
	{
		return schedule.viewSalonServiceScheduleById(salonServiceScheduleServiceId);
	}
}