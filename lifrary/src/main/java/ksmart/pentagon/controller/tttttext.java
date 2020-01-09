package ksmart.pentagon.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class tttttext {

	public static void main(String[] args) {
		 Calendar cal = Calendar.getInstance();
	        cal.setTime(new Date());
	        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	        System.out.println("current: " + df.format(cal.getTime()));

	        cal.add(Calendar.MONTH, -1);
	        System.out.println("after: " + df.format(cal.getTime()));
	}

}
