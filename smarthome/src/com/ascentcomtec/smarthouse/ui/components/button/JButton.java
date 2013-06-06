package com.ascentcomtec.smarthouse.ui.components.button;

import android.content.Context;
import android.widget.Button;

import com.ascentcomtec.smarthouse.ui.components.Media;
/***
 * 
 * @author longtq
 *
 */
public class JButton extends Button {
	 
	/***
	 * 
	 * @param context
	 */
	public JButton(Context context) {
		super(context);
	}
  
	@Override
	public boolean performClick() {
		Media.getMedia(getContext()).start();
 		return super.performClick();
	}
}

