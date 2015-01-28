package com.hms.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>Title: LoginController.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2014年12月27日 下午5:26:52
 * @version 1.0
 */
@Controller
@RequestMapping(value="admin/login")
public class AdminLoginController extends BaseController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/login/login");
		return mav;
	}

}
