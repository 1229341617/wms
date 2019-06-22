package com._520it.wms.util;

import java.util.Set;

import com._520it.wms.domain.Employee;
import com.opensymphony.xwork2.ActionContext;

public class UserContext {
	public static final String USER_IN_SESSION = "user_in_session";
	public static final String USERNAME_IN_SESSION = "username_in_session";
	public static final String PERMISSION_IN_SESSION = "permissions_in_session";
	
	
	
	public static void setEmployee(Employee current) {
		if(current != null){
			ActionContext.getContext().getSession().put(USER_IN_SESSION, current);
		}else{
			ActionContext.getContext().getSession().put(USER_IN_SESSION, null);
		}
	}

	public static void setLoginName(String username) {
		if(username != null && !username.trim().equals("")){
			ActionContext.getContext().getSession().put(USERNAME_IN_SESSION, username);
		}else{
			ActionContext.getContext().getSession().put(USERNAME_IN_SESSION, null);
		}
	}

	public static void setPermissions(Set<String> permissionSet) {
		ActionContext.getContext().getSession().put(PERMISSION_IN_SESSION, permissionSet);
	}

	public static Employee getCurrentEmployee() {
		return (Employee) ActionContext.getContext().getSession().get(USER_IN_SESSION);
	}

	public static Set<String> getCurrentExpressions() {
		return (Set<String>) ActionContext.getContext().getSession().get(PERMISSION_IN_SESSION);
	}

}
