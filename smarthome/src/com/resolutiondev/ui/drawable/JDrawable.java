package com.resolutiondev.ui.drawable;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.Log;
/***
 * 
 * Create by    : longtq6195
 * 
 */
public class JDrawable {
	
	private static final String TAG = JDrawable.class.getName();
	
	private static JDrawable jDrawable;
	/***
	 * 
	 * @return
	 */
	public static JDrawable getJDrawable(){
		if(null == jDrawable){
			jDrawable = new JDrawable();
			Log.i(TAG, "new drawable");
		}
		return jDrawable;
	}
	/***
	 * 
	 */
	private JDrawable(){
		
	}

	public Drawable drawLine() {
		return null;
	}
	/***
	 * 
	 */
	public Drawable getFillRoundRectangleStroke() {
		int[] colors = { 0xFFFFFFFF, 0xFFFFFFFF };
		float[] radii = { 8, 8, 8, 8, 8, 8, 8, 8 };
		GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors);
		drawable.setCornerRadii(radii);
		drawable.setStroke(1, 0xFFB2B2B2);
		return drawable;
    }
    /**
     * 
     * @return
     */
	public Drawable fillRect(int color) {
		PaintDrawable paintDrawable = new PaintDrawable(color);
		paintDrawable.setShape(new RectShape());
 		return paintDrawable;
	}
    /***
     * 
     * @return
     */
	public Drawable fillRectRadialGradient(final int colors[], final float positions[]) {
		ShapeDrawable.ShaderFactory shaderFactory = new ShapeDrawable.ShaderFactory() {
			@Override
			public Shader resize(int width, int height) {
				LinearGradient linearGradient = new LinearGradient(0, 0, 0,height,colors,positions,Shader.TileMode.REPEAT);
				return linearGradient;
			}
		};
		StrokeShapeDrawable strokeShapeDrawable = new StrokeShapeDrawable(new RectShape());
	    strokeShapeDrawable.setShaderFactory(shaderFactory);
	    return strokeShapeDrawable;
	}
    /***
     * 
     * @return
     */
	public Drawable fillRectRadialGradient() {
		ShapeDrawable.ShaderFactory shaderFactory = new ShapeDrawable.ShaderFactory() {
			@Override
			public Shader resize(int width, int height) {
				LinearGradient linearGradient = new LinearGradient(0, 0, 0,height, new int[] { 0xfff6f6f6, 0xfff6f6f6, 0xffc0c1c4,0xffc0c1c4 },new float[] { 0, 0.45f, 0.55f, 1 },Shader.TileMode.REPEAT);
				return linearGradient;
			}
		};
	    StrokeShapeDrawable strokeShapeDrawable = new StrokeShapeDrawable(new RectShape());
	    strokeShapeDrawable.setShaderFactory(shaderFactory);
	    strokeShapeDrawable.setAlpha(185);
	    return strokeShapeDrawable;
	}
	//
	/***
	 * 
	 * @return
	 */
	public Drawable drawRect() {
		ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
		shapeDrawable.getPaint().setStrokeWidth(3);
		shapeDrawable.getPaint().setColor(0xFF000000);
		shapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
		//shapeDrawable.getPaint().setAlpha(0x80);
		shapeDrawable.getPaint().setAntiAlias(true);
		return shapeDrawable;
	}
	/***
	 * 
	 * @return
	 */
	public Drawable drawRect(int stroke, int color) {
		float[] radii = new float[] { 0, 0, 0, 0, 0, 0, 0, 0};
		int[] colors = { 0xFFFFFFFF, 0xFFFFFFFF };
		GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors);
 		drawable.setCornerRadii(radii);
		drawable.setStroke(stroke, color);
		return drawable;
	}
	/***
	 * 
	 * @return
	 */
	public Drawable drawRoundRect() {
		float[] outerRadii = new float[] { 6, 6, 6, 6, 6, 6, 6, 6 };
		ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(outerRadii, null, null));
		shapeDrawable.getPaint().setStrokeWidth(1);
		shapeDrawable.getPaint().setColor(Color.BLACK);
		shapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
		shapeDrawable.getPaint().setAlpha(0x80);
		shapeDrawable.getPaint().setAntiAlias(true);
		shapeDrawable.getPaint().setFlags(Paint.ANTI_ALIAS_FLAG);
		return shapeDrawable;
	}
	/***
	 * 
	 * @return
	 */
	public Drawable drawRoundRect(int stroke, int color) {
		float[] radii = new float[] { 6, 6, 6, 6, 6, 6, 6, 6 };
		int[] colors = { 0xFFFFFFFF, 0xFFFFFFFF };
		GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors);
		//drawable.setAlpha(45);
		drawable.setCornerRadii(radii);
		drawable.setStroke(stroke, color);
		return drawable;
	}
	/***
	 * 
	 * @return
	 */
	public Drawable drawRoundRect(float[] radii, int stroke, int color) {
 		int[] colors = { 0xFFFFFFFF, 0xFFFFFFFF };
		GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors);
 		drawable.setCornerRadii(radii);
		drawable.setStroke(stroke, color);
		return drawable;
	}
	/***
	 * 
	 * @param color
	 * @return
	 */
	public Drawable fillRoundRect(int color) {
		float[] outerRadii = new float[] { 6, 6, 6, 6, 6, 6, 6, 6 };
		PaintDrawable paintDrawable = new PaintDrawable(color);
		paintDrawable.setShape(new RoundRectShape(outerRadii, null, null));
		return paintDrawable;
	}
    /***
     * 
     * @return
     */
	public Drawable fillRoundRectRadialGradient(final int [] color) {
		ShapeDrawable.ShaderFactory shaderFactory = new ShapeDrawable.ShaderFactory() {
			@Override
			public Shader resize(int width, int height) {
				LinearGradient linearGradient = new LinearGradient(0, 0, 0,height,color,new float[] { 0, 0.04f, 0.55f, 1 },Shader.TileMode.REPEAT);
				return linearGradient;
			}
		};
		float[] outerRadii = new float[] { 6, 6, 6, 6, 6, 6, 6, 6 };
	    StrokeShapeDrawable strokeShapeDrawable = new StrokeShapeDrawable(new RoundRectShape(outerRadii, null, null));
 	    strokeShapeDrawable.setShaderFactory(shaderFactory);
	    return strokeShapeDrawable;
	}
}
