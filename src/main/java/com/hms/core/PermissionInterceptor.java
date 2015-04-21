package com.hms.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hms.common.SystemConstant;
import com.hms.dto.Admin;

/**
 * <p>Title: Interceptor.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年1月31日 下午9:50:21
 * @version 1.0
 */
public class PermissionInterceptor implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		String url = arg0.getRequestURI();
		if(url.contains("admin")){
			Admin admin = (Admin)arg0.getSession().getAttribute(SystemConstant.ADMIN_LOGIN);
			if(admin == null){
				arg1.sendRedirect(arg0.getContextPath()+"/admin/login");
				return false;
			}
		}
		return true;
	}

}
