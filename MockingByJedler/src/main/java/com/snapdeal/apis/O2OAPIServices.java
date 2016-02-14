package com.snapdeal.apis;

import static net.jadler.Jadler.onRequest;
import static org.hamcrest.Matchers.containsString;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.HashedMap;

import com.snapdeal.base.exception.SerializationException;
import com.snapdeal.base.model.common.CatalogType;
import com.snapdeal.base.transport.service.ITransportService.Protocol;
import com.snapdeal.base.validation.ValidationError;
import com.snapdeal.cocofs.model.response.GetFulfilmentModelBySellerSupcSubcatResponse;
import com.snapdeal.cocofs.sro.FulfillmentModel;
import com.snapdeal.common.CommonClass;
import com.snapdeal.ipms.base.api.getInventoryPricingBySUPCSeller.v1.EMIChargesSRO;
import com.snapdeal.ipms.base.api.getInventoryPricingBySUPCSeller.v1.ExternalCashbackSRO;
import com.snapdeal.ipms.base.api.getInventoryPricingBySUPCSeller.v1.GetInventoryPricingBySUPCSellerResponse;
import com.snapdeal.ipms.base.api.getInventoryPricingBySUPCSeller.v1.InternalCashbackSRO;
import com.snapdeal.ipms.base.api.getInventoryPricingBySUPCSeller.v1.SUPCSellerInventoryPricingSRO;
import com.snapdeal.ipms.base.api.getInventoryPricingBySUPCSeller.v1.SUPCSellerMappingSRO;
import com.snapdeal.ipms.base.common.CashbackDisplayType;
import com.snapdeal.ipms.base.common.InventoryPricingStatus;
import com.snapdeal.ipms.base.response.IPMSServiceResponse.IPMSResponseCode;
import com.snapdeal.mockRequests.GetCommonPickUpResponse;
import com.snapdeal.mockRequests.GetO2OServiceabilityResponse;
import com.snapdeal.mockRequests.GetStoreDetailsResponse;
import com.snapdeal.oms.base.enums.ExpressDeliveryType;
import com.snapdeal.oms.base.model.GetOrderResponse;
import com.snapdeal.oms.base.model.GetSuborderResponse;
import com.snapdeal.oms.base.sro.order.AddressDetailSRO;
import com.snapdeal.oms.base.sro.order.OrderRefundSRO;
import com.snapdeal.oms.base.sro.order.OrderSRO;
import com.snapdeal.oms.base.sro.order.OrderStatusSRO;
import com.snapdeal.oms.base.sro.order.OrderTransactionSRO;
import com.snapdeal.oms.base.sro.order.SuborderSRO;
import com.snapdeal.oms.base.sro.order.SuborderStatusSRO;
import com.snapdeal.oms.base.sro.order.SuborderTypeSRO;
import com.snapdeal.score.model.response.GetPerSellerDeliveryInfoResponse;
import com.snapdeal.score.sro.PVCDeliveryInfoSRO;
import com.snapdeal.score.sro.ServiceabilityRejectionReasons;
import com.snapdeal.score.sro.StdCodDatesSRO;


/*
 * This class contains the mock response and request for the API's 
 * that we are mocking.
 * 
 */
public class O2OAPIServices extends CommonClass {
	
	/*
	 * This Method creates the mock response for the getSellerWiseDeliveryInfo API.
	 * In this method we set the fields require for the mock response using the getter
	 * and setter methods of the response class.It returns the Response of the type that
	 * the getSellerWiseDeliveryInfo API is returning.
	 */
	@SuppressWarnings("deprecation")
	private static GetPerSellerDeliveryInfoResponse createGetSellerWiseDeliveryInfo()throws SerializationException{
		
		List validationErrors=new ArrayList();
		
		GetPerSellerDeliveryInfoResponse response=new GetPerSellerDeliveryInfoResponse();
		response.setCode(null);
		response.setSuccessful(true);
		response.setMessage(null);
		response.setProtocol(Protocol.PROTOCOL_JSON);
		response.setValidationErrors(validationErrors);
		String vendorCode="ef6f3b";
		String categoryURL=null;
		String supc=null;
		boolean isSTDAvailable=false; 
		boolean isCODAvailable=false;
		List<ServiceabilityRejectionReasons> stdRejectionReasonList=new ArrayList<ServiceabilityRejectionReasons>();
		List<ServiceabilityRejectionReasons> codRejectionReasonList=new ArrayList<ServiceabilityRejectionReasons>();
		//for same day dates
		Date stdDate=new Date(1438093800000L);
		Date codDate=new Date(1438093800000L);
		StdCodDatesSRO sameDayDates=new StdCodDatesSRO(stdDate,codDate);
		//For next day
		Date stdDate1=new Date(1438180200000L);
		Date codDate1=new Date(1438180200000L);
		StdCodDatesSRO nextDayDates=new StdCodDatesSRO(stdDate1,codDate1);
		//For expected Delivery dates
		Date stdDate2=null;
		Date codDate2=null;
		StdCodDatesSRO expectedDeliveryDates=new StdCodDatesSRO(stdDate2,codDate2);
		PVCDeliveryInfoSRO deliveryInfo=new PVCDeliveryInfoSRO(sameDayDates,nextDayDates,expectedDeliveryDates);
		
		deliveryInfo.setVendorCode(vendorCode);
		deliveryInfo.setCategoryURL(categoryURL);
		deliveryInfo.setSupc(supc);
		deliveryInfo.setSTDAvailable(isSTDAvailable);
		deliveryInfo.setCODAvailable(isCODAvailable);
		deliveryInfo.setStdRejectionReasonList(stdRejectionReasonList);
		deliveryInfo.setCodRejectionReasonList(codRejectionReasonList);

		response.setDeliveryInfo(deliveryInfo);
		return response;
	}
	
