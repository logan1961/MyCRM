package com.me.crm.service;

import javax.servlet.http.HttpSession;

import com.me.crm.common.ServerResponse;
import com.me.crm.entity.User;

public interface IUserService {

	ServerResponse pageList(Integer page, Integer limit, User user);

	ServerResponse deleteById(Integer id);

	ServerResponse add(User user, String roles);

	ServerResponse deleteAll(String ids);

	ServerResponse update(User user, String roles);

	ServerResponse selectUserAndRoles(Integer userId);

	ServerResponse login(String name, String password, HttpSession session);

}
