package com.ascentcomtec.smarthouse.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * String Utility class
 * 
 * @author HieuPV
 * 
 */
public class StringUtility {
	/**
	 * Update by    : longtq6195
	 * Check input string
	 * @param editText
	 * @return
	 */
	public static boolean isEmpty(String editText) {
		return StringUtils.isBlank(editText);
	}

	/**
	 * Update by    : longtq6195
	 * Merge all elements of a string array into a string
	 * @param strings
	 * @param separator
	 * @return
	 */
	public static String join(String[] strings, String separator) {
		return StringUtils.join(strings, separator);
	}

	/**
	 * Create by    : longtq6195
	 * @param str
	 * @return
	 */
	public static String sqlQuote(String string) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("\"");
		stringBuffer.append(string);
		stringBuffer.append("\"");
		return stringBuffer.toString();
	}
	/**
	 * Create by    : longtq6195
	 * @param long value
	 * @return
	 */
	public static String sqlQuote(long value) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("\"");
		stringBuffer.append(value);
		stringBuffer.append("\"");
		return stringBuffer.toString();
	}
	/**
	 * Create by    : longtq6195
	 * @param int value
	 * @return
	 */
	public static String sqlQuote(int value) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("\"");
		stringBuffer.append(value);
		stringBuffer.append("\"");
		return stringBuffer.toString();
	}
	/***
	 * Create by    : longtq6195
	 * @param email
	 * @return
	 */
	public static boolean checkEmail(String email) {
		final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		try {
			Pattern pattern = Pattern.compile(EMAIL_PATTERN);
			Matcher matcher = pattern.matcher(email);
			return matcher.matches();
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * 
	 * @param html
	 * @return
	 */
	public static String removeAllTagHtml(String html){
		Pattern tags = Pattern.compile ("</?[^>]+>");
		Matcher match = tags.matcher (html); // here you specify the string you want to modify (HTML)
		String result = match.replaceAll("");
		return result;
	}
}
