package com.ascentcomtec.smarthouse.task;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.AsyncTask;

import com.ascentcomtec.smarthouse.MainActivity;
import com.ascentcomtec.smarthouse.activities.setting.devicemanager.DeviceManager;
import com.netvox.zbapi.java.API;
import com.netvox.zbapi.java.model.CZBNode;

public class DeviceListTask extends AsyncTask<Integer, Integer, String> {

	private Activity activity;
	private AlertDialog dialog;

	public DeviceListTask(Activity activity) {
		super();
		this.activity = activity;

		Builder bd = new AlertDialog.Builder(activity);
		bd.setTitle("Information");
		bd.setMessage("Refresh the list...");
		dialog = bd.show();

	}

	@Override
	protected void onCancelled() {
		// TODO Auto-generated method stub
		super.onCancelled();
	}

	@Override
	protected void onPostExecute(String result) {
		if (activity instanceof DeviceManager) {
			((DeviceManager)activity).InitData();
		}else if (activity instanceof MainActivity) {
			((MainActivity)activity).InitData();
		}
		
		dialog.dismiss();
		super.onPostExecute(result);
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		dialog.show();
		super.onPreExecute();
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		super.onProgressUpdate(values);
	}

	@Override
	protected String doInBackground(Integer... params) {
		if (activity instanceof DeviceManager) {
			((DeviceManager)activity).arrayDev.clear();
			int zc = API.ZBGetZBNodeCount();
			for (int i = 0; i < zc; i++) {
				CZBNode node = API.ZBGetZBNodeByIndex(i);
				((DeviceManager)activity).arrayDev.add(node);
				node = null;
			}
		}else if (activity instanceof MainActivity) {
			((MainActivity)activity).arrayDev.clear();
			int zc = API.ZBGetZBNodeCount();
			for (int i = 0; i < zc; i++) {
				CZBNode node = API.ZBGetZBNodeByIndex(i);
				((MainActivity)activity).arrayDev.add(node);
				node = null;
			}
		}
		
		
		return "finish";
	}

}