	/*
	 * This Method creates the mock response for the getFulfilmentModelBySellerSupcSubcat API.
	 * In this method we set the fields require for the mock response using the getter
	 * and setter methods of the response class.It returns the Response of the type that
	 * the getFulfilmentModelBySellerSupcSubcat API is returning.
	 */
	@SuppressWarnings("deprecation")
	private static GetFulfilmentModelBySellerSupcSubcatResponse createGetFulfilmentModelBySellerSupcSubcat()throws SerializationException{
		GetFulfilmentModelBySellerSupcSubcatResponse response=new GetFulfilmentModelBySellerSupcSubcatResponse();
		FulfillmentModel fulfillmentModel=FulfillmentModel.FC_VOI;
		String key="644db7";
		Map<String,FulfillmentModel> sellerToFulfilmentModel=new HashedMap();
		sellerToFulfilmentModel.put(key, fulfillmentModel);
		List validationErrors=new ArrayList<String>();
		response.setCode(null);
		response.setMessage(null);
		response.setProtocol(Protocol.PROTOCOL_JSON);
		response.setSellerToFulfilmentModel(sellerToFulfilmentModel);
		response.setSuccessful(true);
		response.setValidationErrors(validationErrors);
		//byte[] responseStr = doJsonSerailize(response.getClass(), response);
		return response;
		
	
	}
	
	/*
	 * This Method creates the mock response for the getInventoryPricingBySUPCSeller API.
	 * In this method we set the fields require for the mock response using the getter
	 * and setter methods of the response class.It returns the Response of the type that
	 * the getInventoryPricingBySUPCSeller API is returning.
	 */
	
	@SuppressWarnings("deprecation")
	private static GetInventoryPricingBySUPCSellerResponse createGetInventoryPricingBySUPCSeller()throws SerializationException{
		GetInventoryPricingBySUPCSellerResponse response=new GetInventoryPricingBySUPCSellerResponse();
		String code="0";
		String message=null;
		CatalogType catalogType=CatalogType.PRODUCT;
		String sellerCode="aace21";
		String supc="SDL104973168";
		List validationErrors=new ArrayList();
		IPMSResponseCode ipmsResponseCode=IPMSResponseCode.REQUEST_UNSERVICEABLE;
		SUPCSellerMappingSRO sUPCSellerMappingSRO=new SUPCSellerMappingSRO();
		sUPCSellerMappingSRO.setSellerCode(sellerCode);
		sUPCSellerMappingSRO.setSupc(supc);
		
		SUPCSellerInventoryPricingSRO sUPCSellerInventoryPricingSRO=new SUPCSellerInventoryPricingSRO();
		int buyableInventory=666632;
		EMIChargesSRO emiChargesSRO=new EMIChargesSRO();
		emiChargesSRO.setEmiChargesBorneByCustomer(true);
		emiChargesSRO.setEmiChargesSellerComponent(null);
		emiChargesSRO.setEmiChargesSnapdealComponent(null);
		sUPCSellerInventoryPricingSRO.setBuyableInventory(buyableInventory);
		sUPCSellerInventoryPricingSRO.setEmiChargesSRO(emiChargesSRO);
		ExternalCashbackSRO externalCashbackSRO=new ExternalCashbackSRO();
		externalCashbackSRO.setCashbackDisplayType(CashbackDisplayType.ABS);
		Date endTime=new Date(1490985000000L);
		externalCashbackSRO.setEndTime(endTime);
		externalCashbackSRO.setSellerCashbackComponent(3990.0f);
		externalCashbackSRO.setSnapdealCashbackComponent(3990.0f);
		Date startTime=new Date(1427826600000L);
		externalCashbackSRO.setStartTime(startTime);
		sUPCSellerInventoryPricingSRO.setExternalCashbackSRO(externalCashbackSRO);
		List <Integer> freebieCodeList=new ArrayList<Integer>();
		freebieCodeList.add(15910);
		sUPCSellerInventoryPricingSRO.setFreebieCodeList(freebieCodeList);
		Integer initialPrice=51;
		sUPCSellerInventoryPricingSRO.setInitialPrice(initialPrice);
		
		InternalCashbackSRO internalCashbackSRO=new InternalCashbackSRO();
		internalCashbackSRO.setCashbackDisplayType(CashbackDisplayType.ABS);
		Date endTime1=new Date(1423852200000L);
		internalCashbackSRO.setEndTime(endTime1);
		internalCashbackSRO.setSellerCashbackComponent(100.0f);
		internalCashbackSRO.setSnapdealCashbackComponent(200.0f);
		Date startTime1=new Date(1423593000000L);
		internalCashbackSRO.setStartTime(startTime1);
		
		sUPCSellerInventoryPricingSRO.setInternalCashbackSRO(internalCashbackSRO);
		sUPCSellerInventoryPricingSRO.setMarketingFee(null);
		sUPCSellerInventoryPricingSRO.setOverallRating(4.0f);
		sUPCSellerInventoryPricingSRO.setPayToMerchant(null);
		sUPCSellerInventoryPricingSRO.setPrice(10000);
		sUPCSellerInventoryPricingSRO.setSellerDisplayName("Mapple Ventures");
		sUPCSellerInventoryPricingSRO.setSellerName("Mapple Ventures");
		sUPCSellerInventoryPricingSRO.setSellingPrice(8050);
		sUPCSellerInventoryPricingSRO.setShippingCharges(0);
		sUPCSellerInventoryPricingSRO.setShippingDays(3);
		sUPCSellerInventoryPricingSRO.setStatus(InventoryPricingStatus.LIVE);
		sUPCSellerInventoryPricingSRO.setVendorSku("96656-large");
			
		Map<SUPCSellerMappingSRO, SUPCSellerInventoryPricingSRO> supcToInventoryPricingMap=new HashMap<SUPCSellerMappingSRO, SUPCSellerInventoryPricingSRO>();
		supcToInventoryPricingMap.put(sUPCSellerMappingSRO, sUPCSellerInventoryPricingSRO);
		response.setCode(code);
		response.setIpmsResponseCode(ipmsResponseCode);
		response.setMessage(message);
		response.setProtocol(Protocol.PROTOCOL_JSON);
		response.setSuccessful(true);
		response.setSupcToInventoryPricingMap(supcToInventoryPricingMap);
		response.setValidationErrors(validationErrors);
		//byte[] responseStr = doJsonSerailize(response.getClass(), response);
		//return responseStr;
		return response;
		
	}
	
