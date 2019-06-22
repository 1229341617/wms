package com._520it.wms.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com._520it.wms.dao.CutPaperDao;
import com._520it.wms.domain.CutPaper;

public class CutPaperDaoImpl extends GenericDaoImpl<CutPaper> implements CutPaperDao{

	@Override
	public List<CutPaper> getCutPapersByComplePaperId(Long complepaperid) {
		String hql = "select obj FROM "+CutPaper.class.getSimpleName()+" obj WHERE obj.complepaper.id = (:complepaperid) and obj.parent != null";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("complepaperid", complepaperid);
		List<CutPaper> list = query.list();
		
		return list != null && list.size() > 0 ? list : null;
	}

	@Override
	public CutPaper getRootCutPaperBySubject(Long subjectid) {
		String hql = "select obj FROM "+CutPaper.class.getSimpleName()+" obj WHERE obj.complepaper.subject.id = (:subjectid) and obj.parent = null";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("subjectid", subjectid);
		List<CutPaper> list = query.list();
		
		return list != null && list.size() > 0 ? list.get(0) : null;
	}
	
}
