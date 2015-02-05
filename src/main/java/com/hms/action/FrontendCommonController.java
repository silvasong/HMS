package com.hms.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>Title: CommonController.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年1月28日 下午8:10:40
 * @version 1.0
 */
@Controller
@RequestMapping(value="frontend/common")
public class FrontendCommonController extends BaseController{
	
	@RequestMapping(value="head",method=RequestMethod.GET)
	public ModelAndView head(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("frontend/common/head");
		return mav;
	}
	
	@RequestMapping(value="footer",method=RequestMethod.GET)
	public ModelAndView footer(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("frontend/common/footer");
		return mav;
	}

}