package com.snapdeal.qa.SystemFailureAlerts.providerSytems;

import org.apache.http.HttpResponse;

import com.snapdeal.qa.SystemFailureAlerts.Util.HitTheCurl;
/**
 * @author singh.avinash
 */
public class BOSS {
	
	private static String api_base_url = "http://54.251.152.42:11680";

	public boolean getAvailableFacilities() {
		boolean isWorking = false;
		String url = "/service/boss/getAvailableFacilities";
		String json = "{\"responseProtocol\":\"PROTOCOL_JSON\", \"requestProtocol\":\"PROTOCOL_JSON\" ,\"products\":[{\"sellerSkuCode\":\"o2owebsku37\",\"quantity\":1}],\"pincode\":\"110020\",\"proximityInKMs\":60,\"numberOfResult\":10,\"sellerCode\":\"42b5ff\"}";
		HttpResponse response = HitTheCurl.sendJSon(api_base_url + url, json);
		try {
			isWorking = response.toString().contains("200");
		} catch (Exception e) {
			System.out.println("getAvailableFacilities API of BOSS is not working");
		}
		return isWorking;
	}

}
