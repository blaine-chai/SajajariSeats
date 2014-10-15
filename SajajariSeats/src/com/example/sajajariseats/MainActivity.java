package com.example.sajajariseats;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.sajajariseats.datasets.Room;
import com.example.sajajariseats.datasets.Structure;
import com.example.sajajariseats.functions.HtmlParser;

public class MainActivity extends Activity implements OnClickListener {
	TextView tv[] = new TextView[5];
	Button t;
	ArrayList<Structure> sList = new ArrayList<Structure>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv[0] = (TextView) findViewById(R.id.textView1);
		tv[1] = (TextView) findViewById(R.id.textView2);
		tv[2] = (TextView) findViewById(R.id.textView3);
		tv[3] = (TextView) findViewById(R.id.textView4);
		tv[4] = (TextView) findViewById(R.id.textView5);
		t = (Button) findViewById(R.id.button1);
		
		int idxNumOfJungDoRoom[] = new int[] {7,8,9,10,5,6,11,12};
		int idxNumOfLaw[] = new int[] {1,2,3,4};
		// 백남학술정보관 정보 파싱
		HtmlParser p = new HtmlParser();
		Structure tStruct = new Structure("백남학술정보관");
		p.setDoc(false, "7");
		Room tRoom = new Room(p.getUsed(), p.getUnused(), "중앙도서관 제1열람실");
		p.setDoc(false, "8");
		tRoom.setRoom(p.getUsed(), p.getUnused());
		tStruct.addRoom(tRoom, 0);

		p.setDoc(false, "9");
		tRoom = new Room(p.getUsed(), p.getUnused(), "중앙도서관 제2열람실");
		p.setDoc(false, "10");
		tRoom.setRoom(p.getUsed(), p.getUnused());
		tStruct.addRoom(tRoom, 1);

		p.setDoc(false, "5");
		tRoom = new Room(p.getUsed(), p.getUnused(), "중앙도서관 제3열람실");
		p.setDoc(false, "6");
		tRoom.setRoom(p.getUsed(), p.getUnused());
		tStruct.addRoom(tRoom, 2);

		p.setDoc(false, "11");
		tRoom = new Room(p.getUsed(), p.getUnused(), "중앙도서관 제4열람실");
		p.setDoc(false, "12");
		tRoom.setRoom(p.getUsed(), p.getUnused());
		tStruct.addRoom(tRoom, 3);

		sList.add(tStruct);
		sList.get(0).refreshInfo();
		tv[0].setText(String.format("%.2f", sList.get(0).getPercent()));
		// tv[0].setText(String.format("%d", sList.get(0).getSeatNum()));

		t.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			// sList.get(0).refreshInfo();
			// tv[0].setText(String.format("%.2f",
			// sList.get(0).getPercent()));
			int i;
			for (i = 0; i < 4; i++) {
				tv[i + 1].setText(sList.get(0).getRlist().get(i).getRoomName()
						+ "\n전체좌석: "
						+ sList.get(0).getRlist().get(i).getSeatNum()
						+ "\n빈좌석: "
						+ sList.get(0).getRlist().get(i).getEmpty()
						+ "\n사용중:"
						+ sList.get(0).getRlist().get(i).getFilled()
						+ "\n퍼센트"
						+ String.format("%.2f", sList.get(0).getRlist().get(i)
								.getPercent()));
			}
			break;
		default:
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
