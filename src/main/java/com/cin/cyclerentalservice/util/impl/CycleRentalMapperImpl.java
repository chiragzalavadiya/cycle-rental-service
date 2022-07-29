package com.cin.cyclerentalservice.util.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.cin.cyclerentalservice.entity.CycleRentalReport;
import com.cin.cyclerentalservice.util.CycleRentalMapper;
import com.cin.cyclerentalservice.vo.CustomerVO;
import com.cin.cyclerentalservice.vo.CycleRentalVO;
import com.cin.cyclerentalservice.vo.CycleVO;
import com.cin.cyclerentalservice.vo.RideVO;

@Component
public class CycleRentalMapperImpl implements CycleRentalMapper {

	@Override
	public CycleRentalVO toCycleRentalVO(Object object) {
		CycleRentalVO cycleRentalVO = new CycleRentalVO();
		if(object != null) {
			CycleVO cycleVO = new CycleVO();
			CustomerVO customerVO = new CustomerVO();
			RideVO rideVO = new RideVO();
			
			Object[] arr = (Object[])object;
			rideVO.setRideId(getInteger(arr, 0));
			rideVO.setStartTime(getLocalDateTime(arr, 1));
			rideVO.setEndTime(getLocalDateTime(arr, 2));
			rideVO.setDistanceTravelled(getInteger(arr, 3));
			cycleVO.setCycleId(getInteger(arr, 4));
			cycleVO.setCycleBrandName(getString(arr, 5));
			customerVO.setFirstName(getString(arr, 6));
			customerVO.setLastName(getString(arr, 7));
			
			cycleRentalVO.setCycleVO(cycleVO);
			cycleRentalVO.setCustomerVO(customerVO);
			cycleRentalVO.setRideVO(rideVO);
		}
		return cycleRentalVO;
	}

	@Override
	public CycleRentalReport getCycleRentalReport(String reportType, Integer rideId) {
		CycleRentalReport cycleRentalReport = new CycleRentalReport();
		cycleRentalReport.setReportType(reportType);
		cycleRentalReport.setReportGeneratedDate(new Date());
		cycleRentalReport.setRideId(rideId);
		return cycleRentalReport;
	}

	private Integer getInteger(Object[] arr, int position) {
		return arr[position] != null ? Integer.parseInt(String.valueOf(arr[position])) : null;
	}
	
	private String getString(Object[] arr, int position) {
		return arr[position] != null ? String.valueOf(arr[position]) : null;
	}
	
	private LocalDateTime getLocalDateTime(Object[] arr, int position) {
		return arr[position] != null ? ((Date)arr[position]).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime() : null;
	}
}
