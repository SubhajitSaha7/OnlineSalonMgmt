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
class TestViewSalonServiceByName {

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
		when(salonservicedao.findByServiceName("Haircut")).thenReturn(lst);
		when(salonservicedao.findByServiceName("repair")).thenReturn(lst2);
		when(salonservicedao.findByServiceName("call")).thenReturn(lst3);
	}
	
	@Test
	@DisplayName(value= "testViewSalonServiceByName for Haircut")
	void testViewSalonServiceByName1() throws SalonServiceNotFoundException
	{
		assertTrue(salonservice.getSalonServiceByName("Haircut").size()>0);
	}
	
	@Test
	@DisplayName(value="testViewSalonServiceByName for repair")
	void testViewSalonServiceByName2()
	{
		assertThrows(SalonServiceNotFoundException.class, ()-> salonservice.getSalonServiceByName("repair"));
	}
	
	@Test
	@DisplayName(value="testViewSalonServiceByName for call")
	void testViewSalonServiceByName3()
	{
		assertThrows(SalonServiceNotFoundException.class, ()-> salonservice.getSalonServiceByName("call"));
	}
}
