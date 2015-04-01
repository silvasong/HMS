package com.hms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dao.FrontendRoomPredetemineOrderDao;
import com.hms.dto.Predetemine;
import com.hms.service.FrontendRoomPredetemineOrderService;

/**
 * <p>Title: FrontendRoomPredeteOrderServiceImpl.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月1日 下午3:02:50
 * @version 1.0
 */
@Service
public class FrontendRoomPredetemineOrderServiceImpl implements FrontendRoomPredetemineOrderService{
    
	@Autowired
	private FrontendRoomPredetemineOrderDao frontendRoomPredetemineOrderDao;
	
	public void createPredetemineOrder(Predetemine p) {
		// TODO Auto-generated method stub
		frontendRoomPredetemineOrderDao.sava(p);
	}

}
