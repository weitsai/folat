package test.flota;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import test.tool.Tool;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class UserList extends Activity {
	private ListView mListView;
	private String[] key = { "WmonadName", "UserName", "Date", "Pieces", "Drawble" };
	private String[][] data = { 
		{ "派工單", "請假單", "請購單", "費用申請單", "開會通知單", "尾牙意見調查表" }, 
		{ "邱 人傑", "葉 大雄", "成 大志", "陳 拜家", "林 宜君", "黃 俊雄" },
		{ "2011/01/04 08:00:00", "", "2011/01/04 10:00:00", "2011/01/04 10:00:00", "2011/01/05 11:00:00", "2011/01/06 12:00:00" },
		{ "急件", "普通件", "最速件", "最速件", "普通件", "普通件" },
		{ "0", "1", "2", "2", "0", "2" } 
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.userlist);
		findview();
		setListView();
		mListViewItemClick();

	}
	
	// 日期排序
	private void sortDate() {
		Arrays.sort(data[2]);
	}

	private void mListViewItemClick() {
		mListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				Bundle bundle = new Bundle();
				bundle.putString("title", data[0][arg2]);
				new Tool().jumpActivity(UserList.this, Bill.class, bundle);
			}
		});
	}

	private void findview() {
		mListView = (ListView) findViewById(R.id.listView1);

	}

	private void setListView() {
		ArrayList<HashMap<String, String>> item = new ArrayList<HashMap<String, String>>();

		for (int i = 0; i <  data[0].length; i++) {
			HashMap<String, String> tmp = new HashMap<String, String>();
			for (int j = 0; j < key.length; j++) {
				tmp.put(key[j], data[j][i]);
				
			}
			item.add(tmp);
		}
		

		mListView.setAdapter(new UserListBaseadapter(UserList.this, item, key));

	}

}
