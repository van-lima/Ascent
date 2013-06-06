package com.ascentcomtec.smarthouse.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

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
				// TODO Auto-generated method stub
				finish();
			}
		});

	}

	protected void setTitle(String title) {
		titleTv.setText(title);
	}

}
