package com._520it.wms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com._520it.wms.dao.EmployeeDao;
import com._520it.wms.domain.Employee;
import com._520it.wms.query.EmployeeQueryObject;
import com._520it.wms.query.PageResult;

public class EmployeeDaoImpl extends GenericDaoImpl<Employee> implements EmployeeDao{
	@Override
	public List<Employee> query(EmployeeQueryObject qo) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Employee obj" + qo.getQuery();
		Query query = session.createQuery(hql);
		List<Object> parameters = qo.getParameters();
		
		System.out.println("hql:" + hql);
		System.out.println("parameters:" + qo.getParameters());
		
		setParameters(query, parameters);
		
		return query.list();
	}

	@Override
	public PageResult query(Integer currentPage, Integer pageSize) {
		Session session = sessionFactory.getCurrentSession();
		String countHql = "SELECT COUNT(obj) FROM Employee obj";
		Query query = session.createQuery(countHql);
		Integer totalCount = ((Long)query.uniqueResult()).intValue();
		if(totalCount == 0){
			return PageResult.empty(pageSize);
		}
		
		String resultHql = "FROM Employee obj";
		query = session.createQuery(resultHql);
		if(currentPage > 0 && pageSize > 0){
			query.setFirstResult((currentPage - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		List result = query.list();
		
		return new PageResult(totalCount, result, pageSize, currentPage);
	}
	
	@Override
	public PageResult query(EmployeeQueryObject qo, Integer currentPage, Integer pageSize) {
		Session session = sessionFactory.getCurrentSession();
		String countHql = "SELECT COUNT(obj) FROM Employee obj" + qo.getQuery();
		Query query = session.createQuery(countHql);
		List<Object> parameters = qo.getParameters();
		setParameters(query, parameters);
		
		Integer totalCount = ((Long)query.uniqueResult()).intValue();
		if(totalCount == 0){
			return PageResult.empty(pageSize);
		}
		
		String resultHql = "FROM Employee obj" + qo.getQuery();
		query = session.createQuery(resultHql);
		setParameters(query, parameters);
		
		if(currentPage > 0 && pageSize > 0){
			query.setFirstResult((currentPage - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		List result = query.list();
		
		return new PageResult(totalCount, result, pageSize, currentPage);
	}

	private void setParameters(Query query, List<Object> parameters) {
		for (int index = 0; index < parameters.size(); index++) {
			query.setParameter(index, parameters.get(index));
		}
	}

	@Override
	public Employee login(String username, String password) {
		return queryForObject(" WHERE obj.name = ? AND obj.password = ?", username, password);
	}
}
