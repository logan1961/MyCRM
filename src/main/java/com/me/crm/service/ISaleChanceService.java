package com.me.crm.service;

import com.me.crm.common.ServerResponse;
import com.me.crm.entity.SaleChance;

public interface ISaleChanceService {

	ServerResponse pageList(Integer page, Integer limit, SaleChance saleChance);

	ServerResponse deleteById(Integer id);

	ServerResponse deleteAll(String ids);

	ServerResponse add(SaleChance saleChance);

	ServerResponse update(SaleChance saleChance);

}
