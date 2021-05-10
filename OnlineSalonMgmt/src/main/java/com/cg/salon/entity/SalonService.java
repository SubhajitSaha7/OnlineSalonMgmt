package com.cg.salon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cg_salon_service")
public class SalonService {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "seq1")
	@SequenceGenerator(name = "seq1",sequenceName = "salon_service_seq1",allocationSize = 1)
	@Column(name = "salon_service_id")
	private Integer serviceId;
	
	@Column(name = "service_name", length = 25, nullable = false)
	private String serviceName;
	
	@Column(name = "service_price", length = 10, nullable = false)
	private String servicePrice;
	
	@Column(name = "service_duration", length = 25, nullable = false)
	private String serviceDuration;
	
	@Column(name = "service_discount")
	private Integer discount;
	
	@ManyToOne
	@JoinColumn(name = "salon_id", referencedColumnName = "salon_id")
	private Salon salon;
	
	
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
	public String getServicePrice() {
		return servicePrice;
	}
	public void setServicePrice(String servicePrice) {
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
	public Salon getSalon() {
		return salon;
	}
	public void setSalon(Salon salon) {
		this.salon = salon;
	}
	public SalonService() {
		super();
	}
	@Override
	public String toString() {
		return " " + serviceId + " " + serviceName + " "
				+ servicePrice + " " + serviceDuration + " " + discount + " ";
	}
	
	
	

}
