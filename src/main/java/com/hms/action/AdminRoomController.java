package com.hms.action;

import java.util.ArrayList;
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
import com.hms.dto.RoomType;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;
import com.hms.service.AdminRoomService;
import com.hms.service.AdminRoomTypeService;

/**
 * <p>Title: AdminRoomController.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年3月23日 下午8:52:49
 * @version 1.0
 */
@Controller
@RequestMapping(value="admin/room/room")
public class AdminRoomController {
	
	@Autowired
	private AdminRoomService adminRoomService;
	
	@Autowired
	private AdminRoomTypeService adminRoomTypeService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView room(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		Map<Integer, String> roomTypeMap = null;
		List <RoomType> roomTypes = adminRoomTypeService.loadAll();
		roomTypeMap = new LinkedHashMap<Integer, String>();
		for(RoomType roomType : roomTypes){
		    roomTypeMap.put(roomType.getId(), roomType.getType());
		}
		mav.addObject("roomTypeMap", roomTypeMap);
		mav.setViewName("admin/room/room");
		return mav;
	}
	
	@RequestMapping(value="room_list",method=RequestMethod.GET)
	@ResponseBody
	public String roomList(HttpServletRequest request,DataTableParamer dtp){
		PagingData pagingData = adminRoomService.loadRoomList(dtp);
		Object objs[] = null;
		if(pagingData.getAaData()==null){
			objs = new Object[]{};
			pagingData.setAaData(objs);
		}
	    return JSON.toJSONString(pagingData);
	}

}
