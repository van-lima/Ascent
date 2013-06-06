package com.ascentcomtec.smarthouse.ui.portlets.control;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.ascentcomtec.smarthouse.R;
import com.ascentcomtec.smarthouse.ui.activities.AbstractActivity;
import com.ascentcomtec.smarthouse.ui.components.HAFormFactory;
import com.ascentcomtec.smarthouse.ui.components.button.JButton;
import com.ascentcomtec.smarthouse.ui.components.textview.JTextView;
import com.ascentcomtec.smarthouse.ui.plaf.Style;
import com.ascentcomtec.smarthouse.utils.Utils;
import com.resolutiondev.ui.drawable.JDrawable;

public class DeviceLinks extends HAFormFactory{

	@Override
	public void executeUI() {
		setTitle("Device Links");
		
		LinearLayout linearLayoutRoot = new LinearLayout(getApplicationContext());
		linearLayoutRoot.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
		linearLayoutRoot.setOrientation(LinearLayout.VERTICAL);
		for(int i = 0; i < 4; i++){
			LinearLayout linearLayout = new LinearLayout(getApplicationContext());
			linearLayout.setLayoutParams(getLinearLayoutLayoutParams());
			linearLayout.setOrientation(LinearLayout.HORIZONTAL);
			linearLayout.addView(module());
			View view = new View(getApplicationContext());
			view.setLayoutParams(new LinearLayout.LayoutParams(10, LinearLayout.LayoutParams.FILL_PARENT));
			linearLayout.addView(view);
			linearLayout.addView(module());
			linearLayoutRoot.addView(linearLayout);
		}
		
		RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
  		relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT));
		relativeLayout.addView(linearLayoutRoot);
		ScrollView scrollView = new ScrollView(getApplicationContext());
		scrollView.addView(relativeLayout);
  		getContentPane().addView(scrollView);
  		
		LinearLayout linearLayoutMenuBar = new LinearLayout(getApplicationContext());
		linearLayoutMenuBar.setBackgroundDrawable(JDrawable.getJDrawable().fillRoundRectRadialGradient(new int[]{ 0xFFDCDCDC, 0xFFDCDCDC, 0xFF9C9C9C, 0xFF9C9C9C }));
		linearLayoutMenuBar.setPadding(5, 5, 5, 5);
		linearLayoutMenuBar.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
		linearLayoutMenuBar.setOrientation(LinearLayout.HORIZONTAL);
		linearLayoutMenuBar.setGravity(Gravity.RIGHT | Gravity.CENTER);
		JButton jButtonAdd = new JButton(getApplicationContext());
		jButtonAdd.setLayoutParams(getLinearLayoutLayoutParam());
		jButtonAdd.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_add));
		linearLayoutMenuBar.addView(jButtonAdd);
		JButton jButtonEdit = new JButton(getApplicationContext());
		jButtonEdit.setLayoutParams(getLinearLayoutLayoutParam());
		jButtonEdit.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_edit));
		linearLayoutMenuBar.addView(jButtonEdit);
		JButton jButtonDelete = new JButton(getApplicationContext());
		jButtonDelete.setLayoutParams(getLinearLayoutLayoutParam());
		jButtonDelete.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_delete));
		linearLayoutMenuBar.addView(jButtonDelete);
		
		LinearLayout menuBar = new LinearLayout(this);
		menuBar.setGravity(Gravity.CENTER);
		menuBar.setOrientation(LinearLayout.VERTICAL);
		menuBar.setPadding(0, 0, 0, 0);
		menuBar.setId(0xFF13);
		menuBar.setBackgroundColor(0xFF777777);
		RelativeLayout.LayoutParams relativeLayoutParamsMenuBar = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, Utils.convertDips2Pixel(64, getApplicationContext()));
		relativeLayoutParamsMenuBar.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
		relativeLayoutParamsMenuBar.addRule(RelativeLayout.BELOW, 0xFF13);
 		menuBar.setLayoutParams(relativeLayoutParamsMenuBar);
 		menuBar.addView(linearLayoutMenuBar);
  		setMenuBar(menuBar);
	}
	/***
	 * get layout params for screen title
	 * 
	 * @return
	 */
	public LinearLayout.LayoutParams getLinearLayoutLayoutParam() {
		Style style = new Style(getApplicationContext());
		style.setMargin(0, 0, 10, 10);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(style.getMarginValue(AbstractActivity.LEFT), style.getMarginValue(AbstractActivity.TOP), style.getMarginValue(AbstractActivity.RIGHT), style.getMarginValue(AbstractActivity.BOTTOM));
		return layoutParams;
	}
	/**
	 * 
	 */
	public LinearLayout.LayoutParams getLinearLayoutLayoutParams() {
		Style style = new Style(getApplicationContext());
		style.setMargin(10, 10, 10, 10);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
		layoutParams.setMargins(style.getMarginValue(AbstractActivity.LEFT), style.getMarginValue(AbstractActivity.TOP), style.getMarginValue(AbstractActivity.RIGHT), style.getMarginValue(AbstractActivity.BOTTOM));
		return layoutParams;
	}
	/***
	 * 
	 * @return
	 */
	public LinearLayout module(){
		LinearLayout linearLayoutRoot = new LinearLayout(getApplicationContext());
		linearLayoutRoot.setPadding(10, 10, 10, 10);
		linearLayoutRoot.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutRoot.setOrientation(LinearLayout.HORIZONTAL);
		linearLayoutRoot.setBackgroundDrawable(JDrawable.getJDrawable()
				.drawRoundRect(new float[] { 10, 10, 10, 10, 10, 10, 10, 10 }, 3, Color.BLACK));
		LinearLayout linearLayoutLeft = new LinearLayout(getApplicationContext());
		linearLayoutLeft.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutLeft.setOrientation(LinearLayout.VERTICAL);
		linearLayoutLeft.setGravity(Gravity.CENTER);
		ImageView imageViewDeviceOne = new ImageView(getApplicationContext());
		imageViewDeviceOne.setLayoutParams(new LinearLayout.LayoutParams(120, 120));
		imageViewDeviceOne.setImageResource(R.drawable.light_on);
		linearLayoutLeft.addView(imageViewDeviceOne);
 		JTextView jTextViewStatus = new JTextView(getApplicationContext());
 		jTextViewStatus.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
 		jTextViewStatus.setTextColor(Color.BLACK);
 		jTextViewStatus.setText("ON");
 		linearLayoutLeft.addView(jTextViewStatus);
		JTextView jTextViewDeviceName = new JTextView(getApplicationContext());
		jTextViewDeviceName.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		jTextViewDeviceName.setText("Device Two");
		jTextViewDeviceName.setTextColor(Color.BLACK);
		linearLayoutLeft.addView(jTextViewDeviceName);
		linearLayoutRoot.addView(linearLayoutLeft);
		LinearLayout linearLayoutRight = new LinearLayout(getApplicationContext());
		linearLayoutRight.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutRight.setOrientation(LinearLayout.VERTICAL);
		linearLayoutRight.setGravity(Gravity.CENTER);
		ImageView imageViewDeviceOnes = new ImageView(getApplicationContext());
		imageViewDeviceOnes.setLayoutParams(new LinearLayout.LayoutParams(120, 120));
		imageViewDeviceOnes.setImageResource(R.drawable.printer_on);
		linearLayoutRight.addView(imageViewDeviceOnes);
 		JTextView jTextViewStatuss = new JTextView(getApplicationContext());
 		jTextViewStatuss.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
 		jTextViewStatuss.setTextColor(Color.BLACK);
 		jTextViewStatuss.setText("ON");
 		linearLayoutRight.addView(jTextViewStatuss);
		JTextView jTextViewDeviceNames = new JTextView(getApplicationContext());
		jTextViewDeviceNames.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		jTextViewDeviceNames.setTextColor(Color.BLACK);
		jTextViewDeviceNames.setText("Device Two");
		linearLayoutRight.addView(jTextViewDeviceNames);
 		linearLayoutRoot.addView(linearLayoutRight);
 		return linearLayoutRoot;
	}
}
