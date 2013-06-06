package com.ascentcomtec.smarthouse;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.ascentcomtec.smarthouse.ui.components.FormFactory;

public class ComingSoon extends FormFactory {

	@Override
	public void execute() {
		getContentPane().addView(getImageView(R.drawable.mobile_app));
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
