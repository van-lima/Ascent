package com.ascentcomtec.smarthouse;

import java.util.ArrayList;

import com.ascentcomtec.smarthouse.constant.Clusters;
import com.ascentcomtec.smarthouse.model.Cluster;
import com.ascentcomtec.smarthouse.utils.Utils;

public class Application {
	
	public static String UserDataPath = "/data/data/"+Application.class.getPackage().getName()+"/";
	
	public static boolean isSearchStart=false;
	public static boolean isInitialize=false;
	public static boolean isEnableLocalCIE=false;

	public static ArrayList<String> defaultClusterDes = new ArrayList<String>();
	public static ArrayList<Cluster> defaultCluster = new ArrayList<Cluster>();
	
	static
	{
		addDefaultCluster(0x0006);
		addDefaultCluster(0x0008);
		addDefaultCluster(0x000C);
		addDefaultCluster(0x000D);
		addDefaultCluster(0x000E);
		addDefaultCluster(0x000F);
		addDefaultCluster(0x0010);
		addDefaultCluster(0x0011);
		addDefaultCluster(0x0012);
		addDefaultCluster(0x0013);
		addDefaultCluster(0x0014);
		addDefaultCluster(0x0200);
		addDefaultCluster(0x0201);
		addDefaultCluster(0x0203);
		addDefaultCluster(0x0300);
		addDefaultCluster(0x0400);
		addDefaultCluster(0x0401);
		addDefaultCluster(0x0402);
		addDefaultCluster(0x0403);
		addDefaultCluster(0x0404);
		addDefaultCluster(0x0405);
		addDefaultCluster(0x0406);
	}
	
	
	public static void addDefaultCluster(int num) {
		Cluster c = Clusters.getClusterById(num);
		defaultCluster.add(c);
		defaultClusterDes.add(Utils.Int2Hex(c.ID,4)+"--"+c.Name);
	}
}
