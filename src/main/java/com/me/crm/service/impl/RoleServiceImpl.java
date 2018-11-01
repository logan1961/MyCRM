package com.me.crm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.me.crm.common.ServerResponse;
import com.me.crm.entity.Permission;
import com.me.crm.entity.Role;
import com.me.crm.entity.RolePermission;
import com.me.crm.mapper.PermissionMapper;
import com.me.crm.mapper.RoleMapper;
import com.me.crm.mapper.RolePermissionMapper;
import com.me.crm.service.IRoleService;
import com.me.crm.vo.LayUISelectMVO;

@Service
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	@Autowired
	private PermissionMapper permissionMapper;
	
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

	@Override
	public ServerResponse update(Role role, String permissions) {
		try {
			// 将角色插入到数据库中
			int count = roleMapper.updateByPrimaryKey(role);
			// 删除这个角色下面原来的权限
			rolePermissionMapper.deleteByRoleId(role.getId());
			// 将角色-权限多对多关系放到角色-权限表中
			String[] permissionIds = permissions.split(",");
			for (String permissionId : permissionIds) {
				RolePermission rolePermission = new RolePermission(role.getId(), Integer.parseInt(permissionId));
				rolePermissionMapper.insert(rolePermission);
			}
			return ServerResponse.createSuccess("更新成功");
		} catch (Exception e) {
			return ServerResponse.createError("更新失败");
		}
	}

	@Override
	public ServerResponse selectRoleAndPermissions(Integer roleId) {
		Map<String, Object> map = new HashMap<>();
		//查询role信息放到map中
		Role role = roleMapper.selectByPrimaryKey(roleId);
		map.put("role", role);
		//查询所有的权限放到map中
		List<Permission> permissions = permissionMapper.pageList(new Permission());
		List<LayUISelectMVO> list = new ArrayList<>();
		for (Permission permission : permissions) {
			LayUISelectMVO layUISelectMVO = new LayUISelectMVO();
			layUISelectMVO.setId(permission.getId());
			layUISelectMVO.setName(permission.getName());
			layUISelectMVO.setStatus(1);
			list.add(layUISelectMVO);
		}
		map.put("allPermissions", list);
		//将角色对应的所有权限id的数组放到map中
		List<Permission> roleSelectedPermissions = permissionMapper.selectPermissionsByRoleId(roleId);
		Integer[] selectedPermissionIds = new Integer[roleSelectedPermissions.size()];
		for (int i = 0; i < roleSelectedPermissions.size(); i++) {
			selectedPermissionIds[i] = roleSelectedPermissions.get(i).getId();
		}
		map.put("selectIds", selectedPermissionIds);
		
		return ServerResponse.createSuccess("成功", map);
	}

	@Override
	public ServerResponse selectAllRoles() {
		List<Role> roles = roleMapper.pageList(new Role());
		List<LayUISelectMVO> list = new ArrayList<>();
		for (Role role : roles) {
			LayUISelectMVO layUISelectMVO = new LayUISelectMVO();
			layUISelectMVO.setId(role.getId());
			layUISelectMVO.setName(role.getSn());
			layUISelectMVO.setStatus(1);
			list.add(layUISelectMVO);
		}
		
		return ServerResponse.createSuccess("查找成功", list);
	}

}
