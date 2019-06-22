package com._520it.wms.dao;

import java.util.List;

import com._520it.wms.domain.CutPaper;

public interface CutPaperDao extends GenericDao<CutPaper>{
	List<CutPaper> getCutPapersByComplePaperId(Long complepaperId);

	CutPaper getRootCutPaperBySubject(Long subjectid);
}
