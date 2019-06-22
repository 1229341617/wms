package com._520it.wms.web.action;

import java.util.ArrayList;
import java.util.List;

import com._520it.wms.domain.Employee;
import com._520it.wms.query.EmployeeQueryObject;
import com._520it.wms.service.DepartmentService;
import com._520it.wms.service.EmployeeService;
import com._520it.wms.service.RoleService;
import com._520it.wms.util.RequiredPermission;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class EmployeeAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	private EmployeeService employeeService;
	private DepartmentService departmentService;
	private RoleService roleService;
	private Employee employee = new Employee();
	private EmployeeQueryObject qo = new EmployeeQueryObject();
	private List<Long> ids = new ArrayList<>();


	@RequiredPermission("用户列表")
	@InputConfig(methodName="input")
	public String execute() throws Exception {
		try {
			putContext("depts", departmentService.findAll());
			putContext("pageResult", employeeService.advanceQuery(qo));
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return LIST;
	}
	
	@RequiredPermission("用户编辑")
	public String input() throws Exception {
		if(employee.getId() != null){
			employee = employeeService.get(employee.getId());
		}
		putContext("depts", departmentService.findAll());
		putContext("roles", roleService.findAll());
		return INPUT;
	}
	
	@RequiredPermission("用户保存或更新")
	public String saveOrUpdate() throws Exception {
		try {
			if(employee.getId() != null){
				employeeService.update(employee);
				addActionMessage("更新成功！");
			}else{
				employeeService.save(employee);
				addActionMessage("保存成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return SUCCESS;
	}
	
	@RequiredPermission("用户删除")
	public String delete() throws Exception {
		employeeService.delete(employee.getId());
		putResponseText("删除成功！");
		return NONE;
	}
	
	@RequiredPermission("用户批量删除")
	public String batchDelete() throws Exception {
		if(ids.size() > 0){
			employeeService.batchDelete(ids);
		}
		return NONE;
	}
	
	public void prepareSaveOrUpdate() throws Exception{
		if(employee.getId() != null){
			employee = employeeService.get(employee.getId());
			employee.setDept(null);
		}
		employee.getRoles().clear();
	}
	
	
	
	
	
	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public EmployeeQueryObject getQo() {
		return qo;
	}

	public void setQo(EmployeeQueryObject qo) {
		this.qo = qo;
	}
	public RoleService getRoleService() {
		return roleService;
	}
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	public List<Long> getIds() {
		return ids;
	}
	public void setIds(List<Long> ids) {
		this.ids = ids;
	}
}
