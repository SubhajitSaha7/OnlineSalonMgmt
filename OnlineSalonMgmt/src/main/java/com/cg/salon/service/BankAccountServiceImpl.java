package com.cg.salon.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.salon.dao.IBankAccountDao;
import com.cg.salon.dto.BankAccountDto;
import com.cg.salon.entity.BankAccount;
import com.cg.salon.exceptions.BankAccountNotFoundException;
import com.cg.util.SalonConstraints;

@Service("BankAccount")
public class BankAccountServiceImpl implements IBankAccountService {

	@Autowired
	private IBankAccountDao bankAccountdao;

	@Override
	@Transactional
	public Integer addBankAccount(BankAccountDto dto) {

		BankAccount bankacc = new BankAccount();

		bankacc.setAmount(dto.getAmount());
		bankacc.setBankName(dto.getBankName());
		bankacc.setCardName(dto.getCardName());
		bankacc.setCardNumber(dto.getCardnumber());
		bankacc.setCvvNo(dto.getCvvNo());
		bankacc.setIfscNo(dto.getIfscNo());
		bankacc.setExpiryDate(dto.getExpiryDate());

		BankAccount savedbankacc = bankAccountdao.save(bankacc);
		return savedbankacc.getCvvNo();

	}

	@Override
	public BankAccount viewBankAccountBycvvNo(int cvvNo) throws BankAccountNotFoundException {

		Optional<BankAccount> optservice = bankAccountdao.findById(cvvNo);
		if (!optservice.isPresent())
			throw new BankAccountNotFoundException(SalonConstraints.BANK_ACCOUNT_NOT_FOUND);
		return optservice.get();

	}

	@Override
	@Transactional
	public boolean editBankAccount(BankAccountDto dto) throws BankAccountNotFoundException {

		Optional<BankAccount> optservice = bankAccountdao.findById(dto.getCvvNo());
		if (!optservice.isPresent())

			throw new BankAccountNotFoundException(SalonConstraints.BANK_ACCOUNT_NOT_FOUND);

		BankAccount bankacc = optservice.get();
		bankacc.setAmount(dto.getAmount());
		bankacc.setBankName(dto.getBankName());
		bankacc.setCardName(dto.getCardName());
		bankacc.setCardNumber(dto.getCardnumber());
		bankacc.setCvvNo(dto.getCvvNo());
		bankacc.setIfscNo(dto.getIfscNo());
		bankacc.setExpiryDate(dto.getExpiryDate());
		BankAccount persistedService = bankAccountdao.save(bankacc);
		return true;
	}

}
