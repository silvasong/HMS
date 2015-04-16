package com.hms.action;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.hms.dto.NewType;
import com.hms.dto.News;
import com.hms.dto.RoomType;
import com.hms.model.DataTableParamer;
import com.hms.model.NewsModel;
import com.hms.model.PagingData;
import com.hms.service.AdminNewService;
import com.hms.service.AdminNewTypeService;

/**
 * <p>Title: AdminNewController.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月16日 下午1:22:37
 * @version 1.0
 */
@Controller
@RequestMapping(value="admin/new/new")
public class AdminNewController extends BaseController{
	
	@Autowired
	private AdminNewService adminNewService;
	
	@Autowired
	private AdminNewTypeService adminNewTypeService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView news(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		Map <Integer,String> map = new LinkedHashMap<Integer, String>();
		List<NewType> list = adminNewTypeService.loadNewTypes();
		for(NewType type : list){
			map.put(type.getId(), type.getName());
		}
		mav.addObject("newType", map);
		mav.setViewName("admin/new/new");
		return  mav;
	}
	
	@RequestMapping(value="new_list",method=RequestMethod.GET)
	@ResponseBody
	public String roomList(HttpServletRequest request,DataTableParamer dtp){
		PagingData pagingData = adminNewService.loadNewPagingData(dtp);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
		Object objs[] = null;
		if(pagingData.getAaData()==null){
			objs = new Object[]{};
			pagingData.setAaData(objs);
		}else{
			int i = 0;
			NewsModel newsModel = null;
			objs = new Object[pagingData.getAaData().length];
			for(Object o : pagingData.getAaData()){
				News news = (News) o;
				NewType newType = adminNewTypeService.getNewTypeById(news.getNewType());
				newsModel = new NewsModel();
				newsModel.setId(news.getNewId());
				newsModel.setNewAuthor(news.getNewAuthor());
				newsModel.setNewContent(news.getNewContent());
				newsModel.setNewTitle(news.getNewTitle());
				newsModel.setNewType(newType.getName());
				newsModel.setNewTime(sf.format(new Date(news.getNewTime())));
				objs[i++] = newsModel;
			}
			pagingData.setAaData(objs);
		}
	    return JSON.toJSONString(pagingData);
	}
	
	@RequestMapping(value="new_add",method=RequestMethod.POST)
    @ResponseBody
    public String newAdd(HttpServletRequest request,News news)
    {
		JSONObject resp = new JSONObject();
		try {
			news.setNewTime(System.currentTimeMillis());
			adminNewService.createNews(news);
			resp.put("status", true);
		} catch (Exception e) {
			// TODO: handle exception
			resp.put("status", false);
		}
    	return JSON.toJSONString(resp);
    	
    }
	
	@RequestMapping(value="new_edit",method=RequestMethod.POST)
    @ResponseBody
    public String roomEdit(HttpServletRequest request,News news)
    {
		JSONObject resp = new JSONObject();
		try {
			news.setNewTime(System.currentTimeMillis());
			adminNewService.updateNews(news);
			
			resp.put("status", true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resp.put("status", false);
		}
    	return JSON.toJSONString(resp);
    	
    }
	
	@RequestMapping(value="new_delete/{ids}",method=RequestMethod.DELETE)
    @ResponseBody
    public String newDel(HttpServletRequest request,@PathVariable(value="ids") String ids)
    {
		JSONObject resp = new JSONObject();
		try {
			Integer id[] = ConvertTools.stringArr2IntArr(ids.split(","));
			adminNewService.deleteNews(id);
			resp.put("status", true);
		} catch (Exception e) {
			// TODO: handle exception
			resp.put("status", false);
		}
    	return JSON.toJSONString(resp);
    	
    }

}
