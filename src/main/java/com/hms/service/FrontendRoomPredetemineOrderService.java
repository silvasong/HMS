package com.hms.service;

import com.hms.dto.Predetemine;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;

/**
 * <p>Title: FrontendRoomPredetemineOrderService.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月1日 下午3:02:14
 * @version 1.0
 */
public interface FrontendRoomPredetemineOrderService {
	
	public void createPredetemineOrder(Predetemine p);
	
	public PagingData predetemineOrderList(DataTableParamer dtp);
	
	public Predetemine getPredetemineById(String id);
	
	public void updatePredete(Predetemine p);

}
