package com.ascentcomtec.smarthouse.ui.portlets.settings;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.ascentcomtec.smarthouse.R;
import com.ascentcomtec.smarthouse.activities.setting.devicemanager.DeviceManager;
import com.ascentcomtec.smarthouse.activities.setting.usermanager.UserManager;
import com.ascentcomtec.smarthouse.activities.setting.utilitymanager.UtilityManager;
import com.ascentcomtec.smarthouse.ui.activities.AbstractActivity;
import com.ascentcomtec.smarthouse.ui.components.Font;
import com.ascentcomtec.smarthouse.ui.components.HAFormFactory;
import com.ascentcomtec.smarthouse.ui.components.Network;
import com.ascentcomtec.smarthouse.ui.components.button.JButton;
import com.ascentcomtec.smarthouse.ui.components.textview.JTextView;
import com.ascentcomtec.smarthouse.ui.plaf.Style;
import com.ascentcomtec.smarthouse.ui.portlets.control.DeviceLinks;

public class Setting extends HAFormFactory implements OnClickListener {
	
	private JButton jButtonDeviceManage;
	private JButton jButtonUserManage;
	private JButton jButtonUtilityManage;
	private JButton jButtonDeviceLinks;
	private JButton jButtonNetwork;

	@Override
	public void executeUI() {
		setTitle("Setting");
		 
		LinearLayout linearLayoutRoot = new LinearLayout(getApplicationContext());
		linearLayoutRoot.setLayoutParams(getLinearLayoutLayoutParams());
		linearLayoutRoot.setOrientation(LinearLayout.VERTICAL);
		
		LinearLayout linearLayoutFirst = new LinearLayout(getApplicationContext());
 		linearLayoutFirst.setGravity(Gravity.CENTER);
		linearLayoutFirst.setOrientation(LinearLayout.HORIZONTAL);
		linearLayoutFirst.setLayoutParams(new LinearLayout.LayoutParams(getWidth(), getContentPaneHeight()/3));
		
		LinearLayout.LayoutParams layoutParamsLable = new LinearLayout.LayoutParams(getContentPaneHeight()/3, 36);
		LinearLayout.LayoutParams layoutParamsControl = new LinearLayout.LayoutParams(getContentPaneHeight()/3 - 48, getContentPaneHeight()/3 - 48);
		
		LinearLayout linearLayoutDeviceManage = new LinearLayout(getApplicationContext());
		linearLayoutDeviceManage.setGravity(Gravity.CENTER);
		linearLayoutDeviceManage.setLayoutParams(new LinearLayout.LayoutParams(getWidth()/5, getContentPaneHeight()/3));
		linearLayoutDeviceManage.setOrientation(LinearLayout.VERTICAL);
		jButtonDeviceManage = new JButton(getApplicationContext());
		jButtonDeviceManage.setOnClickListener(this);
		jButtonDeviceManage.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_device_manage));
		jButtonDeviceManage.setLayoutParams(layoutParamsControl);
		linearLayoutDeviceManage.addView(jButtonDeviceManage);
		JTextView jTextViewDeviceManage = new JTextView(getApplicationContext());
		jTextViewDeviceManage.setGravity(Gravity.CENTER);
		jTextViewDeviceManage.setLayoutParams(layoutParamsLable);
		jTextViewDeviceManage.setBackgroundDrawable(getResources().getDrawable(R.drawable.lable_bg));
		jTextViewDeviceManage.setText("Device Manage");
		linearLayoutDeviceManage.addView(jTextViewDeviceManage);
 		linearLayoutFirst.addView(linearLayoutDeviceManage);
		
		LinearLayout linearLayoutUserManage = new LinearLayout(getApplicationContext());
		linearLayoutUserManage.setGravity(Gravity.CENTER);
		linearLayoutUserManage.setLayoutParams(new LinearLayout.LayoutParams(getWidth()/5, getContentPaneHeight()/3));
		linearLayoutUserManage.setOrientation(LinearLayout.VERTICAL);
		jButtonUserManage = new JButton(getApplicationContext());
		jButtonUserManage.setOnClickListener(this);
 		jButtonUserManage.setLayoutParams(layoutParamsControl);
		jButtonUserManage.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_user_manage));
		linearLayoutUserManage.addView(jButtonUserManage);
		JTextView jTextViewUserManage = new JTextView(getApplicationContext());
		jTextViewUserManage.setGravity(Gravity.CENTER);
		jTextViewUserManage.setLayoutParams(layoutParamsLable);
		jTextViewUserManage.setBackgroundDrawable(getResources().getDrawable(R.drawable.lable_bg));
		jTextViewUserManage.setText("User Manage");
		linearLayoutUserManage.addView(jTextViewUserManage);
		linearLayoutFirst.addView(linearLayoutUserManage);
		
		LinearLayout linearLayoutUtilityManage = new LinearLayout(getApplicationContext());
		linearLayoutUtilityManage.setGravity(Gravity.CENTER);
		linearLayoutUtilityManage.setLayoutParams(new LinearLayout.LayoutParams(getWidth()/5, getContentPaneHeight()/3));
		linearLayoutUtilityManage.setOrientation(LinearLayout.VERTICAL);
		jButtonUtilityManage = new JButton(getApplicationContext());
		jButtonUtilityManage.setOnClickListener(this);
 		jButtonUtilityManage.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_utility_manage));
		jButtonUtilityManage.setLayoutParams(layoutParamsControl);
		linearLayoutUtilityManage.addView(jButtonUtilityManage);
		JTextView jTextViewUtilityManage = new JTextView(getApplicationContext());
		jTextViewUtilityManage.setGravity(Gravity.CENTER);
		jTextViewUtilityManage.setLayoutParams(layoutParamsLable);
		jTextViewUtilityManage.setBackgroundDrawable(getResources().getDrawable(R.drawable.lable_bg));
		jTextViewUtilityManage.setText("Utility Manage");
		linearLayoutUtilityManage.addView(jTextViewUtilityManage);
		linearLayoutFirst.addView(linearLayoutUtilityManage);
		
		LinearLayout linearLayoutDeviceLinks = new LinearLayout(getApplicationContext());
		linearLayoutDeviceLinks.setGravity(Gravity.CENTER);
		linearLayoutDeviceLinks.setLayoutParams(new LinearLayout.LayoutParams(getWidth()/5, getContentPaneHeight()/3));
		linearLayoutDeviceLinks.setOrientation(LinearLayout.VERTICAL);
		jButtonDeviceLinks = new JButton(getApplicationContext());
		jButtonDeviceLinks.setOnClickListener(this);
 		jButtonDeviceLinks.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_device_links));
		jButtonDeviceLinks.setLayoutParams(layoutParamsControl);
		linearLayoutDeviceLinks.addView(jButtonDeviceLinks);
		JTextView jTextViewDeviceLinks = new JTextView(getApplicationContext());
		jTextViewDeviceLinks.setGravity(Gravity.CENTER);
		jTextViewDeviceLinks.setLayoutParams(layoutParamsLable);
		jTextViewDeviceLinks.setBackgroundDrawable(getResources().getDrawable(R.drawable.lable_bg));
		jTextViewDeviceLinks.setText("Device Links");
		linearLayoutDeviceLinks.addView(jTextViewDeviceLinks);
		linearLayoutFirst.addView(linearLayoutDeviceLinks);
		
		LinearLayout linearLayoutNetwork = new LinearLayout(getApplicationContext());
		linearLayoutNetwork.setGravity(Gravity.CENTER);
		linearLayoutNetwork.setLayoutParams(new LinearLayout.LayoutParams(getWidth()/5, getContentPaneHeight()/3));
		linearLayoutNetwork.setOrientation(LinearLayout.VERTICAL);
		jButtonNetwork = new JButton(getApplicationContext());
		jButtonNetwork.setOnClickListener(this);
		jButtonNetwork.setLayoutParams(getLinearLayoutLayoutParam());
		jButtonNetwork.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_network));
		jButtonNetwork.setLayoutParams(layoutParamsControl);
		linearLayoutNetwork.addView(jButtonNetwork);
		JTextView jTextViewNetwork = new JTextView(getApplicationContext());
		jTextViewNetwork.setGravity(Gravity.CENTER);
		jTextViewNetwork.setLayoutParams(layoutParamsLable);
		jTextViewNetwork.setBackgroundDrawable(getResources().getDrawable(R.drawable.lable_bg));
		jTextViewNetwork.setText("Network");
		linearLayoutNetwork.addView(jTextViewNetwork);
		linearLayoutFirst.addView(linearLayoutNetwork);
		linearLayoutRoot.addView(linearLayoutFirst);
		
		LinearLayout linearLayoutSecond = new LinearLayout(getApplicationContext());
		linearLayoutSecond.setGravity(Gravity.LEFT);
		linearLayoutSecond.setOrientation(LinearLayout.VERTICAL);
		linearLayoutSecond.setLayoutParams(new LinearLayout.LayoutParams(getWidth(), getContentPaneHeight()/3));
		linearLayoutRoot.addView(linearLayoutSecond);
		LinearLayout linearLayoutTitle = new LinearLayout(getApplicationContext());
		linearLayoutTitle.setLayoutParams(new LinearLayout.LayoutParams(getWidth(), 40));
		linearLayoutTitle.setGravity(Gravity.LEFT | Gravity.CENTER);
		linearLayoutTitle.setOrientation(LinearLayout.HORIZONTAL);
		linearLayoutTitle.setBackgroundDrawable(getResources().getDrawable(R.drawable.title_bg));
  		linearLayoutTitle.addView(getLableTitle("Screen Active Time"));
  		linearLayoutSecond.addView(linearLayoutTitle);
  		linearLayoutSecond.addView(getLable("How long terminal screen stay on for last action"));
 		LinearLayout linearLayoutThird = new LinearLayout(getApplicationContext());
		linearLayoutThird.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
		linearLayoutThird.setGravity(Gravity.CENTER);
		linearLayoutThird.setOrientation(LinearLayout.HORIZONTAL);
		linearLayoutThird.setPadding(10, 2, 10, 2);
		linearLayoutSecond.addView(linearLayoutThird);
 		String[] lable = new String[]{"1 Min","2 Min","5 Min","10 Min","30 Min","1 Hour"};
 		for(int i = 0; i < lable.length; i++){
 			JButton jButton = new JButton(getApplicationContext());
 			jButton.setLayoutParams(new LinearLayout.LayoutParams((getWidth()/6 - 20), 40));
 			jButton.setText(lable[i]);
 			jButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.min_bg));
 			linearLayoutThird.addView(jButton);
 		}
 		
		LinearLayout linearLayoutFourth = new LinearLayout(getApplicationContext());
		linearLayoutFourth.setLayoutParams(new LinearLayout.LayoutParams(getWidth(), getContentPaneHeight()/3));
		linearLayoutFourth.setGravity(Gravity.LEFT);
		linearLayoutFourth.setOrientation(LinearLayout.VERTICAL);  		
		LinearLayout linearLayoutTitles = new LinearLayout(getApplicationContext());
		linearLayoutTitles.setLayoutParams(new LinearLayout.LayoutParams(getWidth(), 40));
		linearLayoutTitles.setGravity(Gravity.LEFT | Gravity.CENTER);
		linearLayoutTitles.setOrientation(LinearLayout.HORIZONTAL);
		linearLayoutTitles.setBackgroundDrawable(getResources().getDrawable(R.drawable.title_bg));
		linearLayoutTitles.addView(getLableTitle("Screen Return Home Time"));
		linearLayoutFourth.addView(linearLayoutTitles);
  		linearLayoutFourth.addView(getLable("How long terminal screen stays on selected screen before returnning to home screen"));
 		LinearLayout linearLayoutFifth = new LinearLayout(getApplicationContext());
 		linearLayoutFifth.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
		linearLayoutFifth.setGravity(Gravity.CENTER);
		linearLayoutFifth.setOrientation(LinearLayout.HORIZONTAL);
		linearLayoutFifth.setPadding(10, 2, 10, 2);
		linearLayoutFourth.addView(linearLayoutFifth);
 		String[] lableHowLongTerminal = new String[]{"15 Sec","30 Sec","1 Min","2 Min","5 Min","10 Min"};
 		for(int i = 0; i < lableHowLongTerminal.length; i++){
 			JButton jButton = new JButton(getApplicationContext());
 			jButton.setLayoutParams(new LinearLayout.LayoutParams(getWidth()/6 - 20, 40));
 			jButton.setText(lableHowLongTerminal[i]);
 			jButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.min_bg));
 			linearLayoutFifth.addView(jButton);
 		}
 		linearLayoutRoot.addView(linearLayoutFourth);
