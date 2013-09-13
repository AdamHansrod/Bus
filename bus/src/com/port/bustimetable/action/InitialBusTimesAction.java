package com.port.bustimetable.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.joda.time.LocalTime;

import com.googlecode.objectify.Objectify;
import com.opensymphony.xwork2.ActionSupport;
import com.port.bustimetable.model.ApplicationParameter;
import com.port.bustimetable.model.BusStop;
import com.port.bustimetable.service.OfyService;

@SuppressWarnings("serial")
public class InitialBusTimesAction extends ActionSupport {
	private String cambridgeTimeString = "08:00,08:20,08:40,09:00,09:20,09:40,10:00,10:20,10:40,11:00,11:20,11:40,12:00,12:20,12:40,13:00,13:20,13:40,14:20,14:40,15:00,15:20,15:40,16:00,16:20,16:40,17:00,17:20,17:40,18:00,18:20,18:40,19:00,19:20,21:00,21:40,22:20,23:00,00:10";
	private String winstonChurchillTimeString = "08:05,08:25,08:45,09:05,09:25,09:45,10:05,10:25,10:45,11:05,11:25,11:45,12:05,12:25,12:45,13:05,13:25,13:45,14:25,14:45,15:05,15:25,15:45,16:05,16:25,16:45,17:05,17:25,17:45,18:05,18:25,18:45,19:05,19:25,21:05,21:45,22:25,23:05,00:13";
	private String frattonLangTimeString = "08:08,08:28,08:48,09:08,09:28,09:48,10:08,10:28,10:48,11:08,11:28,11:48,12:08,12:28,12:48,13:08,13:28,13:48,14:28,14:48,15:08,15:28,15:48,16:08,16:28,16:48,17:08,17:28,17:48,18:08,18:28,18:48,19:08,19:28,21:08,21:48,22:28,23:08,00:15";
	private String lidlLangTimeString = "08:10,08:30,08:50,09:10,09:30,09:50,10:10,10:30,10:50,11:10,11:30,11:50,12:10,12:30,12:50,13:10,13:30,13:50,14:30,14:50,15:10,15:30,15:50,16:10,16:30,16:50,17:10,17:30,17:50,8:10,18:30,18:50,19:10,19:30,21:10,21:50,22:30,23:10,00:17";
	private String miltonTimeString = "08:14,08:34,08:54,09:14,09:34,09:54,10:14,10:34,10:54,11:14,11:34,11:54,12:14,12:34,12:54,13:14,13:34,13:54,14:34,14:54,15:14,15:34,15:54,16:14,16:34,16:54,17:14,17:34,17:54,18:14,18:34,18:54,19:14,19:34,21:14,21:54,22:34,23:14,00:20";
	
	private String langstoneTimeString = "07:40,08:00,08:20,08:40,09:00,09:20,09:40,10:00,10:20,10:40,11:00,11:20,11:40,12:00,12:20,12:40,13:00,13:20,14:00,14:20,14:40,15:00,15:20,15:40,16:00,16:20,16:40,17:00,17:20,17:40,18:00,18:20,18:40,19:00,20:40,21:20,22:00,22:40";
	private String lockswayTimeString = "07:43,08:03,08:23,08:43,09:03,09:23,09:43,10:03,10:23,10:43,11:03,11:23,11:43,12:03,12:23,12:43,13:03,13:23,14:03,14:23,14:43,15:03,15:23,15:43,16:03,16:23,16:43,17:03,17:23,17:43,18:03,18:23,18:43,19:03,20:43,21:23,22:03,22:43";
	private String lidlUniTimeString = "07:47,08:07,08:27,08:47,09:07,09:27,09:47,10:07,10:27,10:47,11:07,11:27,11:47,12:07,12:27,12:47,13:07,13:27,14:07,14:27,14:47,15:07,15:27,15:47,16:07,16:27,16:47,17:07,17:27,17:47,18:07,18:27,18:47,19:07,20:47,21:27,22:07,22:47";
	private String frattonUniTimeString = "07:49,08:09,08:29,08:49,09:09,09:29,09:49,10:09,10:29,10:49,11:09,11:29,11:49,12:09,12:29,12:49,13:09,13:29,14:09,14:29,14:49,15:09,15:29,15:49,16:09,16:29,16:49,17:09,17:29,17:49,18:09,18:29,18:49,19:09,20:49,21:29,22:09,22:49";

	private String cambridgeTimeWeekendString = "10:20,11:00,11:40,12:20,13:40,14:20,15:00,15:40,16:40,17:20,18:00";
	private String winstonChurchillTimeWeekendString = "10:25,11:05,11:45,12:25,13:45,14:25,15:05,15:45,16:45,17:25,18:05";
	private String frattonLangTimeWeekendString = "10:28,11:08,11:48,12:28,13:48,14:28,15:08,15:48,16:48,17:28,18:08";
	private String lidlLangTimeWeekendString = "10:30,11:10,11:50,12:30,13:50,14:30,15:10,15:50,16:50,17:30,18:10";
	private String miltonTimeWeekendString = "10:33,11:13,11:53,12:33,13:53,14:33,15:13,15:53,16:53,17:33,18:13";
	
