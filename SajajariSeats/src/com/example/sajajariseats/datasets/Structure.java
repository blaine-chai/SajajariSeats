package com.example.sajajariseats.datasets;

import java.util.ArrayList;

public class Structure {
	private ArrayList<Room> rlist = new ArrayList<Room>();
	private double percent;
	private String structureName;
	private int seatNum;
	private int emptyNum;
	private int filledNum;

	public Structure(String sName) {
		this.seatNum = 0;
		this.emptyNum = 0;
		this.filledNum = 0;
		this.structureName = sName;
	}

	private void setSeatNum() {
		this.seatNum = 0;
		for (Room r : this.rlist)
			this.seatNum += r.getSeatNum();
	}

	private void setEmpty() {
		this.emptyNum = 0;
		for (Room r : this.rlist)
			this.emptyNum += r.getEmpty();
	}

	private void setfilled() {
		this.filledNum = 0;
		for (Room r : this.rlist)
			this.filledNum += r.getFilled();
	}

	private void setPercent(){
		this.percent = (double)100*(this.filledNum)/(this.seatNum);
	}
	public int getRoomNum() {
		return this.rlist.size();
	}

	public String getStructureName() {
		return this.structureName;
	}

	public double getPercent() {
		return this.percent;
	}

	public Room getIdxOfList(int index) {
		return this.rlist.get(index);
	}

	public ArrayList<Room> getRlist() {
		return this.rlist;
	}

	public void addRoom(Room room) {
		this.rlist.add(room);
		this.refreshInfo();
	}

	public void addRoom(Room room, int index) {
		this.rlist.add(index, room);
		this.refreshInfo();
	}

	public void addRoom(Room room, String index) {
		this.rlist.add(Integer.parseInt(index), room);
		this.refreshInfo();
	}

	public int getEmpty() {
		return this.emptyNum;
	}

	public int getFilled() {
		return this.filledNum;
	}

	public int getSeatNum() {
		return this.seatNum;
	}

	public void refreshInfo() {
		this.setEmpty();
		this.setfilled();
		this.setSeatNum();
		this.setPercent();
	}
}
