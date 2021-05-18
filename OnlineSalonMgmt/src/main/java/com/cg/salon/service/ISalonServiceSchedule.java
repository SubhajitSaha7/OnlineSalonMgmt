package com.cg.salon.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.salon.dto.SalonServiceDto;
import com.cg.salon.dto.SalonServiceScheduleDto;
import com.cg.salon.entity.SalonServiceSchedule;
import com.cg.salon.exceptions.SalonServiceScheduleNotFoundException;

public interface ISalonServiceSchedule {

	public Integer createSchedule(SalonServiceScheduleDto dto);
	public SalonServiceSchedule viewSalonServiceScheduleById(int sid)throws SalonServiceScheduleNotFoundException;
	public List<SalonServiceSchedule> viewSalonServiceScheduleByDate(LocalDate date)throws SalonServiceScheduleNotFoundException;
	
	public boolean editSalonServiceSchedule(SalonServiceScheduleDto dto)throws SalonServiceScheduleNotFoundException;
}
