package com.me.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.me.crm.common.ServerResponse;
import com.me.crm.entity.Permission;
import com.me.crm.mapper.PermissionMapper;
import com.me.crm.service.IPermissionService;
import com.me.crm.vo.LayUISelectMVO;

@Service
public class PermissionServiceImpl implements IPermissionService {
	@Autowired
	private PermissionMapper permissionMapper;
	
	@Override
	public ServerResponse pageList(Integer page, Integer limit, Permission permission) {
		//1、使用PageHelper插件设置分页
		PageHelper.startPage(page, limit);
		//2、执行查询
		List<Permission> list = permissionMapper.pageList(permission);
		//3、使用PageInfo对结果进行包装
		PageInfo pageInfo = new PageInfo(list);
		Integer count = (int) pageInfo.getTotal();//得到总数量
		
		return ServerResponse.createSuccess("查询成功", count, list);
	}

	@Override
	public ServerResponse deleteById(Integer id) {
		try {
			int count = permissionMapper.deleteByPrimaryKey(id);
			if (count == 1) {
				System.out.println("删除成功");
				return ServerResponse.createSuccess("删除成功");
			} else {
				System.out.println("删除失败");
				return ServerResponse.createError("删除失败");
			}
		} catch (Exception e) {
			return ServerResponse.createError("删除失败");
		}
	}

	@Override
	public ServerResponse deleteAll(String ids) {
		String[] idArray = ids.split(",");
		int count = permissionMapper.deleteAll(idArray);
		if (count == idArray.length) {
			return ServerResponse.createSuccess("删除成功");
		} else {
			return ServerResponse.createError("删除失败");
		}
	}

	@Override
	public ServerResponse add(Permission permission) {
		try {
			int count = permissionMapper.insert(permission);
			if (count == 1) {
				return ServerResponse.createSuccess("添加成功");
			} else {
				return ServerResponse.createError("添加失败");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加失败");
		}
	}

	@Override
	public ServerResponse selectAllPermisssions() {
		List<Permission> permissions = permissionMapper.pageList(new Permission());
		List<LayUISelectMVO> list = new ArrayList<>();
		for (Permission permission : permissions) {
			LayUISelectMVO layUISelectMVO = new LayUISelectMVO();
			layUISelectMVO.setId(permission.getId());
			layUISelectMVO.setName(permission.getName());
			layUISelectMVO.setStatus(1);
			list.add(layUISelectMVO);
		}
		return ServerResponse.createSuccess("查询所有权限成功",list);
	}

}
