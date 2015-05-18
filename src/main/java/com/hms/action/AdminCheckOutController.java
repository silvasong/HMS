package com.hms.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hms.common.SystemConstant;
import com.hms.dto.Admin;
import com.hms.dto.Predetemine;
import com.hms.dto.Registration;
import com.hms.dto.Room;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;
import com.hms.model.RegistrationModel;
import com.hms.service.AdminPredetemineOrderService;
import com.hms.service.AdminRegistrationService;
import com.hms.service.AdminRoomService;

/**
 * <p>Title: AdminCheckOutController.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月13日 下午9:12:14
 * @version 1.0
 */
@Controller
@RequestMapping(value="admin/checkmanagement/checkOut")
public class AdminCheckOutController extends BaseController{
	
	@Autowired
	private AdminRegistrationService adminRegistrationService;
	
	@Autowired 
	private AdminRoomService adminRoomService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView checkOut(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/checkmanagement/checkout");
		return mav;
		
	}
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	@ResponseBody
	public String registrationList(HttpServletRequest request,DataTableParamer dtp){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		PagingData pagingData = adminRegistrationService.loadRegistrationPagingData(dtp);
		Object[] obj = null;
		if(pagingData.getAaData() == null){
			obj = new Object[]{};
			pagingData.setAaData(obj);
		}else{
			int i=0;
			obj = new Object[pagingData.getAaData().length];
			for(Object o : pagingData.getAaData()){
				Registration registration = (Registration) o;
				RegistrationModel registrationModel = new RegistrationModel();
				registrationModel.setCheckInAdmin(registration.getCheckInAdmin()+"");
				registrationModel.setCheckInTime(sf.format(new Date(registration.getCheckInTime())));
				registrationModel.setCheckOutAdmin(registration.getCheckOutAdmin()+"");
				registrationModel.setCheckOutTime(sf.format(new Date(registration.getCheckOutTime())));
				registrationModel.setCost(registration.getCost());
				registrationModel.setCustomer(registration.getCustomerName()+"("+registration.getCustomerIdCard()+")");
				registrationModel.setId(registration.getId());
				registrationModel.setMargin(registration.getMargin());
				registrationModel.setRoomId(registration.getRoomId());
				registrationModel.setStatus(registration.getStatus());
				obj[i++]=registrationModel;
				
			}
			pagingData.setAaData(obj);
		}
		return JSON.toJSONString(pagingData);
	}
	
	@RequestMapping(value="manager/{ids}",method=RequestMethod.POST)
	@ResponseBody
	public String predetemineOrderManager(HttpServletRequest request,@PathVariable(value="ids") String ids){
		JSONObject resp = new JSONObject();
		try {
			String [] id = ids.split(",");
			for(String i : id){
				Registration registration = adminRegistrationService.getRegistrationById(i);
				registration.setStatus(0);
				Admin admin = (Admin)request.getSession().getAttribute(SystemConstant.ADMIN_LOGIN);
				registration.setCheckOutAdmin(admin.getAdminId());
				Room room = adminRoomService.getRoomById(registration.getRoomId());
				room.setStatus(0);
				adminRoomService.updateRoom(room);
				adminRegistrationService.updateRegistrationById(registration);
				
			}
			resp.put("status", true);
		} catch (Exception e) {
			// TODO: handle exception
			resp.put("status", false);
		}
		return JSON.toJSONString(resp);
	}

}
