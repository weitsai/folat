package test.flota;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BillDateBaseAdapter extends BaseAdapter {
	private LayoutInflater mLayoutInflater;
	private ArrayList<HashMap<String, String>> data = null;
	private View mInflater = null;
	private String[] key;

	BillDateBaseAdapter(ArrayList<HashMap<String, String>> data, String[] key, Context context) {
		this.data = data;
		this.key = key;
		this.mLayoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

	}

	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		mInflater = mLayoutInflater.inflate(R.layout.bill_date_item, null);
		((TextView) mInflater.findViewById(R.id.date)).setText(data.get(position).get(key[0]));
		if (data.get(position).get(key[1]).endsWith("true")) {
			mInflater.findViewById(R.id.image).setVisibility(View.VISIBLE);
		} else {
			mInflater.findViewById(R.id.image).setVisibility(View.GONE);
		}
		return mInflater;
	}

}
