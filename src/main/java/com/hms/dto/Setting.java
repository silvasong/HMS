package com.hms.dto;
// Generated 2015-1-11 18:26:37 by Hibernate Tools 4.0.0

/**
 * NewType generated by hbm2java
 */
public class Setting implements java.io.Serializable {

	private int id;
	private String name;
	private String value;

	public Setting() {
	}

	public Setting(int id, String name, String value) {
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}