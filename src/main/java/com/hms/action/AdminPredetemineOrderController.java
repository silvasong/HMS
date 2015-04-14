package com.hms.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.util.JsonExpectationsHelper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hms.dto.Predetemine;
import com.hms.dto.RoomType;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;
import com.hms.model.PredetemineOrderModel;
import com.hms.service.AdminPredetemineOrderService;
import com.hms.service.AdminRoomTypeService;

/**
 * <p>Title: AdminPredetemineOrderController.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月10日 下午1:42:52
 * @version 1.0
 */
@Controller
@RequestMapping(value="admin/predetemine/predetemineOrder")
public class AdminPredetemineOrderController extends BaseController{
	
	@Autowired
	private AdminPredetemineOrderService adminPredetemineOrderService;
	
	@Autowired
	private AdminRoomTypeService adminRoomTypeService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView predetemineOrder(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/predetemineorder/predetemine_order");
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="list")
	@ResponseBody
	public String predetemineOrderList(HttpServletRequest request,DataTableParamer dtp){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<RoomType> roomTypes = adminRoomTypeService.loadAll();
		Map<Integer, String> roomTypeMap = new LinkedHashMap<Integer, String>();
		for(RoomType roomType : roomTypes){
			roomTypeMap.put(roomType.getId(), roomType.getType());
		}
		PagingData pagingData = adminPredetemineOrderService.loadPredetemineOrderPagingData(dtp);
		Object []obj = null;
		PredetemineOrderModel predetemineOrderModel = null;
		Predetemine predetemine = null;
		if(pagingData.getAaData() == null){
			obj = new Object[]{};
			pagingData.setAaData(obj);
		}else{
			Object []aObject = pagingData.getAaData();
			obj = new Object[aObject.length];
			int i = 0;
			for(Object o :aObject){
				predetemineOrderModel = new PredetemineOrderModel();
				predetemine = (Predetemine) o;
				predetemineOrderModel.setPredetermineId(predetemine.getPredetermineId());
				predetemineOrderModel.setIdCard(predetemine.getIdCard());
				predetemineOrderModel.setRoomType(roomTypeMap.get(predetemine.getRoomType())+"*"+predetemine.getNumber());
				predetemineOrderModel.setPrice(predetemine.getPrice());
				predetemineOrderModel.setCustomerIdCard(predetemine.getCustomerName()+"("+predetemine.getCustomerIdCard()+")");
				predetemineOrderModel.setPresetTime(sdftime.format(new Date(predetemine.getPresetTime())));
				predetemineOrderModel.setCheckInTime(sdf.format(new Date(predetemine.getCheckInTime())));
				predetemineOrderModel.setCheckOutTime(sdf.format(new Date(predetemine.getCheckOutTime())));
				predetemineOrderModel.setStatus(predetemine.getStatus());
				aObject[i++]=predetemineOrderModel;
			}
		}
		return JSON.toJSONString(pagingData);
	}
	
	@RequestMapping(value="manager/{ids}",method=RequestMethod.POST)
	@ResponseBody
	public String predetemineOrderManager(HttpServletRequest request,@PathVariable(value="ids") String ids ,@RequestParam(value="flag") int flag){
		JSONObject resp = new JSONObject();
		try {
			String [] id = ids.split(",");
			for(String i : id){
				Predetemine predetemine = adminPredetemineOrderService.getPredetemineOrderById(i);
				if(flag == 0){
					predetemine.setStatus(1);
				}else{
					predetemine.setStatus(2);
				}
				adminPredetemineOrderService.updatePredetemineOrder(predetemine);
			}
			resp.put("status", true);
		} catch (Exception e) {
			// TODO: handle exception
			resp.put("status", false);
		}
		return JSON.toJSONString(resp);
	}

}
