package com.cg.salon.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.salon.dao.ISalonServiceDao;
import com.cg.salon.dto.SalonServiceDto;
import com.cg.salon.entity.SalonService;
import com.cg.salon.exceptions.SalonServiceNotFoundException;
import com.cg.util.SalonConstraints;

@Service("salonservice")
public class SalonServiceImpl implements ISalonService {

	@Autowired
	private ISalonServiceDao salonservicedao;

	@Transactional
	@Override
	public Integer addSalonService(SalonServiceDto dto) {
		SalonService service = new SalonService();

		service.setDiscount(dto.getDiscount());
		service.setSalonAddress(dto.getSalonAddress());
		service.setSalonCentreName(dto.getSalonCentreName());
		service.setSalonLocation(dto.getSalonLocation());
		service.setServiceDuration(dto.getServiceDuration());
		service.setServiceName(dto.getServiceName());
		service.setServicePrice(dto.getServicePrice());

		SalonService savedservice = salonservicedao.save(service);
		return savedservice.getServiceId();
	}

	@Override
	public SalonService viewSalonServiceById(int sid) throws SalonServiceNotFoundException {

		Optional<SalonService> optservice = salonservicedao.findById(sid);
		if (!optservice.isPresent())
			throw new SalonServiceNotFoundException(SalonConstraints.SALON_SERVICE_NOT_EXIST + sid);
		return optservice.get();
	}

	@Override
	public List<SalonService> viewSalonServiceByName(String serviceName) throws SalonServiceNotFoundException {

		List<SalonService> lst = salonservicedao.findByServiceName(serviceName);
		if (lst.isEmpty())
			throw new SalonServiceNotFoundException(SalonConstraints.SALON_SERVICE_NOT_EXIST);
		return lst;
	}

	@Override
	public List<SalonService> viewSalonServiceByLocation(String serviceLocation) throws SalonServiceNotFoundException {

		List<SalonService> lst = salonservicedao.findBySalonLocation(serviceLocation);
		if (lst.isEmpty())
			throw new SalonServiceNotFoundException(SalonConstraints.SALON_SERVICE_NOT_EXIST);
		return lst;

	}

	@Transactional
	@Override
	public boolean editSalonService(SalonServiceDto dto) throws SalonServiceNotFoundException {

		Optional<SalonService> optservice = salonservicedao.findById(dto.getServiceId());
		if (!optservice.isPresent())
			throw new SalonServiceNotFoundException(SalonConstraints.SALON_SERVICE_NOT_EXIST);

		SalonService service = optservice.get();
		service.setServiceName(dto.getServiceName());
		service.setServicePrice(dto.getServicePrice());
		service.setDiscount(dto.getDiscount());
		service.setSalonAddress(dto.getSalonAddress());
		service.setSalonCentreName(dto.getSalonCentreName());
		service.setSalonLocation(dto.getSalonLocation());
		service.setServiceDuration(dto.getServiceDuration());
		SalonService persistedService = salonservicedao.save(service);
		return true;
	}
}