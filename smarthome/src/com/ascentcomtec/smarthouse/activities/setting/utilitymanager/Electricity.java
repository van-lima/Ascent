package com.ascentcomtec.smarthouse.activities.setting.utilitymanager;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.ascentcomtec.smarthouse.R;
import com.ascentcomtec.smarthouse.base.BaseActivity;
import com.wheel.adapter.ArrayWheelAdapter;
import com.wheel.adapter.NumericWheelAdapter;
import com.wheel.widget.WheelView;

public class Electricity extends BaseActivity implements OnClickListener {

	private ViewPager viewPager;
	private MyPagerAdapter adapter;
	private Button leftButton, rightButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewpage_activity);
		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
		}
		initControl();
		setTitle(getString(R.string.energy_costs));
		setButtonListener();
	}

	/**
	 * this function init for all controls by ID
	 */
	@Override
	protected void initControl() {
		super.initControl();
		adapter = new MyPagerAdapter();
		viewPager = (ViewPager) findViewById(R.id.myWheelViewElectricity);
		viewPager.setAdapter(adapter);
		viewPager.setCurrentItem(0);
		leftButton = (Button) findViewById(R.id.myButtonLeft);
		rightButton = (Button) findViewById(R.id.myButtonRight);
		leftButton.setVisibility(View.INVISIBLE);
		leftButton.setOnClickListener(this);
		rightButton.setOnClickListener(this);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				if (arg0 == 0) {
					leftButton.setVisibility(View.INVISIBLE);
					rightButton.setVisibility(View.VISIBLE);
				} else if (arg0 == 1) {
					leftButton.setVisibility(View.VISIBLE);
					rightButton.setVisibility(View.INVISIBLE);
				}

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	@Override
	protected void setButtonListener() {
		super.setButtonListener();
		settingBt.setOnClickListener(this);

	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	private class MyPagerAdapter extends PagerAdapter {
		private WheelView hourWheelStart, minuteWheelStart, ampmWheelStart,
				hourWheelFinish, minuteWheelFinish, ampmWheelFinish;

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
				resId = R.layout.electricity_manage_page1_activity;
				view = inflater.inflate(resId, null);
				hourWheelStart = (WheelView) view
						.findViewById(R.id.myWheelViewHourStart);
				minuteWheelStart = (WheelView) view
						.findViewById(R.id.myWheelViewMinStart);
				ampmWheelStart = (WheelView) view
						.findViewById(R.id.myWheelViewAmPmStart);
				hourWheelFinish = (WheelView) view
						.findViewById(R.id.myWheelViewHourFinish);
				minuteWheelFinish = (WheelView) view
						.findViewById(R.id.myWheelViewMinFinish);
				ampmWheelFinish = (WheelView) view
						.findViewById(R.id.myWheelViewAmPmFinish);

				hourWheelStart.setViewAdapter(new NumericWheelAdapter(
						getApplicationContext(), 0, 23));
				hourWheelFinish.setViewAdapter(new NumericWheelAdapter(
						getApplicationContext(), 0, 23));

				minuteWheelStart.setViewAdapter(new NumericWheelAdapter(
						getApplicationContext(), 0, 59, "%02d"));
				minuteWheelStart.setCyclic(true);

				minuteWheelFinish.setViewAdapter(new NumericWheelAdapter(
						getApplicationContext(), 0, 59, "%02d"));
				minuteWheelFinish.setCyclic(true);

				ArrayWheelAdapter<String> ampmAdapter = new ArrayWheelAdapter<String>(
						getApplicationContext(), new String[] { "AM", "PM" });
				ampmAdapter.setItemResource(R.layout.wheel_text_item);
				ampmAdapter.setItemTextResource(R.id.text);
				ampmWheelStart.setViewAdapter(ampmAdapter);
				ampmWheelFinish.setViewAdapter(ampmAdapter);

				break;
			case 1:
				resId = R.layout.electricity_manage_page2_activity;
				view = inflater.inflate(resId, null);
				view.findViewById(R.id.myButtonDone).setOnClickListener(
						new OnClickListener() {
							@Override
							public void onClick(View v) {
								finish();
							}
						});
				break;
			default:
				resId = R.layout.electricity_manage_page2_activity;
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
		switch (v.getId()) {
		case R.id.myButtonLeft:
			viewPager.setCurrentItem(0);
			break;
		case R.id.myButtonRight:
			viewPager.setCurrentItem(1);
			break;
		default:
			break;
		}
	}

}
