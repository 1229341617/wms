package com._520it.wms.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com._520it.wms.dao.ComplePaperDao;
import com._520it.wms.dao.CutPaperDao;
import com._520it.wms.dao.DistributionDao;
import com._520it.wms.domain.ComplePaper;
import com._520it.wms.domain.CutPaper;
import com._520it.wms.domain.Distribution;
import com._520it.wms.domain.Employee;
import com._520it.wms.domain.TitleNum;
import com._520it.wms.query.CutPaperQueryObject;
import com._520it.wms.query.PageResult;
import com._520it.wms.service.CutPaperService;
import com._520it.wms.util.FileUploadUtil;
import com._520it.wms.util.UserContext;
import com._520it.wms.vo.CutPaperVo;

public class CutPaperServiceImpl implements CutPaperService{
	private CutPaperDao cutPaperDao;
	private ComplePaperDao complePaperDao;
	private DistributionDao distributionDao;

	@Override
	public void save(CutPaper obj) {
		cutPaperDao.save(obj);
	}

	@Override
	public void delete(Long id) {
		CutPaper cutPaper = cutPaperDao.get(id);
		if(StringUtils.hasLength(cutPaper.getImagePath1())){
			FileUploadUtil.deleteFile(cutPaper.getImagePath1());
		}
		if(StringUtils.hasLength(cutPaper.getImagePath2())){
			FileUploadUtil.deleteFile(cutPaper.getImagePath2());
		}
		
//		updatePaperState(cutPaper);
		
		cutPaperDao.delete(id);
	}

	private void updatePaperState(CutPaper cutPaper) {
		ComplePaper complePaper = complePaperDao.get(cutPaper.getComplepaper().getId());
		List<CutPaper> cutpapers = cutPaperDao.getCutPapersByComplePaperId(complePaper.getId());
		if(cutpapers != null && cutpapers.size() == 1){
			complePaper.setIscutted(false);
			complePaperDao.update(complePaper);
		}
	}
	
	

	@Override
	public void update(CutPaper obj) {
		ComplePaper complePaper = complePaperDao.get(obj.getComplepaper().getId());
		int reviewdnum = complePaper.getReviewednum();
		complePaper.setReviewednum(++reviewdnum);
		complePaper.setObjscore(complePaper.getObjscore() + obj.getScore());
		if(complePaper.getReviewednum() == complePaper.getCutnum()){
			complePaper.setIsreviewd(true);
		}
		
		obj.setIsfinished(true);
		complePaperDao.update(complePaper);
		
		cutPaperDao.update(obj);
	}
	
	@Override
	public List<CutPaperVo> queryCutPapersByParentId(CutPaperQueryObject qo) {
		Long parentId = qo.getParentId();
		List<CutPaperVo> cutpapervos = null;
		if(parentId > 0){
			cutpapervos = new ArrayList<>();
			queryPapervos(cutpapervos, cutPaperDao.get(parentId));
			Collections.reverse(cutpapervos);
		}
		
		return cutpapervos;
	}
	
	private void queryPapervos(List<CutPaperVo> cutpapervos, CutPaper currentCutPaper) {
		if(currentCutPaper != null){
			CutPaperVo vo = new CutPaperVo();
			vo.setId(currentCutPaper.getId());
			vo.setName(currentCutPaper.getComplepaper().getSubject().getName());
			cutpapervos.add(vo);
			queryPapervos(cutpapervos, currentCutPaper.getParent());
		}
	}
	
	private Map<String, List<TitleNum>> getSubjTitleNumsMap() {
		Map<String,List<TitleNum>> subjTitlesMap = new HashMap<>();
		
		Employee emp = UserContext.getCurrentEmployee();
		if(emp.getRoleNames().contains("教师")) {
			List<Distribution> distributions = distributionDao.getDistributionsByTeacherId(emp.getId());
			if(distributions != null && distributions.size() > 0) {
				for (int i = 0; i < distributions.size(); i++) {
					subjTitlesMap.put(distributions.get(i).getSubject().getName(), distributions.get(i).getTitlenums());
				}
			}
		}
		return subjTitlesMap;
	}
	
	public List<CutPaper> filterRoleTitleNums(List<CutPaper> cutPapers) {
		if(cutPapers != null && cutPapers.size() > 0) {
			Map<String, List<TitleNum>> subjTitleNumsMap = getSubjTitleNumsMap();
			if(subjTitleNumsMap.size() > 0) {
				for (int i = 0; i < cutPapers.size(); i++) {
					String subjectName = cutPapers.get(i).getComplepaper().getSubject().getName();
					if(subjTitleNumsMap.get(subjectName) == null) {
						cutPapers.remove(i);
						i--;
					} else {
						List<TitleNum> titlenums = subjTitleNumsMap.get(subjectName);
						if(!hasTitleNum(cutPapers.get(i), titlenums)) {
							cutPapers.remove(i);
							i--;
						}
					}
				}
				return cutPapers;
			}
		}
		
		return new ArrayList<CutPaper>();
	}
	
	private Boolean hasTitleNum(CutPaper cutPaper, List<TitleNum> titlenums) {
		if(titlenums != null && titlenums.size() > 0) {
			for (int j = 0; j < titlenums.size(); j++) {
				if(cutPaper.getTitlenum() == null || titlenums.get(j).getTitlenum() == cutPaper.getTitlenum().getTitlenum()) {
					return true;
				}
			}
		}
		
		return false;
	}

	
	
	
	
	@Override
	public CutPaper get(Long id) {
		return cutPaperDao.get(id);
	}

	@Override
	public List<CutPaper> findAll() {
		return cutPaperDao.findAll();
	}

	@Override
	public PageResult advanceQuery(CutPaperQueryObject qo) {
		return cutPaperDao.advanceQuery(qo);
	}

	public CutPaperDao getCutPaperDao() {
		return cutPaperDao;
	}

	public void setCutPaperDao(CutPaperDao cutPaperDao) {
		this.cutPaperDao = cutPaperDao;
	}

	public ComplePaperDao getComplePaperDao() {
		return complePaperDao;
	}

	public void setComplePaperDao(ComplePaperDao complePaperDao) {
		this.complePaperDao = complePaperDao;
	}

	public DistributionDao getDistributionDao() {
		return distributionDao;
	}

	public void setDistributionDao(DistributionDao distributionDao) {
		this.distributionDao = distributionDao;
	}
}
