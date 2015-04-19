package com.hms.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dao.FrontendNewDao;
import com.hms.dto.News;
import com.hms.model.DataPageParamer;
import com.hms.model.PagingData;
import com.hms.service.FrontendNewService;

/**
 * <p>Title: FrontendNewServiceImpl.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月19日 下午2:54:37
 * @version 1.0
 */
@Service
public class FrontendNewServiceImpl implements FrontendNewService{
    
	@Autowired
	private FrontendNewDao frontendNewDao;
	
	public PagingData loadPagingData(DataPageParamer dpp) {
		// TODO Auto-generated method stub
		return frontendNewDao.findPage("newTime", false, dpp.getPageIndex()*dpp.getPageSize(), dpp.getPageSize());
	}

	public List<News> getNewByNewType(int value) {
		// TODO Auto-generated method stub
		return frontendNewDao.findBy("newType", value);
	}

	public News getNewsById(int id) {
		// TODO Auto-generated method stub
		return frontendNewDao.get(id);
	}

	public PagingData loadPagingDataByType(DataPageParamer dpp) {
		// TODO Auto-generated method stub
		return frontendNewDao.findPage("newTime", false, Restrictions.eq("newType", dpp.getType()), dpp.getPageIndex()*dpp.getPageSize(), dpp.getPageSize());
	}

}
