package com._520it.wms.web.action;

import com._520it.wms.domain.Role;
import com._520it.wms.query.QueryObject;
import com._520it.wms.service.PermissionService;
import com._520it.wms.service.RoleService;
import com._520it.wms.service.SystemMenuService;
import com._520it.wms.util.RequiredPermission;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class RoleAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	private RoleService roleService;
	private PermissionService permissionService;
	private SystemMenuService systemMenuService;
	private Role role = new Role();
	private QueryObject qo = new QueryObject();

	@RequiredPermission("角色列表")
	@InputConfig(methodName="input")
	public String execute() throws Exception {
		try {
			putContext("pageResult", roleService.advanceQuery(qo));
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return LIST;
	}
	
	
	@RequiredPermission("角色编辑")
	public String input() throws Exception {
		putContext("menus",systemMenuService.findChildrenMenus());
		if(role.getId() != null){
			role = roleService.get(role.getId());
		}
		putContext("permissions", permissionService.findAll());
		return INPUT;
	}
	
	@RequiredPermission("角色保存或更新")
	public String saveOrUpdate() throws Exception {
		try {
			if(role.getId() != null){
				roleService.update(role);
				addActionMessage("更新成功！");
			}else{
				roleService.save(role);
				addActionMessage("保存成功！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return SUCCESS;
	}
	
	@RequiredPermission("角色删除")
	public String delete() throws Exception {
		roleService.delete(role.getId());
		putResponseText("删除成功！");
		return NONE;
	}
	
	public void prepareSaveOrUpdate() throws Exception{
		if(role.getId() != null){
			role = roleService.get(role.getId());
		}
		role.getPermissions().clear();
		role.getMenus().clear();
	}
	
	
	
	public SystemMenuService getSystemMenuService() {
		return systemMenuService;
	}
	public void setSystemMenuService(SystemMenuService systemMenuService) {
		this.systemMenuService = systemMenuService;
	}
	
	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public QueryObject getQo() {
		return qo;
	}
	public void setQo(QueryObject qo) {
		this.qo = qo;
	}
	public PermissionService getPermissionService() {
		return permissionService;
	}
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}
}
