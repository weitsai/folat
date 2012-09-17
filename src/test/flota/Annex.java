package test.flota;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class Annex extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.annex);

	}

	public void black(View v) {
		Annex.this.finish();
	}
}
