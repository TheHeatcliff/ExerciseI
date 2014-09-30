package com.lan.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstraction of a simple Flight
 * @author nikolas
 *
 */
public class Flight {
    /**
     * Flight identifier
     */
	private String code;
	
	private List<Cab> cabs = new ArrayList<Cab>();

	public Flight(String code, List<Cab> cabs) {
		super();
		this.code = code;
		this.cabs = cabs;
	}
	
	public Flight(String code, Cab cab) {
		super();
		this.code = code;
		this.cabs.add(cab);
	}
	
	public void addCab(Cab cab){
		this.cabs.add(cab);
	}
	
	public String getCode() {
		return code;
	}

	/**
	 * @return the cabs
	 */
	public List<Cab> getCabs() {
		return cabs;
	}
	
	public List<Seat> getSeats(){
		
		List<Seat> seats = new ArrayList<Seat>();
		
		for (Cab cab : cabs) {
			seats.addAll(cab.getSeats());
		}
		return seats;
	}
	
	public void addCabs(List<Cab> cabs){
		this.cabs.addAll(cabs);
	}
	
	public void addSeats() {
		
	}
	
	public boolean containCab(String cab){
		return this.cabs.contains(cab);
	}

	public Cab getCab(String cab){
		return this.cabs.get(cabs.indexOf(cab));
	}


	
	
	
}
