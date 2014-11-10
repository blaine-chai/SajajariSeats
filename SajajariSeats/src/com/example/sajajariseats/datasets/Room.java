package com.kyudevelop.sajajari.data;

import java.util.ArrayList;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Room {
	private int maxSeatNum;
	private ArrayList<Integer> emptySeatList = new ArrayList<Integer>();
	private RoomTotalData totalInfo;

//	public Room() {
//	}

	public Room(Elements unused, int idx) {
		for (Element e : unused) {
			emptySeatList.add(Integer.parseInt(e.text()));
		}

		this.totalInfo.setEmpty(emptySeatList.size());
		this.totalInfo.setFilled(RoomList.getMaxNumSeatList(idx)
				- this.totalInfo.getEmpty());
		this.totalInfo
				.setPercent(((double) this.totalInfo.getFilled() * 100 / (this.totalInfo
						.getFilled() + this.totalInfo.getEmpty())));
	}

	public int getMaxSeatNum() {
		return maxSeatNum;
	}

	public void setMaxSeatNum(int maxSeatNum) {
		this.maxSeatNum = maxSeatNum;
	}

	public ArrayList<Integer> getEmptySeatList() {
		return emptySeatList;
	}

	public void setEmptySeatList(ArrayList<Integer> emptySeatList) {
		this.emptySeatList = emptySeatList;
	}

	public RoomTotalData getTotalInfo() {
		return totalInfo;
	}

	public void setTotalInfo(RoomTotalData totalInfo) {
		this.totalInfo = totalInfo;
	}

}