package com.hms.service;

import javax.sound.midi.VoiceStatus;

import com.hms.dto.CommentReply;

/**
 * <p>Title: AdminPredetemineOrderCommendReplyService.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月10日 下午10:19:43
 * @version 1.0
 */
public interface AdminPredetemineOrderCommendReplyService {
	
	public CommentReply getcCommentReplybyCommendId(int id);
	
	public void createCommentRely(CommentReply reply);
	
	public void updateCommentRely(CommentReply reply);

}