	/*
	 * This Method creates the mock response for the getOrderByCode API.
	 * In this method we set the fields require for the mock response using the getter
	 * and setter methods of the response class.It returns the Response of the type that
	 * the getOrderByCode API is returning.
	 */
	@SuppressWarnings("deprecation")
	private static byte[] createGetOrderByCode()throws SerializationException{
		GetOrderResponse response=new GetOrderResponse();
		response.setCode(null);
		response.setMessage(null);
		AddressDetailSRO addressDetailSRO=new AddressDetailSRO();
		addressDetailSRO.setAddressLine1("hello");
		addressDetailSRO.setAddressLine2("jdasjsa");
		addressDetailSRO.setCity("New Delhi");
		addressDetailSRO.setDndActive(false);
		addressDetailSRO.setLandline("landline");
		addressDetailSRO.setMobile("9899601834");
		addressDetailSRO.setName("sanchitmahajan");
		addressDetailSRO.setPincode("110018");
		addressDetailSRO.setState("Delhi");
		OrderSRO orderSRO=new OrderSRO();
		orderSRO.setAddressDetail(addressDetailSRO);
		orderSRO.setAffiliateId(null);
		orderSRO.setChannelCode("INLINK");
		orderSRO.setCode("14808213");
		Date created=new Date(1422599497000L);
		orderSRO.setCreated(created);
		orderSRO.setCustomerName("sanchitmahajan");
		orderSRO.setEmail( "sanchit.mahajan@snapdeal.com");
		orderSRO.setExpressDeliveryCharges(0);
		orderSRO.setExternalCashbackValue(0);
		orderSRO.setGiftWrapCharges(0);
		orderSRO.setId(48821);
		orderSRO.setInternalCashbackValue(0);
		orderSRO.setLatitude(null);
		orderSRO.setLongitude(null);
		orderSRO.setMobile("9899601834");
		Set<OrderRefundSRO>orderRefundSROs=new HashSet<OrderRefundSRO>();
		orderSRO.setOrderRefunds(orderRefundSROs);
		OrderStatusSRO orderStatusSRO=new OrderStatusSRO();
		orderStatusSRO.setCode("CLD");
		orderStatusSRO.setDescription("Cancelled");
		orderStatusSRO.setId(4);
		orderStatusSRO.setValue("Cancelled");
		orderSRO.setOrderStatus(orderStatusSRO);
		orderSRO.setOrderSummaryLink( "https://ite3.snapdeal.com:9447//orderSummary?code=6f8b5851b91f178f5e7d8e276327791d&order=14808213");
		Set<OrderTransactionSRO> orderTransactionSROs=new HashSet<OrderTransactionSRO>();
		orderSRO.setOrderTransactions(orderTransactionSROs);
		orderSRO.setOrderType(null);	
		orderSRO.setPaidAmount(3986);
		orderSRO.setPartnerTransactionCode(null);
		orderSRO.setPrice(10000);
		orderSRO.setPromoValue(10);
		orderSRO.setRefundAmount(3986);
		orderSRO.setRetry(false);
		orderSRO.setSdCash(0);
		orderSRO.setSellingPrice(3996);
		orderSRO.setShippingCharges(0);
		orderSRO.setShippingMethodCharges(0);
		orderSRO.setSuborders(null);
		Date updated=new Date(1422607464000L);
		orderSRO.setUpdated(updated);
		orderSRO.setUserId(567597);
		orderSRO.setZoneId(28);
		Set<SuborderSRO> suborderSROs=new HashSet<SuborderSRO>();
		orderSRO.setSuborders(suborderSROs);
		response.setOrderSRO(orderSRO);
		response.setProtocol(Protocol.PROTOCOL_JSON);
		response.setSuccessful(true);
		List<ValidationError> validationErrors=new ArrayList();
		response.setValidationErrors(validationErrors);
		byte[] responseStr = doJsonSerailize(response.getClass(), response);
		return responseStr;
	}
	
	/*
	 * This Method creates the mock response for the getSuborderByCode API.
	 * In this method we set the fields require for the mock response using the getter
	 * and setter methods of the response class.It returns the Response of the type that
	 * the getSuborderByCode API is returning.
	 */
	
