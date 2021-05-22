package com.cg.salon.web;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.cg.salon.dto.SalonServiceDto;
import com.cg.salon.dto.SalonServiceSuccessMessage;
import com.cg.salon.entity.SalonService;
import com.cg.salon.exceptions.SalonServiceNotFoundException;
import com.cg.salon.exceptions.ValidateSalonServiceException;
import com.cg.salon.service.ISalonService;
import com.cg.util.SalonConstants;

@RestController
public class SalonServiceRestController {

	@Autowired
	private ISalonService service;

	Logger logger = LoggerFactory.getLogger(SalonServiceRestController.class);

	@PostMapping("addsalonservice")
	public SalonServiceSuccessMessage addSalonService(@Valid @RequestBody SalonServiceDto salondto, BindingResult br)
			throws ValidateSalonServiceException {
		logger.info("I am in add salon service");

		if (br.hasErrors())
			throw new ValidateSalonServiceException(br.getFieldErrors());
		int sid = service.addSalonService(salondto);

		return new SalonServiceSuccessMessage(SalonConstants.SALON_SERVICE_ADDED + sid);

	}

	@PutMapping("editsalonservice")
	public SalonServiceSuccessMessage editSalonService(@Valid @RequestBody SalonServiceDto salondto, BindingResult br)
			throws ValidateSalonServiceException, SalonServiceNotFoundException {
		if (br.hasErrors()) {
			throw new ValidateSalonServiceException(br.getFieldErrors());
		}
		service.editSalonService(salondto);
		return new SalonServiceSuccessMessage(SalonConstants.SALON_SERVICE_EDITED);
	}

	@GetMapping("viewbysalonservice/{salonservicename}")
	public List<SalonService> viewSalonServiceByName(@PathVariable("salonservicename") String salonServiceName)
			throws SalonServiceNotFoundException {
		return service.viewSalonServiceByName(salonServiceName);
	}

	@GetMapping("viewbysalonserviceid/{salonserviceid}")
	public SalonService viewSalonServiceById(@PathVariable("salonserviceid") int salonServiceId)
			throws SalonServiceNotFoundException {
		return service.viewSalonServiceById(salonServiceId);
	}

	@GetMapping("viewbysalonservicelocation/{salonservicelocation}")
	public List<SalonService> viewSalonServiceByLocation(
			@PathVariable("salonservicelocation") String salonServiceLocation) throws SalonServiceNotFoundException {
		return service.viewSalonServiceByLocation(salonServiceLocation);
	}
}
