package com.MKBot.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MKBotDateUtil {
	
	public static Date getCurrentDate() throws ParseException {
		
		Date d1=new Date();
		
		DateFormat d=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		return d.parse(d.format(d1));
	}

}
