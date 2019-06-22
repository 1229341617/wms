package com._520it.wms.service;

import java.util.List;

import com._520it.wms.domain.Exam;
import com._520it.wms.query.PageResult;
import com._520it.wms.query.ExamQueryObject;

public interface ExamService {
	void save(Exam exam);
	
	void delete(Long id);
	
	void update(Exam exam);
	
	Exam get(Long id);
	
	List<Exam> findAll();
	
	PageResult advanceQuery(ExamQueryObject qo);
}
