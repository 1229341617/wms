package com._520it.wms.service;

import java.util.List;

import com._520it.wms.domain.Subject;
import com._520it.wms.query.PageResult;
import com._520it.wms.query.SubjectQueryObject;

public interface SubjectService {
	void save(Subject subject);
	
	void delete(Long id);
	
	void update(Subject subject);
	
	Subject get(Long id);
	
	List<Subject> findAll();
	
	PageResult advanceQuery(SubjectQueryObject qo);
}
