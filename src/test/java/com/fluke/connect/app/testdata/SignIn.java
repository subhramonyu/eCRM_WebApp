package com.fluke.connect.app.testdata;

import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;

public class SignIn {
	
	public enum FeatureList {
		SMOKE_IOS("SMOKE_IOS"), SMOKE_ANDROID("SMOKE_ANDROID"), SMOKE_WEB("SMOKE_WEB"), FC1555("FC1555"),FC1664("FC1664"),
		FCM_CNX("FCM_CNX"), FCM_TI("FCM_TI"), REPORTS("REPORTS"), ASSETS("ASSETS"), WORKORDERS("WORKORDERS"), 
		FCCM3540("FCCM3540"), FCCM3550("FCCM3550"), FCCM3560("FCCM3560"), FCCM3560_VIB("FCCM3560_VIB"), FCCM3560_TEMP("FCCM3560_TEMP"),
		MEASUREMENTS("MEASUREMENTS"), TEAM("TEAM"), FCCM174X("FCCM174X"), LOCALIZATION("LOCALIZATION");
		
		private String attributeValue;

	    FeatureList(String attributeValue) 
	    {
	        this.attributeValue = attributeValue;
	    }

	    public String getAttributeValue() 
	    {
	        return attributeValue;
	    }
	
	
	}
	
	public static String getUID(FeatureList featureName)
	{
		switch (featureName) {
		case FCM_CNX:
			DriverManager.setFeatureName(FeatureList.FCM_CNX.getAttributeValue());
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				return "atcnx@yopmail.com";
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				return "Cnx@yopmail.com";	
		case FCM_TI:
			DriverManager.setFeatureName(FeatureList.FCM_TI.getAttributeValue());
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				return "Tistar@yopmail.com";
		case FCCM3540:
			DriverManager.setFeatureName(FeatureList.FCCM3540.getAttributeValue());
			return "3540automation@yopmail.com";
		case FCCM174X:
			DriverManager.setFeatureName(FeatureList.FCCM174X.getAttributeValue());
			return "automationblondel@yopmail.com";
		case FCCM3550:
			DriverManager.setFeatureName(FeatureList.FCCM3550.getAttributeValue());
			return "at@yopmail.com";
		case FCCM3560:
			DriverManager.setFeatureName(FeatureList.FCCM3560.getAttributeValue());
			return "3561UAT@yopmail.com";
		case FCCM3560_VIB:
			DriverManager.setFeatureName(FeatureList.FCCM3560.getAttributeValue());
			return "3561UAT@yopmail.com";
		case WORKORDERS:
			DriverManager.setFeatureName(FeatureList.WORKORDERS.getAttributeValue());
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				return "wo_iosregression@yopmail.com";
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				return "wo_androidregression@yopmail.com";
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				return "wo_automation@yopmail.com";
		case FC1555:
			DriverManager.setFeatureName(FeatureList.FC1555.getAttributeValue());
			return "admin.fccm@yopmail.com";
			
		case FC1664:
			DriverManager.setFeatureName(FeatureList.FC1664.getAttributeValue());
			return "1664Fcios@yopmail.com";
		case ASSETS:
			DriverManager.setFeatureName(FeatureList.ASSETS.getAttributeValue());
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				return "Asset_ios@yopmail.com";
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				return "Android_asset@yopmail.com";
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				return "Asset_web@yopmail.com";	
		case REPORTS:
			DriverManager.setFeatureName(FeatureList.REPORTS.getAttributeValue());
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				return "iOSReportTeam@yopmail.com";
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				return "AndroidReportTeam@yopmail.com";
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				return "Reptests@yopmail.com";
		case SMOKE_IOS:
			return "Smoketest6@yopmail.com";
		case SMOKE_ANDROID:
			return "android_automation_dev@yopmail.com";
		case SMOKE_WEB:
			return "Atdev@yopmail.com";
		case LOCALIZATION:
			DriverManager.setFeatureName(FeatureList.LOCALIZATION.getAttributeValue());
			return "Lt123456@yopmail.com";
		default:
			return "";
		}
	}
	
	public static String getPWD(FeatureList featureName)
	{
		switch (featureName) {
		case FCM_CNX:
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER) || DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				return "atcnx@yopmail.com";
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				return "Cnx@yopmail.com";	
		case FCM_TI:
			if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				return "Tistar@yopmail.com";
		case FCCM3540:
			return "3540automation@yopmail.com";
		case FCCM174X:
			return "Fluke1234!";
		case FCCM3550:
			return "at@yopmail.com";
		case FCCM3560:
			return "3561UAT@yopmail.com";
		case FCCM3560_VIB:
			return "3561UAT@yopmail.com";
		case WORKORDERS:
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				return "Fluke@1234";
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				return "Fluke@1234";
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				return "wo_automation@yopmail.com";
		case FC1555:
			return "admin.fccm@yopmail.com";
		case FC1664:
			return "1664Fcios@yopmail.com";
		case ASSETS:
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				return "Asset_ios@yopmail.com";
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				return "Android_asset@yopmail.com";
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				return "Asset_web@yopmail.com";	
		case REPORTS:
			if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
				return "iOSReportTeam@yopmail.com";
			else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER))
				return "AndroidReportTeam@yopmail.com";
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
				return "Reptests@yopmail.com";
		case SMOKE_IOS:
			return "Smoketest6@yopmail.com";
		case SMOKE_ANDROID:
			return "android_automation_dev@yopmail.com";
		case SMOKE_WEB:
			return "Atdev@yopmail.com";
		case LOCALIZATION:
			return "Lt123456@yopmail.com";
		default:
			return "";
		}
	}

}
