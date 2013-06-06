package com.ascentcomtec.smarthouse.activities.setting.devicemanager;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.ascentcomtec.smarthouse.Application;
import com.ascentcomtec.smarthouse.R;
import com.ascentcomtec.smarthouse.adapters.ListDeviceAdapter;
import com.ascentcomtec.smarthouse.base.BaseActivity;
import com.ascentcomtec.smarthouse.constant.Constant;
import com.ascentcomtec.smarthouse.task.DeviceListTask;
import com.ascentcomtec.smarthouse.ui.portlets.devicemanage.AddDevice;
import com.ascentcomtec.smarthouse.ui.portlets.devicemanage.DeleteDevice;
import com.ascentcomtec.smarthouse.ui.portlets.devicemanage.EditDevice;
import com.netvox.zbapi.java.API;
import com.netvox.zbapi.java.constant.NodeAttr;
import com.netvox.zbapi.java.constant.RtDeviceType;
import com.netvox.zbapi.java.event.ZBEvent;
import com.netvox.zbapi.java.listener.CreateNewZBNodeListener;
import com.netvox.zbapi.java.listener.SearchProgressChangeListener;
import com.netvox.zbapi.java.listener.ZBAttrChangeListener;
import com.netvox.zbapi.java.model.CEndPoint;
import com.netvox.zbapi.java.model.CZBNode;

