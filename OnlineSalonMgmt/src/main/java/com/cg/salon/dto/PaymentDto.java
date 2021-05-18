package com.cg.salon.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.cg.salon.entity.Appointment;
import com.cg.salon.entity.BankAccount;

public class PaymentDto {

	private long paymentId;
	
	private String type;
	
	private String status;
	 
	private Appointment appointment;
	
	private BankAccount bankAccount;
	
	
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	public String getType() {
		return type;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	public PaymentDto() {
		super();
		
	}
	public PaymentDto(long paymentId, String type, String status, Appointment appointment, BankAccount bankAccount) {
		super();
		this.paymentId = paymentId;
		this.type = type;
		this.status = status;
		this.appointment = appointment;
		this.bankAccount = bankAccount;
	}
	

}
