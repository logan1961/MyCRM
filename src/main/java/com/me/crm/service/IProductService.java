package com.me.crm.service;

import java.util.List;

import com.me.crm.common.ServerResponse;
import com.me.crm.entity.Product;

public interface IProductService {

	List<Product> selectAll();

	ServerResponse pageList(Integer page, Integer limit,Product product);

	ServerResponse add(Product product);

	ServerResponse update(Product product);

	Product findById(Integer productId);

}
