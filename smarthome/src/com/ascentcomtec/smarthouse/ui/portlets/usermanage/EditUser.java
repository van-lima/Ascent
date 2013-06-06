package com.ascentcomtec.smarthouse.ui.portlets.usermanage;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.ascentcomtec.smarthouse.R;
import com.ascentcomtec.smarthouse.ui.components.HAFormFactory;
import com.ascentcomtec.smarthouse.ui.components.button.JButton;
import com.ascentcomtec.smarthouse.ui.components.textview.JTextView;
import com.resolutiondev.ui.drawable.JDrawable;

public class EditUser extends HAFormFactory{

	@Override
	public void executeUI() {
		setTitle("Edit User");
		LinearLayout linearLayoutRoot = new LinearLayout(getApplicationContext());
		linearLayoutRoot.setPadding(10, 10, 10, 10);
		linearLayoutRoot.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutRoot.setOrientation(LinearLayout.VERTICAL);
		linearLayoutRoot.addView(getView("User Name", new EditText(getApplicationContext())));
		ListView listViewUserType = new ListView(getApplicationContext());
		listViewUserType.setBackgroundDrawable(JDrawable.getJDrawable()
				.drawRoundRect(new float[] { 10, 10, 10, 10, 10, 10, 10, 10 }, 3, Color.BLACK));
		String[] userType = new String[] { "Administrator", "Limited"};
        // Instantiating array adapter to populate the listView
        // The layout android.R.layout.simple_list_item_single_choice creates radio button for each listview item
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, userType);
        listViewUserType.setAdapter(adapter);
        listViewUserType.setChoiceMode(ListView.CHOICE_MODE_SINGLE);   
        listViewUserType.setItemChecked(0, true); 
		linearLayoutRoot.addView(getView("User Type", listViewUserType));
		LinearLayout linearLayoutLable = new LinearLayout(getApplicationContext());
		linearLayoutLable.setPadding(10, 10, 10, 10);
		linearLayoutLable.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutLable.setOrientation(LinearLayout.VERTICAL);
		linearLayoutLable.setGravity(Gravity.CENTER);
		JTextView jTextView = new JTextView(getApplicationContext());
		jTextView.setGravity(Gravity.CENTER);
		jTextView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
		jTextView.setText("Change PIN");
		linearLayoutLable.addView(jTextView);
		linearLayoutRoot.addView(linearLayoutLable);
		linearLayoutRoot.addView(getView("New PIN", new EditText(getApplicationContext())));
		linearLayoutRoot.addView(getView("Re-Type New PIN", new EditText(getApplicationContext())));
		
		LinearLayout linearLayoutConfirm = new LinearLayout(getApplicationContext());
		linearLayoutConfirm.setPadding(10, 10, 10, 10);
		linearLayoutConfirm.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutConfirm.setOrientation(LinearLayout.VERTICAL);
		linearLayoutConfirm.setGravity(Gravity.CENTER);
		JButton jButtonConfirm = new JButton(getApplicationContext());
		jButtonConfirm.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		jButtonConfirm.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_confirm));
		linearLayoutConfirm.addView(jButtonConfirm);
		linearLayoutRoot.addView(linearLayoutConfirm);
		
 		RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
 		relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT));
 		relativeLayout.setBackgroundDrawable(new ColorDrawable(Color.GRAY));
		relativeLayout.addView(linearLayoutRoot);
		ScrollView scrollView = new ScrollView(getApplicationContext());
		scrollView.addView(relativeLayout);
  		getContentPane().addView(scrollView);
	}
	/***
	 * 
	 * @return
	 */
	public LinearLayout getView(String lable, EditText editText){
		LinearLayout linearLayoutRoot = new LinearLayout(getApplicationContext());
		linearLayoutRoot.setPadding(10, 10, 10, 10);
		linearLayoutRoot.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutRoot.setOrientation(LinearLayout.HORIZONTAL);
		linearLayoutRoot.setGravity(Gravity.CENTER);

		LinearLayout linearLayoutLeft = new LinearLayout(getApplicationContext());
		linearLayoutLeft.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutLeft.setOrientation(LinearLayout.VERTICAL);
		linearLayoutLeft.setGravity(Gravity.RIGHT | Gravity.CENTER);
		JTextView jTextView = new JTextView(getApplicationContext());
		jTextView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
		jTextView.setText(lable + "   :  ");
		jTextView.setGravity(Gravity.RIGHT | Gravity.CENTER);
		linearLayoutLeft.addView(jTextView);
 		linearLayoutRoot.addView(linearLayoutLeft);
 		
 		LinearLayout linearLayoutRight = new LinearLayout(getApplicationContext());
		linearLayoutRight.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutRight.setOrientation(LinearLayout.VERTICAL);
		linearLayoutRight.setGravity(Gravity.RIGHT | Gravity.CENTER);
		editText.setBackgroundDrawable(JDrawable.getJDrawable()
				.drawRoundRect(new float[] { 10, 10, 10, 10, 10, 10, 10, 10 }, 3, Color.BLACK));
		linearLayoutRight.addView(editText);
 		linearLayoutRoot.addView(linearLayoutRight);
 		return linearLayoutRoot;
	}
	/***
	 * 
	 * @return
	 */
	public LinearLayout getView(String lable, ListView editText){
		LinearLayout linearLayoutRoot = new LinearLayout(getApplicationContext());
		linearLayoutRoot.setPadding(10, 10, 10, 10);
		linearLayoutRoot.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutRoot.setOrientation(LinearLayout.HORIZONTAL);
		linearLayoutRoot.setGravity(Gravity.CENTER);

		LinearLayout linearLayoutLeft = new LinearLayout(getApplicationContext());
		linearLayoutLeft.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutLeft.setOrientation(LinearLayout.VERTICAL);
		linearLayoutLeft.setGravity(Gravity.RIGHT | Gravity.CENTER);
		JTextView jTextView = new JTextView(getApplicationContext());
		jTextView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
		jTextView.setText(lable + "   :  ");
		jTextView.setGravity(Gravity.RIGHT | Gravity.CENTER);
		linearLayoutLeft.addView(jTextView);
 		linearLayoutRoot.addView(linearLayoutLeft);
 		
 		LinearLayout linearLayoutRight = new LinearLayout(getApplicationContext());
		linearLayoutRight.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutRight.setOrientation(LinearLayout.VERTICAL);
		linearLayoutRight.setGravity(Gravity.RIGHT | Gravity.CENTER);
		editText.setBackgroundDrawable(JDrawable.getJDrawable()
				.drawRoundRect(new float[] { 10, 10, 10, 10, 10, 10, 10, 10 }, 3, Color.BLACK));
		linearLayoutRight.addView(editText);
 		linearLayoutRoot.addView(linearLayoutRight);
 		return linearLayoutRoot;
	}
}
