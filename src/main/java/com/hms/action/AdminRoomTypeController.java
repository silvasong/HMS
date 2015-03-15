package com.hms.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hms.common.ConvertTools;
import com.hms.common.SystemCache;
import com.hms.common.SystemConstant;
import com.hms.common.UUIDTools;
import com.hms.dto.RoomType;
import com.hms.dto.Setting;
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
	
	@RequestMapping(value="room_type_add",method=RequestMethod.POST)
    @ResponseBody
    public String roomTypeAdd(HttpServletRequest request,RoomType roomType)
    {
		JSONObject resp = new JSONObject();
		try {
			adminRoomTypeService.createRoomType(roomType);
			resp.put("status", true);
		} catch (Exception e) {
			// TODO: handle exception
			resp.put("status", false);
		}
    	return JSON.toJSONString(resp);
    	
    }
	@RequestMapping(value="room_type_delete/{ids}",method=RequestMethod.DELETE)
    @ResponseBody
    public String roomTypeDel(HttpServletRequest request,@PathVariable(value="ids") String ids)
    {
		JSONObject resp = new JSONObject();
		try {
			Integer id[] = ConvertTools.stringArr2IntArr(ids.split(","));
			adminRoomTypeService.deleteRoomType(id);
			resp.put("status", true);
		} catch (Exception e) {
			// TODO: handle exception
			resp.put("status", false);
		}
    	return JSON.toJSONString(resp);
    	
    }
	
	@RequestMapping(value="room_type_edit",method=RequestMethod.POST)
    @ResponseBody
    public String roomTypeEdit(HttpServletRequest request,RoomType roomType)
    {
		JSONObject resp = new JSONObject();
		try {
			
			adminRoomTypeService.updateRoomType(roomType);
			resp.put("status", true);
		} catch (Exception e) {
			// TODO: handle exception
			resp.put("status", false);
		}
    	return JSON.toJSONString(resp);
    	
    }
	
	@RequestMapping(value="room_type_uploadImages",method=RequestMethod.POST)
    @ResponseBody
    public String uploadImages(HttpServletRequest request,@RequestParam("file")MultipartFile file)
    {
		JSONObject resp = new JSONObject();
		String imgName = UUIDTools.getUUIDString().substring(0, 10)+".jpg";
		SystemCache.room_type_image.put(imgName, file);
		resp.put("result", "OK");
    	return JSON.toJSONString(resp);
    	
    }

}
