package com.snapdeal.mockRequests;

public class StoreAddress
{
    private String pinCode;

    private String phone;

    private String email;

    private String name;

    private String state;

    private String longitude;

    private String latitude;

    private String addressLine2;

    private String addressLine1;

    private String country;

    private String city;
    
    public StoreAddress()
    {
    	this.pinCode="";
    	this.phone="";
    	this.email="";
    	this.name="";
    	this.state="";
    	this.latitude="98.89";
    	this.longitude="56.89";
    	this.addressLine1="";
    	this.addressLine2="";
    	this.city="";
    	this.country="";
    			
    			

    }

    public String getPinCode ()
    {
        return pinCode;
    }

    public void setPinCode (String pinCode)
    {
        this.pinCode = pinCode;
    }

    public String getPhone ()
    {
        return phone;
    }

    public void setPhone (String phone)
    {
        this.phone = phone;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getState ()
    {
        return state;
    }

    public void setState (String state)
    {
        this.state = state;
    }

    public String getLongitude ()
    {
        return longitude;
    }

    public void setLongitude (String longitude)
    {
        this.longitude = longitude;
    }

    public String getLatitude ()
    {
        return latitude;
    }

    public void setLatitude (String latitude)
    {
        this.latitude = latitude;
    }

    public String getAddressLine2 ()
    {
        return addressLine2;
    }

    public void setAddressLine2 (String addressLine2)
    {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine1 ()
    {
        return addressLine1;
    }

    public void setAddressLine1 (String addressLine1)
    {
        this.addressLine1 = addressLine1;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

}
			
			
