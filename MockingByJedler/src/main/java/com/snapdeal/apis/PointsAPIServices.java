/**
 * 
 */
package com.snapdeal.apis;

import static net.jadler.Jadler.onRequest;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.containsString;

import com.snapdeal.base.exception.SerializationException;
import com.snapdeal.base.transport.service.ITransportService.Protocol;
import com.snapdeal.common.CommonClass;
import com.snapdeal.points.base.sro.response.AvailablePointsResponse;
import com.snapdeal.points.base.sro.response.PointRedemmableMinThresholdResponse;
import com.snapdeal.points.base.sro.response.PointsExpiryDaysResponse;
import com.snapdeal.points.base.sro.response.PointsProgramEnabledResponse;
import com.snapdeal.points.base.sro.response.RupeeToPointMultiplierResponse;

/**
 * @author Faheem Akhtar
 */
public class PointsAPIServices extends CommonClass {

	private static byte[] createIsProgramEnabledResponse() throws SerializationException {
		
		PointsProgramEnabledResponse response = new PointsProgramEnabledResponse();

		response.setEnabled(true);
		response.setProtocol(Protocol.PROTOCOL_JSON);
		response.setMessage("isProgramEnabled API mocked response");
		response.setCode("200");

		byte[] responseStr = doJsonSerailize(response.getClass(), response);
		return responseStr;

	}
	
	private static byte[] createGetRupeetoPointMultiplierResponse() throws SerializationException {
		
		RupeeToPointMultiplierResponse response = new RupeeToPointMultiplierResponse();
		
		response.setMultiplier(5);
		response.setProtocol(Protocol.PROTOCOL_JSON);
		response.setMessage("RupeeToPointMultiplier Points API mocked response");
		response.setCode("200");
		
		byte[] responseStr = doJsonSerailize(response.getClass(), response);
		return responseStr;
	}
	
	private static byte[] createGetPointsRedemptionMinThreshold() throws SerializationException {
		
		PointRedemmableMinThresholdResponse response = new PointRedemmableMinThresholdResponse();
		
		response.setPoints(100);
		response.setProtocol(Protocol.PROTOCOL_JSON);
		response.setMessage("GetPointsRedemptionMinThreshold Points API mocked response");
		response.setCode("200");
		
		byte[] responseStr = doJsonSerailize(response.getClass(), response);
		return responseStr;
	}
	
	private static byte[] createGetAvailablePoints() throws SerializationException{

		AvailablePointsResponse response = new AvailablePointsResponse();
		response.setPoints(1000);
		response.setCashValue(1000/5);
		response.setProtocol(Protocol.PROTOCOL_JSON);
		response.setMessage("GetAvailablePoints API mocked response");
		response.setCode("200");
		
		byte[] responseStr = doJsonSerailize(response.getClass(), response);
		return responseStr;
		
	}
	
	private static byte[] createGetPointsExpiryDays() throws SerializationException{
		PointsExpiryDaysResponse response = new PointsExpiryDaysResponse();
		response.setPointExpiryDays(90);
		response.setProtocol(Protocol.PROTOCOL_JSON);
		response.setMessage("GetPointsExpiryDays API mocked response");
		response.setCode("200");
		
		byte[] responseStr = doJsonSerailize(response.getClass(), response);
		return responseStr;
	}
	
	public static void isProgramEnabled() throws SerializationException {
		byte[] response = createIsProgramEnabledResponse();
		onRequest()
				.havingMethodEqualTo("POST")
				.havingPathEqualTo("/service/points/isPointsProgramEnabled")
				.havingHeaderEqualTo("Content-Type", "application/json")
		.respond()
				.withBody(response);
	}
	
	public static void getRupeetoPointMultiplier() throws Exception {
		byte[] response = createGetRupeetoPointMultiplierResponse();

		onRequest()
				.havingMethodEqualTo("POST")
				.havingPathEqualTo("/service/points/getRupeetoPointMultiplier")
				.havingHeaderEqualTo("Content-Type", "application/json")
				
		.respond()
				.withBody(response);
	}
	
	public static void getPointsRedemptionMinThreshold() throws SerializationException {
		byte[] response = createGetPointsRedemptionMinThreshold();

		onRequest()
				.havingMethodEqualTo("POST")
				.havingPathEqualTo(	"/service/points/getPointsRedemptionMinThreshold")
				.havingHeaderEqualTo("Content-Type", "application/json")

		.respond().withBody(response);
	}
	
	public static void getAvailablePoints() throws SerializationException {
		byte[] response = createGetAvailablePoints();

		onRequest()
				.havingMethodEqualTo("POST")
				.havingPathEqualTo("/service/points/user/getAvailablePoints")
				.havingBody(anyOf(containsString("568221"),containsString("566530"),containsString("567860")))
				.havingHeaderEqualTo("Content-Type", "application/json")

		.respond().withBody(response);
		
	}
	
	public static void getPointsExpiryDays() throws SerializationException{
		byte[] response = createGetPointsExpiryDays();

		onRequest()
				.havingMethodEqualTo("POST")
				.havingPathEqualTo("/service/points/getPointsExpiryDays")
				.havingHeaderEqualTo("Content-Type", "application/json")

		.respond().withBody(response);
	}
	
}
