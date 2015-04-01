package com.hms.dao;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;








import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hms.dao.base.BaseDao;
import com.hms.dto.Registration;

/**
 * <p>Title: AdminRegistrationDao.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月1日 下午5:12:28
 * @version 1.0
 */
@Repository
public class AdminRegistrationDao extends BaseDao<Registration>{
	
	public Map<Integer, Integer> getTimeRegistrationStatic(long time) {
		Map<Integer, Integer> roomTypeStatic = new LinkedHashMap<Integer, Integer>();
		String hql = "from Registration as reg where "+time+">= reg.checkInTime and reg.checkOutTime <="+time+
				" and reg.status=1";
		Query query = this.currentSession().createQuery(hql);
		List list = query.list();
	    Iterator iterator=list.iterator();
	     while(iterator.hasNext()){
	    	 Registration registration = (Registration) iterator.next();
	    	 if(roomTypeStatic.get(registration.getRoomType()) != null){
	    		 int value = roomTypeStatic.get(registration.getRoomType())+1;
	    		 roomTypeStatic.put(registration.getRoomType(), value);
	    	 }else{
	    		 roomTypeStatic.put(registration.getRoomType(), 1);
	    	 }
	     }
		return roomTypeStatic;
	}
	

}
