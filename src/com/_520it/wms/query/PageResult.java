package com._520it.wms.query;

import java.util.Collections;
import java.util.List;

public class PageResult {
	private Integer totalCount;
	private List result;
	
	private Integer pageSize;
	private Integer currentPage;
	
	private Integer prevPage;
	private Integer nextPage;
	private Integer totalPage;

	
	
	public PageResult(Integer totalCount, List result, Integer pageSize, Integer currentPage){
		this.totalCount = totalCount;
		this.result = result;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		
		totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
		
		prevPage = currentPage - 1 == 0 ? 1 : currentPage - 1;
		nextPage = currentPage + 1 > totalPage ? totalPage : currentPage + 1;
	}
	
	public static PageResult empty(Integer pageSize){
		return new PageResult(0 , Collections.emptyList(), pageSize, 1);
	}


	
	
	
	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public List getResult() {
		return result;
	}

	public void setResult(List result) {
		this.result = result;
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

	public Integer getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(Integer prevPage) {
		this.prevPage = prevPage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public Integer getTotalPage() {
		return totalPage == 0 ? 1 : totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
}
