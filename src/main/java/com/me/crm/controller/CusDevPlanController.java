package com.me.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.me.crm.common.ServerResponse;
import com.me.crm.entity.CusDevPlan;
import com.me.crm.service.ICusDevPlanService;

@Controller
@RequestMapping("/cusDevPlan")
public class CusDevPlanController {
	@Autowired
	private ICusDevPlanService cusDevPlanService;
	
	/**
	 * 分页展示
	 * @param page
	 * @param limit
	 * @param cusDevPlan
	 * @param saleChanceId
	 * @return
	 */
	@RequestMapping("/pageList")
	@ResponseBody
	public ServerResponse pageList(Integer page,Integer limit,CusDevPlan cusDevPlan,Integer saleChanceId){
		ServerResponse serverResponse = cusDevPlanService.pageList(page,limit,cusDevPlan,saleChanceId);
		System.out.println("测试的serverResponse" + serverResponse.getData());
		return serverResponse;
	}
	
	/**
	 * 获得营销开发界面
	 * @return
	 */
	@RequestMapping("/getSaleChancePlanPage")
	public String getSaleChancePlanPage(Integer saleChanceId,Model model){
		model.addAttribute("saleChanceId",saleChanceId);
		return "/cus_dev_plan/sale_chance_plan_list";
	}
	
	/**
	 * 获得添加开发项界面
	 * @param saleChanceId
	 * @param model
	 * @return
	 */
	@RequestMapping("/getAddPage")
	public String getAddPage(Integer saleChanceId,Model model){
		model.addAttribute("saleChanceId", saleChanceId);
		return "/cus_dev_plan/sale_chance_plan_add";
	}
	
	/**
	 * 添加营销机会
	 * @return
	 */
	@RequestMapping("/addSaleChancePlan")
	@ResponseBody
	public ServerResponse addSaleChancePlan(CusDevPlan cusDevPlan){
		System.out.println("测试CusDevPlan内容：" + cusDevPlan);
		return cusDevPlanService.addSaleChancePlan(cusDevPlan);
	}
	
}
