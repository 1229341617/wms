package com._520it.wms.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com._520it.wms.dao.TitleNumDao;
import com._520it.wms.domain.TitleNum;

public class TitleNumDaoImpl extends GenericDaoImpl<TitleNum> implements TitleNumDao{

	@Override
	public TitleNum getTitleNumByNum(int num) {
		String hql = "select obj FROM "+TitleNum.class.getSimpleName()+" obj WHERE obj.titlenum=" + num;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<TitleNum> list = query.list();
		
		return list != null && list.size() > 0 ? list.get(0) : null;
	}
	
}
