package com.snapdeal.apis;

import static net.jadler.Jadler.onRequest;
import static org.hamcrest.Matchers.containsString;

import com.snapdeal.base.exception.SerializationException;
import com.snapdeal.base.transport.service.ITransportService.Protocol;
import com.snapdeal.common.CommonClass;
import com.snapdeal.points.base.sro.response.PointsProgramEnabledResponse;

public class SearchAPI extends CommonClass {

	private static byte[] createSearchGroupLeftNavResponse() throws SerializationException {

		PointsProgramEnabledResponse response = new PointsProgramEnabledResponse();

		response.setEnabled(true);
		response.setProtocol(Protocol.PROTOCOL_JSON);
		response.setMessage("isProgramEnabled API mocked response");
		response.setCode("200");

		byte[] responseStr = doJsonSerailize(response.getClass(), response);
		return responseStr;

	}

	public static void searchGroupLeftNav() throws SerializationException {
		byte[] response = createSearchGroupLeftNavResponse();

		String criteria_1 = "\"categoryUrl\" : \"shbtesting-testsubone\"";
		String criteria_2 = "\"categoryUrl\" : \"computers\"";
		
			onRequest()
					.havingMethodEqualTo("POST")
					.havingPathEqualTo("/service/searchServer/searchGroupLeftNav")
					.havingHeaderEqualTo("Content-Type", "application/json")
					.havingBody(containsString(criteria_1))
				.respond()
					.withStatus(200)
					.withBody("");
			onRequest()
			.havingMethodEqualTo("POST")
			.havingPathEqualTo("/service/searchServer/searchGroupLeftNav")
			.havingHeaderEqualTo("Content-Type", "application/json")
			.havingBody(containsString(criteria_2))
		.respond()
			.withStatus(200)
			.withBody("");
	}
	public static void search() throws SerializationException {
		byte[] response = createSearchGroupLeftNavResponse();

		String criteria_1 = "\"categoryUrl\" : \"shbtesting-testsubone\"";
		String criteria_2 = "\"categoryUrl\" : \"computers\"";
		
			onRequest()
					.havingMethodEqualTo("POST")
					.havingPathEqualTo("/service/searchServer/search")
					.havingHeaderEqualTo("Content-Type", "application/json")
					.havingBody(containsString(criteria_1))
				.respond()
					.withStatus(200)
					.withBody("");
			onRequest()
			.havingMethodEqualTo("POST")
			.havingPathEqualTo("/service/searchServer/search")
			.havingHeaderEqualTo("Content-Type", "application/json")
			.havingBody(containsString(criteria_2))
		.respond()
			.withStatus(200)
			.withBody("");
	}
}
