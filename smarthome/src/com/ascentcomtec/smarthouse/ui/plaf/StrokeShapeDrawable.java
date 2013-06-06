/**
 * Copyright (c) 2012, SetaCinQ
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER
 */
package com.ascentcomtec.smarthouse.ui.plaf;

import android.graphics.Canvas;
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
    private float strokeWidth = 1.15f;
    /***
     * Create by    : longtq6195
     * @param s
     */
    public StrokeShapeDrawable(Shape shape, int color, float strokeWidth) {
        super(shape);
        this.strokeWidth = strokeWidth;
        strokepaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        strokepaint.setAntiAlias(true);
        strokepaint.setStyle(Paint.Style.STROKE);
        strokepaint.setStrokeWidth(strokeWidth);
        strokepaint.setColor(color);
     }

    @Override
    protected void onDraw(Shape shape, Canvas canvas, Paint fillpaint) {
    	shape.resize(canvas.getClipBounds().right, canvas.getClipBounds().bottom);
        shape.draw(canvas, fillpaint);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(new RectF(0, 0, canvas.getClipBounds().right, canvas.getClipBounds().bottom), 
        		new RectF(strokeWidth/strokeWidth, strokeWidth/strokeWidth, canvas.getClipBounds().right - strokeWidth/strokeWidth, canvas.getClipBounds().bottom - strokeWidth/strokeWidth), 
        		Matrix.ScaleToFit.FILL);
        canvas.concat(matrix);
        shape.draw(canvas, strokepaint);
    }
 
}
