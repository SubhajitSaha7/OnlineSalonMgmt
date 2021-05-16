package com.cg.salon.service;

import com.cg.salon.dto.BankAccountDto;
import com.cg.salon.entity.BankAccount;
import com.cg.salon.exceptions.BankAccountNotFoundException;

public interface IBankAccountService{
	
	public Integer addBankAccount(BankAccountDto dto) ;
	
	public BankAccount viewBankAccountBycvvNo(Integer cvvNo)throws BankAccountNotFoundException;
	
	public boolean editBankAccount(BankAccountDto dto)throws BankAccountNotFoundException;
	
	

}