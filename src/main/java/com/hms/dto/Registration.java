package com.hms.dto;
// Generated 2015-1-11 18:26:37 by Hibernate Tools 4.0.0

/**
 * Registration generated by hbm2java
 */
public class Registration implements java.io.Serializable {

	private String id;
	private int roomId;
	private String checkInTime;
	private String checkOutTime;
	private String customerIdCard;
	private String customerName;
	private String predetermineId;
	private int day;
	private int cost;
	private int margin;
	private int checkInAdmin;
	private int checkOutAdmin;
	private int status;

	public Registration() {
	}

	public Registration(String id, int roomId, String checkInTime,
			String checkOutTime, String customerIdCard, String customerName,
			String predetermineId, int day, int cost, int margin,
			int checkInAdmin, int checkOutAdmin, int status) {
		this.id = id;
		this.roomId = roomId;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.customerIdCard = customerIdCard;
		this.customerName = customerName;
		this.predetermineId = predetermineId;
		this.day = day;
		this.cost = cost;
		this.margin = margin;
		this.checkInAdmin = checkInAdmin;
		this.checkOutAdmin = checkOutAdmin;
		this.status = status;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRoomId() {
		return this.roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getCheckInTime() {
		return this.checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getCheckOutTime() {
		return this.checkOutTime;
	}

	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public String getCustomerIdCard() {
		return this.customerIdCard;
	}

	public void setCustomerIdCard(String customerIdCard) {
		this.customerIdCard = customerIdCard;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPredetermineId() {
		return this.predetermineId;
	}

	public void setPredetermineId(String predetermineId) {
		this.predetermineId = predetermineId;
	}

	public int getDay() {
		return this.day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getCost() {
		return this.cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getMargin() {
		return this.margin;
	}

	public void setMargin(int margin) {
		this.margin = margin;
	}

	public int getCheckInAdmin() {
		return this.checkInAdmin;
	}

	public void setCheckInAdmin(int checkInAdmin) {
		this.checkInAdmin = checkInAdmin;
	}

	public int getCheckOutAdmin() {
		return this.checkOutAdmin;
	}

	public void setCheckOutAdmin(int checkOutAdmin) {
		this.checkOutAdmin = checkOutAdmin;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}