package com._520it.wms.dao;

import java.util.List;

import com._520it.wms.domain.Employee;
import com._520it.wms.query.EmployeeQueryObject;
import com._520it.wms.query.PageResult;


public interface EmployeeDao extends GenericDao<Employee>{
	List<Employee> query(EmployeeQueryObject qo);
	
	PageResult query(Integer currentPage, Integer pageSize);
	
	PageResult query(EmployeeQueryObject qo, Integer currentPage, Integer pageSize);

	Employee login(String username, String password);
}
