package com.cg.salon.testCustomer;

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

import com.cg.salon.dao.ICustomerDao;
import com.cg.salon.entity.Customer;
import com.cg.salon.exceptions.CustomerNotFoundException;
import com.cg.salon.service.CustomerServiceImpl;
import com.cg.salon.service.ICustomerService;

@SpringBootTest
class TestViewCustomerById {

	@Mock
	private ICustomerDao customerDao;

	@InjectMocks
	private ICustomerService service = new CustomerServiceImpl();

	@BeforeEach
	public void beforeEach() {
		Optional<Customer> optcust1 = Optional.of(new Customer());
		Optional<Customer> optcust2 = Optional.empty();
		Optional<Customer> optcust3 = Optional.empty();
		when(customerDao.findById(1)).thenReturn(optcust1);
		when(customerDao.findById(6)).thenReturn(optcust2);
		when(customerDao.findById(100)).thenReturn(optcust3);
	}

	@Test
	@DisplayName(value = "TestViewCustomerById for 1")
	void testViewCustomerById1() throws CustomerNotFoundException {
		assertNotNull(service.viewCustomerById(1));
	}

	@Test
	@DisplayName(value = "TestViewCustomerById for 6")
	void testViewCustomerById2() {
		assertThrows(CustomerNotFoundException.class, () -> service.viewCustomerById(6));
	}

	@Test
	@DisplayName(value = "TestViewCustomerById for 100")
	void testViewCustomerById3() {
		assertThrows(CustomerNotFoundException.class, () -> service.viewCustomerById(100));
	}
}
