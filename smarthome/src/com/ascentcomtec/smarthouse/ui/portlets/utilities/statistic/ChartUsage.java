package com.ascentcomtec.smarthouse.ui.portlets.utilities.statistic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer.Orientation;
import org.apache.commons.lang3.ArrayUtils;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ascentcomtec.smarthouse.R;
import com.ascentcomtec.smarthouse.utils.SmartHomeSharePreferents;
import com.resolutiondev.ui.drawable.JDrawable;

public class ChartUsage extends Activity implements OnClickListener {
	private LinearLayout graphicalView;// using to render grapphic of electric,
										// water and gas
	private final int[][] colorsW = new int[][] {
			new int[] { Color.parseColor("#8B0000"), Color.parseColor("#DAA520") },
			new int[] { Color.parseColor("#32CD32"), Color.parseColor("#00FF00") },
			new int[] { Color.parseColor("#00BFFF"), Color.parseColor("#00FFFF") }};

	private List<float[]> datas;
	private float[] dataFloats;
	private final String[] DAYS = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat",
			"Sun" };
	private final String[] WEEK = { "Week1", "Week2", "Week3", "Week3" };
	private final String[] MONTH = { "January", "February", "March", "April",
			"May", "June", "July", "August", "September", "October",
			"November", "December" };
	private final String[] QUARTER = { "Quarter 1", "Quarter 2", "Quarter 3",
			"Quarter 3" };
	private final String[] YEAR = { "2010/2013", "2011/2013", "2012/2013",
			"2013/2013" };
	private int curTab = 0;
	private int curNameGraph = 0;
	private float yMin, yMax;
	private TextView dateTv, titleTv;
	private Button backBt, inputBt, dayBt, weekBt, monthBt, quarterBt, yearBt;

	// define
	private final int ELECTRICAL = 0;
	private final int GAS = 1;
	private final int WATER = 2;
	// for tab
	private final int TAB_DAY = 0;
	private final int TAB_WEEK = 1;
	private final int TAB_MONTH = 2;
	private final int TAB_QUARTER = 3;
	private final int TAB_YEAR = 4;
	private final int[] idButtons = new int[] { R.id.myButtonDay,
			R.id.myButtonWeek, R.id.myButtonMonth, R.id.myButtonQuarter,
			R.id.myButtonYear };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chart_usage);
		graphicalView = (LinearLayout) findViewById(R.id.myGraphicalView);
		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			curNameGraph = bundle.getInt("NAME_GRAPH");
		}
		curTab = TAB_DAY;
		initControl();
		initButton();
		initTitle();
		updateBackgroundButton(R.id.myButtonDay);
		initGraphic();

	}

	/**
	 * this function init for all controls by ID
	 */
	private void initControl() {
		dateTv = (TextView) findViewById(R.id.myTextviewDate);
		titleTv = (TextView) findViewById(R.id.myTextViewTitle);
		backBt = (Button) findViewById(R.id.myButtonBack);
		dayBt = (Button) findViewById(R.id.myButtonDay);
		weekBt = (Button) findViewById(R.id.myButtonWeek);
		monthBt = (Button) findViewById(R.id.myButtonMonth);
		quarterBt = (Button) findViewById(R.id.myButtonQuarter);
		yearBt = (Button) findViewById(R.id.myButtonYear);
		inputBt = (Button) findViewById(R.id.myButtonInPutData);
		backBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		// go to the input data screen
		inputBt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ChartUsage.this, InputData.class);
				Bundle bundle = new Bundle();
				bundle.putByte("TYPE", (byte) curNameGraph);
				intent.putExtras(bundle);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
						| Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
			}
		});
		dateTv.setText(new SimpleDateFormat("dd/MM/yyyy").format(System
				.currentTimeMillis()));
	}

	private void initButton() {
		dayBt.setBackgroundDrawable(JDrawable.getJDrawable()
				.fillRoundRectRadialGradient(
						new int[] { 0xFFEEEEEE, 0xFFEEEEEE, 0xFF0099FF,
								0xFF0099FF }));
		weekBt.setBackgroundDrawable(JDrawable.getJDrawable()
				.fillRoundRectRadialGradient(
						new int[] { 0xFFEEEEEE, 0xFFEEEEEE, 0xFF0099FF,
								0xFF0099FF }));
		monthBt.setBackgroundDrawable(JDrawable.getJDrawable()
				.fillRoundRectRadialGradient(
						new int[] { 0xFFEEEEEE, 0xFFEEEEEE, 0xFF0099FF,
								0xFF0099FF }));
		quarterBt.setBackgroundDrawable(JDrawable.getJDrawable()
				.fillRoundRectRadialGradient(
						new int[] { 0xFFEEEEEE, 0xFFEEEEEE, 0xFF0099FF,
								0xFF0099FF }));
		yearBt.setBackgroundDrawable(JDrawable.getJDrawable()
				.fillRoundRectRadialGradient(
						new int[] { 0xFFEEEEEE, 0xFFEEEEEE, 0xFF0099FF,
								0xFF0099FF }));

		dayBt.setOnClickListener(this);
		weekBt.setOnClickListener(this);
		monthBt.setOnClickListener(this);
		quarterBt.setOnClickListener(this);
		yearBt.setOnClickListener(this);
	}

	private void initTitle() {
		switch (curNameGraph) {
		case ELECTRICAL:
			titleTv.setText("Electricity Usage");
			break;
		case GAS:
			titleTv.setText("Gas Usage");
			break;
		case WATER:
			titleTv.setText("Water Usage");

			break;
		default:
			break;
		}
	}

	private void initGraphic() {
		initDateInput();
		sort();
		if(datas!= null && datas.size() > 0){
			String[] titles = new String[] { "Current Usage", "Average Usage" };
			XYMultipleSeriesRenderer renderer = buildBarRenderer(colorsW[curNameGraph]);
			renderer.setShowGridX(true);
			renderer.setYLabelsPadding(10);
			renderer.setOrientation(Orientation.HORIZONTAL);

			renderer.setXLabels(1);
			renderer.setYLabels(10);

			String labels[] = addLabels(curTab);
			for (int i = 0; i < labels.length; i++) {
				renderer.addXTextLabel(i + 1, labels[i]);
			}

			int length = renderer.getSeriesRendererCount();
			for (int i = 0; i < length; i++) {
				SimpleSeriesRenderer seriesRenderer = renderer
						.getSeriesRendererAt(i);
				seriesRenderer.setDisplayChartValues(true);
			}

			setChartSettings(renderer, "", "", "", 0.5, dataFloats.length + 1, 1,
					yMax, Color.BLACK, Color.BLACK);

			final GraphicalView grfv = ChartFactory.getBarChartView(
					ChartUsage.this, buildBarDataset(titles, datas), renderer,
					Type.DEFAULT);

			graphicalView.addView(grfv);
		}
	}

	protected XYMultipleSeriesRenderer buildBarRenderer(int[] colors) {
		XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
		renderer.setAxisTitleTextSize(10);
		renderer.setChartTitleTextSize(10);
		renderer.setLabelsTextSize(10);
		renderer.setLegendTextSize(13);
		renderer.setBarSpacing(1);

		renderer.setMarginsColor(Color.parseColor("#EEEDED"));
		renderer.setXLabelsColor(Color.BLACK);
		renderer.setYLabelsColor(0, Color.BLACK);

		renderer.setApplyBackgroundColor(true);
		renderer.setBackgroundColor(Color.parseColor("#FBFBFC"));

		int length = colors.length;
		for (int i = 0; i < length; i++) {
			SimpleSeriesRenderer r = new SimpleSeriesRenderer();
			r.setColor(colors[i]);
			// r.setChartvalueAngle(-90);
			r.setChartValuesSpacing(10);
			renderer.addSeriesRenderer(r);
		}
		return renderer;
	}

	protected void setChartSettings(XYMultipleSeriesRenderer renderer,
			String title, String xTitle, String yTitle, double xMin,
			double xMax, double yMin, double yMax, int axesColor,
			int labelsColor) {
		renderer.setChartTitle(title);
		renderer.setYLabelsAlign(Align.RIGHT);
		renderer.setXTitle(xTitle);
		renderer.setYTitle(yTitle);
		renderer.setXAxisMin(xMin);
		renderer.setXAxisMax(xMax);
		renderer.setYAxisMin(yMin);
		renderer.setYAxisMax(yMax);
		renderer.setMargins(new int[] { 10, 65, 10, 15 });
		renderer.setAxesColor(axesColor);
		renderer.setLabelsColor(labelsColor);
	}

	/***
	 * 
	 * @param id
	 * @return
	 */
	private void initDateInput() {
		initData();
		datas = new ArrayList<float[]>();
		datas.add(dataFloats);
		datas.add(dataFloats);
	}

	protected XYMultipleSeriesDataset buildBarDataset(String[] titles,
			List<float[]> values) {
		XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
		int length = titles.length;
		for (int i = 0; i < length; i++) {
			CategorySeries series = new CategorySeries(titles[i]);
			float[] v = values.get(i);
			int seriesLength = v.length;
			for (int k = 0; k < seriesLength; k++) {
				series.add(v[k] == 0 ? 1 : v[k]);
			}
			dataset.addSeries(series.toXYSeries());
		}
		return dataset;
	}

	/**
	 * this function init chart with each type of feul
	 * 
	 * @param type
	 */
	private void initData() {
		switch (curNameGraph) {
		case ELECTRICAL:
			getDataOfElectricity();
			break;
		case GAS:
			getDataOfGas();
			break;
		case WATER:
			getDataOfWater();
			break;

		default:
			break;
		}
	}

	/**
	 * return labels of each graph
	 * 
	 * @param typeGraph
	 * @return
	 */
	private String[] addLabels(int typeGraph) {
		switch (typeGraph) {
		case TAB_DAY:
			return DAYS;
		case TAB_WEEK:
			return WEEK;
		case TAB_MONTH:
			return MONTH;
		case TAB_QUARTER:
			return QUARTER;
		case TAB_YEAR:
			return YEAR;
		default:
			return DAYS;
		}
	}

	/**
	 * Electricity
	 */
	private void getDataOfElectricity() {
		switch (curTab) {
		case TAB_DAY:
			dataFloats = SmartHomeSharePreferents.getDataElectricityOfDay(this);
			break;
		case TAB_WEEK:
			dataFloats = SmartHomeSharePreferents
					.getDataElectricityOfWeek(this);
			break;
		case TAB_MONTH:
			dataFloats = SmartHomeSharePreferents
					.getDataElectricityOfMonth(this);
			break;
		case TAB_QUARTER:
			dataFloats = SmartHomeSharePreferents
					.getDataElectricityOfQuarter(this);
			break;
		case TAB_YEAR:
			dataFloats = SmartHomeSharePreferents
					.getDataElectricityOfYear(this);
			break;
		default:
			break;
		}
	}

	/**
	 * Gas
	 */
	private void getDataOfGas() {
		switch (curTab) {
		case TAB_DAY:
			dataFloats = SmartHomeSharePreferents.getDataGasOfDay(this);
			break;
		case TAB_WEEK:
			dataFloats = SmartHomeSharePreferents.getDataGasOfWeek(this);
			break;
		case TAB_MONTH:
			dataFloats = SmartHomeSharePreferents.getDataGasOfMonth(this);
			break;
		case TAB_QUARTER:
			dataFloats = SmartHomeSharePreferents.getDataGasOfQuarter(this);
			break;
		case TAB_YEAR:
			dataFloats = SmartHomeSharePreferents.getDataGasOfYear(this);
			break;
		default:
			break;
		}
	}

	/**
	 * Water
	 */
	private void getDataOfWater() {
		switch (curTab) {
		case TAB_DAY:
			dataFloats = SmartHomeSharePreferents.getDataWaterOfDay(this);
			break;
		case TAB_WEEK:
			dataFloats = SmartHomeSharePreferents.getDataWaterOfWeek(this);
			break;
		case TAB_MONTH:
			dataFloats = SmartHomeSharePreferents.getDataWaterOfMonth(this);
			break;
		case TAB_QUARTER:
			dataFloats = SmartHomeSharePreferents.getDataWaterOfQuarter(this);
			break;
		case TAB_YEAR:
			dataFloats = SmartHomeSharePreferents.getDataWaterOfYear(this);
			break;
		default:
			break;
		}
	}

	/**
	 * get Ymin, Ymax
	 */
	private void sort() {
		List temp = Arrays.asList(ArrayUtils.toObject(dataFloats));
		yMax = Collections.max(temp);
		yMin = Collections.min(temp);
		if (yMax == 0) {
			yMax = 10;
		}
	}

	private void updateBackgroundButton(int id) {
		for (int i = 0; i < idButtons.length; i++) {
			if (idButtons[i] == id) {
				findViewById(id).setBackgroundDrawable(
						JDrawable.getJDrawable().fillRoundRectRadialGradient(
								new int[] { 0xFFEEEEEE, 0xFFEEEEEE, 0xFFCCCCCC,
										0xFFCCCCCC }));
			} else {
				findViewById(idButtons[i]).setBackgroundDrawable(
						JDrawable.getJDrawable().fillRoundRectRadialGradient(
								new int[] { 0xFFEEEEEE, 0xFFEEEEEE, 0xFF0099FF,
										0xFF0099FF }));
			}
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.myButtonDay:
			curTab = TAB_DAY;
			break;
		case R.id.myButtonWeek:
			curTab = TAB_WEEK;
			break;
		case R.id.myButtonMonth:
			curTab = TAB_MONTH;
			break;
		case R.id.myButtonQuarter:
			curTab = TAB_QUARTER;
			break;
		case R.id.myButtonYear:
			curTab = TAB_YEAR;
			break;
		default:
			curTab = TAB_DAY;
			break;
		}
		updateBackgroundButton(v.getId());
		updateGraph();
	}

	private void updateGraph() {
		graphicalView.removeAllViews();
		initGraphic();

	}

	@Override
	protected void onResume() {
		updateGraph();
		super.onResume();
	}
}
