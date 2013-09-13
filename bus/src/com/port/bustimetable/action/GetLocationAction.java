package com.port.bustimetable.action;


import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.port.bustimetable.model.TimetableEntry;
import com.port.bustimetable.service.BusTimetableService;
import com.port.bustimetable.service.BusTimetableServiceImp;

@SuppressWarnings("serial")
public class GetLocationAction extends ActionSupport {
	private BusTimetableService busTimetableService =  new BusTimetableServiceImp();
	private List<String> locationList;
	private List<TimetableEntry> locationListUni;
	private List<TimetableEntry> locationListLangstone;
	private String status;
	private String status_text;
	private String mon_fri_link;
	private String weekend_link;
	private String information;
	private String following_should_be_noted;
	private String uni_map;
	private String uni_map_link;
	private String lang_map;
	private String lang_map_link;
	
	//these two strings are only used for basic functionality
	private String uniTimes;
	private String langTimes;
	
	
	public String execute() {
		try {
		//locationList = busTimetableService.getLocationList();
		locationListUni = busTimetableService.getLocationListUniDirection();
		TimetableEntry te = new TimetableEntry();
		te.setBoarding(false);
		te.setLocation("Please select a stop");
		te.setStopNumber(0);
		locationListUni.add(0, te);
		locationListUni.remove(1);
		
		locationListLangstone = busTimetableService.getLocationListLangstoneDirection();
		TimetableEntry te2 = new TimetableEntry();		
		te2.setBoarding(false);
		te2.setLocation("Please select a stop");
		te2.setStopNumber(0);
		locationListLangstone.add(0, te2);
		locationListLangstone.remove(1);
		
		status = busTimetableService.getApplicationParameter("status").getParameterValue();
		status_text = busTimetableService.getApplicationParameter("status_text").getParameterValue();
		mon_fri_link = busTimetableService.getApplicationParameter("mon_fri_link").getParameterValue();
		weekend_link = busTimetableService.getApplicationParameter("weekend_link").getParameterValue();
		information = busTimetableService.getApplicationParameter("information").getParameterValue();
		//following_should_be_noted = busTimetableService.getApplicationParameter("following_should_be_noted").getParameterValue();
		uni_map = busTimetableService.getApplicationParameter("uni_map").getParameterValue();
		uni_map_link = busTimetableService.getApplicationParameter("uni_map_link").getParameterValue();
		lang_map = busTimetableService.getApplicationParameter("lang_map").getParameterValue();
		lang_map_link = busTimetableService.getApplicationParameter("lang_map_link").getParameterValue();
		} catch (NullPointerException e){
			
		}
		getBasicTimes();
		return SUCCESS;
	}

	private void getBasicTimes() {
		try {
			GetTimetableAction gta = new GetTimetableAction();			
			uniTimes = gta.getTimesForStop(1);
			langTimes = gta.getTimesForStop(7);
		} catch (NullPointerException e){
			
		}
	}
	public BusTimetableService getBusTimetableService() {
		return busTimetableService;
	}

	public void setBusTimetableService(BusTimetableService busTimetableService) {
		this.busTimetableService = busTimetableService;
	}

	public List<String> getLocationList() {
		return locationList;
	}


	public List<TimetableEntry> getLocationListUni() {
		return locationListUni;
	}

	public List<TimetableEntry> getLocationListLangstone() {
		return locationListLangstone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMon_fri_link() {
		return mon_fri_link;
	}

	public void setMon_fri_link(String mon_fri_link) {
		this.mon_fri_link = mon_fri_link;
	}

	public String getWeekend_link() {
		return weekend_link;
	}

	public void setWeekend_link(String weekend_link) {
		this.weekend_link = weekend_link;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getFollowing_should_be_noted() {
		return following_should_be_noted;
	}

	public void setFollowing_should_be_noted(String following_should_be_noted) {
		this.following_should_be_noted = following_should_be_noted;
	}

	public String getUni_map() {
		return uni_map;
	}

	public void setUni_map(String uni_map) {
		this.uni_map = uni_map;
	}

	public String getUni_map_link() {
		return uni_map_link;
	}

	public void setUni_map_link(String uni_map_link) {
		this.uni_map_link = uni_map_link;
	}

	public String getLang_map() {
		return lang_map;
	}

	public void setLang_map(String lang_map) {
		this.lang_map = lang_map;
	}

	public String getLang_map_link() {
		return lang_map_link;
	}

	public void setLang_map_link(String lang_map_link) {
		this.lang_map_link = lang_map_link;
	}

	public void setLocationList(List<String> locationList) {
		this.locationList = locationList;
	}

	public void setLocationListUni(List<TimetableEntry> locationListUni) {
		this.locationListUni = locationListUni;
	}

	public void setLocationListLangstone(List<TimetableEntry> locationListLangstone) {
		this.locationListLangstone = locationListLangstone;
	}

	public String getStatus_text() {
		return status_text;
	}

	public void setStatus_text(String status_text) {
		this.status_text = status_text;
	}

	public String getUniTimes() {
		return uniTimes;
	}

	public void setUniTimes(String uniTimes) {
		this.uniTimes = uniTimes;
	}

	public String getLangTimes() {
		return langTimes;
	}

	public void setLangTimes(String langTimes) {
		this.langTimes = langTimes;
	}
	
}
