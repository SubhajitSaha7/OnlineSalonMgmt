package com.cg.salon.web;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.cg.salon.exceptions.SalonServiceNotFoundException;
import com.cg.salon.exceptions.SalonServiceScheduleNotFoundException;
import com.cg.salon.exceptions.ScheduleCancelException;
import com.cg.salon.exceptions.ValidateSalonServiceScheduleException;
import com.cg.salon.service.ISalonServiceSchedule;
import com.cg.util.SalonConstants;

@RestController
public class SalonServiceScheduleRestController {

	@Autowired
	private ISalonServiceSchedule schedule;

	Logger logger = LoggerFactory.getLogger(SalonServiceScheduleRestController.class);

	@PostMapping("createschedule")
	public SalonServiceScheduleSuccessMessage addSchedule(@Valid @RequestBody SalonServiceScheduleDto scheduledto,
			BindingResult br) throws ValidateSalonServiceScheduleException, SalonServiceNotFoundException {
		logger.info("I am in addSchedule");

		if (br.hasErrors())
			throw new ValidateSalonServiceScheduleException(br.getFieldErrors());
		int sid = schedule.createSchedule(scheduledto);

		return new SalonServiceScheduleSuccessMessage(SalonConstants.SCHEDULE_ADDED + sid);

	}

	@PutMapping("editsalonservicescheule/{scheduleid}")
	public SalonServiceScheduleSuccessMessage cancelSchedule(@PathVariable("scheduleid") int scheduleId)
			throws ValidateSalonServiceScheduleException, SalonServiceScheduleNotFoundException,
			ScheduleCancelException {

		schedule.cancelSchedule(scheduleId);

		return new SalonServiceScheduleSuccessMessage(SalonConstants.SCHEDULE_CANCELLED);
	}

	@GetMapping("viewbysalonservicescheduleid/{salonservicescheduleid}")
	public SalonServiceSchedule viewSalonServiceScheduleById(
			@PathVariable("salonservicescheduleid") int salonServiceScheduleId)
			throws SalonServiceScheduleNotFoundException {
		return schedule.viewSalonServiceScheduleById(salonServiceScheduleId);
	}

	@GetMapping("viewbysalonservicescheduledate/{salonservicescheduledate}")
	public List<SalonServiceSchedule> viewSalonServiceScheduleByDate(
			@DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable("salonservicescheduledate") LocalDate salonServiceScheduleDate)
			throws SalonServiceScheduleNotFoundException {
		return schedule.viewSalonServiceScheduleByDate(salonServiceScheduleDate);
	}

	@GetMapping("viewbysalonservicescheduleserviceid/{salonservicescheduleserviceid}")
	public SalonServiceSchedule viewSalonServiceScheduleByServiceId(
			@PathVariable("salonservicescheduleserviceid") int salonServiceScheduleServiceId)
			throws SalonServiceScheduleNotFoundException {
		return schedule.viewSalonServiceScheduleById(salonServiceScheduleServiceId);
	}
}