package com.hms.service;

import java.util.List;
import java.util.Map;

import com.hms.dto.RoomType;

/**
 * <p>Title: FrontendRoomPredetermineService.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月1日 下午2:54:35
 * @version 1.0
 */
public interface FrontendRoomPredetermineService {
	
	List<RoomType> loadAllRoomTypes ();
	
	Map<Integer, Integer> getRoomTypeStatic(long checkInTime,long checkOutTime);

}
