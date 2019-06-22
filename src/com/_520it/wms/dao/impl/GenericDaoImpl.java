package com._520it.wms.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com._520it.wms.dao.GenericDao;
import com._520it.wms.query.PageResult;
import com._520it.wms.query.QueryObject;

public class GenericDaoImpl<T> implements GenericDao<T>{
	protected SessionFactory sessionFactory;
	private Class<T> targetClass;
	
	public GenericDaoImpl(){
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		targetClass = (Class<T>) type.getActualTypeArguments()[0];
	}

	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public void save(T obj) {
		Session session = sessionFactory.getCurrentSession();
		session.save(obj);
	}

	@Override
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		T obj = get(id);
		session.delete(obj);
	}

	@Override
	public void update(T obj) {
		Session session = sessionFactory.getCurrentSession();
		session.update(obj);
	}

	@Override
	public T get(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (T) session.get(targetClass, id);
	}

	@Override
	public List<T> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(targetClass).list();
	}
	
	@Override
	public PageResult advanceQuery(QueryObject qo) {
		Integer pageSize = qo.getPageSize();
		Integer currentPage = qo.getCurrentPage();
		Session session = sessionFactory.getCurrentSession();
		
		String countHql = "SELECT COUNT(obj) FROM "+targetClass.getSimpleName()+" obj" + qo.getQuery();
		Query query = session.createQuery(countHql);
		List<Object> parameters = qo.getParameters();
		setParameters(query, parameters);
		
		Integer totalCount = ((Long)query.uniqueResult()).intValue();
		//1.若查询结果为0条，则返回含空集的PageResult
		if(totalCount == 0){
			return PageResult.empty(pageSize);
		}
		
		String resultHql = "FROM "+targetClass.getSimpleName()+" obj" + qo.getQuery();
		query = session.createQuery(resultHql);
		setParameters(query, parameters);
		
		//2.若出现当前页和页尺寸非法，则全部查出
		if(currentPage > 0 && pageSize > 0){
			query.setFirstResult((currentPage - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		List result = query.list();
		return new PageResult(totalCount, result, pageSize, currentPage);
	}
	
	@Override
	public List<T> queryForList(Integer pageSize, Integer currentPage,
			String conditions, Object... params) {
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "FROM "+targetClass.getSimpleName()+" obj";
		if(params.length > 0){
			hql += conditions;
		}
		Query query = session.createQuery(hql);
		for (int index = 0; index < params.length; index++) {
			query.setParameter(index, params[index]);
		}
		
		if(pageSize > 0 && currentPage > 0){
			query.setFirstResult((currentPage - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		
		return query.list();
	}
	
	@Override
	public List<T> queryForList(String conditions) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM "+targetClass.getSimpleName()+" obj ";
		hql += conditions;
		Query query = session.createQuery(hql);
		
		return query.list();
	}

	@Override
	public List<T> queryForList(String conditions, Object... params) {
		return queryForList(0, 0, conditions, params);
	}
	
	@Override
	public T queryForObject(String conditions, Object... params) {
		 List<T> list = queryForList(conditions, params);
		 return list.size() == 1 ? list.get(0) : null;
	}
	

	private void setParameters(Query query, List<Object> parameters) {
		for (int index = 0; index < parameters.size(); index++) {
			query.setParameter(index, parameters.get(index));
		}
	}

	@Override
	public void batchDelete(List<Long> ids) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "DELETE FROM "+targetClass.getSimpleName()+" obj WHERE obj.id IN (:ids)";
		System.out.println("hql:" + hql);
		Query query = session.createQuery(hql);
		query.setParameterList("ids", ids);
		query.executeUpdate();
	}
}
