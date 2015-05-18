package com.hms.core;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;

import com.hms.service.AdminPredetemineOrderService;





/**
 * <p>Title: SchedulerJob.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年5月18日 下午2:03:10
 * @version 1.0
 */
public class SchedulerJob {
	
	@Autowired
	private AdminPredetemineOrderService adminPredetemineOrderService;
	
	public void work(){
		adminPredetemineOrderService.cancelLimit();
	}

}
