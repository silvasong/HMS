package com.hms.action;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>Title: FrontendOnlinebookingController.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年3月28日 下午8:20:55
 * @version 1.0
 */
@Controller
@RequestMapping(value="frontend/online_order")
public class FrontendOnlineOrderController extends BaseController{
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView onlineOrder(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("frontend/onlineorder/online_order");
		return mav;
	}
	
	

}
