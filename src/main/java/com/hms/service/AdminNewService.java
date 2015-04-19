package com.hms.service;

import com.hms.dto.News;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;

/**
 * <p>Title: AdminNewService.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月16日 下午1:18:06
 * @version 1.0
 */
public interface AdminNewService {
	
	public PagingData loadNewPagingData(DataTableParamer dtp);
	
	public void createNews(News news);
	
	public void updateNews(News news);
	
	public void deleteNews(Integer [] ids);

}
