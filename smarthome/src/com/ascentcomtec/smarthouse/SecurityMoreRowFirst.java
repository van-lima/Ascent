package com.ascentcomtec.smarthouse;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;

import com.ascentcomtec.smarthouse.ui.components.textview.JTextView;
import com.ascentcomtec.smarthouse.utils.Utils;

public class SecurityMoreRowFirst extends LinearLayout{
	
	public SecurityMoreRowFirst(Context context) {
		super(context);
	}

	public SecurityMoreRowFirst(Context context, final int width, final int height) {
		super(context);
		
		LinearLayout linearLayoutRoot = new LinearLayout(getContext());
		linearLayoutRoot.setLayoutParams(new LinearLayout.LayoutParams(width, height));
		linearLayoutRoot.setOrientation(LinearLayout.HORIZONTAL);
		LinearLayout.LayoutParams linLayoutParams = new LinearLayout.LayoutParams(width/3, height);
		
		LinearLayout linearLayoutColumnFirst  = new LinearLayout(getContext()){
 			final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
 			final int color[] = {0xFF666666, 0xFF666666, 0xFF666666};
			@Override
			protected void onDraw(Canvas canvas) {
 				super.onDraw(canvas);
 				for(int i = 0; i < 1 ; i++){
 					paint.setColor(color[i]);
 					canvas.drawLine(width/3 - i, 0, width/3 - i, height, paint);
 				}
			}
		};
		linearLayoutColumnFirst.setBackgroundColor(Color.TRANSPARENT);
		linearLayoutColumnFirst.setGravity(Gravity.CENTER);
		linearLayoutColumnFirst.setLayoutParams(linLayoutParams);
		linearLayoutColumnFirst.setOrientation(LinearLayout.VERTICAL);
		LinearLayout titleFirst = getTitleViewRightBorder("Temperature", R.drawable.detail, height, width/3);
		linearLayoutColumnFirst.addView(titleFirst);
		linearLayoutColumnFirst.addView(new ViewComponent(context, height, R.drawable.temperature_off, R.drawable.temperature_on));
		linearLayoutRoot.addView(linearLayoutColumnFirst);
		
		LinearLayout linearLayoutColumnSecond  = new LinearLayout(getContext()){
 			final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
 			final int color[] = {0xFF666666, 0xFF666666, 0xFF666666};
			@Override
			protected void onDraw(Canvas canvas) {
 				super.onDraw(canvas);
 				for(int i = 0; i < 1 ; i++){
 					paint.setColor(color[i]);
 					canvas.drawLine(width/3 - i, 0, width/3 - i, height, paint);
 				}
			}
		};
		linearLayoutColumnSecond.setBackgroundColor(Color.TRANSPARENT);
		linearLayoutColumnSecond.setLayoutParams(linLayoutParams);
		linearLayoutColumnSecond.setOrientation(LinearLayout.VERTICAL);
		LinearLayout titleSecond = getTitleViewRightBorder("Switch Control", R.drawable.detail, height, width/3);
		linearLayoutColumnSecond.addView(titleSecond);
		linearLayoutColumnSecond.addView(new ViewComponent(context, height, R.drawable.lock_off, R.drawable.lock_on));
		linearLayoutRoot.addView(linearLayoutColumnSecond);
		
		LinearLayout linearLayoutColumnThird  = new LinearLayout(getContext());
		linearLayoutColumnThird.setLayoutParams(linLayoutParams);
		linearLayoutColumnThird.setOrientation(LinearLayout.VERTICAL);
		LinearLayout titleSecondThird = getTitleView("Switch Control", R.drawable.detail, width/3);
		linearLayoutColumnThird.addView(titleSecondThird);
		linearLayoutColumnThird.addView(new ViewComponent(context, height, R.drawable.light_off, R.drawable.light_on));
		
		linearLayoutRoot.addView(linearLayoutColumnThird);
		
		addView(linearLayoutRoot);
	}
	/***
	 * 
	 * @return
	 */
	private LinearLayout getTitleView(String title , int id, final int width){
		 
		LinearLayout linearLayout = new LinearLayout(getContext());
		linearLayout.setPadding(5, 5, 5, 5);
		linearLayout.setOrientation(LinearLayout.HORIZONTAL);
		linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, Utils.convertDips2Pixel(45, getContext())));
		linearLayout.setBackgroundResource(R.drawable.title_bar);
		LinearLayout.LayoutParams layoutParamsColumn = new LinearLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.FILL_PARENT, 1);
		LinearLayout linearLayoutLeft = new LinearLayout(getContext());
		linearLayoutLeft.setGravity(Gravity.LEFT | Gravity.CENTER);
		linearLayoutLeft.setLayoutParams(layoutParamsColumn);
		JTextView jTextViewTitleControl = new JTextView(getContext());
		jTextViewTitleControl.setTextColor(0xFF000000);
		jTextViewTitleControl.setModeSubTitle(getContext());
		jTextViewTitleControl.setGravity(Gravity.CENTER);
		jTextViewTitleControl.setText(title);
		linearLayoutLeft.addView(jTextViewTitleControl);
		linearLayout.addView(linearLayoutLeft);
		LinearLayout linearLayoutRight = new LinearLayout(getContext());
		linearLayoutRight.setGravity(Gravity.RIGHT | Gravity.CENTER);
		linearLayoutRight.setLayoutParams(layoutParamsColumn);
		ImageView imageView = new ImageView(getContext());
		imageView.setImageResource(id);
		linearLayoutRight.addView(imageView);
		linearLayout.addView(linearLayoutRight);
		return linearLayout;
	}
	
	/**
	 * 
	 * @param title
	 * @param id
	 * @return
	 */
	public LinearLayout getTitleViewRightBorder(String title , int id, final int height, final int width){
		LinearLayout linearLayout = new LinearLayout(getContext()){
 			final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
 			final int color[] = {0xFF666666, 0xFF666666, 0xFF666666};
			@Override
			protected void onDraw(Canvas canvas) {
 				super.onDraw(canvas);
 				for(int i = 0; i < 1 ; i++){
 					paint.setColor(color[i]);
 					canvas.drawLine(width  - i, 0, width  - i, height, paint);
 				}
			}
		};
		linearLayout.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		linearLayout.setPadding(5, 5, 5, 5);
		linearLayout.setOrientation(LinearLayout.HORIZONTAL);
		linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, Utils.convertDips2Pixel(45, getContext())));
		linearLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.title_bar));
		LinearLayout.LayoutParams layoutParamsColumn = new LinearLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.FILL_PARENT, 1);
		LinearLayout linearLayoutLeft = new LinearLayout(getContext());
		linearLayoutLeft.setGravity(Gravity.LEFT | Gravity.CENTER);
		linearLayoutLeft.setLayoutParams(layoutParamsColumn);
		JTextView jTextViewTitleControl = new JTextView(getContext());
		jTextViewTitleControl.setTextColor(0xFF000000);
		jTextViewTitleControl.setModeSubTitle(getContext());
		jTextViewTitleControl.setGravity(Gravity.CENTER);
		jTextViewTitleControl.setText(title);
		linearLayoutLeft.addView(jTextViewTitleControl);
		linearLayout.addView(linearLayoutLeft);
		LinearLayout linearLayoutRight = new LinearLayout(getContext());
		linearLayoutRight.setGravity(Gravity.RIGHT | Gravity.CENTER);
		linearLayoutRight.setLayoutParams(layoutParamsColumn);
		ImageView imageView = new ImageView(getContext());
		imageView.setImageResource(id);
		linearLayoutRight.addView(imageView);
		linearLayout.addView(linearLayoutRight);
		return linearLayout;
	}
}
