/**
 * Copyright (c) 2012, SetaCinQ
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER
 */
package com.ascentcomtec.smarthouse.utils;

import java.io.File;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
/**
 * Project name : HappiestBaby
 * Package name : com.setacinq.happiestbaby.utils
 * File name    : Utils.java
 * Author       : longtq
 */
public class Utils {
	
	/**
	 * 
	 * @param value
	 * @param pattern
	 * @return
	 */
	public static String decimalFormat(int value, String pattern) {
		DecimalFormat formatter = new DecimalFormat("#00.###");
		return formatter.format(value);
	}
	/**
	 * px dip into
	 * @param dipValue
	 * @return
	 */
	public static int convertDips2Pixel(float dipValue,Context context) {
  		return (int) /*convertDpToPixel(dipValue,context)*/dipValue;
	}
	/**
	 * This method convets dp unit to equivalent device specific value in pixels. 
	 * 
	 * @param dp A value in dp(Device independent pixels) unit. Which we need to convert into pixels
	 * @param context Context to get resources and device specific display metrics
	 * @return A float value to represent Pixels equivalent to dp according to device
	 */
	public static float convertDpToPixel(float dipValue,Context context){
		//DisplayMetrics metrics = context.getResources().getDisplayMetrics();
		float px = dipValue * (/*metrics.densityDpi*/240 / 160f);
		return px;
	}
	/**
	 * This method converts device specific pixels to device independent pixels.
	 * 
	 * @param px A value in px (pixels) unit. Which we need to convert into db
	 * @param context Context to get resources and device specific display metrics
	 * @return A float value to represent db equivalent to px value
	 */
	public static float convertPixelsToDp(float pixels,Context context){
		DisplayMetrics metrics = context.getResources().getDisplayMetrics();
		float dp = pixels / (metrics.densityDpi / 160f);
		return dp;
	}
	/**
	 * 
	 * @param id
	 * @param context
	 * @return
	 */
	public static String convertResources2String(int id,Context context){
		try{
			return context.getResources().getText(id).toString();
		}catch (Resources.NotFoundException notFoundException) {
			return "resources not found";
 		}
	}

