package com.hms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dao.FrontendCustomerDao;
import com.hms.dto.Customer;
import com.hms.service.FrontendCustomerService;

/**
 * <p>Title: FrontendCustomerServiceImpl.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年3月29日 下午5:41:10
 * @version 1.0
 */
@Service
public class FrontendCustomerServiceImpl implements FrontendCustomerService{
    
	@Autowired
	private FrontendCustomerDao frontendCustomerDao;
	
	public void createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		frontendCustomerDao.sava(customer);
	}

	public Customer getCustomerByIdcard(String id_card) {
		// TODO Auto-generated method stub
		return frontendCustomerDao.findUnique("idCard", id_card);
	}

	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		frontendCustomerDao.update(customer);
	}

	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		frontendCustomerDao.delete(customer);
	}
	
	

}
