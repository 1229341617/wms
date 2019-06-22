package com._520it.wms.service.impl;

import java.util.List;

import com._520it.wms.dao.ExamDao;
import com._520it.wms.domain.Exam;
import com._520it.wms.query.PageResult;
import com._520it.wms.query.ExamQueryObject;
import com._520it.wms.service.ExamService;

public class ExamServiceImpl implements ExamService{
	private ExamDao examDao;

	@Override
	public void save(Exam obj) {
		examDao.save(obj);
	}

	@Override
	public void delete(Long id) {
		examDao.delete(id);
	}

	@Override
	public void update(Exam obj) {
		examDao.update(obj);
	}

	@Override
	public Exam get(Long id) {
		return examDao.get(id);
	}

	@Override
	public List<Exam> findAll() {
		return examDao.findAll();
	}

	@Override
	public PageResult advanceQuery(ExamQueryObject qo) {
		return examDao.advanceQuery(qo);
	}

	public ExamDao getExamDao() {
		return examDao;
	}

	public void setExamDao(ExamDao examDao) {
		this.examDao = examDao;
	}

}
