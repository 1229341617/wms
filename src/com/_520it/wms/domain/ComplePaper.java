package com._520it.wms.domain;

import com._520it.wms.util.ClassZhName;

@ClassZhName("试卷")
public class ComplePaper extends BaseDomain {
	private int totalscore;
	private int objscore;
	private String imagePath;
	private Boolean iscutted;
	private int cutnum;
	private	int reviewednum;
	private Boolean isreviewd;
	
	private Employee teacher;
	private Employee student;
	private Subject subject;
	private Exam exam;
	
	
	public String getSmallImagePath(){
		if(imagePath == null){
			return "";
		}
		String prefix = imagePath.substring(0, imagePath.lastIndexOf("."));
		String suffixString = imagePath.substring(imagePath.lastIndexOf("."));
		return prefix + "_small" + suffixString;
	}
	
	
	public int getTotalscore() {
		return totalscore;
	}
	public void setTotalscore(int totalscore) {
		this.totalscore = totalscore;
	}
	public int getObjscore() {
		return objscore;
	}
	public void setObjscore(int objscore) {
		this.objscore = objscore;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Boolean getIscutted() {
		return iscutted;
	}
	public void setIscutted(Boolean iscutted) {
		this.iscutted = iscutted;
	}
	public int getCutnum() {
		return cutnum;
	}
	public void setCutnum(int cutnum) {
		this.cutnum = cutnum;
	}
	public int getReviewednum() {
		return reviewednum;
	}
	public void setReviewednum(int reviewednum) {
		this.reviewednum = reviewednum;
	}
	public Boolean getIsreviewd() {
		return isreviewd;
	}
	public void setIsreviewd(Boolean isreviewd) {
		this.isreviewd = isreviewd;
	}
	public Employee getTeacher() {
		return teacher;
	}
	public void setTeacher(Employee teacher) {
		this.teacher = teacher;
	}
	public Employee getStudent() {
		return student;
	}
	public void setStudent(Employee student) {
		this.student = student;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
}
