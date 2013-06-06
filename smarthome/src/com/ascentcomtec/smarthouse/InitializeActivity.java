package com.ascentcomtec.smarthouse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.netvox.zbapi.java.API;
import com.netvox.zbapi.java.model.ComParamUnit;

public class InitializeActivity extends Activity implements OnClickListener {

	// private final String IP = "192.168.0.104";
	// private final int PORT = 5000;
	private final int SPLASH_SCREEN_TIME_IN_MILLIS = 2000;
	private static int INITIALIZE_TCPIP = 3;
	private ComParamUnit param = null;
	private int mode;
	// private EditText etIp, etPort;
	// private Button btCancel, btOk;
	private String ip;
	private int port;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_activity);
		initControl();
		intitData();
		mode = INITIALIZE_TCPIP;
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				connect();
			}
		}, SPLASH_SCREEN_TIME_IN_MILLIS);

	}

	private void unInitialize() {
		try {
			if (Application.isInitialize == true) {
				boolean res = API.ZBDevInvalidate();
				if (res) {
					Application.isInitialize = false;
				}
			}
		} catch (Exception e) {
		}

	}

	private void initControl() {
		// etIp = (EditText) findViewById(R.id.et_ipInput);
		// etPort = (EditText) findViewById(R.id.et_portInput);
		// btCancel = (Button) findViewById(R.id.bt_cancel);
		// btOk = (Button) findViewById(R.id.bt_ok);
		// btCancel.setOnClickListener(this);
		// btOk.setOnClickListener(this);
	}

	private void intitData() {
		ip = "192.168.1.165";
		port = 5000;
	}

	private void connect() {
		// ip = etIp.getText().toString();
		// port = Integer.parseInt(etPort.getText().toString());
		param = new ComParamUnit(mode, 0, 0, "", ip, port, "",
				MainActivity.class.getPackage().getName());
		boolean res = API.ZBDevInitialize(param);
		if (res == true) {
			Application.isInitialize = true;
			Toast.makeText(this, "Initialize SDK succeed!", 0).show();
		} else if (res == false) {
			Toast.makeText(this, "Initialize SDK failed!Please try again!", 0)
					.show();
		}

		Intent i = new Intent(InitializeActivity.this, MainActivity.class);
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		this.startActivity(i);
		i = null;
		finish();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bt_cancel:
			finish();
			break;
		case R.id.bt_ok:
			connect();
			break;

		default:
			break;
		}
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		unInitialize();
		super.onResume();
	}

}
