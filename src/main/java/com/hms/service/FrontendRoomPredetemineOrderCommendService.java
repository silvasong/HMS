package com.hms.service;

import com.hms.dto.PredetermineCommend;

/**
 * <p>Title: FrontendRoomPredetemineOrderCommendService.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月8日 下午5:43:37
 * @version 1.0
 */
public interface FrontendRoomPredetemineOrderCommendService {
	
	void createPredetemineOrderCommend(PredetermineCommend pc);
	
	PredetermineCommend getCommendByPredetemineId(String id);

}
