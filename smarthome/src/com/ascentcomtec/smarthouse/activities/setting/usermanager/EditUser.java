package com.ascentcomtec.smarthouse.activities.setting.usermanager;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ascentcomtec.smarthouse.R;
import com.ascentcomtec.smarthouse.base.BaseActivity;

public class EditUser extends BaseActivity implements OnClickListener {

	private Button confirmBt;
	private TextView administratorTv, limitedTv;
	private ImageView administratorIm, limitedIm;
	private RelativeLayout administratorLl, limitedLl;
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
		administratorTv = (TextView) findViewById(R.id.myTextviewViewAdministrator);
		limitedTv = (TextView) findViewById(R.id.myTextviewViewLimited);
		administratorIm = (ImageView) findViewById(R.id.myImageViewAministrator);
		limitedIm = (ImageView) findViewById(R.id.myImageViewLimited);
		administratorLl = (RelativeLayout) findViewById(R.id.myLayoutAdministrator);
		limitedLl = (RelativeLayout) findViewById(R.id.myLayoutLimited);

		administratorTv.setTextColor(0xffffffff);
		limitedTv.setTextColor(0xffcccccc);
	}

	@Override
	protected void setButtonListener() {
		super.setButtonListener();
		settingBt.setOnClickListener(this);
		confirmBt.setOnClickListener(this);
		administratorLl.setOnClickListener(this);
		limitedLl.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.myButtonConfirm:
			finish();
			break;
		case R.id.myLayoutAdministrator:
			administratorIm.setVisibility(View.VISIBLE);
			limitedIm.setVisibility(View.INVISIBLE);
			administratorTv.setTextColor(0xffffffff);
			limitedTv.setTextColor(0xffcccccc);
			break;
		case R.id.myLayoutLimited:
			administratorIm.setVisibility(View.INVISIBLE);
			limitedIm.setVisibility(View.VISIBLE);
			limitedTv.setTextColor(0xffffffff);
			administratorTv.setTextColor(0xffcccccc);
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
