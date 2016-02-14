package com.snapdeal.apis;

import java.util.Date;

public class MyDateClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d=new Date();
		long date=1438154002154L;
		Date d2=new Date(date);
		System.out.println(d.getTime());
		System.out.println(d2);
	}

}
