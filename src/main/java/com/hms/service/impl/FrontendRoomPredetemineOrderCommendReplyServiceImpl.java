package com.hms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dao.FrontendRoomPredetemineOrderCommendReplyDao;
import com.hms.dto.CommentReply;
import com.hms.service.FrontendRoomPredetemineOrderCommendReplyService;

/**
 * <p>Title: FrontendRoomPredetemineOrderCommendReplyServiceImpl.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月8日 下午9:54:40
 * @version 1.0
 */
@Service
public class FrontendRoomPredetemineOrderCommendReplyServiceImpl implements FrontendRoomPredetemineOrderCommendReplyService{
    
	@Autowired
	private FrontendRoomPredetemineOrderCommendReplyDao frontendRoomPredetemineOrderCommendReplyDao;
	
	public CommentReply getcCommentReplyByCommendId(int id) {
		// TODO Auto-generated method stub
		return frontendRoomPredetemineOrderCommendReplyDao.findUnique("commendId", id);
	}
	
	

}
