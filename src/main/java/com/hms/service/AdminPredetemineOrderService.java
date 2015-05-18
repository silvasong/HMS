package com.hms.service;

import java.util.List;

import com.hms.dto.Predetemine;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;



/**
 * <p>Title: AdminPredetemineOrderService.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月10日 下午2:10:05
 * @version 1.0
 */
public interface AdminPredetemineOrderService {
	
	PagingData loadPredetemineOrderPagingData(DataTableParamer dtp);
	
	Predetemine getPredetemineOrderById(String id);
	
	void updatePredetemineOrder(Predetemine predetemine);
	
	List<Predetemine> loadPredetemineOrderToday(long today);
	
	void cancelLimit();

}