	@SuppressWarnings({ "deprecation"})
	private static byte[] createGetSuborderByCode()throws SerializationException{
		 GetSuborderResponse response=new  GetSuborderResponse();
		 
		 response.setCode(null);
		 response.setMessage(null);
		 response.setProtocol(Protocol.PROTOCOL_JSON);
		 SuborderSRO suborderSRO = new SuborderSRO() {
		};
		 suborderSRO.setCatalogId(646748460);
		 suborderSRO.setCatalogIdL(646748460l);
		 suborderSRO.setCatalogType("product");
		 suborderSRO.setCode("16486873");
		 Date created=new Date(1422603240000L);
		 suborderSRO.setCreated(created);
		 suborderSRO.setCustomerName("Sunayna Talreja");
		 suborderSRO.setDeliveryDate(null);
		 suborderSRO.setEmiCharges(0);
		 suborderSRO.setExpressDeliveryCharges(0);
		 suborderSRO.setExpressDeliveryType(ExpressDeliveryType.STANDARD);
		 suborderSRO.setExternalCashbackValue(0);
		 suborderSRO.setGiftWrap(false);
		 suborderSRO.setGiftWrapCharges(0);
		 suborderSRO.setId(64687);
		 suborderSRO.setInternalCashbackValue(0);
		 suborderSRO.setInventoryTxnCode("5212182");
		 suborderSRO.setOfferDiscount(0);
		 suborderSRO.setOfferPrice(27000);
		 
		 AddressDetailSRO addressDetailSRO=new AddressDetailSRO();
		 addressDetailSRO.setAddressLine1( "238, Snapdeal Building, Okhla Phase-3, Near Modi Mill");
		 addressDetailSRO.setAddressLine2("DELHI");
		 addressDetailSRO.setAddressTag(null);
		 addressDetailSRO.setCity("Bangalore");
		 addressDetailSRO.setDefaultAddress(false);
		 addressDetailSRO.setDndActive(false);
		 addressDetailSRO.setId(47734);
		 addressDetailSRO.setLandline("");
		 addressDetailSRO.setMobile("7411645173");
		 addressDetailSRO.setName("Sunayna Talreja");
		 addressDetailSRO.setPincode("560037");
		 addressDetailSRO.setRecipient_mobile("7411645173");
		 addressDetailSRO.setRecipient_name( "Sunayna Talreja");
		 addressDetailSRO.setState("Karnataka");
		 suborderSRO.setOrderAddressDetail(addressDetailSRO);
		 suborderSRO.setOrderCode("14888453");
		 suborderSRO.setOrderEmail("sunayna.talreja@snapdeal.com");
		 suborderSRO.setOrderId(48845);
		 suborderSRO.setOrderMobile("7411645173");
		 suborderSRO.setOrderViewSource(null);
		 suborderSRO.setPaidAmount(26990);
		 suborderSRO.setPrice(28900);
		 Date promisedDeliveryDate=new Date(1427466600000L);
		 suborderSRO.setPromisedDeliveryDate(promisedDeliveryDate);
		 suborderSRO.setPromoCode("yahoo123");
		 suborderSRO.setPromoValue(10);
		 suborderSRO.setRefundAmount(0);
		 suborderSRO.setSdCash(0);
		 suborderSRO.setSdCashCredited(0);
		 suborderSRO.setSellingPrice(27000);
		 suborderSRO.setShippingCharges(27000);
		 suborderSRO.setShippingMethodCharges(0);
		 suborderSRO.setShippingMethodCode("COD");
		 
		 SuborderStatusSRO suborderStatusSRO=new SuborderStatusSRO();
		 suborderStatusSRO.setCode("CLD");
		 suborderStatusSRO.setDescription("Cancelled");
		 suborderStatusSRO.setId(5);
		 suborderStatusSRO.setMacroDescription("Cancelled");
		 suborderStatusSRO.setMicroDescription("Cancelled");
		 suborderStatusSRO.setValue("Cancelled");
		 suborderSRO.setSuborderStatus(suborderStatusSRO);
		 
		 SuborderTypeSRO suborderTypeSRO=new SuborderTypeSRO();
		 suborderTypeSRO.setCode("REG");
		 suborderTypeSRO.setId(1);
		 suborderTypeSRO.setValue("Regular");
		 suborderSRO.setSuborderType(suborderTypeSRO);
		 suborderSRO.setSupcCode("SDL153656013");
		 Date updated=new Date(1429537992000L);
		 suborderSRO.setUpdated(updated);
		 suborderSRO.setVendorCode("b56f58");
		 Date verifiedDate=new Date(1422609282000L);
		 suborderSRO.setVerifiedDate(verifiedDate);
		 suborderSRO.setZoneId(28);
		 suborderSRO.setZonePageUrl("delhi");
		 response.setSuborderSRO(suborderSRO);
		 response.setSuccessful(true);
		 List<ValidationError> validationErrors=new ArrayList();
		 response.setValidationErrors(validationErrors);
		byte[] responseStr = doJsonSerailize(response.getClass(), response);
		return responseStr;
	}
	/*
	 * This Method creates the mock response for the getOrderById API.
	 * In this method we set the fields require for the mock response using the getter
	 * and setter methods of the response class.It returns the Response of the type that
	 * the getOrderById API is returning.
	 */
	