	private String langstoneTimeWeekendString = "10:00,10:40,11:20,12:00,13:20,14:00,14:40,15:20,16:20,17:00,17:40,";
	private String lockswayTimeWeekendString = "10:04,10:44,11:24,12:04,13:24,14:04,14:44,15:24,16:24,17:04,17:44";
	private String lidlUniTimeWeekendString = "10:08,10:48,11:28,12:08,13:28,14:08,14:48,15:28,16:28,17:08,17:48";
	private String frattonUniTimeWeekendString = "10:10,10:50,11:30,12:10,13:30,14:10,14:50,15:30,16:30,17:10,17:50";
	
	Objectify objectify = OfyService.ofy();
	public String execute(){
/*		DatastoreService datastore = 
                DatastoreServiceFactory.getDatastoreService();
																	//UNCOMMENT IF YOU WANT THE ENTIRE DATASTORE TO BURN.
Query mydeleteq = new Query();
PreparedQuery pq = datastore.prepare(mydeleteq);
for (Entity result : pq.asIterable()) {
	try{
    datastore.delete(result.getKey());      
	}catch (Exception e)[]
}  */ 
		ApplicationParameter status = new ApplicationParameter("status","tick.png");
		ApplicationParameter status_text = new ApplicationParameter("status_text","Service Available");
		ApplicationParameter mon_fri_link = new ApplicationParameter("mon_fri_link","http://www.port.ac.uk/lookup/generalinformation/gettingaround/bus/filetodownload,103195,en.pdf");
		ApplicationParameter weekend_link = new ApplicationParameter("weekend_link","http://www.port.ac.uk/lookup/generalinformation/gettingaround/bus/filetodownload,122139,en.pdf");
		ApplicationParameter uni_map = new ApplicationParameter("uni_map", "http://maps.googleapis.com/maps/api/staticmap?center=50.794543,-1.097034&zoom=15&markers=color:blue%7Clabel:A%7C50.794543,-1.097034&size=400x400&sensor=false&scale=2");
		ApplicationParameter uni_map_link = new ApplicationParameter("uni_map_link", "https://maps.google.com/maps?t=h&q=loc:50.794543,-1.097034&z=17");
		ApplicationParameter lang_map = new ApplicationParameter("lang_map", "http://maps.googleapis.com/maps/api/staticmap?center=50.796150,-1.041874&zoom=15&markers=color:blue%7Clabel:B%7C50.796150,-1.041874&size=400x400&sensor=false&scale=2");
		ApplicationParameter lang_map_link = new ApplicationParameter("lang_map_link", "https://maps.google.com/maps?t=h&q=loc:50.796150,-1.041874&z=17");
		ApplicationParameter information = new ApplicationParameter("information","<p>The inter-site bus service is provided to help both students and staff to travel between Langstone and the Guildhall Campus. "+
        		"Seats are available on a first-come, first-served basis. The seating capacity of the buses cannot be exceeded.</p>"+
        		"<p>No member of staff or student may bring alcohol on the buses.</p>"+
        		"<p>There is a weekly service from Monday to Friday and a weekend service, both available during term-time only. You can download the full timetables above.</p>"+"" +
        		"<p>If you would like to leave feedback on the inter-site bus service then please use the form "+"" +
        		"<a href=\"http://www.port.ac.uk/lookup/generalinformation/gettingaround/bus/\">here</a>."+
        		"<h3>The following should be noted:</h3>"+
				"<p class=\"bold\">THE DRIVER RESERVES THE RIGHT TO REFUSE TRAVEL TO ANYONE</p>"+
				"<p class=\"bold\">CAMBRIDGE ROAD (STUDENT CENTRE) IS A DROP-OFF POINT ONLY - NO BOARDING PERMITTED AT THIS STOP</p>"+
				"<p>The timetable will be adhered to except in the event of traffic congestion or breakdown.</p>"+
				"<p>The Bus service is available to all members of staff, students and accompanied dependants only. </p>"+
				"<p>For your safety and comfort, the following rules must be adhered to:</p>"+
				"<ol>"+
				"<li>Identity / NUS cards MUST be shown to the driver upon boarding University buses.</li>"+
				"<li>Do not talk to or distract the driver whilst the vehicle is in motion.</li>"+
				"<li>There is a NO SMOKING policy on all University buses.</li>"+
				"<li>No eating or drinking on the buses.</li>"+
				"<li>Please do not ask the driver to make any unscheduled stops.</li>"+
				"</ol></p>");

		objectify.save().entities(status,status_text,mon_fri_link,weekend_link,uni_map,uni_map_link,lang_map,lang_map_link,information);

		CreateWeekBusStops();
		CreateWeekendBusStops();	
		return SUCCESS;
	}

