package com.hms.service;

import com.hms.dto.Room;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;

/**
 * <p>Title: AdminRoomService.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年3月23日 下午9:16:06
 * @version 1.0
 */
public interface AdminRoomService {
	
	public PagingData loadRoomList(DataTableParamer dtp);
	
	public void createRoom(Room room);
	
	public Room getRoomById(Integer id);
	
	public void updateRoom(Room room);
	
	public void deleteRoom(Integer [] id);

}
