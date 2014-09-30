package com.lan.domain;

/**
 * Abstraction of a single flight seat
 * @author nikolas
 *
 */
public class Seat {
	
	private Character row;
	
	private Character letter;
	
	private Cab cab;

	public Seat(Character row, Character letter, Cab cab) {
		super();
		this.row = row;
		this.letter = letter;
		this.cab = cab;
	}
	
	public String getSeatId(){
		return cab.getCode() + row + letter;
	}

	/**
	 * @return the row
	 */
	public Character getRow() {
		return row;
	}

	/**
	 * @return the letter
	 */
	public Character getLetter() {
		return letter;
	}

	/**
	 * @return the cab
	 */
	public Cab getCab() {
		return cab;
	}
}
