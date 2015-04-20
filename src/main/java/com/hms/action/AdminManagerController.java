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
import com.hms.common.SecurityTools;
import com.hms.common.SystemConstant;
import com.hms.dto.Admin;
import com.hms.dto.Room;
import com.hms.dto.RoomType;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;
import com.hms.model.RoomModel;
import com.hms.service.AdminService;

/**
 * <p>Title: AdminManagerController.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月20日 下午6:23:06
 * @version 1.0
 */
@Controller
@RequestMapping(value="admin/user/manager")
public class AdminManagerController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView room(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		Map<Integer, String> roleMap = new LinkedHashMap<Integer, String>();
		Admin admin = (Admin) request.getSession().getAttribute(SystemConstant.ADMIN_LOGIN);
		if(admin.getRoleId()==0){
			roleMap.put(1, "超级管理员");
			roleMap.put(2, "普通管理员");
		}else if(admin.getRoleId()==1){
			roleMap.put(2, "普通管理员");
		}
		mav.addObject("roleMap", roleMap);
		mav.setViewName("admin/user/manager");
		return mav;
	}
	
	@RequestMapping(value="mamager_list",method=RequestMethod.GET)
	@ResponseBody
	public String mamagerList(HttpServletRequest request,DataTableParamer dtp){
		Admin admin = (Admin) request.getSession().getAttribute(SystemConstant.ADMIN_LOGIN);
		PagingData pagingData = adminService.loadAdminPagingData(admin.getRoleId(),dtp);
		Object objs[] = null;
		
		if(pagingData.getAaData()==null){
			objs = new Object[]{};
			pagingData.setAaData(objs);
		}
	    return JSON.toJSONString(pagingData);
	}
	
	@RequestMapping(value="manager_add",method=RequestMethod.POST)
	@ResponseBody
	public String addRoom(HttpServletRequest request,Admin admin){
		JSONObject resp = new JSONObject();
		
		try {
			Admin a = adminService.getByName(admin.getAdminName());
			if(a != null){
				resp.put("status", false);
				resp.put("info", "用户名已经存在");
			}else{
				admin.setPassword(SecurityTools.SHA1(admin.getPassword()));
				adminService.createAdmin(admin);
				resp.put("status", true);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			resp.put("status", false);
			resp.put("info", "添加失败");
		}
		
		return JSON.toJSONString(resp);
	    }
	
	@RequestMapping(value="manager_delete/{ids}",method=RequestMethod.DELETE)
    @ResponseBody
    public String managerDel(HttpServletRequest request,@PathVariable(value="ids") String ids)
    {
		JSONObject resp = new JSONObject();
		try {
			Integer id[] = ConvertTools.stringArr2IntArr(ids.split(","));
			adminService.deleteAdmin(id);
			resp.put("status", true);
		} catch (Exception e) {
			// TODO: handle exception
			resp.put("status", false);
		}
    	return JSON.toJSONString(resp);
    	
    }
	
	@RequestMapping(value="manager_edit",method=RequestMethod.POST)
	@ResponseBody
	public String editManager(HttpServletRequest request,Admin admin){
		JSONObject resp = new JSONObject();
		
		try {
			    Admin a = adminService.getById(admin.getAdminId());
			    a.setRoleId(admin.getRoleId());
			    if(admin.getPassword()!=null && !admin.getPassword().isEmpty()){
			    	a.setPassword(SecurityTools.SHA1(admin.getPassword()));
			    }
			    adminService.updateAdmin(a);
				resp.put("status", true);
				
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resp.put("status", false);
			resp.put("info", "编辑失败");
		}
		
		return JSON.toJSONString(resp);
	    }
	

}
