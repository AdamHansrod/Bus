package com.port.bustimetable.action;

import java.io.ByteArrayInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.port.bustimetable.model.TimetableEntry;
import com.port.bustimetable.service.BusTimetableService;
import com.port.bustimetable.service.BusTimetableServiceImp;

@SuppressWarnings("serial")
public class GetTimetableAction extends ActionSupport {
	private BusTimetableService busTimetableService =  new BusTimetableServiceImp();
	private TimetableEntry timetableEntry;
	private int StopNumber;
	private List<String> futureTimes;
	private ByteArrayInputStream inputStream;
	
	public void validate(){
		List<Integer> busStops = busTimetableService.getBusStops();
		if (busStops != null && !busStops.contains(StopNumber)){
			addActionError("That bus stop doesn't exist.\n\rWhat are you, some sort of computer genius trying to play around with this site? ");			
		}
	}
	public String execute() {
		Locale locale = new Locale.Builder().setLanguage("en").setRegion("GB").build();
		Calendar cal = Calendar.getInstance(locale);
		
		timetableEntry = getTimetableEntry(cal);
		TimetableEntry additionalTimetableEntry = null;
		
		List<String> timetable = new ArrayList<String>(Arrays.asList(timetableEntry.getTime().split(",")));
		List<String> additionalTimetable = null;
		
		String currentTime = getCurrentStringTime(cal);
		int dayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);		
		int hour = Integer.valueOf((String) currentTime.subSequence(0, 2));
		
		futureTimes = new ArrayList<String>();		
		
		if(dayOfTheWeek == Calendar.FRIDAY || dayOfTheWeek == Calendar.SUNDAY) {
			cal.add(Calendar.DAY_OF_MONTH, 1);
			additionalTimetableEntry = getTimetableEntry(cal);
			additionalTimetable = new ArrayList<String>(Arrays.asList(additionalTimetableEntry.getTime().split(",")));
		}

		for(int i = 0; i < timetable.size();i++){
			String time = timetable.get(i);
			int busHour = Integer.valueOf((String) time.subSequence(0, 2));
			int busMin = Integer.valueOf((String) time.subSequence(3, 5));			
			if (hour < busHour){
				return spliceTimetablesToProduce24Hours(timetable,additionalTimetable,i,dayOfTheWeek);	
			} else if (hour == busHour){//same hour
				//only do the extra working out of minutes if were inside the hour
				int min = Integer.valueOf((String) currentTime.subSequence(3, 5));				
				if (min <= busMin){// if before the minute on the timetable		
					return spliceTimetablesToProduce24Hours(timetable,additionalTimetable,i,dayOfTheWeek);					
				}
			}
		}
		//should hit if after the last bus of the day(e.g. past midnight)
		if(additionalTimetableEntry == null) {
			futureTimes = timetable;
		}
		else {
			futureTimes = additionalTimetable;
		}
		return produceJSON();
	}
	private TimetableEntry getTimetableEntry(Calendar cal){
		int day = cal.get(Calendar.DAY_OF_WEEK);
		if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
			return  busTimetableService.getTimetableWeekend(StopNumber);
		} else if (StopNumber == 0) {
			TimetableEntry te = new TimetableEntry();
			te.setTime("");
			return te;
		}else{
			return busTimetableService.getTimetableWeek(StopNumber);
		}
	}
	private String spliceTimetablesToProduce24Hours(List<String> timetable,List<String> additionalTimetable,int i, int dayOfTheWeek){
		futureTimes = timetable.subList(i, timetable.size());//get the rest of the timetable for the day
		//Based on whether its the friday or sunday, 
		//then either add the start of the timetable up to that time onto the end of the list 
		//OR add the other (week/weekend) timetable so we can always produce the 24 hours of timetable in json 
		if(dayOfTheWeek == Calendar.FRIDAY || dayOfTheWeek == Calendar.SUNDAY) {
			futureTimes.addAll(additionalTimetable);
		} else {
			futureTimes.addAll(timetable.subList(0,i));
		}
		return produceJSON();	
	}
	private String produceJSON(){
		String json = new Gson().toJson(futureTimes);//USED WHEN THE JSON IS NEEDED
		inputStream = new ByteArrayInputStream(json.getBytes());//USED WHEN THE JSON IS NEEDED
		return "success";
	}
	public List<String> getFutureTimes() {
		return futureTimes;
	}
	public void setFutureTimes(List<String> futureTimes) {
		this.futureTimes = futureTimes;
	}

	private String getCurrentStringTime(Calendar cal){
		TimeZone tz = TimeZone.getTimeZone("Europe/London");
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		dateFormat.setTimeZone(tz);
		int dst = 0;
		if((TimeZone.getDefault()).observesDaylightTime()){
			dst = 3600000;
		}
		Date d = new Date();
		d.setTime(cal.getTimeInMillis() + dst);
		return dateFormat.format(d);
	}
	public String getTimesForStop(int StopNumber) {
		this.StopNumber = StopNumber;
		execute();
		return "<p class='smallTimes'> Next 4 times: <br><br> "+futureTimes.get(0)+", "+futureTimes.get(1)+", "+futureTimes.get(2)+", "+futureTimes.get(3)+". </p>";
	}
	public int getStopNumber() {
		return StopNumber;
	}
	
	public void setStopNumber(int stopNumber) {
		StopNumber = stopNumber;
	}

	public BusTimetableService getBusTimetableService() {
		return busTimetableService;
	}

	public void setBusTimetableService(BusTimetableService busTimetableService) {
		this.busTimetableService = busTimetableService;
	}

	public void setDirection(String direction) {
	}
	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}
	
}
