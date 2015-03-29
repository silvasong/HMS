package com.hms.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hms.common.SecurityTools;
import com.hms.dto.Customer;
import com.hms.service.FrontendCustomerService;

/**
 * <p>Title: FrontendLoginController.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年3月29日 下午3:47:30
 * @version 1.0
 */
@Controller
@RequestMapping(value="frontend")
public class FrontendLoginController extends BaseController{
	
	@Autowired
	private FrontendCustomerService frontendCustomerService;
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("frontend/login/login");
		return mav;
	}
	
	@RequestMapping(value="login1",method=RequestMethod.POST)
	@ResponseBody
	public String login(HttpServletRequest request,Customer cust){
		JSONObject resp = new JSONObject();
		try {
			Customer customer = frontendCustomerService.getCustomerByIdcard(cust.getIdCard());
			if(customer == null){
				resp.put("status", false);
				resp.put("info", "用户不存在.");
			}else if(!customer.getPassword().equals(SecurityTools.SHA1(cust.getPassword()))){
				resp.put("status", false);
				resp.put("info", "密码错误.");
			}else{
				resp.put("status", true);
				setCustomerSession(request, customer);
			}
		} catch (Exception e) {
			// TODO: handle exception
			resp.put("status", false);
			resp.put("info", "登录错误.");
		}
		return JSON.toJSONString(resp);
	}
	
	@RequestMapping(value="loginout",method=RequestMethod.GET)
	public ModelAndView loginOut(HttpSession session){
		ModelAndView mav = new ModelAndView();
		removeCustomerSession(session);
		mav.setViewName("redirect:/");
		return mav;
	}
	
	@RequestMapping(value="forgetPassword",method=RequestMethod.GET)
	public ModelAndView forgetPassword(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("frontend/login/forget_password");
		return mav;
	}
	
	@RequestMapping(value="signup",method=RequestMethod.GET)
	public ModelAndView signup(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("frontend/signup/signup");
		return mav;
	}

}
