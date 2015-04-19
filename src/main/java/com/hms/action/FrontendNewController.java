package com.hms.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hms.common.SystemConstant;
import com.hms.dto.NewType;
import com.hms.dto.News;
import com.hms.dto.Setting;
import com.hms.model.DataPageParamer;
import com.hms.model.NewsModel;
import com.hms.model.PagingData;
import com.hms.service.AdminNewTypeService;
import com.hms.service.FrontendNewService;
import com.hms.service.SettingService;

/**
 * <p>Title: FrontendNewController.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月18日 下午4:40:36
 * @version 1.0
 */
@Controller
@RequestMapping(value="frontend/news")
public class FrontendNewController {
	
	@Autowired
	private FrontendNewService frontendNewService;
	
	@Autowired
	private AdminNewTypeService adminNewTypeService;
	
	@Autowired
	private SettingService settingService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView news(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		Map<Integer, String> newTypeMap = new LinkedHashMap<Integer, String>();
		List<NewType> newTypes = adminNewTypeService.loadNewTypes();
		for (NewType n : newTypes) {
			List<News> newsList = frontendNewService.getNewByNewType(n.getId());
			newTypeMap.put(n.getId(), n.getName()+"("+newsList.size()+")");
		}
		mav.addObject("newTypeMap", newTypeMap);
		
		Setting setting = settingService.getSettingByKey(SystemConstant.INDEX_BG);
		if(setting != null && !setting.getValue().isEmpty()){
			    List<String> img = new ArrayList<String>();
				String []strs = setting.getValue().substring(0, setting.getValue().length()-1).split("#");
				for(String s : strs){
					img.add("../upload/admin/setting/index_bg/"+s);
				}
				mav.addObject("img", img);
		}
		
		mav.setViewName("frontend/new/news");
		return mav;
	}
    
	@RequestMapping(value="news_list",method=RequestMethod.GET)
	@ResponseBody
	public String newsList(HttpServletRequest request , DataPageParamer dpp){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
		JSONObject resp = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = null;
		PagingData pagingData = frontendNewService.loadPagingData(dpp);
		if(pagingData.getAaData()==null){
			resp.put("data", jsonArray);
			resp.put("total", pagingData.getITotalRecords());
		}else{
			for(Object o : pagingData.getAaData()){
				News news = (News) o;
				jsonObject = new JSONObject();
				jsonObject.put("newId", news.getNewId());
				jsonObject.put("newTitle",news.getNewTitle());
				jsonObject.put("newTime", sdf.format(new Date(news.getNewTime())));
				jsonObject.put("newAuthor", news.getNewAuthor());
				jsonArray.add(jsonObject);
			}
			resp.put("data", jsonArray);
			resp.put("total", pagingData.getITotalRecords());
		}
		return JSON.toJSONString(resp);
	}
	
	@RequestMapping(value="news_item",method=RequestMethod.GET)
	public ModelAndView newsItem(HttpServletRequest request,@RequestParam(value="id")int id){
		ModelAndView mav = new ModelAndView();
		Map <Integer,String> relatedNews = new LinkedHashMap<Integer, String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
		NewsModel newsModel = new NewsModel();
		News news = frontendNewService.getNewsById(id);
		newsModel.setId(news.getNewId());
		newsModel.setNewAuthor(news.getNewAuthor());
		newsModel.setNewTitle(news.getNewTitle());
		newsModel.setNewTime(sdf.format(new Date(news.getNewTime())));
		newsModel.setNewContent(news.getNewContent());
		NewType newType = adminNewTypeService.getNewTypeById(news.getNewType());
		newsModel.setNewType(newType.getName());
		DataPageParamer dpp = new DataPageParamer();
		dpp.setType(newType.getId());
		dpp.setPageIndex(0);
		dpp.setPageSize(20);
		PagingData pagingData = frontendNewService.loadPagingDataByType(dpp);
		if(pagingData.getAaData()!=null){
			for(Object object : pagingData.getAaData()){
				News n = (News) object;
				relatedNews.put(n.getNewId(), n.getNewTitle());
			}
		}
		mav.addObject("news", newsModel);
		mav.addObject("relatedNews", relatedNews);
		mav.setViewName("frontend/new/news_item");
		return mav;
	}
	
	@RequestMapping(value="news_type",method=RequestMethod.GET)
	public ModelAndView newsType(HttpServletRequest request,@RequestParam(value="id") int id){
		ModelAndView mav = new ModelAndView();
		NewType newType = adminNewTypeService.getNewTypeById(id);
		Map<Integer, String> newTypeMap = new LinkedHashMap<Integer, String>();
		List<NewType> newTypes = adminNewTypeService.loadNewTypes();
		for (NewType n : newTypes) {
			List<News> newsList = frontendNewService.getNewByNewType(n.getId());
			newTypeMap.put(n.getId(), n.getName()+"("+newsList.size()+")");
		}
		
		
		mav.addObject("newTypeMap", newTypeMap);
		mav.addObject("newType", newType.getName());
		mav.addObject("id", id);
		mav.setViewName("frontend/new/news_type");
		return mav;
	}
	
	@RequestMapping(value="news_type_list",method=RequestMethod.GET)
	@ResponseBody
	public String newsTypeList(HttpServletRequest request , DataPageParamer dpp){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
		JSONObject resp = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = null;
		PagingData pagingData = frontendNewService.loadPagingDataByType(dpp);
		if(pagingData.getAaData()==null){
			resp.put("data", jsonArray);
			resp.put("total", pagingData.getITotalRecords());
		}else{
			for(Object o : pagingData.getAaData()){
				News news = (News) o;
				jsonObject = new JSONObject();
				jsonObject.put("newId", news.getNewId());
				jsonObject.put("newTitle",news.getNewTitle());
				jsonObject.put("newTime", sdf.format(new Date(news.getNewTime())));
				jsonObject.put("newAuthor", news.getNewAuthor());
				jsonArray.add(jsonObject);
			}
			resp.put("data", jsonArray);
			resp.put("total", pagingData.getITotalRecords());
		}
		return JSON.toJSONString(resp);
	}
}
