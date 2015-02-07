package com.hms.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>Title: AdminSettingController.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年2月7日 下午9:10:30
 * @version 1.0
 */
@Controller
@RequestMapping(value="/admin/setting")
public class AdminSettingController {
	
	@RequestMapping(value="index_setting",method=RequestMethod.GET)
	public ModelAndView index_setting(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/setting/index_setting");
		return mav;
	}

}
