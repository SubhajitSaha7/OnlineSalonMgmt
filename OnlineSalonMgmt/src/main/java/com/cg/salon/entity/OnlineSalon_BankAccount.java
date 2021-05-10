package com.cg.salon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cg_bank_acc")
public class OnlineSalon_BankAccount {
	
	@Column(name = "bank_card_no", length = 16, nullable = false, unique = true)
	private String cardNumber;
	
	@Column(name = "bank_amt")
	private long amount;
	
	@Column(name = "bank_name", length = 25, nullable = false)
	private String bankName;
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public long getAmount() { 
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public OnlineSalon_BankAccount(String cardNumber, long amount, String bankName) {
		super();
		this.cardNumber = cardNumber;
		this.amount = amount;
		this.bankName = bankName;
	}
	@Override
	public String toString() {
		return " " + cardNumber + " " + amount + " " + bankName
				+ " ";
	}
	

}
