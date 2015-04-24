package com.hms.action;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;










import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hms.dto.PredetermineCommend;
import com.hms.service.AdminPredetemineOrderCommendService;

/**
 * <p>Title: DashbordController.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年1月28日 下午8:18:01
 * @version 1.0
 */
@Controller
@RequestMapping(value="admin/dashbord")
public class AdminDashbordController extends BaseController{
	
	@Autowired
	private AdminPredetemineOrderCommendService adminPredetemineOrderCommendService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView dashbord(HttpServletRequest request){
		ModelAndView mav =new ModelAndView();
		mav.setViewName("admin/dashbord/dashbord");
		return mav;
	}
	
	@RequestMapping(value="chartData",method=RequestMethod.GET)
	@ResponseBody
	public String chartData(HttpServletRequest request){
		JSONObject resp = new JSONObject();
		JSONObject object = null;
		JSONArray jsonArray = null;
		Map<Float, Integer> data1 = new LinkedHashMap<Float, Integer>();
		Map<Float, Integer> data2 = new LinkedHashMap<Float, Integer>();
		Map<Float, Integer> data3 = new LinkedHashMap<Float, Integer>();
		List<PredetermineCommend> list = adminPredetemineOrderCommendService.loadAllCommends();
		for(PredetermineCommend pc : list){
			if(data1.get(pc.getScore1())==null){
			   data1.put(pc.getScore1(), 1);
			}else{
			   int i = data1.get(pc.getScore1())+1;
			   data1.put(pc.getScore1(), i);
			}
			if(data2.get(pc.getScore2())==null){
				   data2.put(pc.getScore2(), 1);
				}else{
				   int j = data2.get(pc.getScore2())+1;
				   data2.put(pc.getScore1(), j);
			}
			if(data3.get(pc.getScore3())==null){
				   data3.put(pc.getScore3(), 1);
				}else{
				   int k = data3.get(pc.getScore3())+1;
				   data3.put(pc.getScore3(), k);
			}
		}
		for(Float f:data1.keySet()){
			object = new JSONObject();
			object.put("score", f+"");
			object.put("count", data1.get(f));
			jsonArray = new JSONArray();
			jsonArray.add(object);
		}
		resp.put("data1", jsonArray);
		for(Float f:data2.keySet()){
			object = new JSONObject();
			object.put("score", f+"");
			object.put("count", data2.get(f));
			jsonArray = new JSONArray();
			jsonArray.add(object);
		}
		resp.put("data2", jsonArray);
		for(Float f:data3.keySet()){
			object = new JSONObject();
			object.put("score", f+"");
			object.put("count", data3.get(f));
			jsonArray = new JSONArray();
			jsonArray.add(object);
		}
		resp.put("data3", jsonArray);
		return JSON.toJSONString(resp);
	}

}
