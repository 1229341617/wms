package com._520it.wms.domain;

import com._520it.wms.util.ClassZhName;

@ClassZhName("科目")
public class Subject extends BaseDomain {
	private String name;
	private String sn;
	
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
}
