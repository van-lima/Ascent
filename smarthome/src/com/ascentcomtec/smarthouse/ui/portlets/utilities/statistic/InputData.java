package com.ascentcomtec.smarthouse.ui.portlets.utilities.statistic;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.ascentcomtec.smarthouse.R;
import com.ascentcomtec.smarthouse.ui.activities.AbstractActivity;
import com.ascentcomtec.smarthouse.ui.components.ActionBar;
import com.ascentcomtec.smarthouse.ui.components.FormFactory;
import com.ascentcomtec.smarthouse.ui.components.button.JButton;
import com.ascentcomtec.smarthouse.ui.plaf.Style;
import com.resolutiondev.ui.drawable.JDrawable;
import com.setacinq.happiestbaby.ui.components.tab.OnTabChangeListener;
import com.setacinq.happiestbaby.ui.components.tab.Tabs;
/***
 * 
 * @author longtq
 *
 */
public class InputData extends FormFactory{
    
//	private AlertDialog alert;
	
	private final byte ELECTRICITY = 0;
	private final byte GAS = 1;
	private final byte WATER = 2;
    private JFormInputData jFormInputData;
    private byte inputType = ELECTRICITY;//
    
    private Tabs tab;
    
	@Override
	public void execute() {
		
		Bundle bundle = getIntent().getExtras();
		if (bundle!=null) {
			inputType = bundle.getByte("TYPE");
		}
		ActionBar actionBar = new ActionBar(this);
		actionBar.setText("Input Data Usage");
 		JButton buttonBack = new JButton(getApplicationContext());
 		buttonBack.setBackgroundDrawable(getResources().getDrawable(R.drawable.back));
     	buttonBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View paramView) {
				 finish();
			}
		});
		RelativeLayout.LayoutParams layoutParamsButtonBack =  new RelativeLayout.LayoutParams(90, 40);//LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutParamsButtonBack.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
		layoutParamsButtonBack.addRule(RelativeLayout.CENTER_IN_PARENT,RelativeLayout.TRUE);
   		actionBar.addControlActionBarLeft(buttonBack, layoutParamsButtonBack);
 		JButton buttonSave = new JButton(getApplicationContext());
 		buttonSave.setTextColor(Color.BLACK);
 		buttonSave.setPadding(7, 0, 7, 0);
 		buttonSave.setText("Save Data");
 		buttonSave.setBackgroundDrawable(JDrawable.getJDrawable().fillRoundRectRadialGradient(new int[]{0xFFEEEEEE, 0xFFEEEEEE, 0xFFCCCCCC, 0xFFCCCCCC}));
 		buttonSave.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View paramView) {
				//@Ducv
				jFormInputData.saveData(inputType, tab.getCurrentTab());
				finish();
			}
		});
 		actionBar.addControlActionBarNext(buttonSave);
 		getTitleArea().addView(actionBar);
 		LinearLayout linearLayoutRoot = new LinearLayout(getApplicationContext());
		linearLayoutRoot.setOrientation(LinearLayout.VERTICAL);
		linearLayoutRoot.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
// 		JButton jButtonStartDate = new JButton(getApplicationContext());
// 		jButtonStartDate.setPadding(7, 0, 7, 0);
// 		jButtonStartDate.setLayoutParams(getLinearLayoutLayoutParams());
//  	jButtonStartDate.setTextColor(0xFFFFFFFF);
// 		jButtonStartDate.setTypeface(Font.createSystemFont(getApplicationContext(), Font.FACE_UTMCENTUR, Font.STYLE_BOLD, Font.SIZE_SMALL));
// 		jButtonStartDate.setTextSize(Font.getSize());
// 		jButtonStartDate.setText("Select Start Date");
// 		jButtonStartDate.setBackgroundDrawable(JDrawable.getJDrawable().fillRoundRectRadialGradient(new int[]{0xFF9121A2, 0xFF9A04B1, 0xFF9A04B1, 0xFF9A04B1}));
// 		jButtonStartDate.setOnClickListener(listenerDate);
// 		linearLayoutRoot.addView(jButtonStartDate);
		jFormInputData = new JFormInputData(getApplicationContext());
		jFormInputData.setLayoutParams(new LinearLayout.LayoutParams(getWidth(), LinearLayout.LayoutParams.FILL_PARENT));
 		tab = new Tabs(getApplicationContext());
        tab.addTab("Day");
        tab.addTab("Week");
        tab.addTab("Month");
        tab.addTab("Quarter");
        tab.addTab("Year");
        tab.commit();
        tab.setOnTabChangedListener(new OnTabChangeListener() {
			@Override
			public void onTabChanged(String tabId) {
				int intTabID = Integer.parseInt(tabId);
					switch (intTabID) {
						case 0x111:
							tab.setContent(tabId, jFormInputData.setAdapter(getWidth(), 0x111,inputType));
	 						break;
						case 0x112:
							tab.setContent(tabId, jFormInputData.setAdapter(getWidth(), 0x112,inputType));
	 						break;
						case 0x113:
							tab.setContent(tabId, jFormInputData.setAdapter(getWidth(), 0x113,inputType));
	 						break;
						case 0x114:
							tab.setContent(tabId, jFormInputData.setAdapter(getWidth(), 0x114,inputType));
	 						break;
						case 0x115:
							tab.setContent(tabId, jFormInputData.setAdapter(getWidth(), 0x115,inputType));
	 						break;
						default:
							tab.setContent(tabId, jFormInputData.setAdapter(getWidth(), 0x111,inputType));
	 						break;
				}
			}
		});
        tab.setCurrentTab(0x111);
        linearLayoutRoot.addView(tab);
