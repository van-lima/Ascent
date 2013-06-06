package com.ascentcomtec.smarthouse;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ascentcomtec.smarthouse.ui.activities.AbstractActivity;
import com.ascentcomtec.smarthouse.ui.components.Lines;
import com.ascentcomtec.smarthouse.ui.components.Space;
import com.ascentcomtec.smarthouse.ui.components.button.JToggleButton;
import com.ascentcomtec.smarthouse.ui.components.textview.JTextView;
import com.ascentcomtec.smarthouse.ui.plaf.Style;

public class ViewComponent extends LinearLayout{
	
	public ViewComponent(Context context) {
		super(context);
	}
    /**
     * 
     * @param context
     * @param height
     * @param state_pressed
     * @param state_enabled
     * @param no
     */
	public ViewComponent(Context context, int height, int state_pressed, int state_enabled, boolean no) {
		super(context);
		setPadding(5, 5, 5, 5);
		height = height/2;
		setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
		setOrientation(LinearLayout.HORIZONTAL);
		setGravity(Gravity.CENTER);
		JToggleButton jToggleButton = new JToggleButton(getContext(), state_pressed, state_enabled);
		jToggleButton.setLayoutParams(new LinearLayout.LayoutParams(height, height));
		addView(jToggleButton);
		jToggleButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getContext(), "Coming Soon !", Toast.LENGTH_LONG).show();
			}
		});
	}
	/**
	 * 
	 * @param context
	 * @param height
	 * @param state_pressed
	 * @param state_enabled
	 */
	public ViewComponent(Context context, int height, int state_pressed, int state_enabled) {
		super(context);
		setPadding(5, 5, 5, 5);
		height = height/2;
		setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
		setOrientation(LinearLayout.HORIZONTAL);
		setGravity(Gravity.CENTER);
		JToggleButton jToggleButton = new JToggleButton(getContext(), state_pressed, state_enabled);
		jToggleButton.setLayoutParams(new LinearLayout.LayoutParams(height, height));
		addView(jToggleButton);
		jToggleButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getContext(), "Coming Soon !", Toast.LENGTH_LONG).show();
			}
		});
		Space space = new Space(getContext());
		space.setWidthMeasureSpec(5);
		addView(space);
		addView(getLinearLayout(height));
	}
	
	private LinearLayout getLinearLayout(int height){
		LinearLayout linearLayout = new LinearLayout(getContext());
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, height));
		linearLayout.setBackgroundResource(R.drawable.electricity_background);
		LinearLayout linearLayoutLiveUse = getLinearLayout("10Kwh", height/2);
		linearLayout.addView(linearLayoutLiveUse);
		linearLayout.addView(new Lines(getContext()));
		LinearLayout linearLayoutCost = getLinearLayout("$10", height/2);
		linearLayout.addView(linearLayoutCost);
		return linearLayout;
	}
	/***
	 * 
	 * @param lable
	 * @param value
	 * @return
	 */
	public LinearLayout getLinearLayout(String value, int height){
		LinearLayout linearLayout = new LinearLayout(getContext());
		Style style = new Style(getContext());
		style.setMargin(0, 0, 5, 5);
		style.setPadding(5, 5, 5, 5);
 		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, height);
		layoutParams.setMargins(style.getMarginValue(AbstractActivity.LEFT),
				style.getMarginValue(AbstractActivity.TOP),
				style.getMarginValue(AbstractActivity.RIGHT),
				style.getMarginValue(AbstractActivity.BOTTOM));
		linearLayout.setLayoutParams(layoutParams);
		JTextView jTextViewValue = new JTextView(getContext());
		jTextViewValue.setTextColor(0xFFFFFFFF);
		jTextViewValue.setModeTitle(getContext());
		jTextViewValue.setGravity(Gravity.RIGHT | Gravity.CENTER);
		jTextViewValue.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, height, 1));
		jTextViewValue.setText(value);
		linearLayout.addView(jTextViewValue);
		return linearLayout;
	}
}
