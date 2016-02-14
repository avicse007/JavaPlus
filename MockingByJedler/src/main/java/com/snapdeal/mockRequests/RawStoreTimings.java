package com.snapdeal.mockRequests;

public class RawStoreTimings
{
    private String closingTime;

    private String closed;

    private String openingTime;

    private String dayOfWeek;
    

    public String getClosingTime ()
    {
        return closingTime;
    }

    public void setClosingTime (String closingTime)
    {
        this.closingTime = closingTime;
    }

    public String getClosed ()
    {
        return closed;
    }

    public void setClosed (String closed)
    {
        this.closed = closed;
    }

    public String getOpeningTime ()
    {
        return openingTime;
    }

    public void setOpeningTime (String openingTime)
    {
        this.openingTime = openingTime;
    }

    public String getDayOfWeek ()
    {
        return dayOfWeek;
    }

    public void setDayOfWeek (String dayOfWeek)
    {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [closingTime = "+closingTime+", closed = "+closed+", openingTime = "+openingTime+", dayOfWeek = "+dayOfWeek+"]";
    }
}
			
			
