package com.me.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.me.crm.common.ServerResponse;
import com.me.crm.entity.Order;
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
	
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteById")
	@ResponseBody
	public ServerResponse deleteById(Integer id){
		return orderService.deleteById(id);
	}
	
	/**
	 * 获得订单详情展示页面
	 * @return
	 */
	@RequestMapping("/getOrderDetailPage")
	public String getOrderDetailPage(Integer id,Model model) {
		Order order = orderService.findById(id);
		model.addAttribute("order",order);
		return "/order/order_detail";
	}
}
