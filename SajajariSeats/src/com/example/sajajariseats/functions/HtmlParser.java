package com.example.sajajariseats.functions;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HtmlParser {
	final static private String BASE_URL = "http://166.104.27.81/seat";
	final static private String LAW = "L/roomview5.asp?room_no=";
	final static private String STANDARD = "S/roomview5.asp?room_no=";
	private Document doc;
	private Elements used;
	private Elements unused;
	private ArrayList<Structure> structureList= new 
	

	public Document setDoc(boolean isLaw, String roomNum) {
		try {
			if (isLaw)
				doc = Jsoup.connect(BASE_URL + LAW + roomNum).get();
			else
				doc = Jsoup.connect(BASE_URL + STANDARD + roomNum).get();
		} catch (Exception e) {
			e.getMessage();
		}
		this.setUsed(doc);
		this.setUnused(doc);
		return doc;
	}

	private void setUsed(Document doc) {
		used = doc.select("div table tr td[bgcolor*=red]");
	}

	private void setUnused(Document doc) {
		unused = doc.select("div table tr td[bgcolor*=gray]");
	}

	public Elements getUsed() {
		return this.used;
	}

	public Elements getUnused() {
		return this.unused;
	}
}
