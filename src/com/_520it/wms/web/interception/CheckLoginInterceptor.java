package com._520it.wms.web.interception;

import com._520it.wms.domain.Employee;
import com._520it.wms.util.UserContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckLoginInterceptor extends AbstractInterceptor{
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Employee emp = UserContext.getCurrentEmployee();
		String actionName = invocation.getProxy().getActionName();
		if(emp != null || actionName.equals("login")){
			return invocation.invoke();
		}
		
		return Action.LOGIN;
	}

}
