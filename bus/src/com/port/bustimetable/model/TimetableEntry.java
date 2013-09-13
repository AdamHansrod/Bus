package com.port.bustimetable.model;

public class TimetableEntry {
	private String Location;
	private String Weekend;
	private String Time;
	private String Boarding;
	private int stopNumber;
	private String Direction;

	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getWeekend() {
		return Weekend;
	}
	public boolean getWeekendBoolean(){
		if (Weekend.equals("Y")){
			return true;
		} else {
			return  false;
		}
	}
	public void setWeekend(String weekend) {
		Weekend = weekend;
	}
	public void setWeekend(boolean weekend) {
		if (weekend = true){
			Weekend = "Y";
		} else {
			Weekend = "N";
		}
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public int getStopNumber() {
		return stopNumber;
	}
	public void setStopNumber(int stopNumber) {
		this.stopNumber = stopNumber;
	}
	public String getBoarding() {
		return Boarding;
	}
	public boolean getBoardingBoolean(){
		if (Boarding.equals("Y")){
			return true;
		} else {
			return  false;
		}
	}
	public void setBoarding(String boarding) {
		Boarding = boarding;
	}
	public void setBoarding(boolean boarding) {
		if (boarding = true){
			Boarding = "Y";
		} else {
			Boarding = "N";
		}
	}
	public String getDirection() {
		return Direction;
	}
	public void setDirection(String direction) {
		Direction = direction;
	}
	
}
