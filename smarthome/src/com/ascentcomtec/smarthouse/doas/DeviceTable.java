/*
 * Name: $RCSfile: MeaageTable.java,v $
 * Version: $Revision: 1.1 $
 * Date: $Date: Aug 15, 2012 2:30:56 PM $
 *
 * Copyright (C) 2011 COMPANY_NAME, Inc. All rights reserved.
 */

package com.ascentcomtec.smarthouse.doas;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.provider.BaseColumns;

import com.netvox.zbapi.java.model.CEndPoint;

/**
 * @author Ducv
 * 
 */
public class DeviceTable implements BaseColumns {

	public static final String _ID = "index";
	public static final String DEV = "dev";

	public static void insert(Context ctx, CEndPoint cEndPoint) {
		// Get user information
		Connection connection = Connection.getConnection(ctx);
		connection.openSession();

		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO " + DatabaseHelper.DEVICE_TABLE_NAME
				+ " VALUES (");
		query.append(cEndPoint.index);
		query.append(")");
		connection.makeQuery(query.toString());
		connection.closeSession();
	}

	public static void insert(Context ctx, CEndPoint cEndPoint,
			Connection connection) {
		// Get user information
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO " + DatabaseHelper.DEVICE_TABLE_NAME
				+ " VALUES (");
		query.append(cEndPoint.index);
		query.append(")");
		connection.makeQuery(query.toString());
	}

	/**
	 * (update exist message in database)
	 * 
	 * @author Ducv
	 * @param ctx
	 * @param message
	 * 
	 */
	public static void update(Context ctx, CEndPoint cEndPoint) {
		Connection connection = Connection.getConnection(ctx);
		connection.openSession();
		delete(ctx, cEndPoint.index, connection);
		insert(ctx, cEndPoint, connection);
		connection.closeSession();
	}

	public static void delete(Context ctx, int _id) {
		Connection connection = Connection.getConnection(ctx);
		connection.openSession();
		try {
			StringBuilder query = new StringBuilder("DELETE FROM "
					+ DatabaseHelper.DEVICE_TABLE_NAME + " WHERE " + _ID
					+ " = ");
			query.append(_id);
			connection.makeQuery(query.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
		connection.closeSession();
	}

	public static void delete(Context ctx, int _id,
			Connection connection) {
		try {
			StringBuilder query = new StringBuilder("DELETE FROM "
					+ DatabaseHelper.DEVICE_TABLE_NAME + " WHERE " + _ID
					+ " = ");
			query.append(_id);
			connection.makeQuery(query.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static CEndPoint getBySocialId(Context ctx, int _id) {
		CEndPoint cEndPoint = null;
		Connection connection = Connection.getConnection(ctx);
		connection.openSession();
		StringBuilder query = new StringBuilder("SELECT * FROM "
				+ DatabaseHelper.DEVICE_TABLE_NAME + " WHERE " + _ID
				+ " = ");
		query.append(_id);
		Cursor messageCursor = connection.getCursor(query.toString());
		if (messageCursor.moveToFirst()) {
			cEndPoint = getRow(messageCursor);
		} else {
			messageCursor.close();
			connection.closeSession();
			return null;
		}
		messageCursor.close();
		connection.closeSession();
		return cEndPoint;
	}

	/**
	 * @author Ducv
	 * @param ctx
	 * @return
	 */
	public static ArrayList<CEndPoint> selectAll(Context ctx) {
		ArrayList<CEndPoint> listCEndPoint = new ArrayList<CEndPoint>();
		Connection connection = Connection.getConnection(ctx);
		connection.openSession();
		Cursor messageCursor;
		try {
			messageCursor = connection.queueAllDevices();
			if (messageCursor.moveToFirst()) {
				do {
					CEndPoint cEndPoint = getRow(messageCursor);
					listCEndPoint.add(cEndPoint);
				} while (messageCursor.moveToNext());
				messageCursor.close();
				connection.closeSession();
				return listCEndPoint;
			} else {
				messageCursor.close();
				connection.closeSession();
				return null;
			}

		} catch (Exception e) {
			connection.closeSession();
		}
		return null;
	}

	/**
	 * @author Ducv
	 * @param ctx
	 * @param numberMessage
	 * @return
	 */
	public static ArrayList<CEndPoint> getListMessage(Context ctx, int first,
			int last) {
		ArrayList<CEndPoint> eventList = new ArrayList<CEndPoint>();
		Connection connection = Connection.getConnection(ctx);
		connection.openSession();
		StringBuilder query = new StringBuilder("SELECT * FROM "
				+ DatabaseHelper.DEVICE_TABLE_NAME + " ORDER BY send_date DESC");
		Cursor messageCursor = connection.getCursor(query.toString());
		int index = first;
		if (messageCursor.moveToPosition(first)) {
			do {
				index++;
				CEndPoint cEndPoint = getRow(messageCursor);
				eventList.add(cEndPoint);
			} while (messageCursor.moveToNext() && (index < (last - first)));

		}
		messageCursor.close();
		connection.closeSession();
		return eventList;
	}

	/**
	 * @author Ducv
	 * @param ctx
	 * @param numberMessage
	 * @return
	 */
	public static CEndPoint getOne(Context ctx, int position) {
		CEndPoint cEndPoint = new CEndPoint();
		Connection connection = Connection.getConnection(ctx);
		connection.openSession();
		StringBuilder query = new StringBuilder("SELECT * FROM "
				+ DatabaseHelper.DEVICE_TABLE_NAME + " ORDER BY send_date DESC");
		Cursor messageCursor = connection.getCursor(query.toString());
		if (messageCursor.moveToPosition(position)) {
			cEndPoint = getRow(messageCursor);

		} else {
			messageCursor.close();
			connection.closeSession();
			return null;
		}
		messageCursor.close();
		connection.closeSession();
		return cEndPoint;
	}

	/**
	 * @author Ducv
	 * @param ctx
	 * @param numberMessage
	 * @return
	 */
	public static CEndPoint getFirst(Context ctx) {
		CEndPoint cEndPoint = new CEndPoint();
		Connection connection = Connection.getConnection(ctx);
		connection.openSession();
		StringBuilder query = new StringBuilder("SELECT * FROM "
				+ DatabaseHelper.DEVICE_TABLE_NAME);
		Cursor messageCursor = connection.getCursor(query.toString());
		if (messageCursor.moveToFirst()) {
			cEndPoint = getRow(messageCursor);

		} else {
			messageCursor.close();
			connection.closeSession();
			return null;
		}
		messageCursor.close();
		connection.closeSession();
		return cEndPoint;
	}

	/**
	 * @author Ducv
	 * @param eventsCursor
	 * @return
	 */
	private static CEndPoint getRow(Cursor eventsCursor) {
		CEndPoint cEndPoint = new CEndPoint();
		cEndPoint.index = eventsCursor.getInt(eventsCursor.getColumnIndex(_ID));
		cEndPoint.dev = eventsCursor
				.getString(eventsCursor.getColumnIndex(DEV));
		return cEndPoint;
	}
}
