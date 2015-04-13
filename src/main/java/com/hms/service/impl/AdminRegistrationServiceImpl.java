package com.hms.service.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.hms.dao.AdminRegistrationDao;
import com.hms.dto.Registration;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;
import com.hms.service.AdminRegistrationService;

/**
 * <p>Title: AdminRegistrationServiceImpl.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月1日 下午5:15:29
 * @version 1.0
 */
@Service
public class AdminRegistrationServiceImpl implements AdminRegistrationService{
    
	@Autowired
	private AdminRegistrationDao adminRegistrationDao;
	
	public void createRegistration(Registration registration) {
		// TODO Auto-generated method stub
		adminRegistrationDao.sava(registration);
	}

	public PagingData loadRegistrationPagingData(DataTableParamer dtp) {
		// TODO Auto-generated method stub
		String searchStr = dtp.getsSearch();
		if(searchStr != null && !searchStr.isEmpty()){
			JSONObject jsonObject = JSONObject.parseObject(searchStr);
			return adminRegistrationDao.findPage(Restrictions.eq("status", jsonObject.getInteger("status")),dtp.getiDisplayStart(), dtp.getiDisplayLength());
		}
		return adminRegistrationDao.findPage(Restrictions.eq("status", 1),dtp.getiDisplayStart(), dtp.getiDisplayLength());
	}

	public Registration getRegistrationById(String id) {
		// TODO Auto-generated method stub
		return adminRegistrationDao.get(id);
	}

	public void updateRegistrationById(Registration registration) {
		// TODO Auto-generated method stub
		adminRegistrationDao.update(registration);
	}

}
