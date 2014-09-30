package com.lan.service.impl;

import java.util.List;

import com.lan.domain.Cab;
import com.lan.domain.Flight;
import com.lan.domain.Seat;
import com.lan.exception.BusinessException;
import com.lan.repository.IFlightRepository;
import com.lan.service.FlightConfiguratorFacade;

public class FlightConfiguratorFacadeImpl implements FlightConfiguratorFacade {

	private IFlightRepository flightRepository;
	
	@Override
	public List<Cab> getFlightCabs(String flightId) {
		
		Flight flight = flightRepository.getFlightById(flightId);
		
		if (flight == null) {
			throw new BusinessException("There is no flight with fiven flight id: "+flightId);
		}
		
		return flight.getCabs();
	}

	@Override
	public List<Seat> getFlightSeats(String flightId) {
		
		Flight flight = flightRepository.getFlightById(flightId);
		
		if (flight == null) {
			throw new BusinessException("There is no flight with fiven flight id: " + flightId);
		}
		
		return flight.getSeats();
	}

	@Override
	public void addFlightCabs(String flightID, String[] cabs) {
		
		Flight flight = flightRepository.getFlightById(flightID);
		
		if (flight == null){
			throw new BusinessException("There is no flight with fiven flight id: " + flightID);
		}
		
		for (String string : cabs) {
			flight.addCab(new Cab(string));
		}
	}

	@Override
	public void addFlightSeat(String flightID,String cab, char row, char letter) {
		
		Flight flight = flightRepository.getFlightById(flightID);
		
		if (flight == null) {
			throw new BusinessException("There is no flight with fiven flight id: " + flightID);
		}
		
		if (!flight.containCab(cab)) {
			throw new BusinessException("There is no Cab with id : " + cab + " for the flight: " + flightID);
		}
		
		Cab myCab = flight.getCab(cab);
		
		myCab.addSeat(new Seat(row,letter,myCab));
	}

	/**
	 * @param flightRepository the flightRepository to set (only for testing purpose)
	 */
	public void setFlightRepository(IFlightRepository flightRepository) {
		this.flightRepository = flightRepository;
	}
	
	
}