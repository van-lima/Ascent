/**
 * Copyright (c) 2012, SetaCinQ
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER
 */
package com.ascentcomtec.smarthouse.ui.components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Space is a lightweight View subclass that may be used to create gaps between
 * components in general purpose layouts.
 * Create by    : longtq6195
 * Update date  : May 2, 2012 8:41:48 AM
 */
public class Lines extends View {
	/**
	 * {@inheritDoc}
	 */
	public Lines(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	/**
	 * {@inheritDoc}
	 */
	public Lines(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	/**
	 * {@inheritDoc}
	 */
	public Lines(Context context) {
		this(context, null);
	}
	/**
	 * 
	 */
	@Override
	public void draw(Canvas canvas) {
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		//canvas.drawColor(Color.WHITE);
		paint.setColor(0xFFDDDDDD);
		RectF rectF = new RectF();
		rectF.set(0, 0, canvas.getWidth(), 1);
		canvas.drawRect(rectF, paint);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(widthMeasureSpec,1);
	}
}