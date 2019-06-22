package com._520it.wms.service;

import java.util.List;

import com._520it.wms.domain.CutPaper;
import com._520it.wms.query.CutPaperQueryObject;
import com._520it.wms.query.PageResult;
import com._520it.wms.vo.CutPaperVo;

public interface CutPaperService {
	void save(CutPaper cutPaper);
	
	void delete(Long id);
	
	void update(CutPaper cutPaper);
	
	CutPaper get(Long id);
	
	List<CutPaper> findAll();
	
	PageResult advanceQuery(CutPaperQueryObject qo);
	
	List<CutPaperVo> queryCutPapersByParentId(CutPaperQueryObject qo);
	
	List<CutPaper> filterRoleTitleNums(List<CutPaper> cutPapers);
}
