package com.snapdeal.mockRequests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.snapdeal.base.validation.ValidationError;
public class GetO2OServiceabilityResponse {
	
	boolean successful;
	List<ValidationError>validationErrors;
	Map<String,String>o2oServiceabilityList;
	Map<String,String>pickupServiceability;
	Map<String,String>deliveryServiceability;
	int dispatchSLA;
	int deliverySLA;
	String stdPickupAvailable;
	String codPickupAvailable;
	String stdDeliveryAvailable;
	String codDeliveryAvailable;
	public String getStdDeliveryAvailable() {
		return stdDeliveryAvailable;
	}

	public void setStdDeliveryAvailable(String stdDeliveryAvailable) {
		this.stdDeliveryAvailable = stdDeliveryAvailable;
	}

	public String getCodDeliveryAvailable() {
		return codDeliveryAvailable;
	}

	public void setCodDeliveryAvailable(String codDeliveryAvailable) {
		this.codDeliveryAvailable = codDeliveryAvailable;
	}
	String sellerCode;
	String supc;
	
	public GetO2OServiceabilityResponse(){
		validationErrors=new ArrayList();
		o2oServiceabilityList=new HashMap();
		pickupServiceability=new HashMap();
		deliveryServiceability=new HashMap();
		
	}
	
	public boolean isSuccessful() {
		return successful;
	}
	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}
	public List<ValidationError> getValidationErrors() {
		return validationErrors;
	}
	public void setValidationErrors() {
		this.validationErrors = validationErrors;
	}
	public Map<String, String> getO2oServiceabilityList() {
		return o2oServiceabilityList;
	}
	public void setO2oServiceabilityList() {
		o2oServiceabilityList.put("supc", getSupc());
		o2oServiceabilityList.put("sellerCode", getSellerCode());
	}
	public Map<String, String> getPickupServiceability() {
		return pickupServiceability;
	}
	public void setPickupServiceability() {
		pickupServiceability.put("stdPickupAvailable", getStdPickupAvailable());
		pickupServiceability.put("codPickupAvailable", getCodPickupAvailable());
	}
	public Map<String, String> getDeliveryServiceability() {
		return deliveryServiceability;
	}
	public void setDeliveryServiceability() {
		deliveryServiceability.put("stdDeliveryAvailable", getStdDeliveryAvailable());
		deliveryServiceability.put("codDeliveryAvailable", getCodDeliveryAvailable());
		
	}
	public int getDispatchSLA() {
		return dispatchSLA;
	}
	public void setDispatchSLA(int dispatchSLA) {
		this.dispatchSLA = dispatchSLA;
	}
	public int getDeliverySLA() {
		return deliverySLA;
	}
	public void setDeliverySLA(int deliverySLA) {
		this.deliverySLA = deliverySLA;
	}
	public String getStdPickupAvailable() {
		return stdPickupAvailable;
	}
	public void setStdPickupAvailable(String stdPickupAvailable) {
		this.stdPickupAvailable = stdPickupAvailable;
	}
	public String getCodPickupAvailable() {
		return codPickupAvailable;
	}
	public void setCodPickupAvailable(String codPickupAvailable) {
		this.codPickupAvailable = codPickupAvailable;
	}
	
	public String getSellerCode() {
		return sellerCode;
	}
	public void setSellerCode(String sellerCode) {
		this.sellerCode = sellerCode;
	}
	public String getSupc() {
		return supc;
	}
	public void setSupc(String supc) {
		this.supc = supc;
	}
		

}
