package com.ascentcomtec.smarthouse.doas;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * This class helps open, create, and upgrade the database file.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
	public static final String DEVICE_TABLE_NAME = "fb_friend";
	private SQLiteDatabase sqLiteDatabase;
	public static final int DATABASE_VERSION = 5;

	public DatabaseHelper(Context context, String databaseName) {
		super(context, databaseName, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		db.execSQL("CREATE TABLE " + DEVICE_TABLE_NAME + " (" + DeviceTable._ID
				+ " NUMERIC  PRIMARY KEY," + DeviceTable.DEV + "Text );");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + Connection.DATABASE_NAME);
		onCreate(db);
	}

	public int makeQuery(String query) {
		try {
			sqLiteDatabase.execSQL(query);
			return 1;
		} catch (SQLException sqlException) {
			return 0;
		}

	}

	public Cursor queueAllDevices() {
		Cursor cursor = sqLiteDatabase.rawQuery("select * from "
				+ DEVICE_TABLE_NAME, null);
		return cursor;
	}

	public Cursor getCursor(String query) {
		Cursor cursor = sqLiteDatabase.rawQuery(query, null);
		return cursor;
	}

	public void dropFriendTable() {

	}

	/**
	 * 
	 * @return
	 */
	public int openSession() {
		try {
			sqLiteDatabase = getWritableDatabase();
			return 1;
		} catch (RuntimeException runtimeException) {
			return 0;
		}
	}

	/**
	 * closes the database
	 */
	public void closeSession() {
		try {
			sqLiteDatabase.close();
		} catch (RuntimeException runtimeException) {
			runtimeException.printStackTrace();
		}

	}

}
