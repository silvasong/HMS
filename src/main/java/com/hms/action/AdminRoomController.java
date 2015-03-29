package com.hms.action;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hms.common.ConvertTools;
import com.hms.dto.Room;
import com.hms.dto.RoomType;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;
import com.hms.model.RoomModel;
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
public class AdminRoomController extends BaseController{
	
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
	
	@RequestMapping(value="room_add",method=RequestMethod.POST)
	@ResponseBody
	public String addRoom(HttpServletRequest request,RoomModel roomModel){
		JSONObject resp = new JSONObject();
		
		try {
			Room room = adminRoomService.getRoomById(roomModel.getRoomId());
			if(room != null){
				resp.put("status", false);
				resp.put("info", "房间号已经存在");
			}else{
				RoomType roomType = adminRoomTypeService.getRoomTypeById(roomModel.getRoomType());
				room = new Room();
				room.setRoomId(roomModel.getRoomId());
				room.setRoomType(roomType);
				room.setStatus(roomModel.getStatus());
				adminRoomService.createRoom(room);
				resp.put("status", true);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			resp.put("status", false);
			resp.put("info", "添加失败");
		}
		
		return JSON.toJSONString(resp);
	    }
	    
	@RequestMapping(value="room_edit",method=RequestMethod.POST)
	@ResponseBody
	public String editRoom(HttpServletRequest request,RoomModel roomModel){
		JSONObject resp = new JSONObject();
		
		try {
			Room room = adminRoomService.getRoomById(roomModel.getRoomId());
			RoomType roomType = adminRoomTypeService.getRoomTypeById(roomModel.getRoomType());
			room.setRoomType(roomType);
			room.setStatus(roomModel.getStatus());
			adminRoomService.updateRoom(room);
				resp.put("status", true);
				
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resp.put("status", false);
			resp.put("info", "编辑失败");
		}
		
		return JSON.toJSONString(resp);
	    }
	
	@RequestMapping(value="room_delete/{ids}",method=RequestMethod.DELETE)
    @ResponseBody
    public String roomDel(HttpServletRequest request,@PathVariable(value="ids") String ids)
    {
		JSONObject resp = new JSONObject();
		try {
			Integer id[] = ConvertTools.stringArr2IntArr(ids.split(","));
			adminRoomService.deleteRoom(id);
			resp.put("status", true);
		} catch (Exception e) {
			// TODO: handle exception
			resp.put("status", false);
		}
    	return JSON.toJSONString(resp);
    	
    }

}
