package com._520it.wms.domain;

import java.util.Date;

import com._520it.wms.util.ClassZhName;

@ClassZhName("考试")
public class Exam extends BaseDomain{
	private String name;
	private int totaltimes;
	private Date startdate;
	private Date enddate;
	private Subject subject;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotaltimes() {
		return totaltimes;
	}
	public void setTotaltimes(int totaltimes) {
		this.totaltimes = totaltimes;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
}
