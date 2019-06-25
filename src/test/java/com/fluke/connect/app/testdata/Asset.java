package com.fluke.connect.app.testdata;

import java.util.ArrayList;
import java.util.Vector;

import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DateAndTimeUtils;
import com.fluke.connect.app.utils.DriverManager;

public class Asset 
{
	
	private  static String timeStamp=" "+DateAndTimeUtils.getCurrentTimeStamp();
	String systemUser=System.getProperty("user.name");
	public String importFilePath="/Users/"+systemUser+"/sw-uaf-test-framework/app/FlukeConnectTests/files/FC_Asset_Import_Template.xlsx";
	
	public enum ASSETCONFIG  
	{
		ASSET_GROUP_A("AssetGroupA"+timeStamp+""),
		ASSET_GROUP_EDIT("AssetGroupAEdit"+timeStamp+""),
		ASSET_SUBGROUP_A("AssetSubGroupA"+timeStamp+""),
		ASSET_GROUP_B("StatusGroup"),
		ASSET_GROUP_ALARM("AlarmGroup"),
		ASSET_SUBGROUP_B("AssetSubGroupB"+timeStamp+""),
		ASSET_GROUP_SORT("SortAndFilter"),
		ASSET_IMPORT_GROUP("AssetImportGroup"+timeStamp+""),
		ASSET_GROUP_LEVE1("Asset Group Level 1"),
		ASSET_GROUP_LEVE2("Asset Group Level 2"),
		TEST_POINT_A("TestPoint"+timeStamp+""),
		TEST_POINT_EDIT("TestPointC"+timeStamp+""),	
		ASSET_TYPE("Boiler"),
		ASSET_NAME("AssetA"+timeStamp+""),
		ASSET_NAME_EDIT("AssetAEdit"+timeStamp+""),
		ASSET_NAME_B("StatusAsset"),
		ASSET_NAME_ALARM("AssetAlarm"+timeStamp+"");
		
		
		String assetConfig;
		public String getAssetConfig()
		{
			return assetConfig;
		}
		
		ASSETCONFIG(String assetConfig)
		{
			this.assetConfig=assetConfig;
		}	
	}
	
	
	public enum ASSET_ANALYSIS
	{
		ASSET_ANALYSIS_GROUP("AssetAnalysisGroup"+timeStamp+""),
		
		THERMAL_ASSET("ThermalImageAsset"+timeStamp+""),
		CNX_ASSET("CNXAsset"+timeStamp+""),
		MUSE_ASSET("MuseAsset"+timeStamp+""),
		BEAKER_ASSET("BeakerAsset"+timeStamp+""),
		ASSET_805("805Asset"+timeStamp+""),
		
		
		BEAKER_MEASUREMENT_NAME("BEAKER_1587"),
		CNX_TEMP_MEASUREMENT_NAME("T3000FC"),
		CNX_CURR_MEASUREMENT_NAME("A3001FC"),
		THERMAL_MEASUREMENT_NAME_IOS("FLUKE-Camera"),
		THERMAL_MEASUREMENT_NAME_ANDROID("Thermal Imager"),
		MUSE_MEASUREMENT_NAME("279FC-Muse"),
		FLUKE_805_MEASUREMENT("Fluke 805FC"),
		EVEE_MEASUREMENT("155");
		
		String assetAnalysis;
		public String getAnalysisConfig()
		{
			return assetAnalysis;
		}
		
		ASSET_ANALYSIS(String assetAnalysis)
		{
			this.assetAnalysis=assetAnalysis;
		}	
	}
	
	public enum WEB_MEASUREMENT_ASSET
	{
		THERMAL_ASSET("AssetAnalysisGroup"+timeStamp+" > ThermalImageAsset"+timeStamp+""),
		CNX_ASSET("AssetAnalysisGroup"+timeStamp+" > CNXAsset"+timeStamp+""),
		MUSE_ASSET("AssetAnalysisGroup"+timeStamp+" > MuseAsset"+timeStamp+""),
		BEAKER_ASSET("AssetAnalysisGroup"+timeStamp+" > BeakerAsset"+timeStamp+""),
		ASSET_805("AssetAnalysisGroup"+timeStamp+" > 805Asset"+timeStamp+"");
		
		String webAssetAnalysis;
		public String getWebMeasurementAssetConfig()
		{
			return webAssetAnalysis;
		}
		
		WEB_MEASUREMENT_ASSET(String webAssetAnalysis)
		{
			this.webAssetAnalysis=webAssetAnalysis;
		}	
	}
	
	public enum ALARM_NAME
	{
		ACTIVE_POWER("Active Power"),
		CURRENT("Current"),
		FREQUENCY("Frequency"),
		POEWR_FACTOR("Power Factor"),
		THD_A("THD - A"),
		THD_V("THD - V"),
		TEMPERATURE("Temperature"),
		VOLATGE("Voltage"),
		
		CURRENT_ALARM("Current"+timeStamp+""),
		FREQUENCY_ALARM("Frequency"+timeStamp+""),
		POEWR_FACTOR_ALARM("Power Factor"+timeStamp+""),
		THD_A_ALARM("THD - A"+timeStamp+""),
		THD_V_ALARM("THD - V"+timeStamp+""),
		TEMPERATURE_ALARM("Temperature"+timeStamp+""),
		VOLATGE_ALARM("Voltage"+timeStamp+""),
		ACTIVE_POWER_ALARM("ActivePower"+timeStamp+"");
		
