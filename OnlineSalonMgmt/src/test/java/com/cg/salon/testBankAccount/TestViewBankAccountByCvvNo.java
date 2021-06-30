package com.cg.salon.testBankAccount;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.salon.dao.IBankAccountDao;
import com.cg.salon.entity.BankAccount;
import com.cg.salon.exceptions.BankAccountNotFoundException;
import com.cg.salon.service.BankAccountServiceImpl;
import com.cg.salon.service.IBankAccountService;

@SpringBootTest
class TestViewBankAccountByCvvNo {

	@Mock
	private IBankAccountDao bankdao;
	@InjectMocks
	private IBankAccountService service = new BankAccountServiceImpl();

	@BeforeEach
	public void beforeEach() {
		Optional<BankAccount> optbank1 = Optional.of(new BankAccount());
		Optional<BankAccount> optbank2 = Optional.empty();
		Optional<BankAccount> optbank3 = Optional.empty();
		when(bankdao.findById(122)).thenReturn(optbank1);
		when(bankdao.findById(221)).thenReturn(optbank2);
		when(bankdao.findById(6754)).thenReturn(optbank3);

	}

	@Test
	@DisplayName(value = "testviewbycvvno for 122")
	void testviewbyCvvNo1() throws BankAccountNotFoundException {
		assertNotNull(service.getBankAccountBycvvNo(122));

	}

	@Test
	@DisplayName(value = "testviewbycvvno for 221")
	void testviewbyCvvNo2() throws BankAccountNotFoundException {
		assertThrows(BankAccountNotFoundException.class, () -> service.getBankAccountBycvvNo(221));

	}

	@Test
	@DisplayName(value = "testviewbycvvno for 6754")
	void testviewbyCvvNo3() throws BankAccountNotFoundException {
		assertThrows(BankAccountNotFoundException.class, () -> service.getBankAccountBycvvNo(6754));

	}

}
