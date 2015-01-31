package com.hms.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.transform.impl.AddDelegateTransformer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hms.common.SecurityTools;
import com.hms.dto.Admin;
import com.hms.service.AdminService;

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
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		Admin admin = new Admin();
		mav.addObject("admin", admin);
		mav.setViewName("admin/login/login");
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,Admin admin){
		
		ModelAndView mav = new ModelAndView();
		String msg = "用户名或密码错误";
		String toUrl = "";
		Admin adminUser = adminService.getByName(admin.getAdminName());
		if(adminUser == null){
			mav.addObject("admin", admin);
			mav.addObject("msg", msg);
		}else if(!SecurityTools.SHA1(admin.getPassword()).equals(adminUser.getPassword())){
			mav.addObject("admin", admin);
			mav.addObject("msg", msg);
		}else{
			setAdminSession(request, adminUser);
			toUrl = "/admin/dashbord";
		}
		mav.setViewName("redirect:"+toUrl);
		return mav;
		
	}

}
