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
@Table(name = "cg_payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "seq1")
	@SequenceGenerator(name = "seq1",sequenceName = "payment_seq1",allocationSize = 1)
	@Column(name = "payment_id")
	private long paymentId;
	
	@Column(name = "payment_type", length = 25, nullable = false)
	private String type;
	
	@Column(name = "payment_status", length = 25, nullable = false)
	private String status;
	 
	
	
	@Column(name = "payment_bank_id", length = 25, nullable = false)
	private String bankId;
	
	@ManyToOne
	@JoinColumn(name = "bank_account_id", referencedColumnName = "bank_card_no")
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
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return " " + paymentId + " " + type + " " + status + " " + bankId + " ";
	}
	
	
	

}
