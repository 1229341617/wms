package com._520it.wms.web.action;


import java.util.ArrayList;
import java.util.List;

import com._520it.wms.domain.SystemMenu;
import com._520it.wms.query.SystemMenuQueryObject;
import com._520it.wms.service.SystemMenuService;
import com._520it.wms.util.RequiredPermission;
import com._520it.wms.util.UserContext;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class SystemMenuAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	private SystemMenuService systemMenuService;
	private SystemMenu systemMenu = new SystemMenu();
	private SystemMenuQueryObject qo = new SystemMenuQueryObject();

	@RequiredPermission("系统菜单列表")
	@InputConfig(methodName="input")
	public String execute() throws Exception {
		try {
			putContext("pageResult", systemMenuService.advanceQuery(qo));
			putContext("menus", systemMenuService.queryMenusByParentId(qo));
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return LIST;
	}
	

	@RequiredPermission("系统菜单编辑")
	public String input() throws Exception {
		if(qo.getParentId() > 0){
			putContext("parentName", systemMenuService.get(qo.getParentId()).getName());
		}else {
			putContext("parentName", "根菜单");
		}
		if(systemMenu.getId() != null){
			systemMenu = systemMenuService.get(systemMenu.getId());
		}
		return INPUT;
	}
	
	
	@RequiredPermission("系统菜单保存或更新")
	public String saveOrUpdate() throws Exception {
		try {
			if(qo.getParentId() > 0){
				systemMenu.setParent(systemMenuService.get(qo.getParentId()));
			}else{
				systemMenu.setParent(null);
			}
			
			if(systemMenu.getId() != null){
				systemMenuService.update(systemMenu);
				addActionMessage("更新成功！");
			}else{
				systemMenuService.save(systemMenu);
				addActionMessage("保存成功！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return SUCCESS;
	}
	
	
	@RequiredPermission("系统菜单删除")
	public String delete() throws Exception {
		try {
			systemMenuService.delete(systemMenu.getId());
			putResponseText("删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			putResponseText(e.getMessage());
		}
		return NONE;
	}
	
	public String loadMenusByParentSn() throws Exception{
		List<Object> listMapJsons = new ArrayList<>();
		List<SystemMenu> menus = systemMenuService.getMenusByParentSnAndRoles(qo.getParentSn(), UserContext.getCurrentEmployee().getRoles());
		for (SystemMenu s : menus) {
			listMapJsons.add(s.toJson());
		}
		putJson(listMapJsons);
		
		return NONE;
	}
	
	public void prepareSaveOrUpdate() throws Exception{
		if(systemMenu.getId() != null){
			systemMenu = systemMenuService.get(systemMenu.getId());
		}
	}
	
	
	
	
	
	public SystemMenuService getSystemMenuService() {
		return systemMenuService;
	}

	public void setSystemMenuService(SystemMenuService systemMenuService) {
		this.systemMenuService = systemMenuService;
	}
	public SystemMenu getSystemMenu() {
		return systemMenu;
	}
	public void setSystemMenu(SystemMenu systemMenu) {
		this.systemMenu = systemMenu;
	}
	public SystemMenuQueryObject getQo() {
		return qo;
	}
	public void setQo(SystemMenuQueryObject qo) {
		this.qo = qo;
	}
}
