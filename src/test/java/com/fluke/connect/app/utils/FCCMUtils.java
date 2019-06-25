package com.fluke.connect.app.utils;


public class FCCMUtils 
{

	public static String getRequiredSessionStartTimestamp(String givenTimestamp, String androidSeprator, String iOSSeprator, String webSeprator) throws Exception
	{
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) && givenTimestamp.contains(iOSSeprator))
			return givenTimestamp;
		else if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) && givenTimestamp.contains(androidSeprator))
			return givenTimestamp.replace(givenTimestamp.substring(0, givenTimestamp.indexOf(" ")), DateAndTimeUtils.getDateAsAString(givenTimestamp.substring(0, givenTimestamp.indexOf(" ")), Config.ANDROID_DATE_FORMAT , Config.IOS_DATE_FORMAT)).replaceFirst(" ",", ").replace(givenTimestamp.substring(givenTimestamp.indexOf(" |"), givenTimestamp.length()),"");
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) && givenTimestamp.contains(androidSeprator))
			return givenTimestamp.replace(givenTimestamp.substring(givenTimestamp.indexOf(" |"), givenTimestamp.length()),"");
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) && givenTimestamp.contains(iOSSeprator))
			return givenTimestamp.replace(givenTimestamp.substring(0, givenTimestamp.indexOf(",")), DateAndTimeUtils.getDateAsAString(givenTimestamp.substring(0, givenTimestamp.indexOf(",")), Config.IOS_DATE_FORMAT , Config.ANDROID_DATE_FORMAT)).replace(",","");
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER) && givenTimestamp.contains(iOSSeprator))
		{
			givenTimestamp = givenTimestamp.replace(",", "");
			return DateAndTimeUtils.getDateAsAString(givenTimestamp, Config.IOS_DATE_FORMAT+" "+Config.MOBILE_TIME_FORMAT, Config.WEB_DATE_FORMAT+" "+Config.WEB_TIME_FORMAT);
		}
		else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER) && givenTimestamp.contains(androidSeprator))
		{
			givenTimestamp = givenTimestamp.replace(givenTimestamp.substring(givenTimestamp.indexOf(" |"), givenTimestamp.length()),"");
			givenTimestamp = givenTimestamp.replace(" |", "");
			return DateAndTimeUtils.getDateAsAString(givenTimestamp, Config.ANDROID_DATE_FORMAT+" "+Config.MOBILE_TIME_FORMAT, Config.WEB_DATE_FORMAT+" "+Config.WEB_TIME_FORMAT);
		}
		else
			throw new Exception("Given session start time stamp is not in correct format");
	}
	
	public static String getSessionVariableValue(String propertiesFilePath, String androidVariableName, String iOSVariableName)
	{
			if(FileUtil.readFromPropertyFile(propertiesFilePath, androidVariableName).equals("null"))
				return FileUtil.readFromPropertyFile(propertiesFilePath, iOSVariableName);
			else
				return FileUtil.readFromPropertyFile(propertiesFilePath, androidVariableName);
	}
	
	public static void setSessionVariableValue(String propertiesFilePath, String androidVariableName, String iOSVariableName, String setValue)
	{
		FileUtil.writeProperty(propertiesFilePath, androidVariableName, setValue);
		FileUtil.writeProperty(propertiesFilePath, iOSVariableName, setValue);		
	}
	
	public static String getSessionStartTime(String sessionStartTime, String propertiesFilePath,String androidSessionStartTime, String iOSSessionStartTime)
	{
		if(sessionStartTime.equals("no value"))
			return FCCMUtils.getSessionVariableValue(propertiesFilePath, androidSessionStartTime, iOSSessionStartTime);
		else
			return sessionStartTime;
	}
	
	public static String getGatewayName(String gatewayName, String propertiesFilePath,String androidGatewayName, String iOSGatewayName)
	{
		if(gatewayName.equals("no value"))
			return FCCMUtils.getSessionVariableValue(propertiesFilePath, androidGatewayName, iOSGatewayName);
		else
			return gatewayName;
	}

}
