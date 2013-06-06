package com.ascentcomtec.smarthouse.ui.components.textview;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ascentcomtec.smarthouse.ui.components.Font;

public class JTextView extends TextView {

	public JTextView(Context context) {
		super(context);
		setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.FILL_PARENT));
		setTextColor(0xFFFFFFFF);
 		setTypeface(Font.createSystemFont(context, Font.FACE_UTMCENTUR, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
 		setTextSize(Font.getSize());
 	}
	/**
	 * 
	 * @param context
	 */
	public void setModeTitle(Context context){
 		setTypeface(Font.createSystemFont(context, Font.FACE_UTMCENTUR, Font.STYLE_BOLD, Font.SIZE_LARGE));
 		setTextSize(Font.getSize());
	}
	
	/**
	 * 
	 * @param context
	 */
	public void setModeSubTitle(Context context){
 		setTypeface(Font.createSystemFont(context, Font.FACE_UTMCENTUR, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
 		setTextSize(Font.getSize());
	}
}
