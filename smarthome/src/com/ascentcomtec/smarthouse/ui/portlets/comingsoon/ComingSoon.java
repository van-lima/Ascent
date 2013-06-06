package com.ascentcomtec.smarthouse.ui.portlets.comingsoon;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;

import com.ascentcomtec.smarthouse.ui.components.ActionBar;
import com.ascentcomtec.smarthouse.ui.components.FormFactory;

public class ComingSoon extends FormFactory {

	@Override
	public void execute() {
		ActionBar actionBar = new ActionBar(this);
		actionBar.setText("ComingSoon");
		ImageView buttonBack = new ImageView(getApplicationContext());
 		buttonBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View paramView) {
				finish();
			}
		});
		actionBar.addControlActionBarLeft(buttonBack);
		getTitleArea().addView(actionBar);
		//getContentPane().addView(getImageView(R.drawable.mobile_app));
	}

	/***
	 * 
	 * @return
	 */
	public ImageView getImageView(int id) {
		Resources resources = getResources();
		Bitmap bitmap = BitmapFactory.decodeResource(resources, id);
		ImageView imageView = new ImageView(this);
		imageView.setImageBitmap(bitmap);
		return imageView;
	}
}
