package com._520it.wms.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com._520it.wms.dao.EmployeeDao;
import com._520it.wms.domain.Employee;
import com._520it.wms.domain.Permission;
import com._520it.wms.domain.Role;
import com._520it.wms.query.EmployeeQueryObject;
import com._520it.wms.query.PageResult;
import com._520it.wms.service.EmployeeService;
import com._520it.wms.util.MD5;
import com._520it.wms.util.UserContext;

public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDao employeeDao;

	@Override
	public void save(Employee obj) {
		MD5 md5 = new MD5();
		md5.Init();
		md5.Update(obj.getPassword());
		
		obj.setPassword(md5.asHex());
		employeeDao.save(obj);
	}

	@Override
	public void delete(Long id) {
		employeeDao.delete(id);
	}

	@Override
	public void update(Employee obj) {
		employeeDao.update(obj);
	}

	@Override
	public Employee get(Long id) {
		return employeeDao.get(id);
	}

	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}
	
	@Override
	public List<Employee> getAndFilterByRoleName(String roleName) {
		List<Employee> emps = employeeDao.findAll();
		if(emps != null) {
			for (int i = 0; emps != null && i < emps.size(); i++) {
				if(!emps.get(i).getRoleNames().contains(roleName)){
					emps.remove(i);
					i--;
				}
			}
		}
		
		return emps;
	}
	
	
	
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public List<Employee> query(EmployeeQueryObject qo) {
		return employeeDao.query(qo);
	}

	@Override
	public PageResult query(Integer currentPage, Integer pageSize) {
		return employeeDao.query(currentPage, pageSize);
	}

	@Override
	public PageResult query(EmployeeQueryObject qo, Integer currentPage,
			Integer pageSize) {
		return employeeDao.query(qo, currentPage, pageSize);
	}

	@Override
	public PageResult advanceQuery(EmployeeQueryObject qo) {
		return employeeDao.advanceQuery(qo);
	}

	@Override
	public List<Employee> queryForList(Integer pageSize, Integer currentPage,
			String conditions, Object... params) {
		return employeeDao.queryForList(pageSize, currentPage, conditions, params);
	}

	@Override
	public List<Employee> queryForList(String conditions, Object... params) {
		return employeeDao.queryForList(conditions, params);
	}

	@Override
	public Employee queryForObject(String conditions, Object... params) {
		return employeeDao.queryForObject(conditions, params);
	}

	@Override
	public void checkLogin(String username, String password) {
		MD5 md5 = new MD5();
		md5.Init();
		md5.Update(password);
		Employee current = employeeDao.login(username, md5.asHex());
		if(current == null){
			throw new RuntimeException("用户名或密码错误,请重新输入！");
		}
		UserContext.setEmployee(current);
		UserContext.setLoginName(username);
		Set<String> permissionSet = new HashSet<>();
		List<Role> roles = current.getRoles();
		for (Role role : roles) {
			List<Permission> permissions = role.getPermissions();
			for (Permission p : permissions) {
				permissionSet.add(p.getExpression());
			}
		}
		UserContext.setPermissions(permissionSet);
	}

	@Override
	public void batchDelete(List<Long> ids) {
		employeeDao.batchDelete(ids);
	}

}
