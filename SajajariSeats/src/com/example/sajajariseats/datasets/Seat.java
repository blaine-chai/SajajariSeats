package com.example.sajajariseats.datasets;

public class Seat {
	private int seatIdx;
	private boolean isFull;

	public Seat(int seatIdx, boolean isFull) {
		this.seatIdx = seatIdx;
		this.isFull = isFull;
	}

	public Seat(String seatIdx, boolean isFull) {
		try {
			this.seatIdx = Integer.parseInt(seatIdx);
			this.isFull = isFull;
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public Seat(String seatIdx, String isFull) {
		try {
			this.seatIdx = Integer.parseInt(seatIdx);
			this.isFull = Boolean.getBoolean(isFull);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public int getSeatIdx() {
		return this.seatIdx;
	}

	public boolean isFull() {
		return this.isFull;
	}
}
