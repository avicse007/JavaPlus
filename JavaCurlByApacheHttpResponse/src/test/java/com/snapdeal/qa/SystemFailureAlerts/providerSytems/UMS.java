package com.snapdeal.qa.SystemFailureAlerts.providerSytems;

import org.apache.http.HttpResponse;

import com.snapdeal.qa.SystemFailureAlerts.Util.HitTheCurl;

public class UMS {
	private static String api_base_url = "http://20.0.1.220:9001";

	public boolean getEmailVerificationCode() {
		boolean isWorking = false;
		String url = "/service/ums/user/getEmailVerificationCode";
		String json = "{\"responseProtocol\":\"PROTOCOL_JSON\",\"requestProtocol\":\"PROTOCOL_JSON\",\"email\":\"shobhit.srivastava@snapdeal.com\"}";
		HttpResponse response = HitTheCurl.sendJSon(api_base_url + url, json);
		try {
			isWorking = response.toString().contains("200");
		} catch (Exception e) {
			System.out.println("getEmailVerificationCode API of UMS is not working");
		}
		return isWorking;
	}
}