//		LinearLayout linearLayoutSixth = new LinearLayout(getApplicationContext());
//		linearLayoutSixth.setLayoutParams(getLinearLayoutLayoutParam());
//		linearLayoutSixth.setGravity(Gravity.LEFT);
//		linearLayoutSixth.setOrientation(LinearLayout.VERTICAL);
//		linearLayoutSixth.addView(getLable("Select Temperature Display"));
//		linearLayoutSixth.addView(getLable("Select which temperature to display on Home screen"));
// 		linearLayoutRoot.addView(linearLayoutSixth);
//		LinearLayout linearLayoutSeventh = new LinearLayout(getApplicationContext());
//		linearLayoutSeventh.setLayoutParams(getLinearLayoutLayoutParam());
//		linearLayoutSeventh.setGravity(Gravity.LEFT);
//		linearLayoutSeventh.setOrientation(LinearLayout.VERTICAL);
//		linearLayoutSeventh.setBackgroundDrawable(JDrawable.getJDrawable()
//				.drawRoundRect(new float[] { 12, 12, 12, 12, 12, 12, 12, 12 }, 3, Color.BLACK));
// 		String[] roomName = new String[]{"Room One","Room Two","Room Three"};
// 		for(int i = 0; i < roomName.length; i++){
// 			CheckBox checkBox = new CheckBox(getApplicationContext());
// 			checkBox.setText(roomName[i]);
// 			checkBox.setTextColor(Color.BLACK);
// 			linearLayoutSeventh.addView(checkBox);
// 		}
// 		linearLayoutRoot.addView(linearLayoutSeventh);
// 		JButton jButtonReset = new JButton(getApplicationContext());
// 		jButtonReset.setLayoutParams(getLinearLayoutLayoutParam());
// 		jButtonReset.setText("Reset System Data");
// 		linearLayoutRoot.addView(jButtonReset);
 		RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
 		relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT));
 		relativeLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.conten_bg));
		relativeLayout.addView(linearLayoutRoot);
		ScrollView scrollView = new ScrollView(getApplicationContext());
		scrollView.addView(relativeLayout);
  		getContentPane().addView(scrollView);
	}
	/***
	 * get layout params for screen title
	 * 
	 * @return
	 */
	public LinearLayout.LayoutParams getLinearLayoutLayoutParam() {
		Style style = new Style(getApplicationContext());
		style.setMargin(0, 0, 10, 10);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
		layoutParams.setMargins(style.getMarginValue(AbstractActivity.LEFT), style.getMarginValue(AbstractActivity.TOP), style.getMarginValue(AbstractActivity.RIGHT), style.getMarginValue(AbstractActivity.BOTTOM));
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
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
		layoutParams.setMargins(style.getMarginValue(AbstractActivity.LEFT), style.getMarginValue(AbstractActivity.TOP), style.getMarginValue(AbstractActivity.RIGHT), style.getMarginValue(AbstractActivity.BOTTOM));
		return layoutParams;
	}
	
	/***
	 * get layout params for screen title
	 * 
	 * @return
	 */
	public LinearLayout.LayoutParams getLinearLayoutLayoutParamss() {
		Style style = new Style(getApplicationContext());
		style.setMargin(10, 10, 10, 10);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(style.getMarginValue(AbstractActivity.LEFT), style.getMarginValue(AbstractActivity.TOP), style.getMarginValue(AbstractActivity.RIGHT), style.getMarginValue(AbstractActivity.BOTTOM));
		return layoutParams;
	}
	/***
	 * 
	 * @param lable
	 * @return
	 */
	private JTextView getLableTitle(String lable){
		JTextView jTextView = new JTextView(getApplicationContext());
		jTextView.setTextColor(0xFF000000);
		jTextView.setTypeface(Font.createSystemFont(getApplicationContext(), Font.FACE_UTMCENTUR, Font.STYLE_BOLD, Font.SIZE_LARGE));
		jTextView.setTextSize(Font.getSize());
		jTextView.setLayoutParams(getLinearLayoutLayoutParamss());
		jTextView.setGravity(Gravity.CENTER);
		jTextView.setText(lable);
		return jTextView;
	}
	/***
	 * 
	 * @param lable
	 * @return
	 */
	private JTextView getLable(String lable){
		JTextView jTextView = new JTextView(getApplicationContext());
		jTextView.setTextColor(0xFF000000);
		jTextView.setTypeface(Font.createSystemFont(getApplicationContext(), Font.FACE_UTMCENTUR, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
		jTextView.setTextSize(Font.getSize());
		jTextView.setLayoutParams(getLinearLayoutLayoutParamss());
		jTextView.setGravity(Gravity.CENTER);
		jTextView.setText(lable);
		return jTextView;
	}
	/***
	 * 	private JButton jButtonDeviceManage;
		private JButton jButtonUserManage;
		private JButton jButtonUtilityManage;
		private JButton jButtonDeviceLinks;
		private JButton jButtonNetwork;
	 */
	@Override
	public void onClick(View v) {
		 
		if(v == jButtonDeviceManage){
			Intent intent = new Intent(Setting.this, DeviceManager.class);
			startActivity(intent);
		}else if(v == jButtonUserManage){
			Intent intent = new Intent(Setting.this, UserManager.class);
			startActivity(intent);
		}else if(v == jButtonUtilityManage){
			Intent intent = new Intent(Setting.this, UtilityManager.class);
			startActivity(intent);
		}else if(v == jButtonDeviceLinks){
			Intent intent = new Intent(Setting.this, DeviceLinks.class);
			startActivity(intent);
		}else if(v == jButtonNetwork){
			Intent intent = new Intent(Setting.this, Network.class);
			startActivity(intent);
		}
	}
}