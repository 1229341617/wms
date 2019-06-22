package com._520it.wms.domain;

import com._520it.wms.util.ClassZhName;

@ClassZhName("试题")
public class CutPaper extends BaseDomain{
	
	private TitleNum titlenum;
	private int totalscore;
	private int score;
	private String imagePath1;
	private String imagePath2;
	private Boolean isfinished;
	
	private CutPaper parent;
	private Employee teacher;
	private Employee student;
	private ComplePaper complepaper;
	
	
	public String getSmallImagePath1(){
		if(imagePath1 == null){
			return "";
		}
		String prefix = imagePath1.substring(0, imagePath1.lastIndexOf("."));
		String suffixString = imagePath1.substring(imagePath1.lastIndexOf("."));
		return prefix + "_small" + suffixString;
	}
	
	public String getSmallImagePath2(){
		if(imagePath2 == null){
			return "";
		}
		String prefix = imagePath2.substring(0, imagePath2.lastIndexOf("."));
		String suffixString = imagePath2.substring(imagePath2.lastIndexOf("."));
		return prefix + "_small" + suffixString;
	}
	
	
	public TitleNum getTitlenum() {
		return titlenum;
	}

	public void setTitlenum(TitleNum titlenum) {
		this.titlenum = titlenum;
	}

	public int getTotalscore() {
		return totalscore;
	}
	public void setTotalscore(int totalscore) {
		this.totalscore = totalscore;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getImagePath1() {
		return imagePath1;
	}
	public void setImagePath1(String imagePath1) {
		this.imagePath1 = imagePath1;
	}
	public String getImagePath2() {
		return imagePath2;
	}
	public void setImagePath2(String imagePath2) {
		this.imagePath2 = imagePath2;
	}
	public Boolean getIsfinished() {
		return isfinished;
	}
	public void setIsfinished(Boolean isfinished) {
		this.isfinished = isfinished;
	}
	public CutPaper getParent() {
		return parent;
	}
	public void setParent(CutPaper parent) {
		this.parent = parent;
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

	public ComplePaper getComplepaper() {
		return complepaper;
	}

	public void setComplepaper(ComplePaper complepaper) {
		this.complepaper = complepaper;
	}
}
