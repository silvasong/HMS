package com.hms.service;

import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;

/**
 * <p>Title: AdminRoomTypeService.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年3月14日 下午9:05:50
 * @version 1.0
 */
public interface AdminRoomTypeService {
	
	PagingData loadRoomTypeList(DataTableParamer dtp);

}
