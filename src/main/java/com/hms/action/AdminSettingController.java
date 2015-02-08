package com.hms.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hms.common.SystemConstant;
import com.hms.common.UUIDTools;
import com.hms.dto.Setting;
import com.hms.service.SettingService;
import com.mysql.fabric.xmlrpc.base.Array;

/**
 * <p>Title: AdminSettingController.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年2月7日 下午9:10:30
 * @version 1.0
 */
@Controller
@RequestMapping(value="/admin/setting")
public class AdminSettingController {
	
	@Autowired
	private SettingService settingService;
	
	@RequestMapping(value="index_setting",method=RequestMethod.GET)
	public ModelAndView indexSetting(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		Setting t = settingService.getSettingByKey(SystemConstant.INDEX_BG);
		Map <String,String> bg = null;
		if(t != null){
			if(!t.getValue().isEmpty()){
				String strs []= t.getValue().substring(0, t.getValue().length()-1).split("#");
				bg = new LinkedHashMap<String, String>();
				for(String str :strs){
					bg.put(str, "../../upload"+"/"+"admin"+"/"+"setting"+"/"+"index_bg"+"/"+str);
				}
			}
			
		}
		mav.addObject("bg",bg);
		mav.setViewName("admin/setting/index_setting");
		return mav;
	}
	
    @RequestMapping(value="index_setting_uploadImages",method=RequestMethod.POST)
    @ResponseBody
    public String uploadImages(HttpServletRequest request,@RequestParam("file")MultipartFile file)
    {
		JSONObject resp = new JSONObject();
		try {
			String realPath = request.getSession().getServletContext().getRealPath("/");
			String imgName = UUIDTools.getUUIDString().substring(0, 10)+".jpg";
			File image = null;
			image = new File(realPath,SystemConstant.INDEX_BG_PATH+imgName);
			if(image.exists()){
				image.delete();
			}
			FileUtils.copyInputStreamToFile(file.getInputStream(), image);
			Setting t = settingService.getSettingByKey(SystemConstant.INDEX_BG);
			if(t == null){
				t = new Setting();
				t.setName(SystemConstant.INDEX_BG);
				t.setValue(imgName+"#");
				settingService.saveSetting(t);
			}else{
				t.setValue(t.getValue()+imgName+"#");
				settingService.updateSetting(t);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			resp.put("result", "NO");
			e.printStackTrace();
		}
		
    	
    	resp.put("result", "OK");
    	return JSON.toJSONString(resp);
    	
    }
    
    @RequestMapping(value="index_setting_removeImage",method=RequestMethod.POST)
    @ResponseBody
    public String removeImage(HttpServletRequest request,@RequestParam("value")String value){
    	JSONObject resp = new JSONObject();
    	
    	try{
    		Setting setting = settingService.getSettingByKey(SystemConstant.INDEX_BG);
        	String realPath = request.getSession().getServletContext().getRealPath("/");
        	if(setting !=null){
        		
        		setting.setValue(setting.getValue().replace(value+"#", ""));
        		settingService.updateSetting(setting);
        	}
        	File image = new File(realPath,SystemConstant.INDEX_BG_PATH+value);
        	if(image.exists()){
        		image.delete();
        	}
        	resp.put("status", true);
    	}catch(Exception e){
    		resp.put("status", false);
    		e.printStackTrace();
    	}
    	return JSON.toJSONString(resp);
    }

}
