package com.hms.service.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dao.AdminDao;
import com.hms.dto.Admin;
import com.hms.model.DataPageParamer;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;
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

	public Admin getById(int id) {
		// TODO Auto-generated method stub
		return adminDao.get(id);
	}

	public PagingData loadAdminPagingData(int flag,DataTableParamer dtp) {
		// TODO Auto-generated method stub
		if(flag==1){
			return adminDao.findPage(Restrictions.eq("roleId", 2),dtp.getiDisplayStart(), dtp.getiDisplayLength());
		}
		return adminDao.findPage(dtp.getiDisplayStart(), dtp.getiDisplayLength());
	}

	public void createAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminDao.sava(admin);
	}

	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminDao.update(admin);
	}

	public void deleteAdmin(Integer[] id) {
		// TODO Auto-generated method stub
		adminDao.deletAll(id);
	}

}
