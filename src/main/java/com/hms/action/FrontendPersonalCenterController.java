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
import com.hms.common.SystemConstant;
import com.hms.dto.Customer;
import com.hms.model.PasswordModel;
import com.hms.service.FrontendCustomerService;

/**
 * <p>Title: FrontendPersonalCenterController.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月5日 下午4:01:32
 * @version 1.0
 */
@Controller
@RequestMapping(value="frontend/personal_center")
public class FrontendPersonalCenterController extends BaseController{
	
	@Autowired
	private FrontendCustomerService frontendCustomerService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView personalCenter(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		Customer customer = (Customer) request.getSession().getAttribute(SystemConstant.CUSTOMER_LOGIN);
		if(customer != null){
			mav.addObject("customer", customer);
			mav.setViewName("frontend/personal_center/personal_center");
		}else{
			mav.setViewName("redirect:/frontend/login");
		}
		return mav;
	}
	
	@RequestMapping(value="edit_personal",method=RequestMethod.POST)
	@ResponseBody
	public String personalEdit(HttpServletRequest request,Customer cust,HttpSession session){
		JSONObject resp = new JSONObject();
		try {
			Customer customer = frontendCustomerService.getCustomerByIdcard(cust.getIdCard());
			if(customer != null){
				removeCustomerSession(session);
				customer.setName(cust.getName());
				customer.setEmail(cust.getEmail());
				customer.setPhone(cust.getPhone());
				customer.setAddress(cust.getAddress());
				frontendCustomerService.updateCustomer(customer);
				//frontendCustomerService.deleteCustomer(customer);
				//frontendCustomerService.createCustomer(customer);
				setCustomerSession(request, customer);
				resp.put("status", true);
			}else{
				resp.put("status", false);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resp.put("status", false);
		}
		return JSON.toJSONString(resp);
	}
    
	@RequestMapping(value="edit_password",method=RequestMethod.POST)
	@ResponseBody
	public String editPassword(HttpServletRequest request,HttpSession session,PasswordModel pModel){
		JSONObject resp = new JSONObject();
		try {
			Customer customer = (Customer) session.getAttribute(SystemConstant.CUSTOMER_LOGIN);
			if(customer != null && customer.getPassword().equals(SecurityTools.SHA1(pModel.getPassword()))){
				removeCustomerSession(session);
				customer.setPassword(SecurityTools.SHA1(pModel.getNewpassword()));
				frontendCustomerService.updateCustomer(customer);
				//frontendCustomerService.deleteCustomer(customer);
				//frontendCustomerService.createCustomer(customer);
				setCustomerSession(request, customer);
				resp.put("status", true);
			}else{
				resp.put("status", false);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resp.put("status", false);
		}
		return JSON.toJSONString(resp);
	}
	
}
