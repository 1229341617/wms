package com._520it.wms.web.action;

import com._520it.wms.domain.Subject;
import com._520it.wms.query.SubjectQueryObject;
import com._520it.wms.service.SubjectService;
import com._520it.wms.util.RequiredPermission;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class SubjectAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	private SubjectService subjectService;
	private Subject subject = new Subject();
	private SubjectQueryObject qo = new SubjectQueryObject();

	@RequiredPermission("科目列表")
	@InputConfig(methodName="input")
	public String execute() throws Exception {
		try {
			putContext("pageResult", subjectService.advanceQuery(qo));
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return LIST;
	}
	
	@RequiredPermission("科目编辑")
	public String input() throws Exception {
		if(subject.getId() != null){
			subject = subjectService.get(subject.getId());
		}
		
		return INPUT;
	}
	
	@RequiredPermission("科目保存或更新")
	public String saveOrUpdate() throws Exception {
		try {
			if(subject.getId() != null){
				subjectService.update(subject);
				addActionMessage("更新成功！");
			}else{
				subjectService.save(subject);
				addActionMessage("保存成功！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return SUCCESS;
	}
	
	@RequiredPermission("科目删除")
	public String delete() throws Exception {
		subjectService.delete(subject.getId());
		putResponseText("删除成功！");
		return NONE;
	}
	
	public SubjectService getSubjectService() {
		return subjectService;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
	public Subject getSubject() {
		return subject;
	}
	
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public SubjectQueryObject getQo() {
		return qo;
	}
	public void setQo(SubjectQueryObject qo) {
		this.qo = qo;
	}
}
