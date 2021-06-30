package com.cg.salon.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.salon.dto.SalonServiceScheduleDto;
import com.cg.salon.entity.SalonServiceSchedule;
import com.cg.salon.exceptions.SalonServiceNotFoundException;
import com.cg.salon.exceptions.SalonServiceScheduleNotFoundException;
import com.cg.salon.exceptions.ScheduleCancelException;

public interface ISalonServiceSchedule {

	public Integer createSchedule(SalonServiceScheduleDto dto) throws SalonServiceNotFoundException;

	public SalonServiceSchedule getSalonServiceScheduleById(int sid) throws SalonServiceScheduleNotFoundException;

	public List<SalonServiceSchedule> getSalonServiceScheduleByDate(LocalDate date)
			throws SalonServiceScheduleNotFoundException;

	public List<SalonServiceSchedule> getSalonServiceScheduleByServiceId(int serid)
			throws SalonServiceScheduleNotFoundException;

	public boolean cancelSchedule(int scheduleId) throws SalonServiceScheduleNotFoundException, ScheduleCancelException;

    public List<SalonServiceSchedule> getAllSalonServiceSchedule() throws SalonServiceScheduleNotFoundException;
    
}
