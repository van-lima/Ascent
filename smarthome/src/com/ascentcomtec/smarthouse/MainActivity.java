package com.ascentcomtec.smarthouse;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.ascentcomtec.smarthouse.Control.OnItemSelectedListener;
import com.ascentcomtec.smarthouse.Security.OnSecuritySelectedListener;
import com.ascentcomtec.smarthouse.activities.setting.devicemanager.DeviceManager;
import com.ascentcomtec.smarthouse.ui.components.ActionBar;
import com.ascentcomtec.smarthouse.ui.components.Font;
import com.ascentcomtec.smarthouse.ui.components.FormFactory;
import com.ascentcomtec.smarthouse.ui.components.textview.JTextView;
import com.ascentcomtec.smarthouse.ui.portlets.control.DeviceManage;
import com.ascentcomtec.smarthouse.ui.portlets.settings.Setting;
import com.ascentcomtec.smarthouse.utilities.ChartUtilities;
import com.ascentcomtec.smarthouse.utils.Utils;
import com.netvox.zbapi.java.API;
import com.netvox.zbapi.java.constant.MainsPowerOutletAttr;
import com.netvox.zbapi.java.constant.NodeAttr;
import com.netvox.zbapi.java.constant.TemperatureSensorAttr;
import com.netvox.zbapi.java.event.ZBEvent;
import com.netvox.zbapi.java.listener.AC_MainsPowerOutletListener;
import com.netvox.zbapi.java.listener.AC_TemperatureSensorListener;
import com.netvox.zbapi.java.listener.CreateNewZBNodeListener;
import com.netvox.zbapi.java.listener.SearchProgressChangeListener;
import com.netvox.zbapi.java.listener.ZBAttrChangeListener;
import com.netvox.zbapi.java.model.CEndPoint;
import com.netvox.zbapi.java.model.CZBNode;
import com.resolutiondev.ui.drawable.JDrawable;

public class MainActivity extends FormFactory implements
		AC_MainsPowerOutletListener, SearchProgressChangeListener,
		CreateNewZBNodeListener, ZBAttrChangeListener, OnItemSelectedListener,
		OnSecuritySelectedListener, AC_TemperatureSensorListener {

	// public ArrayList<CZBNode> arrayDev = new ArrayList<CZBNode>();
	// private AlertDialog dialog = null;
	// private ArrayList<CEndPoint> endPointSwitch = null;
	private Control rightControl;
	private Security securityControl;
	private TemperatureHumidity temperatureLl;

	@Override
	public void execute() {

		ActionBar actionBar = new ActionBar(this);

		LinearLayout menuBarControl = new LinearLayout(getApplicationContext());
		menuBarControl.setGravity(Gravity.CENTER);

		ImageView imageViewHome = new ImageView(getApplicationContext());
		imageViewHome.setLayoutParams(getLinearLayoutLayoutParams());
		imageViewHome.setImageResource(R.drawable.home);
		menuBarControl.addView(imageViewHome);
		imageViewHome.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						MainActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
						| Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
			}
		});

		ImageView imageViewSetting = new ImageView(getApplicationContext());
		imageViewSetting.setLayoutParams(getLinearLayoutLayoutParams());
		imageViewSetting.setImageResource(R.drawable.setting);
		imageViewSetting.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, Setting.class);
				startActivity(i);
				i = null;
			}
		});
		menuBarControl.addView(imageViewSetting);

		ImageView imageViewHelp = new ImageView(getApplicationContext());
		imageViewHelp.setLayoutParams(getLinearLayoutLayoutParams());
		imageViewHelp.setImageResource(R.drawable.help);
		imageViewHelp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intentHelp = new Intent(MainActivity.this, Help.class);
				intentHelp.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
						| Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intentHelp);

			}
		});
		menuBarControl.addView(imageViewHelp);

		actionBar.addControlActionBarNext(menuBarControl);
		LinearLayout linearLayoutLogoTime = new LinearLayout(
				getApplicationContext());
		linearLayoutLogoTime.setGravity(Gravity.LEFT | Gravity.CENTER);
		linearLayoutLogoTime.setOrientation(LinearLayout.HORIZONTAL);

		ImageView imageViewLogo = new ImageView(getApplicationContext());
		imageViewLogo.setPadding(10, 0, 120, 0);
		imageViewLogo.setBackgroundResource(R.drawable.lima_logo);
		imageViewLogo.setLayoutParams(new LayoutParams(190, 36));

		linearLayoutLogoTime.addView(imageViewLogo);
		JTextView jTextViewTime = new JTextView(getApplicationContext());

		jTextViewTime.setPadding(50, 10, 10, 10);
		jTextViewTime.setBackgroundDrawable(JDrawable.getJDrawable().drawRect(
				2, Color.BLACK));
		jTextViewTime.setGravity(Gravity.LEFT | Gravity.CENTER);
		jTextViewTime.setText(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
				.format(new Date()));
		jTextViewTime.setTextColor(0xFF000000);
		jTextViewTime.setTypeface(Font.createSystemFont(
				getApplicationContext(), Font.FACE_UTMCENTUR, Font.STYLE_BOLD,
				16));
		jTextViewTime.setTextSize(Font.getSize());
