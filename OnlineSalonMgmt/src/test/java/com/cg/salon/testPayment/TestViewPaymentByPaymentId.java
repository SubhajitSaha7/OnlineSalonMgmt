package com.cg.salon.testPayment;

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

import com.cg.salon.dao.IPaymentDao;

import com.cg.salon.entity.Payment;

import com.cg.salon.exceptions.PaymentNotFoundException;

import com.cg.salon.service.IPaymentService;
import com.cg.salon.service.PaymentServiceImpl;

@SpringBootTest
class TestViewPaymentByPaymentId {
	@Mock
	private IPaymentDao paymentdao;
	@InjectMocks
	private IPaymentService service = new PaymentServiceImpl();

	@BeforeEach
	public void beforeEach() {
		Optional<Payment> optpmt1 = Optional.of(new Payment());
		Optional<Payment> optpmt2 = Optional.empty();
		Optional<Payment> optpmt3 = Optional.empty();
		when(paymentdao.findById(1)).thenReturn(optpmt1);
		when(paymentdao.findById(4)).thenReturn(optpmt2);
		when(paymentdao.findById(-9)).thenReturn(optpmt3);

	}

	@Test
	@DisplayName(value = "testviewbypaymentid for 1")
	void testviewbyPaymentId1() throws PaymentNotFoundException {
		assertNotNull(service.getPaymentByPaymentId(1));

	}

	@Test
	@DisplayName(value = "testviewbypaymentid for 4")
	void testviewbyPaymentId2() throws PaymentNotFoundException {
		assertThrows(PaymentNotFoundException.class, () -> service.getPaymentByPaymentId(4));

	}

	@Test
	@DisplayName(value = "testviewbypaymentid for -9")
	void testviewbyPaymentId3() throws PaymentNotFoundException {
		assertThrows(PaymentNotFoundException.class, () -> service.getPaymentByPaymentId(-9));

	}

}
