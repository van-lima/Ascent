package com.ascentcomtec.smarthouse.activities.setting.usermanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.ascentcomtec.smarthouse.R;
import com.ascentcomtec.smarthouse.base.BaseActivity;
import com.ascentcomtec.smarthouse.ui.portlets.usermanage.DeleteUser;

public class EditUser extends BaseActivity implements OnClickListener {

	private Button confirmBt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_user_activity);
		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
		}
		initControl();
		setTitle(getString(R.string.edit_user));
		setButtonListener();

	}

	/**
	 * this function init for all controls by ID
	 */
	@Override
	protected void initControl() {
		super.initControl();
		confirmBt = (Button) findViewById(R.id.myButtonConfirm);

	}

	@Override
	protected void setButtonListener() {
		super.setButtonListener();
		helpBt.setOnClickListener(this);
		homeBt.setOnClickListener(this);
		settingBt.setOnClickListener(this);

		confirmBt.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent;
		switch (v.getId()) {
		case R.id.myButtonAddUser:
			intent = new Intent(EditUser.this, EditUser.class);
			startActivity(intent);
			break;
		case R.id.myButtonEditUser:
			intent = new Intent(EditUser.this, EditUser.class);
			startActivity(intent);
			break;
		case R.id.myButtonDeleteUser:
			intent = new Intent(EditUser.this, DeleteUser.class);
			startActivity(intent);
			break;
		case R.id.myButtonSetting:
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
