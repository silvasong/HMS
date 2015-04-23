package com.hms.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dao.AdminRegistrationDao;
import com.hms.dao.AdminRoomDao;
import com.hms.dao.FrontendRoomPredetemineDao;
import com.hms.dao.FrontendRoomPredetemineOrderDao;
import com.hms.dto.Room;
import com.hms.dto.RoomType;
import com.hms.service.FrontendRoomPredetermineService;

/**
 * <p>Title: FrontendRoomPredetemineServiceImpl.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月1日 下午2:55:36
 * @version 1.0
 */
@Service
public class FrontendRoomPredetemineServiceImpl implements FrontendRoomPredetermineService{
    
	@Autowired
	private AdminRoomDao adminRoomDao;
	
    @Autowired
	private FrontendRoomPredetemineDao frontendRoomPredetemineDao;
	
	@Autowired
	private FrontendRoomPredetemineOrderDao frontendRoomPredetemineOrderDao;
	
	@Autowired
	private AdminRegistrationDao adminRegistrationDao;
	
	public List<RoomType> loadAllRoomTypes() {
		// TODO Auto-generated method stub
		return frontendRoomPredetemineDao.loadAll();
	}

	public Map<Integer, Integer> getRoomTypeStatic(long checkInTime,long checkOutTime) {
		// TODO Auto-generated method stub
		
		List<RoomType> roomTypes = loadAllRoomTypes();
		List<Room> rooms = adminRoomDao.loadAll();
		Map <Integer,Integer> roomTypeStatic = new LinkedHashMap<Integer, Integer>();
		Map <Integer,Integer> roomTypeCount = new LinkedHashMap<Integer, Integer>();
		if(roomTypes != null){
			for(RoomType roomType : roomTypes){
				roomTypeStatic.put(roomType.getId(), 1);
				roomTypeCount.put(roomType.getId(), 0);
			}
		}
		
		if(rooms != null){
			for(Room room : rooms){
				int value = roomTypeCount.get(room.getRoomType().getId())+1;
				roomTypeCount.put(room.getRoomType().getId(), value);
			}
		}
		
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		//String inString = "2015-04-01";
		//String outString = "2015-04-05";
		try {
			long today = sf.parse(sf.format(new Date())).getTime();
		//	long in = sf.parse(inString).getTime();
		//	long out = sf.parse(outString).getTime();
			long in = checkInTime;
			long out = checkOutTime;
		    int day = (int) ((out-in)/86400000);
		    for(int i=0;i<day;i++){
		    	long time = in + i*86400000;
		    	Map<Integer,Integer> predetemine=frontendRoomPredetemineOrderDao.getTimePredetemineOrderStatic(time);
		    	Map<Integer,Integer> registration=adminRegistrationDao.getTimeRegistrationStatic(time);
		    	for(RoomType roomType : roomTypes){
		    		int count = roomTypeCount.get(roomType.getId());
		    		int use = 0;
		    		if(predetemine.get(roomType.getId()) != null){
		    			use += predetemine.get(roomType.getId());
		    		}
		    		if(registration.get(roomType.getId()) != null){
		    			use += registration.get(roomType.getId());
		    		}
		    		if(use>=count){
		    			roomTypeStatic.put(roomType.getId(), 0);
		    		}
		    		
		    	}
		    	
		    }
			
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return roomTypeStatic;
	}

}
