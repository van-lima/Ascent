package net.sourceforge.api;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/***
 * 
 * @author longtq
 * 
 */
public class JDateTime {
	/***
	 * 
	 */
	private final String FORMAT_DATE = "yyyy/MM/dd";
	/***
	 * 
	 */
	private final String FORMAT_DATE_TYPE_1 = "EEEE yyyy/MM/dd";

	/***
	 * yyyyy/mm/dd
	 * 
	 * @return
	 */
	public String getDateFormat() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_DATE);
		return simpleDateFormat.format(date);
	}

	/***
	 * 
	 * @param nextDay
	 * @return
	 * @throws ParseException
	 */
	public String incrementDateByDay(int amount) throws ParseException {
		String startDate = getDateFormat(); // Start date
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_DATE);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(simpleDateFormat.parse(startDate));
		calendar.add(Calendar.DATE, amount); // number of days to add
		startDate = simpleDateFormat.format(calendar.getTime()); // dt is now
																	// the new
																	// date
		return startDate;
	}

	/***
	 * 
	 * @param amount
	 * @return
	 * @throws ParseException
	 */
	public String reducedDateByDay(int amount) throws ParseException {
		String startDate = getDateFormat(); // Start date
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_DATE);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(simpleDateFormat.parse(startDate));
		calendar.add(Calendar.DATE, -amount); // number of days to add
		startDate = simpleDateFormat.format(calendar.getTime()); // dt is now
																	// the new
																	// date
		return startDate;
	}

	/***
	 * 
	 * @param time
	 * @return
	 */
	public String convertTime(long time) {
		Date date = new Date(time);
		Format format = new SimpleDateFormat(FORMAT_DATE);
		return format.format(date).toString();
	}

	/***
	 * 
	 * @return
	 * @throws ParseException
	 */
	public List<String> listDatesOfWeek() throws ParseException {
		List<String> listDate = new ArrayList<String>();
		String str_date = getDateFormat();
		String end_date = incrementDateByDay(7);
		DateFormat formatter = new SimpleDateFormat(FORMAT_DATE);
		Date startDate = (Date) formatter.parse(str_date);
		Date endDate = (Date) formatter.parse(end_date);
		long interval = 24 * 1000 * 60 * 60; // 1 hour in millis
		long endTime = endDate.getTime(); // create your endtime here, possibly
											// using Calendar or Date
		long curTime = startDate.getTime();
		while (curTime <= endTime) {
			String dateFormat = formatter.format(new Date(curTime));
			listDate.add(dateFormat);
			curTime += interval;
		}
		return listDate;
	}

	/***
	 * 
	 * @return
	 * @throws ParseException
	 */
	public List<String> listDatesInWeek() {
		List<String> listDate = new ArrayList<String>();
		// Get calendar set to current date and time
		Calendar calendar = Calendar.getInstance();
		// Set the calendar to monday of the current week
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		// Print dates of the current week starting on Monday
		DateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE_TYPE_1);
		for (int i = 0; i < 7; i++) {
			listDate.add(dateFormat.format(calendar.getTime()));
			calendar.add(Calendar.DATE, 1);
		}
		return listDate;
	}

	private static Date getFirstDateOfCurrentMonth() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH,
				Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}

	/***
	 * 
	 * @return
	 */
	private static Date getFinallyDateOfCurrentMonth() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH,
				Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}

	/***
	 * 
	 * @return
	 */
	private static Date firstDayOfWeek() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(System.currentTimeMillis()));
		calendar.set(Calendar.DAY_OF_WEEK, 1);
		return calendar.getTime();
	}

	public static Date lastDayOfWeek() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(System.currentTimeMillis()));
		calendar.set(Calendar.DAY_OF_WEEK, 7);
		return calendar.getTime();
	}

	/***
	 * 
	 * @param date
	 * @return
	 */
	private static Date firstDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(System.currentTimeMillis()));
		calendar.set(Calendar.DATE, 1);
		return calendar.getTime();
	}

	/***
	 * 
	 * @return
	 * @throws ParseException
	 */
	public List<String> listWeekOfMonth() {
		String[] stringWeekName = new String[] { "Week1", "Week2", "Week3",
				"Week4" };
		List<String> listDate = new ArrayList<String>();
		for (String string : stringWeekName) {
			listDate.add(string);
		}
		return listDate;
	}

	/***
	 * 
	 * @return
	 * @throws ParseException
	 */
	public List<String> listMonth() {
		List<String> listDate = new ArrayList<String>();
		String[] months = new DateFormatSymbols().getMonths();
		if (months.length == 13) {
			for (int i = 0; i < months.length - 1; i++) {
				String month = months[i];
				listDate.add(month);
			}
		} else {
			for (int i = 0; i < months.length; i++) {
				String month = months[i];
				listDate.add(month);
			}
		}

		return listDate;
	}

	/***
	 * 
	 * @return
	 * @throws ParseException
	 */
	public List<String> listQuarter() {
		String[] stringWeekName = new String[] { "Quarter1", "Quarter2",
				"Quarter3", "Quarter4" };
		List<String> listDate = new ArrayList<String>();
		for (String string : stringWeekName) {
			listDate.add(string);
		}
		return listDate;
	}

	/***
	 * 
	 * @return
	 * @throws ParseException
	 */
	public List<String> listYear() {
		String[] stringWeekName = new String[] { "2010", "2011", "2012", "2013" };
		List<String> listDate = new ArrayList<String>();
		for (String string : stringWeekName) {
			listDate.add(string);
		}
		return listDate;
	}
}
