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
import com.me.crm.entity.Role;
import com.me.crm.entity.User;
import com.me.crm.entity.UserRole;
import com.me.crm.mapper.RoleMapper;
import com.me.crm.mapper.UserMapper;
import com.me.crm.mapper.UserRoleMapper;
import com.me.crm.service.IUserService;
import com.me.crm.vo.LayUISelectMVO;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	/**
	 * 分页展示
	 */
	@Override
	public ServerResponse pageList(Integer page, Integer limit, User user) {
		//1、使用PageHelper插件设置分页
		PageHelper.startPage(page, limit);
		//2、执行查询
		List<User> list = userMapper.pageList(user);
		//3、使用PageInfo对结果进行包装
		PageInfo pageInfo = new PageInfo(list);
		Integer count = (int) pageInfo.getTotal();
		return ServerResponse.createSuccess("查询成功",count,list);
	}

	@Override
	public ServerResponse add(User user,String roles) {
		try {
			//将角色插入到数据库中
			int count = userMapper.insert(user);
			//将角色-权限多对多关系放到角色-权限表中
			String[] roleIds = roles.split(",");
			for (String roleId : roleIds) {
				UserRole userRole = new UserRole(user.getId(),Integer.parseInt(roleId));
				userRoleMapper.insert(userRole);
			}
			return ServerResponse.createSuccess();
		} catch (Exception e) {
			return ServerResponse.createError("添加失败");
		}
	}

	@Override
	public ServerResponse deleteById(Integer id) {
		try {
			int count = userMapper.deleteByPrimaryKey(id);
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
		int count = userMapper.deleteAll(idArray);
		if (count == idArray.length) {
			return ServerResponse.createSuccess("删除成功");
		} else {
			return ServerResponse.createError("删除失败");
		}
	}

	@Override
	public ServerResponse update(User user, String roles) {
		try {
			// 将角色插入到数据库中
			int count = userMapper.updateByPrimaryKey(user);
			// 删除这个角色下面原来的权限
			userRoleMapper.deleteByUserId(user.getId());
			// 将角色-权限多对多关系放到角色-权限表中
			String[] roleIds = roles.split(",");
			for (String roleId : roleIds) {
				UserRole userRole = new UserRole(user.getId(), Integer.parseInt(roleId));
				userRoleMapper.insert(userRole);
			}
			return ServerResponse.createSuccess("更新成功");
		} catch (Exception e) {
			return ServerResponse.createError("更新失败");
		}
	}

	@Override
	public ServerResponse selectUserAndRoles(Integer userId) {
		Map<String, Object> map = new HashMap<>();
		//查询user信息放到map中
		User user = userMapper.selectByPrimaryKey(userId);
		map.put("user", user);
		//查询所有的权限放到map中
		List<Role> roles = roleMapper.pageList(new Role());
		List<LayUISelectMVO> list = new ArrayList<>();
		for (Role role : roles) {
			LayUISelectMVO layUISelectMVO = new LayUISelectMVO();
			layUISelectMVO.setId(role.getId());
			layUISelectMVO.setName(role.getSn());
			layUISelectMVO.setStatus(1);
			list.add(layUISelectMVO);
		}
		map.put("allRoles", list);
		//将角色对应的所有角色id的数组放到map中
		List<Role> userSelectedRoles = roleMapper.selectRoleByUserId(userId);
		Integer[] selectedRoleIds = new Integer[userSelectedRoles.size()];
		for (int i = 0; i < userSelectedRoles.size(); i++) {
			selectedRoleIds[i] = userSelectedRoles.get(i).getId();
		}
		map.put("selectIds", selectedRoleIds);
		
		return ServerResponse.createSuccess("成功",map);
	}

}
