package com.me.crm.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.me.crm.common.ServerResponse;
import com.me.crm.entity.User;
import com.me.crm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	/**
	 * 获取用户信息界面
	 * @return
	 */
	@RequestMapping("/getUserPage")
	public String getUserPage(){
		return "/user/user_list";
	}
	
	/**
	 * 分页展示界面
	 * @param page
	 * @param limit
	 * @param user
	 * @param time
	 * @return
	 */
	@RequestMapping(value="/pageList")
	@ResponseBody
	public ServerResponse pageList(Integer page,Integer limit,User user,Date time){
		System.out.println("这个时间是：" + time);
		System.out.println("page测试" + page);
		System.out.println("甲方单位" + limit);
		ServerResponse serverResponse = userService.pageList(page,limit,user);
		System.out.println("这个serverResponse是：" + serverResponse);
		return serverResponse;
	}
	
	@RequestMapping("/deleteById")
	@ResponseBody
	public ServerResponse deleteById(Integer id){
		return userService.deleteById(id);
	}
	
	@RequestMapping("/deleteAll")
	@ResponseBody
	public ServerResponse deleteAll(String ids){
		return userService.deleteAll(ids);
	}
	
	@RequestMapping("/getAddPage")
	public String getAddPage(){
		return "/user/user_add";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public ServerResponse add(User user,String roles){
		return userService.add(user,roles);
	}
	
	@RequestMapping("/selectUserAndRoles")
	@ResponseBody
	public ServerResponse selectAllRoles(Integer userId){
		return userService.selectUserAndRoles(userId);
	}
	
	@RequestMapping("/getUpdatePage")
	public String getUpdatePage(){
		return "/user/user_update";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(User user, String roles) {
		System.out.println(user);
		System.out.println(roles);
		return userService.update(user, roles);
	}
	
	@RequestMapping("/getLoginPage")
	public String getLoginPage(){
		return "/user/login";
	}
	
	/**
	 * 登录
	 * @param name
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public ServerResponse login(String name,String password,HttpSession session){
		return userService.login(name,password,session);
	}
}
