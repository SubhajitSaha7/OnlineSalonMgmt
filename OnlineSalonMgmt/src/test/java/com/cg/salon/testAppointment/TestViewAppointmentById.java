package com.cg.salon.testAppointment;

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

import com.cg.salon.dao.IAppointmentDao;
import com.cg.salon.entity.Appointment;
import com.cg.salon.exceptions.AppointmentNotFoundException;
import com.cg.salon.service.AppointmentServiceImpl;
import com.cg.salon.service.IAppointmentService;

@SpringBootTest
class TestViewAppointmentById {

	@Mock
	private IAppointmentDao appointmentDao;
	@InjectMocks
	private IAppointmentService service = new AppointmentServiceImpl();

	@BeforeEach
	public void beforeEach() {
		Optional<Appointment> optapp1 = Optional.of(new Appointment());
		Optional<Appointment> optapp2 = Optional.empty();
		Optional<Appointment> optapp3 = Optional.empty();
		when(appointmentDao.findById(1)).thenReturn(optapp1);
		when(appointmentDao.findById(100)).thenReturn(optapp2);
		when(appointmentDao.findById(200)).thenReturn(optapp3);
	}

	@Test
	@DisplayName(value = "TestViewAppointmentById for 1")
	void testViewAppointmentById1() throws AppointmentNotFoundException {
		assertNotNull(service.getAppointmentById(1));
	}

	@Test
	@DisplayName(value = "TestViewAppointmentById for 100")
	void testViewAppointmentById2() {
		assertThrows(AppointmentNotFoundException.class, () -> service.getAppointmentById(100));
	}
	
	@Test
	@DisplayName(value = "TestViewAppointmentById for 200")
	void testViewAppointmentById3() {
		assertThrows(AppointmentNotFoundException.class, () -> service.getAppointmentById(200));
	}

}
