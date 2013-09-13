package com.port.bustimetable.model;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
@Entity
@Cache
@Index
public class BusStop {
	private String location;
	@Id private Long StopNumber;
	private boolean Boarding;
	private String times;
	private boolean weekend;
	private String direction;
	public BusStop(){}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Long getStopNumber() {
		return StopNumber;
	}
	public void setStopNumber(Long stopNumber) {
		StopNumber = stopNumber;
	}
	public boolean isBoarding() {
		return Boarding;
	}
	public void setBoarding(boolean boarding) {
		Boarding = boarding;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public boolean isWeekend() {
		return weekend;
	}
	public void setWeekend(boolean weekend) {
		this.weekend = weekend;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}	
}
