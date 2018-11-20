package com.me.crm.controller;

import java.util.Date;

import org.apache.xmlbeans.impl.xb.xsdschema.impl.PublicImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.me.crm.common.ServerResponse;
import com.me.crm.entity.Permission;
import com.me.crm.service.IPermissionService;

@Controller
@RequestMapping("/permission")
public class PermissionController {
	@Autowired
	private IPermissionService permissionService;
	
	/**
	 * 获得权限界面
	 * @return
	 */
	@RequestMapping("/getPermissionPage")
	public String getPermissionPage() {
		return "/permission/permission_list";
	}
	
	/**
	 * 分页展示
	 * @param page
	 * @param limit
	 * @param permission
	 * @param time
	 * @return
	 */
	@RequestMapping("/pageList")
	@ResponseBody
	public ServerResponse pageList(Integer page,Integer limit,Permission permission,Date time){
		System.out.println(time);
		ServerResponse serverResponse = permissionService.pageList(page,limit,permission);
		return serverResponse;
	}
	
	/**
	 * 根据id删除权限
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteById")
	@ResponseBody
	public ServerResponse deleteById(Integer id){
		return permissionService.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/deleteAll")
	@ResponseBody
	public ServerResponse deleteAll(String ids){
		return permissionService.deleteAll(ids);
	}
	
	/**
	 * 添加
	 * @param permission
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ServerResponse add(Permission permission){
		return permissionService.add(permission);
	}
	
	/**
	 * 获取权限添加界面
	 * @return
	 */
	@RequestMapping("/getAddPage")
	public String getAddPage(){
		return "/permission/permission_add";
	}
	
	/**
	 * 查找所有权限
	 * @return
	 */
	@RequestMapping("/selectAllPermisssions")
	@ResponseBody
	public ServerResponse selectAllPermisssions() {
		return permissionService.selectAllPermisssions();
	}
	
	/**
	 * 获得修改界面
	 * @return
	 */
	@RequestMapping("/getUpdatePage")
	public String getUpdatePage() {
		return "/permission/permission_update";
	}
	
	/**
	 * 修改
	 * @param permission
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ServerResponse update(Permission permission) {
		return permissionService.update(permission);
	}
	
	/**
	 * 根据id查找权限
	 * @param id
	 * @return
	 */
	@RequestMapping("/findPermissionById")
	@ResponseBody
	public ServerResponse findPermissionById(Integer id,Model model) {
		return permissionService.findPermissionById(id);
	}
}
