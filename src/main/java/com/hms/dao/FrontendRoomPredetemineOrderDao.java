package com.hms.dao;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hms.dao.base.BaseDao;
import com.hms.dto.Predetemine;
import com.hms.dto.Registration;

/**
 * <p>Title: FrontendRoomPredetemineOrderDao.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月1日 下午3:06:27
 * @version 1.0
 */
@Repository
public class FrontendRoomPredetemineOrderDao extends BaseDao<Predetemine>{
	
	public Map<Integer, Integer> getTimePredetemineOrderStatic(long time) {
		Map<Integer, Integer> roomTypeStatic = new LinkedHashMap<Integer, Integer>();
		String hql = "from Predetemine as pre where "+time+">= pre.checkInTime and pre.checkOutTime <="+time+
				" and pre.status=2";
		Query query = this.currentSession().createQuery(hql);
		List list = query.list();
	    Iterator iterator=list.iterator();
	     while(iterator.hasNext()){
	    	 Predetemine predetemine = (Predetemine) iterator.next();
	    	 if(roomTypeStatic.get(predetemine.getRoomType()) != null){
	    		 int value = roomTypeStatic.get(predetemine.getRoomType())+1;
	    		 roomTypeStatic.put(predetemine.getRoomType(), value);
	    	 }else{
	    		 roomTypeStatic.put(predetemine.getRoomType(), 1);
	    	 }
	     }
		return roomTypeStatic;
	}

}
