package com._520it.wms.domain;

import java.util.ArrayList;
import java.util.List;

public class Role extends BaseDomain{
	private String name;
	private String sn;
	private List<Permission> permissions = new ArrayList<>();
	private List<SystemMenu> menus = new ArrayList<>();
	
	
	
	public List<SystemMenu> getMenus() {
		return menus;
	}
	public void setMenus(List<SystemMenu> menus) {
		this.menus = menus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
}
