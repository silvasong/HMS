package com.hms.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hms.common.SystemConstant;
import com.hms.dto.Customer;
import com.hms.dto.RoomType;
import com.hms.model.PredetemineModel;
import com.hms.service.FrontendRoomPredetermineService;

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
	
	@Autowired
	private FrontendRoomPredetermineService frontendRoomPredetermineService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView onlineOrder(HttpServletRequest request){
		Customer customer = (Customer) request.getSession().getAttribute(SystemConstant.CUSTOMER_LOGIN);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String todayString = sf.format(new Date());
		String tomorrowString="";
		try {
			 tomorrowString = sf.format(new Date(sf.parse(sf.format(new Date())).getTime()+86400000));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView();
		Map <Integer,List<String>> roomTypeMap = new LinkedHashMap<Integer, List<String>>();
		List <String> roomList = null;
		List <RoomType> roomTypes = frontendRoomPredetermineService.loadAllRoomTypes();
		Map<Integer, Integer> roomTypeStatic = frontendRoomPredetermineService.getRoomTypeStatic(0, 0);
		if(roomTypes != null){
			for(RoomType roomType : roomTypes){
				roomList = new ArrayList<String>();
				roomList.add(roomType.getType());
				roomList.add(roomType.getBreakfast());
				roomList.add(roomType.getCancellation());
				roomList.add(roomType.getDiscountPrice()+"");
				roomList.add(roomType.getBedtype());
				roomList.add(roomType.getBedNumber()+"");
				roomList.add(roomType.getFloor());
				roomList.add(roomType.getNetwork());
				roomList.add(roomTypeStatic.get(roomType.getId())+"");
				roomTypeMap.put(roomType.getId(), roomList);
			}
		}
		mav.addObject("roomTypeMap", roomTypeMap);
		mav.addObject("start",todayString);
		mav.addObject("end", tomorrowString);
		if(customer == null){
			mav.addObject("login",false);
		}
		mav.setViewName("frontend/onlineorder/online_order");
		return mav;
	}
	
	
	

}
