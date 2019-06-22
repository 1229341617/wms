package com._520it.wms.service.impl;

import java.util.List;

import com._520it.wms.dao.DepartmentDao;
import com._520it.wms.domain.Department;
import com._520it.wms.query.PageResult;
import com._520it.wms.query.QueryObject;
import com._520it.wms.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService{
	private DepartmentDao departmentDao;

	@Override
	public void save(Department obj) {
		departmentDao.save(obj);
	}

	@Override
	public void delete(Long id) {
		departmentDao.delete(id);
	}

	@Override
	public void update(Department obj) {
		departmentDao.update(obj);
	}

	@Override
	public Department get(Long id) {
		return departmentDao.get(id);
	}

	@Override
	public List<Department> findAll() {
		return departmentDao.findAll();
	}
	
	
	
	
	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public PageResult advanceQuery(QueryObject qo) {
		return departmentDao.advanceQuery(qo);
	}

}
