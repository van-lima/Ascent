package com.ascentcomtec.smarthouse.ui.portlets.utilities.statistic;

import java.util.List;

import net.sourceforge.api.JDateTime;
import android.content.Context;
import android.text.InputType;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.ascentcomtec.smarthouse.ui.activities.AbstractActivity;
import com.ascentcomtec.smarthouse.ui.components.textview.JTextView;
import com.ascentcomtec.smarthouse.ui.plaf.Style;
import com.ascentcomtec.smarthouse.utils.SmartHomeSharePreferents;

public class JFormInputData extends LinearLayout {

	private LinearLayout root;
	private int[] color;
	private EditText[] editTexts;

	public JFormInputData(Context context) {
		super(context);
		color = new int[] { 0xFF000099, 0xFF0000EE, 0xFF004400, 0xFF000033,
				0xFF330066, 0xFFCC0066, 0xFF009900, 0xFFEE0000, 0xFF336666,
				0xFF0033FF, 0xFFFF3333, 0xFF666666 };
		root = new LinearLayout(context);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT);
		setLayoutParams(layoutParams);
		root.setLayoutParams(layoutParams);
		root.setOrientation(LinearLayout.VERTICAL);
	}

	/***
	 * 
	 */
	public LinearLayout setAdapter(int width, int typeData, int typeFuel) {
		JDateTime jDateTime = new JDateTime();
		root.removeAllViews();
		switch (typeData) {
		case 0x111:
			List<String> listDay = jDateTime.listDatesInWeek();
			if (editTexts != null) {
				editTexts = null;
			}
			editTexts = new EditText[listDay.size()];
			float[] data;
			switch (typeFuel) {
			case 0:
				data = SmartHomeSharePreferents
						.getDataElectricityOfDay(getContext());
				break;
			case 1:
				data = SmartHomeSharePreferents.getDataGasOfDay(getContext());
				break;
			case 2:
				data = SmartHomeSharePreferents.getDataWaterOfDay(getContext());
				break;
			default:
				data = SmartHomeSharePreferents
						.getDataElectricityOfDay(getContext());
				break;
			}

			for (int i = 0; i < editTexts.length; i++) {
				editTexts[i] = new EditText(getContext());
				editTexts[i].setInputType(InputType.TYPE_CLASS_NUMBER);
				editTexts[i].setText("" + data[i]);

			}
			for (int i = 0; i < listDay.size(); i++) {
				root.addView(getLinearLayout(color[i], width, listDay.get(i),
						"Usage", editTexts[i]));
			}
			break;
		case 0x112:
			List<String> listWeekOfMonth = jDateTime.listWeekOfMonth();
			float[] weekOfMonth;
			switch (typeFuel) {
			case 0:
				weekOfMonth = SmartHomeSharePreferents
						.getDataElectricityOfWeek(getContext());
				break;
			case 1:
				weekOfMonth = SmartHomeSharePreferents
						.getDataGasOfWeek(getContext());
				break;
			case 2:
				weekOfMonth = SmartHomeSharePreferents
						.getDataWaterOfWeek(getContext());
				break;
			default:
				weekOfMonth = SmartHomeSharePreferents
						.getDataElectricityOfWeek(getContext());
				break;
			}

			if (editTexts != null) {
				editTexts = null;
			}
			editTexts = new EditText[listWeekOfMonth.size()];
			for (int i = 0; i < editTexts.length; i++) {
				editTexts[i] = new EditText(getContext());
				editTexts[i].setInputType(InputType.TYPE_CLASS_NUMBER);
				editTexts[i].setText("" + weekOfMonth[i]);
			}
			for (int i = 0; i < listWeekOfMonth.size(); i++) {
				root.addView(getLinearLayout(color[i], width,
						listWeekOfMonth.get(i), "Usage", editTexts[i]));
			}
			break;
		case 0x113:
			List<String> listMonth = jDateTime.listMonth();
			float[] monthOfYear;
			switch (typeFuel) {
			case 0:
				monthOfYear = SmartHomeSharePreferents
						.getDataElectricityOfMonth(getContext());
				break;
			case 1:
				monthOfYear = SmartHomeSharePreferents
						.getDataGasOfMonth(getContext());
				break;
			case 2:
				monthOfYear = SmartHomeSharePreferents
						.getDataWaterOfMonth(getContext());
				break;
			default:
				monthOfYear = SmartHomeSharePreferents
						.getDataElectricityOfMonth(getContext());
				break;
			}

			if (editTexts != null) {
				editTexts = null;
			}
			editTexts = new EditText[listMonth.size()];
			for (int i = 0; i < editTexts.length; i++) {
				editTexts[i] = new EditText(getContext());
				editTexts[i].setInputType(InputType.TYPE_CLASS_NUMBER);
				editTexts[i].setText("" + monthOfYear[i]);
			}
			for (int i = 0; i < listMonth.size(); i++) {
				root.addView(getLinearLayout(color[i], width, listMonth.get(i),
						"Usage", editTexts[i]));
			}
			break;
		case 0x114:
			List<String> listQuarter = jDateTime.listQuarter();
			float[] quarterOfYear;
			switch (typeFuel) {
			case 0:
				quarterOfYear = SmartHomeSharePreferents
						.getDataElectricityOfQuarter(getContext());
				break;
			case 1:
				quarterOfYear = SmartHomeSharePreferents
						.getDataGasOfQuarter(getContext());
				break;
			case 2:
				quarterOfYear = SmartHomeSharePreferents
						.getDataWaterOfQuarter(getContext());
				break;
			default:
				quarterOfYear = SmartHomeSharePreferents
						.getDataElectricityOfQuarter(getContext());
				break;
			}
			if (editTexts != null) {
				editTexts = null;
			}
			editTexts = new EditText[listQuarter.size()];
			for (int i = 0; i < editTexts.length; i++) {
				editTexts[i] = new EditText(getContext());
				editTexts[i].setInputType(InputType.TYPE_CLASS_NUMBER);
				editTexts[i].setText("" + quarterOfYear[i]);
			}
			for (int i = 0; i < listQuarter.size(); i++) {
				root.addView(getLinearLayout(color[i], width,
						listQuarter.get(i), "Usage", editTexts[i]));
			}
			break;
		case 0x115:
			List<String> listYear = jDateTime.listYear();
			float[] years;
			switch (typeFuel) {
			case 0:
				years = SmartHomeSharePreferents
						.getDataElectricityOfYear(getContext());
				break;
			case 1:
				years = SmartHomeSharePreferents.getDataGasOfYear(getContext());
				break;
			case 2:
				years = SmartHomeSharePreferents
						.getDataWaterOfYear(getContext());
				break;
			default:
				years = SmartHomeSharePreferents
						.getDataElectricityOfYear(getContext());
				break;
			}

			if (editTexts != null) {
				editTexts = null;
			}
			editTexts = new EditText[listYear.size()];
			for (int i = 0; i < editTexts.length; i++) {
				editTexts[i] = new EditText(getContext());
				editTexts[i].setInputType(InputType.TYPE_CLASS_NUMBER);
				editTexts[i].setText("" + years[i]);
			}
			for (int i = 0; i < listYear.size(); i++) {
				root.addView(getLinearLayout(color[i], width, listYear.get(i),
						"Usage", editTexts[i]));
			}
			break;
		default:
			break;
		}
		return root;
	}

	/***
	 * 
	 * @param lable
	 * @param value
	 * @return
	 */
	public LinearLayout getLinearLayout(int color, int width,
			String stringLable, String currentUsage,
			EditText editTextCurrentUsage) {
		LinearLayout linearLayoutRoot = new LinearLayout(getContext());
		linearLayoutRoot.setOrientation(LinearLayout.VERTICAL);
		LinearLayout linearLayoutCurrentUsage = new LinearLayout(getContext());
		linearLayoutCurrentUsage.setOrientation(LinearLayout.HORIZONTAL);
		Style style = new Style(getContext());
		style.setMargin(10, 10, 10, 10);
		style.setPadding(10, 10, 10, 10);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(style.getMarginValue(AbstractActivity.LEFT),
				style.getMarginValue(AbstractActivity.TOP),
				style.getMarginValue(AbstractActivity.RIGHT),
				style.getMarginValue(AbstractActivity.BOTTOM));
		linearLayoutCurrentUsage.setLayoutParams(layoutParams);
		LinearLayout linearLayoutAverageUsage = new LinearLayout(getContext());
		linearLayoutAverageUsage.setOrientation(LinearLayout.HORIZONTAL);
		linearLayoutAverageUsage.setLayoutParams(layoutParams);
		JTextView jTextViewLableCurrentUsage = new JTextView(getContext());
		jTextViewLableCurrentUsage.setGravity(Gravity.RIGHT | Gravity.CENTER);
		jTextViewLableCurrentUsage
				.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.WRAP_CONTENT,
						LinearLayout.LayoutParams.WRAP_CONTENT, 1));
		jTextViewLableCurrentUsage.setText(currentUsage + " :   ");
		linearLayoutCurrentUsage.addView(jTextViewLableCurrentUsage);
		editTextCurrentUsage.setSingleLine(true);
		editTextCurrentUsage.setMaxLines(1);
		editTextCurrentUsage.setLayoutParams(new LinearLayout.LayoutParams(
				width * 2 / 3, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
		linearLayoutCurrentUsage.addView(editTextCurrentUsage);
		linearLayoutRoot.addView(linearLayoutCurrentUsage);
		LinearLayout root = new LinearLayout(getContext());
		root.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT));
		root.setOrientation(LinearLayout.HORIZONTAL);
		LinearLayout linearLayoutLable = new LinearLayout(getContext());
		linearLayoutLable.setOrientation(LinearLayout.VERTICAL);
		linearLayoutLable.setGravity(Gravity.RIGHT | Gravity.CENTER);
		linearLayoutLable.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.FILL_PARENT));
		linearLayoutLable.setBackgroundColor(color);
		JTextView lable = new JTextView(getContext());
		lable.setPadding(10, 0, 10, 0);
		lable.setText(stringLable.split(" ")[0]);
		lable.setLayoutParams(new LinearLayout.LayoutParams(95,
				LinearLayout.LayoutParams.WRAP_CONTENT));
		lable.setGravity(Gravity.RIGHT | Gravity.CENTER);
		linearLayoutLable.addView(lable);
		try {
			JTextView lableDate = new JTextView(getContext());
			lableDate.setPadding(10, 0, 10, 0);
			lableDate.setText(stringLable.split(" ")[1]);
			lableDate.setLayoutParams(new LinearLayout.LayoutParams(125,
					LinearLayout.LayoutParams.WRAP_CONTENT));
			lableDate.setGravity(Gravity.RIGHT | Gravity.CENTER);
			linearLayoutLable.addView(lableDate);
		} catch (Exception e) {

		}
		root.addView(linearLayoutLable);
		root.addView(linearLayoutRoot);
		return root;
	}

	/**
	 * user can save every data from input text here
	 * 
	 * @param type
	 * @author Ducv
	 */
	public void saveData(int type, int curTab) {
		getData(type, curTab);
	}

	private void getData(int type, int curTab) {
		switch (curTab) {
		case 0x111:// day
			float[] dataOfDay = new float[7];
			for (int i = 0; i < dataOfDay.length; i++) {
				try {
					dataOfDay[i] = Float.parseFloat(editTexts[i].getText()
							.toString());
				} catch (Exception e) {
					dataOfDay[i] = 0;
				}
			}
			switch (type) {
			case 0:// Electricity
				SmartHomeSharePreferents.putDataElectricityOfDay(dataOfDay,
						getContext());
				break;
			case 1:// Gas
				SmartHomeSharePreferents.putDataGasOfDay(dataOfDay,
						getContext());
				break;
			case 2:// Water
				SmartHomeSharePreferents.putDataWaterOfDay(dataOfDay,
						getContext());
				break;

			default:
				break;
			}
			break;
		case 0x112:// week
			float[] dataOfWeek = new float[4];
			for (int i = 0; i < dataOfWeek.length; i++) {
				try {
					dataOfWeek[i] = Float.parseFloat(editTexts[i].getText()
							.toString());
				} catch (Exception e) {
					dataOfWeek[i] = 0;
				}
			}
			switch (type) {
			case 0:
				SmartHomeSharePreferents.putDataElectricityOfWeek(dataOfWeek,
						getContext());
				break;
			case 1:
				SmartHomeSharePreferents.putDataGasOfWeek(dataOfWeek,
						getContext());
				break;
			case 2:
				SmartHomeSharePreferents.putDataWaterOfWeek(dataOfWeek,
						getContext());
				break;

			default:
				break;
			}
			break;
		case 0x113:// month
			float[] dataOfMonth = new float[4];
			for (int i = 0; i < dataOfMonth.length; i++) {
				try {
					dataOfMonth[i] = Float.parseFloat(editTexts[i].getText()
							.toString());
				} catch (Exception e) {
					dataOfMonth[i] = 0;
				}
			}
			switch (type) {
			case 0:
				SmartHomeSharePreferents.putDataElectricityOfMonth(dataOfMonth,
						getContext());
				break;
			case 1:
				SmartHomeSharePreferents.putDataGasOfMonth(dataOfMonth,
						getContext());
				break;
			case 2:
				SmartHomeSharePreferents.putDataWaterOfMonth(dataOfMonth,
						getContext());
				break;

			default:
				break;
			}
			break;
		case 0x114:// quarter
			float[] dataOfQuarter = new float[4];
			for (int i = 0; i < dataOfQuarter.length; i++) {
				try {
					dataOfQuarter[i] = Float.parseFloat(editTexts[i].getText()
							.toString());
				} catch (Exception e) {
					dataOfQuarter[i] = 0;
				}
			}
			switch (type) {
			case 0:
				SmartHomeSharePreferents.putDataElectricityOfQuarter(
						dataOfQuarter, getContext());
				break;
			case 1:
				SmartHomeSharePreferents.putDataGasOfQuarter(dataOfQuarter,
						getContext());
				break;
			case 2:
				SmartHomeSharePreferents.putDataWaterOfQuarter(dataOfQuarter,
						getContext());
				break;

			default:
				break;
			}
			break;
		case 0x115:// year
			float[] dataOfYear = new float[4];
			for (int i = 0; i < dataOfYear.length; i++) {
				try {
					dataOfYear[i] = Float.parseFloat(editTexts[i].getText()
							.toString());
				} catch (Exception e) {
					dataOfYear[i] = 0;
				}
			}
			switch (type) {
			case 0:
				SmartHomeSharePreferents.putDataElectricityOfYear(dataOfYear,
						getContext());
				break;
			case 1:
				SmartHomeSharePreferents.putDataGasOfYear(dataOfYear,
						getContext());
				break;
			case 2:
				SmartHomeSharePreferents.putDataWaterOfYear(dataOfYear,
						getContext());
				break;

			default:
				break;
			}
			break;
		default:
			break;
		}
	}

}
