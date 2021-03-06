package com.hms.dto;
// Generated 2015-1-11 18:26:37 by Hibernate Tools 4.0.0

/**
 * News generated by hbm2java
 */
public class News implements java.io.Serializable {

	private int newId;
	private String newTitle;
	private String newContent;
	private String newAuthor;
	private long newTime;
	private int newType;

	public News() {
	}

	public News(int newId, String newTitle, String newContent,
			String newAuthor, long newTime, int newType) {
		this.newId = newId;
		this.newTitle = newTitle;
		this.newContent = newContent;
		this.newAuthor = newAuthor;
		this.newTime = newTime;
		this.newType = newType;
	}

	public int getNewId() {
		return this.newId;
	}

	public void setNewId(int newId) {
		this.newId = newId;
	}

	public String getNewTitle() {
		return this.newTitle;
	}

	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}

	public String getNewContent() {
		return this.newContent;
	}

	public void setNewContent(String newContent) {
		this.newContent = newContent;
	}

	public String getNewAuthor() {
		return this.newAuthor;
	}

	public void setNewAuthor(String newAuthor) {
		this.newAuthor = newAuthor;
	}

	public long getNewTime() {
		return this.newTime;
	}

	public void setNewTime(long newTime) {
		this.newTime = newTime;
	}

	public int getNewType() {
		return this.newType;
	}

	public void setNewType(int newType) {
		this.newType = newType;
	}

}
