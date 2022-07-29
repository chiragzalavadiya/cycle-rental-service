package com.cin.cyclerentalservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cin.cyclerentalservice.service.RideService;
import com.cin.cyclerentalservice.vo.RideVO;

@RestController
@RequestMapping("/ride")
public class RideController {

	@Autowired
	private RideService rideService;
	
	@GetMapping("/version")
	public String version () {
		return "RideController v1.0";
	}
	
	@GetMapping("/getAllRideVOList")
	public ResponseEntity<List<RideVO>> getAllRideVOList () {
		List<RideVO> serviceResult = rideService.getAllRideVOList();
		return new ResponseEntity<List<RideVO>>(serviceResult, HttpStatus.OK);
	}
}
