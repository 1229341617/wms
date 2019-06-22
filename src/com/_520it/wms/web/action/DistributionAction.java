package com._520it.wms.web.action;

import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com._520it.wms.domain.Distribution;
import com._520it.wms.query.DistributionQueryObject;
import com._520it.wms.service.DistributionService;
import com._520it.wms.service.EmployeeService;
import com._520it.wms.service.SubjectService;
import com._520it.wms.service.TitleNumService;
import com._520it.wms.util.RequiredPermission;

public class DistributionAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	private DistributionService distributionService;
	private TitleNumService titleNumService;
	private SubjectService subjectService;
	private EmployeeService employeeService;
	private Distribution distribution = new Distribution();
	private DistributionQueryObject qo = new DistributionQueryObject();

	@RequiredPermission("试题分配列表")
	@InputConfig(methodName="input")
	public String execute() throws Exception {
		try {
			putContext("pageResult", distributionService.advanceQuery(qo));
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return LIST;
	}
	
	
	@RequiredPermission("试题分配编辑")
	public String input() throws Exception {
		putContext("titlenums", titleNumService.findAll());
		putContext("subjects", subjectService.findAll());
		putContext("teachers", employeeService.getAndFilterByRoleName("教师"));
		if(distribution.getId() != null){
			distribution = distributionService.get(distribution.getId());
		}
		return INPUT;
	}
	
	@RequiredPermission("试题分配保存或更新")
	public String saveOrUpdate() throws Exception {
		try {
			if(distribution.getId() != null){
				distributionService.update(distribution);
				addActionMessage("更新成功！");
			}else{
				distributionService.save(distribution);
				addActionMessage("保存成功！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return SUCCESS;
	}
	
	@RequiredPermission("试题分配删除")
	public String delete() throws Exception {
		distributionService.delete(distribution.getId());
		putResponseText("删除成功！");
		return NONE;
	}
	
	
	public void prepareSaveOrUpdate() throws Exception{
		if(distribution.getId() != null){
			distribution = distributionService.get(distribution.getId());
			distribution.setTeacher(null);
		}
		distribution.getTitlenums().clear();
	}
	
	
	
	public DistributionService getDistributionService() {
		return distributionService;
	}

	public void setDistributionService(DistributionService distributionService) {
		this.distributionService = distributionService;
	}
	public Distribution getDistribution() {
		return distribution;
	}
	public void setDistribution(Distribution distribution) {
		this.distribution = distribution;
	}
	public DistributionQueryObject getQo() {
		return qo;
	}
	public void setQo(DistributionQueryObject qo) {
		this.qo = qo;
	}
	public TitleNumService getTitleNumService() {
		return titleNumService;
	}
	public void setTitleNumService(TitleNumService titleNumService) {
		this.titleNumService = titleNumService;
	}
	public SubjectService getSubjectService() {
		return subjectService;
	}
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
}
