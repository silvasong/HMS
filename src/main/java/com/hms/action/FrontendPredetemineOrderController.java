package com.hms.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hms.common.SystemConstant;
import com.hms.common.UUIDTools;
import com.hms.dao.FrontendRoomPredetemineOrderDao;
import com.hms.dto.Customer;
import com.hms.dto.Predetemine;
import com.hms.model.PredetemineModel;
import com.hms.service.FrontendRoomPredetemineOrderService;

/**
 * <p>Title: FrontendPredetemineController.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月1日 下午7:15:27
 * @version 1.0
 */
@Controller
@RequestMapping(value="frontend/predetemine_order")
public class FrontendPredetemineOrderController extends BaseController{
	
	@Autowired
	private FrontendRoomPredetemineOrderService frontendRoomPredetemineOrderService;
	
	@RequestMapping(value="add_predetemine",method=RequestMethod.POST)
	@ResponseBody
	public String addPredetemine(HttpServletRequest request,PredetemineModel predetemineModel){
		
		JSONObject resp = new JSONObject();
		Predetemine p = new Predetemine();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dates[]=predetemineModel.getTime().split("#");
		try {
			Date start = sdf.parse(dates[0]);
			Date end = sdf.parse(dates[1]);
			Customer customer = (Customer) request.getSession().getAttribute(SystemConstant.CUSTOMER_LOGIN);
			p.setPredetermineId(UUIDTools.getUUIDString());
			p.setIdCard(customer.getIdCard());
			p.setPresetTime(System.currentTimeMillis());
			p.setRoomType(predetemineModel.getRoomTypeId());
			p.setNumber(predetemineModel.getNumber());
			p.setCustomerIdCard(predetemineModel.getIdCard());
			p.setCustomerName(predetemineModel.getName());
			p.setPhone(predetemineModel.getPhone());
			p.setCheckInTime(start.getTime());
			p.setCheckOutTime(end.getTime());
			frontendRoomPredetemineOrderService.createPredetemineOrder(p);
			resp.put("status", true);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			resp.put("status", false);
			e.printStackTrace();
		}
		
		
		
		return JSON.toJSONString(resp);
		
	}
	

}
