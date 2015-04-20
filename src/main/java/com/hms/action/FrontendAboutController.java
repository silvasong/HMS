package com.hms.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>Title: FrontendAboutController.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月20日 下午1:27:04
 * @version 1.0
 */

@Controller
@RequestMapping(value="frontend/about")
public class FrontendAboutController extends BaseController{
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView about(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("frontend/about/about");
		return mav;
	}

}
