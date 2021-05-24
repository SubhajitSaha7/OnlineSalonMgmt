package com.cg.salon.testAppointment;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.salon.dao.IAppointmentDao;
import com.cg.salon.dao.ICustomerDao;
import com.cg.salon.dao.ISalonServiceDao;
import com.cg.salon.dao.ISalonServiceScheduleDao;
import com.cg.salon.entity.Appointment;
import com.cg.salon.entity.Customer;
import com.cg.salon.entity.SalonService;
import com.cg.salon.entity.SalonServiceSchedule;
import com.cg.salon.exceptions.AppointmentNotFoundException;
import com.cg.salon.service.AppointmentServiceImpl;
import com.cg.salon.service.IAppointmentService;

@SpringBootTest
class TestViewAllAppointment {

	@Mock
	private IAppointmentDao appointmentdao;

	@Mock
	private ISalonServiceScheduleDao scheduledao;

	@Mock
	private ISalonServiceDao servicedao;

	@Mock
	private ICustomerDao customerdao;

	@InjectMocks
	private IAppointmentService service = new AppointmentServiceImpl();

	List<Appointment> list1 = new ArrayList<>();

	@BeforeEach
	public void beforeEach() {

		Optional<Customer> optcustomer = Optional.of(new Customer(1, "Sam Verma", "samv@gmail.com", "8777452135",
				LocalDate.of(2000, 01, 23), "4B", "CB/7 Street", "Dum Dum", "Kolkata", "West Bengal", 700091));

		Optional<SalonService> optservice = Optional
				.of(new SalonService(2, "Haircut", 250, "1 hour", 5, "CD Street", "Nagerbajar", "Jawed Habib"));

		Optional<SalonServiceSchedule> optschedule = Optional.of(
				new SalonServiceSchedule(2, 20, LocalDate.of(2021, 05, 26), "Available", "10am-2pm", optservice.get()));

		list1.add(new Appointment(1, LocalDate.of(2021, 05, 26), optcustomer.get(), optschedule.get(),
				"Booking Successfull"));
		list1.add(new Appointment(1, LocalDate.of(2021, 05, 26), optcustomer.get(), optschedule.get(),
				"Booking Successfull"));
		when(appointmentdao.findAll()).thenReturn(list1);

	}

	@Test
	@DisplayName(value = "testviewallappointment")
	void testViewAllAppointment() throws AppointmentNotFoundException {

		assertNotNull(service.viewAllAppointment());
	}

}
