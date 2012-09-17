package test.flota;

import test.tool.Tool;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends Activity {

	private EditText editContent, editPasswd;
	private String strContent, strPasswd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		findView();
	}

	private void findView() {
		editContent = (EditText) findViewById(R.id.edit_content);
		editPasswd = (EditText) findViewById(R.id.edit_passwd);
	}

	/**
	 * 發送郵件 (郵件 Button)
	 */
	public void onclickSubmitMail(View v) {
		new Tool().showToast(this, "寄信");
	}

	/**
	 * 結束程式 (取消 Button)
	 */
	public void onclickCancel(View v) {
		Login.this.finish();

	}

	/**
	 * 確認身分 (確定 Button)
	 */
	public void onclickContentl(View v) {
		// 取出輸入欄位帳號
		strContent = editContent.getText().toString();
		// 取出輸入欄位密碼
		strPasswd = editPasswd.getText().toString();
		
		if (!strContent.trim().equals("") && !strPasswd.trim().equals("")) {
			new Tool().showToast(this, "登入成功");
			new Tool().jumpActivity(this, UserList.class, null);
			Login.this.finish();
		} else {
			new Tool().showToast(this, "請填寫帳號或密碼。");
		}

	}

}
