package com.cg.salon.testAppointment;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.salon.dao.IAppointmentDao;
import com.cg.salon.dao.ICustomerDao;
import com.cg.salon.dao.ISalonServiceScheduleDao;
import com.cg.salon.dto.AppointmentDto;
import com.cg.salon.entity.Appointment;
import com.cg.salon.entity.Customer;
import com.cg.salon.entity.SalonService;
import com.cg.salon.entity.SalonServiceSchedule;
import com.cg.salon.exceptions.AppointmentCancelException;
import com.cg.salon.exceptions.AppointmentNotFoundException;
import com.cg.salon.exceptions.CustomerNotFoundException;
import com.cg.salon.exceptions.SalonServiceScheduleNotFoundException;
import com.cg.salon.service.AppointmentServiceImpl;
import com.cg.salon.service.IAppointmentService;

@SpringBootTest
class TestAddAppointment {

	@Mock
	private IAppointmentDao appointmentdao;
	@Mock
	private ICustomerDao customerdao;
	@Mock
	private ISalonServiceScheduleDao scheduledao;

	@InjectMocks
	private IAppointmentService service = new AppointmentServiceImpl();

	@BeforeEach
	public void beforeEach() {
		Optional<Customer> optcust1 = Optional.of(new Customer(1, "Sam Verma", "samv@gmail.com", "8777452135",
				LocalDate.of(2000, 01, 23), "4B", "CB/7 Street", "Dum Dum", "Kolkata", "West Bengal", 700091));

		Optional<Customer> optcust2 = Optional.empty();
		when(customerdao.findById(1)).thenReturn(optcust1);
		when(customerdao.findById(2)).thenReturn(optcust2);
		Optional<SalonService> optservice1 = Optional
				.of(new SalonService(2, "Haircut", 250, "1 hour", 5, "CD Street", "Nagerbajar", "Jawed Habib"));

		Optional<SalonServiceSchedule> optschedule1 = Optional.of(new SalonServiceSchedule(1, 20,
				LocalDate.of(2021, 05, 26), "Available", "10am-2pm", optservice1.get()));
		Optional<SalonServiceSchedule> optschedule2 = Optional.empty();
		when(scheduledao.findById(1)).thenReturn(optschedule1);
		when(scheduledao.findById(2)).thenReturn(optschedule2);

		Appointment appointment = new Appointment();
		appointment.setAppointmentId(1);
		when(appointmentdao.save(any(Appointment.class))).thenReturn(appointment);
	}

	@Test
	@DisplayName(value = "testaddappointment1")
	void testAddAppointment1() throws CustomerNotFoundException, SalonServiceScheduleNotFoundException,
			AppointmentNotFoundException, AppointmentCancelException {
		AppointmentDto appdto = new AppointmentDto(4, LocalDate.of(2021, 05, 26), 1, 1, "Available");
		assertNotNull(service.addAppointment(appdto));
	}

	@Test
	@DisplayName(value = "testaddappointment2")
	void testAddAppointment2() throws CustomerNotFoundException, SalonServiceScheduleNotFoundException,
			AppointmentNotFoundException, AppointmentCancelException {
		AppointmentDto appdto = new AppointmentDto(2, LocalDate.of(2021, 05, 26), 2, 2, "Available");
		assertThrows(CustomerNotFoundException.class, () -> service.addAppointment(appdto));
	}

	@Test
	@DisplayName(value = "testaddappointment3")
	void testAddAppointment3() throws CustomerNotFoundException, SalonServiceScheduleNotFoundException,
			AppointmentNotFoundException, AppointmentCancelException {
		AppointmentDto appdto = new AppointmentDto(2, LocalDate.of(2021, 05, 26), 1, 2, "Available");
		assertThrows(SalonServiceScheduleNotFoundException.class, () -> service.addAppointment(appdto));
	}
	
}
