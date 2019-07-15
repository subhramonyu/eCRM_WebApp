package com.eCRM.client.utils;

import java.text.ParseException;

public class MeasurementUtils 
{
	public static String getRequriedTime(String givenDate, String dateFormat) throws ParseException
    {
        if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)  && dateFormat.equals("iOS"))
        {
            return DateAndTimeUtils.getDateAsAString(givenDate, Config.iOSDateFormatForMeasurements+" "+Config.mobileTimeFormat, Config.androidDateFormat+" "+Config.mobileTimeFormat);
        }
        else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)  && dateFormat.equals("Android"))
        {
            return DateAndTimeUtils.getDateAsAString(givenDate, Config.androidDateFormat+" "+Config.mobileTimeFormat, Config.iOSDateFormatForMeasurements+" "+Config.mobileTimeFormat);
        }
        else
        {
            if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)  && dateFormat.equals("iOS"))
            {
                return DateAndTimeUtils.getDateAsAString(givenDate, Config.iOSDateFormatForMeasurements+" "+Config.mobileTimeFormat, Config.webDateFormat+" "+Config.webTimeFormat);
            }
            else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)  && dateFormat.equals("Android"))
            {
                return DateAndTimeUtils.getDateAsAString(givenDate, Config.androidDateFormat+" "+Config.mobileTimeFormat, Config.webDateFormat+" "+Config.webTimeFormat);
            }
        }
        return givenDate;
    }

}
