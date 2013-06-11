package com.ascentcomtec.smarthouse.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ascentcomtec.smarthouse.MainActivity;
import com.ascentcomtec.smarthouse.R;

public class BaseActivity extends Activity {

	protected TextView titleTv;
	protected Button backBt, helpBt, homeBt, settingBt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	/**
	 * this function init for all controls by ID
	 */
	protected void initControl() {
		titleTv = (TextView) findViewById(R.id.myTextViewTitle);
		backBt = (Button) findViewById(R.id.myButtonBack);
		helpBt = (Button) findViewById(R.id.myButtonHelp);
		homeBt = (Button) findViewById(R.id.myButtonHome);
		settingBt = (Button) findViewById(R.id.myButtonSetting);
	}

	protected void setButtonListener() {
		backBt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

		homeBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent home = new Intent(BaseActivity.this,
						MainActivity.class);
				home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(home);
				finish();
			}
		});
		helpBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(BaseActivity.this, "Coming soon", 0).show();
			}
		});

	}

	protected void setTitle(String title) {
		titleTv.setText(title);
	}

}
