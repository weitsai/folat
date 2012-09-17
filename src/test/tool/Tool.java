package test.tool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.widget.RemoteViews.ActionException;

public class Tool {
	public void jumpActivity(Context sourt, Class<?> destination, Bundle data) {
		Intent intent = new Intent();
		intent.setClass(sourt, destination);
		if (data != null)
			intent.putExtras(data);
		sourt.startActivity(intent);
	}

	public void showToast(Context sourt, String str) {
		Toast.makeText(sourt, str, 0).show();
	}
}
