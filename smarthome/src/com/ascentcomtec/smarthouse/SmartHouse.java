package com.ascentcomtec.smarthouse;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.LinearLayout;

import com.ascentcomtec.smarthouse.ui.activities.AbstractActivity;
/**
 * Project name : YWCA
 * Package name : com.ywca.main
 * File name    : YWCASplash.java
 * Create by    : longtq6195
 * Create date  : Sep 4, 2012 6:01:10 PM
 */
public class SmartHouse extends AbstractActivity {
	
	private final int SPLASH_SCREEN_TIME_IN_MILLIS = 2000;
	private static final String TAG = "SmartHouseSplash";
	 
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(getApplicationContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
        linearLayout.setBackgroundDrawable(convertImage2Drawable(R.drawable.smart_house));
        setContentView(linearLayout);
 		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent intent = new Intent(SmartHouse.this, InitializeActivity.class);
				startActivity(intent);
				// Finish splash activity so user cant go back to it.
				SmartHouse.this.finish();
				overridePendingTransition(R.anim.fadein, R.anim.fadeout);
			}
		}, SPLASH_SCREEN_TIME_IN_MILLIS);
    }
    
	@Override
	protected void onStart() {
		super.onStart();
 		Log.i(TAG, "start service");
	}
}
