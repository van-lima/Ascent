package com.setacinq.happiestbaby.ui.components.tab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.widget.RadioButton;
/**
 * Project name : HappiestBaby
 * Package name : com.setacinq.happiestbaby.ui.components.tab
 * File name    : Tabs.java
 * Create by    : longtq6195
 */
public class TabHot extends RadioButton {

	private float mX;
    private Context context;
    private int firstBackgroundColor;
    private int firstBorderColor;
    private int firstCheckedTextColor;
    private int firstUnCheckedTextColor;
    private int secondBackgroundColor;
    private int secondBorderColor;
    private int secondCheckedTextColor;
    private int secondUnCheckedTextColor;

	public TabHot(Context context) {
		super(context);
		this.context = context;
		this.firstBackgroundColor = 0xFFE83D91;
		this.firstBorderColor = 0xFFE83D91;
		this.firstCheckedTextColor = 0xFFFFFFFF;
		this.firstUnCheckedTextColor = 0xFFE83D91;
		
		this.secondBackgroundColor = 0xFF39B4C6;
		this.secondBorderColor = 0xFF39B4C6;
		this.secondCheckedTextColor = 0xFFFFFFFF;
		this.secondUnCheckedTextColor = 0xFF39B4C6;
	}
	
	public TabHot(Context context, int firstBackgroundColor, int firstBorderColor,
			int firstCheckedTextColor, int firstUnCheckedTextColor,
			int secondBackgroundColor, int secondBorderColor,
			int secondCheckedTextColor, int secondUnCheckedTextColor) {
		super(context);
		this.context = context;
		this.firstBackgroundColor = firstBackgroundColor;
		this.firstBorderColor = firstBorderColor;
		this.firstCheckedTextColor = firstCheckedTextColor;
		this.firstUnCheckedTextColor = firstUnCheckedTextColor;
		
		this.secondBackgroundColor = secondBackgroundColor;
		this.secondBorderColor = secondBorderColor;
		this.secondCheckedTextColor = secondCheckedTextColor;
		this.secondUnCheckedTextColor = secondUnCheckedTextColor;
	}

	@Override
	public void onDraw(Canvas canvas) {
		String text = this.getText().toString();
		Paint textPaint = new Paint();
		textPaint.setAntiAlias(true);
		float currentHeight = textPaint.measureText("X");
		textPaint.setTextSize(this.getTextSize());
		textPaint.setTextAlign(Paint.Align.CENTER);
		if (!isChecked()) {
			float[] outerRadii = new float[] { 6, 6, 6, 6, 0, 0, 0, 0 };
			ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(outerRadii, null, null));
			shapeDrawable.setBounds(1, this.getHeight() / 2 - this.getHeight()/ 6, this.getWidth() - 1, this.getHeight() + 1);
			shapeDrawable.getPaint().setStrokeWidth(2);
			if(getId() == 0){
				shapeDrawable.getPaint().setColor(firstBorderColor);	
				textPaint.setColor(firstUnCheckedTextColor);
			}else{
				shapeDrawable.getPaint().setColor(secondBorderColor);
				textPaint.setColor(secondUnCheckedTextColor);
			}
			shapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
			shapeDrawable.getPaint().setAntiAlias(true);
			shapeDrawable.getPaint().setFlags(Paint.ANTI_ALIAS_FLAG);
			shapeDrawable.draw(canvas);
		} else {
			float[] outerRadii = new float[] { 6, 6, 6, 6, 0, 0, 0, 0 };
			PaintDrawable paintDrawable = new PaintDrawable(Paint.ANTI_ALIAS_FLAG);
			if(getId() == 0){
				textPaint.setColor(firstCheckedTextColor);
				paintDrawable.getPaint().setColor(firstBackgroundColor);	
			}else{
				textPaint.setColor(secondCheckedTextColor);
				paintDrawable.getPaint().setColor(secondBackgroundColor);
			}
			paintDrawable.setBounds(0, this.getHeight() / 2 - this.getHeight() / 6, this.getWidth(), this.getHeight() + 1);
			paintDrawable.setShape(new RoundRectShape(outerRadii, null, null));
			paintDrawable.draw(canvas);
			
		}
		float h = (this.getHeight() / 2) + this.getHeight() / 6 + currentHeight;
		Typeface typeface = Typeface.createFromAsset(context.getAssets(),"fonts/helvetica_neue_bold.ttf");
 	    textPaint.setTypeface(typeface);
		canvas.drawText(text, mX, h, textPaint);
	}

	@Override
	protected void onSizeChanged(int w, int h, int ow, int oh) {
		super.onSizeChanged(w, h, ow, oh);
		mX = w * 0.5f; // remember the center of the screen
	}
}
