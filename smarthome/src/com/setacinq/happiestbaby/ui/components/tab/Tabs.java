package com.setacinq.happiestbaby.ui.components.tab;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
/**
 * Project name : HappiestBaby
 * Package name : com.setacinq.happiestbaby.ui.components.tab
 * File name    : Tabs.java
 * Create by    : longtq6195
 * Update date  : May 3, 2012 4:16:35 PM
 */
public class Tabs extends LinearLayout implements RadioGroup.OnCheckedChangeListener{
	
	private OnTabChangeListener onTabChangeListener;
	private LinearLayout contentViewLayout;
	private RadioGroup bottomRadioGroup;
	private List<String> titleList;
 	public static String CURRENT_TAB_INDEX;
	private Context context;
	private LinearLayout layoutSpace;
	private int firstSpaceColor;
	private int secondSpaceColor;
  	/***
  	 * 
  	 * @param context
  	 */
 	public Tabs(Context context) {
		super(context);
		this.context = context;
		initUI();
		this.firstSpaceColor = 0xFFE83D91;
		this.secondSpaceColor = 0xFF39B4C6;
	}
 	
 	/***
  	 * 
  	 * @param context
  	 */
 	public Tabs(Context context, int firstSpaceColor, int secondSpaceColor) {
		super(context);
		this.context = context;
		initUI();
		this.firstSpaceColor = firstSpaceColor;
		this.secondSpaceColor = secondSpaceColor;
	}
 	
    /**
     * 
     */
    public void initUI() {
    	RelativeLayout mainLayoutTab = new RelativeLayout(context);
    	RelativeLayout.LayoutParams mainLayoutParamsTab = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
    	mainLayoutTab.setLayoutParams(mainLayoutParamsTab);
		HorizontalScrollView horizontalScrollViewTabHot = new HorizontalScrollView(context);
		horizontalScrollViewTabHot.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		bottomRadioGroup = new RadioGroup(context);
		bottomRadioGroup.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		bottomRadioGroup.setOrientation(RadioGroup.HORIZONTAL);
		horizontalScrollViewTabHot.addView(bottomRadioGroup);
		LinearLayout layoutRadioGroup = new LinearLayout(context);
		layoutRadioGroup.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		layoutRadioGroup.setBackgroundColor(Color.WHITE);
		layoutRadioGroup.addView(horizontalScrollViewTabHot);
		layoutRadioGroup.setId(16);
		RelativeLayout.LayoutParams layoutParamsTabHot = new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		layoutParamsTabHot.addRule(RelativeLayout.CENTER_HORIZONTAL,RelativeLayout.TRUE);
		mainLayoutTab.addView(layoutRadioGroup, layoutParamsTabHot);
		
		layoutSpace = new LinearLayout(context);
		layoutSpace.setId(17);
		layoutSpace.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
    	RelativeLayout.LayoutParams relativeLayoutParamsSpace = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    	relativeLayoutParamsSpace.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE); 
		relativeLayoutParamsSpace.addRule(RelativeLayout.BELOW, 16);
		mainLayoutTab.addView(layoutSpace, relativeLayoutParamsSpace);
              
        contentViewLayout = new LinearLayout(context);
        contentViewLayout.setOrientation(LinearLayout.VERTICAL);
        contentViewLayout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		RelativeLayout.LayoutParams relativeLayoutParamsContentPane = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
		relativeLayoutParamsContentPane.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE); 
		relativeLayoutParamsContentPane.addRule(RelativeLayout.BELOW, 17);
		mainLayoutTab.addView(contentViewLayout, relativeLayoutParamsContentPane);
        addView(mainLayoutTab);
        bottomRadioGroup.setOnCheckedChangeListener(this);
        titleList	= new ArrayList<String>();  
     }
    /***
     * 
     */
	public void commit() {
		int[] id = new int[]{0x111,0x112,0x113,0x114,0x115};
		RadioGroup.LayoutParams buttonLayoutParams = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.FILL_PARENT,RadioGroup.LayoutParams.FILL_PARENT);
		buttonLayoutParams.setMargins(5, 0, 5, 0);
		for (int i = 0; i < titleList.size(); i++) {
 			TabHot tabButton = new TabHot(context);
			tabButton.setPadding(50, 0, 50, 0);
			tabButton.setText(titleList.get(i).toString());
			tabButton.setId(id[i]);
			tabButton.setGravity(Gravity.CENTER);
			bottomRadioGroup.addView(tabButton, i, buttonLayoutParams);
		}
 	}
	
	public void commit(int firstBackgroundColor, int firstBorderColor,
			int firstCheckedTextColor, int firstUnCheckedTextColor,
			int secondBackgroundColor, int secondBorderColor,
			int secondCheckedTextColor, int secondUnCheckedTextColor) {
		RadioGroup.LayoutParams buttonLayoutParams = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.FILL_PARENT,RadioGroup.LayoutParams.FILL_PARENT);
		buttonLayoutParams.setMargins(5, 0, 5, 0);
		for (int i = 0; i < titleList.size(); i++) {
			TabHot tabButton = new TabHot(context, firstBackgroundColor, 
					firstBorderColor, firstCheckedTextColor, firstUnCheckedTextColor,
					secondBackgroundColor, secondBorderColor, secondCheckedTextColor, secondUnCheckedTextColor);
			tabButton.setPadding(50, 0, 50, 0);
			tabButton.setText(titleList.get(i).toString());
			tabButton.setId(i);
			tabButton.setGravity(Gravity.CENTER);
			bottomRadioGroup.addView(tabButton, i, buttonLayoutParams);
		}
	}
    /**
     * 
     * @param title
     * @param view
     */
	public void addTab(String title) {
 		titleList.add(title);
	}
   /**
    * 
    */
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if(titleList.size() > 0){
			onTabChangeListener.onTabChanged(String.valueOf(checkedId));
		}
 	}
	
	public void setOnTabChangedListener(OnTabChangeListener onTabChangeListener){
		this.onTabChangeListener = onTabChangeListener;
	}
    /**
     * 
     * @param id
     * @param view
     */
	public void setContent(String id, View view) {
		layoutSpace.removeAllViews();
		if(Integer.parseInt(id) == 0){
			layoutSpace.addView(new Space(context, firstSpaceColor));
		}else{
			layoutSpace.addView(new Space(context, secondSpaceColor));
		}
 		contentViewLayout.removeAllViews();
 		view.setPadding(10, 10, 10, 10);
 		contentViewLayout.addView(view);
	}
    /***
     * 
     * @param index
     */
	public void setCurrentTab(int index) {
		if(titleList.size() > 0){
			bottomRadioGroup.check(index);
			onTabChangeListener.onTabChanged(String.valueOf(index));
		}
	}
    /**
     * 
     * @return
     */
	public int getCurrentTab() {
		return bottomRadioGroup.getCheckedRadioButtonId();
	}
    
   
}
