package com.ascentcomtec.smarthouse.ui.portlets.control;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.ascentcomtec.smarthouse.Application;
import com.ascentcomtec.smarthouse.MainActivity;
import com.ascentcomtec.smarthouse.R;
import com.ascentcomtec.smarthouse.constant.Constant;
import com.ascentcomtec.smarthouse.ui.activities.AbstractActivity;
import com.ascentcomtec.smarthouse.ui.components.HAFormFactory;
import com.ascentcomtec.smarthouse.ui.components.button.JButton;
import com.ascentcomtec.smarthouse.ui.components.textview.JTextView;
import com.ascentcomtec.smarthouse.ui.plaf.Style;
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
import com.resolutiondev.ui.drawable.JDrawable;

public class DeviceManage extends HAFormFactory implements OnItemClickListener,
		OnItemSelectedListener, SearchProgressChangeListener,
		CreateNewZBNodeListener, ZBAttrChangeListener {

	private ListView listViewDevices;
	private AlertDialog dialog = null;
	public ArrayList<CZBNode> arrayDev = new ArrayList<CZBNode>();
	public static ArrayList<CEndPoint> endPoints = null;

	@Override
	public void executeUI() {
		setTitle("Device Manage");

		LinearLayout linearLayoutRoot = new LinearLayout(
				getApplicationContext());
		linearLayoutRoot.setLayoutParams(getLinearLayoutLayoutParams());
		linearLayoutRoot.setPadding(10, 10, 10, 10);
		linearLayoutRoot.setOrientation(LinearLayout.HORIZONTAL);

		LinearLayout linearLayoutLeft = new LinearLayout(
				getApplicationContext());
		linearLayoutLeft.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutLeft.setOrientation(LinearLayout.VERTICAL);
		linearLayoutLeft.setGravity(Gravity.LEFT);
		JTextView jTextView = new JTextView(getApplicationContext());
		jTextView.setGravity(Gravity.CENTER);
		jTextView.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT));
		jTextView.setText("Current Devices");
		linearLayoutLeft.addView(jTextView);
		listViewDevices = new ListView(getApplicationContext());
		listViewDevices.setBackgroundDrawable(JDrawable.getJDrawable()
				.drawRoundRect(new float[] { 10, 10, 10, 10, 10, 10, 10, 10 },
						3, Color.BLACK));
		String[] devices = new String[] { "Device One", "Device Two",
				"Device Three", "Device Four", "Device Five", "Device Six",
				"Device Seven", "Device Eight", "Device Nine", "Device Ten" };
		// Instantiating array adapter to populate the listView
		// The layout android.R.layout.simple_list_item_single_choice creates
		// radio button for each listview item
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_single_choice, devices);
		listViewDevices.setAdapter(adapter);
		listViewDevices.setOnItemClickListener(this);
		listViewDevices.setOnItemSelectedListener(this);
		listViewDevices.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		listViewDevices.setItemChecked(0, true);
		linearLayoutLeft.addView(listViewDevices);
		linearLayoutRoot.addView(linearLayoutLeft);

		LinearLayout linearLayoutRight = new LinearLayout(
				getApplicationContext());
		linearLayoutRight.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutRight.setOrientation(LinearLayout.VERTICAL);
		linearLayoutRight.setGravity(Gravity.RIGHT | Gravity.CENTER);

		JButton jButtonAddMonitoredAppliance = new JButton(
				getApplicationContext());
		jButtonAddMonitoredAppliance
				.setLayoutParams(getLinearLayoutLayoutParam());
		jButtonAddMonitoredAppliance.setBackgroundDrawable(getResources()
				.getDrawable(R.drawable.button_add_monitored_appliance));
		jButtonAddMonitoredAppliance
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = new Intent(DeviceManage.this,
								AddDevice.class);
						startActivity(intent);
					}
				});
		linearLayoutRight.addView(jButtonAddMonitoredAppliance);

		JButton jButtonAddAddUnMonitoredAppliance = new JButton(
				getApplicationContext());
		jButtonAddAddUnMonitoredAppliance
				.setLayoutParams(getLinearLayoutLayoutParam());
		jButtonAddAddUnMonitoredAppliance.setBackgroundDrawable(getResources()
				.getDrawable(R.drawable.button_add_un_monitored_appliance));
		jButtonAddAddUnMonitoredAppliance
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = new Intent(DeviceManage.this,
								AddDevice.class);
						startActivity(intent);
					}
				});
		linearLayoutRight.addView(jButtonAddAddUnMonitoredAppliance);

		JButton jButtonEditAppliance = new JButton(getApplicationContext());
		jButtonEditAppliance.setLayoutParams(getLinearLayoutLayoutParam());
		jButtonEditAppliance.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.button_edit_appliance));
		jButtonEditAppliance.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DeviceManage.this, EditDevice.class);
				startActivity(intent);
			}
		});
		linearLayoutRight.addView(jButtonEditAppliance);

		JButton jButtonDeleteAppliance = new JButton(getApplicationContext());
		jButtonDeleteAppliance.setLayoutParams(getLinearLayoutLayoutParam());
		jButtonDeleteAppliance.setBackgroundDrawable(getResources()
				.getDrawable(R.drawable.button_delete_appliance));
		jButtonDeleteAppliance.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DeviceManage.this,
						DeleteDevice.class);
				startActivity(intent);
			}
		});
		linearLayoutRight.addView(jButtonDeleteAppliance);

		linearLayoutRoot.addView(linearLayoutRight);

		RelativeLayout relativeLayout = new RelativeLayout(
				getApplicationContext());
		relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.FILL_PARENT,
				RelativeLayout.LayoutParams.FILL_PARENT));
		relativeLayout.addView(linearLayoutRoot);
		getContentPane().addView(relativeLayout);

		ZBEvent.InitEventSystem();
		ZBEvent.AddSearchProgressChangeListener(this);
		ZBEvent.AddCreateNewZBNodeListener(this);
		ZBEvent.AddZBAttrChangeListener(this);

		addManuBar();
		if (Application.isInitialize) {
			RefreshData();
		}

	}

	private void addManuBar() {

		LinearLayout menuBarControl = new LinearLayout(getApplicationContext());
		menuBarControl.setGravity(Gravity.CENTER);
		ImageView imageViewHelp = new ImageView(getApplicationContext());
		imageViewHelp.setPadding(10, 0, 10, 0);
		imageViewHelp.setImageResource(R.drawable.help);
		imageViewHelp.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				showAlertDialog("Coming Soon !");
			}
		});
		menuBarControl.addView(imageViewHelp);
		ImageView imageViewSetting = new ImageView(getApplicationContext());
		imageViewSetting.setPadding(10, 0, 10, 0);
		imageViewSetting.setImageResource(R.drawable.setting);
		imageViewSetting.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				searchDevices();
			}
		});
		menuBarControl.addView(imageViewSetting);
		ImageView imageViewHome = new ImageView(getApplicationContext());
		imageViewHome.setPadding(10, 0, 10, 0);
		imageViewHome.setImageResource(R.drawable.home);
		menuBarControl.addView(imageViewHome);
		imageViewHome.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intentYWCAHome = new Intent(DeviceManage.this,
						MainActivity.class);
				intentYWCAHome.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
						| Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intentYWCAHome);
			}
		});
		actionBar.addControlActionBarNext(menuBarControl);
	}

	private void searchDevices() {
		// init connection
		Builder bd = new AlertDialog.Builder(DeviceManage.this);
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
//			DeviceListTask task = new DeviceListTask(DeviceManager.this);
//			task.execute(0);
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
		} catch (Exception e) {
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		listViewDevices.setItemChecked(arg2, true);
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {

	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

	}

	/***
	 * get layout params for screen title
	 * 
	 * @return
	 */
	public LinearLayout.LayoutParams getLinearLayoutLayoutParam() {
		Style style = new Style(getApplicationContext());
		style.setMargin(10, 10, 10, 10);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(style.getMarginValue(AbstractActivity.LEFT),
				style.getMarginValue(AbstractActivity.TOP),
				style.getMarginValue(AbstractActivity.RIGHT),
				style.getMarginValue(AbstractActivity.BOTTOM));
		return layoutParams;
	}

	/***
	 * get layout params for screen title
	 * 
	 * @return
	 */
	public LinearLayout.LayoutParams getLinearLayoutLayoutParams() {
		Style style = new Style(getApplicationContext());
		style.setMargin(10, 10, 10, 10);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT);
		layoutParams.setMargins(style.getMarginValue(AbstractActivity.LEFT),
				style.getMarginValue(AbstractActivity.TOP),
				style.getMarginValue(AbstractActivity.RIGHT),
				style.getMarginValue(AbstractActivity.BOTTOM));
		return layoutParams;
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
}
