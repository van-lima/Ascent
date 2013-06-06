/**
 * Copyright (c) 2012, SetaCinQ
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER
 */
package com.resolutiondev.ui.drawable;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
/**
 * Create by    : longtq
 * Project name : HappiestBaby
 * Package name : com.setacinq.happiestbaby.ui.components.button
 * File name    : StrokeShapeDrawable.java
 * Create date  : Mar 12, 2012
 * Create border to view
 */
public class StrokeShapeDrawable extends ShapeDrawable {
    private Paint strokepaint;
    private final int WIDTH = 1;
    /**
     * 
     * @param s
     */
    public StrokeShapeDrawable(Shape s) {
        super(s);
        strokepaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        strokepaint.setAntiAlias(true);
        strokepaint.setStyle(Paint.Style.STROKE);
        strokepaint.setStrokeWidth(WIDTH);
        strokepaint.setColor(Color.BLACK);
        strokepaint.setAlpha(0x80);
    }

    @Override
    protected void onDraw(Shape shape, Canvas canvas, Paint fillpaint) {
        shape.resize(canvas.getClipBounds().right, canvas.getClipBounds().bottom);
        shape.draw(canvas, fillpaint);
		Matrix matrix = new Matrix();
		matrix.setRectToRect(new RectF(canvas.getClipBounds().left,canvas.getClipBounds().top,canvas.getClipBounds().right,canvas.getClipBounds().bottom),
				new RectF(canvas.getClipBounds().left,canvas.getClipBounds().top,canvas.getClipBounds().right,canvas.getClipBounds().bottom),Matrix.ScaleToFit.FILL);
		canvas.concat(matrix);
		shape.draw(canvas, strokepaint);
    }
 
}
