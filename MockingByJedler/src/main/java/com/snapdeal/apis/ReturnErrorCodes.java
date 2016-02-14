/**
 * 
 */
package com.snapdeal.apis;

import static net.jadler.Jadler.onRequest;

import com.snapdeal.common.CommonClass;

/**
 * @author Faheem Akhtar
 */
public class ReturnErrorCodes extends CommonClass {
	public static void get500ErrorCode()
	{
			 onRequest()
					.havingPathEqualTo("/get500ErrorCode")
			.respond()
					.withStatus(404);
	}
}
