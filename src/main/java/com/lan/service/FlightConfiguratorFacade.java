package com.lan.service;

import java.util.List;

import com.lan.domain.Cab;
import com.lan.domain.Seat;

public interface FlightConfiguratorFacade {

	/**
	 * Return the cab related with the given flight parameter 
	 * @param flightId identifier of the flight
	 * @return 
	 */
	List<Cab> getFlightCabs(String flightId);
	
	
	/**
	 * Return all the seat of the flight specified with the given flightId parameter
	 * @param flightId
	 * @return
	 */
	List<Seat> getFlightSeats(String flightId);
	
	/**
	 * add cabs to the flight specified with the given flightId parameter. @throws BusinessException if this one does no exist. 
	 * @param flightID Flight identifier
	 * @param cabs cabs to be added
	 */
	void addFlightCabs(String flightID, String[] cabs);
	
	
	/**
	 * Add seat to the cab/flight combination given as a parameters. @throws BusinessException if this combination does no exist.
	 * @param flightID
	 * @param cab
	 * @param row
	 * @param letter
	 */
	void addFlightSeat(String flightID,String cab, char row, char letter);
}
