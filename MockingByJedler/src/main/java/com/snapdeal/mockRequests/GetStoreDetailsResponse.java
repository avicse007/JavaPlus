package com.snapdeal.mockRequests;

public class GetStoreDetailsResponse
{
    private String status;

    private Data data;
    
    public GetStoreDetailsResponse(String supc)
    {
    	this.status="success";
    	data= new Data(supc);
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public Data getData ()
    {
        return data;
    }

    public void setData (Data data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [status = "+status+", data = "+data+"]";
    }
}
			
			
