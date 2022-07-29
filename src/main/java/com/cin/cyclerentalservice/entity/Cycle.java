package com.cin.cyclerentalservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "CYCLE")
@NamedQueries({
	@NamedQuery(name = "findAll.cycle", query = "select c from Cycle as c where status_cd = 'ACTIVE'")
})
public class Cycle {

	@Id
	@Column(name = "CYCLE_ID", nullable=false, unique=true)
	private int cycleId;
	
	@Column(name = "CYCLE_BRAND", nullable=false, length=100)
	private String cycleBrandName;
	
	@Column(name = "STATUS_CD", nullable=false, length=50)
	private String statusCode;
	
	public Cycle() {
	
	}

	public int getCycleId() {
		return cycleId;
	}

	public void setCycleId(int cycleId) {
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
