package com.hms.service;

import com.hms.dto.Admin;
import com.hms.model.DataPageParamer;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;

/**
 * <p>Title: AdminService.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年1月31日 下午4:15:05
 * @version 1.0
 */
public interface AdminService {
	
	public Admin getByName(String name);
	
	public Admin getById(int id);
	
	public PagingData loadAdminPagingData(int flag, DataTableParamer dtp);
	
	public void createAdmin(Admin admin);
	
	public void updateAdmin(Admin admin);
	
	public void deleteAdmin(Integer [] id);

}