	public void CreateWeekBusStops(){
		BusStop CambridgeRoad = new BusStop();
		convertTimeString(cambridgeTimeString);
		CambridgeRoad.setTimes(cambridgeTimeString);
		CambridgeRoad.setLocation("Cambridge Rd (Nuffield)");
		CambridgeRoad.setBoarding(true);
		CambridgeRoad.setStopNumber(7L);
		CambridgeRoad.setDirection("Langstone");
		CambridgeRoad.setWeekend(false);
		
		
		BusStop WinstonChurchill = new BusStop();
		convertTimeString(winstonChurchillTimeString);
		WinstonChurchill.setTimes(winstonChurchillTimeString);	
		WinstonChurchill.setLocation("Winston Churchill Ave (Law Courts)");
		WinstonChurchill.setBoarding(true);
		WinstonChurchill.setStopNumber(8L);
		WinstonChurchill.setDirection("Langstone");
		WinstonChurchill.setWeekend(false);
		
		BusStop Fratton = new BusStop();
		convertTimeString(frattonLangTimeString);
		Fratton.setTimes(frattonLangTimeString);	
		Fratton.setLocation("Fratton Railway Stn");
		Fratton.setBoarding(true);
		Fratton.setStopNumber(9L);
		Fratton.setDirection("Langstone");
		Fratton.setWeekend(false);
		
		BusStop LidlLang = new BusStop();
		convertTimeString(lidlLangTimeString);
		LidlLang.setTimes(lidlLangTimeString);	
		LidlLang.setLocation("Goldsmith Ave (Lidl)");
		LidlLang.setBoarding(true);
		LidlLang.setDirection("Langstone");
		LidlLang.setWeekend(false);
		LidlLang.setStopNumber(10L);
		
		BusStop WhiteHouse = new BusStop();
		convertTimeString(miltonTimeString);
		WhiteHouse.setTimes(miltonTimeString);	
		WhiteHouse.setLocation("Goldsmith Ave (Milton Park)");
		WhiteHouse.setBoarding(true);
		WhiteHouse.setStopNumber(11L);
		WhiteHouse.setDirection("Langstone");
		WhiteHouse.setWeekend(false);
		
		BusStop Langstone = new BusStop();
		convertTimeString(langstoneTimeString);
		Langstone.setTimes(langstoneTimeString);	
		Langstone.setLocation("Langstone Campus");
		Langstone.setBoarding(true);
		Langstone.setStopNumber(1L);	
		Langstone.setDirection("Cambridge Road");
		Langstone.setWeekend(false);
		
		BusStop Locksway = new BusStop();
		convertTimeString(lockswayTimeString);
		Locksway.setTimes(lockswayTimeString);	
		Locksway.setLocation("Locksway Rd (Milton)");
		Locksway.setBoarding(true);
		Locksway.setStopNumber(2L);
		Locksway.setDirection("Cambridge Road");
		Locksway.setWeekend(false);
		
		BusStop LidlUni = new BusStop();
		convertTimeString(lidlUniTimeString);
		LidlUni.setTimes(lidlUniTimeString);	
		LidlUni.setLocation("Goldsmith Ave (Lidl)");
		LidlUni.setBoarding(true);
		LidlUni.setStopNumber(3L);
		LidlUni.setDirection("Cambridge Road");
		LidlUni.setWeekend(false);
		
		BusStop FrattonUni = new BusStop();
		convertTimeString(frattonUniTimeString);
		FrattonUni.setTimes(frattonUniTimeString);	
		FrattonUni.setLocation("Fratton Railway Stn");
		FrattonUni.setBoarding(true);
		FrattonUni.setStopNumber(4L);
		FrattonUni.setDirection("Cambridge Road");
		FrattonUni.setWeekend(false);
		
		objectify.save().entities(CambridgeRoad,WinstonChurchill,Fratton,LidlLang,WhiteHouse,Langstone,Locksway,LidlUni,FrattonUni);
	}
		
