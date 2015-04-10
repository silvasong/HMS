package com.hms.action;

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
import com.hms.common.SystemConstant;
import com.hms.dto.Admin;
import com.hms.dto.CommentReply;
import com.hms.dto.PredetermineCommend;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;
import com.hms.model.PredetemineCommendModel;
import com.hms.model.PredetemineModel;
import com.hms.service.AdminPredetemineOrderCommendReplyService;
import com.hms.service.AdminPredetemineOrderCommendService;
import com.hms.service.AdminService;

/**
 * <p>Title: AdminPredetemineOrderCommendController.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月10日 下午1:47:21
 * @version 1.0
 */
@Controller
@RequestMapping(value="admin/predetemine/predetemineOrderCommend")
public class AdminPredetemineOrderCommendController {
	
	@Autowired
	private AdminPredetemineOrderCommendService adminPredetemineOrderCommendService;
	
	@Autowired
	private AdminPredetemineOrderCommendReplyService adminPredetemineOrderCommendReplyService;
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView predetemineOrderCommend(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/predetemineorder/predetemine_order_commend");
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="list")
	@ResponseBody
	public String predetemineOrderCommendList(HttpServletRequest request,DataTableParamer dtp){
		PagingData pagingData = adminPredetemineOrderCommendService.loadPagingData(dtp);
		Object obj[]= null;
		if(pagingData.getAaData() == null){
			obj = new Object[]{};
			pagingData.setAaData(obj);
		}else{
			 int i=0;
			obj = new Object[pagingData.getAaData().length];
			for(Object o :pagingData.getAaData()){
				 PredetermineCommend predetermineCommend = (PredetermineCommend)o;
				 CommentReply commentReply = adminPredetemineOrderCommendReplyService.getcCommentReplybyCommendId(predetermineCommend.getCommendId());
				 PredetemineCommendModel predetemineCommendModel = new PredetemineCommendModel();
				 predetemineCommendModel.setCommendId(predetermineCommend.getCommendId());
				 predetemineCommendModel.setCommendContend(predetermineCommend.getCommendContend());
				 predetemineCommendModel.setPredetermineId(predetermineCommend.getPredetermineId());
				 predetemineCommendModel.setScore1(predetermineCommend.getScore1());
				 predetemineCommendModel.setScore2(predetermineCommend.getScore2());
				 predetemineCommendModel.setScore3(predetermineCommend.getScore3());
				 if(commentReply != null){
					 predetemineCommendModel.setReplyContent(commentReply.getReplyContent());
					 Admin admin = adminService.getById(commentReply.getAdminId());
					 predetemineCommendModel.setAdminName(admin.getAdminName());
				 }else{
					 predetemineCommendModel.setReplyContent("");
					 predetemineCommendModel.setAdminName("");
				 }
				
				 obj[i++]=predetemineCommendModel;
			}
			pagingData.setAaData(obj);
		}
		return JSON.toJSONString(pagingData);
	}
	
	@RequestMapping(value="adminReply/{id}",method=RequestMethod.POST)
	@ResponseBody
	public String adminReply(HttpServletRequest request,@PathVariable(value="id") String id,String content){
		JSONObject resp = new JSONObject();
		try {
			Admin admin = (Admin)request.getSession().getAttribute(SystemConstant.ADMIN_LOGIN);
			CommentReply reply = adminPredetemineOrderCommendReplyService.getcCommentReplybyCommendId(Integer.parseInt(id));
			if(reply != null){
				reply.setReplyContent(content);
				reply.setAdminId(admin.getAdminId());
				adminPredetemineOrderCommendReplyService.updateCommentRely(reply);
			}else{
				reply = new CommentReply();
				reply.setCommendId(Integer.parseInt(id));
				reply.setReplyContent(content);
				reply.setAdminId(admin.getAdminId());
				adminPredetemineOrderCommendReplyService.createCommentRely(reply);
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
