package test.flota;

import javax.security.auth.login.LoginException;

import test.tool.Tool;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Contract extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contract);
	}

	/**
	 * 前往Login (確定 Button)
	 */
	public void onclickCancel(View v) {
//		Intent intent = new Intent();
//		intent.setClass(this, Login.class);
//		startActivity(intent);
		
		new Tool().jumpActivity(Contract.this, Login.class, null);
		Contract.this.finish();
	}

	/**
	 * 結束程式 (取消 Button)
	 */
	public void onclickConfirm(View v) {
		Contract.this.finish();

	}
}