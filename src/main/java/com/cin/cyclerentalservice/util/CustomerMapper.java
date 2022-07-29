package com.cin.cyclerentalservice.util;

import com.cin.cyclerentalservice.entity.Customer;
import com.cin.cyclerentalservice.vo.CustomerVO;

public interface CustomerMapper {
	Customer getCustomer(CustomerVO customerVO, Customer customer);
	CustomerVO getCustomerVO(Customer customer);
}
