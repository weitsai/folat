package test.flota;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class BillDate extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bill_date);
		setFindView();
		setListViewAdapter();
		mListView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				if (data[1][arg2].equals("false"))
					data[1][arg2] = "true";
				else 
					data[1][arg2] ="false";
				setListViewAdapter();
			}

		});
	}

	private ListView mListView;

	private String[] key = { "date", "check" };
	private String[][] data = { 
		{ "2011/01/15", "2011/01/16", "2011/01/17", "2011/01/18", "2011/01/19", "2011/01/20", "2011/01/21", "2011/01/22" },
		{ "false", "false", "false", "false", "false", "false", "false", "false" } 
	};

	private void setFindView() {
		mListView = (ListView) findViewById(R.id.mlistview);
	}


	private void setListViewAdapter() {
		ArrayList<HashMap<String, String>> item = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < data[0].length; i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(key[0], data[0][i]);
			map.put(key[1], data[1][i]);
			item.add(map);
		}
		mListView.setAdapter(new BillDateBaseAdapter(item, key, BillDate.this));
	}
	
	public void finsh(View v) {
		BillDate.this.finish();
	}

	public void all(View v) {
		for (int i = 0; i < data[1].length; i++) {
			data[1][i] = "true";
		}
		setListViewAdapter();
	}
	public void canceled(View v) {
		for (int i = 0; i < data[1].length; i++) {
			data[1][i] = "false";
		}
		setListViewAdapter();
	}
}
