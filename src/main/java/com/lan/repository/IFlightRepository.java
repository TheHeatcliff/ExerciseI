package com.lan.repository;

import java.util.List;

import com.lan.domain.Cab;
import com.lan.domain.Flight;
import com.lan.domain.Seat;

public interface IFlightRepository {

	List<Cab> getCabsByFlightID(String flightID);
	
	List<Seat> getSeatsByFlightID(String flightID);
	
	Flight getFlightById(String flightID);
	
	void addFlightCabs();
	
	void addFlightSeats();

}
