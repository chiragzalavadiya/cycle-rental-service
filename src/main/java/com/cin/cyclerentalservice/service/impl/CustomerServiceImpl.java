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

import com.cin.cyclerentalservice.entity.Customer;
import com.cin.cyclerentalservice.service.CustomerService;
import com.cin.cyclerentalservice.util.CustomerMapper;
import com.cin.cyclerentalservice.vo.CustomerVO;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public List<CustomerVO> getAllCustomerVOList() {
		List<CustomerVO> customerVOs = new ArrayList<CustomerVO>();
		List<Customer> customers = findAllCustomer();
		customers.forEach(customer -> customerVOs.add(customerMapper.getCustomerVO(customer)));
		return customerVOs;
	}

	private List<Customer> findAllCustomer() {
		List<Customer> customers = null;
		try {
			TypedQuery<Customer> query = em.createNamedQuery("findAll.customer", Customer.class);
			customers = query.getResultList();
		} catch (PersistenceException pe) {
			logger.error("Error occurred in findAllCustomer");
			pe.printStackTrace();
		}
		return customers;
	}
}
