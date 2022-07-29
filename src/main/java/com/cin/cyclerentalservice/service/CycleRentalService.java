package com.cin.cyclerentalservice.service;

import java.util.List;

import com.cin.cyclerentalservice.vo.CycleRentalVO;

public interface CycleRentalService {
	String generateCycleRentalReport();
	List<CycleRentalVO> getReportBasedOnReportType(String reportType);
}
