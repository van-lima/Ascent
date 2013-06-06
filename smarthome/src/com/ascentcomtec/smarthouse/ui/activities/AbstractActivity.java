/**
 * 
 * Copyright (c) 2012, tqlong.net@gmail.com/sourceforge. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact tqlong.net@gmail.com if you need additional information or
 * have any questions.
 * 
 */
package com.ascentcomtec.smarthouse.ui.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ascentcomtec.smarthouse.ui.plaf.Style;
import com.ascentcomtec.smarthouse.utils.Utils;
/**
 * 
 * A screen that contains and runs multiple screen.
 * 
 */
public class AbstractActivity extends Activity {
	
	private ProgressDialog progressDialog;
	private String TAG = AbstractActivity.class.getName();
	private Style  style;
	/**
	 * Indicates a Component center alignment
	 */
	public static final int CENTER = 4;
	/**
	 * Box-orientation constant used to specify the top of a box.
	 */
	public static final int TOP = 0;
	/**
	 * Box-orientation constant used to specify the left side of a box.
	 */
	public static final int LEFT = 1;
	/**
	 * Box-orientation constant used to specify the bottom of a box.
	 */
	public static final int BOTTOM = 2;
	/**
	 * Box-orientation constant used to specify the right side of a box.
	 */
	public static final int RIGHT = 3;
		
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// No title bar.
		TAG = getClass().getSimpleName();
		Log.i(TAG, "onCreating.................");
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		// Switch to fullscreen view, getting rid of the status bar as well.
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// hide the keyboard everytime the activty starts
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		//set orientation
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		//
		KeyguardManager keyguardManager = (KeyguardManager) getSystemService(Activity.KEYGUARD_SERVICE);
		KeyguardLock lock = keyguardManager.newKeyguardLock(Activity.KEYGUARD_SERVICE);
		//reenable keyguard
		lock.reenableKeyguard();
		//set style and had code default value to style
		style = new Style(getApplicationContext());
		style.setMargin(20, 20, 20, 20);
		style.setPadding(10, 10, 10, 10);
		Log.i(TAG, "onCreated.................");
 	}
	
	@Override
	protected void onStart() {
		super.onResume();
 	}

	@Override
	protected void onStop() {
		super.onStart();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	@Override
	protected void onResume() {
 		super.onResume();
		if (!isNetworkAvailable()) {
			//Toast.makeText(getApplicationContext(), "Mobile Network Not Available", Toast.LENGTH_LONG).show();
		}
	}
	/**
	 * 
	 * @return
	 */
	public int getWidth(){
		Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay(); 
		return display.getWidth();
	}
	/***
	 * 
	 * @return
	 */
	public int getHeight(){
		Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay(); 
		return display.getHeight();
	}
	/**
	 * to check if the user have enable wap/wifi this works for all device
	 * 
	 * @return
	 */
	public boolean isNetworkAvailable() {
		ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfoMobile = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		NetworkInfo networkInfoWiFi   = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		boolean booleanMobile = false;
		boolean booleanWiFi   = false;
		if (networkInfoMobile != null) {
			booleanMobile = networkInfoMobile.isConnected();
		}
		if (networkInfoWiFi != null) {
			booleanWiFi = networkInfoWiFi.isConnected();
		}
		return (booleanMobile || booleanWiFi);
	}
	/**
	 * 
	 * @return
	 */
	public Style getStyle() {
		return style;
	}
	/***
	 * 
	 * @param style
	 */
	public void setStyle(Style style) {
		this.style = style;
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Drawable convertImage2Drawable(int id){
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), id);
		BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
		return bitmapDrawable;
	}
 
	/***
	 * 
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (event.getAction() == KeyEvent.ACTION_DOWN) {
			//finish();
		}
		return super.onKeyDown(keyCode, event);
	}
	/**
	 * Open progress dialog
	 * 
	 * @param text
	 */
	public void showProgressDialog(String text) {
		if (progressDialog == null) {
			progressDialog = ProgressDialog.show(this, null, text, true);
			progressDialog.setCancelable(false);
		}
	}
	/**
	 * 
	 */
	public void showWaitConncectServer() {
		showProgressDialog("Loading data...");
	}
	/**
	 * Close progress dialog
	 */
	public void closeProgressDialog() {
		if (progressDialog != null) {
			progressDialog.cancel();
			progressDialog = null;
		}
	}
	/**
	 * 
	 * @param message
	 */
	public void showAlertDialog(String message) {
		final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
		alertDialog.setTitle("Alert");
		alertDialog.setMessage(message);
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				alertDialog.dismiss();
			}
		});
		alertDialog.show();
	}
	/**
	 * 
	 * @param message
	 */
	public void showAlertDialog(String message, final AbstractActivity abstractActivity) {
		final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
		alertDialog.setTitle("Alert");
		alertDialog.setMessage(message);
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				alertDialog.dismiss();
				abstractActivity.finish();
			}
		});
		alertDialog.show();
	}
	/***
	 * 
	 * @param bitmap
	 * @return
	 */
	public static Bitmap createReflectionImageWithOrigin(Bitmap bitmap) {
        final int reflectionGap = 4;
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.preScale(1, -1);
        Bitmap reflectionImage = Bitmap.createBitmap(bitmap, 0, h / 2, w, h / 2, matrix, false);
        Bitmap bitmapWithReflection = Bitmap.createBitmap(w, (h + h / 2), Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapWithReflection);
        canvas.drawBitmap(bitmap, 0, 0, null);
        Paint deafalutPaint = new Paint();
        canvas.drawRect(0, h, w, h + reflectionGap, deafalutPaint);
        canvas.drawBitmap(reflectionImage, 0, h + reflectionGap, null);
        Paint paint = new Paint();
        LinearGradient shader = new LinearGradient(0, bitmap.getHeight(), 0, bitmapWithReflection.getHeight() + reflectionGap, 0x70ffffff, 0x00ffffff, TileMode.CLAMP);
        paint.setShader(shader);
        // Set the Transfer mode to be porter duff and destination in
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_IN));
        // Draw a rectangle using the paint with our linear gradient
        canvas.drawRect(0, h, w, bitmapWithReflection.getHeight() + reflectionGap, paint);
        return bitmapWithReflection;
    }
	
    /**
     * 
     */
	public void scaleImage(ImageView view, int bounding) {
		// Get the ImageView and its bitmap
 		Drawable drawing = view.getDrawable();
		Bitmap bitmap    = ((BitmapDrawable) drawing).getBitmap();

		// Get current dimensions AND the desired bounding box
		int width  = bitmap.getWidth();
		int height = bitmap.getHeight();
 
		// Determine how much to scale: the dimension requiring less scaling is
		// closer to the its side. This way the image always stays inside your
		// bounding box AND either x/y axis touches it.
		float xScale = ((float) Utils.convertDips2Pixel(bounding, getApplicationContext())) / width;
		float yScale = ((float) Utils.convertDips2Pixel(bounding, getApplicationContext())) / height;
		float scale  = (xScale <= yScale) ? xScale : yScale;

		// Create a matrix for the scaling and add the scaling data
		Matrix matrix = new Matrix();
		matrix.postScale(scale, scale);

		// Create a new bitmap and convert it to a format understood by the
		// ImageView
		Bitmap scaledBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
		width  = scaledBitmap.getWidth(); // re-use
		height = scaledBitmap.getHeight(); // re-use
		BitmapDrawable result = new BitmapDrawable(scaledBitmap);

		// Apply the scaled bitmap
		view.setImageDrawable(result);

		// Now change ImageView's dimensions to match the scaled image
	    // Now change ImageView's dimensions to match the scaled image
	    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1); 
	    params.width  = width;
	    params.height = height;
	    view.setLayoutParams(params);
	}
}
