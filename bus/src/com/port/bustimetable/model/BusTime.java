package com.port.bustimetable.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BusTime {
	public long time;
	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		
	}
	public BusTime(String timeString) throws ParseException{
		DateFormat sdf = new SimpleDateFormat("HH:mm");
		Date date = sdf.parse(timeString);
		time = date.getTime();
		System.out.println("Time: " + sdf.format(date));
	}
	public int compareTo(BusTime otherBusTime){
		if (otherBusTime.time > time){//other BusTime is greater
			return 1;
		}else if (otherBusTime.time == time){
			return 0;
		}else if (otherBusTime.time < time){
			return -1;
		}
		return 0;
	}
}
