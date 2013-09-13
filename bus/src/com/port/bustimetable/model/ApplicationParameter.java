package com.port.bustimetable.model;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
@Entity
@Cache
public class ApplicationParameter {

	@Id private String parameterName;
	private String parameterValue;
	public ApplicationParameter(){}
	
	public ApplicationParameter(String name, String value){
		this.parameterName = name;
		this.parameterValue = value;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterValue() {
		return parameterValue;
	}

	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}
}