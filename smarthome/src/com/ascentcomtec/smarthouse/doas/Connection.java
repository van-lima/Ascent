package com.ascentcomtec.smarthouse.doas;
import android.content.Context;

public class Connection extends DatabaseHelper {
	public static final String DATABASE_NAME = "devices_database";
	public Connection(Context context,String databaseName) {
		super(context,databaseName);
	}
	public static Connection getConnection(Context context) {
		Connection connection = new Connection(context,DATABASE_NAME);
		return connection;
	}

}
