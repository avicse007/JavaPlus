package com.snapdeal.qa.SystemFailureAlerts.providerSytems;

import org.apache.http.HttpResponse;

import com.snapdeal.qa.SystemFailureAlerts.Util.HitTheCurl;
/**
 * @author singh.avinash
 */
public class OTS {
	private static String api_base_url = "";
	public boolean ordersByEmail() {
		boolean isWorking = false;
		String url = "/service/agg/ordersByEmail";
		String json = "{\"responseProtocol\":\"PROTOCOL_JSON\",\"requestProtocol\":\"PROTOCOL_JSON\",\"email\":\"shobhit.srivastava@snapdeal.com\",\"pageNumber\":\"0\",\"pageSize\":\"3\",\"source\":\"WAP\"}";
		HttpResponse response = HitTheCurl.sendJSon(api_base_url + url, json);
		try {
			isWorking = response.toString().contains("200");
		} catch (Exception e) {
			System.out.println("ordersByEmail API of OTS is not working");
		}
		return isWorking;
	}

}