package com.cin.cyclerentalservice.util.impl;

import org.springframework.stereotype.Component;

import com.cin.cyclerentalservice.entity.Customer;
import com.cin.cyclerentalservice.util.CustomerMapper;
import com.cin.cyclerentalservice.vo.CustomerVO;

@Component
public class CustomerMapperImpl implements CustomerMapper {

	@Override
	public Customer getCustomer(CustomerVO customerVO, Customer customer) {
		if (customer == null)
			customer = new Customer();
		customer.setCustomerId(customerVO.getCustomerId());
		customer.setFirstName(customerVO.getFirstName());
		customer.setMiddleName(customerVO.getMiddleName());
		customer.setLastName(customerVO.getLastName());
		customer.setStatusCode(customerVO.getStatusCode());
		customer.setAddressLine1(customerVO.getAddressLine1());
		customer.setAddressLine2(customerVO.getAddressLine2());
		customer.setCity(customerVO.getCity());
		customer.setState(customerVO.getState());
		customer.setCountry(customerVO.getCountry());
		customer.setPostalCode(customerVO.getPostalCode());
		return customer;
	}

	@Override
	public CustomerVO getCustomerVO(Customer customer) {
		CustomerVO customerVO = new CustomerVO();
		customerVO.setCustomerId(customer.getCustomerId());
		customerVO.setFirstName(customer.getFirstName());
		customerVO.setMiddleName(customer.getMiddleName());
		customerVO.setLastName(customer.getLastName());
		customerVO.setStatusCode(customer.getStatusCode());
		customerVO.setAddressLine1(customer.getAddressLine1());
		customerVO.setAddressLine2(customer.getAddressLine2());
		customerVO.setCity(customer.getCity());
		customerVO.setState(customer.getState());
		customerVO.setCountry(customer.getCountry());
		customerVO.setPostalCode(customer.getPostalCode());
		return customerVO;
	}

}
