package com.hms.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hms.common.SystemConstant;
import com.hms.dto.Setting;
import com.hms.service.SettingService;

/**
 * <p>Title: CommonController.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年1月28日 下午8:10:40
 * @version 1.0
 */
@Controller
@RequestMapping(value="frontend/common")
public class FrontendCommonController extends BaseController{
	
	@Autowired
	private SettingService settingService;
	
	@RequestMapping(value="head",method=RequestMethod.GET)
	public ModelAndView head(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		Setting setting = settingService.getSettingByKey(SystemConstant.INDEX_PHONE);
		if(setting != null){
			mav.addObject("phone", setting.getValue());
		}
		setting = settingService.getSettingByKey(SystemConstant.INDEX_EMAIL);
		if(setting != null){
			mav.addObject("email", setting.getValue());
		}
		mav.setViewName("frontend/common/head");
		return mav;
	}
	
	@RequestMapping(value="footer",method=RequestMethod.GET)
	public ModelAndView footer(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("frontend/common/footer");
		return mav;
	}
	
	@RequestMapping(value="page_slider",method=RequestMethod.GET)
	public ModelAndView pageSlider(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		Setting setting = settingService.getSettingByKey(SystemConstant.INDEX_BG);
		if(setting != null && !setting.getValue().isEmpty()){
			    List<String> img = new ArrayList<String>();
				String []strs = setting.getValue().substring(0, setting.getValue().length()-1).split("#");
				for(String s : strs){
					img.add("upload/admin/setting/index_bg/"+s);
				}
				mav.addObject("img", img);
		}
		mav.setViewName("frontend/common/page_slider");
		return mav;
	}
	

}
