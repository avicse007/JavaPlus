package com.snapdeal.qa.SystemFailureAlerts.providerSytems;

import org.apache.http.HttpResponse;

import com.snapdeal.qa.SystemFailureAlerts.Util.HitTheCurl;

/**
 * @author singh.avinash
 */
public class SHIPPING {
	private static String api_base_url = "http://20.0.0.96:7013";

	public boolean getShippingHistoryForOrderSummary() {
		boolean isWorking = false;
		String url = "/service/shipping/getShippingHistoryForOrderSummary";
		String json = "{\"responseProtocol\":\"PROTOCOL_JSON\",\"requestProtocol\":\"PROTOCOL_JSON\", \"suborderCode\":\"17801759\"}";
		HttpResponse response = HitTheCurl.sendJSon(api_base_url + url, json);
		try {
			isWorking = response.toString().contains("200");
		} catch (Exception e) {
			System.out.println("getShippingHistoryForOrderSummary API of SHIPPING is not working");
		}
		return isWorking;
	}
}