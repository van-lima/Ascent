package com.ascentcomtec.smarthouse.ui.components;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.ascentcomtec.smarthouse.MainActivity;
import com.ascentcomtec.smarthouse.R;
import com.ascentcomtec.smarthouse.ui.components.button.JButton;


public abstract class HAFormFactory extends FormFactory{

	protected ActionBar actionBar;
	
	@Override
	public void execute() {
	    actionBar = new ActionBar(this);
 		JButton buttonBack = new JButton(getApplicationContext());
 		buttonBack.setBackgroundDrawable(getResources().getDrawable(R.drawable.back));
     	buttonBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View paramView) {
				 finish();
			}
		});
		RelativeLayout.LayoutParams layoutParamsButtonBack =  new RelativeLayout.LayoutParams(60, 40);//LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutParamsButtonBack.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
		layoutParamsButtonBack.addRule(RelativeLayout.CENTER_IN_PARENT,RelativeLayout.TRUE);
   		actionBar.addControlActionBarLeft(buttonBack, layoutParamsButtonBack);
   		
//   		
//		LinearLayout menuBarControl = new LinearLayout(getApplicationContext());
//		menuBarControl.setGravity(Gravity.CENTER);
//		ImageView imageViewHelp = new ImageView(getApplicationContext());
//		imageViewHelp.setPadding(10, 0, 10, 0);
//  		imageViewHelp.setImageResource(R.drawable.help);
//  		imageViewHelp.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				showAlertDialog("Coming Soon !");
//			}
//		});
// 		menuBarControl.addView(imageViewHelp);
// 		ImageView imageViewSetting = new ImageView(getApplicationContext());
// 		imageViewSetting.setPadding(10, 0, 10, 0);
//  		imageViewSetting.setImageResource(R.drawable.setting);
//  		imageViewSetting.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				showAlertDialog("Coming Soon !");
// 			}
//		});
// 		menuBarControl.addView(imageViewSetting);
// 		ImageView imageViewHome = new ImageView(getApplicationContext());
// 		imageViewHome.setPadding(10, 0, 10, 0);
//  		imageViewHome.setImageResource(R.drawable.home);
//  		menuBarControl.addView(imageViewHome);
// 		imageViewHome.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				 Intent intentYWCAHome = new Intent(HAFormFactory.this, MainActivity.class);
//				 intentYWCAHome.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//				 startActivity(intentYWCAHome);
//			}
//		});
// 		actionBar.addControlActionBarNext(menuBarControl);
 		getTitleArea().addView(actionBar);
		executeUI();
	}
	/***
	 * 
	 */
	public void setTitle(String title){
		actionBar.setText(title);
	}
	
    /**
     * The should place its UI into the given form 
     */
	public abstract void executeUI();
	
}
