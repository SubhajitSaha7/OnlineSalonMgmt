package com.cg.salon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cg_payment")
public class OnlineSalon_Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "seq1")
	@SequenceGenerator(name = "seq1",sequenceName = "payment_seq1",allocationSize = 1)
	@Column(name = "payment_id")
	private long paymentId;
	
	@Column(name = "payment_type", length = 25, nullable = false)
	private String type;
	
	@Column(name = "payment_status", length = 25, nullable = false)
	private String status;
	
	@Column(name = "payment_card_name", length = 25, nullable = false)
	private String cardName;
	
	@Column(name = "payment_card_number", length = 25, nullable = false, unique = true)
	private String cardNumber;
	
	@Column(name = "payment_exp_date", length = 25, nullable = false)
	private String expiryDate;
	
	@Column(name = "payment_bank_id", length = 25, nullable = false)
	private String bankId;
	
	private OnlineSalon_Appointment appointment;
	private OnlineSalon_BankAccount bankAccount;
	
	
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	public String getType() {
		return type;
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
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	public OnlineSalon_Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(OnlineSalon_Appointment appointment) {
		this.appointment = appointment;
	}
	public OnlineSalon_BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(OnlineSalon_BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	public OnlineSalon_Payment(long paymentId, String type, String status, String cardName, String cardNumber,
			String expiryDate, String bankId, OnlineSalon_Appointment appointment,
			OnlineSalon_BankAccount bankAccount) {
		super();
		this.paymentId = paymentId;
		this.type = type;
		this.status = status;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.bankId = bankId;
		this.appointment = appointment;
		this.bankAccount = bankAccount;
	}
	@Override
	public String toString() {
		return " " + paymentId + " " + type + " " + status + " "
				+ cardName + " " + cardNumber + " " + expiryDate + " " + bankId + " ";
	}
	
	

}
