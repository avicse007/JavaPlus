package com.snapdeal.qa.SystemFailureAlerts.providerSytems;

import org.apache.http.HttpResponse;

import com.snapdeal.qa.SystemFailureAlerts.Util.HitTheCurl;
/**
 * @author singh.avinash
 */
public class RECOMENDATION {
	private static String api_base_url = "54.169.156.29:10410";

	public boolean getSimilarPOGIdListById() {
		boolean isWorking = false;
		String url = "/service/recommendation/getSimilarPOGIdListById";
		String json = "{\"productOfferGroupId\":\"10001\",\"responseProtocol\":\"PROTOCOL_JSON\",\"requestProtocol\":\"PROTOCOL_JSON\"}";
		HttpResponse response = HitTheCurl.sendJSon(api_base_url + url, json);
		try {
			isWorking = response.toString().contains("200");
		} catch (Exception e) {
			System.out.println("getSimilarPOGIdListById API of RECOMENDATION is not working");
		}
		return isWorking;
	}
}