package com.ascentcomtec.smarthouse.activities.setting.usermanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.ascentcomtec.smarthouse.R;
import com.ascentcomtec.smarthouse.adapters.ListUserAdapter;
import com.ascentcomtec.smarthouse.base.BaseActivity;

public class UserManager extends BaseActivity implements OnClickListener,
		OnItemClickListener {

	private Button addUserBt, editUserBt, deleteUserBt;
	private ListView listUser;
	private ListUserAdapter listUserAdapter;
	private String[] users = { "User One", "User Two", "User Three",
			"User Four", "User Five", "User Six", "User Seven", "User Eight" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_manager_activity);
		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
		}
		initControl();
		setTitle(getString(R.string.user_manager));
		setButtonListener();

	}

	/**
	 * this function init for all controls by ID
	 */
	@Override
	protected void initControl() {
		super.initControl();
		addUserBt = (Button) findViewById(R.id.myButtonAddUser);
		editUserBt = (Button) findViewById(R.id.myButtonEditUser);
		deleteUserBt = (Button) findViewById(R.id.myButtonDeleteUser);

		listUser = (ListView) findViewById(R.id.myListViewDevices);
		
		listUser.setOnItemClickListener(this);
		listUserAdapter = new ListUserAdapter(this, users);
		listUser.setAdapter(listUserAdapter);
		listUser.setAnimationCacheEnabled(true);
		listUser.setAlwaysDrawnWithCacheEnabled(true);
		listUser.setCacheColorHint(0x000000);
		listUserAdapter.setCheck(0);
		listUserAdapter.notifyDataSetChanged();
	}

	@Override
	protected void setButtonListener() {
		super.setButtonListener();
		helpBt.setOnClickListener(this);
		homeBt.setOnClickListener(this);
		settingBt.setOnClickListener(this);

		addUserBt.setOnClickListener(this);
		editUserBt.setOnClickListener(this);
		deleteUserBt.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent;
		switch (v.getId()) {
		case R.id.myButtonAddUser:
			intent = new Intent(UserManager.this, AddUser.class);
			startActivity(intent);
			break;
		case R.id.myButtonEditUser:
			intent = new Intent(UserManager.this, EditUser.class);
			startActivity(intent);
			break;
		case R.id.myButtonDeleteUser:
			intent = new Intent(UserManager.this, DeleteUser.class);
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

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long is) {
		listUserAdapter.setCheck(pos);
		listUserAdapter.notifyDataSetChanged();
	}

}
