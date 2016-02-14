package com.snapdeal.mockRequests;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.snapdeal.base.validation.ValidationError;

public class GetCommonPickUpResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Boolean successful;
	List <ValidationError> validation ;
	Map<String,Object> pickupStoreList;
	Map<String,String> storeAddress; 
	List<String> storeTimings ;
	Map<String,String> pickupServiceability; 
	String message ;
	public Boolean getSuccessful() {
		return successful;
	}

	public void setSuccessful(Boolean successful) {
		this.successful = successful;
	}

	public List<ValidationError> getValidation() {
		return validation;
	}

	public void setValidation(List<ValidationError> validation) {
		this.validation = validation;
	}

	public Map<String, Object> getPickupStoreList() {
		return pickupStoreList;
	}

	public void setPickupStoreList(Map<String, Object> pickupStoreList) {
		this.pickupStoreList = pickupStoreList;
	}

	public Map<String, String> getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(Map<String, String> storeAddress) {
		this.storeAddress = storeAddress;
	}

	public List<String> getStoreTimings() {
		return storeTimings;
	}

	public void setStoreTimings(List<String> storeTimings) {
		this.storeTimings = storeTimings;
	}

	public Map<String, String> getPickupServiceability() {
		return pickupServiceability;
	}

	public void setPickupServiceability(Map<String, String> pickupServiceability) {
		this.pickupServiceability = pickupServiceability;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getShortAddress() {
		return shortAddress;
	}

	public void setShortAddress(String shortAddress) {
		this.shortAddress = shortAddress;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	String name;
	String addressLine1;
	String addressLine2;
	String state;
	String country;
	String pincode;
	String phone;
	String email;
	String latitude;
	String longitude;
	String stdPickupAvailable;
	String codPickupAvailable;
	String code;
	String shortAddress;
	float distance;
	String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public GetCommonPickUpResponse(){
		successful=true;
		validation = new ArrayList<ValidationError>();
		pickupStoreList = new HashMap();
		storeAddress = new HashMap();
		storeTimings = new ArrayList<String>();
		pickupServiceability = new HashMap();
		message = "No store available for all the items in case list is empty";
	}
	
	public void setStoreTimings(){
		storeTimings.add("Mon-Fri 09:30-18:00");
	}
	public void setStoreAddress(){
		setName("");
		storeAddress.put("name",getName());
		setAddressLine1("");
		storeAddress.put("addressLine1",getAddressLine1());
		setAddressLine2("");
		storeAddress.put("addressLine2",getAddressLine2());
		setState("");
		storeAddress.put("state",getState());
		setCountry("");
		storeAddress.put("country",getCountry());
		setPincode("");
		storeAddress.put("pinCode",getPincode());
		setPhone("");
		storeAddress.put("phone",getPhone());
		setEmail("");
		storeAddress.put("email",getEmail());
		setLatitude("98.89");
		storeAddress.put("latitude",getLatitude());
		setLongitude("56.89");
		storeAddress.put("longitude",getLongitude());
		
	}
	
	public void setPickupServiceability(){
		setStdPickupAvailable("true");
		pickupServiceability.put("stdPickupAvailable", getStdPickupAvailable());
		setCodPickupAvailable("true");
		pickupServiceability.put("codPickupAvailable", getCodPickupAvailable());
		
	}
	
	public void setPickupStoreList(){
		setCode("asb23");
		pickupStoreList.put("code",getCode());
		setTitle("");
		pickupStoreList.put("title",getTitle());
		setShortAddress("");
		pickupStoreList.put("shortAddress",getShortAddress());
		pickupStoreList.put("storeAddress",storeAddress);
		setDistance(10.25F);
		pickupStoreList.put("distance",getDistance());
		pickupStoreList.put("storeTimings", storeTimings);
		pickupStoreList.put("pickupServiceability", pickupServiceability);
	}
	
	

}