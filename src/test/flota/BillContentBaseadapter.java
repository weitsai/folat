package test.flota;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BillContentBaseadapter extends BaseAdapter {
	private LayoutInflater mLayoutInflater;
	private View mInflater;
	private String[] key;
	private ArrayList<HashMap<String, String>> mData = new ArrayList<HashMap<String, String>>();

	BillContentBaseadapter(Context context, ArrayList<HashMap<String, String>> data, String[] key) {
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
			mInflater = mLayoutInflater.inflate(R.layout.bill_content_item, null);
			((TextView) mInflater.findViewById(R.id.company_name)).setText(getItem(position, key[0]));
			((TextView) mInflater.findViewById(R.id.elvator_content)).setText(getItem(position, key[1]));
			((TextView) mInflater.findViewById(R.id.type_content)).setText(getItem(position, key[2]));

		}

		return mInflater;
	}
}