	@SuppressWarnings({ "deprecation"})
	private static GetOrderResponse createGetOrderById()throws SerializationException{
		GetOrderResponse response=new  GetOrderResponse();
		
		response.setCode(null);
		response.setMessage(null);
		
		
		OrderSRO orderSRO=new OrderSRO();
		
		 AddressDetailSRO addressDetailSRO=new AddressDetailSRO();
		 addressDetailSRO.setAddressLine1( "238, Snapdeal Building, Okhla Phase-3, Near Modi Mill hello");
		 addressDetailSRO.setAddressLine2("DELHI");
		 addressDetailSRO.setAddressTag(null);
		 addressDetailSRO.setCity("New Delhi");
		 addressDetailSRO.setDefaultAddress(false);
		 addressDetailSRO.setDndActive(false);
		 addressDetailSRO.setId(47710);
		 addressDetailSRO.setLandline("");
		 addressDetailSRO.setMobile("9899601834");
		 addressDetailSRO.setName("sanchitmahajan");
		 addressDetailSRO.setPincode("110018");
		 addressDetailSRO.setRecipient_mobile("9899601834");
		 addressDetailSRO.setRecipient_name("sanchitmahajan");
		 addressDetailSRO.setState("Delhi");
		 orderSRO.setAddressDetail(addressDetailSRO);
		 orderSRO.setAffiliateId(null);
		
		orderSRO.setChannelCode("INLINK");
		orderSRO.setCode("14808213");
		Date created=new Date(1422599497000L);
		orderSRO.setCreated(created);
		orderSRO.setCustomerName("sanchitmahajan");
		orderSRO.setEmail( "sanchit.mahajan@snapdeal.com");
		orderSRO.setExpressDeliveryCharges(0);
		orderSRO.setExternalCashbackValue(0);
		orderSRO.setGiftWrapCharges(0);
		orderSRO.setId(48821);
		orderSRO.setInternalCashbackValue(0);
		orderSRO.setLatitude(null);
		orderSRO.setLongitude(null);
		orderSRO.setMobile("9899601834");
		Set<OrderRefundSRO>orderRefundSROs=new HashSet<OrderRefundSRO>();
		orderSRO.setOrderRefunds(orderRefundSROs);
		
		OrderStatusSRO orderStatusSRO=new OrderStatusSRO();
		orderStatusSRO.setCode("CLD");
		orderStatusSRO.setDescription("Cancelled");
		orderStatusSRO.setId(4);
		orderStatusSRO.setValue("Cancelled");
		orderSRO.setOrderStatus(orderStatusSRO);
		orderSRO.setOrderSummaryLink( "https://ite3.snapdeal.com:9447//orderSummary?code=6f8b5851b91f178f5e7d8e276327791d&order=14808213");
		Set<OrderTransactionSRO> orderTransactionSROs=new HashSet<OrderTransactionSRO>();
		orderSRO.setOrderTransactions(orderTransactionSROs);
		orderSRO.setOrderType(null);	
		orderSRO.setPaidAmount(3986);
		orderSRO.setPartnerTransactionCode(null);
		orderSRO.setPrice(10000);
		orderSRO.setPromoValue(10);
		orderSRO.setRefundAmount(3986);
		orderSRO.setRetry(false);
		orderSRO.setSdCash(0);
		orderSRO.setSellingPrice(3996);
		orderSRO.setShippingCharges(0);
		orderSRO.setShippingMethodCharges(0);
		
		Set<SuborderSRO>subOrderSRO=new HashSet<SuborderSRO>();
		orderSRO.setSuborders(subOrderSRO);
		
		Date updated=new Date(1422607464000L);
		orderSRO.setUpdated(updated);
		orderSRO.setUserId(567597);
		orderSRO.setZoneId(28);
		response.setOrderSRO(orderSRO);
		response.setProtocol(Protocol.PROTOCOL_JSON);
		response.setSuccessful(true);
		List<ValidationError> validationErrors=new ArrayList<ValidationError>();
		response.setValidationErrors(validationErrors);
		// byte[] responseStr = doJsonSerailize(response.getClass(), response);
			//return responseStr;
		return response;
	
	}
	
	@SuppressWarnings({ "deprecation"})
	private static GetCommonPickUpResponse createGetCommonPickupAvailableStores()throws SerializationException{
		GetCommonPickUpResponse response=new GetCommonPickUpResponse();
		response.setPickupServiceability();
		response.setPickupStoreList();
		response.setStoreAddress();
		response.setStoreTimings();
		return response;
	}
	
	@SuppressWarnings({ "deprecation"})
	private static GetO2OServiceabilityResponse createGetO2OServiceability()throws SerializationException{
		GetO2OServiceabilityResponse response=new GetO2OServiceabilityResponse();
		response.setCodPickupAvailable("true");
		response.setStdPickupAvailable("true");
		response.setCodDeliveryAvailable("true");
		response.setStdDeliveryAvailable("true");
		response.setDeliverySLA(72);
		response.setDispatchSLA(48);
		response.setSellerCode("abs675");
		response.setSuccessful(true);
		response.setSupc("sdf7894");
		return response;
	}
	
