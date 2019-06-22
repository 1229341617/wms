package com._520it.wms.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com._520it.wms.dao.DistributionDao;
import com._520it.wms.domain.Distribution;

public class DistributionDaoImpl extends GenericDaoImpl<Distribution> implements DistributionDao{

	@Override
	public List<Distribution> getDistributionsByTeacherId(Long teacherid) {
		String hql = "select obj FROM "+Distribution.class.getSimpleName()+" obj WHERE obj.teacher.id=" + teacherid;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Distribution> list = query.list();
		
		return list != null && list.size() > 0 ? list : null;
	}
	
}
