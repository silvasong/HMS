package com.hms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dao.AdminCustomerDao;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;
import com.hms.service.AdminCustomerService;

/**
 * <p>Title: AdminCustomerServiceImpl.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月20日 下午10:15:31
 * @version 1.0
 */
@Service
public class AdminCustomerServiceImpl implements AdminCustomerService{
    
	@Autowired
	private AdminCustomerDao adminCustomerDao;
	
	public PagingData loadpaPagingData(DataTableParamer dtp) {
		// TODO Auto-generated method stub
		return adminCustomerDao.findPage(dtp.getiDisplayStart(), dtp.getiDisplayLength());
	}

}
