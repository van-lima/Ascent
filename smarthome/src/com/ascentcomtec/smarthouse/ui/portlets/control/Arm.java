package com.ascentcomtec.smarthouse.ui.portlets.control;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.ascentcomtec.smarthouse.ui.components.HAFormFactory;
import com.ascentcomtec.smarthouse.ui.components.button.JButton;
import com.ascentcomtec.smarthouse.ui.components.textview.JTextView;
import com.resolutiondev.ui.drawable.JDrawable;

public class Arm extends HAFormFactory{

	@Override
	public void executeUI() {
		setTitle("Arm");
		
		LinearLayout linearLayoutRoot = new LinearLayout(getApplicationContext());
		linearLayoutRoot.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
		linearLayoutRoot.setOrientation(LinearLayout.HORIZONTAL);
		
		LinearLayout linearLayoutLeft = new LinearLayout(getApplicationContext());
		linearLayoutLeft.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutLeft.setOrientation(LinearLayout.VERTICAL);
		linearLayoutLeft.setGravity(Gravity.LEFT);
		JTextView jTextView = new JTextView(getApplicationContext());
		jTextView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		jTextView.setText("Enter User PIN to Arm Security");
		linearLayoutLeft.addView(jTextView);
		JTextView editText = new JTextView(getApplicationContext());
 		editText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, 80));
		editText.setBackgroundDrawable(JDrawable.getJDrawable()
				.drawRoundRect(new float[] { 10, 10, 10, 10, 10, 10, 10, 10 }, 3, Color.BLACK));
		linearLayoutLeft.addView(editText);
		JButton jButtonConfirm = new JButton(getApplicationContext());
		jButtonConfirm.setText("Confirm");
		linearLayoutLeft.addView(jButtonConfirm);
		linearLayoutRoot.addView(linearLayoutLeft);
		
		LinearLayout linearLayoutRight = new LinearLayout(getApplicationContext());
		linearLayoutRight.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutRight.setOrientation(LinearLayout.VERTICAL);
		linearLayoutRight.setGravity(Gravity.RIGHT);
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
