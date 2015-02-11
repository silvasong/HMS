package com.hms.service;

import java.util.List;

import com.hms.dto.Setting;

/**
 * <p>Title: SettingService.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年2月8日 下午6:10:20
 * @version 1.0
 */
public interface SettingService {
	
	public Setting getSettingByKey(String key);
	
	public void saveSetting(Setting setting);
	
	public void updateSetting(Setting setting);
	
	public List<Setting> loadAllSettings();

}
