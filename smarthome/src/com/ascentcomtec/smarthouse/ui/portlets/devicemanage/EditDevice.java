package com.ascentcomtec.smarthouse.ui.portlets.devicemanage;

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

public class EditDevice extends HAFormFactory{

	@Override
	public void executeUI() {
		setTitle("Edit Device");
		
		LinearLayout linearLayoutRoot = new LinearLayout(getApplicationContext());
		linearLayoutRoot.setPadding(10, 10, 10, 10);
		linearLayoutRoot.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
		linearLayoutRoot.setOrientation(LinearLayout.VERTICAL);
		
		LinearLayout linearLayoutControl = new LinearLayout(getApplicationContext());
		linearLayoutControl.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT ));
		linearLayoutControl.setOrientation(LinearLayout.HORIZONTAL);
		
		
		LinearLayout linearLayoutLeft = new LinearLayout(getApplicationContext());
		linearLayoutLeft.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutLeft.setOrientation(LinearLayout.VERTICAL);
		linearLayoutLeft.setGravity(Gravity.CENTER);
		linearLayoutLeft.addView(getView("Device One", new EditText(getApplicationContext())));
		linearLayoutLeft.addView(getView("Mac Address", new EditText(getApplicationContext())));
		linearLayoutControl.addView(linearLayoutLeft);
 		
		LinearLayout linearLayoutRight = new LinearLayout(getApplicationContext());
		linearLayoutRight.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutRight.setOrientation(LinearLayout.VERTICAL);
		linearLayoutRight.setGravity(Gravity.CENTER);
		ListView listViewUserType = new ListView(getApplicationContext());
		listViewUserType.setBackgroundDrawable(JDrawable.getJDrawable()
				.drawRoundRect(new float[] { 10, 10, 10, 10, 10, 10, 10, 10 }, 3, Color.BLACK));
		String[] userType = new String[] { "Device One", "Device Two"};
        // Instantiating array adapter to populate the listView
        // The layout android.R.layout.simple_list_item_single_choice creates radio button for each listview item
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, userType);
        listViewUserType.setAdapter(adapter);
        listViewUserType.setChoiceMode(ListView.CHOICE_MODE_SINGLE);   
        listViewUserType.setItemChecked(0, true); 
        linearLayoutRight.addView(listViewUserType);
        linearLayoutControl.addView(linearLayoutRight);
        linearLayoutRoot.addView(linearLayoutControl);
        
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
		linearLayoutRoot.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		linearLayoutRoot.setOrientation(LinearLayout.VERTICAL);
		linearLayoutRoot.setGravity(Gravity.LEFT | Gravity.CENTER);

 		JTextView jTextView = new JTextView(getApplicationContext());
		jTextView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		jTextView.setText(lable);
		jTextView.setGravity(Gravity.LEFT | Gravity.CENTER);
		linearLayoutRoot.addView(jTextView);
  		
 		editText.setBackgroundDrawable(JDrawable.getJDrawable()
				.drawRoundRect(new float[] { 10, 10, 10, 10, 10, 10, 10, 10 }, 3, Color.BLACK));
 		linearLayoutRoot.addView(editText);
  		return linearLayoutRoot;
	}
	 
}