	public void CreateWeekendBusStops(){
		BusStop CambridgeRoadWeekend = new BusStop();
		convertTimeString(cambridgeTimeWeekendString);
		CambridgeRoadWeekend.setTimes(cambridgeTimeWeekendString);	
		CambridgeRoadWeekend.setLocation("Cambridge Rd (Nuffield)");
		CambridgeRoadWeekend.setBoarding(true);
		CambridgeRoadWeekend.setStopNumber(107L);
		CambridgeRoadWeekend.setDirection("Langstone");
		CambridgeRoadWeekend.setWeekend(true);
				
		BusStop WinstonChurchillWeekend = new BusStop();
		convertTimeString(winstonChurchillTimeWeekendString);
		WinstonChurchillWeekend.setTimes(winstonChurchillTimeWeekendString);	
		WinstonChurchillWeekend.setLocation("Winston Churchill Ave (Law Courts)");
		WinstonChurchillWeekend.setBoarding(true);
		WinstonChurchillWeekend.setStopNumber(108L);
		WinstonChurchillWeekend.setDirection("Langstone");
		WinstonChurchillWeekend.setWeekend(true);
		
		 BusStop FrattonWeekend = new BusStop();
		convertTimeString(frattonLangTimeWeekendString);
		FrattonWeekend.setTimes(frattonLangTimeWeekendString);	
		FrattonWeekend.setLocation("Fratton Railway Stn");
		FrattonWeekend.setBoarding(true);
		FrattonWeekend.setStopNumber(109L);
		FrattonWeekend.setDirection("Langstone");
		FrattonWeekend.setWeekend(true);
		
				
		BusStop LidlLangWeekend = new  BusStop();
		convertTimeString(lidlLangTimeWeekendString);
		LidlLangWeekend.setTimes(lidlLangTimeWeekendString);	
		LidlLangWeekend.setLocation("Goldsmith Ave (Lidl)");
		LidlLangWeekend.setBoarding(true);
		LidlLangWeekend.setStopNumber(110L);	
		LidlLangWeekend.setDirection("Langstone");
		LidlLangWeekend.setWeekend(true);
		
		BusStop WhiteHouseWeekend = new BusStop();
		convertTimeString(miltonTimeWeekendString);
		WhiteHouseWeekend.setTimes(miltonTimeWeekendString);	
		WhiteHouseWeekend.setLocation("Goldsmith Ave (Milton Park)");
		WhiteHouseWeekend.setBoarding(true);
		WhiteHouseWeekend.setStopNumber(111L);
		WhiteHouseWeekend.setDirection("Langstone");
		WhiteHouseWeekend.setWeekend(true);
		
		BusStop LangstoneWeekend = new BusStop();
		convertTimeString(langstoneTimeWeekendString);
		LangstoneWeekend.setTimes(langstoneTimeWeekendString);	
		LangstoneWeekend.setLocation("Langstone Campus");
		LangstoneWeekend.setBoarding(true);
		LangstoneWeekend.setStopNumber(101L);	
		LangstoneWeekend.setDirection("Cambridge Road");
		LangstoneWeekend.setWeekend(true);
				
		BusStop LockswayWeekend = new BusStop();
		convertTimeString(lockswayTimeWeekendString);
		LockswayWeekend.setTimes(lockswayTimeWeekendString);	
		LockswayWeekend.setLocation("Locksway Rd (Milton)");
		LockswayWeekend.setBoarding(true);
		LockswayWeekend.setStopNumber(102L);
		LockswayWeekend.setDirection("Cambridge Road");
		LockswayWeekend.setWeekend(true);
				
		BusStop LidlUniWeekend = new BusStop();
		convertTimeString(lidlUniTimeWeekendString);
		LidlUniWeekend.setTimes(lidlUniTimeWeekendString);	
		LidlUniWeekend.setLocation("Goldsmith Ave (Lidl)");
		LidlUniWeekend.setBoarding(true);
		LidlUniWeekend.setStopNumber(103L);
		LidlUniWeekend.setDirection("Cambridge Road");
		LidlUniWeekend.setWeekend(true);
				
		BusStop FrattonWeekendUni = new BusStop();
		convertTimeString(frattonUniTimeWeekendString);
		FrattonWeekendUni.setTimes(frattonUniTimeWeekendString);	
		FrattonWeekendUni.setLocation("Fratton Railway Stn");
		FrattonWeekendUni.setBoarding(true);
		FrattonWeekendUni.setStopNumber(104L);
		FrattonWeekendUni.setDirection("Cambridge Road");
		FrattonWeekendUni.setWeekend(true);
		
		objectify.save().entities(CambridgeRoadWeekend,WinstonChurchillWeekend,FrattonWeekend,LidlLangWeekend,WhiteHouseWeekend,LangstoneWeekend,LockswayWeekend,LidlUniWeekend,FrattonWeekendUni);
	}
	public List<LocalTime> convertTimeString(String times){		List<String> timetable = new ArrayList<String>(Arrays.asList(times.split(",")));	
	List<LocalTime> localTimes = new ArrayList<LocalTime>();
	for (String time: timetable){
		List<String> individualTimes = new ArrayList<String>(Arrays.asList(time.split(":")));
		int hour = Integer.parseInt(individualTimes.get(0));
		int minute = Integer.parseInt(individualTimes.get(1));			
		LocalTime lt = new LocalTime(hour,minute);
		localTimes.add(lt);
	}
	return localTimes;
}


}
