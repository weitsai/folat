package test.flota;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class BillContentLeave extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.billcontentleave);
		setFindView();
		setListViewAdapter();
	}

	private ListView mListView;
	private String[] key = { "name", "titles", "igning_date", "signing_content", "opinion" };
	private String[][] data = { 
		{ "王小明", "成大志" },
		{ "經理", "協理"},
		{"2011/01/01 09:30:00", "--"},
		{"核准", "未簽核"},
		{"依公司規定辦理。", "--"}	
	};

	private void setListViewAdapter() {
		ArrayList<HashMap<String, String>> item = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < this.data[0].length; i++) {
			HashMap<String, String> tmp = new HashMap<String, String>();
			tmp.put(key[0], data[0][i]);
			tmp.put(key[1], data[1][i]);
			tmp.put(key[2], data[2][i]);
			tmp.put(key[3], data[3][i]);
			tmp.put(key[4], data[4][i]);
			item.add(tmp);
		}
		 mListView.setAdapter(new BillContentLeaveBaseadapter(item, key, this));

	}

	private void setFindView() {
		mListView = (ListView) findViewById(R.id.mlistview);
	}

	public void black(View v) {
		finish();
	}

}
