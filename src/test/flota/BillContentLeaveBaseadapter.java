package test.flota;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BillContentLeaveBaseadapter extends BaseAdapter {
	private ArrayList<HashMap<String, String>> mData = null;
	private Context context = null;
	private String[] key = null;
	private View inflater;
	LayoutInflater mLayoutInflater = null;

	BillContentLeaveBaseadapter(ArrayList<HashMap<String, String>> data, String[] key, Context context) {
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

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (mData != null && mData.size() > 0) {
			inflater = mLayoutInflater.inflate(R.layout.billcontentleave_item, null);
			((TextView) inflater.findViewById(R.id.leave_name)).setText(mData.get(position).get("name"));
			((TextView) inflater.findViewById(R.id.leave_titles)).setText(mData.get(position).get("titles"));
			((TextView) inflater.findViewById(R.id.leave_igning_date)).setText(mData.get(position).get("igning_date"));
			((TextView) inflater.findViewById(R.id.leave_signing_content)).setText(mData.get(position).get("signing_content"));
			((TextView) inflater.findViewById(R.id.leave_opinion)).setText(mData.get(position).get("opinion"));
		}
		return inflater;
	}

}
