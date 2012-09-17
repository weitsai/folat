package test.flota;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class BillContent extends Activity {

	ListView mListView;
	String key[] = {"index", "elevator", "type"};
	String data[][] = {
			{ "新光三越A8", "太平洋SOGO", "國泰世華大樓" },
			{ "534763", "840621", "698395"},
			{ "大保養", "大保養", "大保養"}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bill_content);
		findview();
		setListView();
		
		
	}

	private void findview() {
		mListView = (ListView) findViewById(R.id.bill_content_listview);
	}

	private void setListView() {
		ArrayList<HashMap<String, String>> item = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < data[0].length; i++) {
			HashMap<String, String> tmp = new HashMap<String, String>();
			tmp.put(key[0], data[0][i]);
			tmp.put(key[1], data[1][i]);
			tmp.put(key[2], data[2][i]);
			item.add(tmp);
		}

		mListView.setAdapter(new BillContentBaseadapter(BillContent.this, item, key));

	}
	
	public void black(View v) {
		BillContent.this.finish();
	}
}
