package com.cg.salon.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.salon.dao.ISalonServiceScheduleDao;
import com.cg.salon.dto.SalonServiceScheduleDto;
import com.cg.salon.entity.SalonServiceSchedule;
import com.cg.salon.exceptions.SalonServiceScheduleNotFoundException;

@Service("salonserviceschedule")
public class SalonServiceScheduleImpl implements ISalonServiceSchedule{

	@Autowired
	private ISalonServiceScheduleDao salonservicescheduledao;
	
	@Transactional
	@Override
	public Integer createSchedule(SalonServiceScheduleDto dto) 
	{
		SalonServiceSchedule schedule= new SalonServiceSchedule();
		
		schedule.setScheduleDate(dto.getScheduleDate());
		schedule.setSlot(dto.getSlot());
		
		
		SalonServiceSchedule savedschedule= salonservicescheduledao.save(schedule);
		return savedschedule.getServiceScheduleId();
	}

	@Override
	public SalonServiceSchedule viewSalonServiceScheduleById(int sid) throws SalonServiceScheduleNotFoundException {
		
		Optional<SalonServiceSchedule> optschedule= salonservicescheduledao.findById(sid);
		if (!optschedule.isPresent())
			throw new SalonServiceScheduleNotFoundException("salon service schedule not exists for "+ sid);
		return optschedule.get();
	}

	@Override
	public List<SalonServiceSchedule> viewSalonServiceScheduleByDate(LocalDate date) throws SalonServiceScheduleNotFoundException {
		
		List<SalonServiceSchedule> dt= salonservicescheduledao.viewSalonServiceScheduleByDate(date);
		if (dt.isEmpty())
			throw new SalonServiceScheduleNotFoundException("No salon service found on this day");
		return dt;
	}

	@Override
	public List<SalonServiceSchedule> viewSalonServiceScheduleByServiceId(int serid) throws SalonServiceScheduleNotFoundException {
		
		List<SalonServiceSchedule> id= salonservicescheduledao.viewSalonServiceScheduleByServiceId(serid);
		if (id.isEmpty())
		throw new SalonServiceScheduleNotFoundException("No salon service found");
		return id;
		
	}

	@Transactional
	@Override
	public boolean editSalonServiceSchedule(SalonServiceScheduleDto dto) throws SalonServiceScheduleNotFoundException {
		
		Optional<SalonServiceSchedule> optservice= salonservicescheduledao.findById(dto.getServiceScheduleId());
		if (!optservice.isPresent())
			throw new SalonServiceScheduleNotFoundException("No salon service found");
		
		SalonServiceSchedule schedule= optservice.get();
		schedule.setScheduleDate(dto.getScheduleDate());
		schedule.setSlot(dto.getSlot());
		
		
		return true;
	}
}