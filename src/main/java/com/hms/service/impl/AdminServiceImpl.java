package com.hms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dao.AdminDao;
import com.hms.dto.Admin;
import com.hms.service.AdminService;

/**
 * <p>Title: AdminServiceImpl.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年1月31日 下午4:15:51
 * @version 1.0
 */
@Service
public class AdminServiceImpl implements AdminService {
    
	@Autowired
	private AdminDao adminDao;
	
	public Admin getByName(String name) {
		// TODO Auto-generated method stub
		return adminDao.findUnique("adminName", name);
	}

}
