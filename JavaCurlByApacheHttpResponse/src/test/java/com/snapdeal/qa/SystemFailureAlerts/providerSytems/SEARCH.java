package com.snapdeal.qa.SystemFailureAlerts.providerSytems;

import org.apache.http.HttpResponse;

import com.snapdeal.qa.SystemFailureAlerts.Util.HitTheCurl;

/**
 * @author singh.avinash
 */
public class SEARCH {
	private static String api_base_url = "http://20.0.0.35:5050";

	public boolean getAllCampaigns() {
		boolean isWorking = false;
		String url = "/service/searchServer/getAllCampaigns";
		String json = "{\"responseProtocol\":\"PROTOCOL_JSON\", \"requestProtocol\":\"PROTOCOL_JSON\"}";
		HttpResponse response = HitTheCurl.sendJSon(api_base_url + url, json);
		try {
			isWorking = response.toString().contains("200");
		} catch (Exception e) {
			System.out.println("getAllCampaigns API of SEARCH is not working");
		}
		return isWorking;
	}
}