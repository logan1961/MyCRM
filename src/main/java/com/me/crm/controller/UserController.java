package com.me.crm.controller;

import java.util.Date;

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
		System.out.println(time);
		ServerResponse serverResponse = userService.pageList(page,limit,user);
		System.out.println(serverResponse);
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
	public ServerResponse add(User user){
		return userService.add(user);
	}
}
