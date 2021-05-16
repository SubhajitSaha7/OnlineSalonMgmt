package com.cg.salon.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.salon.dto.BankAccountDto;
import com.cg.salon.dto.BankAccountSuccessMessage;
import com.cg.salon.entity.BankAccount;
import com.cg.salon.exceptions.BankAccountNotFoundException;
import com.cg.salon.exceptions.ValidateBankAccountException;
import com.cg.salon.service.IBankAccountService;


public class BankAccountRestController {

	@Autowired
	private IBankAccountService service;
	
	@PostMapping("addBankAccountservice")
	public BankAccountSuccessMessage addBankAcc(@Valid @RequestBody BankAccountDto bankdto, BindingResult br) throws ValidateBankAccountException
	{
	
		if (br.hasErrors())
			throw new ValidateBankAccountException(br.getFieldErrors());
		int bid= service.addBankAccount(bankdto);
		
		return new BankAccountSuccessMessage("Bank Account added Successfully");
		
	}	
	
	@PutMapping("editBankAccount")
	public BankAccountSuccessMessage editBankAcc(@Valid @RequestBody BankAccountDto bankdto, BindingResult br) throws ValidateBankAccountException, BankAccountNotFoundException
	{
		if (br.hasErrors())
		{
			throw new ValidateBankAccountException(br.getFieldErrors());
		}
		service.editBankAccount(bankdto);
		return new BankAccountSuccessMessage("Bank Account edited successfully");
	}
	
	@GetMapping("viewbyBankAccountid/{BankAccountid}")
	public BankAccount viewBankAccountByCvvNo(@PathVariable("CvvNo") int BankAccountCvvNo) throws BankAccountNotFoundException
	{
		return service.viewBankAccountBycvvNo(BankAccountCvvNo);
	}
}
