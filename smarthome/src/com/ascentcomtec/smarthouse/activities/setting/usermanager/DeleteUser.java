package com.ascentcomtec.smarthouse.activities.setting.usermanager;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.ascentcomtec.smarthouse.R;
import com.ascentcomtec.smarthouse.base.BaseActivity;

public class DeleteUser extends BaseActivity implements OnClickListener {

	private Button confirmBt;
	private EditText pinEt;
	private String curString;

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
		pinEt = (EditText) findViewById(R.id.myEditTextAdministratorPin);
		
		findViewById(R.id.myButton0).setOnClickListener(this);
		findViewById(R.id.myButton1).setOnClickListener(this);
		findViewById(R.id.myButton2).setOnClickListener(this);
		findViewById(R.id.myButton3).setOnClickListener(this);
		findViewById(R.id.myButton4).setOnClickListener(this);
		findViewById(R.id.myButton5).setOnClickListener(this);
		findViewById(R.id.myButton6).setOnClickListener(this);
		findViewById(R.id.myButton7).setOnClickListener(this);
		findViewById(R.id.myButton8).setOnClickListener(this);
		findViewById(R.id.myButton9).setOnClickListener(this);
		findViewById(R.id.myButtonDel).setOnClickListener(this);
		findViewById(R.id.myButtonOK).setOnClickListener(this);
	}

	@Override
	protected void setButtonListener() {
		super.setButtonListener();
		settingBt.setOnClickListener(this);

		confirmBt.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.myButtonConfirm:
			finish();
			break;
		case R.id.myButton0:
			addWord(0);
			break;
		case R.id.myButton1:
			addWord(1);
			break;
		case R.id.myButton2:
			addWord(2);
			break;
		case R.id.myButton3:
			addWord(3);
			break;
		case R.id.myButton4:
			addWord(4);
			break;
		case R.id.myButton5:
			addWord(5);
			break;
		case R.id.myButton6:
			addWord(6);
			break;
		case R.id.myButton7:
			addWord(7);
			break;
		case R.id.myButton8:
			addWord(8);
			break;
		case R.id.myButton9:
			addWord(9);
			break;
		case R.id.myButtonDel:
			deleteWord();
			break;
		case R.id.myButtonOK:
			finish();
			break;
		default:
			break;
		}
	}

	private void addWord(int index) {
		curString = pinEt.getText().toString();
		curString = curString + index;
		pinEt.setText(curString);
	}

	private void deleteWord() {
		curString = pinEt.getText().toString();
		if (curString.length()>=1) {
			curString = curString.substring(0, curString.length() - 1);
		}
		pinEt.setText(curString);
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

}
