package com.ascentcomtec.smarthouse;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.ascentcomtec.smarthouse.ui.components.button.JButton;
import com.ascentcomtec.smarthouse.ui.components.textview.JTextView;

public class UpDownControl extends LinearLayout{
	
	private JTextView jTextView;
	private int temp = 28;
	
	public UpDownControl(Context context) {
		super(context);
	}

	public UpDownControl(Context context,int w, int h) {
		super(context);
		initUI(w, h);
	}
	/***
	 * 
	 */
	private void initUI(int w, int h){
		setLayoutParams(new LinearLayout.LayoutParams(w, h));
		LinearLayout linearLayoutRoot = new LinearLayout(getContext());
		linearLayoutRoot.setBackgroundResource(R.drawable.air_background);
		LinearLayout linearLayoutLeft = new LinearLayout(getContext());
		linearLayoutLeft.setGravity(Gravity.CENTER);
 		jTextView = new JTextView(getContext());
		jTextView.setTextColor(0xFF72c9e5);
		jTextView.setGravity(Gravity.CENTER);
		jTextView.setModeTitle(getContext());
		jTextView.setText("28°C");
		linearLayoutLeft.addView(jTextView);
		LinearLayout linearLayoutRight = new LinearLayout(getContext());
		linearLayoutRight.setOrientation(LinearLayout.VERTICAL);
 		JButton jButtonUp = new JButton(getContext());
 		jButtonUp.setBackgroundDrawable(getResources().getDrawable(R.drawable.up));
 		jButtonUp.setLayoutParams(new LinearLayout.LayoutParams(h/2, h/2));
		jButtonUp.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				temp++;
				if(temp > 35){
					temp = 35;
				}
				jTextView.setText(temp+"°C");
			}
		});
		linearLayoutRight.addView(jButtonUp);
		JButton jButtonDown = new JButton(getContext());
		jButtonDown.setBackgroundDrawable(getResources().getDrawable(R.drawable.down));
		jButtonDown.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				temp--;
				if(temp < 0){
					temp = 0;
				}
				jTextView.setText(temp+"°C");
			}
		});
 		jButtonDown.setLayoutParams(new LinearLayout.LayoutParams(h/2, h/2));
		linearLayoutRight.addView(jButtonDown);
		linearLayoutRoot.addView(setRelativeLayoutLeft2Right(linearLayoutLeft, w - h / 2, linearLayoutRight, h/2));
		addView(linearLayoutRoot);
	}
    /***
     * 
     * @param left
     * @param right
     * @return
     */
	public RelativeLayout setRelativeLayoutLeft2Right(View left, int w, View right, int ww) {
		left.setId(0x011);
		right.setId(0x012);
		RelativeLayout relativeLayoutControl = new RelativeLayout(
				getContext());
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		relativeLayoutControl.setLayoutParams(layoutParams);

		RelativeLayout.LayoutParams relativeLayoutLayoutParamsLeft = new RelativeLayout.LayoutParams(
				w,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		relativeLayoutLayoutParamsLeft.addRule(
				RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
		relativeLayoutLayoutParamsLeft.addRule(RelativeLayout.CENTER_VERTICAL,
				RelativeLayout.TRUE);

		left.setLayoutParams(relativeLayoutLayoutParamsLeft);

		RelativeLayout.LayoutParams relativeLayoutLayoutParamsRight = new RelativeLayout.LayoutParams(
				ww,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		relativeLayoutLayoutParamsRight.addRule(
				RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
//		relativeLayoutLayoutParamsRight.addRule(RelativeLayout.CENTER_VERTICAL,
//				RelativeLayout.TRUE);
//		relativeLayoutLayoutParamsRight.addRule(RelativeLayout.RIGHT_OF, 0x011);
		right.setLayoutParams(relativeLayoutLayoutParamsRight);

		relativeLayoutControl.addView(left);
		relativeLayoutControl.addView(right);

		return relativeLayoutControl;
	}
}
