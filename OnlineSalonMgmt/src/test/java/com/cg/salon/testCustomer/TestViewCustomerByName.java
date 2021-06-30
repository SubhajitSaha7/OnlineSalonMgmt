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
class TestViewCustomerByName {

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
		when(customerDao.findByName("Sam Kumar")).thenReturn(lst);
		when(customerDao.findByName("Jatin Agarwal")).thenReturn(lst2);
		when(customerDao.findByName("Pinky Das")).thenReturn(lst3);

	}

	@Test
	@DisplayName(value = "TestViewCustomerByName for Sam Kumar")
	void testViewCustomerByName1() throws CustomerNotFoundException {
		assertTrue(service.getCustomerByName("Sam Kumar").size() > 0);
	}

	@Test
	@DisplayName(value = "TestViewCustomerByName for Jatin Agarwal")
	void testViewCustomerByName2() {
		assertThrows(CustomerNotFoundException.class, () -> service.getCustomerByName("Jatin Agarwal"));
	}

	@Test
	@DisplayName(value = "TestViewCustomerByName for Pinky Das")
	void testViewCustomerByName3() {
		assertThrows(CustomerNotFoundException.class, () -> service.getCustomerByName("Pinky Das"));
	}
}
