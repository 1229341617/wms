package com._520it.wms.service;

import java.util.List;

import com._520it.wms.domain.Role;
import com._520it.wms.query.PageResult;
import com._520it.wms.query.QueryObject;

public interface RoleService {
	void save(Role obj);
	
	void delete(Long id);
	
	void update(Role obj);
	
	Role get(Long id);
	
	List<Role> findAll();
	
	PageResult advanceQuery(QueryObject qo);
}