	public static int hex2decimal(String s) {
		String digits = "0123456789ABCDEF";
		s = s.toUpperCase();
		int val = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int d = digits.indexOf(c);
			val = 16 * val + d;
		}
		return val;
	}

	// precondition: d is a nonnegative integer
	public static String decimal2hex(int d) {
		String digits = "0123456789ABCDEF";
		if (d == 0)
			return "0";
		String hex = "";
		while (d > 0) {
			int digit = d % 16; // rightmost digit
			hex = digits.charAt(digit) + hex; // string concatenation
			d = d / 16;
		}
		return hex;
	}
	/***
	 * 
	 * @param str
	 * @return
	 */
	public static String generateKey(String str) {
		char[] chars = str.toUpperCase().toCharArray();
		StringBuffer hex = new StringBuffer();
		for (int i = 0; i < chars.length; i++) {
			hex.append(Integer.toHexString((int) chars[i]));
		}
		return hex.toString();
	}
 
	/***
	 * 
	 * @return serial nurmber device
	 */
	public static String getSerialNumber(){
		String serialNumber;
  		try {                                                                               
  			Class<?> classLoader = Class.forName("android.os.SystemProperties");        	 
  			Method method        = classLoader.getMethod("get", String.class, String.class );                     
  			serialNumber         = (String)(method.invoke(classLoader, "ro.serialno", "W80082PE8YA"));              
  		}catch (Exception exception){   
  			serialNumber = "W80082PE8YA";
  		}
  		return serialNumber;
 	}
	/***
	 * 
	 * @return serial nurmber device
	 */
	public static String getSerialNumber(Context context){
		try{
			TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
			String imei = telephonyManager.getDeviceId();
			return imei;
		}catch (Exception e) {
			String serialNum;
	  		try {                                                                               
	  			Class<?> classLoader = Class.forName("android.os.SystemProperties");        	 
	  			Method method        = classLoader.getMethod("get", String.class, String.class );                     
	  			serialNum            = (String)(method.invoke(classLoader, "ro.serialno"));              
	  		}catch (Exception exception){   
	  			serialNum = "W80082PE8YA";
	  		}
	  		return serialNum; 
		}
	}
	/***
	 * 
	 * @return 
	 */
	public static String getDevice(){
  		return android.os.Build.DEVICE;
	}
	/***
	 * 
	 * @return  
	 */
	public static String getModelAndProduct(){
  		return  android.os.Build.MODEL + " ("+ android.os.Build.PRODUCT + ")";
	}
	
	/**
	 * 
	 * @param url
	 * @return
	 */
	public static String getFileName(String url) {
		int slashIndex = url.lastIndexOf('/');
		int dotIndex = url.length();
		String filenameWithoutExtension;
		if (dotIndex == -1) {
			filenameWithoutExtension = url.substring(slashIndex + 1);
		} else {
			filenameWithoutExtension = url.substring(slashIndex + 1, dotIndex);
		}
		return filenameWithoutExtension;
	}
	
	//for ZBapi

	public static Bitmap drawableToBitmap(Drawable drawable) {
	        
	        Bitmap bitmap = Bitmap
	                        .createBitmap(
	                                        drawable.getIntrinsicWidth(),
	                                        drawable.getIntrinsicHeight(),
	                                        drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
	                                                        : Bitmap.Config.RGB_565);
	        Canvas canvas = new Canvas(bitmap);
	        //canvas.setBitmap(bitmap);
	        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
	        drawable.draw(canvas);
	        return bitmap; 
	}
	
	public static Drawable setAlpha(Drawable dra, int number) 
    { 
			Bitmap sourceImg = ((BitmapDrawable)dra).getBitmap();
            int[] argb = new int[sourceImg.getWidth() * sourceImg.getHeight()]; 
            sourceImg.getPixels(argb, 0, sourceImg.getWidth(), 0, 0,sourceImg.getWidth(), sourceImg.getHeight());
            number = number * 255 / 100; 
            int transparentColor = argb[0];
            for (int i = 0; i < argb.length; i++) 
            {
            	
                    if(argb[i]==transparentColor )
                    {
                    	argb[i] = (number << 24) | (argb[i] & 0x00FFFFFF);
                    }
                    else
                    {
                    	//argb[i]=0x00000000;
                    }
            }
            sourceImg = Bitmap.createBitmap(argb, sourceImg.getWidth(), sourceImg.getHeight(), Config.ARGB_8888);
            return new BitmapDrawable(sourceImg); 
    } 
       
	
	public static int hexStr2Int(String hex)
	{
		int ret = 0;
		
		if(hex.startsWith("0x"))
			hex = hex.substring(2);
		
		int fac=1;
		char chex[] = hex.toUpperCase().toCharArray();
		for(int i=chex.length-1; i>=0;i--)
		{
			int num=0;
			switch(chex[i])
			{
				case 'A':
					num=10;
					break;
				case 'B':
					num=11;
					break;
				case 'C':
					num=12;
					break;
				case 'D':
					num=13;
					break;
				case 'E':
					num=14;
					break;
				case 'F':
					num=15;
					break;
				default:
					num = Integer.parseInt(chex[i]+"");
				    break;
			}
			ret = ret + fac*num;
			fac = fac * 16;
		}
		return ret;
	}
	

	public static String Int2Hex(int i,int size)
	{
		String ret = "";
		int ys = 0;
		do
		{
			ys = i%16;
			i=i/16;
			if(ys<10)
			{
				ret=ys+ret;
			}
			else
			{
				ret=((char)(55+ys))+ret;
			}
		}
		while(i>0);
		if(ret.length()<size)
		{
			int len = ret.length();
			for(int j=0;j<size-len;j++)
			{
				ret="0"+ret;
			}
		}
		return ret;
	}
	
	public static boolean isHexString(String hex)
	{
		Pattern p = Pattern.compile("((0x)|(0X))?[a-fA-F0-9]+");
		Matcher m=  p.matcher(hex);
		return m.matches();
	}

	public static void RemoveFile(String path)
	{
		try
		{
			File f=new File(path);
			if(f.exists())
				f.delete();
		}
		catch(Exception ex)
		{
			
		}
	}
}
