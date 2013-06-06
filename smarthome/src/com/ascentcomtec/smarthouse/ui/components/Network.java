package com.ascentcomtec.smarthouse.ui.components;

import com.ascentcomtec.smarthouse.R;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class Network extends HAFormFactory {

	@Override
	public void executeUI() {
		setTitle("Network");
		LinearLayout linearLayoutRoot = new LinearLayout(
				getApplicationContext());
		linearLayoutRoot.setLayoutParams(getLinearLayoutLayoutParams());
		linearLayoutRoot.setPadding(10, 10, 10, 10);
		linearLayoutRoot.setOrientation(LinearLayout.HORIZONTAL);
		ImageView imageView = new ImageView(getApplicationContext());
		imageView.setImageResource(R.drawable.network_d);
		linearLayoutRoot.addView(imageView);
		RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
  		relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT));
		relativeLayout.addView(linearLayoutRoot);
   		getContentPane().addView(relativeLayout);
	}

}
