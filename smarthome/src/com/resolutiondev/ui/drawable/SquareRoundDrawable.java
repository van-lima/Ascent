package com.resolutiondev.ui.drawable;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
/**
 * 
 * Create by    : longtq6195
 *
 */
public class SquareRoundDrawable extends ShapeDrawable{
	
	private final Paint fillpaint;
	private final Paint strokepaint;
	/***
	 * 
	 */
	public SquareRoundDrawable(){
		this(Color.WHITE, 0xFFF168A6, 3);
	}

	/** 
	 * @param fill
	 * @param stroke
	 * @param strokeWidth
	 */
    public SquareRoundDrawable(int fill, int stroke, int strokeWidth) {
    	float[] outerRadii = new float[] { 0, 0, 16, 16, 0, 0, 16, 16 };
		RoundRectShape roundRectShape = new RoundRectShape(outerRadii, null,null);
		setShape(roundRectShape);
        fillpaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        fillpaint.setColor(fill);
        strokepaint = new Paint(fillpaint);
        strokepaint.setStyle(Paint.Style.STROKE);
        strokepaint.setStrokeWidth(strokeWidth);
        strokepaint.setColor(stroke);
    }
 
    @Override
    protected void onDraw(Shape shape, Canvas canvas, Paint paint) {
    	shape.draw(canvas, fillpaint);
        Matrix matrix = new Matrix();
        RectF src = new RectF(canvas.getClipBounds().left-1, canvas.getClipBounds().top -1, canvas.getClipBounds().right + 1,canvas.getClipBounds().bottom + 1);
        RectF dst = new RectF(canvas.getClipBounds().left, canvas.getClipBounds().top, canvas.getClipBounds().right,canvas.getClipBounds().bottom);
		matrix.setRectToRect(src, dst, Matrix.ScaleToFit.FILL);
        canvas.concat(matrix);
        shape.draw(canvas, strokepaint);
    }
}
