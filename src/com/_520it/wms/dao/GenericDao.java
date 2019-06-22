package com._520it.wms.dao;

import java.util.List;

import com._520it.wms.query.PageResult;
import com._520it.wms.query.QueryObject;

public interface GenericDao<T> {
	void save(T obj);
	
	void delete(Long id);
	
	void update(T obj);
	
	T get(Long id);
	
	List<T> findAll();
	
	PageResult advanceQuery(QueryObject qo);
	
	List<T> queryForList(Integer pageSize, Integer currentPage, String conditions, Object... params);
	
	List<T> queryForList(String conditions, Object... params);
	
	List<T> queryForList(String conditions);
	
	T queryForObject(String conditions, Object... params);
	
	void batchDelete(List<Long> ids);
}
