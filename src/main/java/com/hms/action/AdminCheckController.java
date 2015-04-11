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
import com.hms.dto.Predetemine;
import com.hms.dto.Room;
import com.hms.dto.RoomType;
import com.hms.service.AdminPredetemineOrderService;
import com.hms.service.AdminRoomService;
import com.hms.service.AdminRoomTypeService;

/**
 * <p>Title: AdminCheckController.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月11日 下午5:17:52
 * @version 1.0
 */
@Controller
@RequestMapping(value="admin/checkmanagement/check")
public class AdminCheckController {
	
	@Autowired
	private AdminPredetemineOrderService adminPredetemineOrderService;
	
	@Autowired
	private AdminRoomTypeService adminRoomTypeService;
	
	@Autowired
	private AdminRoomService adminRoomService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView check(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		long today=0;
		try {
			today = sf.parse(sf.format(new Date())).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map <String,String> predetemineOrder = new LinkedHashMap<String, String>();
		Map <Integer,String> roomType = new LinkedHashMap<Integer, String>();
		List<Predetemine> predetemines = adminPredetemineOrderService.loadPredetemineOrderToday(today);
		List<RoomType> roomTypes = adminRoomTypeService.loadAll();
		for(RoomType r : roomTypes){
			roomType.put(r.getId(), r.getType());
		}
		for(Predetemine predetemine : predetemines){
			if(predetemine.getStatus() == 2){
				predetemineOrder.put(predetemine.getPredetermineId(), predetemine.getCustomerName()+"-"
			                         +predetemine.getCustomerIdCard()+"-"
						             +roomType.get(predetemine.getRoomType())+"*"+
			                         predetemine.getNumber());
			}
		}
		mav.addObject("roomType", roomType);
		mav.addObject("predetemineOrder", predetemineOrder);
		mav.setViewName("admin/checkmanagement/check");
		return mav;
	}
	
	@RequestMapping(value="getRoom",method=RequestMethod.POST)
	@ResponseBody
	public String getRoom(HttpServletRequest request,int roomType){
		JSONObject resp = new JSONObject();
		List<Integer> roomId = null;
		try {
			List<Room> rList = adminRoomService.loadRoomByRoomType(roomType);
			roomId = new ArrayList<Integer>();
			for(Room r : rList){
				if(r.getStatus()==0){
					roomId.add(r.getRoomId());
				}
			}
			resp.put("roomId", roomId);
			resp.put("status", true);
		} catch (Exception e) {
			// TODO: handle exception
			resp.put("status", false);
		}
		return JSON.toJSONString(resp);
	}

}
