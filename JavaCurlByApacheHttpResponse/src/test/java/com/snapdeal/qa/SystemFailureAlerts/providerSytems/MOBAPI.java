package com.snapdeal.qa.SystemFailureAlerts.providerSytems;

import org.apache.http.HttpResponse;

import com.snapdeal.qa.SystemFailureAlerts.Util.HitTheCurl;
/**
 * @author singh.avinash
 */
public class MOBAPI {
	private static String api_base_url = "http://52.74.109.177:30010";

	public boolean getpdpContentBySupc() {
		boolean isWorking = false;
		String url = "/service/mobapi/getpdpContentBySupc";
		String json = "{\"responseProtocol\":\"PROTOCOL_JSON\",\"requestProtocol\":\"PROTOCOL_JSON\",\"supc\":\"SDL913862358\",\"locale\":\"en\",\"deviceType\":\"WEB\",\"zone\":\"NO_ZONE\"}";
		HttpResponse response = HitTheCurl.sendJSon(api_base_url + url, json);
		try {
			isWorking = response.toString().contains("200");
		} catch (Exception e) {
			System.out.println("getpdpContentBySupc API of MOBAI is not working");
		}
		return isWorking;
	}

}