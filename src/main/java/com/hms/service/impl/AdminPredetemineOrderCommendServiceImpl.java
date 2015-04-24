package com.hms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dao.AdminPredetemineOrderCommendDao;
import com.hms.dto.PredetermineCommend;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;
import com.hms.service.AdminPredetemineOrderCommendService;

/**
 * <p>Title: AdminPredetemineOrderCommendServiceImpl.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月10日 下午10:23:40
 * @version 1.0
 */
@Service
public class AdminPredetemineOrderCommendServiceImpl implements AdminPredetemineOrderCommendService{
    
	@Autowired
	private AdminPredetemineOrderCommendDao adminPredetemineOrderCommendDao;
	
	public PagingData loadPagingData(DataTableParamer dtp) {
		// TODO Auto-generated method stub
		return adminPredetemineOrderCommendDao.findPage("commendId",false,dtp.getiDisplayStart(), dtp.getiDisplayLength());
	}

	public List<PredetermineCommend> loadAllCommends() {
		// TODO Auto-generated method stub
		return adminPredetemineOrderCommendDao.loadAll();
	}

}
