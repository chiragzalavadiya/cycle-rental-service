package com.cin.cyclerentalservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cin.cyclerentalservice.service.CycleRentalService;
import com.cin.cyclerentalservice.vo.CycleRentalVO;

@RestController
@RequestMapping("/rentcycle")
public class CycleRentalController {
	
	@Autowired
	private CycleRentalService cycleRentalService;
	
	@GetMapping("/version")
	public String version () {
		return "CycleRentalController v1.0";
	}
	
	//@Scheduled(cron = "0 0/5 * 1/1 * ?") //every 5 min every day
	@Scheduled(cron = "0 0 6 1/1 * ?") //At 6:00 every day
	@GetMapping("/generateCycleRentalReport")
	public ResponseEntity<String> generateCycleRentalReport () {
		String serviceResult = cycleRentalService.generateCycleRentalReport();
		return new ResponseEntity<String>(serviceResult, HttpStatus.OK);
	}
	
	@GetMapping("/getReportBasedOnReportType/{reportType}")
	public ResponseEntity<List<CycleRentalVO>> getReportBasedOnReportType (@PathVariable String reportType) {
		List<CycleRentalVO> serviceResult = cycleRentalService.getReportBasedOnReportType(reportType);
		return new ResponseEntity<List<CycleRentalVO>>(serviceResult, HttpStatus.OK);
	}
}
