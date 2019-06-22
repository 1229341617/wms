package com._520it.wms.service.impl;

import java.util.List;

import com._520it.wms.dao.RoleDao;
import com._520it.wms.domain.Role;
import com._520it.wms.query.PageResult;
import com._520it.wms.query.QueryObject;
import com._520it.wms.service.RoleService;

public class RoleServiceImpl implements RoleService{
	private RoleDao roleDao;

	@Override
	public void save(Role obj) {
		roleDao.save(obj);
	}

	@Override
	public void delete(Long id) {
		roleDao.delete(id);
	}

	@Override
	public void update(Role obj) {
		roleDao.update(obj);
	}

	@Override
	public Role get(Long id) {
		return roleDao.get(id);
	}

	@Override
	public List<Role> findAll() {
		return roleDao.findAll();
	}

	@Override
	public PageResult advanceQuery(QueryObject qo) {
		return roleDao.advanceQuery(qo);
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

}
