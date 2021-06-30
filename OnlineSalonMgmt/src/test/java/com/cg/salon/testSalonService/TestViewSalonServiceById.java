package com.cg.salon.testSalonService;

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

import com.cg.salon.dao.ISalonServiceDao;
import com.cg.salon.entity.SalonService;
import com.cg.salon.exceptions.SalonServiceNotFoundException;
import com.cg.salon.service.ISalonService;
import com.cg.salon.service.SalonServiceImpl;

@SpringBootTest
class TestViewSalonServiceById {

	@Mock
	private ISalonServiceDao salonservicedao;
	
	@InjectMocks
	private ISalonService salonservice= new SalonServiceImpl();

	@BeforeEach
	public void beforeEach()
	{
		Optional<SalonService> optsalonservice1= Optional.of(new SalonService());
		Optional<SalonService> optsalonservice2= Optional.empty();
		Optional<SalonService> optsalonservice3= Optional.empty();
		when(salonservicedao.findById(1)).thenReturn(optsalonservice1);
		when(salonservicedao.findById(10)).thenReturn(optsalonservice2);
		when(salonservicedao.findById(20)).thenReturn(optsalonservice3);
	}
	
	@Test
	@DisplayName(value= "testviewsalonservicebyid for 1")
	void testViewSalonServiceById1() throws SalonServiceNotFoundException
	{
		assertNotNull(salonservice.getSalonServiceById(1));
	}
	
	@Test
	@DisplayName(value="testViewSalonServicebyid for 10")
	void testViewSalonServiceById2()
	{
		assertThrows(SalonServiceNotFoundException.class, ()->salonservice.getSalonServiceById(10));
		
	}

	@Test
	@DisplayName(value="testViewSalonServicebyid for 20")
	void testViewSalonServiceById3()
	{
		assertThrows(SalonServiceNotFoundException.class, ()->salonservice.getSalonServiceById(20));
		
	}
}