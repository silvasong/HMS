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
import com.hms.common.ConvertTools;
import com.hms.dto.NewType;
import com.hms.dto.RoomType;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;
import com.hms.service.AdminNewTypeService;

/**
 * <p>Title: AdminNewTypeController.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月14日 下午9:32:19
 * @version 1.0
 */
@Controller
@RequestMapping(value="admin/new/newType")
public class AdminNewTypeController extends BaseController{
	
	@Autowired
	private AdminNewTypeService adminNewTypeService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView newType(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/new/new_type");
		return mav;
	}
    
	@RequestMapping(value="new_type_list",method=RequestMethod.GET)
	@ResponseBody
	public String roomTypeList(HttpServletRequest request,DataTableParamer dtp){
		PagingData pagingData = adminNewTypeService.loadNewTypePagingData(dtp);
		Object objs[] = null;
		if(pagingData.getAaData()==null){
			objs = new Object[]{};
			pagingData.setAaData(objs);
		}
	    return JSON.toJSONString(pagingData);
	}
	
	@RequestMapping(value="new_type_add",method=RequestMethod.POST)
    @ResponseBody
    public String newTypeAdd(HttpServletRequest request,NewType newType)
    {
		JSONObject resp = new JSONObject();
		try {
			adminNewTypeService.createNewType(newType);
			resp.put("status", true);
		} catch (Exception e) {
			// TODO: handle exception
			resp.put("status", false);
		}
    	return JSON.toJSONString(resp);
    	
    }
	
	@RequestMapping(value="new_type_edit",method=RequestMethod.POST)
    @ResponseBody
    public String roomTypeEdit(HttpServletRequest request,NewType newType)
    {
		JSONObject resp = new JSONObject();
		try {
			
			adminNewTypeService.updateNewType(newType);
			resp.put("status", true);
		} catch (Exception e) {
			// TODO: handle exception
			resp.put("status", false);
		}
    	return JSON.toJSONString(resp);
    	
    }
	
	@RequestMapping(value="new_type_delete/{ids}",method=RequestMethod.DELETE)
    @ResponseBody
    public String newTypeDel(HttpServletRequest request,@PathVariable(value="ids") String ids)
    {
		JSONObject resp = new JSONObject();
		try {
			Integer id[] = ConvertTools.stringArr2IntArr(ids.split(","));
			adminNewTypeService.deleteNewTypeById(id);
			resp.put("status", true);
		} catch (Exception e) {
			// TODO: handle exception
			resp.put("status", false);
		}
    	return JSON.toJSONString(resp);
    	
    }
}
