package com.ascentcomtec.smarthouse;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;

import com.ascentcomtec.smarthouse.ui.activities.AbstractActivity;
import com.ascentcomtec.smarthouse.ui.components.HAFormFactory;
import com.ascentcomtec.smarthouse.ui.components.button.JImageView;
import com.ascentcomtec.smarthouse.ui.components.button.JToggleButton;
import com.ascentcomtec.smarthouse.ui.components.textview.JTextView;
import com.ascentcomtec.smarthouse.ui.plaf.Style;
import com.ascentcomtec.smarthouse.utils.Utils;

public class SecuriryCenter extends HAFormFactory {

	@Override
	public void executeUI() {
		setTitle("Securiry Center");

		// root layout
		LinearLayout linearLayoutRoot = new LinearLayout(
				getApplicationContext());
		linearLayoutRoot.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT));
		linearLayoutRoot.setGravity(Gravity.CENTER);
		linearLayoutRoot.setOrientation(LinearLayout.HORIZONTAL);
		// linearLayoutRoot.setBackgroundColor(Color.BLUE);
		// layout left
		LinearLayout linearLayoutColumnFirst = new LinearLayout(
				getApplicationContext()) {
			final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
			final int color[] = { 0xFF666666, 0xFF666666, 0xFF666666 };

			@Override
			protected void onDraw(Canvas canvas) {
				super.onDraw(canvas);
				for (int i = 0; i < 1; i++) {
					paint.setColor(color[i]); // color.RED
					canvas.drawLine(getScreenWidth() / 2 - i, 0,
							getScreenWidth() / 2 - i, canvas.getHeight(), paint);
				}
			}
		};
		linearLayoutColumnFirst.setBackgroundDrawable(new ColorDrawable(
				Color.TRANSPARENT));
		linearLayoutColumnFirst.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutColumnFirst.addView(getLinearLayoutLeft());
		linearLayoutRoot.addView(linearLayoutColumnFirst);

		// layout right
		LinearLayout linearLayoutColumnSecond = new LinearLayout(
				getApplicationContext());
		// linearLayoutColumnSecond.setBackgroundColor(Color.GREEN);
		linearLayoutColumnSecond.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutRoot.addView(linearLayoutColumnSecond);
		linearLayoutColumnSecond.addView(getLinearLayoutRigth());
		getContentPane().setBackgroundDrawable(
				drawableBackgroundImage(getApplicationContext()));
		getContentPane().addView(linearLayoutRoot);

		LinearLayout linearLayoutMenuBar = new LinearLayout(
				getApplicationContext());
		linearLayoutMenuBar.setGravity(Gravity.CENTER);
		linearLayoutMenuBar.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT));
		JTextView jTextView = new JTextView(getApplicationContext());
		jTextView.setGravity(Gravity.CENTER);
		jTextView.setText("Powered by IP LIMA");
		linearLayoutMenuBar.addView(jTextView);
		getMenuBar().addView(linearLayoutMenuBar);

	}

	/**
	 * return drawable image,id of image config in class Constant
	 * 
	 * @param context
	 * @return
	 */
	public Drawable drawableBackgroundImage(Context context) {
		return new ColorDrawable(0xFFb9c2c6);
	}

	/**
	 * 
	 * @return
	 */
	public LinearLayout getLinearLayoutLeft() {
		int height = (getContentPaneHeight() - Utils.convertDips2Pixel(45,
				getApplicationContext())) / 2;
		LinearLayout linearLayout = new LinearLayout(getApplicationContext());
		linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT));
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		// first row
		LinearLayout linearLayoutFirst = new LinearLayout(
				getApplicationContext());
		linearLayoutFirst.setGravity(Gravity.CENTER);
		linearLayoutFirst.setOrientation(LinearLayout.HORIZONTAL);
		linearLayoutFirst.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, height));
		JToggleButton jImageViewArm = new JToggleButton(getApplicationContext(), R.drawable.bt_disarm, R.drawable.bt_arm);
  		jImageViewArm.setLayoutParams(getLinearLayoutLayoutParams(height));
 		linearLayoutFirst.addView(jImageViewArm);
		JToggleButton jImageViewDisArm = new JToggleButton(getApplicationContext(), R.drawable.bt_arm, R.drawable.bt_disarm);
		jImageViewDisArm.setLayoutParams(getLinearLayoutLayoutParams(height));
 		linearLayoutFirst.addView(jImageViewDisArm);
		linearLayout.addView(linearLayoutFirst);
		LinearLayout title = getTitleViewRightBorder("Camera",
				R.drawable.detail);
		linearLayout.addView(title);
		// second row
		LinearLayout linearLayoutSecond = new LinearLayout(
				getApplicationContext());
		linearLayoutSecond.setGravity(Gravity.CENTER);
 		linearLayoutSecond.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, height));
		linearLayoutSecond.setOrientation(LinearLayout.HORIZONTAL);
		JToggleButton jImageViewDoor = new JToggleButton(getApplicationContext(), R.drawable.bt_cam, R.drawable.bt_door);
		jImageViewDoor.setLayoutParams(getLinearLayoutLayoutParams(height));
 		linearLayoutSecond.addView(jImageViewDoor);
		JToggleButton jImageViewCam = new JToggleButton(getApplicationContext(), R.drawable.bt_door, R.drawable.bt_cam);
		jImageViewCam.setLayoutParams(getLinearLayoutLayoutParams(height));
 		linearLayoutSecond.addView(jImageViewCam);
		linearLayout.addView(linearLayoutSecond);

		return linearLayout;
	}
	/***
	 * get layout params for screen title
	 * 
	 * @return
	 */
	public LinearLayout.LayoutParams getLinearLayoutLayoutParams(int height) {
		Style style = new Style(getApplicationContext());
		style.setMargin(10, 10, 10, 10);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(height - 60, height - 20);
		layoutParams.setMargins(style.getMarginValue(AbstractActivity.LEFT), style.getMarginValue(AbstractActivity.TOP), style.getMarginValue(AbstractActivity.RIGHT), style.getMarginValue(AbstractActivity.BOTTOM));
		return layoutParams;
	}
	/**
	 * 
	 * @return
	 */
	public LinearLayout getLinearLayoutRigth() {
		int delta = 0;
		int h = (getContentPaneHeight() - 45)/ 4 + delta;
		LinearLayout linearLayout = new LinearLayout(getApplicationContext());
		linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT));
		linearLayout.setOrientation(LinearLayout.VERTICAL);

		LinearLayout titleSecurity = getTitleView("Sensors", R.drawable.detail);
		linearLayout.addView(titleSecurity);
		
		// first row
		LinearLayout linearLayoutFirst = new LinearLayout(
				getApplicationContext());
		linearLayoutFirst.setOrientation(LinearLayout.VERTICAL);
		linearLayoutFirst.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, h));
		linearLayoutFirst.addView(getControl(0));
		linearLayout.addView(linearLayoutFirst);
		
		// second row
		LinearLayout linearLayoutSecond = new LinearLayout(
				getApplicationContext());
		linearLayoutSecond.setOrientation(LinearLayout.VERTICAL);
		linearLayoutSecond.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, h));
		linearLayoutSecond.addView(getControl(1));
		linearLayout.addView(linearLayoutSecond);
		
		// third row
		LinearLayout linearLayoutThird = new LinearLayout(
				getApplicationContext());
		linearLayoutThird.setOrientation(LinearLayout.VERTICAL);
		linearLayoutThird.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, h));
 		linearLayoutThird.addView(getControl(2));
		linearLayout.addView(linearLayoutThird);
		
		// fourth row
		LinearLayout linearLayoutFourth = new LinearLayout(
				getApplicationContext());
		linearLayoutFourth.setOrientation(LinearLayout.VERTICAL);
		linearLayoutFourth.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, h));
 		linearLayoutFourth.addView(getControl(3));
		linearLayout.addView(linearLayoutFourth);
		
		return linearLayout;
	}
	
	private LinearLayout getControl(int id){
		String[] lable = new String[]{"Front Door - Armed", "Back Door - Breech", "Shed Movement - Armed", "Shed Door - Disarmed"};
		int[] icon = new int[]{R.drawable.bt_001, R.drawable.bt_002, R.drawable.bt_003, R.drawable.bt_004};
		LinearLayout linearLayout = new LinearLayout(getApplicationContext()){
			@Override
			protected void onDraw(Canvas canvas) {
				super.onDraw(canvas);

				Paint pen = new Paint();
				pen.setColor(Color.GRAY);
				pen.setStrokeWidth(1);
				pen.setStyle(Paint.Style.STROKE);
				canvas.drawLine(0, getHeight() - 2, getWidth(),
						getHeight() - 2, pen); // not painted

			}
		};
		linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT));
		linearLayout.setOrientation(LinearLayout.HORIZONTAL);
		linearLayout.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		// first row
		LinearLayout linearLayoutFirst = new LinearLayout(
				getApplicationContext());
		linearLayoutFirst.setPadding(10, 10, 10, 10);
		linearLayoutFirst.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutFirst.setGravity(Gravity.LEFT | Gravity.TOP);
		linearLayoutFirst.setOrientation(LinearLayout.VERTICAL);
		JTextView jTextView = new JTextView(getApplicationContext());
		jTextView.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		jTextView.setText(lable[id]);
		linearLayoutFirst.addView(jTextView);
		JToggleButton jToggleButton = new JToggleButton(getApplicationContext(), R.drawable.bt_off, R.drawable.bt_on);
		jToggleButton.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		linearLayoutFirst.addView(jToggleButton);
 		linearLayout.addView(linearLayoutFirst);
		
		// second row
		LinearLayout linearLayoutSecond = new LinearLayout(
				getApplicationContext());
		linearLayoutSecond.setPadding(10, 10, 10, 10);
		linearLayoutSecond.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutSecond.setGravity(Gravity.RIGHT);
		linearLayoutSecond.setOrientation(LinearLayout.VERTICAL);
 		JImageView imageView = new JImageView(getApplicationContext());
		imageView.setImageResource(icon[id]);
		imageView.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		linearLayoutSecond.addView(imageView);
		linearLayout.addView(linearLayoutSecond);
		
		return linearLayout;
	}

	/***
	 * 
	 * @return
	 */
	public LinearLayout getTitleView(String title, int id) {
		LinearLayout linearLayout = new LinearLayout(getApplicationContext());
		linearLayout.setPadding(5, 5, 5, 5);
		linearLayout.setOrientation(LinearLayout.HORIZONTAL);
		linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, Utils.convertDips2Pixel(
						45, getApplicationContext())));
		linearLayout.setBackgroundResource(R.drawable.title_bar);
		LinearLayout.LayoutParams layoutParamsColumn = new LinearLayout.LayoutParams(
				TableRow.LayoutParams.FILL_PARENT,
				TableRow.LayoutParams.FILL_PARENT, 1);
		LinearLayout linearLayoutLeft = new LinearLayout(
				getApplicationContext());
		linearLayoutLeft.setGravity(Gravity.LEFT | Gravity.CENTER);
		linearLayoutLeft.setLayoutParams(layoutParamsColumn);
		JTextView jTextViewTitleControl = new JTextView(getApplicationContext());
		jTextViewTitleControl.setTextColor(0xFF000000);
		jTextViewTitleControl.setModeSubTitle(getApplicationContext());
		jTextViewTitleControl.setGravity(Gravity.CENTER);
		jTextViewTitleControl.setText(title);
		linearLayoutLeft.addView(jTextViewTitleControl);
		linearLayout.addView(linearLayoutLeft);
		LinearLayout linearLayoutRight = new LinearLayout(
				getApplicationContext());
		linearLayoutRight.setGravity(Gravity.RIGHT | Gravity.CENTER);
		linearLayoutRight.setLayoutParams(layoutParamsColumn);
		ImageView imageView = new ImageView(getApplicationContext());
		imageView.setImageResource(id);
		linearLayoutRight.addView(imageView);
		linearLayout.addView(linearLayoutRight);
		return linearLayout;
	}

	/**
	 * 
	 * @param title
	 * @param id
	 * @return
	 */
	public LinearLayout getTitleViewRightBorder(String title, int id) {
		LinearLayout linearLayout = new LinearLayout(getApplicationContext()) {
			final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
			final int color[] = { 0xFF666666, 0xFF666666, 0xFF666666 };

			@Override
			protected void onDraw(Canvas canvas) {
				super.onDraw(canvas);
				for (int i = 0; i < 1; i++) {
					paint.setColor(color[i]); // color.RED
					canvas.drawLine(getScreenWidth() / 2 - i, 0,
							getScreenWidth() / 2 - i, canvas.getHeight(), paint);
				}
			}
		};
		linearLayout
				.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		linearLayout.setPadding(5, 5, 5, 5);
		linearLayout.setOrientation(LinearLayout.HORIZONTAL);
		linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, Utils.convertDips2Pixel(
						45, getApplicationContext())));
		linearLayout.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.title_bar));
		LinearLayout.LayoutParams layoutParamsColumn = new LinearLayout.LayoutParams(
				TableRow.LayoutParams.FILL_PARENT,
				TableRow.LayoutParams.FILL_PARENT, 1);
		LinearLayout linearLayoutLeft = new LinearLayout(
				getApplicationContext());
		linearLayoutLeft.setGravity(Gravity.LEFT | Gravity.CENTER);
		linearLayoutLeft.setLayoutParams(layoutParamsColumn);
		JTextView jTextViewTitleControl = new JTextView(getApplicationContext());
		jTextViewTitleControl.setTextColor(0xFF000000);
		jTextViewTitleControl.setModeSubTitle(getApplicationContext());
		jTextViewTitleControl.setGravity(Gravity.CENTER);
		jTextViewTitleControl.setText(title);
		linearLayoutLeft.addView(jTextViewTitleControl);
		linearLayout.addView(linearLayoutLeft);
		LinearLayout linearLayoutRight = new LinearLayout(
				getApplicationContext());
		linearLayoutRight.setGravity(Gravity.RIGHT | Gravity.CENTER);
		linearLayoutRight.setLayoutParams(layoutParamsColumn);
		ImageView imageView = new ImageView(getApplicationContext());
		imageView.setImageResource(id);
		linearLayoutRight.addView(imageView);
		linearLayout.addView(linearLayoutRight);
		return linearLayout;
	}

}
