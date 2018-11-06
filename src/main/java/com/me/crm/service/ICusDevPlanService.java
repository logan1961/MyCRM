package com.me.crm.service;

import com.me.crm.common.ServerResponse;
import com.me.crm.entity.CusDevPlan;

public interface ICusDevPlanService {

	ServerResponse addSaleChancePlan(CusDevPlan cusDevPlan);

	ServerResponse pageList(Integer page, Integer limit, CusDevPlan cusDevPlan,Integer saleChanceId);


}