	public static void getO2OServiceability() throws SerializationException {
		GetO2OServiceabilityResponse response = createGetO2OServiceability();
		String supcCode1="\"supc\" : \"sdf7894\"";
		String supcCode2="\"supc\" : \"sdf7895\"";
		String supcCode3="\"supc\" : \"sdf7896\"";
		String supcCode4="\"supc\" : \"sdf7897\"";
		String sellerCode1="\"sellerCode\" : \"abs675\"";
		String sellerCode2="\"sellerCode\" : \"abs676\"";
		String sellerCode3="\"sellerCode\" : \"abs677\"";
		String sellerCode4="\"sellerCode\" : \"abs678\"";
		response.setCodPickupAvailable("true");
		response.setStdPickupAvailable("true");
		byte[] responseStr1 = doJsonSerailize(response.getClass(), response);
		response.setCodPickupAvailable("true");
		response.setStdPickupAvailable("false");
		byte[] responseStr2 = doJsonSerailize(response.getClass(), response);
		response.setCodPickupAvailable("false");
		response.setStdPickupAvailable("true");
		byte[] responseStr3 = doJsonSerailize(response.getClass(), response);
		response.setCodPickupAvailable("false");
		response.setStdPickupAvailable("false");
		byte[] responseStr4 = doJsonSerailize(response.getClass(), response);
		
		onRequest()
				.havingMethodEqualTo("POST")
				.havingHeaderEqualTo("Content-Type", "application/json")
				//.havingPathEqualTo("/service/get/o2oStores/getO2OServiceability")
				.havingPathEqualTo("/service/mobapi/getO2ODeliveryServiceability")
				.havingBody(containsString(supcCode1))
				.havingBody(containsString(sellerCode1))
		.respond()
				.withBody(responseStr1);
		
		
		onRequest()
		.havingMethodEqualTo("POST")
		.havingHeaderEqualTo("Content-Type", "application/json")
		//.havingPathEqualTo("/service/get/o2oStores/getO2OServiceability")
		.havingPathEqualTo("/service/mobapi/getO2OPickupServiceability")
		.havingBody(containsString(supcCode2))
		.havingBody(containsString(sellerCode2))
.respond()
		.withBody(responseStr2);
		
		
		onRequest()
		.havingMethodEqualTo("POST")
		.havingHeaderEqualTo("Content-Type", "application/json")
		//.havingPathEqualTo("/service/get/o2oStores/getO2OServiceability")
		.havingPathEqualTo("/service/mobapi/getO2ODeliveryServiceability")
		//.havingPathEqualTo("/service/mobapi/getO2OPickupServiceability")
		.havingBody(containsString(supcCode3))
		.havingBody(containsString(sellerCode3))
.respond()
		.withBody(responseStr3);
	
		onRequest()
		.havingMethodEqualTo("POST")
		.havingHeaderEqualTo("Content-Type", "application/json")
		//.havingPathEqualTo("/service/get/o2oStores/getO2OServiceability")
		.havingPathEqualTo("/service/mobapi/getO2OPickupServiceability")
		.havingBody(containsString(supcCode4))
		.havingBody(containsString(sellerCode4))
.respond()
		.withBody(responseStr4);
	
	
	}
	
	
	public static void getCommonPickupAvailableStores() throws SerializationException {
		GetCommonPickUpResponse response = createGetCommonPickupAvailableStores();
		String supcCode1="\"supc\" : \"sdf7894\"";
		String supcCode2="\"supc\" : \"sdf7895\"";
		String supcCode3="\"supc\" : \"sdf7896\"";
		String supcCode4="\"supc\" : \"sdf7897\"";
		String sellerCode1="\"sellerCode\" : \"abs675\"";
		String sellerCode2="\"sellerCode\" : \"abs676\"";
		String sellerCode3="\"sellerCode\" : \"abs677\"";
		String sellerCode4="\"sellerCode\" : \"abs678\"";
		response.setCodPickupAvailable("true");
		response.setStdPickupAvailable("true");
		byte[] responseStr1 = doJsonSerailize(response.getClass(), response);
		
		response.setCodPickupAvailable("true");
		response.setStdPickupAvailable("false");
		byte[] responseStr2 = doJsonSerailize(response.getClass(), response);
		
		response.setCodPickupAvailable("false");
		response.setStdPickupAvailable("true");
		byte[] responseStr3 = doJsonSerailize(response.getClass(), response);
		
		response.setCodPickupAvailable("false");
		response.setStdPickupAvailable("false");
		byte[] responseStr4 = doJsonSerailize(response.getClass(), response);
		onRequest()
				.havingMethodEqualTo("POST")
				.havingHeaderEqualTo("Content-Type", "application/json")
				//Change it from getCommonPickupAvailableStores to getAvailablePickupStores
				.havingPathEqualTo("/service/get/o2oStores/getAvailablePickupStores")
				.havingBody(containsString(supcCode1))
				.havingBody(containsString(sellerCode1))
		.respond()
				.withBody(responseStr1);
		
		onRequest()
		.havingMethodEqualTo("POST")
		.havingHeaderEqualTo("Content-Type", "application/json")
		//Change it from getCommonPickupAvailableStores to getAvailablePickupStores
		.havingPathEqualTo("/service/get/o2oStores/getAvailablePickupStores")
		//.havingPathEqualTo("/service/get/o2oStores/getCommonPickupAvailableStores")
		.havingBody(containsString(supcCode2))
		.havingBody(containsString(sellerCode2))
.respond()
		.withBody(responseStr2);
	
		onRequest()
		.havingMethodEqualTo("POST")
		.havingHeaderEqualTo("Content-Type", "application/json")
		//Change it from getCommonPickupAvailableStores to getAvailablePickupStores
		.havingPathEqualTo("/service/get/o2oStores/getAvailablePickupStores")
		//.havingPathEqualTo("/service/get/o2oStores/getCommonPickupAvailableStores")
		.havingBody(containsString(supcCode3))
		.havingBody(containsString(sellerCode3))
.respond()
		.withBody(responseStr3);
		
		onRequest()
		.havingMethodEqualTo("POST")
		.havingHeaderEqualTo("Content-Type", "application/json")
		//Change it from getCommonPickupAvailableStores to getAvailablePickupStores
		.havingPathEqualTo("/service/get/o2oStores/getAvailablePickupStores")
		//.havingPathEqualTo("/service/get/o2oStores/getCommonPickupAvailableStores")
		.havingBody(containsString(supcCode4))
		.havingBody(containsString(sellerCode4))
.respond()
		.withBody(responseStr4);
	
	}
	
	
	
	
	
