package com.me.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.me.crm.common.ServerResponse;
import com.me.crm.entity.Product;
import com.me.crm.mapper.ProductMapper;
import com.me.crm.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<Product> selectAll() {
		return productMapper.pageList(new Product());
	}

	@Override
	public ServerResponse pageList(Integer page, Integer limit,Product product) {
		//1、使用PageHelper插件设置分页
		PageHelper.startPage(page, limit);
		//2、执行查询
		List<Product> list = productMapper.pageList(product);
		//3、使用PageInfo对结果进行包装
		PageInfo pageInfo = new PageInfo(list);
		Integer count = (int) pageInfo.getTotal();
		return ServerResponse.createSuccess("查询成功",count,list);
	}

	@Override
	public ServerResponse add(Product product) {
		try {
			int count = productMapper.insert(product);
			if (count == 1) {
				return ServerResponse.createSuccess("添加成功");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加失败");
		}
		return ServerResponse.createError("添加失败");
	}

	@Override
	public ServerResponse update(Product product) {
		try {
			int count = productMapper.updateByPrimaryKey(product);
			if (count == 1) {
				return ServerResponse.createSuccess("修改成功");
			}
		} catch (Exception e) {
			return ServerResponse.createError("修改失败");
		}
		return ServerResponse.createError("修改失败");
	}

	@Override
	public Product findById(Integer productId) {
		System.out.println("测试id：" + productId);
		Product product = productMapper.selectByPrimaryKey(productId);
		System.out.println("测试product：" + product);
		return product;
	}

	@Override
	public ServerResponse deleteById(Integer id) {
		try {
			int count = productMapper.deleteByPrimaryKey(id);
			if (count == 1) {
				return ServerResponse.createSuccess("删除成功");
			}
		} catch (Exception e) {
			return ServerResponse.createError("删除失败");
		}
		return ServerResponse.createError("删除失败");
	}

	@Override
	public ServerResponse deleteAll(String ids) {
		String[] idArray = ids.split(",");
		int count = productMapper.deleteAll(idArray);
		if (count == idArray.length) {
			return ServerResponse.createSuccess("删除成功");
		}
		return ServerResponse.createError("删除失败");
	}
}
