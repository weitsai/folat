package test.flota;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class UserListBaseadapter extends BaseAdapter {
	private LayoutInflater mLayoutInflater;
	private View mInflater;
	private String[] key;
	private ArrayList<HashMap<String, String>> mData = new ArrayList<HashMap<String, String>>();

	UserListBaseadapter(Context context, ArrayList<HashMap<String, String>> data, String[] key) {
		mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.mData = data;
		this.key = key;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mData.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	private String getItem(int index, String key) {
		return mData.get(index).get(key);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		if (mData != null && mData.size() > 0) {
			mInflater = mLayoutInflater.inflate(R.layout.userlist_item, null);
			((TextView) mInflater.findViewById(R.id.WmonadName)).setText(getItem(position, key[0]));
			((TextView) mInflater.findViewById(R.id.UserName)).setText("寄件人：" + getItem(position, key[1]));

			if (getItem(position, key[2]).equals("")) {
				((TextView) mInflater.findViewById(R.id.Date)).setText("回覆時間：");
			} else {
				((TextView) mInflater.findViewById(R.id.Date)).setText("接收時間：" + getItem(position, key[2]));
			}

			TextView tmp = ((TextView) mInflater.findViewById(R.id.Pieces));
			if (getItem(position, key[3]).equals("急件")) {
				tmp.setTextColor(0xFFDF7800);
			} else if (getItem(position, key[3]).equals("最速件")) {
				tmp.setTextColor(0xFFE60000);
			} else {
				tmp.setTextColor(0xFF4D00A6);
			}
			tmp.setText(getItem(position, key[3]));

			// 切換筆圖
			if (getItem(position, key[4]).equals("1")) {
				((ImageView) mInflater.findViewById(R.id.pen)).setImageResource(R.drawable.pen);
			} else if (getItem(position, key[4]).equals("2")) {
				((ImageView) mInflater.findViewById(R.id.pen)).setImageResource(R.drawable.pen_color);
			} else {
				mInflater.findViewById(R.id.pen).setVisibility(View.GONE);
			}

		}

		return mInflater;
	}
}
