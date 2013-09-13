package com.port.bustimetable.model;

import java.util.List;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
@Entity
@Cache
public class AdminDetails {

	@Id private String id;
	private List<String> adminEmails;
	public AdminDetails(){}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getAdminEmails() {
		return adminEmails;
	}
	public void setAdminEmails(List<String> adminEmails) {
		this.adminEmails = adminEmails;
	}

}