package com.cin.cyclerentalservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CycleRentalVO {

	private CycleVO cycleVO;
	private CustomerVO customerVO;
	private RideVO rideVO;
	
	public CycleRentalVO() {
	
	}

	public CycleVO getCycleVO() {
		return cycleVO;
	}

	public void setCycleVO(CycleVO cycleVO) {
		this.cycleVO = cycleVO;
	}

	public CustomerVO getCustomerVO() {
		return customerVO;
	}

	public void setCustomerVO(CustomerVO customerVO) {
		this.customerVO = customerVO;
	}

	public RideVO getRideVO() {
		return rideVO;
	}

	public void setRideVO(RideVO rideVO) {
		this.rideVO = rideVO;
	}
}