// 		LinearLayout linearLayoutFormInputData = new LinearLayout(getApplicationContext());
// 		linearLayoutFormInputData.setOrientation(LinearLayout.VERTICAL);
// 		linearLayoutFormInputData.setLayoutParams(getLinearLayoutLayoutParams());
// 		linearLayoutFormInputData.addView(jFormInputData);
//		linearLayoutRoot.addView(linearLayoutFormInputData);
//		jFormInputData.setAdapter(getWidth(), 0);
		
 		RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
 		relativeLayout.setBackgroundColor(Color.GRAY);
 		ScrollView scrollView = new ScrollView(getApplicationContext());
 		scrollView.addView(linearLayoutRoot);
		relativeLayout.addView(scrollView);
  		getContentPane().addView(relativeLayout);
 	}
	
//	OnClickListener listenerDate = new OnClickListener() {
//
//        @Override
//        public void onClick(View arg0) {
//        	showDialogButtonClick(new InputData.OnSelectItem() {
//				
//				@Override
//				public void getItem(int id, String name) {
// 					switch (id) {
//						case 0:
//							jFormInputData.setAdapter(getWidth(), id);
//							alert.cancel();
//							break;
//						case 1:
//							jFormInputData.setAdapter(getWidth(), id);
//							alert.cancel();
//							break;
//						case 2:
//							jFormInputData.setAdapter(getWidth(), id);
//							alert.cancel();
//							break;
//						case 3:
//							jFormInputData.setAdapter(getWidth(), id);
//							alert.cancel();
//							break;
//						case 4:
//							jFormInputData.setAdapter(getWidth(), id);
//							alert.cancel();
//							break;
//						default:
//							alert.cancel();
//							break;
//					}
//				}
//			});
//        }
//    };
    
//	private void showDialogButtonClick(final OnSelectItem onSelectItem) {
//		AlertDialog.Builder builder = new AlertDialog.Builder(InputData.this);
//		builder.setTitle("Show dialog");
//
//		final CharSequence[] choiceList = { "Day", "Week", "Month", "Quarter" ,"Year"};
//
//		int selected = -1; // does not select anything
//
//		builder.setSingleChoiceItems(choiceList, selected,
//				new DialogInterface.OnClickListener() {
//
//					@Override
//					public void onClick(DialogInterface dialog, int which) {
// 						onSelectItem.getItem(which, choiceList[which].toString());
//					}
//				});
//		alert = builder.create();
//		alert.show();
//	}
	
	interface OnSelectItem {
		
		public void getItem(int id, String name);
		
	}
	
	/***
	 * get layout params for screen title
	 * 
	 * @return
	 */
	public LinearLayout.LayoutParams getLinearLayoutLayoutParams() {
		Style style = new Style(getApplicationContext());
		style.setMargin(20, 20, 20, 20);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(style.getMarginValue(AbstractActivity.LEFT), style.getMarginValue(AbstractActivity.TOP), style.getMarginValue(AbstractActivity.RIGHT), style.getMarginValue(AbstractActivity.BOTTOM));
		return layoutParams;
	}
}
