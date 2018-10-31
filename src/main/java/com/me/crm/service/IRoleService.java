package com.me.crm.service;

import com.me.crm.common.ServerResponse;
import com.me.crm.entity.Role;

public interface IRoleService {

	ServerResponse deleteById(Integer id);

	ServerResponse deleteAll(String ids);

	ServerResponse add(Role role, String permissions);

	ServerResponse pageList(Integer page, Integer limit, Role role);

}
