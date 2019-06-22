package com._520it.wms.service;

import java.util.List;

import com._520it.wms.domain.Permission;
import com._520it.wms.query.PageResult;
import com._520it.wms.query.QueryObject;

public interface PermissionService {
	void delete(Long id);
	
	Permission get(Long id);
	
	List<Permission> findAll();
	
	PageResult advanceQuery(QueryObject qo);
	
	void reload();
	
	void reloadByWill();
}
