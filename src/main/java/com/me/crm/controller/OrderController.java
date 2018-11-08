package com.me.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.me.crm.common.ServerResponse;
import com.me.crm.service.IOrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private IOrderService orderService;
	
	/**
	 * 获得订单界面
	 * @return
	 */
	@RequestMapping("/getOrderPage")
	public String getOrderPage(){
		return "/order/order";
	}
	
	/**
	 * 分页展示
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/pageList")
	@ResponseBody
	public ServerResponse pageList(Integer page,Integer limit){
		ServerResponse serverResponse = orderService.pageList(page, limit);
		return serverResponse;
	}
	
}