	/*This method alters the response for getSellerWiseDeliveryInfo API based on followings:-
	 * 1. For supc =SDL012542092 and seller code =ef6f3b 
	 *    setCODPickupAvailable=true and stdpickupAvailable=true will be set in response
	 * 2. For supc =SDL012542091 and seller code =ef6f2b 
	 *    setCODPickupAvailable=true and setSTDPickupAvailable=false will be set in response
	 * 3. For supc =SDL012542093 and seller code =ef6f4b 
	 *    setCODPickupAvailable=false and setSTDPickupAvailable=true will be set in response
	 * 4. For supc =SDL012542094 and seller code =ef6f5b	 
	 *    setCODPickupAvailable=false and setSTDPickupAvailable=false will be set in response
	 * For any other combination of supc and seller code no response will be send.
	 */
	public static void getSellerWiseDeliveryInfo() throws SerializationException {
		GetPerSellerDeliveryInfoResponse response = createGetSellerWiseDeliveryInfo();
		//String requestBody="{\"responseProtocol\" : \"PROTOCOL_JSON\",\"requestProtocol\" : \"PROTOCOL_JSON\",\"supc\" : \"SDL012542092\",\"pincode\" : \"110020\",\"productInfoSro\" : {\"categoryUrl\" : \"mobiles-mobile-phones\", \"brandName\" : \"Apple\"},\"sellerInfo\" : [{\"sellerCode\" : \"ef6f3b\", \"sellingPrice\" : 401.0, \"fulfilmentModel\" : \"FC_VOI\"}],\"useCutOffBuffer\" : false}";
		String supcCode1="\"supc\" : \"SDL012542092\"";
		String sellerCode1="\"sellerCode\" : \"ef6f3b\"";
		
		String supcCode2="\"supc\" : \"SDL012542091\"";
		String sellerCode2="\"sellerCode\" : \"ef6f2b\"";
		
		String supcCode3="\"supc\" : \"SDL012542093\"";
		String sellerCode3="\"sellerCode\" : \"ef6f4b\"";
		
		String supcCode4="\"supc\" : \"SDL012542094\"";
		String sellerCode4="\"sellerCode\" : \"ef6f5b\"";


		PVCDeliveryInfoSRO deliveryInfo=response.getDeliveryInfo();
		deliveryInfo.setCODPickupAvailable(true);
		deliveryInfo.setSTDPickupAvailable(true);
		response.setDeliveryInfo(deliveryInfo);
		byte[] responseStr1 = doJsonSerailize(response.getClass(), response);
		//setting true false
		deliveryInfo.setCODPickupAvailable(true);
		deliveryInfo.setSTDPickupAvailable(false);
		response.setDeliveryInfo(deliveryInfo);
		byte[] responseStr2 = doJsonSerailize(response.getClass(), response);
		//setting false true
		deliveryInfo.setCODPickupAvailable(false);
		deliveryInfo.setSTDPickupAvailable(true);
		response.setDeliveryInfo(deliveryInfo);
		byte[] responseStr3 = doJsonSerailize(response.getClass(), response);
		//setting true false
		deliveryInfo.setCODPickupAvailable(false);
		deliveryInfo.setSTDPickupAvailable(false);
		response.setDeliveryInfo(deliveryInfo);
		byte[] responseStr4 = doJsonSerailize(response.getClass(), response);
	
		
		onRequest()
				.havingMethodEqualTo("POST")
				.havingPathEqualTo("/service/score/getSellerWiseDeliveryInfo")
				.havingHeaderEqualTo("Content-Type", "application/json")
				.havingBody(containsString(supcCode1))
				.havingBody(containsString(sellerCode1))
		.respond()
				.withBody(responseStr1);
		
		
		
		onRequest()
		.havingMethodEqualTo("POST")
		.havingPathEqualTo("/service/score/getSellerWiseDeliveryInfo")
		.havingHeaderEqualTo("Content-Type", "application/json")
		.havingBody(containsString(supcCode2))
		.havingBody(containsString(sellerCode2))
.respond()
		.withBody(responseStr2);
		
		
		onRequest()
		.havingMethodEqualTo("POST")
		.havingPathEqualTo("/service/score/getSellerWiseDeliveryInfo")
		.havingHeaderEqualTo("Content-Type", "application/json")
		.havingBody(containsString(supcCode3))
		.havingBody(containsString(sellerCode3))
.respond()
		.withBody(responseStr3);
		
		onRequest()
		.havingMethodEqualTo("POST")
		.havingPathEqualTo("/service/score/getSellerWiseDeliveryInfo")
		.havingHeaderEqualTo("Content-Type", "application/json")
		.havingBody(containsString(supcCode4))
		.havingBody(containsString(sellerCode4))
.respond()
		.withBody(responseStr4);


	}
	/*This method will alter the response for getFulfilmeontModelBySellerSupcSubcat based on followings:-
	 * 1. For supc=SDL758628757
		 	  sellerCodes="e81b95
		      subcat=computers-laptop
		  the FulfillmentModel=FC_VOI will be set in response
	   2. For supc=SDL758628758
		 	  sellerCodes="e81b96
		      subcat=mobiles
		  the FulfillmentModel=O2O will be set in response
	For any other combination of supc,seller code and subcat no response will be sent.
	 */
	
