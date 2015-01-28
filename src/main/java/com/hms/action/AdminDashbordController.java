package com.hms.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>Title: DashbordController.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年1月28日 下午8:18:01
 * @version 1.0
 */
@Controller
@RequestMapping(value="admin/dashbord")
public class AdminDashbordController extends BaseController{
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView dashbord(HttpServletRequest request){
		ModelAndView mav =new ModelAndView();
		mav.setViewName("admin/dashbord/dashbord");
		return mav;
	}

}
