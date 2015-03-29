package com.hms.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hms.common.SecurityTools;
import com.hms.dto.Customer;
import com.hms.service.FrontendCustomerService;

/**
 * <p>Title: FrontendCus.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年3月29日 下午5:24:03
 * @version 1.0
 */
@RequestMapping(value="frontend/customer")
@Controller
public class FrontendCustomerController extends BaseController{
	
	@Autowired
	private FrontendCustomerService frontendCustomerService;
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	@ResponseBody
	public String registerCustomer(HttpServletRequest request,Customer cust){
		JSONObject resp = new JSONObject();
		try {
			
			Customer customer = frontendCustomerService.getCustomerByIdcard(cust.getIdCard());
			if(customer != null){
				resp.put("status", false);
				resp.put("info","注册失败，身份证已经存在.");
			}else{
				cust.setPassword(SecurityTools.SHA1(cust.getPassword()));
				frontendCustomerService.createCustomer(cust);
				resp.put("status", true);
			}
		} catch (Exception e) {
			// TODO: handle exception
			resp.put("status", false);
			resp.put("info","注册失败.");
		}
		
		
		return JSON.toJSONString(resp);
	}

}
