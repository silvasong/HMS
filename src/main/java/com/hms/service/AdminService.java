package com.hms.service;

import com.hms.dto.Admin;

/**
 * <p>Title: AdminService.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年1月31日 下午4:15:05
 * @version 1.0
 */
public interface AdminService {
	
	public Admin getByName(String name);

}
