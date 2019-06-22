package com._520it.wms.service.impl;

import java.util.List;

import com._520it.wms.dao.DistributionDao;
import com._520it.wms.domain.Distribution;
import com._520it.wms.query.DistributionQueryObject;
import com._520it.wms.query.PageResult;
import com._520it.wms.service.DistributionService;

public class DistributionServiceImpl implements DistributionService{
	private DistributionDao distributionDao;

	@Override
	public void save(Distribution obj) {
		distributionDao.save(obj);
	}

	@Override
	public void delete(Long id) {
		distributionDao.delete(id);
	}

	@Override
	public void update(Distribution obj) {
		distributionDao.update(obj);
	}
	
	@Override
	public Distribution get(Long id) {
		return distributionDao.get(id);
	}

	@Override
	public List<Distribution> findAll() {
		return distributionDao.findAll();
	}

	@Override
	public PageResult advanceQuery(DistributionQueryObject qo) {
		return distributionDao.advanceQuery(qo);
	}

	public DistributionDao getDistributionDao() {
		return distributionDao;
	}

	public void setDistributionDao(DistributionDao distributionDao) {
		this.distributionDao = distributionDao;
	}
}
