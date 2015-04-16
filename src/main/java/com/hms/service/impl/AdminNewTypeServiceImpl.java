package com.hms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dao.AdminNewTypeDao;
import com.hms.dto.NewType;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;
import com.hms.service.AdminNewTypeService;


/**
 * <p>Title: AdminNewTypeServiceImpl.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月14日 下午9:28:16
 * @version 1.0
 */
@Service
public class AdminNewTypeServiceImpl implements AdminNewTypeService{
    
	@Autowired
	private AdminNewTypeDao adminNewTypeDao;
	
	public PagingData loadNewTypePagingData(DataTableParamer dtp) {
		// TODO Auto-generated method stub
		return adminNewTypeDao.findPage(dtp.iDisplayStart, dtp.iDisplayLength);
	}

	public void createNewType(NewType newType) {
		// TODO Auto-generated method stub
		adminNewTypeDao.sava(newType);
	}

	public void updateNewType(NewType newType) {
		// TODO Auto-generated method stub
		adminNewTypeDao.update(newType);
	}

	public NewType getNewTypeById(int id) {
		// TODO Auto-generated method stub
		return adminNewTypeDao.get(id);
	}

	public void deleteNewTypeById(Integer[] id) {
		// TODO Auto-generated method stub
		adminNewTypeDao.deletAll(id);
	}

	public List<NewType> loadNewTypes() {
		// TODO Auto-generated method stub
		return adminNewTypeDao.loadAll();
	}

}
