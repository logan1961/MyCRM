package com.me.crm.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.me.crm.common.ServerResponse;
import com.me.crm.entity.Permission;
import com.me.crm.entity.Role;
import com.me.crm.entity.User;
import com.me.crm.service.IRoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private IRoleService roleService;
	
	/**
	 * 得到角色界面
	 * @return
	 */
	@RequestMapping("/getRolePage")
	public String getRolePage(){
		return "/role/role_list";
	}
	
	/**
	 * 分页展示
	 * @param page
	 * @param limit
	 * @param role
	 * @param time
	 * @return
	 */
	@RequestMapping("/pageList")
	@ResponseBody
	public ServerResponse pageList(Integer page, Integer limit, Role role, Date time) {
		ServerResponse serverResponse = roleService.pageList(page, limit, role);
		System.out.println(serverResponse);
		return serverResponse;
	}
	
	/**
	 * 根据id删除角色数据
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteById")
	@ResponseBody
	public ServerResponse deleteById(Integer id) {
		return roleService.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/deleteAll")
	@ResponseBody
	public ServerResponse deleteAll(String ids) {
		return roleService.deleteAll(ids);
	}
	
	/**
	 * 获得添加页面
	 * @return
	 */
	@RequestMapping("/getAddPage")
	public String getAddPage() {
		return "/role/role_add";
	}
	
	/**
	 * 添加
	 * @param role
	 * @param permissions
	 * @param session
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ServerResponse add(Role role, String permissions, HttpSession session) {
		System.out.println("role是这个:" + role);
		System.out.println("permission是这个:" + permissions);
		User user = (User) session.getAttribute("user");
		return roleService.add(role, permissions);
	}
	
	/**
	 * 角色修改
	 * @param role
	 * @param permissions
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(Role role,String permissions){
		System.out.println(role);
		System.out.println(permissions);
		return roleService.update(role,permissions);
	}
	
	/**
	 * 获得角色修改界面
	 * @return
	 */
	@RequestMapping("/getUpdatePage")
	public String getUpdatePage(){
		return "/role/role_update";
	}
	
	/**
	 * 查找出角色对应的权限信息
	 * @param roleId
	 * @return
	 */
	@RequestMapping("/selectRoleAndPermissions")
	@ResponseBody
	public ServerResponse selectRoleAndPermissions(Integer roleId){
		ServerResponse serverResponse = roleService.selectRoleAndPermissions(roleId);
		System.out.println("测试一下用户的权限信息" + serverResponse.getData());
		return roleService.selectRoleAndPermissions(roleId);
	}
	
	/**
	 * 查找所有的角色
	 * @return
	 */
	@RequestMapping("/selectAllRoles")
	@ResponseBody
	public ServerResponse selectAllRoles() {
		return roleService.selectAllRoles();
	}
	
}
