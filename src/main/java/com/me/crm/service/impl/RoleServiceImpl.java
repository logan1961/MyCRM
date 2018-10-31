package com.me.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.me.crm.common.ServerResponse;
import com.me.crm.entity.Role;
import com.me.crm.entity.RolePermission;
import com.me.crm.entity.RolePermissionKey;
import com.me.crm.mapper.RoleMapper;
import com.me.crm.mapper.RolePermissionMapper;
import com.me.crm.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	
	@Override
	public ServerResponse deleteById(Integer id) {
		try {
			int count = roleMapper.deleteByPrimaryKey(id);
			if (count == 1) {
				return ServerResponse.createSuccess("删除成功");
			} else {
				return ServerResponse.createError("删除失败");
			}
		} catch (Exception e) {
			return ServerResponse.createError("删除失败");
		}
	}

	@Override
	public ServerResponse deleteAll(String ids) {
		String[] idArray = ids.split(",");
		int count = roleMapper.deleteAll(idArray);
		if (count == idArray.length) {
			return ServerResponse.createSuccess("删除成功");
		} else {
			return ServerResponse.createError("删除失败");
		}
	}

	@Override
	public ServerResponse add(Role role, String permissions) {
		try {
			// 将角色插入到数据库中
			int count = roleMapper.insert(role);
			// 将角色-权限多对多关系放到角色-权限表中
			String[] permissionIds = permissions.split(",");
			for (String permissionId : permissionIds) {
				System.out.println("role的id:" + role.getId());
				RolePermission rolePermission = new RolePermission(role.getId(), Integer.parseInt(permissionId));
				System.out.println("打印一下rolePermission:" + rolePermission);
				System.out.println("测试下permissionId:" + permissionId);
				rolePermissionMapper.insert(rolePermission);
			}
			return ServerResponse.createSuccess();
		} catch (Exception e) {
			return ServerResponse.createError("添加失败");
		}
	}

	@Override
	public ServerResponse pageList(Integer page, Integer limit, Role role) {
		//1、使用PageHelper插件设置分页
		PageHelper.startPage(page, limit);
		//2、执行查询
		List<Role> list = roleMapper.pageList(role);
		//3、使用PageInfo对结果进行包装
		PageInfo pageInfo = new PageInfo(list);
		Integer count = (int) pageInfo.getTotal();//得到总数量
		
		return ServerResponse.createSuccess("查询成功", count, list);
	}

}
