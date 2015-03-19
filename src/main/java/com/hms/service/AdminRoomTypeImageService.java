package com.hms.service;

import com.hms.dto.RoomTypeImage;

/**
 * <p>Title: AdminRoomTypeImageService.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年3月16日 下午10:31:10
 * @version 1.0
 */
public interface AdminRoomTypeImageService {
	
	void createRoomTypeImage(RoomTypeImage roomTypeImage);
	
	void deleteRoomTypeImage(Integer id);
	
}
