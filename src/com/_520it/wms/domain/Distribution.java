package com._520it.wms.domain;

import java.util.ArrayList;
import java.util.List;

import com._520it.wms.util.ClassZhName;

@ClassZhName("试题分配")
public class Distribution extends BaseDomain {
	private String code;
	private Employee teacher;
	private Subject subject;
	private List<TitleNum> titlenums = new ArrayList<>();
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Employee getTeacher() {
		return teacher;
	}
	public void setTeacher(Employee teacher) {
		this.teacher = teacher;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public List<TitleNum> getTitlenums() {
		return titlenums;
	}
	public void setTitlenums(List<TitleNum> titlenums) {
		this.titlenums = titlenums;
	}
}
