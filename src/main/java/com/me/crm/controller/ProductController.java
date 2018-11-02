package com.me.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.me.crm.common.ServerResponse;
import com.me.crm.entity.Product;
import com.me.crm.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private IProductService productService;
	
	/**
	 * 获得商品界面
	 * @return
	 */
	@RequestMapping("/getProductPage")
	public String getProductPage(){
		return "/product/product_list";
	}
	
	/**
	 * 分页展示
	 * @param page
	 * @param limit
	 * @param product
	 * @return
	 */
	@RequestMapping("/pageList")
	@ResponseBody
	public ServerResponse pageList(Integer page,Integer limit,Product product){
		ServerResponse serverResponse = productService.pageList(page,limit,product); 
		return serverResponse;
	}
	
	@RequestMapping("/getAddPage")
	public String getAddPage(){
		return "/product/product_add";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public ServerResponse add(Product product){
		return productService.add(product);
	}
	
	@RequestMapping("/getUpdatePage")
	public String getUpdate(){
		return "/product/product_update";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(Product product){
		return productService.update(product);
	}
	
	@RequestMapping("/findById")
	@ResponseBody
	public Product findById(Integer productId){
		return productService.findById(productId);
	}
}
