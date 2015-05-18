package com.hms.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.hms.dao.AdminPredetemineOrderDao;
import com.hms.dto.News;
import com.hms.dto.Predetemine;
import com.hms.model.DataTableParamer;
import com.hms.model.PagingData;
import com.hms.service.AdminPredetemineOrderService;

/**
 * <p>Title: AdminPredetemineOrderServiceImpl.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月10日 下午2:10:34
 * @version 1.0
 */
@Service
public class AdminPredetemineOrderServiceImpl implements AdminPredetemineOrderService{
    
	@Autowired
	private AdminPredetemineOrderDao adminPredetemineOrderDao;
	
	public PagingData loadPredetemineOrderPagingData(DataTableParamer dtp) {
		// TODO Auto-generated method stub
		String searchStr = dtp.getsSearch();
		Criterion [] criterions= null;
		if(searchStr != null && ! searchStr.isEmpty()){
			JSONObject jsonObject = JSONObject.parseObject(searchStr);
			int value= jsonObject.getIntValue("status");
			if(value != 4){
				criterions = new Criterion[1];
				criterions[0] = Restrictions.eq("status", value);
			}else{
				criterions = new Criterion[2];
				
				criterions[0] = Restrictions.eq("status", value);
				criterions[1] = Restrictions.eq("status", 5);
				
				return adminPredetemineOrderDao.findPage(Restrictions.or(criterions), dtp.getiDisplayStart(), dtp.getiDisplayLength());
			}
			return adminPredetemineOrderDao.findPage(criterions, dtp.getiDisplayStart(), dtp.getiDisplayLength());
		}
		criterions = new Criterion[1];
		criterions[0] = Restrictions.eq("status", 0);
		return adminPredetemineOrderDao.findPage(criterions,dtp.getiDisplayStart(), dtp.getiDisplayLength());
		
		
	}

	public Predetemine getPredetemineOrderById(String id) {
		// TODO Auto-generated method stub
		return adminPredetemineOrderDao.get(id);
	}

	public void updatePredetemineOrder(Predetemine predetemine) {
		// TODO Auto-generated method stub
		adminPredetemineOrderDao.update(predetemine);
	}

	public List<Predetemine> loadPredetemineOrderToday(long today) {
		// TODO Auto-generated method stub
		return adminPredetemineOrderDao.findBy("checkInTime", today);
	}

	public void cancelLimit() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
     	
		try {
			System.out.println(sdf.parse(sdf.format(new Date())).getTime());
			List <Predetemine> pList = adminPredetemineOrderDao.findBy("checkInTime", sdf.parse(sdf.format(new Date())).getTime());
			for(Predetemine p : pList){
				if(p.getStatus()==2){
					p.setStatus(1);
				}
				adminPredetemineOrderDao.update(p);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
