package com.snapdeal.qa.SystemFailureAlerts.providerSytems;

import org.apache.http.HttpResponse;

import com.snapdeal.qa.SystemFailureAlerts.Util.HitTheCurl;

/**
 * @author mohammad.akhtar
 */
public class Cams {

	private static String api_base_url = "http://20.0.1.126:9096";

	public boolean getAllLabels() {
		boolean isWorking = false;
		String url = "/service/product/getAllLabels";
		String json = "{\"responseProtocol\": \"PROTOCOL_JSON\",\"requestProtocol\": \"PROTOCOL_JSON\"}";
		HttpResponse response = HitTheCurl.sendJSon(api_base_url + url, json);
		try {
			isWorking = response.toString().contains("200");
		} catch (Exception e) {
			System.out.println("getAllLabels API of cams is not working");
		}
		return isWorking;
	}
}
