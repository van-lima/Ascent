package com.ascentcomtec.smarthouse.model;

import android.widget.LinearLayout;

import com.netvox.zbapi.java.constant.RtDeviceType;

public class NeighborhoorData {
	
	public String IEEE;
	public String ModelID;
	public String Name;
	public RtDeviceType type;
	public int LQI;
	public LinearLayout ly;
	
	public String toString()
	{
		return "[IEEE:"+IEEE+",ModeID:"+ModelID+",Name:"+Name+",Type:"+type.name()+",LQI:"+LQI+"]";
	}

}
