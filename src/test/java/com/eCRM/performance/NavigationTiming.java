package com.eCRM.performance;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class NavigationTiming extends PerformanceEvent {

	public void getEventTimeInSeconds(String EventName) {
		loadData();
	}

	public  static HashMap<String, Long> loadData() {
		HashMap<String, Long> performancematrix = new HashMap<String, Long>();
		performancematrix.put(EventAttribute.PAGE_LOAD_TIME.toString(), getPageLoadTIme());
		performancematrix.put(EventAttribute.NETWORK_CONNECTION_TIME.toString(), getNetworkConnectionTime());
		performancematrix.put(EventAttribute.SERVER_RESPONSE_TIME.toString(), getServerResponseTime());
		performancematrix.put(EventAttribute.DOM_LOAD_TIME.toString(), getDOMLoadTime());
		return performancematrix;
		
	}
	

}