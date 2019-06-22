package com._520it.wms.domain;

import java.util.ArrayList;
import java.util.List;


public class Employee extends BaseDomain{
	private String name;
	private String password;
	private String email;
	private Integer age;
	private Boolean admin;
	private Department dept;
	private List<Role> roles = new ArrayList<>();
	
	public String getSimpleName(){
		if(name == null){
			return "[暂无]";
		}
		return name;
	}
	
	public String getRoleNames(){
		if(admin){
			return "[超级管理员]";
		}
		if(roles.size() == 0){
			return "[暂无角色]";
		}
		StringBuilder sb = new StringBuilder(200);
		sb.append("[");
		for (int index = 0; index < roles.size(); index++) {
			sb.append(roles.get(index).getName()).append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		
		return sb.toString();
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
