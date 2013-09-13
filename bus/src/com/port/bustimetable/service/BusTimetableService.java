package com.port.bustimetable.service;

import java.util.List;
import com.port.bustimetable.model.ApplicationParameter;
import com.port.bustimetable.model.TimetableEntry;

public interface BusTimetableService {
	public List<TimetableEntry> getLocationList();
	public List<TimetableEntry> getLocationListUniDirection();
	public List<TimetableEntry> getLocationListLangstoneDirection();
	public TimetableEntry getTimetableWeek(int stopNumber);
	public TimetableEntry getTimetableWeekend(int stopNumber);
	public TimetableEntry getUniTimetableWeek(int stopNumber);
	public TimetableEntry getUniTimetableWeekend(int stopNumber);
	public TimetableEntry getLangstoneTimetableWeek(int stopNumber);
	public TimetableEntry getLangstoneTimetableWeekend(int stopNumber);
	public List<Integer> getBusStops();
	public ApplicationParameter getAdminAuth(String username);
	public ApplicationParameter getApplicationParameter(String parameter);	
	public ApplicationParameter updateApplicationParameter(ApplicationParameter applicationParameter);
}
