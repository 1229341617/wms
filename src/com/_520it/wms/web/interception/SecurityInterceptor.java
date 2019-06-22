package com._520it.wms.web.interception;

import java.lang.reflect.Method;
import java.util.Set;

import com._520it.wms.domain.Employee;
import com._520it.wms.util.PermissionUtil;
import com._520it.wms.util.RequiredPermission;
import com._520it.wms.util.UserContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SecurityInterceptor extends AbstractInterceptor{
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//1.如果是管理员或者是登录，直接放行
		Employee emp = UserContext.getCurrentEmployee();
		if((emp != null && emp.getAdmin())){
			return invocation.invoke();
		}
		//2.如果当前请求的action方法中无RequiredPermission注解，直接放行
		//3.如果当前请求的action方法上的注解value包含在session中，直接放行，负责不放行
		String methodName = invocation.getProxy().getMethod();
		Method method = invocation.getAction().getClass().getDeclaredMethod(methodName);
		if(!method.isAnnotationPresent(RequiredPermission.class)){
			return invocation.invoke();
		}else{
			RequiredPermission rp = method.getAnnotation(RequiredPermission.class);
			Set<String> expressions = UserContext.getCurrentExpressions();
			String currentPermission = PermissionUtil.buidPermission(method);
			if(expressions.contains(currentPermission)){
				return invocation.invoke();
			}else{
				return "nopermission";
			}
		}
	}
	
	

}
