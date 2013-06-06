package com.ascentcomtec.smarthouse.model;

import java.util.ArrayList;

public class Cluster {
	
	public int ID;
	public String Name;
	public ArrayList<Attribute> attributes =new ArrayList<Attribute>();
	
	public void AddAttribute(Attribute attr)
	{
		attributes.add(attr);
	
	}

}
