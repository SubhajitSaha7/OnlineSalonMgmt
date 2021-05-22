package com.cg.salon.testPayment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.salon.dao.IPaymentDao;
import com.cg.salon.entity.Appointment;
import com.cg.salon.entity.BankAccount;
import com.cg.salon.entity.Customer;
import com.cg.salon.entity.Payment;
import com.cg.salon.entity.SalonService;
import com.cg.salon.entity.SalonServiceSchedule;
import com.cg.salon.exceptions.PaymentNotFoundException;
import com.cg.salon.service.IPaymentService;
import com.cg.salon.service.PaymentServiceImpl;

@SpringBootTest
class TestViewAllPayment {

	@Mock
	private IPaymentDao paymentdao;

	@InjectMocks
	private IPaymentService service = new PaymentServiceImpl();

	@BeforeEach
	public void beforeEach() {

		Optional<Customer> optcustomer = Optional.of(new Customer(1, "Sam Verma", "samv@gmail.com", "8777452135",
				LocalDate.of(2000, 01, 23), "4B", "CB/7 Street", "Dum Dum", "Kolkata", "West Bengal", 700091));

		Optional<SalonService> optservice1 = Optional
				.of(new SalonService(2, "Haircut", 250, "1 hour", 5, "CD Street", "Nagerbajar", "Jawed Habib"));

		Optional<SalonServiceSchedule> optschedule = Optional.of(new SalonServiceSchedule(2, 20,
				LocalDate.of(2021, 05, 26), "Available", "10am-2pm", optservice1.get()));
		Optional<Appointment> apt = Optional.of(new Appointment(1, LocalDate.of(2021, 05, 26), optcustomer.get(),
				optschedule.get(), "Booking Successfull"));
		Optional<BankAccount> optbank = Optional.of(new BankAccount("1234234534564567", 5000.0, "SBI", "Vivek Gupta",
				LocalDate.of(2021, 06, 15), 665, "UTB0123456789"));

		List<Payment> list1 = new ArrayList<>();
		list1.add(new Payment(1, "card", "payment successfull", apt.get(), optbank.get()));
		when(paymentdao.findAll()).thenReturn(list1);

	}

	@Test
	@DisplayName(value = "positive_test_viewallpayment")
	void testviewAllPayment() throws PaymentNotFoundException {
		assertNotNull(service.viewAllPayment());

	}

}
