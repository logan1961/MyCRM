package com.me.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.me.crm.common.ServerResponse;
import com.me.crm.entity.Role;
import com.me.crm.entity.User;
import com.me.crm.mapper.RoleMapper;
import com.me.crm.mapper.UserMapper;
import com.me.crm.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;
	
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
	public ServerResponse add(User user) {
		try {
			int count = userMapper.insert(user);
			if (count == 1) {
				return ServerResponse.createSuccess("添加成功");
			} else {
				return ServerResponse.createError("添加失败");
			}
		} catch (Exception e) {
			return ServerResponse.createError("删除失败");
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
	public ServerResponse selectAllRoles() {
		List<Role> roles = roleMapper.pageList(new Role());
		return null;
	}

}
