package com.ascentcomtec.smarthouse.ui.portlets.control;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.ascentcomtec.smarthouse.ui.components.HAFormFactory;
import com.resolutiondev.ui.drawable.JDrawable;

public class DoorInterCom extends HAFormFactory{

	@Override
	public void executeUI() {
		setTitle("Door InterCom");
		LinearLayout linearLayoutRoot = new LinearLayout(getApplicationContext());
		linearLayoutRoot.setLayoutParams(new LinearLayout.LayoutParams(400, 400));

		linearLayoutRoot.setOrientation(LinearLayout.VERTICAL);
		linearLayoutRoot.setBackgroundDrawable(JDrawable.getJDrawable()
				.drawRoundRect(new float[] { 12, 12, 12, 12, 12, 12, 12, 12 }, 3, Color.BLACK));
		
 		RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
  		relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT));
 		relativeLayout.setBackgroundDrawable(new ColorDrawable(Color.GREEN));
		relativeLayout.addView(linearLayoutRoot);
		ScrollView scrollView = new ScrollView(getApplicationContext());
		scrollView.addView(relativeLayout);
  		getContentPane().addView(scrollView);
	}
 
}
