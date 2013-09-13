package com.port.bustimetable.service;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.port.bustimetable.model.AdminDetails;
import com.port.bustimetable.model.ApplicationParameter;
import com.port.bustimetable.model.BusStop;


public class OfyService {
	static {
		ObjectifyService.register(ApplicationParameter.class);
		ObjectifyService.register(AdminDetails.class);
		ObjectifyService.register(BusStop.class);
	}

	public static Objectify ofy() {
		return ObjectifyService.ofy();// prior to v.4.0 use .begin() ,
										// since v.4.0 use
										// ObjectifyService.ofy();
	}

	public static ObjectifyFactory factory() {
		return ObjectifyService.factory();
	}
}
