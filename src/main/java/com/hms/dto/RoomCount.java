package com.hms.dto;
// Generated 2015-1-11 18:26:37 by Hibernate Tools 4.0.0

/**
 * RoomCount generated by hbm2java
 */
public class RoomCount implements java.io.Serializable {

	private String time;
	private int roomType;
	private int sum;
	private int predetermine;
	private int surplus;

	public RoomCount() {
	}

	public RoomCount(String time, int roomType, int sum, int predetermine,
			int surplus) {
		this.time = time;
		this.roomType = roomType;
		this.sum = sum;
		this.predetermine = predetermine;
		this.surplus = surplus;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getRoomType() {
		return this.roomType;
	}

	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}

	public int getSum() {
		return this.sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getPredetermine() {
		return this.predetermine;
	}

	public void setPredetermine(int predetermine) {
		this.predetermine = predetermine;
	}

	public int getSurplus() {
		return this.surplus;
	}

	public void setSurplus(int surplus) {
		this.surplus = surplus;
	}

}