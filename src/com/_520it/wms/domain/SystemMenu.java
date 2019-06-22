package com._520it.wms.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com._520it.wms.util.ClassZhName;

@ClassZhName("系统菜单")
public class SystemMenu extends BaseDomain implements IJsonObject{
	private String name;//菜单名称
	private String sn;//菜单编号:父菜单有，子菜单没有，用来加载自己的子菜单
	private String url;//菜单链接，子菜单拥有，父菜单没有
	private SystemMenu parent;//上级菜单
	private List<System> children = new ArrayList<>();//下级菜单
	
	@Override
	public Object toJson() {
		Map<String, Object> mapJson = new HashMap<String, Object>();
		mapJson.put("id", id);
		mapJson.put("name", name);
		mapJson.put("action", url);
		mapJson.put("pId", parent.getId());
		
		return mapJson;
	}
	
	public String getParentName(){
		if(parent == null){
			return "根菜单";
		}
		return parent.getName();
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public SystemMenu getParent() {
		return parent;
	}
	public void setParent(SystemMenu parent) {
		this.parent = parent;
	}
	public List<System> getChildren() {
		return children;
	}
	public void setChildren(List<System> children) {
		this.children = children;
	}
}
