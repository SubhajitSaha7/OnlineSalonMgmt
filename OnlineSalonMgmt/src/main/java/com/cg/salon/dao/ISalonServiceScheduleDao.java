package com.cg.salon.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.salon.dto.SalonServiceDto;
import com.cg.salon.dto.SalonServiceScheduleDto;
import com.cg.salon.entity.SalonServiceSchedule;
import com.cg.salon.exceptions.SalonServiceScheduleNotFoundException;

@Repository("salonservicescheduledao")
public interface ISalonServiceScheduleDao extends JpaRepository<SalonServiceSchedule, Integer>{
	public Integer createSchedule(SalonServiceScheduleDto dto);
	public List<SalonServiceSchedule> viewSalonServiceScheduleById(int sid)throws SalonServiceScheduleNotFoundException;
	public List<SalonServiceSchedule> viewSalonServiceScheduleByDate(LocalDate date)throws SalonServiceScheduleNotFoundException;
	@Query("from SalonServiceSchedule s inner join fetch s.SalonService t where t.serviceId=:sid")
	public List<SalonServiceSchedule> viewSalonServiceScheduleByServiceId(@Param("sid")int serid )throws SalonServiceScheduleNotFoundException;
	public boolean editSalonServiceSchedule(SalonServiceScheduleDto dto)throws SalonServiceScheduleNotFoundException;
}
