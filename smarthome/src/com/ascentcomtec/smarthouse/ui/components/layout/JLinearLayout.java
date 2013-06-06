package com.ascentcomtec.smarthouse.ui.components.layout;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.LinearLayout;

public class JLinearLayout extends LinearLayout {
	
	private Paint paint;
	private Bitmap bitmap;
    private Context context;
    
	public JLinearLayout(Context context) {
		super(context);
		this.context = context;
	}

	/**
	 * 
	 */
	public void setBorder(int iconId) {
		paint  = new Paint(Paint.ANTI_ALIAS_FLAG);
		bitmap = readBitMap(context, iconId);
	}

	/**
	 * 
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (null != bitmap) {
			if(bitmap.getWidth() < getWidth() && bitmap.getHeight() < getHeight()){
				for (int i = 0; i < getWidth(); i += bitmap.getWidth()) {
					canvas.drawBitmap(bitmap, i, getHeight() / 2 - bitmap.getHeight() / 2, paint);
				}
			}
		}
	}
	/**
	 * 
	 * @param context
	 * @param resId
	 * @return
	 */
	public static Bitmap readBitMap(Context context, int resId) {
		BitmapFactory.Options bitmapLoadingOptions = new BitmapFactory.Options();
		bitmapLoadingOptions.inPreferredConfig = Bitmap.Config.RGB_565;
  		InputStream inputStream = context.getResources().openRawResource(resId);
		return BitmapFactory.decodeStream(inputStream,null,bitmapLoadingOptions);
	}
}
