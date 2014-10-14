package com.example.sajajariseats.datasets;

import java.util.ArrayList;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Room {
	private String roomName;
	private int seatNum;
	private ArrayList<Seat> Slist = new ArrayList<Seat>();
	private double percent;
	private int filled;
	private int empty;

	public Room(Elements used, Elements unused, String roomName) {
		Seat tSeat;
		for (Element e : used) {
			tSeat = new Seat(e.text(), true);
			Slist.add(tSeat);
		}
		for (Element e : unused) {
			for (Seat s : Slist) {
				if (s.getSeatIdx() < Integer.parseInt(e.text())) {
					tSeat = new Seat(e.text(), false);
					if (Slist.indexOf(s) - 1 < 0)
						Slist.add(0, tSeat);
					else
						Slist.add(Slist.indexOf(s) - 1, tSeat);
					break;
				}
			}
		}

		this.filled = used.size();
		this.empty = unused.size();
		this.seatNum = this.filled + this.empty;
		this.percent = ((double) filled * 100 / (filled + empty));
		this.roomName = roomName;
	}

	public void setRoom(Elements used, Elements unused) {
		Seat tSeat;
		for (Element e : used) {
			tSeat = new Seat(e.text(), true);
			Slist.add(tSeat);
		}
		for (Element e : unused) {
			for (Seat s : Slist) {
				if (s.getSeatIdx() < Integer.parseInt(e.text())) {
					tSeat = new Seat(e.text(), false);
					if (Slist.indexOf(s) - 1 < 0)
						Slist.add(0, tSeat);
					else
						Slist.add(Slist.indexOf(s) - 1, tSeat);
					break;
				}
			}
		}

		this.filled += used.size();
		this.empty += unused.size();
		this.seatNum = this.filled + this.empty;
		this.percent = ((double) filled * 100 / (filled + empty));
	}

	public int getSeatNum() {
		return this.seatNum;
	}

	public double getPercent() {
		return this.percent;
	}

	public Seat getIdxOfList(int index) {
		return Slist.get(index);
	}

	public ArrayList<Seat> getSlist() {
		return Slist;
	}

	public ArrayList<Seat> getEmptyList() {
		ArrayList<Seat> Elist = new ArrayList<Seat>();
		for (Seat s : this.Slist) {
			if (!s.isFull())
				Elist.add(s);
		}
		return Elist;
	}

	public ArrayList<Seat> getFilledList() {
		ArrayList<Seat> Flist = new ArrayList<Seat>();
		for (Seat s : this.Slist) {
			if (s.isFull())
				Flist.add(s);
		}
		return Flist;
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
