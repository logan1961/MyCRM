package com.me.crm.service;

import com.me.crm.common.ServerResponse;
import com.me.crm.entity.Order;

public interface IOrderService {

	ServerResponse pageList(Integer page, Integer limit);

	ServerResponse insert(Order order);

	ServerResponse deleteById(Integer id);

}