public class DeviceManager extends BaseActivity implements OnClickListener,
		OnItemClickListener, SearchProgressChangeListener,
		CreateNewZBNodeListener, ZBAttrChangeListener {

	private Button addMonitoredBt, addUnMonitoredBt, editApplianceBt,
			deleteApplianceBt;
	private ListView listDevices;
	private AlertDialog dialog = null;
	public ArrayList<CZBNode> arrayDev = new ArrayList<CZBNode>();
	public static ArrayList<CEndPoint> endPoints = null;
	private ListDeviceAdapter listDeviceAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.device_manager_activity);
		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
		}
		endPoints = new ArrayList<CEndPoint>();
		initControl();
		setTitle(getString(R.string.device_manager));
		setButtonListener();
		ZBEvent.InitEventSystem();
		ZBEvent.AddSearchProgressChangeListener(this);
		ZBEvent.AddCreateNewZBNodeListener(this);
		ZBEvent.AddZBAttrChangeListener(this);

		if (Application.isInitialize) {
			RefreshData();
		}

	}

	/**
	 * this function init for all controls by ID
	 */
	@Override
	protected void initControl() {
		super.initControl();
		addMonitoredBt = (Button) findViewById(R.id.myButtonAddMotion);
		addUnMonitoredBt = (Button) findViewById(R.id.myButtonAddUnMotion);
		editApplianceBt = (Button) findViewById(R.id.myButtonEditAppliance);
		deleteApplianceBt = (Button) findViewById(R.id.myButtonDeleteAppliance);

		listDevices = (ListView) findViewById(R.id.myListViewDevices);
		listDevices.setOnItemClickListener(this);
		listDeviceAdapter = new ListDeviceAdapter(this, endPoints);
		listDevices.setAdapter(listDeviceAdapter);
		listDevices.setAnimationCacheEnabled(true);
		listDevices.setAlwaysDrawnWithCacheEnabled(true);
		listDevices.setCacheColorHint(0x000000);
	}

	@Override
	protected void setButtonListener() {
		super.setButtonListener();
		helpBt.setOnClickListener(this);
		homeBt.setOnClickListener(this);
		settingBt.setOnClickListener(this);

		addMonitoredBt.setOnClickListener(this);
		addUnMonitoredBt.setOnClickListener(this);
		editApplianceBt.setOnClickListener(this);
		deleteApplianceBt.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent;
		switch (v.getId()) {
		case R.id.myButtonAddMotion:
			intent = new Intent(DeviceManager.this, AddDevice.class);
			startActivity(intent);
			break;
		case R.id.myButtonAddUnMotion:
			intent = new Intent(DeviceManager.this, AddDevice.class);
			startActivity(intent);
			break;
		case R.id.myButtonEditAppliance:
			intent = new Intent(DeviceManager.this, EditDevice.class);
			startActivity(intent);
			break;
		case R.id.myButtonDeleteAppliance:
			intent = new Intent(DeviceManager.this, DeleteDevice.class);
			startActivity(intent);
			break;
		case R.id.myButtonSetting:
			searchDevices();
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
	public void onZBAttrChange(CZBNode node, NodeAttr attr, String value) {
		// TODO Auto-generated method stub
		CZBNode dev = null;
		for (CZBNode n : arrayDev) {
			if (n.m_ZBNodeAttr.IEEE.equals(node.m_ZBNodeAttr.IEEE)) {
				dev = n;

			}
		}

		if (attr == NodeAttr.ModelIdentify) {
			dev.m_ZBNodeAttr.ModelID = value;
			Message msg = searchHandle.obtainMessage();
			msg.what = 0x0003;
			searchHandle.sendMessage(msg);
		}
		if (attr == NodeAttr.TYPE) {
			if (dev == null || dev.m_ZBNodeAttr == null)
				return;
			dev.m_ZBNodeAttr.enumRtDeviceTypeEndPoType = RtDeviceType
					.getRtDeviceTypeByValue(Integer.parseInt(value));
			Message msg = searchHandle.obtainMessage();
			msg.what = 0x0003;
			searchHandle.sendMessage(msg);
		}
	}

	@Override
	public void onCreateNewZBNodeBack(CZBNode arg) {
		// TODO Auto-generated method stub
		int size = arrayDev.size();
		boolean isExist = false;
		for (int i = 0; i < size; i++) {
			CZBNode node = arrayDev.get(i);
			if (node.m_ZBNodeAttr.IEEE.equals(arg.m_ZBNodeAttr.IEEE)) {
				isExist = true;
			}
		}
		if (!isExist) {
			arrayDev.add(arg);
			Message msg = searchHandle.obtainMessage();
			msg.what = 0x0003;
			searchHandle.sendMessage(msg);
		}
	}

	@Override
	public void onSearchProgressChange(int progress) {
		// TODO Auto-generated method stub
		Message msg = searchHandle.obtainMessage();
		if (progress == 100) {
			msg.what = 0x0001;
		} else {
			msg.what = 0x0002;
			msg.arg1 = progress;
		}
		searchHandle.sendMessage(msg);
		msg = null;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long id) {
		listDeviceAdapter.setCheck(pos);
		listDeviceAdapter.notifyDataSetChanged();
	}

	private void searchDevices() {
		// init connection
		Builder bd = new AlertDialog.Builder(DeviceManager.this);
		bd.setTitle("Information");
		bd.setMessage("Searching devices...");
		dialog = bd.show();
		Application.isSearchStart = true;
		API.ZBStartManuSearchDev();
	}

	private Handler searchHandle = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 0x0001: {
				dialog.dismiss();
				break;
			}
			case 0x0002: {
				dialog.setMessage("Search devices : " + msg.arg1 + "%");
				break;
			}
			case 0x0003: {
				InitData();
				break;
			}
			}
		}

	};

	public void RefreshData() {
		try {
			DeviceListTask task = new DeviceListTask(DeviceManager.this);
			task.execute(0);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void InitData() {
		try {
			endPoints = new ArrayList<CEndPoint>();
			for (int i = 0; i < arrayDev.size(); i++) {
				ArrayList<CEndPoint> temp = null;
				CZBNode node = API.ZBGetZBNodeByIndex(arrayDev.get(i).index);
				temp = API.ZBGetEndPointsByIEEE(node.m_ZBNodeAttr.IEEE);
				if (temp != null && temp.size() > 0) {
					String id = temp.get(0).m_EPAttr.DeviceID;
					if (id.equalsIgnoreCase(Constant.SWITCH)) {
						for (CEndPoint cEndPoint : temp) {
							endPoints.add(cEndPoint);
						}
					} else if (id.equalsIgnoreCase(Constant.TMSENSOR)) {
					}
				}
			}
			listDeviceAdapter.removeAllItem();
			listDeviceAdapter.addItems(endPoints);
			listDeviceAdapter.notifyDataSetChanged();
		} catch (Exception e) {
		}
	}

}
