package com.hms.service;

import java.util.List;

import com.hms.dto.PredetermineCommend;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;

/**
 * <p>Title: AdminPredetemineOrderCommendService.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月10日 下午10:19:10
 * @version 1.0
 */
public interface AdminPredetemineOrderCommendService {
	
	PagingData loadPagingData(DataTableParamer dtp);
	
	List<PredetermineCommend> loadAllCommends();
	
	

}
