package com.hms.common;

import java.util.UUID;

/**
 * <p>Title: UUID.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年2月8日 下午5:12:06
 * @version 1.0
 */
public class UUIDTools {
	
	public static String getUUIDString(){
		String str = UUID.randomUUID().toString();
		str=str.replace("-","");
		return str;
		
	}

}
