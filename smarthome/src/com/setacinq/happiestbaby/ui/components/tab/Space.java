/**
 * Copyright (c) 2012, SetaCinQ
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER
 */
package com.setacinq.happiestbaby.ui.components.tab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

/**
 * Space is a lightweight View subclass that may be used to create gaps between
 * components in general purpose layouts.
 * Create by    : longtq6195
 * Update date  : May 2, 2012 8:42:34 AM
 */
public class Space extends View {
	private int color = Color.RED;
	private int heightMeasureSpecs = 20;
	/**
	 * {@inheritDoc}
	 */
	public Space(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	/**
	 * {@inheritDoc}
	 */
	public Space(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	/**
	 * {@inheritDoc}
	 */
	public Space(Context context) {
		this(context, null);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(0, 0, 0, 0);
		setLayoutParams(layoutParams);
	}
	/**
	 * {@inheritDoc}
	 */
	public Space(Context context,int color) {
		this(context);
		this.color = color;
	}
	/**
	 * {@inheritDoc}
	 */
	public Space(Context context, int color, int heightMeasureSpecs) {
		this(context);
		this.color = color;
		this.heightMeasureSpecs = heightMeasureSpecs;
	}
	/**
	 * Draw nothing.
	 * 
	 * @param canvas
	 *            an unused parameter.
	 */
	@Override
	public void draw(Canvas canvas) {
		canvas.drawColor(Color.WHITE);
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		RectF rectF = new RectF();
		paint.setColor(color);
		rectF.set(0, 0, canvas.getWidth(), canvas.getHeight());
		canvas.drawRect(rectF, paint);
	}
 
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(widthMeasureSpec, heightMeasureSpecs);
	}
}