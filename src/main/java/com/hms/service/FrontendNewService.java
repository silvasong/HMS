package com.hms.service;

import java.util.List;

import com.hms.dto.News;
import com.hms.model.DataPageParamer;
import com.hms.model.PagingData;

/**
 * <p>Title: FrontendNewService.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月19日 下午2:54:15
 * @version 1.0
 */
public interface FrontendNewService {
	
	PagingData loadPagingData(DataPageParamer dpp);
	
	PagingData loadPagingDataByType(DataPageParamer dpp);
	
	List<News> getNewByNewType(int value);
	
	News getNewsById(int id);

}
