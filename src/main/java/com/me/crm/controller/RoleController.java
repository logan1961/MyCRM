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
	
	@RequestMapping("/pageList")
	@ResponseBody
	public ServerResponse pageList(Integer page, Integer limit, Role role, Date time) {
		ServerResponse serverResponse = roleService.pageList(page, limit, role);
		System.out.println(serverResponse);
		return serverResponse;
	}

	@RequestMapping("/deleteById")
	@ResponseBody
	public ServerResponse deleteById(Integer id) {
		return roleService.deleteById(id);
	}

	@RequestMapping("/deleteAll")
	@ResponseBody
	public ServerResponse deleteAll(String ids) {
		return roleService.deleteAll(ids);
	}

	@RequestMapping("/getAddPage")
	public String getAddPage() {
		return "/role/role_add";
	}

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
	
	@RequestMapping("/selectRoleAndPermissions")
	@ResponseBody
	public ServerResponse selectRoleAndPermissions(Integer roleId){
		return roleService.selectRoleAndPermissions(roleId);
	}
	
	@RequestMapping("/selectAllRoles")
	@ResponseBody
	public ServerResponse selectAllRoles() {
		return roleService.selectAllRoles();
	}
	
}
