package com.lan.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstraction of flight cabin
 * @author nikolas
 *
 */
public class Cab {

	/**
	 * Cab identifier
	 */
	private String code;
	
	private List<Seat> seats = new ArrayList<Seat>();

	public Cab(String code, Seat seat) {
		super();
		this.code = code;
		this.seats.add(seat);
	}
	
	public Cab(String code) {
		super();
		this.code = code;
	}

	/**
	 * @return the seats
	 */
	public List<Seat> getSeats() {
		return seats;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	
	public Cab addSeat(Seat seat){
		this.seats.add(seat);
		return this;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cab other = (Cab) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
}