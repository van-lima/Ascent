package com.ascentcomtec.smarthouse.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SmartHomeSharePreferents {
	private static String SMARTHOME_PREFERENT = "smarthome_prefer";

	/**
	 * put data to prefer
	 * 
	 * @param dataOfDay
	 * @param context
	 */
	public static void putDataWaterOfDay(float dataOfDay[], Context context) {
		for (int i = 0; i < dataOfDay.length; i++) {
			putFloatValue("day_data" + i, dataOfDay[i], context);
		}
	}

	public static float[] getDataWaterOfDay(Context context) {
		float dataOfDay[] = new float[7];
		for (int i = 0; i < dataOfDay.length; i++) {
			dataOfDay[i] = getFloatValue("day_data" + i, context);
		}
		return dataOfDay;
	}

	/**
	 * put data of week to prefer
	 * 
	 * @param dataOfDay
	 * @param context
	 */
	public static void putDataWaterOfWeek(float dataOfDay[], Context context) {
		for (int i = 0; i < dataOfDay.length; i++) {
			putFloatValue("week_data" + i, dataOfDay[i], context);
		}
	}

	public static float[] getDataWaterOfWeek(Context context) {
		float dataOfDay[] = new float[4];
		for (int i = 0; i < dataOfDay.length; i++) {
			dataOfDay[i] = getFloatValue("week_data" + i, context);
		}
		return dataOfDay;
	}

	/**
	 * put data of quarter to prefer
	 * 
	 * @param dataOfDay
	 * @param context
	 */
	public static void putDataWaterOfQuarter(float dataOfDay[],
			Context context) {
		for (int i = 0; i < dataOfDay.length; i++) {
			putFloatValue("quarter_data" + i, dataOfDay[i], context);
		}
	}

	public static float[] getDataWaterOfQuarter(Context context) {
		float dataOfDay[] = new float[4];
		for (int i = 0; i < dataOfDay.length; i++) {
			dataOfDay[i] = getFloatValue("quarter_data" + i, context);
		}
		return dataOfDay;
	}

	/**
	 * put data of four years to prefer
	 * 
	 * @param dataOfDay
	 * @param context
	 */
	public static void putDataWaterOfYear(float dataOfDay[], Context context) {
		for (int i = 0; i < dataOfDay.length; i++) {
			putFloatValue("year_data" + i, dataOfDay[i], context);
		}
	}

	public static float[]  getDataWaterOfYear(Context context) {
		float dataOfDay[] = new float[4];
		for (int i = 0; i < dataOfDay.length; i++) {
			dataOfDay[i] = getFloatValue("year_data" + i, context);
		}
		return dataOfDay;
	}

	/**
	 * put data to prefer
	 * 
	 * @param dataOfDay
	 * @param context
	 */
	public static void putDataWaterOfMonth(float dataOfDay[],
			Context context) {
		for (int i = 0; i < dataOfDay.length; i++) {
			putFloatValue("month_data" + i, dataOfDay[i], context);
		}
		
	}

	public static float[] getDataWaterOfMonth(Context context) {
		float dataOfDay[] = new float[12];
		for (int i = 0; i < dataOfDay.length; i++) {
			dataOfDay[i] = getFloatValue("month_data" + i, context);
		}
		return dataOfDay;
	}

	/**
	 * electricity
	 */

	/**
	 * put data to prefer
	 * 
	 * @param dataOfDay
	 * @param context
	 */
	public static void putDataElectricityOfDay(float dataOfDay[], Context context) {
		for (int i = 0; i < dataOfDay.length; i++) {
			putFloatValue("e_day_data" + i, dataOfDay[i], context);
		}
	}

	public static float[] getDataElectricityOfDay(Context context) {
		float dataOfDay[] = new float[7];
		for (int i = 0; i < dataOfDay.length; i++) {
			dataOfDay[i] = getFloatValue("e_day_data" + i, context);
		}
		return dataOfDay;
	}

	/**
	 * put data of week to prefer
	 * 
	 * @param dataOfDay
	 * @param context
	 */
	public static void putDataElectricityOfWeek(float dataOfDay[], Context context) {
		for (int i = 0; i < dataOfDay.length; i++) {
			putFloatValue("e_week_data" + i, dataOfDay[i], context);
		}
	}

	public static float[] getDataElectricityOfWeek(Context context) {
		float dataOfDay[] = new float[4];
		for (int i = 0; i < dataOfDay.length; i++) {
			dataOfDay[i] = getFloatValue("e_week_data" + i, context);
		}
		return dataOfDay;
	}

	/**
	 * put data of quarter to prefer
	 * 
	 * @param dataOfDay
	 * @param context
	 */
	public static void putDataElectricityOfQuarter(float dataOfDay[],
			Context context) {
		for (int i = 0; i < dataOfDay.length; i++) {
			putFloatValue("e_quarter_data" + i, dataOfDay[i], context);
		}
	}

	public static float[] getDataElectricityOfQuarter(Context context) {
		float dataOfDay[] = new float[4];
		for (int i = 0; i < dataOfDay.length; i++) {
			dataOfDay[i] = getFloatValue("e_quarter_data" + i, context);
		}
		return dataOfDay;
	}

	/**
	 * put data of four years to prefer
	 * 
	 * @param dataOfDay
	 * @param context
	 */
	public static void putDataElectricityOfYear(float dataOfDay[], Context context) {
		for (int i = 0; i < dataOfDay.length; i++) {
			putFloatValue("e_year_data" + i, dataOfDay[i], context);
		}
	}

	public static float[]  getDataElectricityOfYear(Context context) {
		float dataOfDay[] = new float[4];
		for (int i = 0; i < dataOfDay.length; i++) {
			dataOfDay[i] = getFloatValue("e_year_data" + i, context);
		}
		return dataOfDay;
	}

	/**
	 * put data to prefer
	 * 
	 * @param dataOfDay
	 * @param context
	 */
	public static void putDataElectricityOfMonth(float dataOfDay[],
			Context context) {
		for (int i = 0; i < dataOfDay.length; i++) {
			putFloatValue("e_month_data" + i, dataOfDay[i], context);
		}
		
	}

	public static float[] getDataElectricityOfMonth(Context context) {
		float dataOfDay[] = new float[12];
		for (int i = 0; i < dataOfDay.length; i++) {
			dataOfDay[i] = getFloatValue("e_month_data" + i, context);
		}
		return dataOfDay;
	}

	/**
	 * Gas
	 */
	/**
	 * put data to prefer
	 * 
	 * @param dataOfDay
	 * @param context
	 */
	public static void putDataGasOfDay(float dataOfDay[], Context context) {
		for (int i = 0; i < dataOfDay.length; i++) {
			putFloatValue("g_day_data" + i, dataOfDay[i], context);
		}
	}

	public static float[] getDataGasOfDay(Context context) {
		float dataOfDay[] = new float[7];
		for (int i = 0; i < dataOfDay.length; i++) {
			dataOfDay[i] = getFloatValue("g_day_data" + i, context);
		}
		return dataOfDay;
	}

	/**
	 * put data of week to prefer
	 * 
	 * @param dataOfDay
	 * @param context
	 */
	public static void putDataGasOfWeek(float dataOfDay[], Context context) {
		for (int i = 0; i < dataOfDay.length; i++) {
			putFloatValue("g_week_data" + i, dataOfDay[i], context);
		}
	}

	public static float[] getDataGasOfWeek(Context context) {
		float dataOfDay[] = new float[4];
		for (int i = 0; i < dataOfDay.length; i++) {
			dataOfDay[i] = getFloatValue("g_week_data" + i, context);
		}
		return dataOfDay;
	}

	/**
	 * put data of quarter to prefer
	 * 
	 * @param dataOfDay
	 * @param context
	 */
	public static void putDataGasOfQuarter(float dataOfDay[],
			Context context) {
		for (int i = 0; i < dataOfDay.length; i++) {
			putFloatValue("g_quarter_data" + i, dataOfDay[i], context);
		}
	}

	public static float[] getDataGasOfQuarter(Context context) {
		float dataOfDay[] = new float[4];
		for (int i = 0; i < dataOfDay.length; i++) {
			dataOfDay[i] = getFloatValue("g_quarter_data" + i, context);
		}
		return dataOfDay;
	}

	/**
	 * put data of four years to prefer
	 * 
	 * @param dataOfDay
	 * @param context
	 */
	public static void putDataGasOfYear(float dataOfDay[], Context context) {
		for (int i = 0; i < dataOfDay.length; i++) {
			putFloatValue("g_year_data" + i, dataOfDay[i], context);
		}
	}

	public static float[]  getDataGasOfYear(Context context) {
		float dataOfDay[] = new float[4];
		for (int i = 0; i < dataOfDay.length; i++) {
			dataOfDay[i] = getFloatValue("year_data" + i, context);
		}
		return dataOfDay;
	}

	/**
	 * put data to prefer
	 * 
	 * @param dataOfDay
	 * @param context
	 */
	public static void putDataGasOfMonth(float dataOfDay[],
			Context context) {
		for (int i = 0; i < dataOfDay.length; i++) {
			putFloatValue("g_month_data" + i, dataOfDay[i], context);
		}
		
	}

	public static float[] getDataGasOfMonth(Context context) {
		float dataOfDay[] = new float[12];
		for (int i = 0; i < dataOfDay.length; i++) {
			dataOfDay[i] = getFloatValue("g_month_data" + i, context);
		}
		return dataOfDay;
	}
	/**
	 * base function to get/set data from database
	 * 
	 * @param key
	 * @param s
	 * @param context
	 */
	public static void putStringValue(String key, String s, Context context) {
		// SmartLog.log(TAG, "Set string value");
		SharedPreferences pref = context.getSharedPreferences(
				SMARTHOME_PREFERENT, 0);
		SharedPreferences.Editor editor = pref.edit();
		editor.putString(key, s);
		editor.commit();
	}
	
	public static void putFloatValue(String key, Float s, Context context) {
		// SmartLog.log(TAG, "Set string value");
		SharedPreferences pref = context.getSharedPreferences(
				SMARTHOME_PREFERENT, 0);
		SharedPreferences.Editor editor = pref.edit();
		editor.putFloat(key, s);
		editor.commit();
	}


	public static void putIntValue(String key, int value, Context context) {
		// SmartLog.log(TAG, "Set string value");
		SharedPreferences pref = context.getSharedPreferences(
				SMARTHOME_PREFERENT, 0);
		SharedPreferences.Editor editor = pref.edit();
		editor.putInt(key, value);
		editor.commit();
	}

	public static void putBooleanValue(String key, Boolean s, Context context) {
		// SmartLog.log(TAG, "Set string value");
		SharedPreferences pref = context.getSharedPreferences(
				SMARTHOME_PREFERENT, 0);
		SharedPreferences.Editor editor = pref.edit();
		editor.putBoolean(key, s);
		editor.commit();
	}

	/**
	 * Read an string to SharedPreferences
	 * 
	 * @param key
	 * @return
	 */
	public static String getStringValue(String key, Context context) {
		SharedPreferences pref = context.getSharedPreferences(
				SMARTHOME_PREFERENT, 0);
		return pref.getString(key, "");
	}
	
	public static Float getFloatValue(String key, Context context) {
		SharedPreferences pref = context.getSharedPreferences(
				SMARTHOME_PREFERENT, 0);
		return pref.getFloat(key, (float)0);
	}

	public static int getIntValue(String key, Context context) {
		SharedPreferences pref = context.getSharedPreferences(
				SMARTHOME_PREFERENT, 0);
		return pref.getInt(key, 0);
	}

	public static boolean getBooleanValue(String key, Context context) {
		SharedPreferences pref = context.getSharedPreferences(
				SMARTHOME_PREFERENT, 0);
		return pref.getBoolean(key, false);
	}

}
