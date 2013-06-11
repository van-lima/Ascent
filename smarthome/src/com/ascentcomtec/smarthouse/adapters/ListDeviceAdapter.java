package com.ascentcomtec.smarthouse.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ascentcomtec.smarthouse.R;
import com.netvox.zbapi.java.model.CZBNode;

public class ListDeviceAdapter extends BaseAdapter {

	private ArrayList<CZBNode> items;
	private static LayoutInflater inflater = null;
	private int posCheck = -1;

	public ListDeviceAdapter(Context context, ArrayList<CZBNode> items) {
		this.items = items;
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return items.size();
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		Holder holder = null;
		if (vi == null) {
			vi = inflater.inflate(R.layout.lis_device_item, null);
			holder = new Holder();
			holder.name = (TextView) vi.findViewById(R.id.myTextviewDeviceName);
			holder.isCheck = (ImageView) vi.findViewById(R.id.id_playing_flag);
			vi.setTag(holder);
		} else {
			holder = (Holder) vi.getTag();
		}
		if (position == posCheck) {
			holder.isCheck.setVisibility(View.VISIBLE);
		} else {
			holder.isCheck.setVisibility(View.INVISIBLE);
		}
		holder.name.setText(items.get(position).m_ZBNodeAttr.Name);
		return vi;
	}

	static class Holder {
		public TextView name;
		public ImageView isCheck;
	}

	public void setCheck(int pos) {
		this.posCheck = pos;
	}
	public void removeAllItem(){
		items = null;
		items = new ArrayList<CZBNode>();
	}

	public void addItems(ArrayList<CZBNode> additional) {
		items.addAll(additional);
	}
}