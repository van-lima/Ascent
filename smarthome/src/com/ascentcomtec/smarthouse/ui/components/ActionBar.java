/**
 * Copyright (c) 2012, SetaCinQ
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER
 */
package com.ascentcomtec.smarthouse.ui.components;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.ascentcomtec.smarthouse.R;
import com.ascentcomtec.smarthouse.ui.activities.AbstractActivity;
import com.ascentcomtec.smarthouse.ui.components.layout.JRelativeLayout;
import com.ascentcomtec.smarthouse.ui.components.textview.JTextView;
import com.ascentcomtec.smarthouse.ui.plaf.Style;
import com.ascentcomtec.smarthouse.utils.Utils;

public class ActionBar extends LinearLayout {
    
	private Context context;
	private JRelativeLayout menuBar;
	private JTextView jTextView;
	
 	public ActionBar(Context context) {
		super(context);
		this.context = context;
		Style style = new Style(context);
		style.setMargin(0, 0, 0, 0);
		style.setPadding(5, 5, 5, 5);
 		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, Utils.convertDips2Pixel(FormFactory.TITLE_AREA_HEIGHT, context));
		layoutParams.setMargins(style.getMarginValue(AbstractActivity.LEFT),
				style.getMarginValue(AbstractActivity.TOP),
				style.getMarginValue(AbstractActivity.RIGHT),
				style.getMarginValue(AbstractActivity.BOTTOM));
		setLayoutParams(layoutParams);
		setOrientation(LinearLayout.HORIZONTAL);
		

		// +++++++++++++ TOP COMPONENT: the header
		menuBar = new JRelativeLayout(getContext());
		menuBar.setBackgroundResource(R.drawable.top_background);
		menuBar.setPadding(style.getPaddingValue(AbstractActivity.LEFT),
				style.getPaddingValue(AbstractActivity.TOP),
				style.getPaddingValue(AbstractActivity.RIGHT),
				style.getPaddingValue(AbstractActivity.BOTTOM));
      	RelativeLayout.LayoutParams topParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, Utils.convertDips2Pixel(FormFactory.TITLE_AREA_HEIGHT, context));
     	topParams.addRule(RelativeLayout.ALIGN_PARENT_TOP,RelativeLayout.TRUE);
     	addView(menuBar,topParams);
     	
		RelativeLayout.LayoutParams layoutParamsTitleView = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		layoutParamsTitleView.addRule(RelativeLayout.CENTER_IN_PARENT,RelativeLayout.TRUE);
		jTextView = new JTextView(context);
		jTextView.setGravity(Gravity.CENTER);
 		menuBar.addView(jTextView, layoutParamsTitleView);
 	}
    /**
     * 
     * @param text
     */
	public final void setText(String text) {
		jTextView.setTypeface(Font.createSystemFont(context, Font.FACE_UTMCENTUR, Font.STYLE_BOLD, 21));
		jTextView.setTextSize(Font.getSize());
		jTextView.setTextColor(0xFF000000);
		jTextView.setText(text);
	}
    /**
     * 
     * @param text
     */
    public final void setText(CharSequence text) {
    	jTextView.setTypeface(Font.createSystemFont(context, Font.FACE_LOVEYALIKEASISTERSOLID, Font.STYLE_PLAIN, Font.SIZE_LARGE));
    	jTextView.setTextSize(Font.getSize());
    	jTextView.setTextColor(0xFF000000);
    	jTextView.setText(text);
    	jTextView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 //Intent intent = new Intent(context, AboutUs.class);
				 //context.startActivity(intent);
			}
		});
     }
 	/***
 	 * 
 	 * @param buttonBack
 	 */
 	public void addControlActionBarLeft(View view){
 		view.setId(0x1);
		RelativeLayout.LayoutParams layoutParamsButtonBack =  new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);//LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutParamsButtonBack.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
		layoutParamsButtonBack.addRule(RelativeLayout.CENTER_IN_PARENT,RelativeLayout.TRUE);
 		menuBar.addView(view, layoutParamsButtonBack);
 	}
 	/***
 	 * 
 	 * @param buttonBack
 	 */
 	public void addControlActionBarLeft(View view, RelativeLayout.LayoutParams layoutParamsButtonBack){
 		view.setId(0x1);
  		menuBar.addView(view, layoutParamsButtonBack);
 	}
 	/***
 	 * 
 	 * @param buttonNext
 	 */
 	public void addControlActionBarNext(View view){
 		view.setId(0x2);
		RelativeLayout.LayoutParams layoutParamsButtonNext =  new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);//LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutParamsButtonNext.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
		layoutParamsButtonNext.addRule(RelativeLayout.CENTER_IN_PARENT,RelativeLayout.TRUE);
 		menuBar.addView(view, layoutParamsButtonNext);
 	}
 	/***
 	 * 
 	 * @param button
 	 * @param layoutParams
 	 */
 	public void addControlActionBar(Button button,RelativeLayout.LayoutParams layoutParams){
 		menuBar.addView(button, layoutParams);
 	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		super.onLayout(changed, l, t, r, b);
	}
}
