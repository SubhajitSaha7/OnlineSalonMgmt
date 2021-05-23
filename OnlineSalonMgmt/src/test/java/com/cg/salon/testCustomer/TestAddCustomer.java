package com.cg.salon.testCustomer;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.salon.dao.ICustomerDao;
import com.cg.salon.dto.CustomerDto;
import com.cg.salon.entity.Customer;
import com.cg.salon.exceptions.CustomerNotFoundException;
import com.cg.salon.service.CustomerServiceImpl;
import com.cg.salon.service.ICustomerService;

@SpringBootTest
class TestAddCustomer {

	@Mock
	private ICustomerDao customerDao;

	@InjectMocks
	private ICustomerService service = new CustomerServiceImpl();

	@BeforeEach
	public void beforeEach() {
		Customer persistedCustomer = new Customer(1, "Sam Kumar", "samkumar@gmail.com", "9000123654",
				LocalDate.of(2000, 01, 01), "2", "Private Road", "Nagerbajar", "Kolkata", "West Bengal", 700074);
		when(customerDao.save(any(Customer.class))).thenReturn(persistedCustomer);
	}

	@Test
	@DisplayName(value = "TestAddCustomer for Sam Kumar")
	void testAddCustomer1() throws CustomerNotFoundException {
		CustomerDto customerDto = new CustomerDto(1, "Sam Kumar", "samkumar@gmail.com", "9000123654",
				LocalDate.of(2000, 01, 01), "2", "Private Road", "Nagerbajar", "Kolkata", "West Bengal", 700074);
		assertNotNull(service.addCustomer(customerDto));

	}

}
