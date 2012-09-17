package test.flota;

import java.util.ArrayList;
import java.util.HashMap;

import test.tool.Tool;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class Bill extends Activity {

	ListView mListView;
	TextView title;
	View BillImage; 
	String billTitle;
	Bundle bundel;

	String key[] = { "index", "content", "image"};
	String data[][] = { 
		{ "單據編號", "申請人", "申辦單位", "申請日期", "到工日期", "到工時間", "領班人員", "派工說明", "派通項目" },
		{ "ANS000001", "邱人傑", "維修部", "2011/01/09", "2011/01/12", "09:00:00", "黃俊雄", "信義區大樓電梯定期保養", "新光三越A8\n太平洋SOGO\n國泰世華大樓" },
		{ "false", "false", "false", "false", "false", "false", "false", "false", "true"}
	};
	String data2[][] = {
		{ "單據編號", "申請日期", "申請人", "申請人工號", "請假人工號", "假別", "事由", "代理人", "代工人號", "起始日期", "截止日期", "合計時間", "附件"},
		{ "ANS0000002", "2011/01/01", "葉大雄", "EMPLOYEE001", "EMPLOYEE002", "病假", "感冒急診", "陳靜香", "EMPLOYEE003", "2011/01/02 08:00:00", "2011/01/03 17:00:00", "2天", "診斷證明書"},
		{ "false", "false", "false", "false", "false", "false", "false", "false", "false", "false", "false", "false", "true"}
	};
	String data3[][] = {
		{ "事由", "預定日期", "參加意願", "可參加日期", "可參加時間", "地點選擇", "備註"},
		{ "年度尾牙意見調查表", "2011/01/15 - 2011/01/25", "是否願意參加?", "請選擇可以參加的日期", "請選擇可以參加的時間", "請選擇您希望參加的地點", "如有其他推薦地點請於簽核意見欄填寫回覆。"},
		{ "false", "false", "true", "true", "true", "true", "false"}
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bill);
		findview();
		setTitle();
		setListView();
		mListViewItemClick();

	}

	private void findview() {
		mListView = (ListView) findViewById(R.id.bill_list);
		title = (TextView) findViewById(R.id.bill_title);
		BillImage = findViewById(R.id.image);
		// 取得 Bundle 物件
		bundel = this.getIntent().getExtras();

	}

	private void setTitle() {
		billTitle = bundel.getString("title");
		title.setText(billTitle);
	}

	private void mListViewItemClick() {
		mListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				if (data[0].length - 1 == arg2 && billTitle.equals("派工單")) {
					bundel.clear();
					bundel.putBoolean("color", false);
					new Tool().jumpActivity(Bill.this, BillContent.class, bundel);
				} else if (data2[0].length - 1 == arg2 && billTitle.equals("請假單")) {
					new Tool().jumpActivity(Bill.this, Annex.class, null);
				} else if (data3[0][arg2].equals("參加意願")) {
					new Tool().jumpActivity(Bill.this, BillContentLeaveJoin.class, null);
				} else if (data3[0][arg2].equals("可參加日期")) {
					new Tool().jumpActivity(Bill.this, BillDate.class, null);
					
				}
			}
		});
	}
	

	private void setListView() {
		ArrayList<HashMap<String, String>> item = new ArrayList<HashMap<String, String>>();
		if (billTitle.equals("派工單")) {
			for (int i = 0; i < data[0].length; i++) {
				HashMap<String, String> tmp = new HashMap<String, String>();
				tmp.put(key[0], data[0][i]);
				tmp.put(key[1], data[1][i]);
				tmp.put(key[2], data[2][i]);
				item.add(tmp);
			}
		} else if (billTitle.equals("請假單")) {
			for (int i = 0; i < data2[0].length; i++) {
				HashMap<String, String> tmp = new HashMap<String, String>();
				tmp.put(key[0], data2[0][i]);
				tmp.put(key[1], data2[1][i]);
				tmp.put(key[2], data2[2][i]);
				item.add(tmp);
			}
		} else if (billTitle.equals("尾牙意見調查表")) {
			for (int i = 0; i < data3[0].length; i++) {
				HashMap<String, String> tmp = new HashMap<String, String>();
				tmp.put(key[0], data3[0][i]);
				tmp.put(key[1], data3[1][i]);
				tmp.put(key[2], data3[2][i]);
				item.add(tmp);
			}
		}

		mListView.setAdapter(new BillBaseadapter(Bill.this, item, key));

	}
	
	public void onclick(View v) {
		if (billTitle.equals("請假單")) {
		}
	}

	public void black(View v) {
		Bill.this.finish();
	}

}
