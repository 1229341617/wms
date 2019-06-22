package com._520it.wms.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com._520it.wms.dao.SystemMenuDao;
import com._520it.wms.domain.Role;
import com._520it.wms.domain.SystemMenu;
import com._520it.wms.query.PageResult;
import com._520it.wms.query.SystemMenuQueryObject;
import com._520it.wms.service.SystemMenuService;
import com._520it.wms.util.UserContext;
import com._520it.wms.vo.SystemMenuVo;

public class SystemMenuServiceImpl implements SystemMenuService{
	private SystemMenuDao systemMenuDao;

	@Override
	public void save(SystemMenu obj) {
		systemMenuDao.save(obj);
	}
	
	@Override
	public void delete(Long id) {
		SystemMenuQueryObject qo = new SystemMenuQueryObject();
		qo.setParentId(id);
		PageResult pageResult = systemMenuDao.advanceQuery(qo);
		if(pageResult.getResult().size() > 0){
			throw new RuntimeException("对不起，菜单正在被使用！");
		}else{
			systemMenuDao.delete(id);
		}
	}
	
	@Override
	public List<SystemMenu> findChildrenMenus() {
		return systemMenuDao.findChildrenMenus();
	}

	@Override
	public void update(SystemMenu obj) {
		systemMenuDao.update(obj);
	}

	@Override
	public SystemMenu get(Long id) {
		return systemMenuDao.get(id);
	}

	@Override
	public List<SystemMenu> findAll() {
		return systemMenuDao.findAll();
	}

	@Override
	public PageResult advanceQuery(SystemMenuQueryObject qo) {
		return systemMenuDao.advanceQuery(qo);
	}

	public SystemMenuDao getSystemMenuDao() {
		return systemMenuDao;
	}

	public void setSystemMenuDao(SystemMenuDao systemMenuDao) {
		this.systemMenuDao = systemMenuDao;
	}

	@Override
	public List<SystemMenuVo> queryMenusByParentId(SystemMenuQueryObject qo) {
		Long parentId = qo.getParentId();
		List<SystemMenuVo> menuvos = null;
		if(parentId > 0){
			menuvos = new ArrayList<>();
			queryMenuvos(menuvos, systemMenuDao.get(parentId));
			Collections.reverse(menuvos);
		}
		return menuvos;
	}

	private void queryMenuvos(List<SystemMenuVo> menus, SystemMenu currentMenu) {
		if(currentMenu != null){
			SystemMenuVo vo = new SystemMenuVo();
			vo.setId(currentMenu.getId());
			vo.setName(currentMenu.getName());
			menus.add(vo);
			queryMenuvos(menus, currentMenu.getParent());
		}
	}
	
	@Override
	public List<SystemMenu> getMenusByParentSn(String parentSn) {
		return systemMenuDao.findMenusByParentSn(parentSn);
	}

	@Override
	public List<SystemMenu> getMenusByParentSnAndRoles(String parentSn,
			List<Role> roles) {
//		if (UserContext.getCurrentEmployee().getAdmin()) {
//			return getMenusByParentSn(parentSn);
//		}else {
			return systemMenuDao.getMenusByParentSnAndRoles(parentSn, roles);
//		}
	}
	
}
