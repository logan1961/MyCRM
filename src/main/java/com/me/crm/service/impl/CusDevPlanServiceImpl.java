package com.me.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.me.crm.common.ServerResponse;
import com.me.crm.entity.CusDevPlan;
import com.me.crm.mapper.CusDevPlanMapper;
import com.me.crm.mapper.UserRoleMapper;
import com.me.crm.service.ICusDevPlanService;

@Service
public class CusDevPlanServiceImpl implements ICusDevPlanService {
	@Autowired
	private CusDevPlanMapper cusDevPlanMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	@Override
	public ServerResponse addSaleChancePlan(CusDevPlan cusDevPlan) {
		try {
			int count = cusDevPlanMapper.insert(cusDevPlan);
			if (count == 1) {
				return ServerResponse.createSuccess("添加成功");
			} else {
				return ServerResponse.createError("添加失败");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加失败");
		}
	}

	@Override
	public ServerResponse pageList(Integer page, Integer limit, CusDevPlan cusDevPlan,Integer saleChanceId) {
		//1、使用PageHelper插件设置分页
		PageHelper.startPage(page, limit);
		//2、执行查询
		List<CusDevPlan> list = cusDevPlanMapper.pageList(cusDevPlan,saleChanceId);
		System.out.println("测试的list" + list);
		//3、使用PageInfo对结果进行包装
		PageInfo pageInfo = new PageInfo(list);
		Integer count = (int) pageInfo.getTotal();//得到总数量
		
		return ServerResponse.createSuccess("查询成功", count, list);
	}

}
