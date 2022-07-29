package com.cin.cyclerentalservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "RIDE")
@NamedQueries({
	@NamedQuery(name = "findAll.ride", query = "select r from Ride as r where status_cd = 'ACTIVE'")
})
public class Ride {

	@Id
	@Column(name = "RIDE_ID")
	private int rideId;
	
	@Column(name = "CYCLE_ID")
	private int cycleId;
	
	@Column(name = "CUSTOMER_ID")
	private int customerId;
	
	@Column(name = "STATUS_CD")
	private String statusCode;
	
	@Column(name = "START_TIME")
	private Date startTime;
	
	@Column(name = "END_TIME")
	private Date endTime;
	
	@Column(name = "DISTANCE_TRAVELLED")
	private int distanceTravelled;
	
	public Ride() {
	
	}

	public int getRideId() {
		return rideId;
	}

	public void setRideId(int rideId) {
		this.rideId = rideId;
	}

	public int getCycleId() {
		return cycleId;
	}

	public void setCycleId(int cycleId) {
		this.cycleId = cycleId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getDistanceTravelled() {
		return distanceTravelled;
	}

	public void setDistanceTravelled(int distanceTravelled) {
		this.distanceTravelled = distanceTravelled;
	}
}
