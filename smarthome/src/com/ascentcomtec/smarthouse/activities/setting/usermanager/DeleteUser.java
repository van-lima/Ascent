package com.ascentcomtec.smarthouse.activities.setting.usermanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;

import com.ascentcomtec.smarthouse.R;
import com.ascentcomtec.smarthouse.base.BaseActivity;
import com.ascentcomtec.smarthouse.ui.portlets.usermanage.EditUser;

public class DeleteUser extends BaseActivity implements OnClickListener {

	private Button confirmBt;
	private GridView gridView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.delete_user_activity);
		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
		}
		initControl();
		setTitle(getString(R.string.delete_user));
		setButtonListener();

	}

	/**
	 * this function init for all controls by ID
	 */
	@Override
	protected void initControl() {
		super.initControl();
		confirmBt = (Button) findViewById(R.id.myButtonConfirm);
//		gridView = (GridView)findViewById(R.id.myGridViewKeypad);

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
			intent = new Intent(DeleteUser.this, DeleteUser.class);
			startActivity(intent);
			break;
		case R.id.myButtonEditUser:
			intent = new Intent(DeleteUser.this, EditUser.class);
			startActivity(intent);
			break;
		case R.id.myButtonDeleteUser:
			intent = new Intent(DeleteUser.this, DeleteUser.class);
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
