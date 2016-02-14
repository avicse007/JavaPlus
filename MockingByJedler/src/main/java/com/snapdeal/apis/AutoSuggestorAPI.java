/**
 * 
 */
package com.snapdeal.apis;

import static net.jadler.Jadler.onRequest;
import static org.hamcrest.Matchers.containsString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.snapdeal.base.exception.SerializationException;
import com.snapdeal.base.transport.service.ITransportService.Protocol;
import com.snapdeal.common.CommonClass;
import com.snapdeal.suggester.ext.GetAutoSuggestionsResponse;
import com.snapdeal.suggester.ext.GetSuggestRightNavResponse;
import com.snapdeal.suggester.sro.SearchSuggestionCategorySRO;
import com.snapdeal.suggester.sro.SearchSuggestionSRO;
import com.snapdeal.suggester.sro.SuggestionRightNavSRO;

/**
 * @author Faheem Akhtar
 */
public class AutoSuggestorAPI extends CommonClass {

	@SuppressWarnings("deprecation")
	private static byte[] createGetAutoSuggestionsResponse() throws SerializationException
	{
		GetAutoSuggestionsResponse response = new GetAutoSuggestionsResponse();
		
		List<SearchSuggestionSRO> searchSuggestions = new ArrayList<SearchSuggestionSRO>();
		SearchSuggestionSRO e = new SearchSuggestionSRO();
		e.setKeyword("anarkali dress");
		
		SearchSuggestionCategorySRO category = new SearchSuggestionCategorySRO();
		category.setCategoryName("Dress Materials");
		category.setLabelUrl("women-apparel-dress-material");
		category.setCategoryId();
		category.setScore(1028537);
				
		e.addCategory(0, category);
		
		SearchSuggestionCategorySRO category1 = new SearchSuggestionCategorySRO();
		category1.setCategoryName("Frocks & Dresses");
		category1.setLabelUrl("girls-clothing-frocks");
		category1.setCategoryId();
		category1.setScore(1778);
		
		e.addCategory(1, category1);
		
		SearchSuggestionCategorySRO category2 = new SearchSuggestionCategorySRO();
		category2.setCategoryName("All Categories");
		category2.setLabelUrl("ALL");
		category2.setCategoryId();
		category2.setScore(1042704);
		
		e.addCategory(2, category2);
		
		SearchSuggestionSRO e1 = new SearchSuggestionSRO();
		e1.setKeyword("womens chudidhar anarkali dress materials");

		SearchSuggestionCategorySRO category3 = new SearchSuggestionCategorySRO();
		category3.setCategoryName("Dress Materials");
		category3.setLabelUrl("women-apparel-dress-material");
		category3.setCategoryId();
		category3.setScore(521072);
				
		e1.addCategory(0, category3);
		
		SearchSuggestionCategorySRO category4 = new SearchSuggestionCategorySRO();
		category4.setCategoryName("Bed Sheets");
		category4.setLabelUrl("bed-sheets");
		category4.setCategoryId();
		category4.setScore(163);
		
		e1.addCategory(1, category4);
		
		SearchSuggestionCategorySRO category5 = new SearchSuggestionCategorySRO();
		category5.setCategoryName("All Categories");
		category5.setLabelUrl("ALL");
		category5.setCategoryId();
		category5.setScore(531186);
		
		e1.addCategory(2, category5);
		
		searchSuggestions.add(e);
		searchSuggestions.add(e1);
		
		response.setSuccessful(true);
		//response.setCode("null");
		response.setProtocol(Protocol.PROTOCOL_JSON);
		//response.setMessage("null");
		response.setSearchSuggestions(searchSuggestions);
		byte[] responseStr = doJsonSerailize(response.getClass(), response);
		return responseStr;
	}
	
	@SuppressWarnings("deprecation")
	private static byte[] createGetSuggestionRightNav() throws SerializationException{
		GetSuggestRightNavResponse response = new GetSuggestRightNavResponse();
		SuggestionRightNavSRO suggestionRightNav = new SuggestionRightNavSRO();
		
		suggestionRightNav.setKeyword("a");
		
		List<String> brands = new ArrayList<String>();
		brands.add("lenovo");
		brands.add("styles closet");
		brands.add("samsung");
		brands.add("micromax");
		suggestionRightNav.setBrands(brands);

		List<String> labelUrls = new ArrayList<String>();
		labelUrls.add("mobiles-mobile-phones");
		labelUrls.add("electronic-tv-accessories");
		labelUrls.add("mobiles-screen-guards");
		suggestionRightNav.setLabelUrls(labelUrls);
		
		List<Long> pogIds = new ArrayList<Long>();
		pogIds.add(670500124351L);
		pogIds.add(618889569737L);
		pogIds.add(16558352L);
		pogIds.add(618908664215L);
		pogIds.add(639230235625L);
		suggestionRightNav.setPogIds(pogIds);
		
		List<String> promos = new ArrayList<String>();
		suggestionRightNav.setPromos(promos);
		
		response.setSuggestionRightNav(suggestionRightNav);
		
		response.setSuccessful(true);
		response.setProtocol(Protocol.PROTOCOL_JSON);
		byte[] responseStr = doJsonSerailize(response.getClass(), response);
		return responseStr;
	}
	
	public static void getAutoSuggestions() throws SerializationException {
		byte[] response = createGetAutoSuggestionsResponse();
		 String condition_1 = "\"searchString\":\"a\"";
		 String condition_3 = "\"version\":\"v2\"";
		 String condition_4 = "\"labelUrl\":\"ALL\"";
		 
		 onRequest()
				.havingMethodEqualTo("POST")
				.havingHeaderEqualTo("Content-Type", "application/json")
				.havingPathEqualTo("/service/suggester/getAutoSuggestions")
				.havingBody(containsString(condition_1))
				.havingBody(containsString(condition_3))
				.havingBody(containsString(condition_4))
		.respond()
				.withDelay(5, TimeUnit.SECONDS)
				.withBody(response);
	}
	
	public static void getSuggestionRightNav() throws SerializationException{
		byte [] response = createGetSuggestionRightNav();
		String body ="\"keyword\":\"a\""; 
		
		 onRequest()
			.havingMethodEqualTo("POST")
			.havingHeaderEqualTo("Content-Type", "application/json")
			.havingPathEqualTo("/service/suggester/getSuggestionRightNav")
			.havingBody(containsString(body))
	.respond()
			.withDelay(10, TimeUnit.SECONDS)
			.withBody(response);
	}
}
