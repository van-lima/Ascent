package com.ascentcomtec.smarthouse;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.ascentcomtec.smarthouse.ui.activities.AbstractActivity;
import com.ascentcomtec.smarthouse.ui.components.Lines;
import com.ascentcomtec.smarthouse.ui.components.Space;
import com.ascentcomtec.smarthouse.ui.components.button.JButton;
import com.ascentcomtec.smarthouse.ui.components.textview.JTextView;
import com.ascentcomtec.smarthouse.ui.plaf.Style;
import com.ascentcomtec.smarthouse.ui.portlets.utilities.statistic.ChartUsage;
import com.ascentcomtec.smarthouse.utils.Utils;

public class Gas extends LinearLayout{
	
	public Gas(Context context) {
		super(context);
	}

	public Gas(final AbstractActivity context, int height) {
		super(context);
 		setPadding(Utils.convertDips2Pixel(10, context), Utils.convertDips2Pixel(10, context), Utils.convertDips2Pixel(10, context), Utils.convertDips2Pixel(10, context));
		height = height - Utils.convertDips2Pixel(10, context) - Utils.convertDips2Pixel(10, context);
		setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
		setOrientation(LinearLayout.HORIZONTAL);
		JButton jButton = new JButton(getContext());
		jButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.gas));
		jButton.setLayoutParams(new LinearLayout.LayoutParams(height, height));
		addView(jButton);
		jButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				Intent intent = new Intent(context, GasChart.class);
//				context.startActivity(intent);
				Intent intent = new Intent(context, ChartUsage.class);// ElectricityChart
				Bundle bundle = new Bundle();
				bundle.putInt("NAME_GRAPH", 1);
				intent.putExtras(bundle);
				context.startActivity(intent);
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
		linearLayout.setBackgroundResource(R.drawable.gas_background);
		LinearLayout linearLayoutLiveUse = getLinearLayout("Usage per day", "51MJ", height/2);
		linearLayout.addView(linearLayoutLiveUse);
		linearLayout.addView(new Lines(getContext()));
		LinearLayout linearLayoutCost = getLinearLayout("Cost per day", "$1.02", height/2);
		linearLayout.addView(linearLayoutCost);
		return linearLayout;
	}
	/***
	 * 
	 * @param lable
	 * @param value
	 * @return
	 */
	public LinearLayout getLinearLayout(String lable, String value, int height){
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
 		JTextView jTextViewLable = new JTextView(getContext());
		jTextViewLable.setGravity(Gravity.LEFT | Gravity.CENTER);
		jTextViewLable.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, height, 1));
		jTextViewLable.setText(lable);
		linearLayout.addView(jTextViewLable);
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
