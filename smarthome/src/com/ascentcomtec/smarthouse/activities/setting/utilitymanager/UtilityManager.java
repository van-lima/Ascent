package com.ascentcomtec.smarthouse.activities.setting.utilitymanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.ascentcomtec.smarthouse.R;
import com.ascentcomtec.smarthouse.base.BaseActivity;

public class UtilityManager extends BaseActivity implements OnClickListener {

	private Button electricityBt, gasBt, waterBt, usageAlarmBt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.utility_manager_activity);
		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
		}
		initControl();
		setTitle(getString(R.string.utility_manager));
		setButtonListener();

	}

	/**
	 * this function init for all controls by ID
	 */
	@Override
	protected void initControl() {
		super.initControl();
		electricityBt = (Button) findViewById(R.id.myButtonElectricity);
		gasBt = (Button) findViewById(R.id.myButtonGas);
		waterBt = (Button) findViewById(R.id.myButtonWater);
		usageAlarmBt = (Button) findViewById(R.id.myButtonUserAlarm);

	}

	@Override
	protected void setButtonListener() {
		super.setButtonListener();
		settingBt.setOnClickListener(this);

		electricityBt.setOnClickListener(this);
		gasBt.setOnClickListener(this);
		waterBt.setOnClickListener(this);
		usageAlarmBt.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent;
		switch (v.getId()) {
		case R.id.myButtonElectricity:
			intent = new Intent(getApplicationContext(), Electricity.class);
			startActivity(intent);
			break;
		case R.id.myButtonGas:
			intent = new Intent(getApplicationContext(), Gas.class);
			startActivity(intent);
			break;
		case R.id.myButtonWater:
			intent = new Intent(getApplicationContext(), Water.class);
			startActivity(intent);
			break;
		case R.id.myButtonUserAlarm:
			intent = new Intent(getApplicationContext(), UsageAlarm.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

}
