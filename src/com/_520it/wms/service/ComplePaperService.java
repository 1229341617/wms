package com._520it.wms.service;

import java.util.List;

import com._520it.wms.domain.ComplePaper;
import com._520it.wms.query.ComplePaperQueryObject;
import com._520it.wms.query.PageResult;

public interface ComplePaperService {
	void save(ComplePaper complePaper);
	
	void delete(Long id);
	
	void update(ComplePaper complePaper);
	
	ComplePaper get(Long id);
	
	List<ComplePaper> findAll();
	
	PageResult advanceQuery(ComplePaperQueryObject qo);

	void batchCutPapers(List<Long> ids);
	
	PageResult filterPaperByStudent(PageResult pr);
}
