
package com.lan.service.impl;

import mockit.Capturing;

import mockit.Expectations;
import mockit.Mocked;
import mockit.VerificationsInOrder;
import mockit.integration.junit4.JMockit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.lan.domain.Cab;
import com.lan.domain.Flight;
import com.lan.domain.Seat;
import com.lan.exception.BusinessException;
import com.lan.repository.IFlightRepository;

@RunWith(JMockit.class)
public class FlightConfiguratorFacadeImplTest {

	//SUD
	private FlightConfiguratorFacadeImpl facade;
	
	@Mocked
	private IFlightRepository repo;
	
	
	@Capturing 
	private Flight flight;
	
	@Capturing
	private Cab cab;
	
	final String flightCode = "FlightCode";
	
	@Before
	public void setup(){
		facade = new FlightConfiguratorFacadeImpl();
	}
	
	@Test(expected = BusinessException.class)
	public void testGetFlightCabsWithInvalidFlightId() {
		
		new Expectations() {{
			 repo.getFlightById("Flight_1"); 
			 result = null;
		  }};
		  
		 facade.setFlightRepository(repo);
		 facade.getFlightCabs("Flight_1");
	}
	
	@Test
	public void testGetFlightCabsWithValidFlightId(){
		
		new Expectations() {{
			 repo.getFlightById(flightCode); 
			 result = flight;
		  }};
		  
		  facade.setFlightRepository(repo);
		  facade.getFlightCabs(flightCode);
		  
		   new VerificationsInOrder() {{
			   flight.getCabs();
			   times = 1;
		  }};
	}
	
	
	@Test(expected = BusinessException.class)
	public void testGetFlightSeatsWithInvalidFlightId() {
		
		new Expectations() {{
			 repo.getFlightById(flightCode); 
			 result = null;
		  }};
		  
		 facade.setFlightRepository(repo);
		 facade.getFlightSeats(flightCode);
	}
	
	
	@Test
	public void testGetFlightSeatsWithValidFlightId(){
		
		new Expectations() {{
			 repo.getFlightById(flightCode); 
			 result = flight;
		  }};
		  
		  facade.setFlightRepository(repo);
		  facade.getFlightSeats(flightCode);
		  
		   new VerificationsInOrder() {{
			   flight.getSeats();
			   times = 1;
		  }};
	}
	
	@Test(expected = BusinessException.class)
	public void addFlightCabsWithInvalidFlightId() {
		
		new Expectations() {{
			 repo.getFlightById(flightCode); 
			 result = null;
		  }};
		  
		 facade.setFlightRepository(repo);
		 facade.addFlightCabs(flightCode,new String[]{});
	}
	
	@Test
	public void addFlightCabsWithValidFlightId() {
		
		new Expectations() {{
			 repo.getFlightById(flightCode); 
			 result = flight;
		  }};
		  
		 facade.setFlightRepository(repo);
		 facade.addFlightCabs(flightCode,new String[]{"cab1","cab2","cab3"});
		 
		  new VerificationsInOrder() {{
			   flight.addCab((Cab)any);
			   times = 3;
		  }};
	}
	
	@Test(expected = BusinessException.class)
	public void addFlightSeatsWithInvalidFlightId() {
		
		new Expectations() {{
			 repo.getFlightById(flightCode); 
			 result = null;
		  }};
		  
		  facade.setFlightRepository(repo);
		  facade.addFlightSeat(flightCode, "Business",'3','c');
	}
	
	@Test(expected = BusinessException.class)
	public void addFlightSeatsWithValidFlightIdButInvalidCab() {
		
		new Expectations() {{
			 repo.getFlightById(flightCode); 
			 result = flight;
			 
			 flight.containCab(anyString);
			 result = false;
		  }};
		  
		  facade.setFlightRepository(repo);
		  facade.addFlightSeat(flightCode, "Business",'3','c');
	}
	
	
	@Test
	public void addFlightSeatsWithValidFlightIdandValidCab() {
		
		new Expectations() {{
			 repo.getFlightById(flightCode); 
			 result = flight;
			 
			 flight.containCab(anyString);
			 result = true;
			 
			 flight.getCab(anyString);
			 result = cab;
			 
		  }};
		  
		  facade.setFlightRepository(repo);
		  facade.addFlightSeat(flightCode, "Business",'3','c');
		  
		  new VerificationsInOrder() {{
			   cab.addSeat((Seat)any);
			   times = 1;
		  }};
	}
}
