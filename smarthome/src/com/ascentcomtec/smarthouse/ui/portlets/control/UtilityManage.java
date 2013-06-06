package com.ascentcomtec.smarthouse.ui.portlets.control;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.ascentcomtec.smarthouse.R;
import com.ascentcomtec.smarthouse.ui.activities.AbstractActivity;
import com.ascentcomtec.smarthouse.ui.components.HAFormFactory;
import com.ascentcomtec.smarthouse.ui.components.button.JButton;
import com.ascentcomtec.smarthouse.ui.plaf.Style;

public class UtilityManage extends HAFormFactory{

	@Override
	public void executeUI() {
		setTitle("Utility Manage");
		LinearLayout linearLayoutRoot = new LinearLayout(getApplicationContext());
		linearLayoutRoot.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
		linearLayoutRoot.setOrientation(LinearLayout.HORIZONTAL);
		JButton jButtonElectricity = new JButton(getApplicationContext());
		jButtonElectricity.setLayoutParams(getLinearLayoutLayoutParams());
		jButtonElectricity.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_electricity));
		linearLayoutRoot.addView(jButtonElectricity);
		JButton jButtonGas = new JButton(getApplicationContext());
		jButtonGas.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_gas));
		jButtonGas.setLayoutParams(getLinearLayoutLayoutParams());
		linearLayoutRoot.addView(jButtonGas);
		JButton jButtonWater = new JButton(getApplicationContext());
		jButtonWater.setLayoutParams(getLinearLayoutLayoutParams());
		jButtonWater.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_water));
		linearLayoutRoot.addView(jButtonWater);
		JButton jButtonUsageAlarm = new JButton(getApplicationContext());
		jButtonUsageAlarm.setLayoutParams(getLinearLayoutLayoutParams());
		jButtonUsageAlarm.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_usage_alarm));
		linearLayoutRoot.addView(jButtonUsageAlarm);
		RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
  		relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT));
		relativeLayout.addView(linearLayoutRoot);
		ScrollView scrollView = new ScrollView(getApplicationContext());
		scrollView.addView(relativeLayout);
  		getContentPane().addView(scrollView);
		
	}
	/***
	 * get layout params for screen title
	 * 
	 * @return
	 */
	public LinearLayout.LayoutParams getLinearLayoutLayoutParams() {
		Style style = new Style(getApplicationContext());
		style.setMargin(10, 10, 10, 10);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(style.getMarginValue(AbstractActivity.LEFT), style.getMarginValue(AbstractActivity.TOP), style.getMarginValue(AbstractActivity.RIGHT), style.getMarginValue(AbstractActivity.BOTTOM));
		return layoutParams;
	}

}
