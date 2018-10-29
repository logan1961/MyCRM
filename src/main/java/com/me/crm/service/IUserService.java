package com.me.crm.service;

import com.me.crm.common.ServerResponse;
import com.me.crm.entity.User;

public interface IUserService {

	ServerResponse pageList(Integer page, Integer limit, User user);

	ServerResponse deleteById(Integer id);

	ServerResponse add(User user);

	ServerResponse deleteAll(String ids);

}
