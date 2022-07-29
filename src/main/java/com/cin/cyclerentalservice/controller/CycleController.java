package com.cin.cyclerentalservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cin.cyclerentalservice.service.CycleService;
import com.cin.cyclerentalservice.vo.CycleVO;

@RestController
@RequestMapping("/cycle")
public class CycleController {
	
	@Autowired
	private CycleService cycleService;
	
	@GetMapping("/version")
	public String version () {
		return "CycleController v1.0";
	}
	
	@GetMapping("/getAllCycleVOList")
	public ResponseEntity<List<CycleVO>> getAllCycleVOList () {
		List<CycleVO> serviceResult = cycleService.getAllCycleVOList();
		return new ResponseEntity<List<CycleVO>>(serviceResult, HttpStatus.OK);
	}
}
