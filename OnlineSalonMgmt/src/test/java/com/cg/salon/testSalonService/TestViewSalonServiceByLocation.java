package com.cg.salon.testSalonService;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
class TestViewSalonServiceByLocation {

	@Mock
	private ISalonServiceDao salonservicedao;
	
	@InjectMocks
	private ISalonService salonservice= new SalonServiceImpl();

	@BeforeEach
	public void beforeEach()
	{
	
		List<SalonService> lst= new ArrayList<>();
		lst.add(new SalonService(1, "Haircut",150,"40 minutes",5, "24, CB Apartment","Nagerbajar","Jawed Habib"));
		lst.add(new SalonService(2,"Facial", 250 ,"1 hour 30 minutes",5, "24, CB Apartment", "Nagerbajar","Jawed Habib"));
		List<SalonService> lst2= new ArrayList<>();
		List<SalonService> lst3= new ArrayList<>();
		when(salonservicedao.findBySalonLocation("Nagerbajar")).thenReturn(lst);
		when(salonservicedao.findBySalonLocation("Chiriyamore")).thenReturn(lst2);
		when(salonservicedao.findBySalonLocation("Satgachi")).thenReturn(lst3);
	}
	
	@Test
	@DisplayName(value= "testViewSalonServiceByLocation for Nagerbajar")
	void testViewSalonServiceByLocation1() throws SalonServiceNotFoundException
	{
		assertTrue(salonservice.viewSalonServiceByLocation("Nagerbajar").size()>0);
	}
	
	@Test
	@DisplayName(value="testViewSalonServiceByLocation for Chiriyamore")
	void testViewSalonServiceByLocation2()
	{
		assertThrows(SalonServiceNotFoundException.class, ()-> salonservice.viewSalonServiceByLocation("Chiriyamore"));
	}
	
	@Test
	@DisplayName(value="testViewSalonServiceByLocation for Satgachi")
	void testViewSalonServiceByLocation3()
	{
		assertThrows(SalonServiceNotFoundException.class, ()-> salonservice.viewSalonServiceByLocation("Satgachi"));
	}
}