package com.cg.salon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cg_salon")
public class Salon {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "seq1")
	@SequenceGenerator(name = "seq1",sequenceName = "salon_seq1",allocationSize = 1)
	@Column(name = "salon_id")
	private Integer salonId;
	
	@Column(name = "salon_centre_name", length = 25, nullable = false)
	private String salonCentreName;
	
	@Column(name = "salon_address", length = 100, nullable = false)
	private String address;
	
	@Column(name = "salon_contactno", length = 25, nullable = false)
	private String contactNo;
	
	public Integer getSalonId() {
		return salonId; 
	}
	public void setSalonId(Integer salonId) {
		this.salonId = salonId;
	}
	public String getSalonCentreName() {
		return salonCentreName;
	}
	public void setSalonCentreName(String salonCentreName) {
		this.salonCentreName = salonCentreName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public Salon() {
		super();
	}
	@Override
	public String toString() {
		return " " + salonId + " " + salonCentreName + " " + address
				+ " " + contactNo + " ";
	}
	
	
}
