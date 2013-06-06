package com.ascentcomtec.smarthouse.ui.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class Space extends View {
	
	private int widthMeasureSpec;
	
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
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(getWidthMeasureSpec(), heightMeasureSpec);
	}

	public int getWidthMeasureSpec() {
		return widthMeasureSpec;
	}

	public void setWidthMeasureSpec(int widthMeasureSpec) {
		this.widthMeasureSpec = widthMeasureSpec;
	}
}
