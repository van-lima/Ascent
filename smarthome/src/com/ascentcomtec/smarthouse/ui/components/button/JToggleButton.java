/**
 * Copyright (c) 2012, SetaCinQ
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER
 */
package com.ascentcomtec.smarthouse.ui.components.button;

import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.ascentcomtec.smarthouse.ui.components.Media;
/**
 * Create by    : longtq
 * Project name : HappiestBaby
 * Package name : com.setacinq.happiestbaby.ui.components.button
 * File name    : JToggleButton.java
 * Create date  : Mar 12, 2012
 */
public class JToggleButton extends ToggleButton {
	
 	/***
	 * 
	 * @param context
	 */
	public JToggleButton(Context context) {
		super(context);
		setText(null);
		setTextOn(null);
		setTextOff(null);
		setChecked(false);
        setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getContext(), "Coming Soon !", Toast.LENGTH_LONG).show();
 			}
		});
	}
	/***
	 * 
	 * @param context
	 */
	public JToggleButton(Context context, int state_pressed, int state_enabled) {
		super(context);
		setText(null);
		setTextOn(null);
		setTextOff(null);
		StateListDrawable stateListDrawable = new StateListDrawable();
		stateListDrawable.addState(new int[] { android.R.attr.state_checked }, getResources().getDrawable(state_pressed));
		stateListDrawable.addState(new int[] { android.R.attr.state_enabled }, getResources().getDrawable(state_enabled));
		setBackgroundDrawable(stateListDrawable);
 	}
	
	 
	@Override
	public boolean performClick() {
		Media.getMedia(getContext()).start();
		return super.performClick();
	}
}
