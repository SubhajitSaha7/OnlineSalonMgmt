package com.cg.salon.testCustomer;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.salon.dao.ICustomerDao;
import com.cg.salon.entity.Customer;
import com.cg.salon.exceptions.CustomerNotFoundException;
import com.cg.salon.service.CustomerServiceImpl;
import com.cg.salon.service.ICustomerService;

@SpringBootTest
class TestViewCustomerByContactNo {

	@Mock
	private ICustomerDao customerDao;

	@InjectMocks
	private ICustomerService service = new CustomerServiceImpl();

	@BeforeEach
	public void beforeEach() {

		List<Customer> lst = new ArrayList<>();
		lst.add(new Customer(1, "Sam Kumar", "samkumar@gmail.com", "9000123654", LocalDate.of(2000, 01, 01), "2",
				"Private Road", "Nagerbajar", "Kolkata", "West Bengal", 700074));
		lst.add(new Customer(2, "Souvik Kundu", "souvik@gmail.com", "9885328997", LocalDate.of(2000, 03, 15), "17",
				"Goruhata", "Nagerbajar", "Kolkata", "West Bengal", 700074));
		List<Customer> lst2 = new ArrayList<>();
		List<Customer> lst3 = new ArrayList<>();
		when(customerDao.findByContactNo("9000123654")).thenReturn(lst);
		when(customerDao.findByContactNo("9034628125")).thenReturn(lst2);
		when(customerDao.findByContactNo("7003456712")).thenReturn(lst3);

	}

	@Test
	@DisplayName(value = "TestViewCustomerByContactNo for 9000123654")
	void testViewCustomerByContactNo1() throws CustomerNotFoundException {
		assertTrue(service.getCustomerByContactNo("9000123654").size() > 0);
	}

	@Test
	@DisplayName(value = "TestViewCustomerByContactNo for 9034628125")
	void testViewCustomerByContactNo2() {
		assertThrows(CustomerNotFoundException.class, () -> service.getCustomerByContactNo("9034628125"));
	}

	@Test
	@DisplayName(value = "TestViewCustomerByContactNo for 7003456712")
	void testViewCustomerByContactNo3() {
		assertThrows(CustomerNotFoundException.class, () -> service.getCustomerByContactNo("7003456712"));
	}
}
