package com.me.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	/**
	 * 获得添加页面
	 * @return
	 */
	@RequestMapping("/getAddPage")
	public String getAddPage(){
		return "/product/product_add";
	}
	
	/**
	 * 添加
	 * @param product
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ServerResponse add(Product product){
		return productService.add(product);
	}
	
	/**
	 * 获得修改界面
	 * @return
	 */
	@RequestMapping("/getUpdatePage")
	public String getUpdate(){
		return "/product/product_update";
	}
	
	/**
	 * 修改
	 * @param product
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(Product product){
		return productService.update(product);
	}
	
	/**
	 * 根据id查找出要修改的信息
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id,Model model) {
		Product product = productService.findById(id);
		System.err.println("测试product" + product);
		model.addAttribute("product",product);
		return "/product/product_update";
	}
	
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteById")
	@ResponseBody
	public ServerResponse deleteById(Integer id){
		System.out.println("测试productId" + id);
		return productService.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/deleteAll")
	@ResponseBody
	public ServerResponse deleteAll(String ids){
		return productService.deleteAll(ids);
	}
	
	/**
	 * 获得商品图表界面
	 * @return
	 */
	@RequestMapping("/getProductChartPage")
	public String getProductChartPage(){
		return "/charts/product_chart";
	}
	
	/**
	 * 获得商品对应的数量
	 * @return
	 */
	@RequestMapping("/getProductCount")
	@ResponseBody
	public ServerResponse getProductCount(){
		return productService.getProductCount();
	}
}
