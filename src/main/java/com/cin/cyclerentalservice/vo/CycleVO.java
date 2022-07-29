package com.cin.cyclerentalservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CycleVO {

	private Integer cycleId;
	private String cycleBrandName;
	private String statusCode;
	
	public CycleVO() {
		
	}

	public Integer getCycleId() {
		return cycleId;
	}

	public void setCycleId(Integer cycleId) {
		this.cycleId = cycleId;
	}

	public String getCycleBrandName() {
		return cycleBrandName;
	}

	public void setCycleBrandName(String cycleBrandName) {
		this.cycleBrandName = cycleBrandName;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
}
