package com.hms.model;
/**
 * <p>Title: PasswordModel.java</p>
 * <p>Description: </p>
 * @author silvasong Emial:silvasong@aliyun.com
 * @date 2015年4月5日 下午11:01:44
 * @version 1.0
 */
public class PasswordModel {
	
	private String password;
	
	private String newpassword;
	
	private String confirm_password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	
	

}
