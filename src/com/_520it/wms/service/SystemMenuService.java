package com._520it.wms.service;

import java.util.List;

import com._520it.wms.domain.Role;
import com._520it.wms.domain.SystemMenu;
import com._520it.wms.query.PageResult;
import com._520it.wms.query.SystemMenuQueryObject;
import com._520it.wms.vo.SystemMenuVo;

public interface SystemMenuService {
	void save(SystemMenu systemMenu);
	
	void delete(Long id);
	
	void update(SystemMenu systemMenu);
	
	SystemMenu get(Long id);
	
	List<SystemMenu> findAll();
	
	PageResult advanceQuery(SystemMenuQueryObject qo);

	List<SystemMenuVo> queryMenusByParentId(SystemMenuQueryObject qo);

	List<SystemMenu> findChildrenMenus();

	List<SystemMenu> getMenusByParentSn(String parentSn);

	List<SystemMenu> getMenusByParentSnAndRoles(String parentSn,
			List<Role> roles);

}
