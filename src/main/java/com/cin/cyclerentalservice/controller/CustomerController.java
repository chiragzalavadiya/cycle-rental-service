package com.cin.cyclerentalservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cin.cyclerentalservice.service.CustomerService;
import com.cin.cyclerentalservice.vo.CustomerVO;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/version")
	public String version () {
		return "CustomerController v1.0";
	}
	
	@GetMapping("/getAllCustomerVOList")
	public ResponseEntity<List<CustomerVO>> getAllCustomerVOList () {
		List<CustomerVO> serviceResult = customerService.getAllCustomerVOList();
		return new ResponseEntity<List<CustomerVO>>(serviceResult, HttpStatus.OK);
	}
}
