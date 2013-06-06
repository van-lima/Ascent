package com.ascentcomtec.smarthouse;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.ascentcomtec.smarthouse.ui.activities.AbstractActivity;
import com.ascentcomtec.smarthouse.ui.components.Lines;
import com.ascentcomtec.smarthouse.ui.components.textview.JTextView;
import com.ascentcomtec.smarthouse.ui.plaf.Style;
import com.ascentcomtec.smarthouse.utils.Utils;

public class TemperatureHumidity extends LinearLayout {

	private float temperate, humidity;
	private JTextView tempText, humiText;
	private Handler counter = new Handler();

	private final int time = 120000;///milli seconds
	public TemperatureHumidity(Context context) {
		super(context);
	}

	public TemperatureHumidity(Context context, int height) {
		super(context);
		setPadding(Utils.convertDips2Pixel(10, context),
				Utils.convertDips2Pixel(10, context),
				Utils.convertDips2Pixel(10, context),
				Utils.convertDips2Pixel(10, context));
		height = height - Utils.convertDips2Pixel(10, context)
				- Utils.convertDips2Pixel(10, context);
		setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT));
		setOrientation(LinearLayout.HORIZONTAL);
		addView(getLinearLayout(height));
		counter.postDelayed(updateTimeTaskTemp, time);

	}

	private LinearLayout getLinearLayout(int height) {
		LinearLayout linearLayout = new LinearLayout(getContext());
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, height));
		linearLayout.setBackgroundResource(R.drawable.tem_hum);
		LinearLayout linearLayoutLiveUse = getLinearLayoutTemp("TEMPERATURE",
				height / 2);
		linearLayout.addView(linearLayoutLiveUse);
		linearLayout.addView(new Lines(getContext()));
		LinearLayout linearLayoutCost = getLinearLayoutTempHum("HUMIDITY",
				height / 2);
		linearLayout.addView(linearLayoutCost);
		return linearLayout;
	}

	/***
	 * 
	 * @param lable
	 * @param value
	 * @return
	 */
	public LinearLayout getLinearLayoutTempHum(String lable, int height) {
		LinearLayout linearLayout = new LinearLayout(getContext());
		Style style = new Style(getContext());
		style.setMargin(0, 0, 5, 5);
		style.setPadding(5, 5, 5, 5);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, height);
		layoutParams.setMargins(style.getMarginValue(AbstractActivity.LEFT),
				style.getMarginValue(AbstractActivity.TOP),
				style.getMarginValue(AbstractActivity.RIGHT),
				style.getMarginValue(AbstractActivity.BOTTOM));
		linearLayout.setLayoutParams(layoutParams);
		JTextView jTextViewLable = new JTextView(getContext());
		jTextViewLable.setGravity(Gravity.LEFT | Gravity.CENTER);
		jTextViewLable.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, height, 1));
		jTextViewLable.setText(lable);
		linearLayout.addView(jTextViewLable);
		humiText = new JTextView(getContext());
		humiText.setTextColor(0xFFFFFFFF);
		humiText.setModeTitle(getContext());
		humiText.setGravity(Gravity.RIGHT | Gravity.CENTER);
		humiText.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, height, 1));

		linearLayout.addView(humiText);
		linearLayout
				.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		return linearLayout;
	}

	/***
	 * 
	 * @param lable
	 * @param value
	 * @return
	 */
	public LinearLayout getLinearLayoutTemp(String lable, int height) {
		LinearLayout linearLayout = new LinearLayout(getContext());
		Style style = new Style(getContext());
		style.setMargin(0, 0, 5, 5);
		style.setPadding(5, 5, 5, 5);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, height);
		layoutParams.setMargins(style.getMarginValue(AbstractActivity.LEFT),
				style.getMarginValue(AbstractActivity.TOP),
				style.getMarginValue(AbstractActivity.RIGHT),
				style.getMarginValue(AbstractActivity.BOTTOM));
		linearLayout.setLayoutParams(layoutParams);
		JTextView jTextViewLable = new JTextView(getContext());
		jTextViewLable.setGravity(Gravity.LEFT | Gravity.CENTER);
		jTextViewLable.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, height, 1));
		jTextViewLable.setText(lable);
		linearLayout.addView(jTextViewLable);
		tempText = new JTextView(getContext());
		tempText.setTextColor(0xFFFFFFFF);
		tempText.setModeTitle(getContext());
		tempText.setGravity(Gravity.RIGHT | Gravity.CENTER);
		tempText.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, height, 1));

		linearLayout.addView(tempText);
		linearLayout
				.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		return linearLayout;
	}

	public void updateData(float temp, float humi) {
		if (temp != 0) {
			temperate = temp;
			tempText.setText("" + temperate);
		} else {
			temperate = 0;
			tempText.setText("In progress...");
		}

		if (humi != 0) {
			humidity = humi;
			humiText.setText("" + humidity);
		} else {
			temperate = 0;
			humiText.setText("In progress...");
		}
		invalidate();
	}

	Runnable updateTimeTaskTemp = new Runnable() {
		public void run() {
			if (temperate == 0) {
				tempText.setText("----");
			}
			if (humidity == 0) {
				humiText.setText("----");
			}
			counter.postDelayed(this, time);
		}
	};

}
