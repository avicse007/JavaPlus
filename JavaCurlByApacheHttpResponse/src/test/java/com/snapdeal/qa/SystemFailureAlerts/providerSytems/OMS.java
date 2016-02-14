package com.snapdeal.qa.SystemFailureAlerts.providerSytems;

import org.apache.http.HttpResponse;

import com.snapdeal.qa.SystemFailureAlerts.Util.HitTheCurl;
/**
 * @author singh.avinash
 */
public class OMS {
	private static String api_base_url = "http://20.0.0.150:8080";
	public boolean getSuborderHistoryStatusesByCode() {
		boolean isWorking = false;
		String url = "/service/oms/order/getSuborderHistoryStatusesByCode";
		String json = "{\"responseProtocol\":\"PROTOCOL_JSON\",\"requestProtocol\":\"PROTOCOL_JSON\", \"suborderCodes\":[\"17801759\"]}";
		HttpResponse response = HitTheCurl.sendJSon(api_base_url + url, json);
		try {
			isWorking = response.toString().contains("200");
		} catch (Exception e) {
			System.out.println("getSuborderHistoryStatusesByCode API of OMS is not working");
		}
		return isWorking;
	}

}