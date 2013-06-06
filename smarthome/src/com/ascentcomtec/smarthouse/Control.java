package com.ascentcomtec.smarthouse;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.Gravity;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TableRow;

import com.ascentcomtec.smarthouse.ui.components.button.JToggleButton;
import com.ascentcomtec.smarthouse.ui.components.textview.JTextView;
import com.ascentcomtec.smarthouse.utils.Utils;

public class Control extends LinearLayout {
	private OnItemSelectedListener onItemSelectedListener;
	private JToggleButton[] buttons; 
	public Control(Context context) {
		super(context);
	}

	public Control(Context context, int height,
			OnItemSelectedListener onItemSelectedListener) {
		super(context);
		buttons = new JToggleButton[2];
		LinearLayout linearLayout = new LinearLayout(getContext());
		linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT));
		LinearLayout.LayoutParams layoutParamsColumn = new LinearLayout.LayoutParams(
				TableRow.LayoutParams.FILL_PARENT,
				TableRow.LayoutParams.FILL_PARENT, 1);
		LinearLayout light = getCell(context, height, R.drawable.light_on,
				R.drawable.light_off, "Bed Room",0);
		light.setLayoutParams(layoutParamsColumn);
		linearLayout.addView(light);
		LinearLayout printer = getCell(context, height, R.drawable.printer_on,
				R.drawable.printer_off, "Meeting Room",1);
		printer.setLayoutParams(layoutParamsColumn);
		linearLayout.addView(printer);
		LinearLayout space = new LinearLayout(getContext());
		space.setLayoutParams(layoutParamsColumn);
		linearLayout.addView(space);
		setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT));
		addView(linearLayout);
		this.onItemSelectedListener = onItemSelectedListener;
	}

	/***
	 * 
	 * @param height
	 * @return
	 */
	private LinearLayout getCell(Context context, int height,
			int state_pressed, int state_enabled,int id) {
		LinearLayout linearLayout = new LinearLayout(getContext());
		setPadding(Utils.convertDips2Pixel(10, context),
				Utils.convertDips2Pixel(5, context),
				Utils.convertDips2Pixel(10, context),
				Utils.convertDips2Pixel(5, context));
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT));
		LinearLayout linearLayoutFirst = new LinearLayout(getContext());
		linearLayoutFirst.setGravity(Gravity.CENTER);
		height = height - Utils.convertDips2Pixel(5, context)
				- Utils.convertDips2Pixel(5, context);
		linearLayoutFirst.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, height));
		buttons[id] = new JToggleButton(getContext(),
				state_pressed, state_enabled);
		buttons[id].setChecked(false);
		buttons[id].setLayoutParams(new LinearLayout.LayoutParams(height,
				height));
		linearLayoutFirst.addView(buttons[id]);
		linearLayout.addView(linearLayoutFirst);
		return linearLayout;
	}

	/***
	 * 
	 * @param height
	 * @return
	 */
	private LinearLayout getCell(Context context, int height,
			int state_pressed, int state_enabled, String text,final int id) {
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
		buttons[id] = new JToggleButton(getContext(),
				state_pressed, state_enabled);
		buttons[id].setLayoutParams(new LinearLayout.LayoutParams(height,
				height));
		buttons[id].setChecked(false);
		linearLayoutFirst.addView(buttons[id]);
		
		
		linearLayout.addView(linearLayoutFirst);
		JTextView jTextView = new JTextView(context);
		jTextView.setTextColor(0xFF000000);
		jTextView.setGravity(Gravity.CENTER);
		jTextView.setSingleLine(true);
		jTextView.setEllipsize(TruncateAt.END);
		jTextView.setText(text);
		linearLayout.addView(jTextView);
	

		buttons[id].setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				onItemSelectedListener.onSelect(id, isChecked);
			}
		});

		return linearLayout;
	}

	public interface OnItemSelectedListener {
		public void onSelect(int id, boolean status);
	}

	public void setSelect(int id, boolean status) {
		buttons[id].setSelected(status);
		this.invalidate();
	}
}