//		linearLayoutLogoTime.addView(jTextViewTime);
		actionBar.addControlActionBarLeft(linearLayoutLogoTime);

		getTitleArea().addView(actionBar);
		// root layout
		LinearLayout linearLayoutRoot = new LinearLayout(
				getApplicationContext());
		linearLayoutRoot.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT));
		linearLayoutRoot.setGravity(Gravity.CENTER);
		linearLayoutRoot.setOrientation(LinearLayout.HORIZONTAL);
		// linearLayoutRoot.setBackgroundColor(Color.BLUE);
		// layout left
		LinearLayout linearLayoutColumnFirst = new LinearLayout(
				getApplicationContext()) {
			final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
			final int color[] = { 0xFF666666, 0xFF666666, 0xFF666666 };

			@Override
			protected void onDraw(Canvas canvas) {
				super.onDraw(canvas);
				for (int i = 0; i < 1; i++) {
					paint.setColor(color[i]); // color.RED
					canvas.drawLine(getScreenWidth() / 2 - i, 0,
							getScreenWidth() / 2 - i, canvas.getHeight(), paint);
				}
			}
		};
		linearLayoutColumnFirst.setBackgroundDrawable(new ColorDrawable(
				Color.TRANSPARENT));
		linearLayoutColumnFirst.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutColumnFirst.addView(getLinearLayoutLeft());
		linearLayoutRoot.addView(linearLayoutColumnFirst);

		// layout right
		LinearLayout linearLayoutColumnSecond = new LinearLayout(
				getApplicationContext());
		// linearLayoutColumnSecond.setBackgroundColor(Color.GREEN);
		linearLayoutColumnSecond.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutRoot.addView(linearLayoutColumnSecond);
		linearLayoutColumnSecond.addView(getLinearLayoutRigth());
		getContentPane().setBackgroundDrawable(
				drawableBackgroundImage(getApplicationContext()));
		getContentPane().addView(linearLayoutRoot);

		LinearLayout linearLayoutMenuBar = new LinearLayout(
				getApplicationContext());
		linearLayoutMenuBar.setGravity(Gravity.CENTER);
		linearLayoutMenuBar.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT));
		JTextView jTextView = new JTextView(getApplicationContext());
		jTextView.setGravity(Gravity.CENTER);
		jTextView.setText("Powered by IP LIMA");
		linearLayoutMenuBar.addView(jTextView);
		getMenuBar().addView(linearLayoutMenuBar);

		ZBEvent.InitEventSystem();
		// ZBEvent.AddSearchProgressChangeListener(this);
		// ZBEvent.AddCreateNewZBNodeListener(this);
		ZBEvent.AddZBAttrChangeListener(this);
		ZBEvent.AddAC_TemperatureSensorListener(this);
		ZBEvent.AddAC_MainsPowerOutletListener(this);
		// if (Application.isInitialize) {
		// RefreshData();
		// }

	}

	/**
	 * return drawable image,id of image config in class Constant
	 * 
	 * @param context
	 * @return
	 */
	public Drawable drawableBackgroundImage(Context context) {
		return new ColorDrawable(0xFFb9c2c6);
	}

	/**
	 * 
	 * @return
	 */
	public LinearLayout getLinearLayoutLeft() {
		int height = (getContentPaneHeight() - Utils.convertDips2Pixel(45,
				getApplicationContext())) / 3;
		LinearLayout linearLayout = new LinearLayout(getApplicationContext());
		linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT));
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		LinearLayout title = getTitleViewRightBorder("Utilities",
				R.drawable.detail);
		title.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						ChartUtilities.class);
				startActivity(intent);
			}
		});
		linearLayout.addView(title);

		// first row
		LinearLayout linearLayoutFirst = new LinearLayout(
				getApplicationContext());
		linearLayoutFirst.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, height));
		// linearLayoutFirst.setBackgroundColor(Color.CYAN);
		linearLayoutFirst.addView(new Electricity(MainActivity.this, height));
		linearLayout.addView(linearLayoutFirst);
		// second row
		LinearLayout linearLayoutSecond = new LinearLayout(
				getApplicationContext());
		// linearLayoutSecond.setBackgroundColor(Color.YELLOW);
		linearLayoutSecond.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, height));
		linearLayoutSecond.addView(new Gas(MainActivity.this, height));
		linearLayout.addView(linearLayoutSecond);
		// third row
		LinearLayout linearLayoutThird = new LinearLayout(
				getApplicationContext());
		// linearLayoutThird.setBackgroundColor(Color.MAGENTA);
		linearLayoutThird.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, height));
		linearLayoutThird.addView(new Water(MainActivity.this, height));
		linearLayout.addView(linearLayoutThird);
		return linearLayout;
	}

	/**
	 * 
	 * @return
	 */
	public LinearLayout getLinearLayoutRigth() {
		int delta = Utils.convertDips2Pixel(10, getApplicationContext());
		LinearLayout linearLayout = new LinearLayout(getApplicationContext());
		linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT));
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		// first row
		LinearLayout linearLayoutFirst = new LinearLayout(
				getApplicationContext());
		linearLayoutFirst.setOrientation(LinearLayout.VERTICAL);
		linearLayoutFirst.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, getContentPaneHeight()
						/ 3 + delta));
		// linearLayoutFirst.setBackgroundColor(Color.RED);
		LinearLayout titleSecurity = getTitleView("Security", R.drawable.detail);
		titleSecurity.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						SecuriryCenter.class);
				startActivity(intent);
			}
		});
		linearLayoutFirst.addView(titleSecurity);
		securityControl = new Security(getApplicationContext(),
				(getContentPaneHeight() / 3 + delta)
						- Utils.convertDips2Pixel(45, getApplicationContext()),
				this);

		linearLayoutFirst.addView(securityControl);
		linearLayout.addView(linearLayoutFirst);
		// second row
		LinearLayout linearLayoutSecond = new LinearLayout(
				getApplicationContext());
		linearLayoutSecond.setOrientation(LinearLayout.VERTICAL);
		// linearLayoutSecond.setBackgroundColor(Color.GREEN);
		linearLayoutSecond.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, getContentPaneHeight()
						/ 3 + delta));
		LinearLayout titleControl = getTitleView("Control", R.drawable.detail);
		titleControl.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, ControlMore.class);
				startActivity(intent);
			}
		});
		linearLayoutSecond.addView(titleControl);
		rightControl = new Control(getApplicationContext(),
				(getContentPaneHeight() / 3 + delta)
						- Utils.convertDips2Pixel(45, getApplicationContext()),
				this);
		linearLayoutSecond.addView(rightControl);
		linearLayout.addView(linearLayoutSecond);
		// third row
		LinearLayout linearLayoutThird = new LinearLayout(
				getApplicationContext());
		// linearLayoutThird.setBackgroundColor(Color.BLUE);
		linearLayoutThird.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, getContentPaneHeight()
						/ 3 - delta * 2));
		temperatureLl = new TemperatureHumidity(getApplicationContext(),
				getContentPaneHeight() / 3 - delta * 2);
		linearLayoutThird.addView(temperatureLl);
		linearLayout.addView(linearLayoutThird);
		temperatureLl.updateData(0, 0);
		return linearLayout;
	}

	/***
	 * 
	 * @return
	 */
	public LinearLayout getTitleView(String title, int id) {
		LinearLayout linearLayout = new LinearLayout(getApplicationContext());
		linearLayout.setPadding(5, 5, 5, 5);
		linearLayout.setOrientation(LinearLayout.HORIZONTAL);
		linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, Utils.convertDips2Pixel(
						45, getApplicationContext())));
		linearLayout.setBackgroundResource(R.drawable.title_bar);
		LinearLayout.LayoutParams layoutParamsColumn = new LinearLayout.LayoutParams(
				TableRow.LayoutParams.FILL_PARENT,
				TableRow.LayoutParams.FILL_PARENT, 1);
		LinearLayout linearLayoutLeft = new LinearLayout(
				getApplicationContext());
		linearLayoutLeft.setGravity(Gravity.LEFT | Gravity.CENTER);
		linearLayoutLeft.setLayoutParams(layoutParamsColumn);
		JTextView jTextViewTitleControl = new JTextView(getApplicationContext());
		jTextViewTitleControl.setTextColor(0xFF000000);
		jTextViewTitleControl.setModeSubTitle(getApplicationContext());
		jTextViewTitleControl.setGravity(Gravity.CENTER);
		jTextViewTitleControl.setText(title);
		linearLayoutLeft.addView(jTextViewTitleControl);
		linearLayout.addView(linearLayoutLeft);
		LinearLayout linearLayoutRight = new LinearLayout(
				getApplicationContext());
		linearLayoutRight.setGravity(Gravity.RIGHT | Gravity.CENTER);
		linearLayoutRight.setLayoutParams(layoutParamsColumn);
		ImageView imageView = new ImageView(getApplicationContext());
		imageView.setImageResource(id);
		linearLayoutRight.addView(imageView);
		linearLayout.addView(linearLayoutRight);
		return linearLayout;
	}

	/**
	 * 
	 * @param title
	 * @param id
	 * @return
	 */
	public LinearLayout getTitleViewRightBorder(String title, int id) {
		LinearLayout linearLayout = new LinearLayout(getApplicationContext()) {
			final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
			final int color[] = { 0xFF666666, 0xFF666666, 0xFF666666 };

			@Override
			protected void onDraw(Canvas canvas) {
				super.onDraw(canvas);
				for (int i = 0; i < 1; i++) {
					paint.setColor(color[i]); // color.RED
					canvas.drawLine(getScreenWidth() / 2 - i, 0,
							getScreenWidth() / 2 - i, canvas.getHeight(), paint);
				}
			}
		};
		linearLayout
				.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		linearLayout.setPadding(5, 5, 5, 5);
		linearLayout.setOrientation(LinearLayout.HORIZONTAL);
		linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, Utils.convertDips2Pixel(
						45, getApplicationContext())));
		linearLayout.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.title_bar));
		LinearLayout.LayoutParams layoutParamsColumn = new LinearLayout.LayoutParams(
				TableRow.LayoutParams.FILL_PARENT,
				TableRow.LayoutParams.FILL_PARENT, 1);
		LinearLayout linearLayoutLeft = new LinearLayout(
				getApplicationContext());
		linearLayoutLeft.setGravity(Gravity.LEFT | Gravity.CENTER);
		linearLayoutLeft.setLayoutParams(layoutParamsColumn);
		JTextView jTextViewTitleControl = new JTextView(getApplicationContext());
		jTextViewTitleControl.setTextColor(0xFF000000);
		jTextViewTitleControl.setModeSubTitle(getApplicationContext());
		jTextViewTitleControl.setGravity(Gravity.CENTER);
		jTextViewTitleControl.setText(title);
		linearLayoutLeft.addView(jTextViewTitleControl);
		linearLayout.addView(linearLayoutLeft);
		LinearLayout linearLayoutRight = new LinearLayout(
				getApplicationContext());
		linearLayoutRight.setGravity(Gravity.RIGHT | Gravity.CENTER);
		linearLayoutRight.setLayoutParams(layoutParamsColumn);
		ImageView imageView = new ImageView(getApplicationContext());
		imageView.setImageResource(id);
		linearLayoutRight.addView(imageView);
		linearLayout.addView(linearLayoutRight);
		return linearLayout;
	}

	@Override
	public void onACMainsPowerOutletBack(CEndPoint ep,
			MainsPowerOutletAttr attr, int value) {
		Message msg = programHandle.obtainMessage();
		msg.arg1 = value;
		if (attr == MainsPowerOutletAttr.Status) {
			msg.what = 0x0001;
		}
		Log.w("Data", "" + msg.arg1);
		programHandle.sendMessage(msg);
	}

	private Handler programHandle = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 0x0001: {
				rightControl.setSelect(0, msg.arg1 == 0 ? false : true);

				break;
			}
			case 0x0002: {
				TemperatureSensorAttr attr = (TemperatureSensorAttr) msg.obj;
				if (attr == TemperatureSensorAttr.Temperature) {
					float temp = msg.arg1 / 10000.0f;
					temperatureLl.updateData(temp, 0);
				}
				if (attr == TemperatureSensorAttr.Humidity) {
					temperatureLl.updateData(0, msg.arg1 / 10000.0f);
				}

				break;
			}
			}
		}

	};

	@Override
	public void onZBAttrChange(CZBNode node, NodeAttr attr, String value) {
		// TODO Auto-generated method stub
		// CZBNode dev = null;
		// for (CZBNode n : arrayDev) {
		// if (n.m_ZBNodeAttr.IEEE.equals(node.m_ZBNodeAttr.IEEE)) {
		// dev = n;
		//
		// }
		// }
		//
		// if (attr == NodeAttr.ModelIdentify) {
		// dev.m_ZBNodeAttr.ModelID = value;
		// Message msg = searchHandle.obtainMessage();
		// msg.what = 0x0003;
		// searchHandle.sendMessage(msg);
		// }
		// if (attr == NodeAttr.TYPE) {
		// if (dev == null || dev.m_ZBNodeAttr == null)
		// return;
		// dev.m_ZBNodeAttr.enumRtDeviceTypeEndPoType = RtDeviceType
		// .getRtDeviceTypeByValue(Integer.parseInt(value));
		// Message msg = searchHandle.obtainMessage();
		// msg.what = 0x0003;
		// searchHandle.sendMessage(msg);
		// }
	}

	@Override
	public void onCreateNewZBNodeBack(CZBNode arg) {
		// TODO Auto-generated method stub
		// int size = arrayDev.size();
		// Log.e("msg model:", arg.m_ZBNodeAttr.ModelID);
		// boolean isExist = false;
		// for (int i = 0; i < size; i++) {
		// CZBNode node = arrayDev.get(i);
		// if (node.m_ZBNodeAttr.IEEE.equals(arg.m_ZBNodeAttr.IEEE)) {
		// isExist = true;
		// }
		// }
		// if (!isExist) {
		// arrayDev.add(arg);
		// Message msg = searchHandle.obtainMessage();
		// msg.what = 0x0003;
		// searchHandle.sendMessage(msg);
		// }
	}

	@Override
	public void onSearchProgressChange(int progress) {
		// TODO Auto-generated method stub
		// Message msg = searchHandle.obtainMessage();
		// if (progress == 100) {
		// msg.what = 0x0001;
		// } else {
		// msg.what = 0x0002;
		// msg.arg1 = progress;
		// }
		// searchHandle.sendMessage(msg);
		// msg = null;
	}

	// binding each device for each button
	// public void InitData() {
	// try {
	// endPointSwitch = new ArrayList<CEndPoint>();
	// for (int i = 0; i < arrayDev.size(); i++) {
	// ArrayList<CEndPoint> temp = null;
	// CZBNode node = API.ZBGetZBNodeByIndex(arrayDev.get(i).index);
	// temp = API.ZBGetendPointSwitchByIEEE(node.m_ZBNodeAttr.IEEE);
	// if (temp != null && temp.size() > 0) {
	// String id = temp.get(0).m_EPAttr.DeviceID;
	// if (id.equalsIgnoreCase(Constant.SWITCH)) {
	// endPointSwitch.add(temp.get(0));
	// } else if (id.equalsIgnoreCase(Constant.TMSENSOR)) {
	// endPointSwitchThSensor = temp;
	// }
	// }
	// }
	// } catch (Exception e) {
	// }
	// }

	// private Handler searchHandle = new Handler() {
	// @Override
	// public void handleMessage(Message msg) {
	// switch (msg.what) {
	// case 0x0001: {
	// dialog.dismiss();
	// break;
	// }
	// case 0x0002: {
	// dialog.setMessage("Search devices : " + msg.arg1 + "%");
	// break;
	// }
	// case 0x0003: {
	// // InitData();
	// break;
	// }
	// }
	// }
	//
	// };

	public void RefreshData() {
		// try {
		// DeviceListTask task = new DeviceListTask(MainActivity.this);
		// task.execute(0);
		// } catch (Exception e) {
		// // TODO: handle exception
		// }
		//
	}

	@Override
	public void onSelect(int id, boolean status) {
		// TODO Auto-generated method stub
		switch (id) {
		case 0:
			if (Application.isInitialize && DeviceManager.endPointSwitch != null) {
				if (status) {
					API.ZBCLUSTEROnOffToggle(DeviceManager.endPointSwitch.get(0), 0);
				} else {
					API.ZBCLUSTEROnOffToggle(DeviceManager.endPointSwitch.get(0), 1);
				}
			} else {
				Toast.makeText(this, "Initialize SDK failed!Please try again!",
						0).show();
			}

			break;
		case 1:
			if (Application.isInitialize && DeviceManager.endPointSwitch != null
					&& DeviceManager.endPointSwitch.size() >= 2) {
				if (status) {
					API.ZBCLUSTEROnOffToggle(DeviceManager.endPointSwitch.get(1), 0);
				} else {
					API.ZBCLUSTEROnOffToggle(DeviceManager.endPointSwitch.get(1), 1);
				}
			} else {
				Toast.makeText(this, "Initialize SDK failed!Please try again!",
						0).show();
			}
			break;
		default:
			break;
		}
	}

	@Override
	public void onACTemperatureSensorBack(CEndPoint arg0,
			TemperatureSensorAttr arg1, int arg2) {
		Message msg = programHandle.obtainMessage();
		msg.obj = arg1;
		msg.arg1 = arg2;
		msg.what = 0x0002;
		programHandle.sendMessage(msg);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		unInitialize();
		finish();
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

	@Override
	public void onSecuritySelect(int id, boolean status) {
		// TODO Auto-generated method stub
		switch (id) {
		case 0:
			if (Application.isInitialize && DeviceManager.endPointSwitch != null
					&& DeviceManager.endPointSwitch.size() >= 3) {
				if (status) {
					API.ZBCLUSTEROnOffToggle(DeviceManager.endPointSwitch.get(2), 0);
				} else {
					API.ZBCLUSTEROnOffToggle(DeviceManager.endPointSwitch.get(2), 1);
				}
			} else {
				Toast.makeText(this, "Initialize SDK failed!Please try again!",
						0).show();
			}

			break;
		case 1:
			if (Application.isInitialize && DeviceManager.endPointSwitch != null
					&& DeviceManager.endPointSwitch.size() >= 4) {
				if (status) {
					API.ZBCLUSTEROnOffToggle(DeviceManager.endPointSwitch.get(3), 0);
				} else {
					API.ZBCLUSTEROnOffToggle(DeviceManager.endPointSwitch.get(3), 1);
				}
			} else {
				Toast.makeText(this, "Initialize SDK failed!Please try again!",
						0).show();
			}
			break;
		case 2:
			if (Application.isInitialize && DeviceManager.endPointSwitch != null
					&& DeviceManager.endPointSwitch.size() >= 5) {
				if (status) {
					API.ZBCLUSTEROnOffToggle(DeviceManager.endPointSwitch.get(4), 0);
				} else {
					API.ZBCLUSTEROnOffToggle(DeviceManager.endPointSwitch.get(4), 1);
				}
			} else {
				// Toast.makeText(this, "Comming soon!",
				// 0).show();
			}
			break;
		default:
			break;
		}
	}

}