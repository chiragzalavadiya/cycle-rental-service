package com.cin.cyclerentalservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cin.cyclerentalservice.entity.Ride;
import com.cin.cyclerentalservice.service.RideService;
import com.cin.cyclerentalservice.util.RideMapper;
import com.cin.cyclerentalservice.vo.RideVO;

@Service
public class RideServiceImpl implements RideService {

private static Logger logger = LoggerFactory.getLogger(RideServiceImpl.class);
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	private RideMapper rideMapper;
	
	@Override
	public List<RideVO> getAllRideVOList() {
		List<RideVO> rideVOs = new ArrayList<RideVO>();
		List<Ride> rides = findAllRide();
		rides.forEach(ride -> rideVOs.add(rideMapper.getRideVO(ride)));
		return rideVOs;
	}

	private List<Ride> findAllRide() {
		List<Ride> rides = null;
		try {
			TypedQuery<Ride> query = em.createNamedQuery("findAll.ride", Ride.class);
			rides = query.getResultList();
		} catch (PersistenceException pe) {
			logger.error("Error occurred in findAllRide");
			pe.printStackTrace();
		}
		return rides;
	}
}
