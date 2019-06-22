package com._520it.wms.web.action;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class BaseAction extends ActionSupport implements Preparable{
	private static final long serialVersionUID = 1L;
	public static final String LIST = "list";
	
	
	
	@Override
	public void prepare() throws Exception {
	}
	
	protected void putContext(String name, Object obj){
		ActionContext.getContext().put(name, obj);
	}
	
	protected void putResponseText(String data){
		try {
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().print(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void putJson(Object json) {
		try {
			ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
			ServletActionContext.getResponse().getWriter().print(JSON.toJSON(json));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
