package com.hms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dao.FrontendRoomPredetemineOrderCommendDao;
import com.hms.dto.PredetermineCommend;
import com.hms.service.FrontendRoomPredetemineOrderCommendService;

/**
 * <p>Title: FrontendRoomPredetemineOrderCommendServiceImpl.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月8日 下午5:43:49
 * @version 1.0
 */
@Service
public class FrontendRoomPredetemineOrderCommendServiceImpl implements FrontendRoomPredetemineOrderCommendService{
     
	@Autowired
	private FrontendRoomPredetemineOrderCommendDao frontendRoomPredetemineOrderCommendDao;
	
	
	public void createPredetemineOrderCommend(PredetermineCommend pc) {
		// TODO Auto-generated method stub
		frontendRoomPredetemineOrderCommendDao.sava(pc);
	}


	public PredetermineCommend getCommendByPredetemineId(String id) {
		// TODO Auto-generated method stub
		return frontendRoomPredetemineOrderCommendDao.findUnique("predetermineId", id);
	}

}
