package com._520it.wms.service;

import java.util.List;

import com._520it.wms.domain.Employee;
import com._520it.wms.query.EmployeeQueryObject;
import com._520it.wms.query.PageResult;

public interface EmployeeService {
	void save(Employee obj);
	
	void delete(Long id);
	
	void update(Employee obj);
	
	Employee get(Long id);
	
	List<Employee> findAll();
	
	List<Employee> query(EmployeeQueryObject qo);
	
	PageResult query(Integer currentPage, Integer pageSize);
	
	PageResult query(EmployeeQueryObject qo, Integer currentPage, Integer pageSize);
	
	PageResult advanceQuery(EmployeeQueryObject qo);
	
	List<Employee> queryForList(Integer pageSize, Integer currentPage,
			String conditions, Object... params);
	
	List<Employee> queryForList(String conditions, Object... params);
	
	Employee queryForObject(String conditions, Object... params);

	void checkLogin(String username, String password);
	
	void batchDelete(List<Long> ids);
	
	public List<Employee> getAndFilterByRoleName(String roleName);
}
