package com.hms.dto;
// Generated 2015-1-11 18:26:37 by Hibernate Tools 4.0.0

/**
 * Room generated by hbm2java
 */
public class Room implements java.io.Serializable {

	private int roomId;
	private int roomType;
	private int status;

	public Room() {
	}

	public Room(int roomId, int roomType, int status) {
		this.roomId = roomId;
		this.roomType = roomType;
		this.status = status;
	}

	public int getRoomId() {
		return this.roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getRoomType() {
		return this.roomType;
	}

	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
