package com.cg.salon.testBankAccount;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.salon.dao.IBankAccountDao;
import com.cg.salon.dto.BankAccountDto;

import com.cg.salon.entity.BankAccount;
import com.cg.salon.service.BankAccountServiceImpl;
import com.cg.salon.service.IBankAccountService;

@SpringBootTest
class TestAddBankAccount {

	@Mock
	private IBankAccountDao bankaccdao;

	@InjectMocks
	private IBankAccountService service = new BankAccountServiceImpl();

	BankAccountDto bankaccdto;
	BankAccount bankacc;

	@BeforeEach
	public void beforeEach() {

		bankaccdto = new BankAccountDto();
		bankacc = new BankAccount();

		bankaccdto.setAmount(1000.0);
		bankaccdto.setBankName("SBI");
		bankaccdto.setCardName("Anirban Mukherjee");
		bankaccdto.setCardnumber("2341567432459875");
		bankaccdto.setCvvNo(789);
		bankaccdto.setExpiryDate(LocalDate.of(2021, 07, 20));
		bankaccdto.setIfscNo("SBI0123456789");

		bankacc.setAmount(bankaccdto.getAmount());
		bankacc.setBankName(bankaccdto.getBankName());
		bankacc.setCardName(bankaccdto.getCardName());
		bankacc.setCardNumber(bankaccdto.getCardName());
		bankacc.setCvvNo(bankaccdto.getCvvNo());
		bankacc.setExpiryDate(bankaccdto.getExpiryDate());
		bankacc.setIfscNo(bankaccdto.getIfscNo());

		when(bankaccdao.save(any(BankAccount.class))).thenReturn(bankacc);
	}

	@Test
	@DisplayName(value = "testaddbankaccount")
	void testBankAccount1() {
		assertNotNull(service.addBankAccount(bankaccdto));

	}

}
