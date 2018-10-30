package com.me.crm.service;

import com.me.crm.common.ServerResponse;
import com.me.crm.entity.Permission;

public interface IPermissionService {

	ServerResponse pageList(Integer page, Integer limit, Permission permission);

	ServerResponse deleteById(Integer id);

	ServerResponse deleteAll(String ids);

	ServerResponse add(Permission permission);

}
