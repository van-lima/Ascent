package com.ascentcomtec.smarthouse;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.Gravity;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.ascentcomtec.smarthouse.Control.OnItemSelectedListener;
import com.ascentcomtec.smarthouse.ui.components.button.JToggleButton;
import com.ascentcomtec.smarthouse.ui.components.textview.JTextView;
import com.ascentcomtec.smarthouse.utils.Utils;

public class Security extends LinearLayout {
	private JToggleButton[] buttons;
	private OnSecuritySelectedListener onSecuritySelectedListener;

	public Security(Context context) {
		super(context);
	}

	public Security(Context context, int height,
			OnSecuritySelectedListener onSecuritySelectedListener) {
		super(context);
		buttons = new JToggleButton[3];
		this.onSecuritySelectedListener = onSecuritySelectedListener;
		LinearLayout linearLayout = new LinearLayout(getContext());
		linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT));
		LinearLayout.LayoutParams layoutParamsColumn = new LinearLayout.LayoutParams(
				TableRow.LayoutParams.FILL_PARENT,
				TableRow.LayoutParams.FILL_PARENT, 1);
		LinearLayout disArm = getCell(context, height, R.drawable.lock_off,
				R.drawable.lock_on, false, "Front Door Lock",0);
		disArm.setLayoutParams(layoutParamsColumn);
		linearLayout.addView(disArm);
		LinearLayout arm = getCell(context, height, R.drawable.lock_off,
				R.drawable.lock_on, true, "Security System",1);
		arm.setLayoutParams(layoutParamsColumn);
		linearLayout.addView(arm);
		LinearLayout webcam = getCell(context, height, R.drawable.camera_off,
				R.drawable.camera_on, true, "Front Door Intercom",2);
		webcam.setLayoutParams(layoutParamsColumn);
		linearLayout.addView(webcam);
		setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT));
		addView(linearLayout);
	}

	/***
	 * 
	 * @param height
	 * @return
	 */
	private LinearLayout getCell(Context context, int height,
			int state_pressed, int state_enabled, boolean checked) {
		LinearLayout linearLayout = new LinearLayout(getContext());
		setPadding(Utils.convertDips2Pixel(10, context),
				Utils.convertDips2Pixel(5, context),
				Utils.convertDips2Pixel(10, context),
				Utils.convertDips2Pixel(5, context));
		height = height - Utils.convertDips2Pixel(5, context)
				- Utils.convertDips2Pixel(5, context)
				- Utils.convertDips2Pixel(30, getContext());
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT));
		LinearLayout linearLayoutFirst = new LinearLayout(getContext());
		linearLayoutFirst.setGravity(Gravity.CENTER);
		linearLayoutFirst.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, height));
		JToggleButton jToggleButton = new JToggleButton(getContext(),
				state_pressed, state_enabled);
		jToggleButton.setChecked(checked);
		jToggleButton.setLayoutParams(new LinearLayout.LayoutParams(height,
				height));
		linearLayoutFirst.addView(jToggleButton);
		linearLayout.addView(linearLayoutFirst);
		return linearLayout;
	}

	/***
	 * 
	 * @param height
	 * @return
	 */
	private LinearLayout getCell(Context context, int height,
			int state_pressed, int state_enabled, boolean checked, String text, final int id) {
		LinearLayout linearLayout = new LinearLayout(getContext());
		setPadding(Utils.convertDips2Pixel(10, context),
				Utils.convertDips2Pixel(5, context),
				Utils.convertDips2Pixel(10, context),
				Utils.convertDips2Pixel(5, context));
		height = height - Utils.convertDips2Pixel(5, context)
				- Utils.convertDips2Pixel(5, context)
				- Utils.convertDips2Pixel(20, getContext());
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		linearLayout.setGravity(Gravity.CENTER);
		linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT));
		LinearLayout linearLayoutFirst = new LinearLayout(getContext());
		linearLayoutFirst.setOrientation(LinearLayout.VERTICAL);
		linearLayoutFirst.setGravity(Gravity.CENTER);
		linearLayoutFirst.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, height));
		buttons[id]  = new JToggleButton(getContext(),
				state_pressed, state_enabled);
		buttons[id].setChecked(checked);
		buttons[id].setLayoutParams(new LinearLayout.LayoutParams(height,
				height));
		linearLayoutFirst.addView(buttons[id]);
		
		buttons[id].setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				onSecuritySelectedListener.onSecuritySelect(id, isChecked);
			}
		});

		
		linearLayout.addView(linearLayoutFirst);
		JTextView jTextView = new JTextView(context);
		jTextView.setTextColor(0xFF000000);
		jTextView.setGravity(Gravity.CENTER);
		jTextView.setSingleLine(true);
		jTextView.setEllipsize(TruncateAt.END);
		jTextView.setText(text);
		linearLayout.addView(jTextView);
		return linearLayout;
	}

	public interface OnSecuritySelectedListener {
		public void onSecuritySelect(int id, boolean status);
	}

	public void setSelect(int id, boolean status) {
		buttons[id].setSelected(status);
		this.invalidate();
	}
}
