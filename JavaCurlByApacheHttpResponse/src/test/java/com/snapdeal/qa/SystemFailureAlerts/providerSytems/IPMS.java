package com.snapdeal.qa.SystemFailureAlerts.providerSytems;

import org.apache.http.HttpResponse;

import com.snapdeal.qa.SystemFailureAlerts.Util.HitTheCurl;
/**
 * @author singh.avinash
 */
public class IPMS {
	private static String api_base_url = "http://20.0.1.179:9097";

	public boolean getSellerInventoryPricingForPDP() {
		boolean isWorking = false;
		String url = "/service/ipms/getSellerInventoryPricingForPDP";
		String json = "{\"orderedSUPCList\":[\"SDL994240556\"],\"zone\":\"1\",\"responseProtocol\":\"PROTOCOL_JSON\",\"requestProtocol\":\"PROTOCOL_JSON\"}";
		HttpResponse response = HitTheCurl.sendJSon(api_base_url + url, json);
		try {
			isWorking = response.toString().contains("200");
		} catch (Exception e) {
			System.out.println("getSellerInventoryPricingForPDP API of IPMS is not working");
		}
		return isWorking;
	}

}

