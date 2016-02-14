package com.snapdeal.qa.SystemFailureAlerts.providerSytems;

import org.apache.http.HttpResponse;

import com.snapdeal.qa.SystemFailureAlerts.Util.HitTheCurl;
/**
 * @author singh.avinash
 */
public class RMS {
	private static String api_base_url = "http://20.0.0.96:10360";

	public boolean getRMSHistoryForOrderSummary() {
		boolean isWorking = false;
		String url = "/service/returns/getRMSHistoryForOrderSummary";
		String json = "{\"responseProtocol\":\"PROTOCOL_JSON\",\"requestProtocol\":\"PROTOCOL_JSON\", \"suborderCode\":\"5637643522\"}";
		HttpResponse response = HitTheCurl.sendJSon(api_base_url + url, json);
		try {
			isWorking = response.toString().contains("200");
		} catch (Exception e) {
			System.out.println("getRMSHistoryForOrderSummary API of RMS is not working");
		}
		return isWorking;
	}

}
