package com.example.sajajariseats.datasets;

import java.util.ArrayList;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Room {
	private String roomName;
	private int seatNum;
	private ArrayList<Integer> emptySeatList = new ArrayList<Integer>();
	private double percent;
	private int filled;
	private int empty;

	public Room(Elements unused, int seatNum, String roomName) {
		for (Element e : unused) {
			emptySeatList.add(Integer.parseInt(e.text()));
		}

		this.empty = emptySeatList.size();
		this.filled = seatNum - this.empty;
		this.seatNum = seatNum;
		this.percent = ((double) filled * 100 / (filled + empty));
		this.roomName = roomName;
	}

	public void setRoom(Elements unused) {

		for (Element e : unused) {
			emptySeatList.add(Integer.parseInt(e.text()));
		}

		this.empty = emptySeatList.size();
		this.filled = this.seatNum - this.empty;
		this.percent = ((double) filled * 100 / (filled + empty));
	}

	public int getSeatNum() {
		return this.seatNum;
	}

	public double getPercent() {
		return this.percent;
	}

	public ArrayList<Integer> getEmptySeatList() {
		return this.emptySeatList;
	}

	public String getRoomName() {
		return this.roomName;
	}

	public int getFilled() {
		return this.filled;
	}

	public int getEmpty() {
		return this.empty;
	}
}
