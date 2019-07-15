package com.eCRM.client.utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.NoSuchElementException;

public class DateAndTimeUtils 
{
	private static Date date;
	private static SimpleDateFormat simpleDateFormat;
	private static SimpleDateFormat givenFormat;
	private static SimpleDateFormat requiredFormat;
	private static Calendar calendar;

	public static String getCurrentTimeStamp()
	{
		simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy HH-mm-ss");
		return simpleDateFormat.format(new Date());
	}

	public static String getCurrentTimeStamp(String format)
	{
		simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(new Date());
	}

	public static String getDateAsAString(String date, String givenFormat, String requiredFormat) throws ParseException
	{
		DateAndTimeUtils.givenFormat = new SimpleDateFormat(givenFormat);
		DateAndTimeUtils.date = null;
		DateAndTimeUtils.date = DateAndTimeUtils.givenFormat.parse(date);
		DateAndTimeUtils.requiredFormat = new SimpleDateFormat(requiredFormat);
		return DateAndTimeUtils.requiredFormat.format(DateAndTimeUtils.date);
	}

	public static String getModifiedDateTime(String dateTime, String givenFormat, String requiredFormat, int addYears, int addMonths, int addDate, int addHours, int addMinutes, int addSeconds) throws ParseException
	{
		calendar = Calendar.getInstance();
		calendar.setTime(new SimpleDateFormat(givenFormat).parse(dateTime));
		calendar.add(Calendar.YEAR, addYears);
		calendar.add(Calendar.MONTH, addMonths);
		calendar.add(Calendar.DAY_OF_MONTH, addDate);
		calendar.add(Calendar.HOUR_OF_DAY, addHours);
		calendar.add(Calendar.MINUTE, addMinutes);
		calendar.add(Calendar.SECOND, addSeconds);
		return new SimpleDateFormat(requiredFormat).format(calendar.getTime());
	}
	

	public static boolean isAfter(String format, String givenTimestamp, String compareTimestamp) throws ParseException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date givenDate = dateFormat.parse(givenTimestamp);
        Date compareDate = dateFormat.parse(compareTimestamp);
        return  givenDate.after(compareDate);
	}
	
	public static boolean isBefore(String format, String givenTimestamp, String compareTimestamp) throws ParseException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date givenDate = dateFormat.parse(givenTimestamp);
        Date compareDate = dateFormat.parse(compareTimestamp);
        return  givenDate.before(compareDate);
	}
	
	public static boolean isEqual(String format, String givenTimestamp, String compareTimestamp) throws ParseException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date givenDate = dateFormat.parse(givenTimestamp);
        Date compareDate = dateFormat.parse(compareTimestamp);
        return  givenDate.equals(compareDate);
	}

	public static boolean compareDateAscedningOrder(String firstDate, String secondDate,String givenFormat) 
	{
		try
		{
			SimpleDateFormat date;
			date=new SimpleDateFormat(givenFormat); //"MM/dd/yyyy hh:mm a"
			Date first=date.parse(firstDate);
		
			Date second=date.parse(secondDate);
			System.out.println(first);
			System.out.println(second);
			if (second.after(first))
			{			
				return true;		
			}
			else if(second.equals(first))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch( NoSuchElementException e) 
		{
			e.printStackTrace();
			System.out.println("Alarm is not sorted");
			return false;
			
		} 
		catch (ParseException e) {
			
			e.printStackTrace();
			return false;
		}		

	}
	public static boolean compareDateDscedningOrder(String firstDate, String secondDate,String givenFormat) 
	{
		try
		{
			SimpleDateFormat date;
			date=new SimpleDateFormat(givenFormat); //"MM/dd/yyyy hh:mm a"
			Date first=date.parse(firstDate);
			Date second=date.parse(secondDate);
			if (first.after(second))
			{			
				return true;		
			}
			else if(first.equals(second))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch( NoSuchElementException e) 
		{
			e.printStackTrace();
			System.out.println("Alarm is not sorted");
			return false;
			
		} 
		catch (ParseException e) {
			
			e.printStackTrace();
			return false;
		}		
	}
	
	public static long getDaysBetweenDates(String startDate, String endDate, String dateFormat) throws IOException
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
		LocalDate firstDate = LocalDate.parse(startDate, formatter);
		LocalDate secondDate = LocalDate.parse(endDate, formatter);
		return ChronoUnit.DAYS.between(firstDate, secondDate);
	}
	
}
