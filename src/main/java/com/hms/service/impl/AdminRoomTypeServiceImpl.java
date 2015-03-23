package com.hms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hms.dao.AdminRoomTypeDao;
import com.hms.dto.RoomType;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;
import com.hms.service.AdminRoomTypeService;

/**
 * <p>Title: AdminRoomTypeServiceImpl.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年3月14日 下午9:06:13
 * @version 1.0
 */
@Controller
class AdminRoomTypeServiceImpl implements AdminRoomTypeService{
	
	@Autowired
	private AdminRoomTypeDao adminRoomTypeDao;

	public PagingData loadRoomTypeList(DataTableParamer dtp) {
		// TODO Auto-generated method stub
		return adminRoomTypeDao.findPage(dtp.getiDisplayStart(), dtp.getiDisplayLength());
	}

	public void createRoomType(RoomType roomType) {
		// TODO Auto-generated method stub
		adminRoomTypeDao.sava(roomType);
	}

	public void updateRoomType(RoomType roomType) {
		// TODO Auto-generated method stub
		adminRoomTypeDao.update(roomType);
	}

	public void deleteRoomType(Integer ids[]) {
		// TODO Auto-generated method stub
		adminRoomTypeDao.deletAll(ids);
	}

	public RoomType getRoomTypeById(Integer id) {
		// TODO Auto-generated method stub
		return adminRoomTypeDao.get(id);
	}

	public void deleteRoomType(RoomType roomType) {
		// TODO Auto-generated method stub
		adminRoomTypeDao.delete(roomType);
	}

	public List<RoomType> loadAll() {
		// TODO Auto-generated method stub
		return adminRoomTypeDao.loadAll();
	}
	
	

}
