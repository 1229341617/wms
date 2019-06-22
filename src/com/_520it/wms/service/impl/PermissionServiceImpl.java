package com._520it.wms.service.impl;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com._520it.wms.dao.PermissionDao;
import com._520it.wms.domain.Permission;
import com._520it.wms.query.PageResult;
import com._520it.wms.query.QueryObject;
import com._520it.wms.service.PermissionService;
import com._520it.wms.util.PermissionUtil;
import com._520it.wms.util.RequiredPermission;
import com._520it.wms.web.action.BaseAction;

public class PermissionServiceImpl implements PermissionService, ApplicationContextAware{
	private PermissionDao permissionDao;
	private ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		this.ctx = ctx;
	}

	@Override
	public void delete(Long id) {
		permissionDao.delete(id);
	}

	@Override
	public Permission get(Long id) {
		return permissionDao.get(id);
	}

	@Override
	public List<Permission> findAll() {
		return permissionDao.findAll();
	}
	
	@Override
	public PageResult advanceQuery(QueryObject qo) {
		return permissionDao.advanceQuery(qo);
	}

	@Override
	public void reload() {
		//0.将数据库中的权限表达式加载到pSet集合中
		List<Permission> permissions = permissionDao.findAll();
		Set<String> pSet = new HashSet<>();
		for (Permission permission : permissions) {
			pSet.add(permission.getExpression());
		}
		//1.扫描BaseAction并得到所有子类map
		Map<String, BaseAction> actionMap = ctx.getBeansOfType(BaseAction.class);
		Set<Entry<String, BaseAction>> entrySet = actionMap.entrySet();
		for (Entry<String, BaseAction> entry : entrySet) {
			Class<? extends BaseAction> actionClz = entry.getValue().getClass();
			//2.获取每一个Action类中的所有方法
			Method[] methods = actionClz.getDeclaredMethods();
			for (int i = 0; i < methods.length; i++) {
				//3.判断pSet(数据库中)集合中是否存在该权限表达式，若否，则保存
				String expression = PermissionUtil.buidPermission(methods[i]);
				if(!pSet.contains(expression)){
					if (methods[i].isAnnotationPresent(RequiredPermission.class)) {
						String value = methods[i].getAnnotation(RequiredPermission.class).value();
						//4.每次遇到RequiredPermission的方法，都创建出Permission对象，并设置name和expression
						Permission permission = new Permission();
						permission.setName(value);
						permission.setExpression(expression);
						//5.调用permissionDao.save(权限对象）；
						permissionDao.save(permission);
					}
				}
			}
		}
	}
	
	@Override
	public void reloadByWill(){
		List<Permission> permissions = permissionDao.findAll();
		Set<String> pSet = new HashSet<>();
		for (Permission permission : permissions) {
			pSet.add(permission.getExpression());
		}
		Map<String, BaseAction> actionMap = ctx.getBeansOfType(BaseAction.class);
		Collection<BaseAction> actions = actionMap.values();
		for (BaseAction action : actions) {
			Method[] ms = action.getClass().getDeclaredMethods();
			for (Method m : ms) {
				String exp = PermissionUtil.buidPermission(m);
				if(!pSet.contains(exp)){
					RequiredPermission rp = m.getAnnotation(RequiredPermission.class);
					if(rp != null){
						String name = rp.value();
						Permission permission = new Permission();
						permission.setName(name);
						permission.setExpression(exp);
						permissionDao.save(permission);
					}
				}
			}
		}
	}
	
	
	public PermissionDao getPermissionDao() {
		return permissionDao;
	}

	public void setPermissionDao(PermissionDao permissionDao) {
		this.permissionDao = permissionDao;
	}
}
