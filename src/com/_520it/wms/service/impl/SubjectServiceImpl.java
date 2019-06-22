package com._520it.wms.service.impl;

import java.util.List;

import com._520it.wms.dao.SubjectDao;
import com._520it.wms.domain.Subject;
import com._520it.wms.query.PageResult;
import com._520it.wms.query.SubjectQueryObject;
import com._520it.wms.service.SubjectService;

public class SubjectServiceImpl implements SubjectService{
	private SubjectDao subjectDao;

	@Override
	public void save(Subject obj) {
		subjectDao.save(obj);
	}

	@Override
	public void delete(Long id) {
		subjectDao.delete(id);
	}

	@Override
	public void update(Subject obj) {
		subjectDao.update(obj);
	}

	@Override
	public Subject get(Long id) {
		return subjectDao.get(id);
	}

	@Override
	public List<Subject> findAll() {
		return subjectDao.findAll();
	}

	@Override
	public PageResult advanceQuery(SubjectQueryObject qo) {
		return subjectDao.advanceQuery(qo);
	}

	public SubjectDao getSubjectDao() {
		return subjectDao;
	}

	public void setSubjectDao(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}

}
