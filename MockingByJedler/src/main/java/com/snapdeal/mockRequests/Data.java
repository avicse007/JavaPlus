package com.snapdeal.mockRequests;

import java.util.ArrayList;
import java.util.List;

public class Data
{
    private List <StoreDetails> storeDetails= new ArrayList<StoreDetails>();

    
   public  Data(String supc)
    {
    	StoreDetails sd = new StoreDetails();
    	sd.setCode(supc);
    	    	
    	StoreAddress sa = new StoreAddress();
    	sd.setStoreAddress(sa);
    	storeDetails.add(sd);
    	
    }
    public List<StoreDetails> getStoreDetails() {
		return storeDetails;
	}

	public void setStoreDetails(List<StoreDetails> storeDetails) {
		this.storeDetails = storeDetails;
		
	}

    @Override
    public String toString()
    {
        return "ClassPojo [storeDetails = "+storeDetails+"]";
    }
}