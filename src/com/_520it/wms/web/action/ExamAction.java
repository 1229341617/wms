package com._520it.wms.web.action;

import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com._520it.wms.domain.Exam;
import com._520it.wms.query.ExamQueryObject;
import com._520it.wms.service.ExamService;
import com._520it.wms.service.SubjectService;
import com._520it.wms.util.RequiredPermission;

public class ExamAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	private ExamService examService;
	private SubjectService subjectService;
	private Exam exam = new Exam();
	private ExamQueryObject qo = new ExamQueryObject();

	@RequiredPermission("考试列表")
	@InputConfig(methodName="input")
	public String execute() throws Exception {
		try {
			putContext("pageResult", examService.advanceQuery(qo));
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return LIST;
	}
	
	
	@RequiredPermission("考试编辑")
	public String input() throws Exception {
		if(exam.getId() != null){
			exam = examService.get(exam.getId());
		}
		
		putContext("subjects", subjectService.findAll());
		
		return INPUT;
	}
	
	@RequiredPermission("考试保存或更新")
	public String saveOrUpdate() throws Exception {
		try {
			if(exam.getId() != null){
				examService.update(exam);
				addActionMessage("更新成功！");
			}else{
				examService.save(exam);
				addActionMessage("保存成功！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return SUCCESS;
	}
	
	@RequiredPermission("考试删除")
	public String delete() throws Exception {
		examService.delete(exam.getId());
		putResponseText("删除成功！");
		return NONE;
	}
	
	
	
	public ExamService getExamService() {
		return examService;
	}

	public void setExamService(ExamService examService) {
		this.examService = examService;
	}
	 
	
	public SubjectService getSubjectService() {
		return subjectService;
	}


	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}


	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public ExamQueryObject getQo() {
		return qo;
	}
	public void setQo(ExamQueryObject qo) {
		this.qo = qo;
	}
}
