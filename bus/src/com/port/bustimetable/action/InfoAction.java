package com.port.bustimetable.action;

import com.googlecode.objectify.Objectify;
import com.opensymphony.xwork2.ActionSupport;
import com.port.bustimetable.model.ApplicationParameter;
import com.port.bustimetable.service.OfyService;

@SuppressWarnings("serial")
public class InfoAction extends ActionSupport {
	private String information;
	private String status;
	private String status_text;
	private String mon_fri_link;
	private String weekend_link;
	Objectify objectify = OfyService.ofy();

	public String execute() {
		information = objectify.load().type(ApplicationParameter.class).id("information").now().getParameterValue();
		status = objectify.load().type(ApplicationParameter.class).id("status").now().getParameterValue();
		status_text = objectify.load().type(ApplicationParameter.class).id("status_text").now().getParameterValue();
		mon_fri_link = objectify.load().type(ApplicationParameter.class).id("mon_fri_link").now().getParameterValue();
		weekend_link = objectify.load().type(ApplicationParameter.class).id("weekend_link").now().getParameterValue();
		information = objectify.load().type(ApplicationParameter.class).id("information").now().getParameterValue();

		return SUCCESS;
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
	
}
