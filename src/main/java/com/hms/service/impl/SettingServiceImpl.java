package com.hms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dao.SettingDao;
import com.hms.dto.Setting;
import com.hms.service.SettingService;

/**
 * <p>Title: SettingServiceImpl.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年2月8日 下午6:10:47
 * @version 1.0
 */
@Service
public class SettingServiceImpl implements SettingService {
	
	@Autowired
	private SettingDao settingDao;

	public Setting getSettingByKey(String key) {
		// TODO Auto-generated method stub
		return settingDao.findUnique("name", key);
	}

	public void saveSetting(Setting setting) {
		// TODO Auto-generated method stub
		settingDao.sava(setting);
	}

	public void updateSetting(Setting setting) {
		// TODO Auto-generated method stub
		settingDao.update(setting);
	}

}
