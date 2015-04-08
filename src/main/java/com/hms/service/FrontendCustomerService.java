package com.hms.service;

import com.hms.dto.Customer;

/**
 * <p>Title: FrontendCustomerService.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年3月29日 下午5:39:50
 * @version 1.0
 */
public interface FrontendCustomerService {
	
	public void createCustomer(Customer customer);
	
	public Customer getCustomerByIdcard(String id_card);
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(Customer customer);

}
