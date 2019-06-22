package com._520it.wms.service;

import java.util.List;

import com._520it.wms.domain.Department;
import com._520it.wms.query.PageResult;
import com._520it.wms.query.QueryObject;

public interface DepartmentService {
	void save(Department obj);
	
	void delete(Long id);
	
	void update(Department obj);
	
	Department get(Long id);
	
	List<Department> findAll();
	
	PageResult advanceQuery(QueryObject qo);
}
