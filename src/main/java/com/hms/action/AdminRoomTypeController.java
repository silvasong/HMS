package com.hms.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;
import com.hms.service.AdminRoomTypeService;

/**
 * <p>Title: AdminRoomType.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年3月13日 下午11:18:36
 * @version 1.0
 */
@Controller
@RequestMapping(value="admin/room/room_type")
public class AdminRoomTypeController {
	
	@Autowired
	private AdminRoomTypeService adminRoomTypeService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView roomType(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/room/room_type");
		return mav;
	}
	
	@RequestMapping(value="room_type_list",method=RequestMethod.GET)
	@ResponseBody
	public String roomTypeList(HttpServletRequest request,DataTableParamer dtp){
		PagingData pagingData = adminRoomTypeService.loadRoomTypeList(dtp);
		Object objs[] = null;
		if(pagingData.getAaData()==null){
			objs = new Object[]{};
			pagingData.setAaData(objs);
		}
	    return JSON.toJSONString(pagingData);
	}

}
