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
import com.me.crm.util.UserContext;

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
	
	/**
	 * 根据id删除用户信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteById")
	@ResponseBody
	public ServerResponse deleteById(Integer id){
		return userService.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/deleteAll")
	@ResponseBody
	public ServerResponse deleteAll(String ids){
		return userService.deleteAll(ids);
	}
	
	/**
	 * 获得添加界面
	 * @return
	 */
	@RequestMapping("/getAddPage")
	public String getAddPage(){
		return "/user/user_add";
	}
	
	/**
	 * 添加用户信息
	 * @param user
	 * @param roles
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ServerResponse add(User user,String roles){
		return userService.add(user,roles);
	}
	
	/**
	 * 查找用户和角色信息
	 * @param userId
	 * @return
	 */
	@RequestMapping("/selectUserAndRoles")
	@ResponseBody
	public ServerResponse selectUserAndRoles(Integer userId){
		ServerResponse serverResponse = userService.selectUserAndRoles(userId);
		System.out.println("测试一下查找用户的角色" + serverResponse.getData());
		return userService.selectUserAndRoles(userId);
	}
	
	/**
	 * 获得修改界面
	 * @return
	 */
	@RequestMapping("/getUpdatePage")
	public String getUpdatePage(){
		return "/user/user_update";
	}
	
	/**
	 * 修改信息
	 * @param user
	 * @param roles
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(User user, String roles) {
		System.out.println(user);
		System.out.println(roles);
		return userService.update(user, roles);
	}
	
	/**
	 * 获得登录界面
	 * @return
	 */
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
	
	/**
	 * 用户退出
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		//从session中获取user
		User user = (User) session.getAttribute(UserContext.USER_IN_SESSION);
		System.out.println("退出测试user：" + user);
		if (null != user) {
			//销毁session
			session.invalidate();
			return "/user/login";
		}
		return "/index";
	}
}
