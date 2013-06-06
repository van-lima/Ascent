package com.ascentcomtec.smarthouse;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ascentcomtec.smarthouse.ui.components.ActionBar;
import com.ascentcomtec.smarthouse.ui.components.FormFactory;
import com.ascentcomtec.smarthouse.ui.components.textview.JTextView;

public class SecurityMore extends FormFactory{

	 
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
				 Intent intent = new Intent(SecurityMore.this, MainActivity.class);
				 intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
				 startActivity(intent);
			}
		});
 		
 		ImageView imageViewSetting = new ImageView(getApplicationContext());
 		imageViewSetting.setLayoutParams(getLinearLayoutLayoutParams());
   		imageViewSetting.setImageResource(R.drawable.setting);
  		imageViewSetting.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Coming Soon !", Toast.LENGTH_LONG).show();
 			}
		});
 		menuBarControl.addView(imageViewSetting);
 		
		ImageView imageViewHelp = new ImageView(getApplicationContext());
		imageViewHelp.setLayoutParams(getLinearLayoutLayoutParams());
   		imageViewHelp.setImageResource(R.drawable.help);
  		imageViewHelp.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 Intent intentHelp = new Intent(SecurityMore.this, Help.class);
				 intentHelp.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
				 startActivity(intentHelp);
			}
		});
 		menuBarControl.addView(imageViewHelp);
 		
 		actionBar.addControlActionBarNext(menuBarControl);
 		getTitleArea().addView(actionBar);
 		
 		//root layout
 		LinearLayout linearLayoutRoot = new LinearLayout(getApplicationContext());
 		linearLayoutRoot.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
 		linearLayoutRoot.setGravity(Gravity.CENTER);
 		linearLayoutRoot.setOrientation(LinearLayout.VERTICAL);
 		getContentPane().setBackgroundDrawable(drawableBackgroundImage(getApplicationContext()));
 		getContentPane().addView(linearLayoutRoot);
 		
 		LinearLayout linearLayoutRowFirst = new  LinearLayout(getApplicationContext());
  		linearLayoutRowFirst.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, getContentPaneHeight()/2));
 		linearLayoutRowFirst.addView(new SecurityMoreRowFirst(getApplicationContext(), getScreenWidth(), getContentPaneHeight()/2));
 		linearLayoutRoot.addView(linearLayoutRowFirst);
 		
 		LinearLayout linearLayoutRowSecond = new  LinearLayout(getApplicationContext());
  		linearLayoutRowSecond.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, getContentPaneHeight()/2));
 		linearLayoutRowSecond.addView(new SecurityMoreRowSecond(getApplicationContext(), getScreenWidth(), getContentPaneHeight()/2));
 		linearLayoutRoot.addView(linearLayoutRowSecond);
 		
 		LinearLayout linearLayoutMenuBar = new LinearLayout(getApplicationContext());
 		linearLayoutMenuBar.setGravity(Gravity.CENTER);
 		linearLayoutMenuBar.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
 		JTextView jTextView = new JTextView(getApplicationContext());
 		jTextView.setGravity(Gravity.CENTER);
 		jTextView.setText("Powered by IP LIMA");
 		linearLayoutMenuBar.addView(jTextView);
 		getMenuBar().addView(linearLayoutMenuBar);
	}
	/**
	 * return drawable image,id of image config in class Constant
	 * @param context
	 * @return
	 */
	public Drawable drawableBackgroundImage(Context context){
//		Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.background);
//	    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
//	    bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
//	    return bitmapDrawable;
		return new ColorDrawable(0xFFb9c2c6);
	}
}