		String alarm_Name;
		public String getAlarmName()
		{
	  		return alarm_Name;
		}
		ALARM_NAME(String alarm_Name)
		{
			this.alarm_Name=alarm_Name;
		}	
	}
	
	public enum ALARM_TYPE
	{
		ABOVE,BELOW,WITH_IN_A_RANGE,OUT_OF_RANGE;	
	}
	
	public enum TEAM_MEMBER
	{
		ME("Me"),
		TEAM_ADMINISTRATOR("Team Administrators"),
		TEAM_MEMBERS("Specific Team Members");
		String team_Member;
		public String getTeamMember()
		{
			return team_Member;
		}
		TEAM_MEMBER(String team_Member)
		{
			this.team_Member=team_Member;
		}	
	}
	
	public enum MEASUREMENT_NAME
	{
		THERMAL,BEAKER,CNX,MUSE,VIBRATION,EVEE;
	}
	
	public ArrayList<String> statusFilter()
	{
		ArrayList<String> status=new ArrayList<String>();
		status.add("Normal");
		status.add("Moderate");
		//status.add("Serious");
		//status.add("Extreme");
		//status.add("Unassigned");
		return (status);	
	}
	
	public ArrayList<String> assetTypeFilter()
	{
		ArrayList<String> status=new ArrayList<String>();
		status.add("Boiler");
		status.add("Breaker");
		//status.add("Busbar");
		//status.add("Chiller");
		//status.add("Connector");
		//status.add("Controller");
		//status.add("Disconnect");
		//status.add("Electrical Panel");
		//status.add("Fuse");
		//status.add("Generator");
		
		return (status);	
	}
	
	public ArrayList<String> assetSeverityFilter()
	{
		ArrayList<String> status=new ArrayList<String>();
		status.add("normal_icon");
		status.add("moderate_icon");
		status.add("serious_icon");
		status.add("extreme_icon");
		status.add("unassigned_icon");
		return (status);	
	}	
	
	public ArrayList<String> assetSeverityFilterWeb()
	{
		ArrayList<String> status=new ArrayList<String>();
		status.add("normal");
		status.add("moderate");
		status.add("serious");
		status.add("extreme");
		status.add("unassigned");
		return (status);	
	}	
	
	public ArrayList<String> getThermalImageDate()
	{
		ArrayList<String> date=new ArrayList<String>();	
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			date.add("01/23/19 18:17:14");
			date.add("01/23/19 18:17:03");
		}
			
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)||DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			date.add("1/23/19 17:08:33");
			date.add("1/23/19 17:08:10");
			
		//	date.add("23/01/19 17:08:33");
			
			//date.add("23/01/19 17:08:10");
		}
		return (date);
	}
	
	 public ArrayList<String> getThermalImageiOSDate()
	{
		ArrayList<String> date=new ArrayList<String>();
			
		//date.add("9/28/18 17:23:54");
		date.add("8/17/18 18:23:24");
		date.add("8/17/18 18:19:07");
		
		
		return (date);
	}
	
	public ArrayList<String> getMuseDate()
	{
		ArrayList<String> date=new ArrayList<String>();			
		date.add("10/10/18 19:54:52");
		date.add("10/10/18 16:10:14");
		return (date);
	}
	
	public ArrayList<String> getVibrationDate()
	{
		ArrayList<String> date=new ArrayList<String>();
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			date.add("01/23/19 18:24:16");
			date.add("01/23/19 18:23:50");	
		}	
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)||DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			date.add("1/23/19 18:30:16");
			date.add("1/23/19 18:29:52");
			//date.add("23/01/19 18:30:16");
			//date.add("23/01/19 18:29:52");
		}
		
		return (date);
	}
	
	public ArrayList<String> getBeakerDate()
	{
		ArrayList<String> date=new ArrayList<String>();
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			date.add("01/23/19 18:46:31");
			date.add("01/23/19 18:23:22");
		}
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)||DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			date.add("1/23/19 18:32:56");
			date.add("1/23/19 18:32:47");	
			//date.add("23/01/19 18:32:56");
			//date.add("23/01/19 18:32:47");
		}	
		return (date);
	}

	public ArrayList<String> getCNXDate()
	{
		ArrayList<String> date=new ArrayList<String>();
		if(DriverManager.getDriverName().equals(Config.IOS_DRIVER))
		{
			date.add("01/23/19 18:15:58");
			date.add("01/23/19 18:15:16");
		}	
		else if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER)||DriverManager.getDriverName().equals(Config.WEB_DRIVER))
		{
			date.add("1/23/19 17:06:14");
			date.add("1/23/19 17:06:02");
			
			//date.add("23/01/19 17:06:14");
			//date.add("23/01/19 17:06:02");
		}	
		return (date);
	}
	
	public ArrayList<String> getEveeDate()
	{
		ArrayList<String> date=new ArrayList<String>();
			date.add("12/5/18 15:30:21");
			date.add("12/10/18 11:37:32");
			date.add("12/10/2018 2:28:53");
			return (date);
	}
	
	public String[] sortedAsset= {"Accelix","Evee","LongHorn","Minion","OneApp","Report","ThermoGraphy","Vibration","WrokOrder"};
	
	
}
