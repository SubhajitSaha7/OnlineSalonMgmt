package com.cg.salon.testPayment;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.salon.dao.IAppointmentDao;
import com.cg.salon.dao.IBankAccountDao;
import com.cg.salon.dao.IPaymentDao;
import com.cg.salon.dto.PaymentDto;
import com.cg.salon.entity.Appointment;
import com.cg.salon.entity.BankAccount;
import com.cg.salon.entity.Payment;
import com.cg.salon.exceptions.AppointmentNotFoundException;
import com.cg.salon.exceptions.BankAccountNotFoundException;
import com.cg.salon.exceptions.PaymentNotFoundException;
import com.cg.salon.service.IPaymentService;

import com.cg.salon.service.PaymentServiceImpl;

@SpringBootTest
class TestAddPayment {

	@Mock
	private IAppointmentDao appdao;

	@Mock
	private IBankAccountDao bankaccdao;
	@Mock
	private IPaymentDao pmtdao;
	@InjectMocks
	private IPaymentService service = new PaymentServiceImpl();

	@BeforeEach
	public void beforeEach() {
		Optional<Appointment> optapp = Optional.of(new Appointment());
		Optional<Appointment> optapp2 = Optional.empty();
		when(appdao.findById(1)).thenReturn(optapp);
		when(appdao.findById(2)).thenReturn(optapp2);
		when(bankaccdao.findById(1)).thenReturn(Optional.of(new BankAccount()));
		when(bankaccdao.findById(2)).thenReturn(Optional.empty());
		Payment payment = new Payment();
		payment.setPaymentId(1);
		when(pmtdao.save(any(Payment.class))).thenReturn(payment);

	}

	@Test
	@DisplayName(value = "testaddpayment1")
	void testPayment1() throws PaymentNotFoundException, AppointmentNotFoundException, BankAccountNotFoundException {
		PaymentDto pmtdto = new PaymentDto(4, "card", "payment successfull", 1, 1);
		assertNotNull(service.addPayment(pmtdto));
	}

	@Test
	@DisplayName(value = "testaddpayment2")
	void testPayment2() throws PaymentNotFoundException, AppointmentNotFoundException, BankAccountNotFoundException {
		PaymentDto pmtdto = new PaymentDto(2, "card", "payment successfull", 2, 1);
		assertThrows(AppointmentNotFoundException.class, () -> service.addPayment(pmtdto));
	}
}
