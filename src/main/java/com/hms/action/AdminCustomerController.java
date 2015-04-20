package com.hms.action;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.hms.common.SystemConstant;
import com.hms.dto.Admin;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;
import com.hms.service.AdminCustomerService;

/**
 * <p>Title: AdminCustomerController.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月20日 下午9:59:01
 * @version 1.0
 */
@Controller
@RequestMapping(value="admin/user/customer")
public class AdminCustomerController extends BaseController{
	
	@Autowired
	public AdminCustomerService adminCustomerService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView room(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("admin/user/customer");
		return mav;
	}
	
	@RequestMapping(value="customer_list",method=RequestMethod.GET)
	@ResponseBody
	public String customerList(HttpServletRequest request,DataTableParamer dtp){
		
		PagingData pagingData = adminCustomerService.loadpaPagingData(dtp);
		Object objs[] = null;
		
		if(pagingData.getAaData()==null){
			objs = new Object[]{};
			pagingData.setAaData(objs);
		}
	    return JSON.toJSONString(pagingData);
	}

}
