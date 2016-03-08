package com.snapdeal.apis;

import static net.jadler.Jadler.onRequest;
import static org.hamcrest.Matchers.containsString;

import java.util.concurrent.TimeUnit;

import com.snapdeal.common.CommonClass;

public class IsCodAvailable extends CommonClass {
	public static void isCodAvailable(){
		String criteria_1 = "\"email\":\"codtest1@gmail.com\"";
			onRequest()
					.havingMethodEqualTo("POST")
					.havingPathEqualTo("/service/push/isCodAvailable")
					.havingHeaderEqualTo("Content-Type", "application/json")
					.havingBody(containsString(criteria_1))
				.respond()
					.withDelay(1,  TimeUnit.SECONDS)
					.withStatus(200)
					.withBody("");
	}
}
