package com.cg.salon.service;

import java.util.List;

import com.cg.salon.dto.SalonServiceDto;
import com.cg.salon.entity.SalonService;
import com.cg.salon.exceptions.SalonServiceNotFoundException;

public interface ISalonService {

	public Integer addSalonService(SalonServiceDto dto);

	public SalonService getSalonServiceById(int sid) throws SalonServiceNotFoundException;

	public List<SalonService> getSalonServiceByName(String serviceName) throws SalonServiceNotFoundException;

	public List<SalonService> getSalonServiceByLocation(String salonLocation) throws SalonServiceNotFoundException;

	public boolean editSalonService(SalonServiceDto dto) throws SalonServiceNotFoundException;
	
	public List<SalonService> getAllSalonService() throws SalonServiceNotFoundException;
}