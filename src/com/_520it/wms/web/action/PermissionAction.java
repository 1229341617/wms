package com._520it.wms.web.action;

import com._520it.wms.domain.Permission;
import com._520it.wms.query.QueryObject;
import com._520it.wms.service.PermissionService;
import com._520it.wms.util.RequiredPermission;

public class PermissionAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	private PermissionService permissionService;
	private Permission permission = new Permission();
	private QueryObject qo = new QueryObject();

	@RequiredPermission("权限列表")
	public String execute() throws Exception {
		putContext("pageResult", permissionService.advanceQuery(qo));
		return LIST;
	}

	@RequiredPermission("权限删除")
	public String delete() throws Exception {
		permissionService.delete(permission.getId());
		putResponseText("删除成功！");
		return NONE;
	}
	
	@RequiredPermission("权限加载")
	public String reload(){
		permissionService.reload();
		return NONE;
	}
	
	
	public PermissionService getPermissionService() {
		return permissionService;
	}
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	public QueryObject getQo() {
		return qo;
	}
	public void setQo(QueryObject qo) {
		this.qo = qo;
	}
}
