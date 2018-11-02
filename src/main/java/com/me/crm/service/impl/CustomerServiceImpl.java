package com.me.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.crm.entity.Customer;
import com.me.crm.mapper.CustomerMapper;
import com.me.crm.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public List<Customer> selectAll() {
		return customerMapper.pageList(new Customer());
	}

}
