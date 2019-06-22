package com._520it.wms.query;

import com._520it.wms.util.StrUtil;

public class EmployeeQueryObject extends QueryObject{
	private String keyword;
	private Long deptId;
	

	
	
	@Override
	public void customizedQuery() {
		if(StrUtil.hasLength(keyword)){
			String key = "%" + keyword + "%";
			addQuery("(obj.name LIKE ? or obj.email LIKE ?)", key, key);
		}
		if(deptId != null && deptId != -1){
			addQuery("obj.dept.id = ?", deptId);
		}
	}
	
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
}
