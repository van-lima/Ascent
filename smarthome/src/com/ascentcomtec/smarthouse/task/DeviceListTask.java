package com.ascentcomtec.smarthouse.task;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.AsyncTask;

import com.ascentcomtec.smarthouse.activities.setting.devicemanager.DeviceManager;
import com.ascentcomtec.smarthouse.ui.portlets.control.DeviceManage;
import com.netvox.zbapi.java.API;
import com.netvox.zbapi.java.model.CZBNode;

public class DeviceListTask extends AsyncTask<Integer, Integer, String>{

	private DeviceManager activity;
	private AlertDialog dialog;
	
	public DeviceListTask(DeviceManager activity) {
		super();
		this.activity = activity;
		
		Builder bd = new AlertDialog.Builder(activity);
		bd.setTitle("Information");
		bd.setMessage("Refresh the list...");
		dialog=bd.show();

	}

	@Override
	protected void onCancelled() {
		// TODO Auto-generated method stub
		super.onCancelled();
	}

	@Override
	protected void onPostExecute(String result) {
		activity.InitData();
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
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
	}

	@Override
	protected String doInBackground(Integer... params) {
		activity.arrayDev.clear();
		int zc = API.ZBGetZBNodeCount();
		for(int i=0;i<zc;i++)
		{
			CZBNode node = API.ZBGetZBNodeByIndex(i);
			activity.arrayDev.add(node);
			node=null;
		}
		return "finish";
	}
	

}
