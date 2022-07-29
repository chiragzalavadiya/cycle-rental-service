package com.cin.cyclerentalservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CYCLE_RENTAL_REPORT")
public class CycleRentalReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REPORT_ID")
	private int reportId;
	
	@Column(name = "REPORT_TYPE")
	private String reportType;
	
	@Column(name = "REPORT_GENERATED_DT")
	private Date reportGeneratedDate;
	
	@Column(name = "RIDE_ID")
	private int rideId;
	
	public CycleRentalReport() {
	
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public Date getReportGeneratedDate() {
		return reportGeneratedDate;
	}

	public void setReportGeneratedDate(Date reportGeneratedDate) {
		this.reportGeneratedDate = reportGeneratedDate;
	}

	public int getRideId() {
		return rideId;
	}

	public void setRideId(int rideId) {
		this.rideId = rideId;
	}
}
