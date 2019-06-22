package com._520it.wms.service.impl;

import java.util.List;

import com._520it.wms.dao.TitleNumDao;
import com._520it.wms.domain.TitleNum;
import com._520it.wms.service.TitleNumService;

public class TitleNumServiceImpl implements TitleNumService{
	private TitleNumDao titleNumDao;
	

	@Override
	public void save(TitleNum obj) {
		titleNumDao.save(obj);
	}

	@Override
	public void delete(Long id) {
		titleNumDao.delete(id);
	}

	@Override
	public void update(TitleNum obj) {
		titleNumDao.update(obj);
	}

	@Override
	public TitleNum get(Long id) {
		return titleNumDao.get(id);
	}

	@Override
	public List<TitleNum> findAll() {
		return titleNumDao.findAll();
	}

	public TitleNumDao getTitleNumDao() {
		return titleNumDao;
	}

	public void setTitleNumDao(TitleNumDao titleNumDao) {
		this.titleNumDao = titleNumDao;
	}
}
