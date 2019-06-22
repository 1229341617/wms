package com._520it.wms.web.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com._520it.wms.domain.ComplePaper;
import com._520it.wms.domain.Employee;
import com._520it.wms.query.ComplePaperQueryObject;
import com._520it.wms.service.ComplePaperService;
import com._520it.wms.service.EmployeeService;
import com._520it.wms.service.ExamService;
import com._520it.wms.service.SubjectService;
import com._520it.wms.util.FileUploadUtil;
import com._520it.wms.util.RequiredPermission;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class ComplePaperAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	private ComplePaperService complePaperService;
	private SubjectService subjectService;
	private EmployeeService employeeService;
	private ExamService examService;
	private ComplePaper complePaper = new ComplePaper();
	private ComplePaperQueryObject qo = new ComplePaperQueryObject();
	
	private List<Long> ids = new ArrayList<>();
	
	private File pic;
	private String picFileName;
	

	@RequiredPermission("试卷列表")
	@InputConfig(methodName="input")
	public String execute() throws Exception {
		try {
			putContext("pageResult", complePaperService.filterPaperByStudent(complePaperService.advanceQuery(qo)));
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return LIST;
	}

	@RequiredPermission("试卷编辑")
	public String input() throws Exception {
		if(complePaper.getId() != null){
			complePaper = complePaperService.get(complePaper.getId());
		}
		
		putContext("subjects", subjectService.findAll());
		putContext("exams", examService.findAll());
		
		List<Employee> emps = employeeService.getAndFilterByRoleName("学生");
		putContext("emps", emps);
		
		return INPUT;
	}
	
	@RequiredPermission("试卷保存或更新")
	public String saveOrUpdate() throws Exception {
		try {
			if(pic != null && complePaper.getId() != null && complePaper.getImagePath() != null){
				FileUploadUtil.deleteFile(complePaper.getImagePath());
			}
			if(pic != null){
				String imagePath = FileUploadUtil.uploadFile(pic, picFileName);
				complePaper.setImagePath(imagePath);
			}
			
			if(complePaper.getId() != null){
				complePaperService.update(complePaper);
				addActionMessage("更新成功！");
			}else{
				complePaperService.save(complePaper);
				addActionMessage("保存成功！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return SUCCESS;
	}
	
	@RequiredPermission("试卷删除")
	public String delete() throws Exception {
		complePaperService.delete(complePaper.getId());
		putResponseText("删除成功！");
		return NONE;
	}
	
	@RequiredPermission("试卷批量切割")
	public String batchCutPaper() throws Exception {
		if(ids.size() > 0){
			complePaperService.batchCutPapers(ids);
		}
		return NONE;
	}
	
	
	
	public void prepareSaveOrUpdate() throws Exception{
		if(complePaper.getId() != null){
			complePaper = complePaperService.get(complePaper.getId());
			complePaper.setStudent(null);
			complePaper.setTeacher(null);
			complePaper.setSubject(null);
		}
	}
	
	
	
	
	public ExamService getExamService() {
		return examService;
	}

	public void setExamService(ExamService examService) {
		this.examService = examService;
	}

	public ComplePaperService getComplePaperService() {
		return complePaperService;
	}

	public void setComplePaperService(ComplePaperService complePaperService) {
		this.complePaperService = complePaperService;
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
	
	public ComplePaper getComplePaper() {
		return complePaper;
	}
	public void setComplePaper(ComplePaper complePaper) {
		this.complePaper = complePaper;
	}
	public ComplePaperQueryObject getQo() {
		return qo;
	}
	public void setQo(ComplePaperQueryObject qo) {
		this.qo = qo;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}
	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}
	public void setIds(List<Long> ids) {
		this.ids = ids;
	}
}
