package com._520it.wms.service;

import java.util.List;

import com._520it.wms.domain.Distribution;
import com._520it.wms.query.PageResult;
import com._520it.wms.query.DistributionQueryObject;

public interface DistributionService {
	void save(Distribution distribution);
	
	void delete(Long id);
	
	void update(Distribution distribution);
	
	Distribution get(Long id);
	
	List<Distribution> findAll();
	
	PageResult advanceQuery(DistributionQueryObject qo);
}
