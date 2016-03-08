package com.snapdeal.qa.SystemFailureAlerts.providerSytems;

import org.apache.http.HttpResponse;

import com.snapdeal.qa.SystemFailureAlerts.Util.HitTheCurl;

/**
 * @author singh.avinash
 */
public class SCORE {
	private static String api_base_url = "http://54.251.152.42:10070";

	public boolean getSellerWiseDeliveryInfo() {
		boolean isWorking = false;
		String url = "/service/score/getSellerWiseDeliveryInfo";
		String json = "{\"responseProtocol\":\"PROTOCOL_JSON\",\"requestProtocol\":\"PROTOCOL_JSON\",\"useCutOffBuffer\":\"false\",\"additionalChargesRequired\":\"true\",\"calculateDeliveryDate\":\"true\",\"supc\":\"SDL287280643\",\"pincode\":\"110020\",\"productInfoSro\":{  \"categoryUrl\":\"shbtesting-testsubthree\",\"brandName\":\"Adidas\",\"make2Order\":\"false\"},\"sellerInfo\":[{\"sellerCode\":\"S467d4\",\"sellingPrice\":\"444.0\",\"fulfilmentModel\":\"DROPSHIP\",\"fcCodes\":null,\"shippingCharge\":\"0\"}]}";
		HttpResponse response = HitTheCurl.sendJSon(api_base_url + url, json);
		try {
			isWorking = response.toString().contains("200");
		} catch (Exception e) {
			System.out.println("getSellerWiseDeliveryInfo API of SCORE is not working");
		}
		return isWorking;
	}
}