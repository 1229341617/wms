package com._520it.wms.service;

import java.util.List;

import com._520it.wms.domain.TitleNum;

public interface TitleNumService {
	void save(TitleNum obj);
	
	void delete(Long id);
	
	void update(TitleNum obj);
	
	TitleNum get(Long id);
	
	List<TitleNum> findAll();
}
