package com.hackerrank.java;

import java.text.SimpleDateFormat;
import java.text.DateFormatSymbols;
import java.util.*;

public class DatePlay{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();
        Date d=new Date(2015,8,5);
		DateFormatSymbols dfs = new DateFormatSymbols(Locale.ENGLISH);
		String weekdays[] = dfs.getWeekdays();
		for(int i=0;i<weekdays.length;i++){
			weekdays[i]=weekdays[i].toUpperCase();
			System.out.println(weekdays[i]);
		}
		Calendar cal=Calendar.getInstance();
		int daya=cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(weekdays[daya]);
	}
}