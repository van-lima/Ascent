package com.ascentcomtec.smarthouse.ui.portlets.usermanage;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.ascentcomtec.smarthouse.R;
import com.ascentcomtec.smarthouse.ui.activities.AbstractActivity;
import com.ascentcomtec.smarthouse.ui.components.HAFormFactory;
import com.ascentcomtec.smarthouse.ui.components.button.JButton;
import com.ascentcomtec.smarthouse.ui.components.textview.JTextView;
import com.ascentcomtec.smarthouse.ui.plaf.Style;
import com.resolutiondev.ui.drawable.JDrawable;

public class DeleteUser extends HAFormFactory{

	@Override
	public void executeUI() {
		setTitle("Delete User");
		
		LinearLayout linearLayoutRoot = new LinearLayout(getApplicationContext());
		linearLayoutRoot.setPadding(10, 10, 10, 10);
		linearLayoutRoot.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
		linearLayoutRoot.setOrientation(LinearLayout.HORIZONTAL);
		linearLayoutRoot.setGravity(Gravity.CENTER);

		LinearLayout linearLayoutLeft = new LinearLayout(getApplicationContext());
		linearLayoutLeft.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutLeft.setOrientation(LinearLayout.VERTICAL);
		linearLayoutLeft.setGravity(Gravity.LEFT | Gravity.CENTER);
		JTextView jTextView = new JTextView(getApplicationContext());
		jTextView.setLayoutParams(getLinearLayoutLayoutParams());
		jTextView.setText("Are you sure you want to delete user ?");
		linearLayoutLeft.addView(jTextView);
		JTextView jTextViews = new JTextView(getApplicationContext());
		jTextViews.setLayoutParams(getLinearLayoutLayoutParams());
		jTextViews.setText("Administrator PIN");
		linearLayoutLeft.addView(jTextViews);
		JTextView editText = new JTextView(getApplicationContext());
 		editText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, 80));
		editText.setBackgroundDrawable(JDrawable.getJDrawable()
				.drawRoundRect(new float[] { 10, 10, 10, 10, 10, 10, 10, 10 }, 3, Color.BLACK));
		linearLayoutLeft.addView(editText);
		
		LinearLayout linearLayoutConfirm = new LinearLayout(getApplicationContext());
		linearLayoutConfirm.setPadding(10, 10, 10, 10);
		linearLayoutConfirm.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
		linearLayoutConfirm.setOrientation(LinearLayout.VERTICAL);
		linearLayoutConfirm.setGravity(Gravity.CENTER);
		JButton jButtonConfirm = new JButton(getApplicationContext());
		jButtonConfirm.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		jButtonConfirm.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_confirm));
		linearLayoutConfirm.addView(jButtonConfirm);
		linearLayoutLeft.addView(linearLayoutConfirm);
		linearLayoutRoot.addView(linearLayoutLeft);
		
		LinearLayout linearLayoutRight = new LinearLayout(getApplicationContext());
		linearLayoutRight.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutRight.setOrientation(LinearLayout.VERTICAL);
		linearLayoutRight.setGravity(Gravity.RIGHT | Gravity.CENTER);
		linearLayoutRight.addView(getKeyboardView());
		linearLayoutRoot.addView(linearLayoutRight);
 		
		RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
  		relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT));
		relativeLayout.addView(linearLayoutRoot);
		ScrollView scrollView = new ScrollView(getApplicationContext());
		scrollView.addView(relativeLayout);
  		getContentPane().addView(scrollView);
		
	}
	/***
	 * get layout params for screen title
	 * 
	 * @return
	 */
	public LinearLayout.LayoutParams getLinearLayoutLayoutParams() {
		Style style = new Style(getApplicationContext());
		style.setMargin(10, 10, 10, 10);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(style.getMarginValue(AbstractActivity.LEFT), style.getMarginValue(AbstractActivity.TOP), style.getMarginValue(AbstractActivity.RIGHT), style.getMarginValue(AbstractActivity.BOTTOM));
		return layoutParams;
	}
	/***
	 * 
	 * @return
	 */
	private LinearLayout getKeyboardView(){
		LinearLayout linearLayout = new LinearLayout(getApplicationContext());
		linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		linearLayout.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
 		linearLayout.setOrientation(LinearLayout.VERTICAL);
		String[][] key = new String[][]{{"7","8","9"},{"4","5","6"},{"1","2","3"},{"DEL","0","OK"}};
		for(int i = 0; i < key.length;i++){
			LinearLayout linearLayoutRow = new LinearLayout(getApplicationContext());
			for(int j = 0 ; j < key[0].length; j++){
				JButton jButton = new JButton(getApplicationContext());
				jButton.setLayoutParams(new LinearLayout.LayoutParams(100, 120));
				jButton.setText(key[i][j]);
				linearLayoutRow.addView(jButton);
			}
			linearLayout.addView(linearLayoutRow);
		}
		return linearLayout;
	}

}
