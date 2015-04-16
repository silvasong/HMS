package com.hms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dao.AdminNewDao;
import com.hms.dto.News;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;
import com.hms.service.AdminNewService;

/**
 * <p>Title: AdminNewServiceImpl.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月16日 下午1:18:32
 * @version 1.0
 */
@Service
public class AdminNewServiceImpl implements AdminNewService{
    
	@Autowired
	private AdminNewDao adminNewDao;
	
	public PagingData loadNewPagingData(DataTableParamer dtp) {
		// TODO Auto-generated method stub
		return adminNewDao.findPage(dtp.getiDisplayStart(),dtp.getiDisplayLength() );
	}

	public void createNews(News news) {
		// TODO Auto-generated method stub
		adminNewDao.sava(news);
	}

	public void updateNews(News news) {
		// TODO Auto-generated method stub
		adminNewDao.update(news);
	}

	public void deleteNews(Integer[] ids) {
		// TODO Auto-generated method stub
		adminNewDao.deletAll(ids);
	}

}