	public static void getFulfilmeontModelBySellerSupcSubcat() throws SerializationException {
		GetFulfilmentModelBySellerSupcSubcatResponse response = createGetFulfilmentModelBySellerSupcSubcat();
		String supcCode1="\"supc\": \"SDL758628757\"";
		String sellerCode1="\"sellerCodes\": [\"e81b95\"]";
		String subCat1="\"subcat\": \"computers-laptops\"";
		
		String supcCode2="\"supc\": \"SDL758628758\"";
		String sellerCode2="\"sellerCodes\": [\"e81b96\"]";
		String subCat2="\"subcat\": \"mobiles\"";
		Map<String,FulfillmentModel> sellerToFulfilmentModel=response.getSellerToFulfilmentModel();
		sellerToFulfilmentModel.put("644db7", FulfillmentModel.FC_VOI);
		response.setSellerToFulfilmentModel(sellerToFulfilmentModel);
		byte[] responseStr1 = doJsonSerailize(response.getClass(), response);
		//setting FullfillmentModel to O2O
		sellerToFulfilmentModel.put("644db7", FulfillmentModel.O2O);
		response.setSellerToFulfilmentModel(sellerToFulfilmentModel);
		byte[] responseStr2 = doJsonSerailize(response.getClass(), response);
		//String requestbody="{\"responseProtocol\": \"PROTOCOL_JSON\",\"requestProtocol\": \"PROTOCOL_JSON\",\"sellerCodes\": [\"e81b95\"],\"supc\": \"SDL758628757\",\"subcat\": \"computers-laptops\"}";
		onRequest()
				.havingMethodEqualTo("POST")
				.havingPathEqualTo("/service/cocofs/getFulfilmentModelBySellerSupcSubcat")
				.havingHeaderEqualTo("Content-Type", "application/json")
				.havingBody(containsString(supcCode1))
				.havingBody(containsString(sellerCode1))
				.havingBody(containsString(subCat1))
				
		.respond()
				.withBody(responseStr1);
		//setting response to have FullfilmentModel to O2O
		onRequest()
		.havingMethodEqualTo("POST")
		.havingPathEqualTo("/service/cocofs/getFulfilmentModelBySellerSupcSubcat")
		.havingHeaderEqualTo("Content-Type", "application/json")
		.havingBody(containsString(supcCode2))
		.havingBody(containsString(sellerCode2))
		.havingBody(containsString(subCat2))
		
.respond()
		.withBody(responseStr2);
		
	}
	
	
	
	
	public static void getInventoryPricingBySUPCSeller() throws SerializationException {
		GetInventoryPricingBySUPCSellerResponse response = createGetInventoryPricingBySUPCSeller();
		
		//String requestbody="{\"supcSellerMappings\":[{\"supc\":\"SDL104973168\",\"sellerCode\":\"aace21\",\"catalogType\":\"PRODUCT\"}] , \"responseProtocol\":\"PROTOCOL_JSON\",\"requestProtocol\":\"PROTOCOL_JSON\"}";
		String supccode1="\"supc\":\"SDL104973168\"";
		String sellercode1="\"sellerCode\":\"aace21\"";
		Map<SUPCSellerMappingSRO, SUPCSellerInventoryPricingSRO> supcToInventoryPricingMap=response.getSupcToInventoryPricingMap();
		//supcToInventoryPricingMap.put(key, value)
		response.setSupcToInventoryPricingMap(supcToInventoryPricingMap);
		byte[] responseStr1 = doJsonSerailize(response.getClass(), response);
		
		onRequest()
				.havingMethodEqualTo("POST")
				.havingPathEqualTo("/service/ipms/getInventoryPricingBySUPCSeller")
				.havingHeaderEqualTo("Content-Type", "application/json")
				.havingBody(containsString(supccode1))
				.havingBody(containsString(sellercode1))
		.respond()
				.withBody(responseStr1);
		
	}
	
	
	
	public static void getOrderByCode() throws SerializationException {
		byte[] response = createGetOrderByCode();
		
		String requestbody="{\"orderCode\":\"14808213\",\"fetchType\":\"FETCH_WITH_BASIC_DETAILS\",\"responseProtocol\":\"PROTOCOL_JSON\",\"requestProtocol\":\"PROTOCOL_JSON\"}";
		onRequest()
				.havingMethodEqualTo("POST")
				.havingPathEqualTo("/service/oms/order/getOrderByCode")
				.havingHeaderEqualTo("Content-Type", "application/json")
		//		.havingBodyEqualTo(requestbody)
		.respond()
				.withBody(response);
		
	}
	
	public static void getSuborderByCode() throws SerializationException {
		byte[] response = createGetSuborderByCode();
		onRequest()
			.havingMethodEqualTo("POST")
			.havingPathEqualTo("/service/oms/order/getSuborderByCode")
			.havingHeaderEqualTo("Content-Type", "application/json")
			//.havingBodyEqualTo(requestbody)
		.respond()
			.withBody(response);

	}
	
	public static void getOrderById() throws SerializationException {
		//byte[] response = createGetOrderById();
		GetOrderResponse response=createGetOrderById();
		
		OrderSRO orderSRO=response.getOrderSRO();
		orderSRO.setEmail("avinash.singh@snapdeal.com");
		byte[] responseStr1 = doJsonSerailize(response.getClass(), response);
		onRequest()
			.havingMethodEqualTo("POST")
			.havingPathEqualTo("/service/oms/order/getOrderById")
			.havingHeaderEqualTo("Content-Type", "application/json")
			//.havingBody(containsString("\"orderCode\":\"14808213\""))
			
		.respond()
			.withBody(responseStr1);

	}
	
	
	public static void getStoreDetails() throws SerializationException
	{
		
		String sellercode="abcd123";
		GetStoreDetailsResponse res2= new GetStoreDetailsResponse(sellercode);
		byte[] response2 = doJsonSerailize(res2.getClass(), res2);
		
		onRequest()
		.havingPathEqualTo("/service/mobapi/getStoreDetails").havingBody(containsString(sellercode))
		.respond()
		.withBody(response2);
		
	}
	
	
}
