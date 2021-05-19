package com.cg.salon.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class SalonServiceDto {
	
	private Integer serviceId;
	
    @NotBlank(message = "Service name must not be blank")
	@Pattern(regexp = "([a-zA-Z]+)|([a-zA-Z]+[\\s][a-zA-Z]+)", message = "service name must contain alphabets")
	private String serviceName;
	
    @Min(value= 150, message = "Service price must be minimum 150.0")
	private Integer servicePrice;
	
	private String serviceDuration;
	
	@Max(value= 20, message = "discount can be upto 20")
	private Integer discount;
	
	private String salonAddress;
	
	private String salonLocation;
	
	private String salonCentreName;
	
	public SalonServiceDto()
	{
		
	}
	
	

	public Integer getServiceId() {
		return serviceId;
	}



	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}



	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Integer getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(Integer servicePrice) {
		this.servicePrice = servicePrice;
	}

	public String getServiceDuration() {
		return serviceDuration;
	}

	public void setServiceDuration(String serviceDuration) {
		this.serviceDuration = serviceDuration;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public String getSalonAddress() {
		return salonAddress;
	}

	public void setSalonAddress(String salonAddress) {
		this.salonAddress = salonAddress;
	}

	public String getSalonLocation() {
		return salonLocation;
	}

	public void setSalonLocation(String salonLocation) {
		this.salonLocation = salonLocation;
	}

	public String getSalonCentreName() {
		return salonCentreName;
	}

	public void setSalonCentreName(String salonCentreName) {
		this.salonCentreName = salonCentreName;
	}
	
	
}