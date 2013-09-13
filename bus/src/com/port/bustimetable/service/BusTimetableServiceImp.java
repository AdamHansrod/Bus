package com.port.bustimetable.service;

import java.util.ArrayList;
import java.util.List;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.cmd.Query;
import com.port.bustimetable.model.AdminDetails;
import com.port.bustimetable.model.ApplicationParameter;
import com.port.bustimetable.model.BusStop;
import com.port.bustimetable.model.TimetableEntry;

public class BusTimetableServiceImp implements BusTimetableService {

	Objectify objectify = OfyService.ofy();

	public List<TimetableEntry> getLocationList() {
		List<BusStop> busStops = objectify.load().type(BusStop.class).filter("StopNumber >=", 1L).list();
		return refineLocationList(busStops);
	}
	public List<TimetableEntry> refineLocationList(List<BusStop> busStops){
		List<TimetableEntry> locations = new ArrayList<TimetableEntry>();
		for (BusStop busStop : busStops) {
			int busStopNumber = (int) busStop.getStopNumber().longValue();
			boolean weDontHaveThisStopInTheList = true;
			for (TimetableEntry location: locations){
				if (location.getStopNumber() == busStopNumber || location.getStopNumber() == (busStopNumber - 100)){//checking that weekend stops don't get added twice
					weDontHaveThisStopInTheList = false;		
				}
			}
			if (weDontHaveThisStopInTheList) {//check if we already have this one in the list
				TimetableEntry te = new TimetableEntry();
				te.setStopNumber((int) busStop.getStopNumber().longValue() );
				te.setLocation(busStop.getLocation());
				locations.add(te);
			}
		}	
		return locations;
	}
	public List<TimetableEntry> getLocationListUniDirection() {
		List<BusStop> busStops = objectify.load().type(BusStop.class).filter("StopNumber >=", 1L).filter("direction ==", "Cambridge Road").list();
		return refineLocationList(busStops);
	}

	public List<TimetableEntry> getLocationListLangstoneDirection() {
		List<BusStop> busStops = objectify.load().type(BusStop.class).filter("StopNumber >=", 1L).filter("direction ==", "Langstone").list();
		return refineLocationList(busStops);
	}

	public TimetableEntry getTimetableWeek(int stopNumber) {
		return getTimetableEntry(stopNumber,false);
	}

	public TimetableEntry getTimetableWeekend(int stopNumber) {
		return getTimetableEntry(100+stopNumber,true);
		//All weekend stops are at the normal id + 100, so here we alter that to return it properly on weekends
	}
	// boolean langstoneDirection
	public TimetableEntry getTimetableEntry(int stopNumber, boolean weekend){
		Long stopNumberL = new Long(stopNumber);
		Query<BusStop> q = objectify.load().type(BusStop.class).filter("StopNumber ==", stopNumberL);
		for (BusStop busStop: q){
			TimetableEntry te = new TimetableEntry();
			te.setBoarding(busStop.isBoarding());
			if (weekend){
				te.setStopNumber(stopNumber-100); //re-adjust it back so the stopnumber is returned the same as the weekday number
			}else{
				te.setStopNumber(stopNumber);
			}
			te.setTime(busStop.getTimes());
			te.setWeekend(weekend);
			te.setDirection(busStop.getDirection());
			te.setLocation(busStop.getLocation());
			return te;
		}
		return null; 
	}
	public void updateBusStop(TimetableEntry te){
		BusStop updatedBusStop = new BusStop();
		updatedBusStop.setTimes(te.getTime());	
		updatedBusStop.setLocation(te.getLocation());
		updatedBusStop.setBoarding(te.getBoardingBoolean());
		updatedBusStop.setStopNumber((long) te.getStopNumber());
		updatedBusStop.setDirection(te.getDirection());
		updatedBusStop.setWeekend(te.getWeekendBoolean());
		objectify.save().entities(updatedBusStop);
	}
	public TimetableEntry getUniTimetableWeek(int stopNumber) {
		//return getTimetableEntry(stopNumber,false,false);
		return null;
	}

	public TimetableEntry getUniTimetableWeekend(int stopNumber) {
		//return getTimetableEntry(stopNumber,true,false);
		return null;
	}

	public TimetableEntry getLangstoneTimetableWeek(int stopNumber) {
		//return getTimetableEntry(stopNumber,false,true);
		return null;
	}

	public TimetableEntry getLangstoneTimetableWeekend(int stopNumber) {
		//return getTimetableEntry(stopNumber,true,true);
		return null;
	}

	public List<Integer> getBusStops() {
		Query<BusStop> q = objectify.load().type(BusStop.class);//.filter("StopNumber >=", 1L);
		List<Integer> busStopNumbers = new ArrayList<Integer>();
		for (BusStop busStop : q) {
			int busStopNumber = (int) busStop.getStopNumber().longValue(); // casting the Long to long so we can then cast to int.
			if (!busStopNumbers.contains(busStopNumber)) { 				   // because primitive types stored in the datastore
				busStopNumbers.add(busStopNumber);
			}
		}
		return busStopNumbers;	
	}

	public ApplicationParameter getAdminAuth(String username) {
		UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();

        if (user != null) {
        	AdminDetails ad = objectify.load().type(AdminDetails.class).id("admin").now();
        	if (ad != null){
        		if (ad.getAdminEmails().contains(user.getEmail())){
        			return new ApplicationParameter("admin",username);        		
        		}
        	}        	
        }
        return null;

	}

	public ApplicationParameter getApplicationParameter(String parameter) {
		return objectify.load().type(ApplicationParameter.class).id(parameter).now();
	}

	public ApplicationParameter updateApplicationParameter(ApplicationParameter applicationParameter) {
		ApplicationParameter updatedAppParam = new ApplicationParameter(applicationParameter.getParameterName(),applicationParameter.getParameterValue());
		objectify.save().entities(updatedAppParam).now();
		return applicationParameter;
	}


}
