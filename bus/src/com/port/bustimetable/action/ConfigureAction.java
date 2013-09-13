package com.port.bustimetable.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.port.bustimetable.service.BusTimetableService;
import com.port.bustimetable.service.BusTimetableServiceImp;
import com.port.bustimetable.model.ApplicationParameter;

public class ConfigureAction extends ActionSupport implements SessionAware {

	private static final int VAL_LENGTH = 4000;
	private static final long serialVersionUID = 1L;
	private BusTimetableService busTimetableService =  new BusTimetableServiceImp();
	private Map<String, Object> session;
	private String status;
	private String status_text;
	private String mon_fri_link;
	private String weekend_link;
	private String information;
	private String uni_map;
	private String uni_map_link;
	private String lang_map;
	private String lang_map_link;
	
	public String execute() {
		status = busTimetableService.getApplicationParameter("status").getParameterValue();
		status_text = busTimetableService.getApplicationParameter("status_text").getParameterValue();
		mon_fri_link = busTimetableService.getApplicationParameter("mon_fri_link").getParameterValue();
		weekend_link = busTimetableService.getApplicationParameter("weekend_link").getParameterValue();
		information = busTimetableService.getApplicationParameter("information").getParameterValue();
		uni_map = busTimetableService.getApplicationParameter("uni_map").getParameterValue();
		uni_map_link = busTimetableService.getApplicationParameter("uni_map_link").getParameterValue();
		lang_map = busTimetableService.getApplicationParameter("lang_map").getParameterValue();
		lang_map_link = busTimetableService.getApplicationParameter("lang_map_link").getParameterValue();
		return SUCCESS;
	}
	
	public String saveConfig() {
		if(information.length() > VAL_LENGTH){ //|| following_should_be_noted.length() > VAL_LENGTH){
			addActionError(getText("configure.length.content"));
			return INPUT;
		}
		setParameter("status",status);
		setParameter("status_text",status_text);		
		setParameter("mon_fri_link",mon_fri_link);
		setParameter("weekend_link",weekend_link);
		setParameter("information",information);
		setParameter("uni_map",uni_map);
		setParameter("uni_map_link",uni_map_link);
		setParameter("lang_map",lang_map);
		setParameter("lang_map_link",lang_map_link);
		return SUCCESS;
	}
	private ApplicationParameter setParameter(String paramName, String paramValue) {
		ApplicationParameter applicationParameter = new ApplicationParameter();
		applicationParameter.setParameterName(paramName);
		applicationParameter.setParameterValue(paramValue);
		busTimetableService.updateApplicationParameter(applicationParameter);
		return applicationParameter;
	}

	public BusTimetableService getBusTimetableService() {
		return busTimetableService;
	}

	public void setBusTimetableService(BusTimetableService busTimetableService) {
		this.busTimetableService = busTimetableService;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus_text() {
		return status_text;
	}

	public void setStatus_text(String status_text) {
		this.status_text = status_text;
	}
	
}