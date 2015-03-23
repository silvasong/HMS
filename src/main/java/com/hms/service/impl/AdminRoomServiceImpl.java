package com.hms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dao.AdminRoomDao;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;
import com.hms.service.AdminRoomService;

/**
 * <p>Title: AdminRoomServiceImpl.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年3月23日 下午9:16:36
 * @version 1.0
 */
@Service
public class AdminRoomServiceImpl implements AdminRoomService{
    
	@Autowired
	private AdminRoomDao adminRoomDao;
	
	public PagingData loadRoomList(DataTableParamer dtp) {
		// TODO Auto-generated method stub
		return adminRoomDao.findPage(dtp.getiDisplayStart(), dtp.getiDisplayLength());
	}

}
