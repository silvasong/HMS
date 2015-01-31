package com.hms.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hms.common.SystemConstant;
import com.hms.dto.Admin;

/**
 * <p>Title: BaseController.java</p>
 * <p>Description: Spring MVC Controller基类</p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2014年12月27日 下午5:25:00
 * @version 1.0
 */
public class BaseController {
	
	public void setAdminSession(HttpServletRequest request,Admin admin){
		request.getSession().setAttribute(SystemConstant.ADMIN_LOGIN, admin);
	}
	
	public void removeAdminSession(HttpSession session){
		session.removeAttribute(SystemConstant.ADMIN_LOGIN);
	}
	

}
