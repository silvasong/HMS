package com.hms.service;

import com.hms.dto.Registration;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;

/**
 * <p>Title: AdminRegistrationService.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月1日 下午5:15:00
 * @version 1.0
 */
public interface AdminRegistrationService {
	
	public void createRegistration(Registration registration);
	
	public PagingData loadRegistrationPagingData(DataTableParamer dtp);
	
	public Registration getRegistrationById(String id);
	
	public void updateRegistrationById(Registration registration);

}
