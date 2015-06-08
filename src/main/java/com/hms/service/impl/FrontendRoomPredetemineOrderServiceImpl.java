package com.hms.service.impl;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dao.FrontendRoomPredetemineOrderDao;
import com.hms.dto.Predetemine;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;
import com.hms.service.FrontendRoomPredetemineOrderService;

/**
 * <p>Title: FrontendRoomPredeteOrderServiceImpl.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月1日 下午3:02:50
 * @version 1.0
 */
@Service
public class FrontendRoomPredetemineOrderServiceImpl implements FrontendRoomPredetemineOrderService{
    
	@Autowired
	private FrontendRoomPredetemineOrderDao frontendRoomPredetemineOrderDao;
	
	public void createPredetemineOrder(Predetemine p) {
		// TODO Auto-generated method stub
		frontendRoomPredetemineOrderDao.sava(p);
	}

	public PagingData predetemineOrderList(DataTableParamer dtp,String id_card) {
		// TODO Auto-generated method stub
		return frontendRoomPredetemineOrderDao.findPage(new Criterion[]{Restrictions.eq("status", dtp.getIstatic()),Restrictions.eq("idCard", id_card)}, dtp.getiDisplayStart(), dtp.getiDisplayLength());
	}

	public Predetemine getPredetemineById(String id) {
		// TODO Auto-generated method stub
		return frontendRoomPredetemineOrderDao.get(id);
	}

	public void updatePredete(Predetemine p) {
		// TODO Auto-generated method stub
		frontendRoomPredetemineOrderDao.update(p);
	}

}
