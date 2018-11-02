package com.me.crm.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.me.crm.common.ServerResponse;
import com.me.crm.entity.Customer;
import com.me.crm.entity.SaleChance;
import com.me.crm.service.ICustomerService;
import com.me.crm.service.ISaleChanceService;

@Controller
@RequestMapping("/saleChance")
public class SaleChanceController {
	@Autowired
	private ISaleChanceService saleChanceService;
	@Autowired
	private ICustomerService customerService;
	
	/**
	 * 获得营销管理界面
	 * @return
	 */
	@RequestMapping("/getSaleChancePage")
	public String getSaleChancePage() {
		return "/sale_chance/sale_chance_list";
	}
	
	/**
	 * 分页展示
	 * @param page
	 * @param limit
	 * @param saleChance
	 * @param time
	 * @return
	 */
	@RequestMapping("/pageList")
	@ResponseBody
	public ServerResponse pageList(Integer page, Integer limit, SaleChance saleChance, Date time) {
		System.out.println(time);
		ServerResponse serverResponse = saleChanceService.pageList(page, limit, saleChance);
		System.out.println(serverResponse);
		return serverResponse;
	}
	
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteById")
	@ResponseBody
	public ServerResponse deleteById(Integer id) {
		return saleChanceService.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/deleteAll")
	@ResponseBody
	public ServerResponse deleteAll(String ids) {
		return saleChanceService.deleteAll(ids);
	}
	
	/**
	 * 获得添加界面
	 * @param model
	 * @return
	 */
	@RequestMapping("/getAddPage")
	public String getAddPage(Model model) {
		List<Customer> customerList = customerService.selectAll();
		model.addAttribute("customerList", customerList);
		return "/sale_chance/sale_chance_add";
	}
	
	/**
	 * 添加
	 * @param saleChance
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ServerResponse add(SaleChance saleChance) {
		System.out.println(saleChance);
		return saleChanceService.add(saleChance);
	}
	
	/**
	 * 获得修改界面
	 * @return
	 */
	@RequestMapping("/getUpdatePage")
	public String getUpdatePage() {
		return "/saleChance/saleChance_update";
	}
	
	/**
	 * 修改
	 * @param saleChance
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(SaleChance saleChance) {
		System.out.println(saleChance);
		return saleChanceService.update(saleChance);
	}
	
}
