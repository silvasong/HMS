package com.hms.service;

import com.hms.dto.NewType;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;

/**
 * <p>Title: AdminNewTypeService.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月14日 下午9:27:43
 * @version 1.0
 */
public interface AdminNewTypeService {
	
	public PagingData loadNewTypePagingData(DataTableParamer dtp);
	
	public void createNewType(NewType newType);
	
	public void updateNewType(NewType newType);
	
	public NewType getNewTypeById(int id);
	
	public void deleteNewTypeById(Integer []id);

}
