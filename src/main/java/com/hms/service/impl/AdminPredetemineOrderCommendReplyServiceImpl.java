package com.hms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dao.AdminPredetemineOrderCommendReplyDao;
import com.hms.dto.CommentReply;
import com.hms.service.AdminPredetemineOrderCommendReplyService;

/**
 * <p>Title: AdminPredetemineOrderCommendReplyServiceImpl.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月10日 下午10:24:25
 * @version 1.0
 */
@Service
public class AdminPredetemineOrderCommendReplyServiceImpl implements AdminPredetemineOrderCommendReplyService{
    
	@Autowired
	private AdminPredetemineOrderCommendReplyDao adminPredetemineOrderCommendReplyDao;
	
	public CommentReply getcCommentReplybyCommendId(int id) {
		// TODO Auto-generated method stub
		return adminPredetemineOrderCommendReplyDao.findUnique("commendId", id);
	}

	public void createCommentRely(CommentReply reply) {
		// TODO Auto-generated method stub
		adminPredetemineOrderCommendReplyDao.sava(reply);
	}

	public void updateCommentRely(CommentReply reply) {
		// TODO Auto-generated method stub
		adminPredetemineOrderCommendReplyDao.update(reply);
		
	}

}
