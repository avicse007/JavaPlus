/**
 * 
 */
package com.snapdeal.main;

import static net.jadler.Jadler.initJadlerListeningOn;
import static net.jadler.Jadler.port;

import com.snapdeal.apis.AutoSuggestorAPI;
import com.snapdeal.apis.IsCodAvailable;
import com.snapdeal.apis.O2OAPIServices;
import com.snapdeal.apis.PointsAPIServices;
import com.snapdeal.apis.ReturnErrorCodes;
import com.snapdeal.apis.ScoreAPIServices;
import com.snapdeal.apis.SearchAPI;
import com.snapdeal.common.CommonClass;

/**
 * @author Faheem Akhtar
 */
public class MainClass extends CommonClass {

	public static void main(String[] args) throws Exception {

		/* Jadler starting on Port 8086 */
		initJadlerListeningOn(8086);

		checkServerStatus();

		/* Registering the APIs of Points System */
		PointsAPIServices.isProgramEnabled();
		PointsAPIServices.getRupeetoPointMultiplier();
		PointsAPIServices.getPointsRedemptionMinThreshold();
		PointsAPIServices.getAvailablePoints();
		PointsAPIServices.getPointsExpiryDays();

		O2OAPIServices.getInventoryPricingBySUPCSeller();
		ScoreAPIServices.getSellerwiseDeliveryInfo();

		AutoSuggestorAPI.getAutoSuggestions();
		AutoSuggestorAPI.getSuggestionRightNav();

		ReturnErrorCodes.get500ErrorCode();

		SearchAPI.searchGroupLeftNav();
		SearchAPI.search();
		IsCodAvailable.isCodAvailable();
		
		System.out.println("\nAPIs mocking System.\nStarted on Port = " + port());

	}
}
