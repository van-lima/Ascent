//package com.ascentcomtec.smarthouse.ui.portlets.control;
//
//import android.content.Intent;
//import android.graphics.Color;
//import android.view.Gravity;
//import android.view.View;
//import android.widget.CompoundButton;
//import android.widget.CompoundButton.OnCheckedChangeListener;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.RelativeLayout;
//import android.widget.TableLayout;
//import android.widget.TableRow;
//
//import com.ascentcomtec.smarthouse.MainActivity;
//import com.ascentcomtec.smarthouse.R;
//import com.ascentcomtec.smarthouse.ui.activities.AbstractActivity;
//import com.ascentcomtec.smarthouse.ui.components.ActionBar;
//import com.ascentcomtec.smarthouse.ui.components.Font;
//import com.ascentcomtec.smarthouse.ui.components.FormFactory;
//import com.ascentcomtec.smarthouse.ui.components.button.JButton;
//import com.ascentcomtec.smarthouse.ui.components.button.JToggleButton;
//import com.ascentcomtec.smarthouse.ui.components.textview.JTextView;
//import com.ascentcomtec.smarthouse.ui.plaf.Style;
//import com.ascentcomtec.smarthouse.utils.Utils;
//
//public class Control extends FormFactory{
//	
//	private final int COLUMNSCONTROL   = 3;
//	private final int COLUMNSCONTROLs  = 2;
//  	
//	@Override
//	public void execute() {
//		ActionBar actionBar = new ActionBar(this);
//		actionBar.setText("Control");
// 		ImageView buttonBack = new ImageView(getApplicationContext());
// 		buttonBack.setImageResource(R.drawable.back);
//   		buttonBack.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View paramView) {
//				 finish();
//			}
//		});
//		actionBar.addControlActionBarLeft(buttonBack);
//		
//		LinearLayout menuBarControl = new LinearLayout(getApplicationContext());
//		menuBarControl.setGravity(Gravity.CENTER);
// 		
//		ImageView imageViewHelp = new ImageView(getApplicationContext());
//		imageViewHelp.setPadding(10, 0, 10, 0);
//  		imageViewHelp.setImageResource(R.drawable.help);
//  		imageViewHelp.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				showAlertDialog("Coming Soon !");
//			}
//		});
// 		menuBarControl.addView(imageViewHelp);
// 		
// 		ImageView imageViewSetting = new ImageView(getApplicationContext());
// 		imageViewSetting.setPadding(10, 0, 10, 0);
//  		imageViewSetting.setImageResource(R.drawable.setting);
//  		imageViewSetting.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				showAlertDialog("Coming Soon !");
// 			}
//		});
// 		menuBarControl.addView(imageViewSetting);
// 		
// 		ImageView imageViewHome = new ImageView(getApplicationContext());
// 		imageViewHome.setPadding(10, 0, 10, 0);
//  		imageViewHome.setImageResource(R.drawable.home);
//  		menuBarControl.addView(imageViewHome);
// 		imageViewHome.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				 Intent intentYWCAHome = new Intent(Control.this, MainActivity.class);
//				 intentYWCAHome.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//				 startActivity(intentYWCAHome);
//			}
//		});
// 		actionBar.addControlActionBarNext(menuBarControl);
// 		
// 		getTitleArea().addView(actionBar);
// 		
//		TableLayout tableLayoutFirst = new TableLayout(getApplicationContext());
//		TableLayout.LayoutParams tableLayoutLayoutParamsFirst = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,  270);
//		tableLayoutFirst.setLayoutParams(tableLayoutLayoutParamsFirst);
//		tableLayoutFirst.setStretchAllColumns(true);
//		tableLayoutFirst.setGravity(Gravity.TOP);
//		
//		TableRow tableRowFirst = new TableRow(getApplicationContext());
//		TableRow.LayoutParams layoutParamsTableRowFirst = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
//		layoutParamsTableRowFirst.column = COLUMNSCONTROLs;
//		tableRowFirst.setLayoutParams(layoutParamsTableRowFirst);
//		tableRowFirst.setGravity(Gravity.CENTER);
//		TableRow.LayoutParams layoutParamsColumnFirst = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
//		layoutParamsColumnFirst.setMargins(10, 10, 10, 10);
//		layoutParamsColumnFirst.span = COLUMNSCONTROLs;
//		
//		LinearLayout linearLayoutUpstairs = getCellUpstairs();
//		linearLayoutUpstairs.setLayoutParams(layoutParamsColumnFirst);
//		tableRowFirst.addView(linearLayoutUpstairs);
//		
//		TableRow.LayoutParams layoutParamsColumnSecond = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
//		layoutParamsColumnSecond.setMargins(10, 10, 10, 10);
//		layoutParamsColumnSecond.span = 4;
//		LinearLayout linearLayoutAirConditioning = getCellAirConditioning();
//		linearLayoutAirConditioning.setLayoutParams(layoutParamsColumnSecond);
//		tableRowFirst.addView(linearLayoutAirConditioning);
//		
//		tableLayoutFirst.addView(tableRowFirst);
//		
// 		//content
//		TableLayout tableLayout = new TableLayout(getApplicationContext());
//		TableLayout.LayoutParams tableLayoutLayoutParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT,  270);
//		tableLayout.setLayoutParams(tableLayoutLayoutParams);
//		tableLayout.setStretchAllColumns(true);
//		tableLayout.setGravity(Gravity.TOP);
//		
//		TableRow tableRow = new TableRow(getApplicationContext());
//		TableRow.LayoutParams layoutParamsTableRow = new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT,TableRow.LayoutParams.WRAP_CONTENT);
//		layoutParamsTableRow.column = COLUMNSCONTROL;
//		tableRow.setLayoutParams(layoutParamsTableRow);
//		tableRow.setGravity(Gravity.TOP);
//		
//		TableRow.LayoutParams layoutParamsColumn = new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT,TableRow.LayoutParams.WRAP_CONTENT);
//		layoutParamsColumn.setMargins(10, 10, 10, 10);
//		layoutParamsColumn.span = COLUMNSCONTROL;
//		
//		LinearLayout linearLayoutDownstairs = getCellDownstairsControl();
//		linearLayoutDownstairs.setLayoutParams(layoutParamsColumn);
//		tableRow.addView(linearLayoutDownstairs);
//		
//		LinearLayout linearLayoutPrinterOne = getCellPrinterOne();
//		linearLayoutPrinterOne.setLayoutParams(layoutParamsColumn);
//		tableRow.addView(linearLayoutPrinterOne);
//		
//		LinearLayout linearLayoutPrinterTwo = getCellPrinterTwo();
//		linearLayoutPrinterTwo.setLayoutParams(layoutParamsColumn);
//		tableRow.addView(linearLayoutPrinterTwo);
//	
//		tableLayout.addView(tableRow);
//		
//		LinearLayout row = new LinearLayout(getApplicationContext());
//		row.setOrientation(LinearLayout.VERTICAL);
//		row.addView(tableLayoutFirst);
//		row.addView(tableLayout);
//		
// 		RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
// 		relativeLayout.setBackgroundColor(Color.GRAY);
//		relativeLayout.addView(row);
// 		getContentPane().addView(relativeLayout);
//		
//		LinearLayout linearLayoutMenuBar = new LinearLayout(getApplicationContext());
//		Style style = new Style(getApplicationContext());
//		style.setMargin(0, 0, 0, 0);
//		style.setPadding(5, 5, 5, 5);
// 		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, Utils.convertDips2Pixel(30, getApplicationContext()));
//		layoutParams.setMargins(style.getMarginValue(AbstractActivity.LEFT),
//				style.getMarginValue(AbstractActivity.TOP),
//				style.getMarginValue(AbstractActivity.RIGHT),
//				style.getMarginValue(AbstractActivity.BOTTOM));
//		linearLayoutMenuBar.setLayoutParams(layoutParams);
//		linearLayoutMenuBar.setGravity(Gravity.CENTER);
//		// +++++++++++++ TOP COMPONENT: the header
//		RelativeLayout menuBar = new RelativeLayout(getApplicationContext());
//		menuBar.setPadding(style.getPaddingValue(AbstractActivity.LEFT),
//				style.getPaddingValue(AbstractActivity.TOP),
//				style.getPaddingValue(AbstractActivity.RIGHT),
//				style.getPaddingValue(AbstractActivity.BOTTOM));
//      	RelativeLayout.LayoutParams topParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//     	topParams.addRule(RelativeLayout.ALIGN_PARENT_TOP,RelativeLayout.TRUE);
//     	linearLayoutMenuBar.addView(menuBar,topParams);
//     	
//		RelativeLayout.LayoutParams layoutParamsTitleView = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//		layoutParamsTitleView.addRule(RelativeLayout.CENTER_IN_PARENT,RelativeLayout.TRUE);
//		JTextView jTextView = new JTextView(getApplicationContext());
//		jTextView.setModeTitle(getApplicationContext());
//		jTextView.setText("Powered By IP LIMA");
//		jTextView.setGravity(Gravity.CENTER);
// 		menuBar.addView(jTextView, layoutParamsTitleView);
// 		getMenuBar().addView(linearLayoutMenuBar);
//	}
//	/*
//	 * 
//	 */
//	public LinearLayout getCellAirConditioning(){
// 
//		LinearLayout linearLayout = new LinearLayout(getApplicationContext());
//		linearLayout.setPadding(10, 10, 10, 10);
//		linearLayout.setBackgroundResource(R.drawable.bb_03);
//		linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//		linearLayout.setOrientation(LinearLayout.VERTICAL);
//		linearLayout.addView(getCellTitle("Air Conditioning"));
//		
//		LinearLayout linearLayoutFirst = new LinearLayout(getApplicationContext());
//		linearLayoutFirst.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
//		linearLayoutFirst.setOrientation(LinearLayout.HORIZONTAL);
// 		
//		LinearLayout linearLayoutRowFirst = new LinearLayout(getApplicationContext());
//		linearLayoutRowFirst.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
//		linearLayoutRowFirst.setOrientation(LinearLayout.VERTICAL);
//
//		final ImageView conditioning = new ImageView(getApplicationContext());
//		conditioning.setImageResource(R.drawable.conditioning);
//		LinearLayout linearLayoutLable = new LinearLayout(getApplicationContext());
//		linearLayoutLable.setGravity(Gravity.CENTER);
// 		linearLayoutLable.setOrientation(LinearLayout.VERTICAL);
// 		JTextView textViewDate = new JTextView(getApplicationContext());
// 		textViewDate.setModeSubTitle(getApplicationContext());
//		textViewDate.setText("TODAY");
//		textViewDate.setLayoutParams(getLinearLayoutLayoutParamsRow());
//		linearLayoutLable.addView(textViewDate);
//		JTextView textViewPowerConsumption = new JTextView(getApplicationContext());
//		textViewPowerConsumption.setModeSubTitle(getApplicationContext());
//		textViewPowerConsumption.setText("5kWh");
//		textViewPowerConsumption.setLayoutParams(getLinearLayoutLayoutParamsRow());
//		linearLayoutLable.addView(textViewPowerConsumption);
//		JTextView textViewPrices = new JTextView(getApplicationContext());
//		textViewPrices.setModeSubTitle(getApplicationContext());
//		textViewPrices.setLayoutParams(getLinearLayoutLayoutParamsRow());
//		textViewPrices.setText("$1.00");
//		linearLayoutLable.addView(textViewPrices);
//		LinearLayout linearLayoutContent = new LinearLayout(getApplicationContext());
//		linearLayoutContent.setOrientation(LinearLayout.VERTICAL);
//		linearLayoutContent.addView(setRelativeLayoutLeft2Right(linearLayoutLable, conditioning));
//		LinearLayout linearLayoutOnOff = new LinearLayout(getApplicationContext());
//		linearLayoutOnOff.setLayoutParams(getLinearLayoutLayoutParamsRow());
//		JToggleButton upstairsLights = new JToggleButton(getApplicationContext(), R.drawable.switch_on, R.drawable.switch_off);
//		upstairsLights.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, Utils.convertDips2Pixel(40, getApplicationContext())));
//		upstairsLights.setOnCheckedChangeListener(new OnCheckedChangeListener() {
//			
//			@Override
//			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//				 if(isChecked){
//					 conditioning.setImageResource(R.drawable.conditioning_select);
//				 }else{
//					 conditioning.setImageResource(R.drawable.conditioning);
//				 }
//				
//			}
//		});
//		linearLayoutOnOff.addView(upstairsLights);
//		linearLayoutRowFirst.addView(linearLayoutContent);
//		linearLayoutRowFirst.addView(linearLayoutOnOff);
//		linearLayoutFirst.addView(linearLayoutRowFirst);
//		
//		LinearLayout linearLayoutRowSecond = new LinearLayout(getApplicationContext());
//		linearLayoutRowSecond.setGravity(Gravity.CENTER);
//		linearLayoutRowSecond.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
//		linearLayoutRowSecond.setOrientation(LinearLayout.HORIZONTAL);
//		linearLayoutRowSecond.addView(getFan());
//		linearLayoutRowSecond.addView(getTemp());
//		linearLayoutFirst.addView(linearLayoutRowSecond);
//		
//		linearLayout.addView(linearLayoutFirst);
//		
//		return linearLayout;
//	}
//	/**
//	 * 
//	 * @return
//	 */
//	private int fan = 0;
//	public LinearLayout getFan(){
//		LinearLayout linearLayout = new LinearLayout(getApplicationContext());
//		linearLayout.setGravity(Gravity.CENTER);
//		linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
//		linearLayout.setOrientation(LinearLayout.VERTICAL);
//		JButton fanSpeedUp = new JButton(getApplicationContext(), R.drawable.fan_speed_up, R.drawable.fan_speed_up);
// 		fanSpeedUp.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 40));
//		linearLayout.addView(fanSpeedUp);
//		final JTextView  textViewValue = new JTextView(getApplicationContext());
//		textViewValue.setTypeface(Font.createSystemFont(getApplicationContext(), Font.FACE_UTMCENTUR, Font.STYLE_BOLD, 16));
//		textViewValue.setTextSize(Font.getSize());
//		textViewValue.setGravity(Gravity.CENTER);
//		textViewValue.setText("0");
//		textViewValue.setTextSize(30);
//		linearLayout.addView(textViewValue);
//		JButton fanSpeedDown  = new JButton(getApplicationContext(), R.drawable.fan_speed_down, R.drawable.fan_speed_down);
//		fanSpeedDown.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 40));
// 		linearLayout.addView(fanSpeedDown);
//		JTextView  textViewLable = new JTextView(getApplicationContext());
//		textViewLable.setGravity(Gravity.CENTER);
//		textViewLable.setText("Fan Speed");
//		textViewLable.setModeSubTitle(getApplicationContext());
//		linearLayout.addView(textViewLable);
// 		fanSpeedUp.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				fan++;
//				if(fan <= 3){
//					textViewValue.setText(fan+ " ");
//				}else{
// 					fan = 3;
//				}
//				
//			}
//		});
// 		fanSpeedDown.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				fan--;
//				if(fan >= 0 ){
//					textViewValue.setText(fan+ " ");
//				}else{
// 					fan = 0;
//				}
//			}
//		});
//		return linearLayout;
//	}
//	/**
//	 * 
//	 * @return
//	 */
//	private int temp = 23;
//	public LinearLayout getTemp(){
//		LinearLayout linearLayout = new LinearLayout(getApplicationContext());
//		linearLayout.setGravity(Gravity.CENTER);
//		linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
//		linearLayout.setOrientation(LinearLayout.VERTICAL);
//		JButton fanTempUp    = new JButton(getApplicationContext(), R.drawable.temp_up, R.drawable.temp_up);
//		fanTempUp.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 40));
// 		linearLayout.addView(fanTempUp);
//		final JTextView  textViewValue = new JTextView(getApplicationContext());
//		textViewValue.setGravity(Gravity.CENTER);
//		textViewValue.setTypeface(Font.createSystemFont(getApplicationContext(), Font.FACE_UTMCENTUR, Font.STYLE_BOLD, 16));
//		textViewValue.setTextSize(Font.getSize());
//		textViewValue.setText("23°");
//		textViewValue.setTextSize(30);
//		linearLayout.addView(textViewValue);
//		JButton fanTempDown  = new JButton(getApplicationContext(), R.drawable.temp_down, R.drawable.temp_down);
//		fanTempDown.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 40));
// 		linearLayout.addView(fanTempDown);
//		JTextView  textViewLable = new JTextView(getApplicationContext());
//		textViewLable.setGravity(Gravity.CENTER);
//		textViewLable.setText("Temp");
//		textViewLable.setModeSubTitle(getApplicationContext());
//		linearLayout.addView(textViewLable);
//		fanTempUp.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				temp += 1;
//				textViewValue.setText(Math.min(temp, 100)+ "°");
//			}
//		});
//		fanTempDown.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				temp -= 1;
//				textViewValue.setText(Math.max(temp, 0)+ "°");
//			}
//		});
//		return linearLayout;
//	}
//	/***
//	 * 
//	 * @return
//	 */
//	public LinearLayout getCellUpstairs(){
//		LinearLayout linearLayout = new LinearLayout(getApplicationContext());
// 		linearLayout.setPadding(10, 10, 10, 10);
//		linearLayout.setBackgroundResource(R.drawable.bb_03);
//		linearLayout.setOrientation(LinearLayout.VERTICAL);
//		linearLayout.addView(getCellTitle("Upstairs Lights"));
//		
//		final ImageView imageView = new ImageView(getApplicationContext());
//		imageView.setImageResource(R.drawable.lights_off);
//		LinearLayout linearLayoutLable = new LinearLayout(getApplicationContext());
//		linearLayoutLable.setGravity(Gravity.RIGHT);
// 		linearLayoutLable.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
// 		linearLayoutLable.setOrientation(LinearLayout.VERTICAL);
//		JTextView textViewDate = new JTextView(getApplicationContext());
//		textViewDate.setGravity(Gravity.RIGHT);
//		textViewDate.setLayoutParams(getLinearLayoutLayoutParamsRow());
//		textViewDate.setModeSubTitle(getApplicationContext());
// 		textViewDate.setText("TODAY");
//		linearLayoutLable.addView(textViewDate);
//		JTextView textViewPowerConsumption = new JTextView(getApplicationContext());
//		textViewPowerConsumption.setModeSubTitle(getApplicationContext());
//		textViewPowerConsumption.setGravity(Gravity.RIGHT);
//		textViewPowerConsumption.setLayoutParams(getLinearLayoutLayoutParamsRow());
//		textViewPowerConsumption.setText("5kWh");
//		linearLayoutLable.addView(textViewPowerConsumption);
//		JTextView textViewPrices = new JTextView(getApplicationContext());
//		textViewPrices.setModeSubTitle(getApplicationContext());
//		textViewPrices.setGravity(Gravity.RIGHT);
//		textViewPrices.setLayoutParams(getLinearLayoutLayoutParamsRow());
//		textViewPrices.setText("$1.00");
//		linearLayoutLable.addView(textViewPrices);
//		linearLayout.addView(setRelativeLayoutLeft2Right(imageView, linearLayoutLable));
//		
//		LinearLayout linearLayoutOnOff = new LinearLayout(getApplicationContext());
//		linearLayoutOnOff.setLayoutParams(getLinearLayoutLayoutParamsRow());
//		JToggleButton upstairsLights = new JToggleButton(getApplicationContext(), R.drawable.switch_on, R.drawable.switch_off);
//		upstairsLights.setOnCheckedChangeListener(new OnCheckedChangeListener() {
//			
//			@Override
//			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//				 if(isChecked){
//					 imageView.setImageResource(R.drawable.lights_on);
//				 }else{
//					 imageView.setImageResource(R.drawable.lights_off);
//				 }
//				
//			}
//		});
//		upstairsLights.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, Utils.convertDips2Pixel(40, getApplicationContext())));
// 		linearLayoutOnOff.addView(upstairsLights);
//		linearLayout.addView(linearLayoutOnOff);
//		
//		return linearLayout;
//	}
//	/***
//	 * Printer One
//	 * @return
//	 */
//	public LinearLayout getCellPrinterOne(){
//		LinearLayout linearLayout = new LinearLayout(getApplicationContext());
// 		linearLayout.setPadding(10, 10, 10, 10);
//		linearLayout.setBackgroundResource(R.drawable.bb_03);
//		linearLayout.setOrientation(LinearLayout.VERTICAL);
//		linearLayout.addView(getCellTitle("Printer One"));
//		
//		final ImageView imageView = new ImageView(getApplicationContext());
//		imageView.setImageResource(R.drawable.printer_off);
//		LinearLayout linearLayoutLable = new LinearLayout(getApplicationContext());
//		linearLayoutLable.setGravity(Gravity.RIGHT);
// 		linearLayoutLable.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
// 		linearLayoutLable.setOrientation(LinearLayout.VERTICAL);
//		JTextView textViewDate = new JTextView(getApplicationContext());
//		textViewDate.setGravity(Gravity.RIGHT);
//		textViewDate.setLayoutParams(getLinearLayoutLayoutParamsRow());
//		textViewDate.setModeTitle(getApplicationContext());
// 		textViewDate.setText("TODAY");
//		linearLayoutLable.addView(textViewDate);
//		JTextView textViewPowerConsumption = new JTextView(getApplicationContext());
//		textViewPowerConsumption.setModeSubTitle(getApplicationContext());
//		textViewPowerConsumption.setGravity(Gravity.RIGHT);
//		textViewPowerConsumption.setLayoutParams(getLinearLayoutLayoutParamsRow());
//		textViewPowerConsumption.setText("5kWh");
//		linearLayoutLable.addView(textViewPowerConsumption);
//		JTextView textViewPrices = new JTextView(getApplicationContext());
//		textViewPrices.setModeSubTitle(getApplicationContext());
//		textViewPrices.setGravity(Gravity.RIGHT);
//		textViewPrices.setLayoutParams(getLinearLayoutLayoutParamsRow());
//		textViewPrices.setText("$1.00");
//		linearLayoutLable.addView(textViewPrices);
//		linearLayout.addView(setRelativeLayoutLeft2Right(imageView, linearLayoutLable));
//		
//		LinearLayout linearLayoutPrinterOne = new LinearLayout(getApplicationContext());
//		linearLayoutPrinterOne.setLayoutParams(getLinearLayoutLayoutParamsRow());
//		JToggleButton printerOne = new JToggleButton(getApplicationContext(), R.drawable.switch_on, R.drawable.switch_off);
//		printerOne.setOnCheckedChangeListener(new OnCheckedChangeListener() {
//			
//			@Override
//			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//				 if(isChecked){
//					 imageView.setImageResource(R.drawable.printer_on);
//				 }else{
//					 imageView.setImageResource(R.drawable.printer_off);
//				 }
//				
//			}
//		});
//		printerOne.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, Utils.convertDips2Pixel(40, getApplicationContext())));
//		linearLayoutPrinterOne.addView(printerOne);
//		linearLayout.addView(linearLayoutPrinterOne);
//		
//		return linearLayout;
//	}
//	/***
//	 * Printer Two
//	 * @return
//	 */
//	public LinearLayout getCellPrinterTwo(){
//		LinearLayout linearLayout = new LinearLayout(getApplicationContext());
// 		linearLayout.setPadding(10, 10, 10, 10);
//		linearLayout.setBackgroundResource(R.drawable.bb_03);
//		linearLayout.setOrientation(LinearLayout.VERTICAL);
//		linearLayout.addView(getCellTitle("Printer Two"));
//		
//		final ImageView imageView = new ImageView(getApplicationContext());
//		imageView.setImageResource(R.drawable.printer_off);
//		LinearLayout linearLayoutLable = new LinearLayout(getApplicationContext());
//		linearLayoutLable.setGravity(Gravity.RIGHT);
// 		linearLayoutLable.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
// 		linearLayoutLable.setOrientation(LinearLayout.VERTICAL);
//		JTextView textViewDate = new JTextView(getApplicationContext());
//		textViewDate.setGravity(Gravity.RIGHT);
//		textViewDate.setLayoutParams(getLinearLayoutLayoutParamsRow());
//		textViewDate.setModeTitle(getApplicationContext());
// 		textViewDate.setText("TODAY");
//		linearLayoutLable.addView(textViewDate);
//		JTextView textViewPowerConsumption = new JTextView(getApplicationContext());
//		textViewPowerConsumption.setModeSubTitle(getApplicationContext());
//		textViewPowerConsumption.setGravity(Gravity.RIGHT);
//		textViewPowerConsumption.setLayoutParams(getLinearLayoutLayoutParamsRow());
//		textViewPowerConsumption.setText("5kWh");
//		linearLayoutLable.addView(textViewPowerConsumption);
//		JTextView textViewPrices = new JTextView(getApplicationContext());
//		textViewPrices.setModeSubTitle(getApplicationContext());
//		textViewPrices.setGravity(Gravity.RIGHT);
//		textViewPrices.setLayoutParams(getLinearLayoutLayoutParamsRow());
//		textViewPrices.setText("$1.00");
//		linearLayoutLable.addView(textViewPrices);
//		linearLayout.addView(setRelativeLayoutLeft2Right(imageView, linearLayoutLable));
//		
//		LinearLayout linearLayoutPrinterTwo = new LinearLayout(getApplicationContext());
//		linearLayoutPrinterTwo.setLayoutParams(getLinearLayoutLayoutParamsRow());
//		JToggleButton printerTwo = new JToggleButton(getApplicationContext(), R.drawable.switch_on, R.drawable.switch_off);
//		printerTwo.setOnCheckedChangeListener(new OnCheckedChangeListener() {
//			
//			@Override
//			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//				 if(isChecked){
//					 imageView.setImageResource(R.drawable.printer_on);
//				 }else{
//					 imageView.setImageResource(R.drawable.printer_off);
//				 }
//				
//			}
//		});
//		printerTwo.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, Utils.convertDips2Pixel(40, getApplicationContext())));
//		linearLayoutPrinterTwo.addView(printerTwo);
//		linearLayout.addView(linearLayoutPrinterTwo);
//		
//		return linearLayout;
//	}
//	/***
//	 * Downstairs Lights
//	 * @return
//	 */
//	public LinearLayout getCellDownstairsControl(){
//		LinearLayout linearLayout = new LinearLayout(getApplicationContext());
// 		linearLayout.setPadding(10, 10, 10, 10);
//		linearLayout.setBackgroundResource(R.drawable.bb_03);
//		linearLayout.setOrientation(LinearLayout.VERTICAL);
//		linearLayout.addView(getCellTitle("Downstairs Lights"));
//		
//		final ImageView imageView = new ImageView(getApplicationContext());
//		imageView.setImageResource(R.drawable.lights_off);
//		LinearLayout linearLayoutLable = new LinearLayout(getApplicationContext());
//		linearLayoutLable.setGravity(Gravity.RIGHT);
// 		linearLayoutLable.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
// 		linearLayoutLable.setOrientation(LinearLayout.VERTICAL);
//		JTextView textViewDate = new JTextView(getApplicationContext());
//		textViewDate.setGravity(Gravity.RIGHT);
//		textViewDate.setLayoutParams(getLinearLayoutLayoutParamsRow());
//		textViewDate.setModeTitle(getApplicationContext());
// 		textViewDate.setText("TODAY");
//		linearLayoutLable.addView(textViewDate);
//		JTextView textViewPowerConsumption = new JTextView(getApplicationContext());
//		textViewPowerConsumption.setModeSubTitle(getApplicationContext());
//		textViewPowerConsumption.setGravity(Gravity.RIGHT);
//		textViewPowerConsumption.setLayoutParams(getLinearLayoutLayoutParamsRow());
//		textViewPowerConsumption.setText("5kWh");
//		linearLayoutLable.addView(textViewPowerConsumption);
//		JTextView textViewPrices = new JTextView(getApplicationContext());
//		textViewPrices.setModeSubTitle(getApplicationContext());
//		textViewPrices.setGravity(Gravity.RIGHT);
//		textViewPrices.setLayoutParams(getLinearLayoutLayoutParamsRow());
//		textViewPrices.setText("$1.00");
//		linearLayoutLable.addView(textViewPrices);
//		linearLayout.addView(setRelativeLayoutLeft2Right(imageView, linearLayoutLable));
//		
//		LinearLayout linearLayoutDownstairsLights = new LinearLayout(getApplicationContext());
//		linearLayoutDownstairsLights.setLayoutParams(getLinearLayoutLayoutParamsRow());
//		JToggleButton downstairsLights = new JToggleButton(getApplicationContext(), R.drawable.switch_on, R.drawable.switch_off);
//		downstairsLights.setOnCheckedChangeListener(new OnCheckedChangeListener() {
//			
//			@Override
//			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//				 if(isChecked){
//					 imageView.setImageResource(R.drawable.lights_on);
//				 }else{
//					 imageView.setImageResource(R.drawable.lights_off);
//				 }
//				
//			}
//		});
//		downstairsLights.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, Utils.convertDips2Pixel(40, getApplicationContext())));
//		linearLayoutDownstairsLights.addView(downstairsLights);
//		linearLayout.addView(linearLayoutDownstairsLights);
//		
//		return linearLayout;
//	}
//	/**
//	 * 
//	 * @return
//	 */
//	public LinearLayout getCellTitle(String string){
//		LinearLayout linearLayoutTitle = new LinearLayout(getApplicationContext());
//		JTextView textViewTitle = new JTextView(getApplicationContext());
// 		textViewTitle.setTextColor(0xFF000000);
// 		textViewTitle.setModeSubTitle(getApplicationContext());
//		textViewTitle.setText(string);
//		JButton buttonMore = new JButton(getApplicationContext(), R.drawable.more, R.drawable.more);
//  		buttonMore.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				showAlertDialog("Coming Soon !");
//			}
//		});
//		linearLayoutTitle.addView(setRelativeLayoutRight2Left(textViewTitle, buttonMore, 35));
// 		return linearLayoutTitle;
//	}
//	/**
//	 * 
//	 * @return
//	 */
//	public RelativeLayout setRelativeLayoutRight2Left(View left, View right, int height) {
//		left.setId(11);
//		right.setId(22);
//		RelativeLayout relativeLayoutControl = new RelativeLayout(getApplicationContext());
//		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
// 		relativeLayoutControl.setLayoutParams(layoutParams);
//		
// 		RelativeLayout.LayoutParams relativeLayoutLayoutParamsLeft = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//		relativeLayoutLayoutParamsLeft.addRule(RelativeLayout.ALIGN_PARENT_LEFT,RelativeLayout.TRUE);
//		relativeLayoutLayoutParamsLeft.addRule(RelativeLayout.CENTER_VERTICAL,RelativeLayout.TRUE);
//		relativeLayoutLayoutParamsLeft.addRule(RelativeLayout.LEFT_OF,22);	
// 		left.setLayoutParams(relativeLayoutLayoutParamsLeft);
//		
//		RelativeLayout.LayoutParams relativeLayoutLayoutParamsRight = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, height);
//		relativeLayoutLayoutParamsRight.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
//		relativeLayoutLayoutParamsRight.addRule(RelativeLayout.CENTER_VERTICAL,RelativeLayout.TRUE);	
// 		right.setLayoutParams(relativeLayoutLayoutParamsRight);
// 		
// 		relativeLayoutControl.addView(left);
// 		relativeLayoutControl.addView(right);
// 		
//		return relativeLayoutControl;
//	}
//	/**
//	 * 
//	 * @return
//	 */
//	public RelativeLayout setRelativeLayoutRight2Left(View left, View right) {
//		left.setId(11);
//		right.setId(22);
//		RelativeLayout relativeLayoutControl = new RelativeLayout(getApplicationContext());
//		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
// 		relativeLayoutControl.setLayoutParams(layoutParams);
//		
// 		RelativeLayout.LayoutParams relativeLayoutLayoutParamsLeft = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//		relativeLayoutLayoutParamsLeft.addRule(RelativeLayout.ALIGN_PARENT_LEFT,RelativeLayout.TRUE);
//		relativeLayoutLayoutParamsLeft.addRule(RelativeLayout.CENTER_VERTICAL,RelativeLayout.TRUE);
//		relativeLayoutLayoutParamsLeft.addRule(RelativeLayout.LEFT_OF,22);	
// 		left.setLayoutParams(relativeLayoutLayoutParamsLeft);
//		
//		RelativeLayout.LayoutParams relativeLayoutLayoutParamsRight = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//		relativeLayoutLayoutParamsRight.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
//		relativeLayoutLayoutParamsRight.addRule(RelativeLayout.CENTER_VERTICAL,RelativeLayout.TRUE);	
// 		right.setLayoutParams(relativeLayoutLayoutParamsRight);
// 		
// 		relativeLayoutControl.addView(left);
// 		relativeLayoutControl.addView(right);
// 		
//		return relativeLayoutControl;
//	}
//	/**
//	 * 
//	 * @return
//	 */
//	public RelativeLayout setRelativeLayoutLeft2Right(View left, View right) {
//		left.setId(1);
//		right.setId(2);
//		RelativeLayout relativeLayoutControl = new RelativeLayout(getApplicationContext());
//		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
// 		relativeLayoutControl.setLayoutParams(layoutParams);
//		
// 		RelativeLayout.LayoutParams relativeLayoutLayoutParamsLeft = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//		relativeLayoutLayoutParamsLeft.addRule(RelativeLayout.ALIGN_PARENT_LEFT,RelativeLayout.TRUE);
//		relativeLayoutLayoutParamsLeft.addRule(RelativeLayout.CENTER_VERTICAL,RelativeLayout.TRUE);
//		
//		left.setLayoutParams(relativeLayoutLayoutParamsLeft);
//		
//		RelativeLayout.LayoutParams relativeLayoutLayoutParamsRight = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//		relativeLayoutLayoutParamsRight.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
//		relativeLayoutLayoutParamsRight.addRule(RelativeLayout.CENTER_VERTICAL,RelativeLayout.TRUE);	
//		relativeLayoutLayoutParamsRight.addRule(RelativeLayout.RIGHT_OF, 1);
// 		right.setLayoutParams(relativeLayoutLayoutParamsRight);
// 		
// 		relativeLayoutControl.addView(left);
// 		relativeLayoutControl.addView(right);
// 		
//		return relativeLayoutControl;
//	}
//}
//
