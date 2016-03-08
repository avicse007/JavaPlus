package com.snapdeal.qa.SystemFailureAlerts.providerSytems;

import org.apache.http.HttpResponse;

import com.snapdeal.qa.SystemFailureAlerts.Util.HitTheCurl;

public class PROMO {
	private static String api_base_url = "http://54.169.156.29:10220";

	public boolean getOfferStrips() {
		boolean isWorking = false;
		String url = "/service/promoAPIService/getOfferStrips";
		String json = "{\"responseProtocol\":\"PROTOCOL_JSON\",\"requestProtocol\":\"PROTOCOL_JSON\",\"pogId\":\"637317953797\", \"brandId\":\"0\", \"bucketId\":\"1420\"}";
		HttpResponse response = HitTheCurl.sendJSon(api_base_url + url, json);
		try {
			isWorking = response.toString().contains("200");
		} catch (Exception e) {
			System.out.println("getOfferStrips API of PROMO is not working");
		}
		return isWorking;
	}

}
