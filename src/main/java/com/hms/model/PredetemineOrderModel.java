package com.hms.model;
/**
 * <p>Title: PredetemineOrderModel.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月8日 下午12:48:41
 * @version 1.0
 */
public class PredetemineOrderModel {
	
	private String predetermineId;
	
	private String presetTime;
	
	private String roomType;
	
	private String customerIdCard;
	
	private String checkInTime;
	
	private String checkOutTime;
	
	private int status;

	public String getPredetermineId() {
		return predetermineId;
	}

	public void setPredetermineId(String predetermineId) {
		this.predetermineId = predetermineId;
	}

	public String getPresetTime() {
		return presetTime;
	}

	public void setPresetTime(String presetTime) {
		this.presetTime = presetTime;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getCustomerIdCard() {
		return customerIdCard;
	}

	public void setCustomerIdCard(String customerIdCard) {
		this.customerIdCard = customerIdCard;
	}

	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
