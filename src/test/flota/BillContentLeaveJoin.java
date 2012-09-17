package test.flota;

import java.util.Calendar;

import test.whell.OnWheelChangedListener;
import test.whell.WheelView;
import test.whell.adapters.ArrayWheelAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.Paint.Join;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class BillContentLeaveJoin extends Activity {
	WheelView join = null;
	String joindata[] = null;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.bill_content_leave_join);
		Calendar calendar = Calendar.getInstance();
		join = (WheelView) findViewById(R.id.join);
		OnWheelChangedListener listener = new OnWheelChangedListener() {
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				updateDays(join);
			}
		};

		// month
		int curMonth = calendar.get(Calendar.MONTH);
		joindata = new String[] { "會參加", "不會參加" };
		join.setViewAdapter(new DateArrayAdapter(this, joindata, curMonth));
		join.setCurrentItem(curMonth);
		join.addChangingListener(listener);
	}

	public void black(View v) {
		finish();
	}

	public void confirm(View v) {
		Toast.makeText(this, "您選擇：" + joindata[join.getCurrentItem()], 0).show();
		finish();
	}

	/**
	 * Updates day wheel. Sets max days according to selected month and year
	 */
	void updateDays(WheelView join) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, join.getCurrentItem());
		int maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		Log.w("Data", "" + join.getCurrentItem());
	}

	private class DateArrayAdapter extends ArrayWheelAdapter<String> {
		// Index of current item
		int currentItem;
		// Index of item to be highlighted
		int currentValue;

		/**
		 * Constructor
		 */
		public DateArrayAdapter(Context context, String[] items, int current) {
			super(context, items);
			this.currentValue = current;
			setTextSize(16);
		}

		@Override
		protected void configureTextView(TextView view) {
			super.configureTextView(view);
			view.setGravity(Gravity.CENTER);
			view.setTypeface(Typeface.SANS_SERIF);
		}

		@Override
		public View getItem(int index, View cachedView, ViewGroup parent) {
			currentItem = index;
			return super.getItem(index, cachedView, parent);
		}
	}

}
