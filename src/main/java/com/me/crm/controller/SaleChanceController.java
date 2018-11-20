package com.me.crm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.impl.PublicImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.me.crm.common.ServerResponse;
import com.me.crm.entity.Customer;
import com.me.crm.entity.Order;
import com.me.crm.entity.Product;
import com.me.crm.entity.SaleChance;
import com.me.crm.entity.User;
import com.me.crm.service.ICustomerService;
import com.me.crm.service.IOrderService;
import com.me.crm.service.IProductService;
import com.me.crm.service.ISaleChanceService;
import com.me.crm.service.IUserService;

@Controller
@RequestMapping("/saleChance")
public class SaleChanceController {
	@Autowired
	private ISaleChanceService saleChanceService;
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private IProductService productService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IOrderService orderService;
	
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
		List<Product> productList = productService.selectAll();
		model.addAttribute("productList",productList);
		List<User> userList = userService.selectXiaoShouUser();
		model.addAttribute("userList",userList);
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
	public String getUpdatePage(Integer saleChanceId,Model model) {
		SaleChance saleChance = saleChanceService.selectById(saleChanceId);
		model.addAttribute("saleChance",saleChance);
		
		List<Customer> customers = customerService.selectAll();
		List<Product> products = productService.selectAll();
		List<User> users = userService.selectXiaoShouUser();
		model.addAttribute("customers",customers);
		model.addAttribute("product",products);
		model.addAttribute("user",users);
		return "/sale_chance/sale_chance_update";
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
	
	@RequestMapping("/selectById")
	@ResponseBody
	public ServerResponse selectById(Integer saleChanceId){
		//查出sale_chance表的信息
		SaleChance saleChance = saleChanceService.selectById(saleChanceId);
		System.out.println("测试saleChance：" + saleChance);
		
		//填充order表
		Order order = new Order();
		order.setCustomerId(saleChance.getCustomerId());//客户ID
		
		//生成时间的订单号
		Date date = new Date();
		SimpleDateFormat toOrderNo = new SimpleDateFormat("yyyyMMddhhmmss");
		String orderNo = toOrderNo.format(date);
		order.setOrderNo(orderNo);//订单号
		order.setSaleChanceId(saleChance.getId());//机会id
		
		//订购日期
		order.setOrderDate(date);//订购日期
		order.setStatus(1);//回款
		order.setProductId(saleChance.getProductId());//产品id
		
		//更改sale_chance表的客户状态,更改为开发成功
		SaleChance sale = new SaleChance();
		sale.setDevResult(2);
		saleChanceService.update(sale);
		
		return orderService.insert(order);
	}
	
	/**
	 * 开发失败
	 * @param saleChanceId
	 * @return
	 */
	@RequestMapping("/fail")
	@ResponseBody
	public ServerResponse fail(Integer saleChanceId) {
		//查出开发机会的信息
		SaleChance saleChance = saleChanceService.selectById(saleChanceId);
		//设置开发状态为开发失败--3
		saleChance.setDevResult(3);
		//修改状态更新完的saleChance
		return saleChanceService.update(saleChance);
	}
}
