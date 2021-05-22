package com.cg.salon.testSalonService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.salon.dao.ISalonServiceDao;
import com.cg.salon.dto.SalonServiceDto;
import com.cg.salon.entity.SalonService;
import com.cg.salon.exceptions.SalonServiceNotFoundException;
import com.cg.salon.service.ISalonService;
import com.cg.salon.service.SalonServiceImpl;

@SpringBootTest
class TestAddSalonService {

	@Mock
	private ISalonServiceDao salonservicedao;
	
	@InjectMocks
	private ISalonService salonservice = new SalonServiceImpl();
	
	
	@BeforeEach
	public void beforeEach()
	{
		
		SalonService persistedSalonService= new SalonService(1, "Haircut",150,"40 minutes",5, "24, CB Apartment","Nagerbajar","Jawed Habib");
		SalonService persistedSalonService2= new SalonService(2, "Facial",200,"1 hour",5, "24, CB Apartment","Nagerbajar","Jawed Habib");
		when(salonservicedao.save(any(SalonService.class))).thenReturn(persistedSalonService);
		when(salonservicedao.save(any(SalonService.class))).thenReturn(persistedSalonService2);
	}
	
	@Test
	@DisplayName(value= "testaddsalonservice1 for salon service Haircut")
	void testAddSalonService1() throws SalonServiceNotFoundException
	{
		SalonServiceDto salonservicedto= new SalonServiceDto(1, "Haircut",150,"40 minutes",5, "24, CB Apartment","Nagerbajar","Jawed Habib");
		assertNotNull(salonservice.addSalonService(salonservicedto));
	}
	
	
	
	@Test
	@DisplayName(value="testaddsalonservice2 for salon service Haircut")
	void testAddSalonService2() throws SalonServiceNotFoundException
	{
		SalonServiceDto salonservicedto= new SalonServiceDto(2, "Facial",200,"1 hour",5, "24, CB Apartment","Nagerbajar","Jawed Habib");
		assertNotNull(salonservice.addSalonService(salonservicedto));
		
		
	}
		
}