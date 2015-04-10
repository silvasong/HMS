package com.hms.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
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
import com.hms.common.UUIDTools;
import com.hms.dao.FrontendRoomPredetemineOrderDao;
import com.hms.dto.CommentReply;
import com.hms.dto.Customer;
import com.hms.dto.Predetemine;
import com.hms.dto.PredetermineCommend;
import com.hms.dto.RoomType;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;
import com.hms.model.PredetemineModel;
import com.hms.model.PredetemineOrderModel;
import com.hms.service.AdminRoomTypeService;
import com.hms.service.FrontendRoomPredetemineOrderCommendReplyService;
import com.hms.service.FrontendRoomPredetemineOrderCommendService;
import com.hms.service.FrontendRoomPredetemineOrderService;
import com.hms.service.impl.FrontendRoomPredetemineOrderCommendServiceImpl;

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
	
	@Autowired
	private AdminRoomTypeService adminRoomTypeService;
	
	@Autowired
	private FrontendRoomPredetemineOrderCommendService frontendRoomPredetemineOrderCommendService;
	
	@Autowired
	private FrontendRoomPredetemineOrderCommendReplyService frontendRoomPredetemineOrderCommendReplyService;
	
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
			p.setPredetermineId(UUIDTools.getUUIDString().substring(0, 10));
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
	
	@RequestMapping(value="order_list",method=RequestMethod.GET)
	@ResponseBody
	public String predetemineOrderList(HttpServletRequest request ,DataTableParamer dtp){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<RoomType> roomTypes = adminRoomTypeService.loadAll();
		Map<Integer, String> roomTypeMap = new LinkedHashMap<Integer, String>();
		for(RoomType roomType : roomTypes){
			roomTypeMap.put(roomType.getId(), roomType.getType());
		}
		PagingData pagingData = frontendRoomPredetemineOrderService.predetemineOrderList(dtp);
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
				predetemineOrderModel.setRoomType(roomTypeMap.get(predetemine.getRoomType())+"*"+predetemine.getNumber());
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
	
	@RequestMapping(value="order_qx/{ids}",method=RequestMethod.POST)
	@ResponseBody
	public String qxOrder(HttpServletRequest request,@PathVariable(value="ids") String ids){
		JSONObject resp = new JSONObject();
		
		
		try {
			String id[] = ids.split(",");
			for(String i : id){
				Predetemine predetemine = frontendRoomPredetemineOrderService.getPredetemineById(i);
				predetemine.setStatus(1);
				frontendRoomPredetemineOrderService.updatePredete(predetemine);
			}
			resp.put("status", true);
		} catch (Exception e) {
			// TODO: handle exception
			resp.put("status", false);
		}
		
		return JSON.toJSONString(resp);
		
	}
	
	@RequestMapping(value="order_commend",method=RequestMethod.POST)
	@ResponseBody
	public String commendOrder(HttpServletRequest request,PredetermineCommend pc){
		JSONObject resp = new JSONObject();
		try {
			frontendRoomPredetemineOrderCommendService.createPredetemineOrderCommend(pc);
			Predetemine predetemine = frontendRoomPredetemineOrderService.getPredetemineById(pc.getPredetermineId());
			predetemine.setStatus(5);
			frontendRoomPredetemineOrderService.updatePredete(predetemine);
			resp.put("status", true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resp.put("status", false);
		}
		
		return JSON.toJSONString(resp);
		
	}
	
	@RequestMapping(value="order_commend_reply",method=RequestMethod.GET)
	@ResponseBody
	public String commendOrderReply(HttpServletRequest request,@RequestParam(value="predetermineId") String predetermineId ){
		JSONObject resp = new JSONObject();
		try {
			PredetermineCommend predetermineCommend = frontendRoomPredetemineOrderCommendService.getCommendByPredetemineId(predetermineId);
			CommentReply commentReply = frontendRoomPredetemineOrderCommendReplyService.getcCommentReplyByCommendId(predetermineCommend.getCommendId());
			resp.put("CommendContend", predetermineCommend.getCommendContend());
			resp.put("score1", predetermineCommend.getScore1());
			resp.put("score2", predetermineCommend.getScore2());
			resp.put("score3", predetermineCommend.getScore3());
			if(commentReply != null){
				resp.put("CommendReply", commentReply.getReplyContent());
			}
			resp.put("status", true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resp.put("status", false);
		}
		
		return JSON.toJSONString(resp);
		
	}

}
