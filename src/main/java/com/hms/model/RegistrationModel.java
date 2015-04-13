package com.hms.model;
/**
 * <p>Title: RegistrationModel.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月13日 下午9:58:23
 * @version 1.0
 */
public class RegistrationModel {
	
	private String id;
	
	private int roomId;
	
	private String checkInTime;
	
	private String checkOutTime;
	
	private String customer;
	
	private int cost;
	
	private int margin;
	
	private String checkInAdmin;
	
	private String checkOutAdmin;
	
	private int status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
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

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getMargin() {
		return margin;
	}

	public void setMargin(int margin) {
		this.margin = margin;
	}

	public String getCheckInAdmin() {
		return checkInAdmin;
	}

	public void setCheckInAdmin(String checkInAdmin) {
		this.checkInAdmin = checkInAdmin;
	}

	public String getCheckOutAdmin() {
		return checkOutAdmin;
	}

	public void setCheckOutAdmin(String checkOutAdmin) {
		this.checkOutAdmin = checkOutAdmin;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
