package com.ascentcomtec.smarthouse.activities.setting.devicemanager;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.ascentcomtec.smarthouse.R;
import com.ascentcomtec.smarthouse.adapters.ListAdapter;
import com.ascentcomtec.smarthouse.base.BaseActivity;

public class EditDevice extends BaseActivity implements OnClickListener {

	private ViewPager viewPager;
	private MyPagerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_device_activity);
		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
		}
		initControl();
		setTitle(getString(R.string.edit_device));
		setButtonListener();
	}

	/**
	 * this function init for all controls by ID
	 */
	@Override
	protected void initControl() {
		super.initControl();
		adapter = new MyPagerAdapter();
		viewPager = (ViewPager) findViewById(R.id.myViewPageAddDevice);
		viewPager.setAdapter(adapter);
		viewPager.setCurrentItem(0);
	}

	@Override
	protected void setButtonListener() {
		super.setButtonListener();
		helpBt.setOnClickListener(this);
		homeBt.setOnClickListener(this);
		settingBt.setOnClickListener(this);

	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	private class MyPagerAdapter extends PagerAdapter {

		private String[] Objects = { "A/C", "Fridge", "Freezer",
				"Fridge/Freezer Combo", "Hot Water Service", "Stove Top", "TV",
				"Computer", "Printers", "Lights" };
		private ListView listUser;
		private ListAdapter listUserAdapter;

		public int getCount() {
			return 2;
		}

		public Object instantiateItem(View collection, int position) {

			LayoutInflater inflater = (LayoutInflater) collection.getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			int resId = 0;
			View view;
			switch (position) {
			case 0:
				resId = R.layout.add_device_page1_activity;
				view = inflater.inflate(resId, null);
				Button nextButton = (Button) view
						.findViewById(R.id.myButtonNext);
				nextButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						viewPager.setCurrentItem(1, true);
					}
				});

				listUser = (ListView) view.findViewById(R.id.myListViewDevices);

				listUser.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int pos, long arg3) {
						listUserAdapter.setCheck(pos);
						listUserAdapter.notifyDataSetChanged();
					}
				});
				listUserAdapter = new ListAdapter(getApplicationContext(),
						Objects);
				listUser.setAdapter(listUserAdapter);
				listUser.setAnimationCacheEnabled(true);
				listUser.setAlwaysDrawnWithCacheEnabled(true);
				listUser.setCacheColorHint(0x000000);
				listUserAdapter.setCheck(0);
				listUserAdapter.notifyDataSetChanged();

				break;
			case 1:
				resId = R.layout.add_device_page2_activity;
				view = inflater.inflate(resId, null);
				Button confirmButton = (Button) view
						.findViewById(R.id.myButtonConfirm);
				confirmButton.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
					}
				});
				break;
			default:
				view = inflater.inflate(resId, null);
				break;
			}

			((ViewPager) collection).addView(view, 0);
			return view;
		}

		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			((ViewPager) arg0).removeView((View) arg2);

		}

		@Override
		public void finishUpdate(View arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == ((View) arg1);

		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public Parcelable saveState() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void startUpdate(View arg0) {
			// TODO Auto-generated method stub

		}

	}

	@Override
	public void onClick(View v) {

	}

}
