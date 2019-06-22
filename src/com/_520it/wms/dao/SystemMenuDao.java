package com._520it.wms.dao;

import java.util.List;

import com._520it.wms.domain.Role;
import com._520it.wms.domain.SystemMenu;

public interface SystemMenuDao extends GenericDao<SystemMenu>{

	List<SystemMenu> findChildrenMenus();

	List<SystemMenu> findMenusByParentSn(String parentSn);

	List<SystemMenu> getMenusByParentSnAndRoles(String parentSn,
			List<Role> roles);
	
}
