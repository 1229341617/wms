package com._520it.wms.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class QueryObject {
	private Integer currentPage = 1;//默认当前页数为第一页
	private Integer pageSize = 10;//默认当前页面数据条数
	
	private List<String> conditions = new ArrayList<>();//查询语句
	private List<Object> params = new ArrayList<>();//查询语句参数
	private Boolean firstSet = true;
	
	
	
	
	
	public void customizedQuery(){}
	
	
	protected void addQuery(String condition, Object... args){
		conditions.add(condition);
		params.addAll(Arrays.asList(args));
	}
	
	//查询条件用AND连接，再之前加上WHERE(apach.common.lang3)
	public String getQuery(){
		//若是第一次，则设置查询条件语句和参数
		if(firstSet){
			customizedQuery();
			firstSet = false;
		}
		//为空则不需要join
		if(conditions.size() == 0){
			return "";
		}
		return " WHERE " + StringUtils.join(conditions, " AND ");

		/*StringBuilder sb = new StringBuilder(200);
		if(conditions.size() > 0){
			for (int index = 0; index < conditions.size(); index++) {
				if(index == 0){
					sb.append(" WHERE ");
				}else{
					sb.append(" AND ");
				}
				sb.append(conditions.get(index));
			}
		}
		
		return sb.toString();*/
	}
	
	public List<Object> getParameters(){
		return this.params;
	}
	
	
	
	
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
}
