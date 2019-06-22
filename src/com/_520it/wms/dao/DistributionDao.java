package com._520it.wms.dao;

import java.util.List;

import com._520it.wms.domain.Distribution;

public interface DistributionDao extends GenericDao<Distribution>{
	
	List<Distribution> getDistributionsByTeacherId(Long teacherid);
	
}
