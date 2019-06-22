package com._520it.wms.dao;

import com._520it.wms.domain.TitleNum;

public interface TitleNumDao extends GenericDao<TitleNum>{
	
	TitleNum getTitleNumByNum(int num);
	
}
