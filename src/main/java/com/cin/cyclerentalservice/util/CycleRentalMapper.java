package com.cin.cyclerentalservice.util;

import com.cin.cyclerentalservice.entity.CycleRentalReport;
import com.cin.cyclerentalservice.vo.CycleRentalVO;

public interface CycleRentalMapper {
	CycleRentalVO toCycleRentalVO(Object object);
	CycleRentalReport getCycleRentalReport(String reportType, Integer rideId);
}
