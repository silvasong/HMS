package com.hms.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>Title: FrontendNewController.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月18日 下午4:40:36
 * @version 1.0
 */
@Controller
@RequestMapping(value="frontend/news")
public class FrontendNewController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView news(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("frontend/new/news");
		return mav;
	}

}
