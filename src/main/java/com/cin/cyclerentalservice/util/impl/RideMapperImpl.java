package com.cin.cyclerentalservice.util.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.cin.cyclerentalservice.entity.Ride;
import com.cin.cyclerentalservice.util.RideMapper;
import com.cin.cyclerentalservice.vo.RideVO;

@Component
public class RideMapperImpl implements RideMapper {

	@Override
	public Ride getRide(RideVO rideVO, Ride ride) {
		if (ride == null)
			ride = new Ride();
		ride.setRideId(rideVO.getRideId());
		ride.setCycleId(rideVO.getCycleId());
		ride.setCustomerId(rideVO.getCustomerId());
		ride.setStatusCode(rideVO.getStatusCode());
		ride.setStartTime(getDate(rideVO.getStartTime()));
		ride.setEndTime(getDate(rideVO.getEndTime()));
		ride.setDistanceTravelled(rideVO.getDistanceTravelled());
		return ride;
	}

	@Override
	public RideVO getRideVO(Ride ride) {
		RideVO rideVO = new RideVO();
		rideVO.setRideId(ride.getRideId());
		rideVO.setCycleId(ride.getCycleId());
		rideVO.setCustomerId(ride.getCustomerId());
		rideVO.setStatusCode(ride.getStatusCode());
		rideVO.setStartTime(getLocalDateTime(ride.getStartTime()));
		rideVO.setEndTime(getLocalDateTime(ride.getEndTime()));
		rideVO.setDistanceTravelled(ride.getDistanceTravelled());
		return rideVO;
	}

	private Date getDate(LocalDateTime localDateTime) {
		return localDateTime != null ? Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()) : null;
	}
	
	private LocalDateTime getLocalDateTime(Date date) {
		return date != null ? date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime() : null;
	}
}
