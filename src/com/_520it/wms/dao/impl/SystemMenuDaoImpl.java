package com._520it.wms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com._520it.wms.dao.SystemMenuDao;
import com._520it.wms.domain.Role;
import com._520it.wms.domain.SystemMenu;

public class SystemMenuDaoImpl extends GenericDaoImpl<SystemMenu> implements SystemMenuDao{

	
	@Override
	public List<SystemMenu> findChildrenMenus() {
		return queryForList(" WHERE obj.parent IS NOT NULL");
	}
	
	@Override
	public List<SystemMenu> findMenusByParentSn(String parentSn) {
		return queryForList(" WHERE obj.parent.sn = ?", parentSn);
	}

	@Override
	public List<SystemMenu> getMenusByParentSnAndRoles(String parentSn,
			List<Role> roles) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "SELECT m FROM Role r JOIN r.menus m WHERE m.parent.sn = :parentSn AND r IN (:roles)";
		Query query = session.createQuery(hql);
		query.setParameter("parentSn", parentSn);
		query.setParameterList("roles", roles);
	
		return query.list();
	}
	
	
}
