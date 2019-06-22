package com._520it.wms.web.action;

import com._520it.wms.util.UserContext;

public class LogoutAction extends BaseAction{
	private static final long serialVersionUID = -3975228156236286434L;

	@Override
	public String execute() throws Exception {
		UserContext.setEmployee(null);
		UserContext.setLoginName(null);
		UserContext.setPermissions(null);
		return SUCCESS;
	}
	
}
