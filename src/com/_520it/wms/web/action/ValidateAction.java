package com._520it.wms.web.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;




public class ValidateAction extends BaseAction {
	private static final long serialVersionUID = 8267590649514360508L;
	
	private File headImg;//上传文件:												必须有setter方法;
	private String headImgFileName;//上传文件的原始名称:								必须有setter方法;
	
	
	public String upload() throws Exception{
		String tempRealPath = ServletActionContext.getServletContext().getRealPath("temp");//得上传文件存放的目录
		File file = new File(tempRealPath, headImgFileName);//创建上传文件对象
		FileUtils.copyFile(headImg, file);//利用commons.io中的FileUtils工具类来完成上传;
		return NONE;
	}


	public void setHeadImg(File headImg) {
		this.headImg = headImg;
	}
	public void setHeadImgFileName(String headImgFileName) {
		this.headImgFileName = headImgFileName;
	}
}
