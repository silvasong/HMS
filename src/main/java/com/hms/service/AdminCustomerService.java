package com.hms.service;

import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;

/**
 * <p>Title: AdminCustomerService.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月20日 下午10:15:13
 * @version 1.0
 */
public interface AdminCustomerService {
	
	public PagingData loadpaPagingData(DataTableParamer dtp);

}
