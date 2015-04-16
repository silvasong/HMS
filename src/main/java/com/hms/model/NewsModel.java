package com.hms.model;
/**
 * <p>Title: NewsModel.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月16日 下午1:44:52
 * @version 1.0
 */
public class NewsModel {
	
	private int id;
	
	private String newTitle;
	
	private String newContent;
	
	private String newAuthor;
	
	private String newTime;
	
	private String newType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNewTitle() {
		return newTitle;
	}

	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}

	public String getNewContent() {
		return newContent;
	}

	public void setNewContent(String newContent) {
		this.newContent = newContent;
	}

	public String getNewAuthor() {
		return newAuthor;
	}

	public void setNewAuthor(String newAuthor) {
		this.newAuthor = newAuthor;
	}

	public String getNewTime() {
		return newTime;
	}

	public void setNewTime(String newTime) {
		this.newTime = newTime;
	}

	public String getNewType() {
		return newType;
	}

	public void setNewType(String newType) {
		this.newType = newType;
	}
	
	

}
