package com.fluke.connect.app.testdata;

public class Graph {
	
	public enum SessionTileDetail
	{
		GATEWAYNAME,SENSORNAME,STARTTIME,STARTUSER,ENDTIME,ENDUSER,ASSETGROUP,ASSET,ALARM,ALERT,MONITORINGSTATUS,ACTIVITYOPTION,EDITSESSION,
		VIEWSESSIONACTIVITY,EXPORTSESSION,LEFTGRAPHUNIT,RIGHTGRAPHUNIT,
		ALARMTYPE,FOVSALARM,XAXISLABEL,YAXISLABEL,ZAXISLABEL,MAXLABEL,MINLABEL
	}

	public enum SessionType
	{
		POWER("/PowerMonitor"),
		VIBRATION("/Vibration"),
		THERMAL("/ThermalImage"),
		VATG("/VATG");
		
		String sessionType;
		
		public String getSessionType()
		{
			return sessionType;
		}
		
		SessionType(String sessionType)
		{
			this.sessionType=sessionType;
		}
		
	}
	
	final public static  String GRAPHDEV="graphCheck";
	
	
}

