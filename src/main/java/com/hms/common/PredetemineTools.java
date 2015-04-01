package com.hms.common;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.hms.dto.RoomType;
import com.hms.service.FrontendRoomPredetermineService;

/**
 * <p>Title: PredetemineTools.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月1日 下午3:54:55
 * @version 1.0
 */
public class PredetemineTools {
	
	@Autowired
	private FrontendRoomPredetermineService frontendRoomPredetermineService;
	
	public void getRoomTypeStatic(long checkInTime,long checkOutTime){
		
		List<RoomType> roomTypes = frontendRoomPredetermineService.loadAllRoomTypes();
		Map <Integer,Integer> roomTypeStatic = new LinkedHashMap<Integer, Integer>();
		if(roomTypes != null){
			for(RoomType roomType : roomTypes){
				roomTypeStatic.put(roomType.getId(), 1);
			}
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String inString = "2015-04-01";
		String outString = "2015-04-05";
		try {
			long today = sf.parse(sf.format(new Date())).getTime();
			long in = sf.parse(inString).getTime();
			long out = sf.parse(outString).getTime();
			
		    int day = (int) ((out-in)/86400000);
		    for(int i=0;i<day;i++){
		    	long time = in + i*86400000;
		    	if(time == today){
		    		
		    	}else{
		    		
		    	}
		    }
			System.out.println(day);
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
