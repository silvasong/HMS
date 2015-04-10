package com.hms.model;
/**
 * <p>Title: PredetemineCommendModel.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月10日 下午10:27:18
 * @version 1.0
 */
public class PredetemineCommendModel {
	
	private int commendId;
	private String predetermineId;
	private String commendContend;
	private float score1;
	private float score2;
	private float score3;
	private String replyContent;
	private String adminName;
	public int getCommendId() {
		return commendId;
	}
	public void setCommendId(int commendId) {
		this.commendId = commendId;
	}
	public String getPredetermineId() {
		return predetermineId;
	}
	public void setPredetermineId(String predetermineId) {
		this.predetermineId = predetermineId;
	}
	public String getCommendContend() {
		return commendContend;
	}
	public void setCommendContend(String commendContend) {
		this.commendContend = commendContend;
	}
	public float getScore1() {
		return score1;
	}
	public void setScore1(float score1) {
		this.score1 = score1;
	}
	public float getScore2() {
		return score2;
	}
	public void setScore2(float score2) {
		this.score2 = score2;
	}
	public float getScore3() {
		return score3;
	}
	public void setScore3(float score3) {
		this.score3 = score3;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
}
