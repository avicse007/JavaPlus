package com.snapdeal.qa.SystemFailureAlerts.providerSytems;

import org.apache.http.HttpResponse;

import com.snapdeal.qa.SystemFailureAlerts.Util.HitTheCurl;
/**
 * @author singh.avinash
 */
public class COCOFS {
	private static String api_base_url = "http://54.251.152.42:10320";

	public boolean getFulfilmentModel() {
		boolean isWorking = false;
		String url = "/service/cocofs/getFulfilmentModel";
		String json = "{\"responseProtocol\":\"PROTOCOL_JSON\",\"requestProtocol\":\"PROTOCOL_JSON\",\"sellerSupcPairs\":[{\"supc\":\"SDL039770721\",\"sellerCode\":\"42b5ff\"}]}";
		HttpResponse response = HitTheCurl.sendJSon(api_base_url + url, json);
		try {
			isWorking = response.toString().contains("200");
		} catch (Exception e) {
			System.out.println("getFulfilmentModel API of COCOFS is not working");
		}
		return isWorking;
	}

}