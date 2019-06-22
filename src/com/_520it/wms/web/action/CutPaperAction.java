package com._520it.wms.web.action;

import java.util.List;

import com._520it.wms.domain.CutPaper;
import com._520it.wms.query.CutPaperQueryObject;
import com._520it.wms.query.PageResult;
import com._520it.wms.service.CutPaperService;
import com._520it.wms.util.RequiredPermission;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class CutPaperAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	private CutPaperService cutPaperService;
	private CutPaper cutPaper = new CutPaper();
	private CutPaperQueryObject qo = new CutPaperQueryObject();

	
	/**
	 * 科目     题号s
	 * 
	 * Map<String, List<>
	 * 
	 * 
	 * 科目-题号
	 * 
	 * 
	 * 
	 * 
	 */
	@RequiredPermission("试题列表")
	@InputConfig(methodName="input")
	public String execute() throws Exception {
		try {
			PageResult pageResult = cutPaperService.advanceQuery(qo);
			pageResult.setResult(cutPaperService.filterRoleTitleNums(pageResult.getResult()));
			
			putContext("pageResult", pageResult);
			putContext("cutpapervos", cutPaperService.queryCutPapersByParentId(qo));
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return LIST;
	}



	@RequiredPermission("试题编辑")
	public String input() throws Exception {
		if(cutPaper.getId() != null){
			cutPaper = cutPaperService.get(cutPaper.getId());
		}
		return INPUT;
	}
	
	@RequiredPermission("试题保存或更新")
	public String saveOrUpdate() throws Exception {
		try {
			if(qo.getParentId() > 0){
				cutPaper.setParent(cutPaperService.get(qo.getParentId()));
			}else{
				cutPaper.setParent(null);
			}
			
			if(cutPaper.getId() != null){
				cutPaperService.update(cutPaper);
				addActionMessage("阅卷成功！");
			}else{
				cutPaperService.save(cutPaper);
				addActionMessage("保存成功！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return SUCCESS;
	}
	
	@RequiredPermission("试题删除")
	public String delete() throws Exception {
		try {
			cutPaperService.delete(cutPaper.getId());
			putResponseText("删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			putResponseText(e.getMessage());
		}
		return NONE;
	}
	
	
	public void prepareSaveOrUpdate() throws Exception{
		if(cutPaper.getId() != null){
			cutPaper = cutPaperService.get(cutPaper.getId());
		}
	}
	
	public CutPaperService getCutPaperService() {
		return cutPaperService;
	}

	public void setCutPaperService(CutPaperService cutPaperService) {
		this.cutPaperService = cutPaperService;
	}
	public CutPaper getCutPaper() {
		return cutPaper;
	}
	public void setCutPaper(CutPaper cutPaper) {
		this.cutPaper = cutPaper;
	}
	public CutPaperQueryObject getQo() {
		return qo;
	}
	public void setQo(CutPaperQueryObject qo) {
		this.qo = qo;
	}
}
