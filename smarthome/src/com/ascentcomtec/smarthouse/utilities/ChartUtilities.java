package com.ascentcomtec.smarthouse.utilities;

import java.util.ArrayList;
import java.util.List;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer.Orientation;

import android.graphics.Color;
import android.graphics.Paint.Align;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.ascentcomtec.smarthouse.R;
import com.ascentcomtec.smarthouse.ui.activities.AbstractActivity;
import com.ascentcomtec.smarthouse.ui.components.HAFormFactory;
import com.ascentcomtec.smarthouse.ui.components.button.JImageView;
import com.ascentcomtec.smarthouse.ui.components.textview.JTextView;
import com.ascentcomtec.smarthouse.ui.plaf.Style;

public class ChartUtilities extends HAFormFactory{

	@Override
	public void executeUI() {
		setTitle("Utilities");
		 
		LinearLayout linearLayoutRoot = new LinearLayout(getApplicationContext());
 		linearLayoutRoot.setOrientation(LinearLayout.VERTICAL);
		linearLayoutRoot.setLayoutParams(getLinearLayoutLayoutParams());

		LinearLayout linearLayoutRootFirst = new LinearLayout(getApplicationContext());
		linearLayoutRootFirst.setOrientation(LinearLayout.VERTICAL);
		linearLayoutRootFirst.setPadding(5, 5, 5, 5);
		linearLayoutRoot.addView(linearLayoutRootFirst);
		LinearLayout linearLayoutFirst = new LinearLayout(getApplicationContext());
		linearLayoutFirst.setBackgroundDrawable(getResources().getDrawable(R.drawable.b_e));
 		linearLayoutFirst.setGravity(Gravity.LEFT);
		linearLayoutFirst.setOrientation(LinearLayout.VERTICAL);
		linearLayoutFirst.setLayoutParams(new LinearLayout.LayoutParams(getWidth(), (getContentPaneHeight() - 20)/3));
		linearLayoutFirst.addView(getLinearLayout(0));
		linearLayoutRootFirst.addView(linearLayoutFirst);
	 
		LinearLayout linearLayoutRootSecond = new LinearLayout(getApplicationContext());
		linearLayoutRootSecond.setOrientation(LinearLayout.VERTICAL);
		linearLayoutRootSecond.setPadding(5, 0, 5, 5);
		linearLayoutRoot.addView(linearLayoutRootSecond);
		LinearLayout linearLayoutSecond = new LinearLayout(getApplicationContext());
 		linearLayoutSecond.setBackgroundDrawable(getResources().getDrawable(R.drawable.b_w));
		linearLayoutSecond.setGravity(Gravity.LEFT);
		linearLayoutSecond.setOrientation(LinearLayout.VERTICAL);
		linearLayoutSecond.setLayoutParams(new LinearLayout.LayoutParams(getWidth(), (getContentPaneHeight() - 20)/3));
		linearLayoutSecond.addView(getLinearLayout(1));
		linearLayoutRootSecond.addView(linearLayoutSecond);
		
		LinearLayout linearLayoutRootThird = new LinearLayout(getApplicationContext());
		linearLayoutRootThird.setOrientation(LinearLayout.VERTICAL);
		linearLayoutRootThird.setPadding(5, 0, 5, 5);
		linearLayoutRoot.addView(linearLayoutRootThird);
 		LinearLayout linearLayoutThird = new LinearLayout(getApplicationContext());
  		linearLayoutThird.setBackgroundDrawable(getResources().getDrawable(R.drawable.b_g));
 		linearLayoutThird.setLayoutParams(new LinearLayout.LayoutParams(getWidth(), (getContentPaneHeight() - 20)/3));
		linearLayoutThird.setGravity(Gravity.LEFT);
		linearLayoutThird.setOrientation(LinearLayout.VERTICAL);
		linearLayoutThird.addView(getLinearLayout(2));
		linearLayoutRootThird.addView(linearLayoutThird);
		
 		RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
 		relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT));
 		relativeLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.conten_bg));
		relativeLayout.addView(linearLayoutRoot);
  		getContentPane().addView(relativeLayout);
		
	}
	/***
	 * 
	 * @return
	 */
	private LinearLayout getLinearLayout(int id){
		
		String[] lable = new String[]{"Electricity(kWH)","Water(L)","Gas(MJh)"};
		int[] iconID   = new int[]{R.drawable.light_on, R.drawable.water, R.drawable.gas};
 		
		LinearLayout linearLayoutRoot = new LinearLayout(getApplicationContext());
 		linearLayoutRoot.setOrientation(LinearLayout.HORIZONTAL);
		linearLayoutRoot.setLayoutParams(getLinearLayoutLayoutParams());
		
		LinearLayout linearLayout = new LinearLayout(getApplicationContext());
		linearLayout.setOrientation(LinearLayout.VERTICAL);
 		linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		JTextView jTextView = new JTextView(getApplicationContext());
		jTextView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		jTextView.setGravity(Gravity.CENTER);
		jTextView.setTextColor(Color.BLACK);
		jTextView.setText(lable[id]);
		linearLayout.addView(jTextView);
 		JImageView imageViewE = new JImageView(getApplicationContext());
 		imageViewE.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		imageViewE.setImageResource(iconID[id]);
		linearLayout.addView(imageViewE);
		linearLayoutRoot.addView(linearLayout);
		
// 		ImageView imageViewC = new ImageView(getApplicationContext());
// 		imageViewC.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
// 		imageViewC.setImageResource(chartID[id]);
		final GraphicalView gv = createIntent(fakeData(id), colorsFake(id));
		gv.setLayoutParams(new LinearLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
 		linearLayoutRoot.addView(gv);
		return linearLayoutRoot;
	}
	
	private int[] colorsFake(int id){
		switch (id) {
		case 0:
			int[] colorsE = new int[] { Color.parseColor("#8B0000"), Color.parseColor("#DAA520")};
			return colorsE;
		case 1:
			int[] colorsW = new int[] { Color.parseColor("#00BFFF"), Color.parseColor("#00FFFF")};
			return colorsW;
		case 2:
			int[] colorsG = new int[] { Color.parseColor("#32CD32"), Color.parseColor("#00FF00")};
			return colorsG;
		default:
			int[] colors = new int[] { Color.parseColor("#32CD32"), Color.parseColor("#00FF00")};
			return colors;
		}
	}
	/***
	 * 
	 * @param id
	 * @return
	 */
	private List<double[]> fakeData(int id){
		switch (id) {
		case 0:
			List<double[]> valuesE = new ArrayList<double[]>();
			valuesE.add(new double[] { 4, 2.5, 2.5, 4, 1.8, 2.4, 1.4 });
			valuesE.add(new double[] { 3, 3.5, 4.4, 3.5, 1.5, 4.6, 2 });
			return valuesE;
		case 1:
			List<double[]> valuesW = new ArrayList<double[]>();
			valuesW.add(new double[] { 3, 2.5, 4.5, 4, 4.8, 2.4, 3.4 });
			valuesW.add(new double[] { 3.5, 3.5, 3.4, 3.5, 3.5, 4.6, 2 });
			return valuesW;
		case 2:
			List<double[]> valuesG = new ArrayList<double[]>();
			valuesG.add(new double[] { 2, 3.5, 2.5, 4, 4.8, 2.4, 2.4 });
			valuesG.add(new double[] { 3, 4.5, 3.4, 3.5, 3.5, 4.6, 2 });
			return valuesG;
		default:
			List<double[]> values = new ArrayList<double[]>();
			values.add(new double[] { 4, 2.5, 3.5, 4, 2.8, 3.4, 4.4 });
			values.add(new double[] { 3, 3.5, 4.4, 3.5, 1.5, 4.6, 2 });
			return values;
		}
	}
	/***
	 * 
	 */
	public LinearLayout.LayoutParams getLinearLayoutLayoutParams() {
		Style style = new Style(getApplicationContext());
		style.setMargin(10, 10, 10, 10);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(style.getMarginValue(AbstractActivity.LEFT), style.getMarginValue(AbstractActivity.TOP), style.getMarginValue(AbstractActivity.RIGHT), style.getMarginValue(AbstractActivity.BOTTOM));
		return layoutParams;
	}
	
	public GraphicalView createIntent(List<double[]> values, int[] colors) {
		//"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
		String[] titles = new String[] { "Current Usage", "Average Usage"};

		XYMultipleSeriesRenderer renderer = buildBarRenderer(colors);
		renderer.setShowGridX(true);
		renderer.setYLabelsPadding(10);
 		renderer.setOrientation(Orientation.HORIZONTAL);
		setChartSettings(renderer, "", "", "", 0.5,
				7.5, 0, 5, Color.BLACK, Color.BLACK);
		renderer.setXLabels(1);
		renderer.setYLabels(10);
		renderer.addXTextLabel(1, "Mon");
		renderer.addXTextLabel(2, "Tue");
		renderer.addXTextLabel(3, "Wed");
		renderer.addXTextLabel(4, "Thu");
		renderer.addXTextLabel(5, "Fri");
		renderer.addXTextLabel(6, "Sat");
		renderer.addXTextLabel(7, "Sun");
		int length = renderer.getSeriesRendererCount();
		for (int i = 0; i < length; i++) {
			SimpleSeriesRenderer seriesRenderer = renderer
					.getSeriesRendererAt(i);
			seriesRenderer.setDisplayChartValues(true);
		}

		final GraphicalView grfv = ChartFactory.getBarChartView(
				ChartUtilities.this, buildBarDataset(titles, values), renderer,
				Type.DEFAULT);

		return grfv;
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
			r.setChartValuesSpacing(15);
			renderer.addSeriesRenderer(r);
		}
		return renderer;
	}

	protected XYMultipleSeriesDataset buildBarDataset(String[] titles,
			List<double[]> values) {
		XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
		int length = titles.length;
		for (int i = 0; i < length; i++) {
			CategorySeries series = new CategorySeries(titles[i]);
			double[] v = values.get(i);
			int seriesLength = v.length;
			for (int k = 0; k < seriesLength; k++) {
				series.add(v[k]);
			}
			dataset.addSeries(series.toXYSeries());
		}
		return dataset;
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
}
