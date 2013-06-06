package com.ascentcomtec.smarthouse.ui.portlets.control;

import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.ascentcomtec.smarthouse.R;
import com.ascentcomtec.smarthouse.ui.activities.AbstractActivity;
import com.ascentcomtec.smarthouse.ui.components.HAFormFactory;
import com.ascentcomtec.smarthouse.ui.components.button.JButton;
import com.ascentcomtec.smarthouse.ui.components.textview.JTextView;
import com.ascentcomtec.smarthouse.ui.plaf.Style;
import com.ascentcomtec.smarthouse.ui.portlets.usermanage.AddUser;
import com.ascentcomtec.smarthouse.ui.portlets.usermanage.DeleteUser;
import com.ascentcomtec.smarthouse.ui.portlets.usermanage.EditUser;
import com.resolutiondev.ui.drawable.JDrawable;

public class UserManage extends HAFormFactory implements OnItemClickListener,OnItemSelectedListener{

	private ListView listViewUser;
	
	@Override
	public void executeUI() {
		setTitle("Users Manage");
		
		LinearLayout linearLayoutRoot = new LinearLayout(getApplicationContext());
		linearLayoutRoot.setLayoutParams(getLinearLayoutLayoutParams());
		linearLayoutRoot.setPadding(10, 10, 10, 10);
		linearLayoutRoot.setOrientation(LinearLayout.HORIZONTAL);
		
		LinearLayout linearLayoutLeft = new LinearLayout(getApplicationContext());
		linearLayoutLeft.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutLeft.setOrientation(LinearLayout.VERTICAL);
		linearLayoutLeft.setGravity(Gravity.LEFT);
		JTextView jTextView = new JTextView(getApplicationContext());
		jTextView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		jTextView.setText("Current Users");
		linearLayoutLeft.addView(jTextView);
		listViewUser = new ListView(getApplicationContext());
		listViewUser.setBackgroundDrawable(JDrawable.getJDrawable()
				.drawRoundRect(new float[] { 10, 10, 10, 10, 10, 10, 10, 10 }, 3, Color.BLACK));
		String[] devices = new String[] { "User One", "User Two", "User Three",
				"User Four", "User Five", "User Six", "User Seven", "User Eight",
				"User Nine", "User Ten" };
        // Instantiating array adapter to populate the listView
        // The layout android.R.layout.simple_list_item_single_choice creates radio button for each listview item
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice,devices);
        listViewUser.setAdapter(adapter);
        listViewUser.setOnItemClickListener(this);   
        listViewUser.setOnItemSelectedListener(this);   
        listViewUser.setChoiceMode(ListView.CHOICE_MODE_SINGLE);   
        listViewUser.setItemChecked(0, true);  
        linearLayoutLeft.addView(listViewUser);
		linearLayoutRoot.addView(linearLayoutLeft);
		
		LinearLayout linearLayoutRight = new LinearLayout(getApplicationContext());
		linearLayoutRight.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT, 1));
		linearLayoutRight.setOrientation(LinearLayout.VERTICAL);
		linearLayoutRight.setGravity(Gravity.RIGHT | Gravity.CENTER);
		
		JButton jButtonAddMonitoredAppliance = new JButton(getApplicationContext());
		jButtonAddMonitoredAppliance.setLayoutParams(getLinearLayoutLayoutParam());
		jButtonAddMonitoredAppliance.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_add_user));
		jButtonAddMonitoredAppliance.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
 				Intent intent = new Intent(UserManage.this, AddUser.class);
 				startActivity(intent);
			}
		});
		linearLayoutRight.addView(jButtonAddMonitoredAppliance);
		
		JButton jButtonAddAddUnMonitoredAppliance = new JButton(getApplicationContext());
		jButtonAddAddUnMonitoredAppliance.setLayoutParams(getLinearLayoutLayoutParam());
		jButtonAddAddUnMonitoredAppliance.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_edit_user));
		jButtonAddAddUnMonitoredAppliance.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
 				Intent intent = new Intent(UserManage.this, EditUser.class);
 				startActivity(intent);
			}
		});
		linearLayoutRight.addView(jButtonAddAddUnMonitoredAppliance);
		
		JButton jButtonEditAppliance = new JButton(getApplicationContext());
		jButtonEditAppliance.setLayoutParams(getLinearLayoutLayoutParam());
		jButtonEditAppliance.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_delete_user));
		jButtonEditAppliance.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
 				Intent intent = new Intent(UserManage.this, DeleteUser.class);
 				startActivity(intent);
			}
		});
		linearLayoutRight.addView(jButtonEditAppliance);
				
 		linearLayoutRoot.addView(linearLayoutRight);
 		
		RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
  		relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT));
		relativeLayout.addView(linearLayoutRoot);
   		getContentPane().addView(relativeLayout);
		
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		listViewUser.setItemChecked(arg2, true); 
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
 		
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
 		
	}
 
	/***
	 * get layout params for screen title
	 * 
	 * @return
	 */
	public LinearLayout.LayoutParams getLinearLayoutLayoutParam() {
		Style style = new Style(getApplicationContext());
		style.setMargin(10, 10, 10, 10);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(style.getMarginValue(AbstractActivity.LEFT), style.getMarginValue(AbstractActivity.TOP), style.getMarginValue(AbstractActivity.RIGHT), style.getMarginValue(AbstractActivity.BOTTOM));
		return layoutParams;
	}
	/***
	 * get layout params for screen title
	 * 
	 * @return
	 */
	public LinearLayout.LayoutParams getLinearLayoutLayoutParams() {
		Style style = new Style(getApplicationContext());
		style.setMargin(10, 10, 10, 10);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
		layoutParams.setMargins(style.getMarginValue(AbstractActivity.LEFT), style.getMarginValue(AbstractActivity.TOP), style.getMarginValue(AbstractActivity.RIGHT), style.getMarginValue(AbstractActivity.BOTTOM));
		return layoutParams;
	}
}
