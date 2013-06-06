package com.ascentcomtec.smarthouse;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ascentcomtec.smarthouse.ui.components.Space;
import com.ascentcomtec.smarthouse.ui.components.button.JToggleButton;

public class ViewComponentAir extends LinearLayout{
	
	public ViewComponentAir(Context context) {
		super(context);
	}

	public ViewComponentAir(Context context, int width, int height, int state_pressed, int state_enabled) {
		super(context);
		setPadding(5, 5, 5, 5);
		height = height/ 2;
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
		addView(new UpDownControl(getContext(), (width - height - 25)/2, height));
		Space spaceOne = new Space(getContext());
		spaceOne.setWidthMeasureSpec(5);
		addView(spaceOne);
		addView(new UpDownControls(getContext(), (width - height - 25)/2, height));
		Space spaceTwo = new Space(getContext());
		spaceTwo.setWidthMeasureSpec(5);
		addView(spaceTwo);
 	}
}
