package com.cin.cyclerentalservice.util;

import com.cin.cyclerentalservice.entity.Ride;
import com.cin.cyclerentalservice.vo.RideVO;

public interface RideMapper {
	Ride getRide(RideVO rideVO, Ride ride);
	RideVO getRideVO(Ride ride);
}
