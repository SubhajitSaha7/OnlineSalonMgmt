package com.cg.salon.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.salon.dao.ISalonServiceDao;
import com.cg.salon.dao.ISalonServiceScheduleDao;
import com.cg.salon.dto.SalonServiceScheduleDto;
import com.cg.salon.entity.SalonService;
import com.cg.salon.entity.SalonServiceSchedule;
import com.cg.salon.exceptions.SalonServiceNotFoundException;
import com.cg.salon.exceptions.SalonServiceScheduleNotFoundException;
import com.cg.salon.exceptions.ScheduleCancelException;
import com.cg.util.SalonConstraints;

@Service("salonserviceschedule")
public class SalonServiceScheduleImpl implements ISalonServiceSchedule {

	@Autowired
	private ISalonServiceScheduleDao salonservicescheduledao;

	@Autowired
	private ISalonServiceDao salonservicedao;

	@Transactional
	@Override
	public Integer createSchedule(SalonServiceScheduleDto dto) throws SalonServiceNotFoundException {
		Optional<SalonService> optsalon = salonservicedao.findById(dto.getSalonServiceId());
		if (!optsalon.isPresent())
			throw new SalonServiceNotFoundException(SalonConstraints.SALON_SERVICE_NOT_FOUND);

		SalonServiceSchedule schedule = new SalonServiceSchedule();

		schedule.setScheduleDate(dto.getScheduleDate());
		schedule.setSlot(dto.getSlot());
		schedule.setSalonService(optsalon.get());
		schedule.setNoofappointments(dto.getNoofappointments());
		schedule.setScheduleStatus(SalonConstraints.AVAILABLE);

		SalonServiceSchedule savedschedule = salonservicescheduledao.save(schedule);
		return savedschedule.getServiceScheduleId();
	}

	@Override
	public SalonServiceSchedule viewSalonServiceScheduleById(int sid) throws SalonServiceScheduleNotFoundException {

		Optional<SalonServiceSchedule> optschedule = salonservicescheduledao.findById(sid);
		if (!optschedule.isPresent())
			throw new SalonServiceScheduleNotFoundException(SalonConstraints.SALON_SCHEDULE_NOT_EXIST + sid);
		return optschedule.get();
	}

	@Override
	public List<SalonServiceSchedule> viewSalonServiceScheduleByDate(LocalDate scheduleDate)
			throws SalonServiceScheduleNotFoundException {

		List<SalonServiceSchedule> lstschedules = salonservicescheduledao.findByScheduleDate(scheduleDate);
		if (lstschedules.isEmpty())
			throw new SalonServiceScheduleNotFoundException(SalonConstraints.SALON_SCHEDULE_EMPTY);
		return lstschedules;
	}

	@Override
	public List<SalonServiceSchedule> viewSalonServiceScheduleByServiceId(int serid)
			throws SalonServiceScheduleNotFoundException {

		List<SalonServiceSchedule> id = salonservicescheduledao.viewSalonServiceScheduleByServiceId(serid);
		if (id.isEmpty())
			throw new SalonServiceScheduleNotFoundException(SalonConstraints.SALON_SCHEDULE_NOT_EXIST);
		return id;

	}

	@Transactional
	@Override
	public boolean cancelSchedule(int scheduleId)
			throws SalonServiceScheduleNotFoundException, ScheduleCancelException {

		Optional<SalonServiceSchedule> optservice = salonservicescheduledao.findById(scheduleId);
		if (!optservice.isPresent())
			throw new SalonServiceScheduleNotFoundException(SalonConstraints.SALON_SCHEDULE_NOT_EXIST);

		SalonServiceSchedule schedule = optservice.get();
		if (schedule.getScheduleDate().isBefore(LocalDate.now()) || schedule.getScheduleDate().isEqual(LocalDate.now()))
			throw new ScheduleCancelException(SalonConstraints.SCHEDULE_NOT_CANCEL);
		schedule.setScheduleStatus(SalonConstraints.CANCELLED);

		salonservicescheduledao.save(schedule);

		return true;
	}
}