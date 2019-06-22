package com._520it.wms.web.action;

import com._520it.wms.domain.Department;
import com._520it.wms.query.QueryObject;
import com._520it.wms.service.DepartmentService;
import com._520it.wms.util.RequiredPermission;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class DepartmentAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	private DepartmentService departmentService;
	private Department department = new Department();

	private QueryObject qo = new QueryObject();
	
	@RequiredPermission("部门列表")
	@InputConfig(methodName="input")
	public String execute() throws Exception {
		try {
			putContext("pageResult", departmentService.advanceQuery(qo));
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return LIST;
	}
	
	
	@RequiredPermission("部门编辑")
	public String input() throws Exception {
		if(department.getId() != null){
			department = departmentService.get(department.getId());
		}
		return INPUT;
	}
	
	@RequiredPermission("部门保存或更新")
	public String saveOrUpdate() throws Exception {
		try {
			if(department.getId() != null){
				departmentService.update(department);
				addActionMessage("更新成功！");
			}else{
				departmentService.save(department);
				addActionMessage("保存成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	@RequiredPermission("部门删除")
	public String delete() throws Exception {
		departmentService.delete(department.getId());
		putResponseText("删除成功！");
		return NONE;
	}
	

	
	
	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	public QueryObject getQo() {
		return qo;
	}

	public void setQo(QueryObject qo) {
		this.qo = qo;
	}


}
