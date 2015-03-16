package com.hms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dao.AdminRoomTypeDao;
import com.hms.dao.AdminRoomTypeImageDao;
import com.hms.dto.RoomType;
import com.hms.dto.RoomTypeImage;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;
import com.hms.service.AdminRoomTypeImageService;
import com.hms.service.AdminRoomTypeService;

/**
 * <p>Title: AdminRoomTypeImageServiceImpl.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年3月16日 下午10:35:58
 * @version 1.0
 */
@Service
public class AdminRoomTypeImageServiceImpl implements AdminRoomTypeImageService{
    
	@Autowired
	private AdminRoomTypeImageDao adminRoomTypeImageDao;
	
	public void createRoomTypeImage(RoomTypeImage roomTypeImage) {
		// TODO Auto-generated method stub
		adminRoomTypeImageDao.sava(roomTypeImage);
	}

	
}
