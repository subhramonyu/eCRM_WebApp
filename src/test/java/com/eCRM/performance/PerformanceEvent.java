package com.eCRM.performance;

import java.util.HashMap;
import java.util.Map;

import com.eCRM.client.core.CommonUtils;

public class PerformanceEvent extends CommonUtils {

	protected static long getPageLoadTIme() {
		return (getEventValue(EventAttribute.LOAD_EVENT_END) - getEventValue(EventAttribute.NAVIGATION_START)) / 1000;
	}

	protected static long getNetworkConnectionTime() {
		return (getEventValue(EventAttribute.CONNECT_END) - getEventValue(EventAttribute.DOMAIN_LOOKUP_START)) / 1000;
	}

	protected static long getDOMLoadTime() {
		return (getEventValue(EventAttribute.DOM_COMPLETE) - getEventValue(EventAttribute.DOM_LOADING)) / 1000;
	}

	protected static long getServerResponseTime() {
		return (getEventValue(EventAttribute.RESPONSE_END) - getEventValue(EventAttribute.REQUEST_START)) / 1000;
	}

	private static long getEventValue(EventAttribute event) {
		String script = String.format("return window.performance.timing.%s;", event);
		return (long) jsExeCute(script);
	}

}
