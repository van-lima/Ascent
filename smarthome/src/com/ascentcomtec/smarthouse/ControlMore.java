package com.ascentcomtec.smarthouse;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.ascentcomtec.smarthouse.ui.components.HAFormFactory;
import com.ascentcomtec.smarthouse.ui.components.textview.JTextView;

public class ControlMore extends HAFormFactory{

	@Override
	public void executeUI() {
		setTitle("Control More");
 		//root layout
 		LinearLayout linearLayoutRoot = new LinearLayout(getApplicationContext());
 		linearLayoutRoot.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
 		linearLayoutRoot.setGravity(Gravity.CENTER);
 		linearLayoutRoot.setOrientation(LinearLayout.VERTICAL);
 		getContentPane().setBackgroundDrawable(drawableBackgroundImage(getApplicationContext()));
 		getContentPane().addView(linearLayoutRoot);
 		
 		LinearLayout linearLayoutRowFirst = new  LinearLayout(getApplicationContext());
  		linearLayoutRowFirst.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, getContentPaneHeight()/2));
 		linearLayoutRowFirst.addView(new ControlMoreRowFirst(getApplicationContext(), getScreenWidth(), getContentPaneHeight()/2));
 		linearLayoutRoot.addView(linearLayoutRowFirst);
 		
 		LinearLayout linearLayoutRowSecond = new  LinearLayout(getApplicationContext());
  		linearLayoutRowSecond.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, getContentPaneHeight()/2));
 		linearLayoutRowSecond.addView(new ControlMoreRowSecond(getApplicationContext(), getScreenWidth(), getContentPaneHeight()/2));
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
