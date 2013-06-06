package com.ascentcomtec.smarthouse.ui.portlets.control;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableRow;

import com.ascentcomtec.smarthouse.R;
import com.ascentcomtec.smarthouse.ui.components.HAFormFactory;
import com.ascentcomtec.smarthouse.ui.components.textview.JTextView;
import com.ascentcomtec.smarthouse.utils.Utils;
import com.resolutiondev.ui.drawable.JDrawable;

public class Cameras extends HAFormFactory{

	@Override
	public void executeUI() {
		setTitle("Cameras");
		
		LinearLayout linearLayoutRoot = new LinearLayout(getApplicationContext());
		linearLayoutRoot.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
		linearLayoutRoot.setOrientation(LinearLayout.HORIZONTAL);
		
		linearLayoutRoot.addView(getView("Camera One"));
		
		linearLayoutRoot.addView(getView("Door Intercom"));
		
 		RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
  		relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT));
 		relativeLayout.setBackgroundDrawable(new ColorDrawable(Color.GREEN));
		relativeLayout.addView(linearLayoutRoot);
		ScrollView scrollView = new ScrollView(getApplicationContext());
		scrollView.addView(relativeLayout);
  		getContentPane().addView(scrollView);
	}
	/***
	 * 
	 * @param titleView
	 * @return
	 */
	private LinearLayout getView(String titleView){
		LinearLayout linearLayout = new LinearLayout(getApplicationContext());
		linearLayout.setLayoutParams(new LinearLayout.LayoutParams(new LinearLayout.LayoutParams(400, 400)));
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		linearLayout.addView(getTitleView(titleView, R.drawable.detail));
		LinearLayout cameraOne = new LinearLayout(getApplicationContext());
		cameraOne.setGravity(Gravity.CENTER);
		cameraOne.setLayoutParams(new LinearLayout.LayoutParams(400, 354));
		cameraOne.setBackgroundDrawable(JDrawable.getJDrawable()
				.drawRoundRect(new float[] { 0, 0, 0, 0, 0, 0, 0, 0 }, 3, Color.BLACK));
		ImageView imageView = new ImageView(getApplicationContext());
		imageView.setImageResource(R.drawable.camera_icon);
		cameraOne.addView(imageView);
		linearLayout.addView(cameraOne);
		return linearLayout;
 	}
	
	/***
	 * 
	 * @return
	 */
	private LinearLayout getTitleView(String title, int id) {
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
}
