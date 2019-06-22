package com._520it.wms.web.action;

import com._520it.wms.service.EmployeeService;
import com._520it.wms.util.UserContext;

public class LoginAction extends BaseAction{
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private EmployeeService employeeService;
	
	@Override
	public String execute() throws Exception {
		try {
			if(UserContext.getCurrentEmployee() != null){
				return SUCCESS;
			}
			employeeService.checkLogin(username, password);
		} catch (Exception e) {
			super.addActionError(e.getMessage());
			return LOGIN;
		}
		return SUCCESS;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
}
