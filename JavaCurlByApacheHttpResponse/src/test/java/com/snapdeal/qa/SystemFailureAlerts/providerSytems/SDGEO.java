package com.snapdeal.qa.SystemFailureAlerts.providerSytems;

import org.apache.http.HttpResponse;

import com.snapdeal.qa.SystemFailureAlerts.Util.HitTheCurl;

/**
 * @author singh.avinash
 */
public class SDGEO {
	private static String api_base_url = "http://20.0.1.134:8080";

	public boolean getZoneFromPincode() {
		boolean isWorking = false;
		String url = "/service/sdgeoapi/getZoneFromPincode";
		String json = "{\"pincode\":\"560049\", \"responseProtocol\":\"PROTOCOL_JSON\",\"requestProtocol\":\"PROTOCOL_JSON\"}";
		HttpResponse response = HitTheCurl.sendJSon(api_base_url + url, json);
		try {
			isWorking = response.toString().contains("200");
		} catch (Exception e) {
			System.out.println("getZoneFromPincode API of SDGEO is not working");
		}
		return isWorking;
	}
}