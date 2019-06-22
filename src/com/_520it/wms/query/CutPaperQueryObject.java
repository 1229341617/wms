package com._520it.wms.query;

public class CutPaperQueryObject extends QueryObject{
	private Long parentId = -1L;
	private String parentSn;
	

	@Override
	public void customizedQuery() {
		if(parentId > 0){ 
			addQuery("obj.parent.id = ?", parentId);
		}else{
			addQuery("obj.parent IS NULL");
		}
	}
	
	public String getParentSn() {
		return parentSn;
	}
	public void setParentSn(String parentSn) {
		this.parentSn = parentSn;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
}
