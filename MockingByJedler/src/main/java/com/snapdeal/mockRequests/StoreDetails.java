package com.snapdeal.mockRequests;

import java.util.ArrayList;
import java.util.List;

public class StoreDetails

{
	
	private List<String> compactStoreTimings= new ArrayList<String>();

    private String title;

    private String shortAddress;

    private List <RawStoreTimings> rawStoreTimings= new ArrayList<RawStoreTimings>();

    private StoreAddress storeAddress;

    private String code;

    
    
    public StoreDetails()
    {
    	this.title="";
    	this.shortAddress="";
    	this.code="abcd123";
    	compactStoreTimings.add("Mon - Fri 9:30am - 6pm");
    	compactStoreTimings.add("Sat, 10am - 4pm");
    	
    	RawStoreTimings rt1= new RawStoreTimings();
    	rt1.setOpeningTime("09:30");
    	rt1.setClosingTime("20:00");
    	rt1.setDayOfWeek("MONDAY");
    	rt1.setClosed("false");
    	RawStoreTimings rt2= new RawStoreTimings();
    	rt2.setOpeningTime("09:30");
    	rt2.setClosingTime("20:00");
    	rt2.setDayOfWeek("TUESDAY");
    	rt2.setClosed("false");
    	RawStoreTimings rt3= new RawStoreTimings();
    	rt3.setOpeningTime("09:30");
    	rt3.setClosingTime("20:00");
    	rt3.setDayOfWeek("WEDNESDAY");
    	rt3.setClosed("false");
    	RawStoreTimings rt4= new RawStoreTimings();
    	rt4.setOpeningTime("09:30");
    	rt4.setClosingTime("20:00");
    	rt4.setDayOfWeek("THURSDAY");
    	rt4.setClosed("false");
    	RawStoreTimings rt5= new RawStoreTimings();
    	rt5.setOpeningTime("09:30");
    	rt5.setClosingTime("20:00");
    	rt5.setDayOfWeek("FRIDAY");
    	rt5.setClosed("false");
    	RawStoreTimings rt6= new RawStoreTimings();
    	rt6.setDayOfWeek("SATURDAY");
    	rt6.setClosed("false");
    	RawStoreTimings rt7= new RawStoreTimings();
    	rt7.setDayOfWeek("SUNDAY");
    	rt7.setClosed("false");
    	rawStoreTimings.add(rt1);
    	rawStoreTimings.add(rt2);
    	rawStoreTimings.add(rt3);
    	rawStoreTimings.add(rt4);
    	rawStoreTimings.add(rt5);
    	rawStoreTimings.add(rt6);
    	rawStoreTimings.add(rt7);
    	
    }
    
    public List <String> getCompactStoreTimings ()

    {
        return compactStoreTimings;
    }

    public void setCompactStoreTimings (List <String> compactStoreTimings)
    {
        this.compactStoreTimings = compactStoreTimings;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getShortAddress ()
    {
        return shortAddress;
    }

    public void setShortAddress (String shortAddress)
    {
        this.shortAddress = shortAddress;
    }

    public List <RawStoreTimings> getRawStoreTimings ()
    {
        return rawStoreTimings;
    }

    public void setRawStoreTimings (List <RawStoreTimings> rawStoreTimings)
    {
        this.rawStoreTimings = rawStoreTimings;
    }

    public StoreAddress getStoreAddress ()
    {
        return storeAddress;
    }

    public void setStoreAddress (StoreAddress storeAddress)
    {
        this.storeAddress = storeAddress;
    }

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [compactStoreTimings = "+compactStoreTimings+", title = "+title+", shortAddress = "+shortAddress+", rawStoreTimings = "+rawStoreTimings+", storeAddress = "+storeAddress+", code = "+code+"]";
    }
}
			
