package com._520it.wms.domain;

public class TitleNum extends BaseDomain {
	private int titlenum;
	private Subject subject;

	
	public TitleNum() {
		
	}

	public TitleNum(int titlenum, Subject subject) {
		this.titlenum = titlenum;
		this.subject = subject;
	}
	
	
	
	public int getTitlenum() {
		return titlenum;
	}
	public void setTitlenum(int titlenum) {
		this.titlenum = titlenum;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
}
